package stepImplementation;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import portfolio.pages.LoginPage;
import portfolio.pages.ProductPage;
import portfolio.testComponents.BaseTest;

public class StepImplefile extends BaseTest {
	
	public LoginPage loginpage;
	public ProductPage productpage;
	
	@Given("I am on the Login page")
	public void I_am_on_the_login_page() throws IOException {
		loginpage = setup();
		
	}
	
	@Given ("^Logged in with username (.+) and password (.+)$")
	public void Login_using_username_and_password(String username, String password) {
		loginpage.login(username,password);
	}
	
	@When("I Clicked on the Signin button")
	public void I_Clicked_on_the_Signin_button() {
		loginpage.click_on_element(loginpage.signInButton);
	}
	
	@Then ("^user should be taken to Prodcutpage url (.+)$")
	public void user_should_be_taken_to_Prodcutpage_url(String url) {
		loginpage.wait_for_url_change(url);
		Assert.assertTrue(driver.getCurrentUrl().equals(url));
		Teardown();
		
		
	}
	

}
