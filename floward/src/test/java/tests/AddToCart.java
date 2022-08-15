package tests;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.floward.CartPage;
import com.floward.HomePage;
import com.floward.ProductsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


@Listeners({TestAllureListener.class})
public class AddToCart extends TestBase {
	String countryName = "Kuwait";
	String categoryName="Plants";
	String productName = "";
	String ExpectedCartPage = "https://floward.com/en-kw/checkout/cart";
	HomePage homePage;
	CartPage cartPage;
	ProductsPage productsPage;


	@Test(description="verify add to cart flow")
	@Severity(SeverityLevel.CRITICAL)
	@Description("verify add to cart flow")

	public void checkAddToCart() throws InterruptedException {
		homePage = new HomePage(driver);
		homePage.selectCountry(countryName);
		productsPage= new ProductsPage(driver);
		productsPage.selectCategory(categoryName);

		productName = productsPage.getFirstProduct();

		productsPage.selectProduct(productName);

		productsPage.continueToCartPage();
		String ActualCartPage= driver.getCurrentUrl();
		Assert.assertEquals(ActualCartPage, ExpectedCartPage);
		cartPage= new CartPage(driver);
		assertTrue(cartPage.isProductInCartPage(productName));






	}

}
