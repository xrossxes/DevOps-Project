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

public class NewTest_HX {
	// declare Selenium WebDriver
	private WebDriver webDriver;

	@Test

	// shows all details of the users on dashboard
	public void checkProfile() {
		// Load website as a new page
		webDriver.navigate().to("http://localhost:8091/DevOpsProject/ProfileServlet/dashboard");

		// Assert the title to check that we are indeed in the correct website
		Assert.assertEquals(webDriver.getTitle(), "Profile Management");

		System.out.println("title: " + webDriver.getTitle());

		// Retrieve link using it's class name and click on it
		webDriver.findElement(By.className("btnsuccess")).click();

		// Assert the new title to check that the title contain Wikipedia and the button
		// had successfully bring us to the new page
		Assert.assertTrue(webDriver.getTitle().contains("Add Profile"));
		System.out.println("new title: " + webDriver.getTitle());
	}

	@Test
	// add profile page form
	public void AddProfile() {
		webDriver.navigate().to("http://localhost:8091/DevOpsProject/addprofile.jsp");

		Assert.assertEquals(webDriver.getTitle(), "Add Profile");

		System.out.println("title: " + webDriver.getTitle());

		WebElement name = webDriver.findElement(By.xpath("/html/body/form/input[1]"));

		name.sendKeys("john3edxample");

		WebElement password = webDriver.findElement(By.xpath("/html/body/form/input[2]"));

		password.sendKeys("eclipseTdest3");

		webDriver.findElement(By.className("addprofilebtn")).click();		
		webDriver.findElement(By.className("nextpagebtn")).click();

		Assert.assertTrue(webDriver.getTitle().contains("Profile Management"));
		System.out.println("new title: " + webDriver.getTitle());

	}

	@Test
	public void editProfile() {
		webDriver.navigate().to("http://localhost:8091/DevOpsProject/ProfileServlet/dashboard");

		Assert.assertEquals(webDriver.getTitle(), "Profile Management");

		System.out.println("title: " + webDriver.getTitle());

		webDriver.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[4]/a[1]")).click();

		WebElement name2 = webDriver.findElement(By.xpath("/html/body/div/div/div/form/fieldset[1]/input"));

		name2.sendKeys(Keys.chord(Keys.CONTROL, "a"), "editname233");

		WebElement password2 = webDriver.findElement(By.xpath("/html/body/div/div/div/form/fieldset[2]/input"));

		password2.sendKeys(Keys.chord(Keys.CONTROL, "a"), "editpassw2o3rd3");

		webDriver.findElement(By.className("editbutton")).click();

		Assert.assertTrue(webDriver.getTitle().contains("Profile Management"));
		System.out.println("new title: " + webDriver.getTitle());

	}

	@Test
	public void deleteProfile() {
		webDriver.navigate().to("http://localhost:8091/DevOpsProject/ProfileServlet/dashboard");

		Assert.assertEquals(webDriver.getTitle(), "Profile Management");

		webDriver.findElement(By.xpath("/html/body/div")).click();

	}

	@BeforeTest
	public void beforeTestProfile() {
		// Setting system properties of ChromeDriver
		// to amend directory path base on your local file path
		String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

		System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		// initialize FirefoxDriver at the start of test
		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTestProfile() {
		// Quit the ChromeDriver and close all associated window at the end of test
		webDriver.close();
	}

}