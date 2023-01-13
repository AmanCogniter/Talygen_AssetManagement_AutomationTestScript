package actions;

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
	public void VerifyfunctionalityOfCheckAvabilityForNormalUser() {

		myProductsPage.clickOnCheckAvailability();
		manageProductPage.clickOnSearchByProductRadioButton();
		manageProductPage.clickOnSelectProductName();
		manageProductPage.clickOnCheckAvability();
		manageProductPage.CheckProductAvabilityAndQuantity();
		manageProductPage.clickOnProductAvaibilityCheckBox();
		myProductsPage.clickOnProceedToCheckOut();

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
		myProductsPage.clickOnReturnButton();
		myProductsPage.selectReason();
		myProductsPage.enterQuantity();
		myProductsPage.clickOnSubmitButton();
		myProductsPage.notifyMessage();
	}
	public void checkassignedProductInMyProductListPage() {

		myProductsPage.enterproductnameInSelfAssignmentSearchField();
		myProductsPage.clickOnSearchButtonOfSelfAssignment();
		myProductsPage.verifyProductNameInMyProductListPage();
	}
}
