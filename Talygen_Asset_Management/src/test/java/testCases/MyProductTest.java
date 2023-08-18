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

	/* Not working due to change in functionality */
	//@Test(priority = 2, enabled = true)
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
		//myProductsAction.VerifyfunctionalityOfCheckAvability();
		myProductsAction.VerifyfunctionalityOfCheckAvability();
	}

	//@Test(priority = 3)
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

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.AddProductType();

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

	@Test(priority = 8, enabled = true)
	public void VerifyReturnRequestWithApproveFunctionality() {
		test = getTest(Screenname + " :Verify Product Name In Reservation Field");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		/*
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 */
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

	@Test(priority = 9, enabled = true)
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

	@Test(priority = 10, enabled = true)
	public void VerifyActionButtonRejectFunctionality() {
		test = getTest(Screenname + " :Verify Reject Action Button Functionality");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		/*
		 * ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 */

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
		myProductsAction.checkFunctionalityOfRejectActionButton();

	}

	@Test(priority = 11, enabled = true)
	public void VerifyConsumeButtonFunctionality() {
		test = getTest(Screenname + " :check functionality of consume button");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		/*
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 */
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
		myProductsAction.checkFunctionalityOfconsume();

	}

	@Test(priority = 12, enabled = true)
	public void VerifyReplaceRequestwithApproveFunctionality() {
		test = getTest(Screenname + " :check functionality of Replace Request with approve");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		/*
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 * 
		 */
		  new LoginAction(driver).logoutLogin();
		  
		  manageProductAction.GoTomanageProductPage();
		  manageProductAction.addProductPage();
		  
		  new LoginAction(driver).logoutLogin(); myProductsAction.GoTomyProductPage();
		  myProductsAction.checkFunctionalityOfAddCheckOutRequest();
		  
		  new LoginAction(driver).logoutLogin();
		  pendingRequestAction.GoToPendingRequestPage(); pendingRequestAction.
		  VerifyPendingRequestAssignFunctionalityInPendingCheckOutRequestPage();
		 
		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfAcceptRequest();
		myProductsAction.checkFunctionalityOfReplaceRequest();

		new LoginAction(driver).logoutLogin();
		pendingRequestAction.GoToPendingRequestPage();
		pendingRequestAction.VerifyFunctionalityReplaceRequestPagewithApproveFunctionality();

	}
	@Test(priority = 13, enabled = true)
	public void VerifySelfCheckOutFunctionality() {
		test = getTest(Screenname + " :check Self Check Out Functionality Of Action Button");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		/*
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 */
		/*
		 * new LoginAction(driver).logoutLogin();
		 * 
		 * manageProductAction.GoTomanageProductPage();
		 * manageProductAction.addProductPage();
		 * 
		 * new LoginAction(driver).logoutLogin(); myProductsAction.GoTomyProductPage();
		 * myProductsAction.checkFunctionalityOfAddCheckOutRequest();
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * pendingRequestAction.GoToPendingRequestPage(); pendingRequestAction.
		 * VerifyPendingRequestAssignFunctionalityInPendingCheckOutRequestPage();
		 */
		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfSelfCheckoutButton();

		
	}
	@Test(priority = 14, enabled = true)
	public void VerifyProductTransferBUttonFunctionality() {
		test = getTest(Screenname + " :check Product transfer Action Button Functionality");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		
		  new LoginAction(driver).logoutLogin();
		  productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 
		
		  new LoginAction(driver).logoutLogin();
		  
		  manageProductAction.GoTomanageProductPage();
		  manageProductAction.addProductPage();
		  
		  new LoginAction(driver).logoutLogin(); myProductsAction.GoTomyProductPage();
		  myProductsAction.checkFunctionalityOfAddCheckOutRequest();
		  
		  new LoginAction(driver).logoutLogin();
		  pendingRequestAction.GoToPendingRequestPage(); pendingRequestAction.
		  VerifyPendingRequestAssignFunctionalityInPendingCheckOutRequestPage();
		 
		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfProductTransferButton();

		
	}

	// @Test(priority = 15, enabled = true)
	public void VerifyRequestQuantityFunctionality() {
		test = getTest(Screenname + " :check functionality of Request Quantity ");
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
		 */
		new LoginAction(driver).logoutLogin();
		myProductsAction.GoTomyProductPage();
		myProductsAction.checkFunctionalityOfRequestQuantity();

		/*
		 * new LoginAction(driver).logoutLogin();
		 * pendingRequestAction.GoToPendingRequestPage(); pendingRequestAction.
		 * VerifyFunctionalityReplaceRequestPagewithApproveFunctionality();
		 */

	}

	@Test(priority = 16, enabled = true)
	public void VerifyReplaceRequestwithRejectFunctionality() {
		test = getTest(Screenname + " :check functionality of Replace Request with Rejection");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);

		/*
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 */

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
		myProductsAction.checkFunctionalityOfAcceptRequest();
		myProductsAction.checkFunctionalityOfReplaceRequest();

		new LoginAction(driver).logoutLogin();
		pendingRequestAction.GoToPendingRequestPage();
		pendingRequestAction.VerifyFunctionalityReplaceRequestPagewithRejectFunctionality();

	}

	@Test(priority = 17, enabled = true)
	public void VerifyTermsAndConditionFunctionalityOfActionButton() {
		test = getTest(Screenname + " :check Terms And Condition Functionality Of Action Button");
		PendingRequestAction pendingRequestAction = new PendingRequestAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		/*
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 */
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
		myProductsAction.VerifyProductNameOnMyProductListPage();

	}

}
