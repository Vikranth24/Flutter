package General;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Generic_Screenshots {
public static void getPhoto(WebDriver driver) throws IOException {
		
		String photo="./screen_shot";			
		java.util.Date date= new java.util.Date();
		String ScreenShotDate=date.toString().replaceAll(":", "-");
		TakesScreenshot takeScreenShot=(TakesScreenshot)driver;
		java.io.File source=takeScreenShot.getScreenshotAs(OutputType.FILE);
		java.io.File destination= new java.io.File(photo+ScreenShotDate+".png");
		FileHandler.copy(source, destination);		
	}

}
