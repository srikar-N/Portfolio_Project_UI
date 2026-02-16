package portfolio.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmCheckoutPage extends BasePage {

	public ConfirmCheckoutPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div.suggestions li a")
	List<WebElement> countries;
	@FindBy(css = "button.btn-success")
	WebElement confirmCheckout;


	@FindBy(css = "label[for='checkbox2']")
	WebElement checkbox;
	@FindBy(css = "input.btn-success")
	WebElement purchaseButton;
	By suggestCountries = By.cssSelector("div.suggestions li a");
	
	
	public void select_country(String nation) {
		click_on_element(confirmCheckout);
		driver.findElement(By.cssSelector(".filter-input")).sendKeys(nation);
		wait_for_element_to_appear(suggestCountries);
		for (WebElement country : countries) {
			if (country.getText().equalsIgnoreCase(nation)) {
				country.click();
			}
		}
		click_on_element(checkbox);
		click_on_element(purchaseButton);

	}

}
