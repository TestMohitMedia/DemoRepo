package MavenTest.com.MavenProject;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.firefox.*;



public class FirefoxOptions 
{
	public void initializeBrowser()
	{
       org.openqa.selenium.firefox.FirefoxOptions option=new org.openqa.selenium.firefox.FirefoxOptions();
     //Set profile
      ProfilesIni allprof=new ProfilesIni();
      FirefoxProfile profile=allprof.getProfile("Mohit");
      //Prozy Set
      profile.setPreference("network.proxy.type",1);
      profile.setPreference("network.proxy.socks","310.92.12.87");
      profile.setPreference("network.proxy.socks.port",5231);
      //Certificates
      profile.setAcceptUntrustedCertificates(true);
      profile.setAssumeUntrustedCertificateIssuer(false);
      //Page Load stratery
      option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
      //Turn Off logs
      System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"D://FireFoxlogs.txt");
      //Notifications
      profile.setPreference("dom.webnotifications.enabled",false);
      option.setProfile(profile);
      System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
      //Set own download path in firefox driver
      profile.setPreference("browser.download.dir","C:\\Driver\\");
      profile.setPreference("browser.download.folderList",2);
      profile.setPreference("browser.helperApps.neverAsk,SaveToDisk","application/vnd.openxmlformats-officedocument.wordprocessingml.document");
      WebDriver driver=new FirefoxDriver(option);
	}
   
}
