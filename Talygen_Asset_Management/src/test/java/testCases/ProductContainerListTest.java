package testCases;

import static reporting.ComplexReportFactory.getTest;

import org.testng.annotations.Test;

import actions.LoginAction;
import actions.ManageProductAction;
import actions.MyProductsAction;
import actions.NormalUserLoginAction;
import actions.PendingRequestAction;
import actions.ProductContainerListAction;
import actions.ProductTypeAction;
import utils.WebTestBase;

public class ProductContainerListTest extends WebTestBase {
	static String Screenname = " <b> Product Container List Page </b>";

	@Test(priority = 1)
	public void validateMandatoryFieldsInAddProductContainerPage() {
		test = getTest(Screenname + " :validate Mandatory Fields In Add Product Container List page");
		ProductContainerListAction productContainerListAction = new ProductContainerListAction(driver);

		new LoginAction(driver).logoutLogin();
		productContainerListAction.GoToProductContainerPage();
		productContainerListAction.ValidationMessageCheckOfAddProductContainerList();
	}

	@Test(priority = 2)
	public void VerifyFunctionalityOfAddProductContainer() {
		test = getTest(Screenname + " :Verify Functionality Of Add Product Container");
		ProductContainerListAction productContainerListAction = new ProductContainerListAction(driver);
		MyProductsAction myProductsAction = new MyProductsAction(driver);
		ManageProductAction manageProductAction = new ManageProductAction(driver);

		ProductTypeAction productTypeAction = new ProductTypeAction(driver);

		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.AddProductTypeWithContainer();

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPage();

		new LoginAction(driver).logoutLogin();
		productContainerListAction.GoToProductContainerPage();
		productContainerListAction.checkFunctionalityOfAddProductContainer();

	}
	@Test(priority = 3, dependsOnMethods = { "VerifyFunctionalityOfAddProductContainer" } )
	public void VerifyFunctionalityOfRefreshButton() {
		test = getTest(Screenname + " :Verify Functionality Of Refresh Button");
		ProductContainerListAction productContainerListAction = new ProductContainerListAction(driver);

		new LoginAction(driver).logoutLogin();
		productContainerListAction.GoToProductContainerPage();
		productContainerListAction.checkFunctionalityOfRefreshButton();

	}
	@Test(priority = 4, dependsOnMethods = { "VerifyFunctionalityOfAddProductContainer" } )
	public void VerifyFunctionalityOfInActiveButton() {
		test = getTest(Screenname + " :Verify Functionality Of InActive Button");
		ProductContainerListAction productContainerListAction = new ProductContainerListAction(driver);

		new LoginAction(driver).logoutLogin();
		productContainerListAction.GoToProductContainerPage();
		productContainerListAction.checkFunctionalityOfInActiveButton();

	}

	@Test(priority = 5 , dependsOnMethods = { "VerifyFunctionalityOfInActiveButton" })
	public void VerifyFunctionalityOfActiveButton() {
		test = getTest(Screenname + " :Verify Functionality Of Active Button");
		ProductContainerListAction productContainerListAction = new ProductContainerListAction(driver);

		new LoginAction(driver).logoutLogin();
		productContainerListAction.GoToProductContainerPage();
		productContainerListAction.checkFunctionalityOfActiveButton();

	}
	@Test(priority = 6 , dependsOnMethods = { "VerifyFunctionalityOfInActiveButton" })
	public void VerifyFunctionalityOfDeleteButton() {
		test = getTest(Screenname + " :Verify Functionality Of Delete Button");
		ProductContainerListAction productContainerListAction = new ProductContainerListAction(driver);

		new LoginAction(driver).logoutLogin();
		productContainerListAction.GoToProductContainerPage();
		productContainerListAction.checkFunctionalityOfDeleteButton();

	}
}
