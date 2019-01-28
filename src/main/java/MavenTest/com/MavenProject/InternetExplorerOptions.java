package MavenTest.com.MavenProject;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorerOptions
{
  public void setIESetup()
  {
	  org.openqa.selenium.ie.InternetExplorerOptions option=new org.openqa.selenium.ie.InternetExplorerOptions();
	  //Logs
	  System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,"INFO");
	  System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,"D:IE_logs.txt");
	  //Set Proxy
	  DesiredCapabilities cap =new DesiredCapabilities();
	  String PROXY="83.1.232.12:9090";
	  Proxy proxy=new Proxy();
	  proxy.setAutodetect(false);
	  proxy.setProxyType(Proxy.ProxyType.MANUAL);
	  proxy.setSocksProxy(PROXY);
	  cap.setCapability(CapabilityType.PROXY,proxy);
	  option.merge(cap);
	  
  }
}
