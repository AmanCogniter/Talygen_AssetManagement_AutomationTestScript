package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import actions.LoginAction;
import actions.ManageProductAction;
import actions.MyProductsAction;
import actions.ProductTypeAction;
import utils.WebTestBase;

/**
 * 
 * @author aanand
 *
 */
public class MyProductTest extends WebTestBase {
	static String Screenname = " <b> My Products </b>";

	@Test(priority = 1)
	public void validationCheckOfCheckAvabilityFunctionality() {
		test = getTest(Screenname + " :validation Check Of Check Avability Functionality");
		MyProductsAction myProductsAction = new MyProductsAction(driver);

		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.validationcheckOfCheckAvability();
	}

	@Test(priority = 2, enabled = true)
	public void ValidateCheckAvabilityFunctionalityWithProceedToassign() {
		test = getTest(Screenname + " : Validate Check Avability Functionality");
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);

		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.AddProductType();
		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPage();

		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.VerifyfunctionalityOfCheckAvability();
	}

	@Test(priority = 3, dependsOnMethods = { "ValidateCheckAvabilityFunctionality" })
	public void ValidateAssignedProductOnMyProductListPage() {
		test = getTest(Screenname + " :Validate Assigned Product On My Product List Page");
		MyProductsAction myProductsAction = new MyProductsAction(driver);

		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.VerifyProductNameOnMyProductListPage();
	}

	@Test(priority = 4)
	public void validationCheckOfAddCheckOutRequestMandatoryFields() {
		test = getTest(Screenname + " :validation Check Of Add Check Out Request Mandatory Fields");
		MyProductsAction myProductsAction = new MyProductsAction(driver);

		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.validationCheckOfAddCheckOutRequestMandatoryFields();
	}

	@Test(priority = 5)
	public void ValidateFunctionalityOfAddCheckOutRequest() {
		test = getTest(Screenname + " :Validate Functionality Of Add Check Out Request");
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		
		
		/*
		 * ProductTypeAction productTypeAction = new ProductTypeAction(driver); new
		 * LoginAction(driver).logoutLogin(); productTypeAction.GoToProductTypePage();
		 * productTypeAction.AddProductType();
		 */
		 

		new LoginAction(driver).logoutLogin();
		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPage();

		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfAddCheckOutRequest();
	}

	@Test(priority = 6, dependsOnMethods = { "ValidateFunctionalityOfAddCheckOutRequest" })
	public void ValidateFunctionalityOfCheckOutRequestListwithRejection() {
		test = getTest(Screenname + " :Validate Functionality Of Check Out Request List with Rejection");
		MyProductsAction myProductsAction = new MyProductsAction(driver);

		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfCheckOutRequestList();
	}

	// @Test(priority = 7)
	public void ValidateFunctionalityOfSelfAssignment() {
		test = getTest(Screenname + " :Validate Functionality Of Self Assignment");
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		/*
		 * ProductTypeAction productTypeAction = new ProductTypeAction(driver); new
		 * LoginAction(driver).logoutLogin(); productTypeAction.GoToProductTypePage();
		 * productTypeAction.AddProductType();
		 */

		new LoginAction(driver).logoutLogin();
		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPage();

		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfSelfAssignment();
	}
}
