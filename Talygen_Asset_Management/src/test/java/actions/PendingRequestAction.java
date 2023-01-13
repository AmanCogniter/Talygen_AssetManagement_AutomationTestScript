package actions;

import org.openqa.selenium.WebDriver;

import pageObjects.ManageProductPage;
import pageObjects.PendingRequestPage;

public class PendingRequestAction {
	WebDriver driver;
	PendingRequestPage pendingRequestPage;
	public  PendingRequestAction(WebDriver driver)
	{
		this.driver= driver;
		pendingRequestPage = new PendingRequestPage(driver);
	}
	
	public void GoToPendingRequestPage()
	{
		
		pendingRequestPage.clickFullMenuDropDown();
		pendingRequestPage.clickOnAssetManagement();
		pendingRequestPage.clickOnPendingRequest();
	}
	public void VerifyPendingRequestInPendingCheckOutRequestPage()
	{
		
		pendingRequestPage.clickOnSelectProductName();
		pendingRequestPage.clickOnSearchButton();
		pendingRequestPage.verifyProductName();
	}
	public void VerifyPendingRequestInReservationPage()
	{
		pendingRequestPage.clickOnReservation();
		pendingRequestPage.clickOnSelectProductName();
		pendingRequestPage.clickOnSearchButton();
		pendingRequestPage.verifyProductName();
	}
	public void VerifyPendingRequestAssignFunctionalityInPendingCheckOutRequestPage()
	{
		
		pendingRequestPage.clickOnSelectProductName();
		pendingRequestPage.clickOnSearchButton();
		pendingRequestPage.verifyProductName();
		pendingRequestPage.clickOnAssignButton();
		pendingRequestPage.clickOnSave();
	}
	public void VerifyFunctionalityReturnrequestPagewithApproveFunctionality()
	{
		pendingRequestPage.clickOnReturnRequest();
		pendingRequestPage.clickOnenterReturnRequestProductName();
		pendingRequestPage.clickOnSearch();
		pendingRequestPage.clickOnCheckBox();
		pendingRequestPage.clickOnApproveButton();
		pendingRequestPage.clickOnSaveButton();
		pendingRequestPage.validateNotifyMessageForApprove();
		
	}
	public void VerifyFunctionalityReturnrequestPagewithRejetcFunctionality()
	{
		pendingRequestPage.clickOnReturnRequest();
		pendingRequestPage.clickOnenterReturnRequestProductName();
		pendingRequestPage.clickOnSearch();
		pendingRequestPage.clickOnCheckBox();
		pendingRequestPage.clickOnRejectButton();
		pendingRequestPage.clickOnSaveButton();
		pendingRequestPage.validateNotifyMessageForReject();
		
	}
}
