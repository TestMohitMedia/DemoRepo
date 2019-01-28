package MavenTest.com.MavenProject;

import java.util.ArrayList;
import java.util.Set;

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

public class WinHandle {
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
	public void winHandle() throws InterruptedException
	{
		driver.navigate().to("https://www.online.citibank.co.in/");
		String ParentWin=driver.getWindowHandle();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.xpath("//a[@title='Login']")).click();
		ArrayList<String> tab2=new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tab2.size());
		driver.switchTo().window(tab2.get(1));
		System.out.println(driver.getCurrentUrl());
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#User_Id"))));
		driver.findElement(By.cssSelector("#User_Id")).sendKeys("mohit");
		System.out.println("Enter user info.");
		driver.close();
	    driver.switchTo().window(tab2.get(0));
		
	}
	public Set<String> returnWinId()
	{
		return driver.getWindowHandles();
	}
	@AfterTest
    public void quitBrowser()
    
    {
    	driver.quit(); 
    }

}
