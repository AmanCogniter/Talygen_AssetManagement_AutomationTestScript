package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import actions.LoginAction;
import actions.NewProductTypeRequestAction;
import actions.ProductTypeAction;
import utils.WebTestBase;

public class NewProductTypeRequestTest extends WebTestBase {
	static String Screenname = " <b>New Product Type Request</b>";

	@Test(priority = 1, enabled = true)
	public void NewProductTypeRequestValidationCheck() {
		test = getTest(Screenname + " : Validation message on Add New Product Type Request screen");
		NewProductTypeRequestAction newProductTypeRequestAction = new NewProductTypeRequestAction(driver);
		new LoginAction(driver).logoutLogin();
		newProductTypeRequestAction.GoToNewProductTypeRequesPage();
		newProductTypeRequestAction.validationCheck();
	}

	@Test(priority = 2)
	public void addNewProductType() {
		test = getTest(Screenname + " : Add New Product Type screen");
		NewProductTypeRequestAction newProductTypeRequestAction = new NewProductTypeRequestAction(driver);
		
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.AddProductType();
		new LoginAction(driver).logoutLogin();
		newProductTypeRequestAction.GoToNewProductTypeRequesPage();
		newProductTypeRequestAction.checkFunctionalityOfRequestNewProductType();
	}

	@Test(priority = 3, dependsOnMethods = { "addNewProductType" })
	public void verifyNewAddeProductTypeInNewProductTypeRequestListPage() {
		test = getTest(Screenname + " : verify New Added Product Type In New Product Type Request List Page screen");
		NewProductTypeRequestAction newProductTypeRequestAction = new NewProductTypeRequestAction(driver);
		new LoginAction(driver).logoutLogin();
		newProductTypeRequestAction.GoToNewProductTypeRequesPage();
		newProductTypeRequestAction.VerifyNewAddedProducttype();
	}
	@Test(priority = 4, dependsOnMethods = { "addNewProductType" })
	public void validateRemoveButtonFunctionality() 
{
		test = getTest(Screenname + " :validate Remove Button Functionality screen");
		NewProductTypeRequestAction newProductTypeRequestAction = new NewProductTypeRequestAction(driver);
		new LoginAction(driver).logoutLogin();
		newProductTypeRequestAction.GoToNewProductTypeRequesPage();
		newProductTypeRequestAction.checkFunctionalityOfRemoveProductType();
	}
	@Test(priority = 5)
	public void validateApproveFunctionalityForNewProductTypeRequest() 
{
		test = getTest(Screenname + " :validate Approve Functionality For New Product Type Request");
		NewProductTypeRequestAction newProductTypeRequestAction = new NewProductTypeRequestAction(driver);
		
		new LoginAction(driver).logoutLogin();
		newProductTypeRequestAction.GoToNewProductTypeRequesPage();
		newProductTypeRequestAction.checkFunctionalityOfRequestNewProductType();
		
		new LoginAction(driver).logoutLogin();
		newProductTypeRequestAction.GoToNewProductTypeRequesPage();
		newProductTypeRequestAction.verifyApproveFunctionality();
	}
	@Test(priority = 6)
	public void validateRejectFunctionalityForNewProductTypeRequest() 
{
		test = getTest(Screenname + " :validate Reject Functionality For New Product Type Request");
		NewProductTypeRequestAction newProductTypeRequestAction = new NewProductTypeRequestAction(driver);
		
		new LoginAction(driver).logoutLogin();
		newProductTypeRequestAction.GoToNewProductTypeRequesPage();
		newProductTypeRequestAction.checkFunctionalityOfRequestNewProductType();
		
		new LoginAction(driver).logoutLogin();
		newProductTypeRequestAction.GoToNewProductTypeRequesPage();
		newProductTypeRequestAction.verifyRejectionFunctionality();
	}
}
