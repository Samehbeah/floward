package com.floward;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class CartPage {
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30 );
	}

	@Step("verifying the product is displayed in the cart page step....")
	public Boolean isProductInCartPage(String productName) {

		return !driver.findElements(By.xpath("//*[text()=' "+productName+" ']")).isEmpty();
		

	}

}
