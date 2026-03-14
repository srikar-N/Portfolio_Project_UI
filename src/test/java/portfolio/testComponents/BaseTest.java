package portfolio.testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
//import org.apache.commons.io.FileUtils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import portfolio.pages.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public Properties property;
	public LoginPage loginpage;
	
	public WebDriver get_browser() throws IOException {
		
		// getting data from Global properties file
		property = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/portfolio/resources/Global.properties");
		property.load(fis);
		
		String browser = System.getProperty("browser")!=null ? System.getProperty("browser"): property.getProperty("browser").trim();
		
		if(browser.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if (browser.contains("headless")) {
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
			}
			
			driver = new ChromeDriver(options);
			
			
		}else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
		
		
	}
	
	// Getting data from JSON
	public List<HashMap<String, String>> getJsonData(String FilePath) throws IOException {
		String jsonData = FileUtils.readFileToString( new File(FilePath),StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonData,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
	
public String getScreenshot(String testName,WebDriver driver) throws IOException {
	TakesScreenshot ts =(TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File destination = new File( System.getProperty("user.dir") +"//reports//"+ testName +".png");
	FileUtils.copyFile(source, destination);
	return System.getProperty("user.dir") + "//reports//"+ testName +".png";
	
	
	
}
	
	
	@BeforeMethod(alwaysRun = true)
	public LoginPage setup() throws IOException {
		driver = get_browser();
		String url = property.getProperty("url");
		loginpage = new LoginPage(driver);
		loginpage.goTo(url);
		return loginpage;
		
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void Teardown() {
		driver.quit();
	}

}
