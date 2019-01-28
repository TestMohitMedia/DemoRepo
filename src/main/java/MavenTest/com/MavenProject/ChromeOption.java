package MavenTest.com.MavenProject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOption 
{
	public void setBrowsersetup()
	{
	 ChromeOptions option=new ChromeOptions();
	 //disable notification
	 option.addArguments("--disable-notifications");
	 //disable infobar
	 option.addArguments("--disable-infobar");
	 //Handle logs
	 System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,"D://chrome.txt");
	 //option.addArguments("--proxy-server=http://83.09.3.12:9021");
 	 //option.addArguments("User-data-dir=C:\\Users\\mohit\\AppData\\Local\\Google\\Chrome\\User Data\\");
 	 //option.setPageLoadStrategy(PageLoadStrategy.EAGER);
	 System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,"./D/chromedriver.exe");
	 
	 //Set own download path for chrome browser.
	 
	   Map<String,Object> prof=new HashMap<String,Object>();
	   prof.put("download.default_directory","C:\\Drivertexxt\\");
	   prof.put("profile.default_content_setting.popups",0);
	   prof.put("savebrowsing.enabled",true);
	   option.setExperimentalOption("profs",prof);
	 ChromeDriver driver=new ChromeDriver(option);
	}
}
