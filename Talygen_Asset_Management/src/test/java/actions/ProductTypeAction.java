package actions;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;

import pageObjects.ProductTypePage;

public class ProductTypeAction {
	WebDriver driver;
	ProductTypePage productTypePage;
	
	public  ProductTypeAction(WebDriver driver)
	{
		this.driver= driver;
		productTypePage = new ProductTypePage(driver);
	}
	
	public void GoToProductTypePage()
	{
		
		productTypePage.clickFullMenuDropDown();
		productTypePage.clickOnAssetManagement();
		productTypePage.clickOnProductType();
	}
	public void ValidationMessageCheckOfAddProductType()
	{
		
		productTypePage.clickOnAddProductType();
		productTypePage.clickOnSaveButton();
		productTypePage.closeNotifyMessagePopUp();
		productTypePage.VerifyMandatoryFieldValidationOfAddProductTypePage();
		productTypePage.clickOnCancelButtonofAddProductType();
	}
	public void ValidationMessageCheckOfImportProductType()
	{
		
		productTypePage.clickOnImportProductType();
		productTypePage.clickOnImportFromExcelFile();
		productTypePage.VerifyMandatoryFieldValidationOfImportProductTypePage();
		productTypePage.clickOnCancel();
	}
	public void ImportProductType() throws EncryptedDocumentException, IOException
	{
		productTypePage.updateExceldata();
		productTypePage.readupdateExceldata();
		productTypePage.clickOnImportProductType();
		productTypePage.uploadDocument();
		productTypePage.clickOnImportFromExcelFile();
		productTypePage.clickOnConfirmationButton();
		productTypePage.clickOnSubmitButton();
		productTypePage.verifyImportProductType();
	}
	public void ValidationOfDeleteFunctionalityForImportProductType()
	{
		
		productTypePage.checkDeleteFunctionality();
		/*
		 * productTypePage.clickOnImportFromExcelFile();
		 * productTypePage.VerifyMandatoryFieldValidationOfImportProductTypePage();
		 * productTypePage.clickOnCancel();
		 */
	}
	public void AddProductType()
	{
		
		productTypePage.clickOnAddProductType();
		productTypePage.EnterProductTypeName();
		productTypePage.uploadimage();
		productTypePage.clickOnResetButton();
		productTypePage.uploadimage();
		productTypePage.EnterDescription();
		productTypePage.clickOnAssetToggleButton();
		productTypePage.clickOnConsumableToggleButton();
		productTypePage.clickOnAddNewTag();
		productTypePage.EnterTagNameTitle();
		productTypePage.clicksaveButtonOfTagNameTitle();
		productTypePage.clickOnIsTransferableToggleButton();
		productTypePage.clickOnEmployAcceptanceToggleButton();
		productTypePage.clickOnSelfCheckoutToggleButton();
		productTypePage.clickOnEnableTermsAndConditionToggleButton();
		productTypePage.clickOnProductCostToggleButton();
		productTypePage.clickOnDepreciableToggleButton();
		productTypePage.clickOnSaveButton();
	}
	public void AddProductTypeWithContainer()
	{
		
		productTypePage.clickOnAddProductType();
		productTypePage.EnterProductTypeName();
		productTypePage.clickOnContainerToggleButton();
		productTypePage.enterCompartmentName();
		productTypePage.uploadimage();
		productTypePage.clickOnResetButton();
		productTypePage.uploadimage();
		productTypePage.EnterDescription();
		productTypePage.clickOnAssetToggleButton();
		productTypePage.clickOnConsumableToggleButton();
		productTypePage.clickOnAddNewTag();
		productTypePage.EnterTagNameTitle();
		productTypePage.clicksaveButtonOfTagNameTitle();
		productTypePage.clickOnIsTransferableToggleButton();
		productTypePage.clickOnSelfCheckoutToggleButton();
		productTypePage.clickOnEmployAcceptanceToggleButton();
		productTypePage.clickOnEnableTermsAndConditionToggleButton();
		productTypePage.clickOnProductCostToggleButton();
		productTypePage.clickOnDepreciableToggleButton();
		productTypePage.clickOnSaveButton();
	}
	public void verifyAddedProduct() {
		productTypePage.checkProductTypename();
		
		
	}
	public void verifyDeleteFunctionalityOfAddProductType() {
		productTypePage.checkDeleteFunctionalityOfAddProductType();
		
		
	}
}
