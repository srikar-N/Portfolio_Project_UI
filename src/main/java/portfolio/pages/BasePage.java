package portfolio.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
WebDriver driver ;
public WebDriverWait wait; 
Select select ;

public BasePage(WebDriver driver) {
	this.driver = driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
}
	
	public void get_title() {
		System.out.println(driver.getTitle());
	}
	
	public void wait_for_element_to_appear(By ele) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
		
	}
	public void wait_for_element_to_disappear(WebElement ele) {
		wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	public void wait_for_url_change(String url) {
		wait.until(ExpectedConditions.urlMatches(url));
		
	}
	
	public void send_data(WebElement ele,String data) {
		ele.sendKeys(data);
	}
	
	public void click_on_element(WebElement ele) {
		try {
	        // 3. Try standard click
	        ele.click();
	    } catch (Exception e) {
	        // 4. Fallback to JavaScript click if UI is still being difficult in headless
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ele);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
	    }
		
	}
	public String get_text(WebElement ele) {
		return ele.getText();
	}
	
	public void select_from_dropdown(WebElement ele,String value) {
		select = new Select(ele);
		select.selectByVisibleText(value);
		
		
	}
	

	
	
	
	

}
