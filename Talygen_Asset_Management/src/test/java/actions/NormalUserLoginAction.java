package actions;
import org.openqa.selenium.WebDriver;

import pageObjects.NormalUserLoginPage;

public class NormalUserLoginAction  {
    WebDriver driver;
    NormalUserLoginPage normalUserLoginPage;
    public NormalUserLoginAction(WebDriver driver)
    {
        this.driver = driver;
        normalUserLoginPage = new NormalUserLoginPage(driver);
    }
    public void enterCredentials()
    {
    	normalUserLoginPage = new NormalUserLoginPage(driver);
    	normalUserLoginPage.enterUserName();
		 normalUserLoginPage.enterPassword(); 
        //userLoginPage.acceptPrivacyPolicy();
    }

	
	  public void submit() { 
		  normalUserLoginPage.clickLogin(); }
	 
    public void logoutLogin(){
    	normalUserLoginPage.forcefulLogOutLogin();
    }

}
