package Test;

import org.testng.annotations.Test;

import General.Base_Class;
import General.Utilities;
import POM.Login;

public class Test_001 extends Base_Class {
	@Test
	public void one() throws InterruptedException
	{
		
		Login log =new Login(driver);
		System.out.println("hai");
		Thread.sleep(9000);
		log.userNameField().sendKeys("hai@gmail.ocm");
		System.out.println("bye");
		Thread.sleep(2000);
		log.passwordField().click();
		Thread.sleep(2000);
		log.passwordField().sendKeys("Nba241119!@#$");
		Thread.sleep(2000);
		System.out.println("Tata");
		log.enterBtn().click();
		System.out.println("no");
		Utilities uti=new Utilities(driver);
		uti.Press_Home_button();
		System.out.println("end");
		
		
	}
	
	

}
