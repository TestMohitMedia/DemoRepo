package MavenTest.com.MavenProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleAlert {
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
	public void alert()
	{
		driver.navigate().to("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.id("login1")).sendKeys("qa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a=driver.switchTo().alert();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();//Back to main page
	}
	@AfterTest
    public void quitBrowser()
    
    {
    	driver.quit(); 
    }
}
