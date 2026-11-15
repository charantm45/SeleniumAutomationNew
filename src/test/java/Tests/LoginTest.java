package Tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
     @Test
	public void testvalidateLoginPage () {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername("admin@yourstore.com");
		loginpage.enterPassword("admin");
		loginpage.clickLogin();
	}
}