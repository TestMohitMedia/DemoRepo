package MavenTest.com.MavenProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFile 
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
	public void alert() throws InterruptedException, IOException
	{
	driver.navigate().to("https://upload.photobox.com/en/#computer");
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("#button_desktop")).click();
	/*
	 * Script for AutoID
	 * WinWaitActive("Open")
	 * ControlSetText("Open","","Edit1",$CmdLine[1])
	 * ControlClick("Open","","Button1")
	 * */
	 Process process=new ProcessBuilder("./AutoITScript/fileupload.exe","D:\\workspace\\com.MavenProject\\UploadScreenshot\\test.jpg","Open").start();
	//Runtime.getRuntime().exec("C:\\Users\\mohit\\Desktop\\fileupload.exe");
	Thread.sleep(8000);
	}
	@AfterTest
    public void quitBrowser()
    {
    	driver.quit(); 
    }
}
