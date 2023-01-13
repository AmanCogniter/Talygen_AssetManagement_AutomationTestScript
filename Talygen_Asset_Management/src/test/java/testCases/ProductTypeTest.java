package testCases;

import static reporting.ComplexReportFactory.getTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import actions.LoginAction;
import actions.ProductTypeAction;
import utils.WebTestBase;
/**
 * 
 * @author aanand
 *
 */
public class ProductTypeTest extends WebTestBase{
	static String Screenname =" <b> Product type </b>";
	@Test(priority =1)
	public void AddProductTypeValidationCheck()
	{
		test=getTest(Screenname + " : Validation message on Add Product Type");
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.ValidationMessageCheckOfAddProductType();
	}
	@Test(priority =2)
	public void ImportProductTypeValidationCheck()
	{
		test=getTest(Screenname + " : Validation message on Import Product Type");
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.ValidationMessageCheckOfImportProductType();
	}
	@Test(priority =3)
	public void ImportProductType() throws EncryptedDocumentException, IOException
	{
		test=getTest(Screenname + " : Import Product Type");
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.ImportProductType();
	}
	@Test(priority =4)
	public void validateDeleteFunctionality() throws EncryptedDocumentException, IOException
	{
		test=getTest(Screenname + " : validate Delete Functionality");
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		//productTypeAction.ImportProductType();
		productTypeAction.ValidationOfDeleteFunctionalityForImportProductType();
	}
	@Test(priority =5)
	public void AddProductType()
	{
		test=getTest(Screenname + " : Add Product Type");
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		productTypeAction.AddProductType();
	}
	@Test(priority =6)
	public void ValidateAddedProductType()
	{
		test=getTest(Screenname + " : Validate Added Product");
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		//productTypeAction.AddProductType();
		productTypeAction.verifyAddedProduct();
	}
	@Test(priority =7)
	public void ValidateDeleteFunctionalityOfAddProductType()
	{
		test=getTest(Screenname + " : Validate Delete Functionality Of Add Product Type");
		ProductTypeAction productTypeAction = new ProductTypeAction(driver);
		new LoginAction(driver).logoutLogin();
		productTypeAction.GoToProductTypePage();
		//productTypeAction.AddProductType();
		productTypeAction.verifyDeleteFunctionalityOfAddProductType();
	}
}
