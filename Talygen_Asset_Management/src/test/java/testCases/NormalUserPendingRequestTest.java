package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import actions.LoginAction;
import actions.ManageProductAction;
import actions.MyProductsAction;
import actions.NormalUserLoginAction;
import actions.PendingRequestAction;
import actions.ProductTypeAction;
import utils.WebTestBase;

public class NormalUserPendingRequestTest extends WebTestBase {
	static String Screenname = " <b>Normal User Pending request</b>";

	@Test(priority = 1)
	public void VerifyNormalUserAssignedProduct() {
		test = getTest(Screenname + " :Verify Normal User Assigned Product");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);

		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.AddProductType();

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPage();

		new NormalUserLoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfAddCheckOutRequest();

		new LoginAction(driver).logoutLogin();
		pendingRequestAction.GoToPendingRequestPage();
		pendingRequestAction.VerifyPendingRequestAssignFunctionalityInPendingCheckOutRequestPage();

		new NormalUserLoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkassignedProductInMyProductListPage();

		/*
		 * new NormalUserLoginAction(driver).logoutLogin();
		 * myProductsAction.GoTomyProductPage();
		 * myProductsAction.checkFunctionalityOfReturn();
		 * 
		 * new NormalUserLoginAction(driver).logoutLogin();
		 * pendingRequestAction.GoToPendingRequestPage(); pendingRequestAction.
		 * VerifyFunctionalityReturnrequestPagewithApproveFunctionality();
		 */
	}

	@Test(priority = 2, enabled = true)
	public void VerifyReturnRequestWithApproveFunctionality() {
		test = getTest(Screenname + " :Verify Product Name In Reservation Field");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		/*
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * 
		 * manageProductAction.GoTomanageProductPage();
		 * manageProductAction.addProductPage();
		 * 
		 * new NormalUserLoginAction(driver).logoutLogin();
		 * myProductsAction.GoTomyProductPage();
		 * myProductsAction.checkFunctionalityOfAddCheckOutRequest();
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * pendingRequestAction.GoToPendingRequestPage(); pendingRequestAction.
		 * VerifyPendingRequestAssignFunctionalityInPendingCheckOutRequestPage();
		 * 
		 */
		new NormalUserLoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfReturn();

		new LoginAction(driver).logoutLogin();
		pendingRequestAction.GoToPendingRequestPage();
		pendingRequestAction.VerifyFunctionalityReturnrequestPagewithApproveFunctionality();
	}

	@Test(priority = 3, enabled = true)
	public void VerifyReturnRequestWithRejectFunctionality() {
		test = getTest(Screenname + " :Verify Product Name In Reservation Field");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);

		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.AddProductType();

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPage();

		new NormalUserLoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfAddCheckOutRequest();

		new LoginAction(driver).logoutLogin();
		pendingRequestAction.GoToPendingRequestPage();
		pendingRequestAction.VerifyPendingRequestAssignFunctionalityInPendingCheckOutRequestPage();

		new NormalUserLoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfReturn();

		new LoginAction(driver).logoutLogin();
		pendingRequestAction.GoToPendingRequestPage();
		pendingRequestAction.VerifyFunctionalityReturnrequestPagewithRejetcFunctionality();
	}
	@Test(priority = 4, enabled = true)
	public void ValidateCheckAvabilityFunctionalityWithProceedTocheckOut() {
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

		new NormalUserLoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.VerifyfunctionalityOfCheckAvabilityForNormalUser();
	}
	@Test(priority = 5, enabled = true)
	public void ValidateFunctionalityOfAddCheckOutRequestFromCheckOutListPage() {
		test = getTest(Screenname + " : Validate Functionality Of Add Check Out Request From Check Out List Page");
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);

		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.AddProductType();
		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPage();

		new NormalUserLoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfAddCheckOutRequestFromCheckOutListPage();
	}
	
	

}
