package MavenTest.com.MavenProject;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleCookies 
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
        driver.navigate().to("https://www.americangolf.co.uk");
        Set<Cookie> cookie=driver.manage().getCookies();
        Iterator<Cookie> itr=cookie.iterator();
        System.out.println(cookie.size());
        while(itr.hasNext())
        {
        	Cookie c=itr.next();
        	System.out.println(c.getName()+"------------"+c.getValue()+"---------"+c.getExpiry());
        	//System.out.println("-------------------------------");
        	if(c.getName().equalsIgnoreCase("_ga"))
        	{
        		driver.manage().deleteCookieNamed("_ga");
        		Cookie cookies=new Cookie("_ga","testqa101");
        		driver.manage().addCookie(cookies);
        	}
        }
        Set<Cookie> cookieSet=driver.manage().getCookies();
        Iterator<Cookie> itrs=cookie.iterator();
        System.out.println(cookieSet.size());
        while(itrs.hasNext())
        {
        	Cookie c=itrs.next();
        	System.out.println(c.getName()+"------------"+c.getValue()+"---------"+c.getExpiry());
        }
     }
    @AfterTest
    public void quitBrowser()
    
    {
    	driver.quit(); 
    }
}
