package MavenTest.com.MavenProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class TestTestNg 
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
    public void verifyShopingCard()
    {
        driver.navigate().to("https://www.rediff.com/");
        /*1. implicit wait: Dynamic wait
        2. applicable to all driver.findElement  commands.
        3. Dynamically till 20 sec. */
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//u[contains(text(),'rediffmail')]")).click();
        WebElement username=driver.findElement(By.id("login1"));
        username.sendKeys("PrimeQA");
        String userID=username.getAttribute("value");
        if(userID==null)
        {
        	System.out.print("Text is blank for UserID");
        }
        else
        {
        	System.out.println("UserID textbox text is: "+userID);
        }
        	
    }
    @AfterTest
    public void quitBrowser()
    
    {
    	driver.quit(); 
    }

}
