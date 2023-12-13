package General;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base_Class {

	public static AndroidDriver driver;
	public  static AppiumDriverLocalService server;
	@BeforeSuite
	public void add() throws MalformedURLException
	{
		
		 server = new AppiumServiceBuilder()
					.withAppiumJS(
							new File("C:\\Users\\vikra\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).build();
			server.start();
		  
		   
		
	}
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void capabilities() throws MalformedURLException
	{
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		   capabilities.setCapability("app", "C:\\Users\\vikra\\eclipse-project\\Flutter_Framework\\src\\main\\resources\\app-debug.apk");
		   capabilities.setCapability("deviceName", "pro");
		   capabilities.setCapability("platformName", "Android");
		   capabilities.setCapability("automationName", "Flutter");
		   driver =new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
		
	}
	@AfterClass
	public void logout()
	{
		
		
	}
	
	@AfterTest
	public void quit() {
		
		driver.quit();
	}
	
	
	
	@AfterSuite
	public void closeServer()
	{
		
		server.stop();
		
	}}
