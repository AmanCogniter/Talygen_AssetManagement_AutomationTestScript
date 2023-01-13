package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import actions.LoginAction;
import actions.ManageProductAction;
import actions.MyProductsAction;
import actions.PendingRequestAction;
import actions.ProductTypeAction;
import utils.WebTestBase;

public class PendingRequestTest extends WebTestBase {
	static String Screenname = " <b>Pending request</b>";

	@Test(priority = 1, enabled = true)
	public void verifyPendingRequest() {
		test = getTest(Screenname + " :Verify Pending Request");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);

		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);

		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.AddProductType();

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPage();

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.VerifyfunctionalityOfCheckAvability();
		new LoginAction(driver).logoutLogin();
		pendingRequestAction.GoToPendingRequestPage();
		pendingRequestAction.VerifyPendingRequestInPendingCheckOutRequestPage();
	}
	@Test(priority = 2, enabled = true)
	public void verifyProductNameInReservationField() {
		test = getTest(Screenname + " :Verify Product Name In Reservation Field");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);

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
		 * new LoginAction(driver).logoutLogin();
		 * 
		 * manageProductAction.GoTomanageProductPage();
		 * manageProductAction.VerifyfunctionalityOfCheckAvability();
		 */
		new LoginAction(driver).logoutLogin();
		pendingRequestAction.GoToPendingRequestPage();
		pendingRequestAction.VerifyPendingRequestInReservationPage();
	}
	@Test(priority = 3, enabled = true)
	public void VerifyReturnRequestWithApproveFunctionality() {
		test = getTest(Screenname + " :Verify Product Name In Reservation Field");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);

		
		  new LoginAction(driver).logoutLogin();
		  productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		  
		  new LoginAction(driver).logoutLogin();
		  
		  manageProductAction.GoTomanageProductPage();
		  manageProductAction.addProductPage();
		  
			
		 
		
		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfAddCheckOutRequest();
		
		new LoginAction(driver).logoutLogin();
		pendingRequestAction.GoToPendingRequestPage();
		pendingRequestAction.VerifyPendingRequestAssignFunctionalityInPendingCheckOutRequestPage();
		
		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfReturn();
		
		new LoginAction(driver).logoutLogin();
		pendingRequestAction.GoToPendingRequestPage();
		pendingRequestAction.VerifyFunctionalityReturnrequestPagewithApproveFunctionality();
	}
	@Test(priority = 4, enabled = true)
	public void VerifyReturnRequestWithRejectFunctionality() {
		test = getTest(Screenname + " :Verify Product Name In Reservation Field");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);

		
		  new LoginAction(driver).logoutLogin();
		  productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		  
		  new LoginAction(driver).logoutLogin();
		  
		  manageProductAction.GoTomanageProductPage();
		  manageProductAction.addProductPage();
		  
			
		 
		
		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfAddCheckOutRequest();
		
		new LoginAction(driver).logoutLogin();
		pendingRequestAction.GoToPendingRequestPage();
		pendingRequestAction.VerifyPendingRequestAssignFunctionalityInPendingCheckOutRequestPage();
		
		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfReturn();
		
		new LoginAction(driver).logoutLogin();
		pendingRequestAction.GoToPendingRequestPage();
		pendingRequestAction.VerifyFunctionalityReturnrequestPagewithRejetcFunctionality();
	}
}
