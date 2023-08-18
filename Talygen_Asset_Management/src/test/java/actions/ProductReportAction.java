package actions;

import org.openqa.selenium.WebDriver;

import pageObjects.ManageProductPage;
import pageObjects.MyProductsPage;
import pageObjects.ProductReportPage;

public class ProductReportAction {
	WebDriver driver;
	ProductReportPage productReportPage;
	

	public ProductReportAction(WebDriver driver) {
		this.driver = driver;
		productReportPage = new ProductReportPage(driver);
		
	}

	public void GoToProductReportPage() {

		productReportPage.clickFullMenuDropDown();
		productReportPage.clickOnAssetManagement();
		productReportPage.clickOnProductReport();
	}
	public void validateMandatoryFieldsOfProductAssignmentReport() {

		productReportPage.clickOnProductAssignmentReport();
		productReportPage.clickOnSearch();
		productReportPage.VerifyMandatoryFieldValidationOfProductAssignmentReport();
		
		
	}
	public void validateProductAssignmentReportWithProductType() {

		productReportPage.clickOnProductAssignmentReport();
		productReportPage.clickOnLocationDropDown();
		productReportPage.clickOnLocation();
		productReportPage.selectProductType();
		productReportPage.clickOnSearch();
		productReportPage.validateProjectReport();
		productReportPage.validateProjectNameInReport();
		
	}
	public void validateProductAssignmentReportWithProductName() {

		productReportPage.clickOnProductAssignmentReport();
		productReportPage.clickOnLocationDropDown();
		productReportPage.clickOnLocation();
		productReportPage.selectProductType();
		productReportPage.selectProductName();
		productReportPage.clickOnSearch();
		productReportPage.validateProjectReport();
		productReportPage.validateProjectNameInReport();
		
	}
	public void validateProductAssignmentReportWithTodayDate() {

		productReportPage.clickOnProductAssignmentReport();
		productReportPage.clickOnLocationDropDown();
		productReportPage.clickOnLocation();
		productReportPage.selectProductType();
		productReportPage.selectProductName();
		productReportPage.selectTodaydate();
		productReportPage.clickOnSearch();
		productReportPage.validateProjectReport();
		//productReportPage.validateProjectNameInReport();
		
	}
	/*--------------------------------------------------------------Audit Log report------------------------------------------------------------*/
	public void validateMandatoryFieldsOfAuditLogReport() {

		productReportPage.clickOnAuditLogReport();
		productReportPage.clickOnSearch();
		productReportPage.VerifyMandatoryFieldValidationOfAuditLogReport();
		
		
	}
	public void validatteAuditLogReportFunctionality() {

		productReportPage.clickOnAuditLogReport();
		productReportPage.clickOnLocationDropDown();
		productReportPage.clickOnLocation();
		productReportPage.selectProductNameForAuditLogReport();
		productReportPage.clickOnSearch();
		productReportPage.validateAuditLogReport();
		
		}
	/*--------------------------------------------------------------Product Barcode Report------------------------------------------------------------*/
	public void validateMandatoryFieldsOfProductBarcodeReport() {

		productReportPage.clickOnProductBarcodeReport();
		productReportPage.clickOnSearch();
		productReportPage.VerifyMandatoryFieldValidationOfAuditLogReport();
		
		
	}
	public void validateProductBarcodeReportFunctionality() {

		productReportPage.clickOnProductBarcodeReport();
		productReportPage.selectProductNameForAuditLogReport();
		productReportPage.clickOnLocationDropDown();
		productReportPage.clickOnLocation();
		
		productReportPage.clickOnSearch();
		productReportPage.validateProductBarcodeReport();
		productReportPage.validateProjectNameInProductBarcodeReport();
		
		}
	
	/*--------------------------------------------------------------Item Log History Report------------------------------------------------------------*/
	public void validateMandatoryFieldsOfItemLogHistoryReport() {

		productReportPage.clickOnItemLogHistoryReport();
		productReportPage.clickOnSearch();
		productReportPage.VerifyMandatoryFieldOfItemLogHistoryReport();
		
		
	}
	public void validateItemLogHistoryReportWithProductName() {

		productReportPage.clickOnItemLogHistoryReport();
		productReportPage.clickOnLocationDropDown();
		productReportPage.clickOnLocation();
		productReportPage.selectProductName();
		productReportPage.clickOnSearch();
		productReportPage.validateItemLogHistoryReport();
		productReportPage.validateItemInItemLogHistoryReport();
		
	}
	public void validateItemLogHistoryReportWithUniqueProductName() {

		productReportPage.clickOnItemLogHistoryReport();
		productReportPage.clickOnLocationDropDown();
		productReportPage.clickOnLocation();
		productReportPage.selectProductName();
		productReportPage.selectUniqueProductName();
		productReportPage.clickOnSearch();
		productReportPage.validateItemLogHistoryReport();
		productReportPage.validateItemInItemLogHistoryReport();
		
	}
	public void validateItemLogHistoryReportWithAssignDate() {

		productReportPage.clickOnItemLogHistoryReport();
		productReportPage.clickOnLocationDropDown();
		productReportPage.clickOnLocation();
		productReportPage.selectProductName();
		productReportPage.selectUniqueProductName();
		productReportPage.selectTodaydateOfItemLogHistoryReport();
		productReportPage.clickOnSearch();
		productReportPage.validateItemLogHistoryReport();
		//productReportPage.validateItemInItemLogHistoryReportWithAssignDate();
		
	}
	/*--------------------------------------------------------------Product Count Report------------------------------------------------------------*/
	public void validateMandatoryFieldsOfProductCountReport() {

		productReportPage.clickOnProductCountReport();
		productReportPage.clickOnSearch();
		productReportPage.VerifyMandatoryFieldOfProductCountReport();
		
		
	}
	public void validateProductCountReportWithProductType() {

		productReportPage.clickOnProductCountReport();
		productReportPage.clickOnLocationOfProductCountReport();
		
		productReportPage.selectProductTypeForProductCountReport();
		productReportPage.clickOnSearch();
		productReportPage.validateProjectReportOfCountReport();
		//productReportPage.validateProjectNameInReport();
		
	}
	public void validateProductCountReportWithDeployDate() {

		productReportPage.clickOnProductCountReport();
		productReportPage.clickOnLocationOfProductCountReport();
		
		productReportPage.selectProductTypeForProductCountReport();
		productReportPage.selectUniqueProductName();
		productReportPage.selectTodaydateOfProductCountReport();
		productReportPage.clickOnSearch();
		productReportPage.validateItemLogHistoryReport();
		productReportPage.validateItemInItemLogHistoryReportWithAssignDate();
		
	}
	/*--------------------------------------------------------------Product Report------------------------------------------------------------*/
	public void validateMandatoryFieldsOfProductReport() {

		productReportPage.clickOnProductReports();
		productReportPage.clickOnSearch();
		productReportPage.VerifyMandatoryFieldOfProductReport();
		
		
	}
	public void validateProductReportWithProductType() {

		productReportPage.clickOnProductReports();
		//productReportPage.selectProductTypeForProductReport();
		productReportPage.selectTagTypeForProductReport();
		productReportPage.clickOnLocationOfProductCountReport();
		
		productReportPage.clickOnSearch();
		productReportPage.validateProjectReports();
		productReportPage.validateProjectNameInProjectReport();
		
	}
	public void pageRefresh() {
		productReportPage.pagerefresh();
	}
}
