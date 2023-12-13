package General;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.github.ashwith.flutter.FlutterFinder;

public class Utilities {
	public AndroidDriver driver;
    public FlutterFinder finder;

    public Utilities( AndroidDriver driver) {
        this.driver = driver;
        this.finder = new FlutterFinder(driver);
    }
	
	public void landscape(){
		DeviceRotation land =new DeviceRotation(0, 0, 90);
		driver.rotate(land);
	}
	
	public void web(String name) {
		driver.getContextHandles();
		driver.context(name);
	}
	
	public void Press_back_button(){
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	
	
	public void Press_Enter_button(){
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
	
	public void Press_Home_button(){
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
	
	public void Hide_keyboard() {
		driver.hideKeyboard();
	}
	
	
	public void LongPress(WebElement element, int time){
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),"duration", time));
		
	}
	
	public void LongPress_Dimension(int x, int y, int time){
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		        "x", x,
		        "y", y,
		        "duration", time));
	}
	
	public void DoubleClick(WebElement element){
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()));
		
	}
	
	public void DoubleClick_Dimension(int x, int y){
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of(
		        "x", x,
		        "y", y));
	}
	
	public void Click(WebElement element){
		driver.executeScript("mobile: clickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()));
	}
	
	public void Click_Dimension(int x, int y){
		driver.executeScript("mobile: clickGesture", ImmutableMap.of(
				"x", x,
		        "y", y));
		
	}
	
	public void Drop(WebElement element, int x, int y){
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "endX", x,
			    "endY", y));
		
	}
	
	public void Scroll_to_element(WebElement element){
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector(().scrollIntoView(text(\"" + element + "\"));"));
	}
	
	// 
	public void scroll( int left, int top, int width, int height,String direction, double percent){
		boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", left, "top", top, "width", width, "height", height,
			    "direction", direction,
			    "percent", percent));
	}
	
	public void scroll_end(int left, int top, int width, int height,String direction, double percent){
		boolean canScrollMore;
		do {
		    canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", left, "top", top, "width", width, "height", height,
			    "direction", direction,
			    "percent", percent));}while(canScrollMore);
		
	}
	
	
	public void Swipe(int left, int top, int width, int height,String direction, double percent){
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"left", left, "top", top, "width", width, "height", height,
			    "direction", direction,
			    "percent", percent));
	}
	
	
	public void Swipe_using_element(WebElement element,String direction, double percent){
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				 "elementId", ((RemoteWebElement) element).getId(),
			    "direction", direction,
			    "percent", percent));
	}
	

}
