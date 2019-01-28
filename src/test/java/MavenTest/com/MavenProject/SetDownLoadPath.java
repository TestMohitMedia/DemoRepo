package MavenTest.com.MavenProject;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SetDownLoadPath 
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
		Map<String,Object> chromePrefs=new HashMap<String,Object>();
		//chromePrefs.put("profile.default_content_setting.popups",0);
		chromePrefs.put("download.default_directory","D:\\My Folder\\");
		chromePrefs.put("safebrowsing.enabled", "true");
		option.setExperimentalOption("prefs",chromePrefs);
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(ChromeOptions.CAPABILITY, option);
        driver=new ChromeDriver(option);
		wait=new WebDriverWait(driver,20);
	}
	@Test
	public void alert() throws InterruptedException
	{
		/*driver.navigate().to("https://www.seleniumhq.org/download/");
		driver.findElement(By.xpath("//a[contains(text(),'3.141.59')]")).click();
		Thread.sleep(10000);*/		
		driver.get("https://unsplash.com/search/photos/record");
		driver.findElement(By.xpath("//img[@alt='photo of black turntable']")).click();
		Thread.sleep(3000);
        driver.findElement(By.xpath("//span[text()='Download free']")).click();
        Thread.sleep(3000);
		
	}
	@AfterTest
    public void quitBrowser()
    
    {
    	driver.quit(); 
    }
}
