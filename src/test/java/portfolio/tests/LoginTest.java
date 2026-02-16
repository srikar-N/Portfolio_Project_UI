package portfolio.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import portfolio.testComponents.BaseTest;

public class LoginTest extends BaseTest {
	public WebDriverWait wait;
	String url = "https://rahulshettyacademy.com/angularpractice/shop";

	@DataProvider // simple data provider method
	public static Object[][] validData() {
		return new Object[][] { { "rahulshettyacademy", "Learning@830$3mK2" } };
	}

	@DataProvider // Getting Data from a .json file
	public Object[][] invalidData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(
		System.getProperty("user.dir") + "/src/main/resources/portfolio/resources/invaidData.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

	@Test(dataProvider = "validData")
	public void validLogin(String username, String pass) {
		loginpage.login_as_user(username, pass,"Consultant");
		loginpage.wait_for_url_change(url);
		Assert.assertTrue(driver.getCurrentUrl().equals(url));

	}

	@Test(dataProvider = "invalidData",groups="IncorrectLogin")
	public void invalidLogin(HashMap<String, String> data) throws InterruptedException {
		String errorMessage = loginpage.validate_error(data.get("username"), data.get("password"),"Teacher");
		Assert.assertTrue("Incorrect username/password.".equals(errorMessage));

	}
}
