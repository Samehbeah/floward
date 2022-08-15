package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {

	public WebDriver driver;
	String baseUrl = "https://floward.com/";

	@BeforeSuite
	public void setUpEnvironment()
	{

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.navigate().to(baseUrl);
		System.out.println(driver.getCurrentUrl());
	}
	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}

}
