package actions;

import org.openqa.selenium.WebDriver;

import pageObjects.ProductContainerListPage;
import pageObjects.ProductTypePage;

public class ProductContainerListAction {
	WebDriver driver;
	ProductContainerListPage productContainerListPage;
	
	public  ProductContainerListAction(WebDriver driver)
	{
		this.driver= driver;
		productContainerListPage = new ProductContainerListPage(driver);
	}
	
	public void GoToProductContainerPage()
	{
		
		productContainerListPage.clickFullMenuDropDown();
		productContainerListPage.clickOnAssetManagement();
		productContainerListPage.clickOnProductsContainerList();
	}
	public void ValidationMessageCheckOfAddProductContainerList()
	{
		
		productContainerListPage.clickOnAddProductContainer();
		productContainerListPage.clickOnSaveButton();
		productContainerListPage.VerifyMandatoryFieldValidationOfAddProductTypePage();
		
	}
	public void checkFunctionalityOfAddProductContainer() {

		productContainerListPage.clickOnAddProductContainer();
		productContainerListPage.clickOnSelectProductType();
		productContainerListPage.clickOnSelectLocation();
		productContainerListPage.clickOnSelectProductName();
		productContainerListPage.clickOnSelectContainer();
		productContainerListPage.clickOnSelectCompartments();
		productContainerListPage.clickOnAddNewRowPlusIcon();
		productContainerListPage.clickOnSelectSecondProductName();
		productContainerListPage.clickOnSelectCompartmentsForSecondProduct();
		productContainerListPage.clickOnSaveButton();
		productContainerListPage.captureNotifyMessage();
	}
	public void checkFunctionalityOfActiveButton() {

		productContainerListPage.enterContainerNameInSearchTextField();
		productContainerListPage.clickOnSearch();
		productContainerListPage.clickOnCheckBox();
		productContainerListPage.clickOnActiveButton();
		productContainerListPage.clickOnConfirmationButton();
		productContainerListPage.validateNotifyMessage();
		
	}
	public void checkFunctionalityOfInActiveButton() {

		productContainerListPage.enterContainerNameInSearchTextField();
		productContainerListPage.clickOnSearch();
		productContainerListPage.clickOnCheckBox();
		productContainerListPage.clickOnINActiveButton();
		productContainerListPage.clickOnConfirmationButton();
		productContainerListPage.validateNotifyMessage();
		
	}
	public void checkFunctionalityOfDeleteButton() {

		productContainerListPage.enterContainerNameInSearchTextField();
		productContainerListPage.clickOnSearch();
		productContainerListPage.clickOnCheckBox();
		productContainerListPage.clickOnDeleteeButton();
		productContainerListPage.clickOnConfirmationButton();
		productContainerListPage.validateNotifyMessageForDeleteButton();
		
	}
	public void checkFunctionalityOfRefreshButton() {

		productContainerListPage.enterContainerNameInSearchTextField();
		productContainerListPage.clickOnrefreshButton();
		productContainerListPage.validateNotifyMessageForRefreshButton();
		
		
	}
}
