package com.kase.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyTestEx {

	private WebDriver driver;

	@Test(testName = "test11")
	public void test1() {

		// Launch website
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");

		String sampleText = driver.findElement(By.className("col-md-12")).getText();

		// click() method
		// driver.findElement(By.linkText("This is a link")).click();
		// driver.navigate().back();

		// Click on the textbox and send value
		driver.findElement(By.id("fname")).sendKeys("JavaTpoint");

		// Clear the text written in the textbox
		// sdriver.findElement(By.id("fname")).clear();

		// Click on the Submit button using click() command
		driver.findElement(By.id("idOfButton")).click();

		// Locate the radio button by id and check it using click() function
		driver.findElement(By.id("male")).click();

		// Locate the checkbox by cssSelector and check it using click() function
		driver.findElement(By.cssSelector("input.Performance")).click();

		// Use Select class for selecting value from dropdown
		Select dropdown = new Select(driver.findElement(By.id("testingDropdown")));
		dropdown.selectByVisibleText("Performance Testing");

		Assert.assertEquals(sampleText, "This is sample webpage with dummy elements that will help you in learning selenium automation.");

	}

	@Test(testName = "test22")
	public void test2() {
		driver.navigate().to("https://www.testandquiz.com/selenium/testing.html");
		// getText() method
		String sampleText = driver.findElement(By.className("col-md-12")).getText();
		Assert.assertEquals(sampleText, "This is sample webpage with dummy elements that will help you in learning selenium automation.");
	}

	@BeforeClass
	public void init() {
		String OS = System.getProperty("os.name").toLowerCase();
		if(isWindows(OS)) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kaush\\CodeX\\Java\\chromedriver.exe");
		} else if(isUnix(OS)) {
			System.setProperty("webdriver.chrome.driver", "webdrivers/unix/chromedriver");
		} else if(isMac(OS)) {
			System.setProperty("webdriver.chrome.driver", "webdrivers/mac/chromedriver");
		} else {
			//Other OS
		}
		driver = new ChromeDriver();
	}

	@AfterClass
	public void endCall() {
		driver.close();
	}

	public static boolean isWindows(final String OS) {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac(final String OS) {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix(final String OS) {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );

	}

}
