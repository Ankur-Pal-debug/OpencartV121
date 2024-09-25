package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_Login()
	{
		try {
		//HomePage
		logger.info("*** Starting TC_002LoginTest ****");
		logger.debug("capturing application debug logs ***");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on myaccount link on homepage..");
		hp.clickLogin();
		logger.info("clicked on login link on homepage..");
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password..");
		lp.setEmail(p.getProperty("email"));
		lp.SetPassword(p.getProperty("password"));
		logger.info("clicked on login button****");
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExist();
		
		Assert.assertEquals(targetpage, true, "Login Failed");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_LoginTest  ****");

				
		
	}

}
