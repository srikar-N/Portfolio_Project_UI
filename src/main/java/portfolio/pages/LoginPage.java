package portfolio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
	public ProductPage productpage;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id = "username")
	WebElement username;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(id = "terms")
	WebElement termsCheckbox;
	@FindBy(id = "signInBtn")
	public
	WebElement signInButton;
	@FindBy(css="input[value='user']")
	WebElement radioButton;
	@FindBy(css ="div select")
	WebElement dropdown;
	@FindBy(id="myModal")
	WebElement alert;
	
	
	
	
	By errorMessage = By.cssSelector("div.alert-danger");
	By okayButton = By.id("okayBtn");
	
	public ProductPage login_as_admin(String name,String Pass) {
		send_data(username,name);
		send_data(password,Pass);
		click_on_element(signInButton);
		return new ProductPage(driver);
	}
	
	public void login(String name,String Pass) {
		send_data(username,name);
		send_data(password,Pass);
	}

	
	
	public void login_as_user(String name,String Pass,String value) {
		send_data(username,name);
		send_data(password,Pass);
		click_on_element(radioButton);
		wait_for_element_to_appear(okayButton);
		click_on_element(driver.findElement(okayButton));
		wait_for_element_to_disappear(alert);
		select_from_dropdown(dropdown,value);
		click_on_element(termsCheckbox);
		click_on_element(signInButton);
	}
	
	public String validate_error(String name,String Pass,String value) {
		login_as_user(name, Pass,value);
		wait_for_element_to_appear(errorMessage);
		return get_text(driver.findElement(errorMessage));
		
	}
	
	
	
	public void goTo(String url) {
		driver.get(url);
	}
	
	

}
