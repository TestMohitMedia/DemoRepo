package MavenTest.com.MavenProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScriptExecutor 
{
	WebDriver driver;
	WebDriverWait wait;
	@BeforeTest
	public void setUp()
	{
		ChromeOptions option=new ChromeOptions();
    	option.addArguments("--disable-notifications");
    	option.addArguments("disable-infobars");
    	option.addArguments("--start-maximized");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,"./Driver/chromedriver.exe");
        driver=new ChromeDriver(option);
		wait=new WebDriverWait(driver,20);
	}
	@Test
	public void alert() throws InterruptedException
	{
		//driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.location='https://www.rediff.com/'");
		String status=(String) js.executeScript("return document.readyState");
		System.out.println(status);
		//js.executeScript("document.getElementById('login1').value='hello';");
		WebElement deal=driver.findElement(By.xpath("//a[text()='Hourly Deal']"));
		js.executeScript("window.scrollBy(0,200)");
		js.executeScript("arguments[0].scrollIntoView();", deal);
		Thread.sleep(3000);
		
		
	}
	@AfterTest
    public void quitBrowser()
    
    {
    	driver.quit(); 
    }
}
