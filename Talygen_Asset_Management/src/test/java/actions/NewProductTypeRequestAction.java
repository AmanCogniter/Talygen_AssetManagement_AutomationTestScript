package actions;

import org.openqa.selenium.WebDriver;

import pageObjects.ManageProductPage;
import pageObjects.NewProductTypeRequestPage;

public class NewProductTypeRequestAction {
	WebDriver driver;
	NewProductTypeRequestPage newProductTypeRequestPage;
	
	public  NewProductTypeRequestAction(WebDriver driver)
	{
		this.driver= driver;
		newProductTypeRequestPage = new NewProductTypeRequestPage(driver);
	}
	
	public void GoToNewProductTypeRequesPage()
	{
		
		newProductTypeRequestPage.clickFullMenuDropDown();
		newProductTypeRequestPage.clickOnAssetManagement();
		newProductTypeRequestPage.clickOnNewProductTypeRequest();
	}
	public void  validationCheck()
	{
		newProductTypeRequestPage.clickOnNewRequestProductType();
		newProductTypeRequestPage.clickOnSave();
		newProductTypeRequestPage.VerifyMandatoryFieldValidationOfAddProductPage();
		newProductTypeRequestPage.clickOnCancel();
	}
	public void checkFunctionalityOfRequestNewProductType() {

		newProductTypeRequestPage.clickOnNewRequestProductType();
		newProductTypeRequestPage.EnterProductTypeName();
		newProductTypeRequestPage.EnterDescription();
		newProductTypeRequestPage.clickOnSave();
		newProductTypeRequestPage.validateNotifyMessage();
		
	}
	public void VerifyNewAddedProducttype() {

		newProductTypeRequestPage.clickOnExpandAllorCollapseAll();
		newProductTypeRequestPage.EnterTitle();
		newProductTypeRequestPage.clickOnSearch();
		newProductTypeRequestPage.validateNewaddedProductTypeInProductListPage();
		
		
	}
	public void checkFunctionalityOfRemoveProductType() {

		newProductTypeRequestPage.clickOnExpandAllorCollapseAll();
		newProductTypeRequestPage.EnterTitle();
		newProductTypeRequestPage.clickOnSearch();
		newProductTypeRequestPage.clickOnCheckBox();
		newProductTypeRequestPage.clickOnRemoveButton();
		newProductTypeRequestPage.clickOnConfirmationButton();
		newProductTypeRequestPage.validateNotifyMessageForRemoveProductType();
		newProductTypeRequestPage.validateNewaddedProductTypeInProductListPage();
		
	}
	public void verifyApproveFunctionality() {

		newProductTypeRequestPage.clickOnExpandAllorCollapseAll();
		newProductTypeRequestPage.EnterTitle();
		newProductTypeRequestPage.clickOnSearch();
		newProductTypeRequestPage.clickOnViewButton();
		newProductTypeRequestPage.EnterApprovedCommentTitle();
		newProductTypeRequestPage.EnterCommentDescription();
		newProductTypeRequestPage.clickOnPostComment();
		newProductTypeRequestPage.clickOnApproveButton();
		
		
	}
	public void verifyRejectionFunctionality() {

		newProductTypeRequestPage.clickOnExpandAllorCollapseAll();
		newProductTypeRequestPage.EnterTitle();
		newProductTypeRequestPage.clickOnSearch();
		newProductTypeRequestPage.clickOnViewButton();
		newProductTypeRequestPage.EnterRejectedCommentTitle();
		newProductTypeRequestPage.EnterCommentDescription();
		newProductTypeRequestPage.clickOnPostComment();
		newProductTypeRequestPage.clickOnRejectButton();
		
		
	}
	
}
