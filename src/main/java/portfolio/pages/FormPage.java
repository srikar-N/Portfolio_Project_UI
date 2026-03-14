package portfolio.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormPage extends BasePage {

	public FormPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input.form-control[name = 'name']")
	WebElement nameField;
	@FindBy(css="input.form-control[name = 'name']")
	WebElement emailField;
	@FindBy(css="input.form-control[name = 'name']")
	WebElement passwordField;
	
	
	public void enterData(String name,String email,String pass,String gender,String employee,String DOB) {
		
		send_data(nameField,name);
		send_data(emailField,email);
		send_data(passwordField,pass);
		
	}
	
	

}
