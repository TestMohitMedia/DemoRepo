package MavenTest.com.MavenProject;

import java.util.List;

import org.openqa.selenium.Alert;
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

public class WebTableScenarios 
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
	public void getCompanyPrice()
	{
		String CompanyName="Commercial Engineers";
		String path="//table[@class='dataTable']/tbody/tr/td/a[contains(text(),'"+CompanyName+"')]/ancestor::tr/td[4]";
		driver.navigate().to("https://money.rediff.com/gainers/bse/weekly");
		String priceCompany=driver.findElement(By.xpath(path)).getText();
		System.out.println(priceCompany);
	}
	@AfterTest
    public void quitBrowser()
    {
    	driver.quit(); 
    }
}
