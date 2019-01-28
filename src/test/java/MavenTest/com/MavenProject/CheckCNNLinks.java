package MavenTest.com.MavenProject;

import java.util.List;

import org.apache.http.client.fluent.Request;
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

public class CheckCNNLinks 
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
    public void verifyCNNLinks()
    {
    	driver.navigate().to("https://edition.cnn.com/");
    	List<WebElement> ls=driver.findElements(By.xpath("//*[@id='intl_homepage1-zone-1']/div[2]/div/div[3]//a"));
        String path1="//*[@id='intl_homepage1-zone-1']/div[2]/div/div[3]//li[";
        String path2="]//a";
        int i=2;
        while(isElementPresent(path1+i+path2,"xpath"))
        {
        	String lnkName=driver.findElement(By.xpath(path1+i+path2)).getText();
        	System.out.println(lnkName);
        	String url=driver.findElement(By.xpath(path1+i+path2)).getAttribute("href");
        	if(getResponseStatus(url))
        	{
        	driver.findElement(By.xpath(path1+i+path2)).click();
        	System.out.println(driver.getTitle());
        	driver.navigate().back();
        	i++;
        	}
        }
     }
	/*Verify response code before clicking on links.
	Steps 1. Add fluent-hc maven dependency.*/
	public boolean getResponseStatus(String url)
	{
		int response_code=0;
		try{
			response_code=Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
		   }catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		if(response_code==200)
			return true;
        else
		    return false;
	}
	public boolean isElementPresent(String Locator,String LocatorType)
	{
		List<WebElement> element=null;
		
		if(LocatorType.equalsIgnoreCase("xpath"))
		{
		   element=driver.findElements(By.xpath(Locator));
		}else  if(LocatorType.equalsIgnoreCase("cssselector"))
		{
			element=driver.findElements(By.cssSelector(Locator));
		}else  if(LocatorType.equalsIgnoreCase("class"))
		{
			element=driver.findElements(By.className(Locator));
		}else  if(LocatorType.equalsIgnoreCase("tagrule"))
		{
			element=driver.findElements(By.className(Locator));
		}else  if(LocatorType.equalsIgnoreCase("id"))
		{
			element=driver.findElements(By.className(Locator));
		}
		if(element.size()>0)
		   return true;
		else
			return false;
	}
    @AfterTest
    public void quitBrowser()
    
    {
    	driver.quit(); 
    }
}
