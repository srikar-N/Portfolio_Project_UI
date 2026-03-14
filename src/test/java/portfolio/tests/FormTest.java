package portfolio.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import portfolio.pages.FormPage;
import portfolio.pages.ProductPage;
import portfolio.testComponents.BaseTest;

public class FormTest extends BaseTest {
	String url = "https://rahulshettyacademy.com/angularpractice/";
	
	
	@Test(dataProvider="data")
	public void enterData(String username,String password) {
		ProductPage productpage = loginpage.login_as_admin(username,password);
		FormPage formpage = productpage.gotoFormPage(url);
//		formpage.enterData();

		
		
	}
	
	
	@DataProvider
	public Object[][] data() {
		return new Object[][] {{"rahulshettyacademy", "Learning@830$3mK2"}};
		
	}

}
