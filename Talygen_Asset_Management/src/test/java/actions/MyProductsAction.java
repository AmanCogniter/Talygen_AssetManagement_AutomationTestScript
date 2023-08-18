package actions;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import pageObjects.ManageProductPage;
import pageObjects.MyProductsPage;

public class MyProductsAction {
	WebDriver driver;
	MyProductsPage myProductsPage;
	ManageProductPage manageProductPage;

	public MyProductsAction(WebDriver driver) {
		this.driver = driver;
		myProductsPage = new MyProductsPage(driver);
		manageProductPage = new ManageProductPage(driver);
	}

	public void GoTomyProductPage() {

		myProductsPage.clickFullMenuDropDown();
		myProductsPage.clickOnAssetManagement();
		myProductsPage.clickOnMyProducts();
	}

	public void VerifyfunctionalityOfCheckAvability() {

		myProductsPage.clickOnCheckAvailability();
		manageProductPage.clickOnSearchByProductRadioButton();
		manageProductPage.clickOnSelectProductName();
		manageProductPage.clickOnCheckAvability();
		manageProductPage.CheckProductAvabilityAndQuantity();
		manageProductPage.clickOnProductAvaibilityCheckBox();
		myProductsPage.clickOnProceedToAssign();
		myProductsPage.enterRequestQuantityInTextField();
		myProductsPage.clickOnSaveButtonOfProductAssignmentPage();
		myProductsPage.clickOnExpandAllorCollapseAll();

		myProductsPage.enterproductnameInSearchField();
		myProductsPage.clickOnSearchButton();
		// myProductsPage.validateProductName();
		myProductsPage.clickOnCheckBox();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();

		/*
		 * myProductsPage.clickOnNotReturn(); myProductsPage.enterTitle();
		 * myProductsPage.enterComment();
		 */
		myProductsPage.clickOnCloseActionButton();

	}
	public void VerifyfunctionalityOfCheckAvabilityForNormalUser() throws AWTException {

		myProductsPage.clickOnCheckAvailability();
		manageProductPage.clickOnSearchByProductRadioButton();
		manageProductPage.clickOnSelectProductName();
		manageProductPage.selecttomorrowDate();
		manageProductPage.clickOnCheckAvability();
		manageProductPage.CheckProductAvabilityAndQuantity();
		manageProductPage.clickOnProductAvaibilityCheckBox();
		myProductsPage.clickOnProceedToCheckOut();
		

		
		  myProductsPage.clickOnAddProduct();
		  myProductsPage.clickOnSelectProductType();
		  myProductsPage.clickOnSelectProductName();
		 // myProductsPage.clickOnSelectItem(); 
		  //myProductsPage.clickOnSearch();
		  myProductsPage.clickOnClose();
		  myProductsPage.clickOnTermsAndCondition();
			/*
			 * myProductsPage.clickOnCheckBoxofSearchItem();
			 * myProductsPage.clickOnAddToList();
			 * 
			 * myProductsPage.waitforElement(); myProductsPage.clickOnSave();
			 * myProductsPage.clickOnExpandAllorCollapseAll();
			 * myProductsPage.enterproductnameInCheckOutListSearchField();
			 * myProductsPage.clickOnSearch();
			 * myProductsPage.verifyProductNameInProductListPage();
			 */

		  myProductsPage.clickOnSaveButtonOfProductCheckOutPage();
		  manageProductPage.clickOnExpandOrCollapseAllSearchField();
		  
		  manageProductPage.enterProductNameInsearchFieldOfCheckOutList();
		  manageProductPage.clickOnSearchbuttonOfCheckOutList();
		 
		
		 
	}
	public void validationcheckOfCheckAvability() {

		myProductsPage.clickOnCheckAvailability();
		manageProductPage.clickOnSearchByProductRadioButton();
		manageProductPage.clickOnCheckAvability();
		manageProductPage.validateNotificationPopup();
	}
		
	public void VerifyProductNameOnMyProductListPage() {
		myProductsPage.enterProductName();
		myProductsPage.clickOnMyProductSearchButton();
		myProductsPage.verifyProductNameInMyProductListPage();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnAcceptButton();
		myProductsPage.enterProductName();
		myProductsPage.clickOnMyProductSearchButton();
		myProductsPage.verifyProductOnMyProductListPage();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnAcceptTermsAndCondition();
		myProductsPage.clickOnTermsAndConditionCheckBox();
		myProductsPage.clickOnTermsAndConditionsaveButton();
	}

	public void validationCheckOfAddCheckOutRequestMandatoryFields() {
		myProductsPage.clickOnAddCheckOutRequest();
		myProductsPage.clickOnSave();
		myProductsPage.validateNotificationPopup();
		
	}

	public void checkFunctionalityOfAddCheckOutRequest() {

		myProductsPage.clickOnAddCheckOutRequest();
		myProductsPage.enterAddCheckOutRequestComment();
		myProductsPage.clickOnAddProduct();
		myProductsPage.clickOnSelectProductType();
		myProductsPage.clickOnSelectProductName();
		myProductsPage.clickOnSelectItem();
		myProductsPage.clickOnSearch();
		myProductsPage.clickOnCheckBoxofSearchItem();
		myProductsPage.clickOnAddToList();
		myProductsPage.waitforElement();
		//myProductsPage.clickOnRequestQuantityOfProductAssignmentReport();
		myProductsPage.clickOnSave();
		myProductsPage.clickOnExpandAllorCollapseAll();
		myProductsPage.enterproductnameInCheckOutListSearchField();
		myProductsPage.clickOnSearch();
		myProductsPage.verifyProductNameInProductListPage();
	}
	public void checkFunctionalityOfAddCheckOutRequestFromCheckOutListPage() {
		myProductsPage.clickOnCheckOutRequestList();
		myProductsPage.clickOnAddCheckOutRequest();
		myProductsPage.enterAddCheckOutRequestComment();
		myProductsPage.clickOnAddProduct();
		myProductsPage.clickOnSelectProductType();
		myProductsPage.clickOnSelectProductName();
		myProductsPage.clickOnSelectItem();
		myProductsPage.clickOnSearch();
		myProductsPage.clickOnCheckBoxofSearchItem();
		myProductsPage.clickOnAddToList();
		myProductsPage.waitforElement();
		myProductsPage.clickOnSave();
		myProductsPage.clickOnExpandAllorCollapseAll();
		myProductsPage.enterproductnameInCheckOutListSearchField();
		myProductsPage.clickOnSearch();
		myProductsPage.verifyProductNameInProductListPage();
	}

	public void checkFunctionalityOfCheckOutRequestList() {

		myProductsPage.clickOnCheckOutRequestList();
		myProductsPage.clickOnExpandAllorCollapseAll();
		myProductsPage.enterproductnameInCheckOutListSearchField();
		myProductsPage.clickOnSearch();
		myProductsPage.verifyProductNameInProductListPage();
		myProductsPage.clickOnCancelButton();
		myProductsPage.clickOnConfirmationButton();
		myProductsPage.enterRejectionReason();
		myProductsPage.clickOnSaveButton();
	}
	public void checkFunctionalityOfSelfAssignment() {

		myProductsPage.clickOnSelfAssignment();
		myProductsPage.enterRemark();
		myProductsPage.selectProductType();
		myProductsPage.selectProductName();
		myProductsPage.enterName();
		myProductsPage.clickOnAddProductOfSelfAssignment();
		myProductsPage.clickOnTermsAndConditionCheckBoxOfSelfAssignment();
		myProductsPage.clickOnAddToItem();
		myProductsPage.clickOnSave();
		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
	}
	public void checkFunctionalityOfReturn() {

		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnAcceptButton();
		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnReturnButton();
		myProductsPage.selectReason();
		myProductsPage.enterQuantity();
		myProductsPage.clickOnSubmitButton();
		myProductsPage.notifyMessage();
	}
	public void checkFunctionalityOfRejectActionButton() {

		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnRejectButton();
		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.validateRejectedProduct();
		}
	public void checkassignedProductInMyProductListPage() {

		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
	}
	public void checkFunctionalityOfAcceptButton() {

		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnConsumeButton();
		myProductsPage.enterQuantity();
		myProductsPage.enterRemarks();
		myProductsPage.enterTag();
		myProductsPage.clickOnConsumeSaveButton();
		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.validateConsumequantity();
	}
	public void checkFunctionalityOfconsume() {
		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnAcceptButton();
		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnConsumeButton();
		myProductsPage.enterQuantity();
		myProductsPage.enterRemarks();
		myProductsPage.enterTag();
		myProductsPage.clickOnConsumeSaveButton();
		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.validateConsumequantity();
	}
public void checkFunctionalityOfAcceptRequest() {
		
		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnAcceptButton();
		
		
	}
	public void checkFunctionalityOfReplaceRequest() {
		
		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnReplaceButton();
		myProductsPage.enterQuantity();
		myProductsPage.enterReplaceRequestRemarks();
	
		myProductsPage.clickOnConsumeSaveButton();
		myProductsPage.notifyMessageForReplaceRequest();
		
	}
	public void checkFunctionalityOfSelfCheckoutButton() {
		
		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnSelfCheckOutButton();
		myProductsPage.enternumaberofProducts();
		myProductsPage.enterSelfCheckoutRequestRemarks();
	
		myProductsPage.clickOnConsumeSaveButton();
		myProductsPage.notifyMessageForSelfCheckOutRequest();
		
	}
public void checkFunctionalityOfProductTransferButton() {
		
		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnAcceptButton();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnTransferButton();
		myProductsPage.clickOnProductCheckBox();
		myProductsPage.enterTranferProductsQuantity();
	
		myProductsPage.selectlLocation();
		myProductsPage.selectUser();
		myProductsPage.enterTransferRequestRemarks();
		myProductsPage.clickOnConsumeSaveButton();
		myProductsPage.notifyMessageForTransferRequest();
		
	}
	public void checkFunctionalityOfRequestQuantity() {
		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnAcceptButton();
		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
		myProductsPage.clickOnCloseCommunicationPopUp();
		myProductsPage.clickOnActionButton();
		myProductsPage.clickOnRequestQuantity();
		myProductsPage.enterQuantity();
		myProductsPage.enterRequesQuantitytRemarks();
	
		myProductsPage.clickOnConsumeSaveButton();
		//myProductsPage.notifyMessageForReplaceRequest();
		
	}
}
