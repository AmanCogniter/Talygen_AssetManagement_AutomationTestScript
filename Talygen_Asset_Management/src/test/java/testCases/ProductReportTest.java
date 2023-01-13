package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import actions.LoginAction;
import actions.ManageProductAction;
import actions.MyProductsAction;
import actions.ProductReportAction;
import actions.ProductTypeAction;
import utils.WebTestBase;

public class ProductReportTest extends WebTestBase {
	static String Screenname = " <b>Products Report </b>";
	@Test(priority = 1)
	public void validateMandatoryFieldsOfProductAssignmentReport() {
		test = getTest(Screenname + " :validate Mandatory Fields Of Product Assignment Report");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		
		
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateMandatoryFieldsOfProductAssignmentReport();
	}

	@Test(priority = 2)
	public void validateFunctionalityOfProductAssignmentReportWithProductType() {
		test = getTest(Screenname + " :validation Functionality Of Product Assignment Report With Product Type");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);

		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.AddProductType();

		new LoginAction(driver).logoutLogin();
		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPage();
		
		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.VerifyfunctionalityOfCheckAvability();
		
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateProductAssignmentReportWithProductType();
	}
	@Test(priority = 3)
	public void validateFunctionalityOfProductAssignmentReportWithProductName() {
		test = getTest(Screenname + " :validation Functionality Of Product Assignment Report With Product Name");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		/*
		 * ManageProductAction manageProductAction = new ManageProductAction(driver);
		 * ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		 * MyProductsAction myProductsAction = new MyProductsAction(driver);
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * manageProductAction.GoTomanageProductPage();
		 * manageProductAction.addProductPage();
		 * 
		 * new LoginAction(driver).logoutLogin(); myProductsAction.GoTomyProductPage();
		 * myProductsAction.VerifyfunctionalityOfCheckAvability();
		 */
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateProductAssignmentReportWithProductName();
	}
	@Test(priority = 4)
	public void validateFunctionalityOfProductAssignmentReportWithToadyDate() {
		test = getTest(Screenname + " :validation Functionality Of Product Assignment Report With Today Date");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		/*
		 * ManageProductAction manageProductAction = new ManageProductAction(driver);
		 * ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		 * MyProductsAction myProductsAction = new MyProductsAction(driver);
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * manageProductAction.GoTomanageProductPage();
		 * manageProductAction.addProductPage();
		 * 
		 * new LoginAction(driver).logoutLogin(); myProductsAction.GoTomyProductPage();
		 * myProductsAction.VerifyfunctionalityOfCheckAvability();
		 */
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateProductAssignmentReportWithTodayDate();
	}
	@Test(priority = 5)
	public void validatemandatoryFieldsOfAuditLogReport() {
		test = getTest(Screenname + " :Validate mandatory Fields Of Audit Log Report");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		
		 
		 
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateMandatoryFieldsOfAuditLogReport();
	}
	@Test(priority = 6)
	public void validateFunctionalityOfAuditLogReport() {
		test = getTest(Screenname + " :validation Functionality Of Audit Log Report");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		
		  ManageProductAction manageProductAction = new ManageProductAction(driver);
		  ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		  MyProductsAction myProductsAction = new MyProductsAction(driver);
		  
			/*
			 * new LoginAction(driver).logoutLogin();
			 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
			 * 
			 * new LoginAction(driver).logoutLogin();
			 * manageProductAction.GoTomanageProductPage();
			 * manageProductAction.addProductPage();
			 * 
			 * new LoginAction(driver).logoutLogin(); myProductsAction.GoTomyProductPage();
			 * myProductsAction.VerifyfunctionalityOfCheckAvability();
			 */
		 
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validatteAuditLogReportFunctionality();
	}
	@Test(priority = 7)
	public void validateMandatoryFieldsOfProductBarcodeReport() {
		test = getTest(Screenname + " :validate Mandatory Fields Of Product Barcode Report");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		
		  
		 
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateMandatoryFieldsOfProductBarcodeReport();
	}
	@Test(priority = 8)
	public void validateFunctionalityOfProductBarcodeReport() {
		test = getTest(Screenname + " :validation Functionality Of Product Barcode Report");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		
		  ManageProductAction manageProductAction = new ManageProductAction(driver);
		  ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		  MyProductsAction myProductsAction = new MyProductsAction(driver);
		  
			/*
			 * new LoginAction(driver).logoutLogin();
			 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
			 * 
			 * new LoginAction(driver).logoutLogin();
			 * manageProductAction.GoTomanageProductPage();
			 * manageProductAction.addProductPage();
			 */
		  
			/*
			 * new LoginAction(driver).logoutLogin(); myProductsAction.GoTomyProductPage();
			 * myProductsAction.VerifyfunctionalityOfCheckAvability();
			 */
		 
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateProductBarcodeReportFunctionality();
	}
	
	@Test(priority = 9)
	public void validateMandatoryFieldsOfItemLogHistoryReport() {
		test = getTest(Screenname + " :validate Mandatory Fields Of Item Log History Report");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		
		  
		 
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateMandatoryFieldsOfItemLogHistoryReport();
	}
	@Test(priority = 10)
	public void validateFunctionalityOfItemLogHistoryReportWithProductName() {
		test = getTest(Screenname + " :validation Functionality Of Item Log History Report With Product Type");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		/*
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * manageProductAction.GoTomanageProductPage();
		 * manageProductAction.addProductPage();
		 * 
		 * new LoginAction(driver).logoutLogin(); myProductsAction.GoTomyProductPage();
		 * myProductsAction.VerifyfunctionalityOfCheckAvability();
		 */
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateItemLogHistoryReportWithProductName();
	}
	@Test(priority = 11)
	public void validateFunctionalityOfItemLogHistoryReportWithUniqueProductName() {
		test = getTest(Screenname + " :validation Functionality Of Item Log History Report With Unique Product Type");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);

		/*
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * manageProductAction.GoTomanageProductPage();
		 * manageProductAction.addProductPage();
		 * 
		 * new LoginAction(driver).logoutLogin(); myProductsAction.GoTomyProductPage();
		 * myProductsAction.VerifyfunctionalityOfCheckAvability();
		 */
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateItemLogHistoryReportWithUniqueProductName();
	}
	@Test(priority = 12)
	public void validateFunctionalityOfItemLogHistoryReportWithDate() {
		test = getTest(Screenname + " :validation Functionality Of Item Log History Report With Date");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);

		/*
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * manageProductAction.GoTomanageProductPage();
		 * manageProductAction.addProductPage();
		 * 
		 * new LoginAction(driver).logoutLogin(); myProductsAction.GoTomyProductPage();
		 * myProductsAction.VerifyfunctionalityOfCheckAvability();
		 */
		
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateItemLogHistoryReportWithAssignDate();
	}
	@Test(priority = 13)
	public void validateMandatoryFieldsOfProductCountReport() {
		test = getTest(Screenname + " :validate Mandatory Fields Of Product Count Report");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateMandatoryFieldsOfProductCountReport();
	}
	@Test(priority = 14)
	public void validateFunctionalityOfProductCountReportWithProductType() {
		test = getTest(Screenname + " :validation Functionality Of Product Count Report With Product Type");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);

		/*
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * manageProductAction.GoTomanageProductPage();
		 * manageProductAction.addProductPage();
		 * 
		 * new LoginAction(driver).logoutLogin(); myProductsAction.GoTomyProductPage();
		 * myProductsAction.VerifyfunctionalityOfCheckAvability();
		 */
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateProductCountReportWithProductType();
	}
	//@Test(priority = 14)
	public void validateFunctionalityOfProductCountReportWithDeployDate() {
		test = getTest(Screenname + " :validation Functionality Of Product Count Report With Deploy Date");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);

		/*
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * manageProductAction.GoTomanageProductPage();
		 * manageProductAction.addProductPage();
		 * 
		 * new LoginAction(driver).logoutLogin(); myProductsAction.GoTomyProductPage();
		 * myProductsAction.VerifyfunctionalityOfCheckAvability();
		 */
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateProductCountReportWithDeployDate();
	}
	@Test(priority = 15)
	public void validateMandatoryFieldsOfProductReport() {
		test = getTest(Screenname + " :validate Mandatory Fields Of Product Report");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateMandatoryFieldsOfProductReport();
	}
	@Test(priority = 16)
	public void validateFunctionalityOfProductReportWithProductType() {
		test = getTest(Screenname + " :validation Functionality Of Product Count Report With Product Type");
		ProductReportAction productReportAction = new ProductReportAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);

		
		/*
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * manageProductAction.GoTomanageProductPage();
		 * manageProductAction.addProductPage();
		 * 
		 * new LoginAction(driver).logoutLogin(); myProductsAction.GoTomyProductPage();
		 * myProductsAction.VerifyfunctionalityOfCheckAvability();
		 */
		 
		new LoginAction(driver).logoutLogin();
		productReportAction.GoToProductReportPage();
		productReportAction.validateProductReportWithProductType();
	}
}
