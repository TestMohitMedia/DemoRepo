package MavenTest.com.MavenProject;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
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
	
    @Test(enabled=true)
    public void verifyShopingCard()
    {
        driver.navigate().to("https://www.americangolf.co.uk");
        /*1. implicit wait: Dynamic wait
        2. applicable to all driver.findElement  commands.
        3. Dynamically till 20 sec. */
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='header-wishlist-trigger-ctr only-on-lg']/following-sibling::div//a")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='heading-1 cart-heading']"))));
        WebElement card=driver.findElement(By.xpath("//h1[@class='heading-1 cart-heading']"));
        
    }
    @Test
    public void verifyCNNLinks()
    {
    	driver.navigate().to("https://edition.cnn.com/");
    	WebElement web=driver.findElement(By.xpath("//*[@id='intl_homepage1-zone-1']/div[2]/div/div[3]"));
    	List<WebElement> ls=web.findElements(By.tagName("a"));
    	System.out.println(ls.size());
    	for(WebElement webs:ls)
    	{
    		System.out.println("--------"+webs.getText());
    	}
    	
    }
    @Test
    public void verifyCommit()
    {System.out.println("Test first commit.");}
    @Test
    public void verifyCommit2()
    {System.out.println("Test first commit2.");}
	@Test
    public void testPullCommit()
    {System.out.println("Test first commit3.");}
    @AfterTest
    public void quitBrowser()
    
    {
    	driver.quit(); 
    }
}
