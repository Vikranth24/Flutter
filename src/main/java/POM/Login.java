package POM;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.github.ashwith.flutter.FlutterFinder;

public class Login {
	public AndroidDriver driver;
    public FlutterFinder finder;

    public Login( AndroidDriver driver) {
        this.driver = driver;
        this.finder = new FlutterFinder(driver);
    }

    public WebElement userNameField() {
        return this.finder.byValueKey("user_name");
    }

    public WebElement passwordField() {
        return this.finder.byValueKey("Pass");
    }

    public WebElement enterBtn() {
        return this.finder.byText("ENTER");
    }

}
