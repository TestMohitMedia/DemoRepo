package stepDefinations;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefination 
{
	WebDriver driver;
	WebDriverWait wait;
   @Given("^user is already on login page$")
   public void user_already_on_login_page()
   {
	  ChromeOptions option=new ChromeOptions();
   	  option.addArguments("--disable-notifications");
   	  option.addArguments("disable-infobars");
   	  option.addArguments("--start-maximized");
	  System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,"./Driver/chromedriver.exe");
      driver=new ChromeDriver(option);
	  wait=new WebDriverWait(driver,20);
	  driver.navigate().to("https://www.freecrm.com/");
   }
   @When("^title of login page is FreeCRM$")
   public void title_login_page_FreeCRM()
   {
	   String title=driver.getTitle();
	   Assert.assertEquals("#1 Free CRM software in the cloud for sales and service",title);
   }
   @Then("^user enters username and password$")
   public void user_enters_username_and_password(){
       driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("mohitqa");
       driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("mohit@123");
   }

   @Then("^user click on login button$")
   public void user_click_on_login_button(){
	  WebElement submit=driver.findElement(By.xpath("//input[@value='Login']"));
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click();", submit);
   }
   @Then("^user is on home page$")
   public void user_is_on_home_page(){
	  String currentTitle=driver.getTitle();
	  System.out.println(currentTitle);
   }
}
