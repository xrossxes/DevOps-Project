package com.sddevops.DevOpsProject;
import java.util.Random;

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

public class NewTest { 
  //declare Selenium WebDriver
  private WebDriver webDriver1;		
  private String Name;
   
  public String generateRandomName(int length) {
      char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
              .toCharArray();
      StringBuilder sb = new StringBuilder();
      Random random = new Random();
      for (int i = 0; i < length; i++) {
          char c = chars[random.nextInt(chars.length)];
          sb.append(c);
      }
      String randomString = sb.toString();
      return randomString;
  }
   
  @Test
  public void checkTitle() {
	  //Load website as a new page
	  webDriver1.navigate().to("http://localhost:8090/DevOpsProject/UserServlet/dashboard");
	  
	  //Assert the title to check that we are indeed in the correct website
	  Assert.assertEquals(webDriver1.getTitle(), "User Management");
	  
	  System.out.println("title: "+webDriver1.getTitle());
	  
	  //Retrieve link using it's class name and click on it
	  webDriver1.findElement(By.className("btnbtnsuccess")).click();

	  //Assert the new title to check that the title contain Wikipedia and the button had successfully bring us to the new page
	  Assert.assertTrue(webDriver1.getTitle().contains("User Registration"));
	  System.out.println("new title: "+webDriver1.getTitle());
	  
	   
  }
  @Test
  // Create a registration function to test it out
  public void Registration() {
	  
	  // Go to this page 
	  
	  webDriver1.navigate().to("http://localhost:8090/DevOpsProject/register.jsp");
	  
	  // Go to this page with a title called 'User Registration'
	  
	  Assert.assertEquals(webDriver1.getTitle(), "User Registration");
	  
	  System.out.println("title: "+webDriver1.getTitle());
	  
	  // Go to the 1st input
	  
	  WebElement name =  webDriver1.findElement(By.xpath("/html/body/form/input[1]"));
	  
	  // Input
	  
	  name.sendKeys("Moho");
	  
	// Go to the 2nd input
	  
	  WebElement password =  webDriver1.findElement(By.xpath("/html/body/form/input[2]"));
	  
	  // Input
	  
	  password.sendKeys("1234");
	  
	// Go to the 3rd input
	  
	  WebElement email =  webDriver1.findElement(By.xpath("/html/body/form/input[3]"));
	  
	  //input 
	  
	  email.sendKeys("Moho@gmail.com");
	  
	  // press the button with class name 'register'
	  
	  webDriver1.findElement(By.className("register")).click();
	  
	  // press the button with class name 'afterregister'
	  
	  webDriver1.findElement(By.className("SuccessRegister")).click();
	  
	  // Go to the page with the title named 'User Management'
	  
	  Assert.assertTrue(webDriver1.getTitle().contains("User Management"));
	  System.out.println("new title: "+webDriver1.getTitle());
	  
  }
	  @Test
	  public void Edit() {
		  webDriver1.navigate().to("http://localhost:8090/DevOpsProject/UserServlet/dashboard");
		 
		  Name = generateRandomName(9);
		  
		  Assert.assertEquals(webDriver1.getTitle(), "User Management");
		  
		  System.out.println("title: "+webDriver1.getTitle());
		  
		  webDriver1.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[4]/a[1]")).click();

		  
		  WebElement name2 =  webDriver1.findElement(By.xpath("/html/body/div/div/div/form/fieldset[1]/input"));
		  
		  name2.sendKeys(Keys.chord(Keys.CONTROL, "a"), Name );
		  
		  WebElement password2 =  webDriver1.findElement(By.xpath("/html/body/div/div/div/form/fieldset[2]/input"));
		  		  	  
		  password2.sendKeys(Keys.chord(Keys.CONTROL, "a"),Name);
		  
		  WebElement email2 =  webDriver1.findElement(By.xpath("/html/body/div/div/div/form/fieldset[3]/input"));
		  
		  email2.sendKeys(Keys.chord(Keys.CONTROL, "a"), Name +"@gmail.com");
		  
		  webDriver1.findElement(By.className("btnbtn-success")).click();
		  
		  Assert.assertTrue(webDriver1.getTitle().contains("User Management"));
		  System.out.println("new title: "+webDriver1.getTitle()); 
		  
		
	  }
	   
	  @Test
	  public void Delete() {
		  webDriver1.navigate().to("http://localhost:8090/DevOpsProject/UserServlet/dashboard");
		  
		  Assert.assertEquals(webDriver1.getTitle(), "User Management");
		  
		  webDriver1.findElement(By.xpath("/html/body/div")).click();
		  
	  
	  }
	  
  
  @BeforeTest
  public void beforeTest() {
	  //Setting system properties of ChromeDriver
	  //to amend directory path base on your local file path
	  String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

	  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

	  //initialize FirefoxDriver at the start of test
	  webDriver1 = new ChromeDriver();  
  }

  @AfterTest
  public void afterTest() {
	  //Quit the ChromeDriver and close all associated window at the end of test
	  webDriver1.quit();			
  }

}