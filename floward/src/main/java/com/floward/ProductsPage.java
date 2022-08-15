package com.floward;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class ProductsPage {



	WebDriver driver;
	WebDriverWait wait;
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}
	@Step("select category {0} step ....")
	public void selectCategory(String categoryName) {

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" +categoryName+" ']"))).click();



	}

	@Step("select product {0} step ....")
	public void selectProduct(String productName) {

		WebElement productLabel = driver.findElement(By.xpath("//*[text()=' "+productName+"']"));

		Actions action = new Actions(driver);

		action.moveToElement(productLabel).perform();

		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()=' "+productName+"']//following::div)[2]//button"))).click();


	}

	@Step("go to cart page step....")
	public void continueToCartPage() {


		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Continue ']"))).click();



	}
	@Step("select first product step ....")
	public String getFirstProduct() {
		
		wait.until(
				ExpectedConditions.numberOfElementsToBeMoreThan(By.className("product-name"), 1));
		String productName= "";

		
		
		while(true) {
			
			if (productName.isEmpty()) {
				try {
				productName	= driver.findElements(By.className("product-name")).get(0).getText();
				}catch(Exception e) {
					continue;
					
				}
				
				if (!productName.isEmpty()) break;
				
				
			}
		
		}
		
		return productName;
		


	}



}
