package com.sddevops.DevOpsProject; 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NicTest {
	// declare Selenium WebDriver
	private WebDriver webDriver;

	@Test

	// shows all details of the users on dashboard
	public void checkTitle() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8080/DevOpsProject/ReviewServlet/dashboard");

		// Assert the title to check that we are indeed in the correct website
		Assert.assertEquals(webDriver.getTitle(), "Review Management");

		System.out.println("title: " + webDriver.getTitle());

		// Retrieve link using it's class name and click on it
		webDriver.findElement(By.className("btnbtnsuccess")).click();

		// Assert the new title to check that the title contain Wikipedia and the button
		// had successfully bring us to the new page
		Assert.assertTrue(webDriver.getTitle().contains("Add New Review"));
		System.out.println("new title: " + webDriver.getTitle());
	}

	@Test
	// add profile page form
	public void AddReview() {
		webDriver.navigate().to("http://localhost:8080/DevOpsProject/addReview.jsp");

		Assert.assertEquals(webDriver.getTitle(), "Add New Review");

		System.out.println("title: " + webDriver.getTitle());

		WebElement name = webDriver.findElement(By.xpath("/html/body/form/input[1]"));

		name.sendKeys("funny");

		WebElement password = webDriver.findElement(By.xpath("/html/body/form/input[2]"));

		password.sendKeys("eclipseTdest3");

		webDriver.findElement(By.className("submitReview")).click();
		webDriver.findElement(By.className("SuccessReview")).click();

		Assert.assertTrue(webDriver.getTitle().contains("Review Management"));
		System.out.println("new title: " + webDriver.getTitle());

	}

	@Test
	public void Edit() {
		webDriver.navigate().to("http://localhost:8080/DevOpsProject/ReviewServlet/dashboard");

		Assert.assertEquals(webDriver.getTitle(), "Review Management");

		System.out.println("title: " + webDriver.getTitle());

		webDriver.findElement(By.xpath("/html/body/div/div/table/tbody/tr/td[3]/a[1]")).click();

		WebElement name2 = webDriver.findElement(By.xpath("/html/body/div/div/div/form/fieldset[1]/input"));

		title2.sendKeys(Keys.chord(Keys.CONTROL, "a"), "aaaaaa");

		WebElement password2 = webDriver.findElement(By.xpath("/html/body/div/div/div/form/fieldset[2]/input"));

		password2.sendKeys(Keys.chord(Keys.CONTROL, "a"), "editpassw2o3rd3");

		webDriver.findElement(By.className("btnbtn-success")).click();

		Assert.assertTrue(webDriver.getTitle().contains("Review Management"));
		System.out.println("new title: " + webDriver.getTitle());
	}

	@Test
	public void Delete() {
		webDriver.navigate().to("http://localhost:8080/DevOpsProject/ReviewServlet/dashboard");

		Assert.assertEquals(webDriver.getTitle(), "Review Management");

		webDriver.findElement(By.xpath("/html/body/div")).click();

	}

	@BeforeTest
	public void beforeTest() {
		// Setting system properties of ChromeDriver
		// to amend directory path base on your local file path
		String chromeDriverDir = "C:\\Program Files (x86)\\Google\\Chrome\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		// initialize FirefoxDriver at the start of test
		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
		// Quit the ChromeDriver and close all associated window at the end of test
		webDriver.close();
	}

}