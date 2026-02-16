package portfolio.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {

	public ProductPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div.card")
	List<WebElement> products;
	@FindBy(css = "a.btn-primary")
	WebElement checkoutButton;

	

	



	public List<WebElement> getProducts() {
		return products;
	}

	public ConfirmCheckoutPage add_product(String prod) {

		for (WebElement product : getProducts()) {
			WebElement currentProdcut = product.findElement(By.cssSelector("h4.card-title"));
			if (currentProdcut.getText().equalsIgnoreCase(prod)) {
				product.findElement(By.cssSelector("button")).click();

			}

		}
		click_on_element(checkoutButton);
		
		return new ConfirmCheckoutPage(driver);

	}

	

}
