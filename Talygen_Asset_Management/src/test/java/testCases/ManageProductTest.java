package testCases;

import static reporting.ComplexReportFactory.getTest;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import actions.LoginAction;
import actions.ManageProductAction;
import actions.ProductTypeAction;
import utils.WebTestBase;

/**
 * 
 * @author aanand
 *
 */
public class ManageProductTest extends WebTestBase {
	static String Screenname = " <b> Manage Product </b>";

	@Test(priority = 1, enabled = true)
	public void AddProductValidationCheck() {
		test = getTest(Screenname + " : Validation message on Add Product");
		ManageProductAction manageProductAction = new ManageProductAction(driver);
		new LoginAction(driver).logoutLogin();
		manageProductAction.GoTomanageProductPage();
		manageProductAction.ValidationMessageCheckOfAddProduct();
	}

	@Test(priority = 2)
	public void AddProduct() {
		test = getTest(Screenname + " : Add Product");

		ManageProductAction manageProductAction = new ManageProductAction(driver);
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.AddProductType();

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPage();
	}

	@Test(priority = 3)
	public void ValidateandDeleteAddedProduct() {
		test = getTest(Screenname + " : Validate and Delete Added Product");

		ManageProductAction manageProductAction = new ManageProductAction(driver);

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.SearchandDeleteaddedProduct();
	}

	@Test(priority = 4)
	public void AddProductwithCreateuniquenamelisting() {
		test = getTest(Screenname + " : Add Product with Create unique name listing");

		ManageProductAction manageProductAction = new ManageProductAction(driver);

		/*
		 * ProductTypeAction productTypeAction = new ProductTypeAction(driver); new
		 * LoginAction(driver).logoutLogin(); productTypeAction.GoToProductTypePage();
		 * productTypeAction.AddProductType();
		 */

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPagewithCreateuniquenamelisting();
	}

	@Test(priority = 5)
	public void ValidateandDeleteAddedProductwithCreateuniquenamelisting() {
		test = getTest(Screenname + " : Validate and Delete Added Product with Create unique name listing");

		ManageProductAction manageProductAction = new ManageProductAction(driver);

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.SearchandDeleteaddedProduct();
	}

	@Test(priority = 6)
	public void ValidateFunctionalityOfProductTransferButton() {
		test = getTest(Screenname + " : Validate Functionality Of Product Transfer Button");

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
		manageProductAction.productTransferFromOneLocationToAnother();
	}

	@Test(priority = 7)
	public void ValidateFunctionalityOfInTransitProductPageWithRejection() {
		test = getTest(
				Screenname + " : Validate Functionality Of In Transit Product Page with Rejection functionality");

		ManageProductAction manageProductAction = new ManageProductAction(driver);

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.VerifyInTransitProductPageWithRejection();
	}

	@Test(priority = 8)
	public void ValidateRejectedProductInTransferredListPage() {
		test = getTest(Screenname + " :Validate Rejected Product In Transferred List Page");

		ManageProductAction manageProductAction = new ManageProductAction(driver);

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.VerifyproductInTransferredListPage();
	}

	@Test(priority = 9)
	public void ValidateFunctionalityOfInTransitProductPageWithAccept() {
		test = getTest(Screenname + " : Validate Functionality Of In Transit Product Page with Accept functionality");

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
		manageProductAction.productTransferFromOneLocationToAnother();

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.VerifyInTransitProductPageWithAccept();
	}

	@Test(priority = 10)
	public void ValidateAcceptProductInTransferredListPage() {
		test = getTest(Screenname + " :Validate Accepted Product In Transferred List Page");

		ManageProductAction manageProductAction = new ManageProductAction(driver);

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.VerifyproductInTransferredListPage();
	}

	@Test(priority = 11)
	public void ValidateUpdatedProduct() {
		test = getTest(Screenname + " : Validate Updated Product");

		ManageProductAction manageProductAction = new ManageProductAction(driver);

		
		  ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		  
		  new LoginAction(driver).logoutLogin();
		  productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPage();

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.updateProduct();
	}

	@Test(priority = 12, dependsOnMethods = { "ValidateUpdatedProduct" })
	public void ValidateDepreciationFunctionality() {
		test = getTest(Screenname + " :Validate Depreciation Functionality");

		ManageProductAction manageProductAction = new ManageProductAction(driver);

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.VerifyDepreciation();
	}

	@Test(priority = 13)
	public void ValidateAddRelationshipFunctionality() {
		test = getTest(Screenname + " : Validate Add Relationship Functionality");

		ManageProductAction manageProductAction = new ManageProductAction(driver);

		/*
		 * ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		 * 
		 * new LoginAction(driver).logoutLogin();
		 * productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 * 
		 */

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPage();

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.VerifyfunctionalityOfAddrelationship();
	}

	@Test(priority = 14)
	public void ValidateCheckAvabilityFunctionalityWithProductCheckOut() throws AWTException {
		test = getTest(Screenname + " : Validate Check Avability Functionality");

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

		manageProductAction.GoTomanageProductPage();
		manageProductAction.VerifyfunctionalityOfCheckAvability();
	}

	@Test(priority = 15)
	public void ValidateCheckAvabilityFunctionalityWithRejection() throws AWTException {
		test = getTest(Screenname + " : Validate Check Avability Functionality");

		ManageProductAction manageProductAction = new ManageProductAction(driver);

		
		  ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		  
		  new LoginAction(driver).logoutLogin();
		  productTypeAction.GoToProductTypePage(); productTypeAction.AddProductType();
		 

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.addProductPage();

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.VerifyfunctionalityOfCheckAvabilityWithRejection();
	}

	@Test(priority = 16)
	public void ValidateImportProductFunctionality() throws EncryptedDocumentException, IOException {
		test = getTest(Screenname + " : Validate Import Product Functionality");

		ManageProductAction manageProductAction = new ManageProductAction(driver);

		new LoginAction(driver).logoutLogin();

		manageProductAction.GoTomanageProductPage();
		manageProductAction.VerifyfunctionalityOfImportProductButton();
	}
}
