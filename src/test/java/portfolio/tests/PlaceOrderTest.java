package portfolio.tests;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import portfolio.pages.ConfirmCheckoutPage;
import portfolio.pages.ProductPage;
import portfolio.testComponents.BaseTest;

public class PlaceOrderTest extends BaseTest {

	@Test(dataProvider = "getDetails")
	public void Placeoder(Map<String, String> data) {
		ProductPage productpage = loginpage.login_as_admin(data.get("username"), data.get("password"));

		ConfirmCheckoutPage confirmcheckout = productpage.add_product(data.get("product1"));
		String product = productpage.get_text(driver.findElement(By.cssSelector("h4.media-heading")));
		Assert.assertTrue(product.equalsIgnoreCase(data.get("product1")));

		confirmcheckout.select_country(data.get("country"));

		String successMessage = productpage.get_text(driver.findElement(By.cssSelector("div.alert-success")));
		Assert.assertTrue(successMessage.contains("Thank you! Your order will be delivered in next few weeks"));

	}

	@DataProvider // Sending data via Hashmap
	public static Object[][] getDetails() {
		Map<String, String> data = new HashMap<String, String>();
		data.put("username", "rahulshettyacademy");
		data.put("password", "Learning@830$3mK2");
		data.put("product1", "iphone X");
		data.put("country", "india");

		return new Object[][] { { data } };
	}

}
