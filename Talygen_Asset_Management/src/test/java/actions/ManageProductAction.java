package actions;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import pageObjects.ManageProductPage;
import pageObjects.MyProductsPage;
import pageObjects.ProductTypePage;

public class ManageProductAction {
	WebDriver driver;
	ManageProductPage manageProductPage;
	MyProductsPage myProductsPage;
	public  ManageProductAction(WebDriver driver)
	{
		this.driver= driver;
		manageProductPage = new ManageProductPage(driver);
		myProductsPage = new MyProductsPage(driver);
	}
	
	public void GoTomanageProductPage()
	{
		
		manageProductPage.clickFullMenuDropDown();
		manageProductPage.clickOnAssetManagement();
		manageProductPage.clickOnManageProduct();
	}
	public void ValidationMessageCheckOfAddProduct()
	{
		manageProductPage.clickOnAddProduct();
		manageProductPage.clickOnsaveAndClose();
		manageProductPage.VerifyMandatoryFieldValidationOfAddProductPage();
		}
	public void addProductPage()
	{
		
		manageProductPage.clickOnAddProduct();
		//manageProductPage.clickOnAddProductTypeActionButton();
		manageProductPage.clickOnSelectProductTypeName();
		manageProductPage.enterProductName();
		manageProductPage.clickOnSelectBarCode();
		manageProductPage.uploadimage();
		manageProductPage.clickOndeployproducttogglebutton();
		manageProductPage.clickOnSelectLocation();
		manageProductPage.enterQuantity();
		manageProductPage.enterUnitPrice();
		manageProductPage.clickOnsaveAndClose();
		
	}
	public void SearchandDeleteaddedProduct()
	{
		
		//manageProductPage.clickOnExpandSearchField();
		//manageProductPage.clickOnAddProductTypeActionButton();
		manageProductPage.enterproductnameInSearchField();
		manageProductPage.clickOnSearchbutton();
		manageProductPage.clickOncheckBox();
		manageProductPage.clickOnDeleteButton();
		manageProductPage.clickOnConfirmationButton();
		
		
	}
	public void addProductPagewithCreateuniquenamelisting()
	{
		
		manageProductPage.clickOnAddProduct();

		manageProductPage.clickOnSelectProductTypeName();
		manageProductPage.enterProductName();
		manageProductPage.clickOnSelectBarCode();
		manageProductPage.clickOnCreateUniquenameListing();
		manageProductPage.uploadimage();
		manageProductPage.clickOndeployproducttogglebutton();
		manageProductPage.clickOnSelectLocation();
		manageProductPage.enterQuantity();
		manageProductPage.enterUnitPrice();
		manageProductPage.clickOnsaveAndClose();
		
	}
	public void productTransferFromOneLocationToAnother()
	{
		
		manageProductPage.clickOnProductTransfer();
		manageProductPage.clickOnSelectFromLocation();
		manageProductPage.clickOnSelectProductType();
		manageProductPage.clickOnSelectProductName();
		manageProductPage.clickOnenterProductName();
		manageProductPage.clickOnsearchButton();
		manageProductPage.clickOnCheckBox();
		manageProductPage.clickOnentertransferQuantity();
		manageProductPage.clickOnAddToList();
		manageProductPage.clickOnSelectToLocation();
		manageProductPage.clickOnenterdescription();
		manageProductPage.clickOnenterComment();
		manageProductPage.clickOnSaveButton();
		manageProductPage.successfullmessagepopup();
		
		
		
	}
	public void VerifyInTransitProductPageWithRejection()
	{
		
		manageProductPage.clickOnInTransitProducts();
		manageProductPage.clickOnIntransitProductsExpandabdCollapseButton();
		manageProductPage.clickOnSelectFromLocation();
		manageProductPage.clickOnSelectToLocation();
		manageProductPage.clickOnSearchButton();
		manageProductPage.clickOnCheckBox();
		
		  manageProductPage.clickOnAcceptOrRejectButton();
		  manageProductPage.clickOnCheckBoxOfInTransitProduct();
		  manageProductPage.clickOnRejectAllButton(); 
		  manageProductPage.clickOnSaveButtonOfInTransitProducts();
		  }
	public void VerifyproductInTransferredListPage()
	{
		
		
		  manageProductPage.clickOnTransferList();
		  //manageProductPage.clickOnIntransitProductsExpandabdCollapseButton();
		  manageProductPage.clickOnSearchByProductName();
		  manageProductPage.enterProductNameInsearchField();
			 
		  manageProductPage.clickOnSearchButton();
		  manageProductPage.verifyproductinlistingpage();
		
		
	}
	public void VerifyInTransitProductPageWithAccept()
	{
		
		manageProductPage.clickOnInTransitProducts();
		manageProductPage.clickOnIntransitProductsExpandabdCollapseButton();
		manageProductPage.clickOnSelectFromLocation();
		manageProductPage.clickOnSelectToLocation();
		manageProductPage.clickOnSearchButton();
		manageProductPage.clickOnCheckBox();
		
		  manageProductPage.clickOnAcceptOrRejectButton();
		  manageProductPage.clickOnCheckBoxOfInTransitProduct();
		  //manageProductPage.clickOnRejectAllButton(); 
		  manageProductPage.clickOnSaveButtonOfInTransitProducts();
		 	
	}
	public void updateProduct()
	{
		
		//manageProductPage.clickOnExpandSearchField();
		manageProductPage.enterproductnameInSearchField();
		manageProductPage.clickOnSearchbutton();
		//manageProductPage.clickOnProduct();// 1st way to go to update product
		manageProductPage.clickOncloseChatpopup();/* 2 nd way to update product details */
		manageProductPage.clickOnActionButton(); /* 2 nd way to update product details */
		manageProductPage.clickOnEditButton(); /* 2 nd way to update product details */
		manageProductPage.clickOnDeployProduct();
		manageProductPage.clickOnLocation();
		
		  manageProductPage.clickOnSelectDepreciationRule();
		  manageProductPage.enterProductLiffe();
		  manageProductPage.clickOnSaveButtonOfDeployProducts(); 
		  manageProductPage.notifymessageForDeployProducts();
		  manageProductPage.clickOnAttachment();
		  manageProductPage.enterAttachmentName();
		  manageProductPage.uploadimageInAttachmentPage();
		  manageProductPage.clickOnSaveButtonOfEditedproduct();
		  manageProductPage.notifymessageForUpdatedProducts();
		  
	}
	public void VerifyDepreciation()
	{
		
		manageProductPage.clickOndepreciation();
		manageProductPage.clickOnExpandSearchField();
		manageProductPage.enterproductnameIndepreciationSearchField();
		manageProductPage.clickOnDepreciationSearchbutton();	 	
	}
	public void VerifyfunctionalityOfAddrelationship()
	{
		
		manageProductPage.clickOnAddRelation();
		manageProductPage.clickOnSearchByProduct();
		manageProductPage.clickOnSelectProductName();
		manageProductPage.clickOnSearchButtonOfAddRelation();
		manageProductPage.clickOnSelectPairedProduct();
		manageProductPage.clickOnCheckOutToggleButton();
		manageProductPage.clickOnAddMoreProductButton();
		manageProductPage.clickOnDeleteAddedMoreProductButton();
		manageProductPage.clickOnSaveAddRelationship();
		manageProductPage.captureNotifyMessageOfAddRelationship();
		/* verify on Product list page */
		//manageProductPage.clickOnExpandSearchField();
		manageProductPage.enterproductnameInSearchField();
		manageProductPage.clickOnSearchbutton();
		manageProductPage.verifyAddRelationShipProductInProductListpage();
		manageProductPage.clickOnRelatedProduct();
		manageProductPage.verifyRelatedProduct();
		manageProductPage.clickOnCloseButton();
	}
	
	public void VerifyfunctionalityOfCheckAvability() throws AWTException
	{
		
		manageProductPage.clickOnCheckAvabilityButton();
		manageProductPage.clickOnSearchByProductRadioButton();
		manageProductPage.clickOnSelectProductName();
		manageProductPage.selecttomorrowDate();
		manageProductPage.clickOnCheckAvability();
		manageProductPage.CheckProductAvabilityAndQuantity();
		manageProductPage.clickOnProductAvaibilityCheckBox();
		manageProductPage.clickOnProceedToCheckOut();
		
		
		/* ----------------------------------------------------*/	
		myProductsPage.clickOnAddProduct();
		  myProductsPage.clickOnSelectProductType();
		  myProductsPage.clickOnSelectProductName();
		 // myProductsPage.clickOnSelectItem(); 
		  //myProductsPage.clickOnSearch();
		  myProductsPage.clickOnClose();
		  myProductsPage.clickOnTermsAndCondition();
		  /*      ----------------------------------------------------			 */
		//manageProductPage.clickOnTermsAndConditionCheckBox();
		manageProductPage.clickOnSaveButtonOfNewCheckOutPage();
		manageProductPage.clickOnExpandOrCollapseAllSearchField();
	
		manageProductPage.enterProductNameInsearchFieldOfCheckOutList();
		manageProductPage.clickOnSearchbuttonOfCheckOutList();
		
	}
	public void VerifyfunctionalityOfCheckAvabilityWithRejection() throws AWTException
	{
		
		manageProductPage.clickOnCheckAvabilityButton();
		manageProductPage.clickOnSearchByProductRadioButton();
		manageProductPage.clickOnSelectProductName();
		manageProductPage.selecttomorrowDate();
		manageProductPage.clickOnCheckAvability();
		manageProductPage.CheckProductAvabilityAndQuantity();
		manageProductPage.clickOnProductAvaibilityCheckBox();
		manageProductPage.clickOnProceedToCheckOut();
		manageProductPage.clickOnTermsAndConditionCheckBox();
		manageProductPage.clickOnSaveButtonOfNewCheckOutPage();
		manageProductPage.clickOnExpandOrCollapseAllSearchField();
	
		manageProductPage.enterProductNameInsearchFieldOfCheckOutList();
		manageProductPage.clickOnSearchbuttonOfCheckOutList();
		manageProductPage.clickOnRejectButton();
		
	}
	public void VerifyfunctionalityOfImportProductButton() throws EncryptedDocumentException, IOException
	{
		
		manageProductPage.clickOnImportButton();
		manageProductPage.updateExceldata();
		manageProductPage.readupdateExceldata();
		manageProductPage.uploadDocument();
		manageProductPage.clickOnImportFromExcelFile();
		manageProductPage.clickOnConfirmationButtonForImportProduct();
		manageProductPage.clickOnSubmitButton();
		manageProductPage.verifyImportProductType();
		
		
	}
}
