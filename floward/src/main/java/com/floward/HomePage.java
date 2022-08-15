package com.floward;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver,30 );
	}
@Step("select country {0} would you like to send a gift to....")
	public void selectCountry(String countryName) {

		wait.until(
				ExpectedConditions.elementToBeClickable(By.cssSelector("img[alt='"+countryName+"']"))).click();

	}




}
