package pageObjects;

import static reporting.ComplexReportFactory.getTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import utils.DateTime;
import utils.PropertiesLoader;
import utils.WebBasePage;

public class ManageProductPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);
	
	/* code for tomorrow date */
	
	// static String productname;
	static String firstrowdata;
	static String pairedProductName;
	static String productName;
	static String secondrowdata;
	
	  ProductTypePage productTypePage;
	
	 
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public ManageProductPage(WebDriver driver) {
		super(driver, "Manage Product Page");
		this.driver = driver;
	}

	public void clickFullMenuDropDown() {
		staticWait(3000);
		click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 30);

	}

	public void clickOnAssetManagement() {
		staticWait(2000);
		// click(By.xpath("//a[contains(text(),'COMPANY SETUP')]"),"Company Setup Link",
		// 30);
		click(By.xpath("//li[@data-name='Asset Management ']/span"), "Asset Management", 30);

	}

	public void clickOnManageProduct() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[@data-original-title='Manage Product']"), "Manage Product", 30);
		staticWait(2000);
		WebElement manageproductPage = driver.findElement(By.xpath("//div/span[text()='Product List']"));
		if (manageproductPage.isDisplayed()) {
			logger.info("Product list page opened successfully");

		} else {
			logger.info("Product list page not opened successfully");
		}

	}

	public void clickOnAddProduct() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/span/a[@id='ancCreateJob']"), "Add Product", 30);
		staticWait(2000);
		WebElement addproductPage = driver.findElement(By.xpath("//div/h5[text()='Add Product']"));
		if (addproductPage.isDisplayed()) {
			logger.info("Add Product page opened successfully");

		} else {
			logger.info("Add Product page not opened successfully");
		}

	}

	public void VerifyMandatoryFieldValidationOfAddProductPage() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='form-group']//span[contains(@class,'invalid-feedback')]"), 15);
		String[] expectedValue = { "Product Type", "Product Name", "Barcode Type" };
		for (Object expected : expectedValue) {
			WebElement AsteriskField = findElementVisibility(By.xpath("//label[text()='" + expected
					+ "']/parent::asp-label-mandatory/descendant::span[@class='mandatory']"), 20);
			if (AsteriskField != null) {
				getTest().log(LogStatus.PASS, "The Asterisk symbol is displayed for " + expected + " field");
				logger.info("The Asterisk symbol is displayed for " + expected + " field");
			} else {
				getTest().log(LogStatus.FAIL, "The Asterisk symbol is not displayed for " + expected + " field");
				logger.info("The Asterisk symbol is not displayed for " + expected + " field");
				takeScreenshot(expected.toString());
			}

			List<WebElement> expectedElements = errorMessageLocator;
			for (WebElement element : expectedElements) {
				i++;
				actualText = element.getText();
				expectedText = expected.toString();

				if (actualText.indexOf(expectedText) != -1) {
					getTest().log(LogStatus.PASS,
							"Error message for \"" + expected + "\" field is displayed as expected");
					logger.info("Error message for \"" + expected + "\" field is displayed as expected");
					i = 0;
					break;
				} else if (i == expectedValue.length && !element.getText().contains(expectedText)) {
					getTest().log(LogStatus.FAIL, "Error message for \"" + expected + "\" field is not displayed");
					logger.info("Error message for \"" + expected + "\" field is displayed as expected");
					takeScreenshot(expectedText);
				}
			}
		}
	}

	public void clickOnAddProductTypeActionButton() {
		staticWait(2000);
		click(By.xpath("//a/i[@id='AddProducttype']"), "Add Product Type Action Button", 30);
		staticWait(2000);
		WebElement addproducttypePage = driver.findElement(By.xpath("//div/h5[text()='Add Product Type']"));
		if (addproducttypePage.isDisplayed()) {
			logger.info("Add Product Type page opened successfully");
			productTypePage.EnterProductTypeName();
			productTypePage.uploadimage();
			productTypePage.clickOnResetButton();
			productTypePage.uploadimage();
			productTypePage.EnterDescription();
			productTypePage.clickOnAssetToggleButton();
			productTypePage.clickOnConsumableToggleButton();
			productTypePage.clickOnAddNewTag();
			productTypePage.EnterTagNameTitle();
			productTypePage.clicksaveButtonOfTagNameTitle();
			productTypePage.clickOnIsTransferableToggleButton();
			productTypePage.clickOnSelfCheckoutToggleButton();
			productTypePage.clickOnEnableTermsAndConditionToggleButton();
			productTypePage.clickOnProductCostToggleButton();
			productTypePage.clickOnDepreciableToggleButton();
			productTypePage.clickOnSaveButton();

		} else {
			logger.info("Add Product Type page not opened successfully");
		}
	}

	public void clickOnSelectProductTypeName() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div[@class='input-group']/select[@id='AssetTypeId']"),
				productTypePage.productname, "Product name", 30);
	}

	public void enterProductName() {
		staticWait(2000);
		productName = prop.getProperty("productname") + datevalue;
		enter(By.xpath("//div/tg-input/input[@id='Name']"), productName, " Product Name", 20);
		staticWait(2000);
		click(By.xpath("//button[@id='closenotifymessage']"), "close notify message popup", 30);
	}

	public void clickOnSelectBarCode() {
		staticWait(2000);
		selectValueWithText(By.xpath("//tg-select/select[@id='BarcodeTypeId']"), "Barcode", "Barcode", 30);
	}

	public void clickOnCreateUniquenameListing() {
		staticWait(2000);
		click(By.xpath("//label/input[@id='CreateUniqueNameListing']/ancestor::asp-checkbox-toggle/descendant::span"),
				"Create Unique name Listing Button", 30);
	}

	public void uploadimage() {
//		findElementVisibility(
//				By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"), 20);
//		uploadDoc(By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"),
//				filePath + prop.getProperty("expenseFileDoc"), "uploaded document", 10);

//		String h = filePath + prop.getProperty("expenseFileDoc");
//		System.out.println("file path is :: " + h);
//		

		/*
		 * driver.findElement(By.
		 * xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"
		 * )) .click();
		 */
		driver.findElement(By.xpath(
				"//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']/label[@for='flFileDisplay']"))
				.click();

		// put path to your image in a clipboard
		StringSelection ss = new StringSelection(
				"C:\\Users\\aanand\\eclipse-workspace\\Talygen_Asset_Management_AutomationTestScript\\Talygen_Asset_Management\\src\\main\\resources\\testfiles\\55565.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot;
		try {
			robot = new Robot();

			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(90);
			robot.keyRelease(KeyEvent.VK_ENTER);
			logger.info("image uploaded successfully");
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOndeployproducttogglebutton() {
		staticWait(2000);
		click(By.xpath("//label/input[@id='showdeployment']/ancestor::asp-checkbox-toggle/descendant::span"),
				"deploy product toggle button", 30);
	}

	public void clickOnSelectLocation() {
		staticWait(2000);
		click(By.xpath("//div[@id='divmultilevelselectLocationWizard']//div/span[text()='Select']"),
				"Location dropDown", 30);
		staticWait(2000);
		click(By.xpath("(//ol/li/a/span[text()='Dallas'])[last()]"), "Dallas", 30);
	}

	public void enterQuantity() {
		staticWait(2000);
		enter(By.xpath("//tg-input/input[@id='Quantity']"), prop.getProperty("quantity"), "Quantity", 20);
	}

	public void enterUnitPrice() {
		staticWait(2000);
		enter(By.xpath("//tg-input/input[@id='UnitPrice']"), prop.getProperty("unitprice"), "Unit Price", 20);
	}

	public void clickOnsaveAndClose() {
		staticWait(1000);
		clickByJavascript(By.xpath("//div/a[@id='btnSaveAndClosed']"), "Save and Close", 30);

	}

	public void clickOnExpandSearchField() {
		staticWait(3000);
		// click(By.xpath("//span[@class='expand_all_filters']/span[@data-original-title='Expand
		// All or Collapse All']"), "Expand All or Collapse All", 30);
		WebElement expandAllFilter = driver.findElement(By
				.xpath("//span[@class='expand_all_filters']/span[@data-original-title='Expand All or Collapse All']"));
		Actions action = new Actions(driver);
		action.moveToElement(expandAllFilter).doubleClick().perform();
		logger.info("Expand All or Collapse All clicked successfully");
	}

	public void enterproductnameInSearchField() {
		staticWait(2000);
		enter(By.xpath("//div/input[@id='search']"), productName, "Product name", 20);

	}

	public void clickOnSearchbutton() {
		staticWait(1000);
		click(By.xpath("//span/a[@data-original-title='Click here to search']"), "Search Button", 30);
		try {
			WebElement ProductInListingpage = driver
					.findElement(By.xpath("//a/span[contains(text(),'" + productName + "')]"));
			if (ProductInListingpage.isDisplayed()) {
				logger.info("Product Name is Visible in listing page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product Name is not Visible in listing page");
		}

	}

	public void clickOncheckBox() {
		staticWait(1000);
		click(By.xpath("//tbody/tr/td/div[@class='custom-control custom-checkbox']"), "Check Box", 30);

	}

	public void clickOnDeleteButton() {
		staticWait(1000);
		click(By.xpath("//a[@id='DeleteMultiple']"), "Delete Button", 30);

	}

	public void clickOnConfirmationButton() {
		staticWait(1000);
		click(By.xpath("//button[@title='OK']"), "OK Button", 30);

		try {
			WebElement confirmationMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Product has been successfully deleted')]"));
			if (confirmationMessage.isDisplayed()) {
				logger.info("Product has been successfully deleted");

			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product hasn't been successfully deleted");
		}

	}
	/*-------------------------------------------------------------------------------------------------------------------------*/
	/* TestScript for Product Transfer page */

	public void clickOnProductTransfer() {
		staticWait(2000);
		click(By.xpath("//span/a[@id='ancItemTransfer']"), "Product Transfer", 30);
		try {
			WebElement producttransferPage = driver.findElement(By.xpath("//div/span[text()='Product Transfer']"));
			if (producttransferPage.isDisplayed()) {
				logger.info("Product Transfered Page opened successfully ");

			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product Transfered Page not opened successfully ");
		}
	}

	public void clickOnSelectFromLocation() {
		staticWait(2000);
		click(By.xpath("//div/span[text()='Select']"), "From Location TextField ", 30);
		staticWait(1000);
		click(By.xpath("//a/span[text()='Dallas']"), "Dallas", 30);
		staticWait(50000);
	}

	public void clickOnSelectProductType() {
		staticWait(48000);
		selectValueWithText(By.xpath("//div/select[@name='AssetTypeFilter']"), productTypePage.productname,
				"Product Type Name", 30);

	}

	public void clickOnSelectProductName() {
		staticWait(2000);
		click(By.xpath("//div/select[@id='AssetCatalogFilter']"), "Product Name Dropdown", 30);
		staticWait(50000);
		selectValueWithText(By.xpath("//div/select[@id='AssetCatalogFilter']"), productName, "Product Name", 30);

	}

	public void clickOnenterProductName() {
		staticWait(1000);
		enter(By.xpath("//div/input[@id='txtAssetItems']"), productName, "Products", 30);

	}

	public void clickOnsearchButton() {
		staticWait(1000);
		clickByJavascript(By.xpath("//div/span/a[@id='Searchassest']"), " Search Button", 30);

	}

	public void clickOnCheckBox() {
		staticWait(2000);
		click(By.xpath("(//div[@class='custom-control custom-checkbox'])[1]"), "Check Box", 30);

	}

	public void clickOnentertransferQuantity() {
		staticWait(1000);
		enter(By.xpath("//table/tbody/tr/td/input[@type='text']"), prop.getProperty("transferquantity"),
				"Transfer Quantity", 30);

	}

	public void clickOnAddToList() {
		staticWait(1000);
		click(By.xpath("//div/a[text()='Add To List']"), "Add To List", 30);

	}

	public void clickOnSelectToLocation() {
		staticWait(2000);
		click(By.xpath("//div/span[text()='Select']"), "To Location TextField ", 30);
		staticWait(1000);
		click(By.xpath("(//a/span[text()='Texas'])[last()]"), "Texas", 30);

	}

	public void clickOnenterdescription() {
		staticWait(1000);
		enter(By.xpath("//div/textarea[@id='txtDescription']"), prop.getProperty("Description"), "Description", 30);

	}

	public void clickOnenterComment() {
		staticWait(1000);
		enter(By.xpath("//div/textarea[@id='txtComment']"), prop.getProperty("commentforproductmovetolist"), "Comment",
				30);

	}

	public void clickOnSaveButton() {
		staticWait(1000);
		click(By.xpath("//div/a[@id='saveBtn']"), "Save Button", 30);

	}

	public void successfullmessagepopup() {
		staticWait(1000);
		// click(By.xpath("//div/span[contains(text(),'Product has been successfully
		// transferred')]"),"Save Button", 30);
		WebElement notifymessage = driver
				.findElement(By.xpath("//div/span[contains(text(),'Product has been successfully transferred')]"));
		if (notifymessage.isDisplayed()) {
			logger.info(notifymessage.getText());
		} else {
			logger.info("Product hasn't been successfully transferred");
		}

	}

	/*-------------------------------------------------------------------------------------------------------------------------*/
	/* TestScript for In-Transit Products page */
	public void clickOnInTransitProducts() {
		staticWait(2000);
		click(By.xpath("//div/span/a[@data-original-title='In-Transit Products']"), "In-Transit Products ", 30);
		try {
			WebElement intransitpage = driver.findElement(By.xpath("//div/span[text()='In-Transit List']"));
			if (intransitpage.isDisplayed()) {
				logger.info(" In-Transit Products page opened succesfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(" In-Transit Products page not opened succesfully");
		}
	}

	public void clickOnIntransitProductsExpandabdCollapseButton() {
		staticWait(5000);
		// click(By.xpath("//span[@data-toggle='collapse']"),"Collapse Button", 30);
		WebElement expandAllFilter = driver.findElement(By.xpath("//span[@data-toggle='collapse']"));
		Actions action = new Actions(driver);
		action.moveToElement(expandAllFilter).doubleClick().perform();
		logger.info("Expand All or Collapse All clicked successfully");

	}

	public void clickOnSearchByProductName() {
		staticWait(1000);
		click(By.xpath("//div/h5/a/span[text()='Product Name']"), "Search By Product name", 30);

	}

	public void clickOnSearchButton() {
		staticWait(1000);
		click(By.xpath("//span/a[@id='Go']"), "Search Button", 30);

	}

	public void clickOnAcceptOrRejectButton() {
		staticWait(1000);
		click(By.xpath("//div/span/a[@data-original-title='Accept/Reject']"), "Accept/Reject", 30);

	}

	public void clickOnCheckBoxOfInTransitProduct() {
		staticWait(2000);
		click(By.xpath("(//table/thead/tr/th[@id='nonresize']/div[@class='custom-control custom-checkbox'])[last()]"),
				"Check Box", 30);

	}

	public void clickOnRejectAllButton() {
		staticWait(1000);
		click(By.xpath("//div/a[@id='rejectAll']"), "Reject All", 30);

	}

	public void clickOnSaveButtonOfInTransitProducts() {
		staticWait(1000);
		click(By.xpath("//div/a[@id='btnSave']"), "Save Button", 30);

	}

	public void clickOnAcceptAllButton() {
		staticWait(1000);
		// click(By.xpath("//div/a[@id='rejectAll']"),"Reject All", 30);
		click(By.xpath("//div/a[@id='acceptAll']"), "Accept All", 30);

	}

	public void successfullmessagepopupForInTransitProduct() {
		staticWait(1000);
		// click(By.xpath("//div/span[contains(text(),'Product has been successfully
		// transferred')]"),"Save Button", 30);
		WebElement notifymessage = driver
				.findElement(By.xpath("//div/span[contains(text(),'Product has been successfully transferred')]"));
		if (notifymessage.isDisplayed()) {
			logger.info(notifymessage.getText());
		} else {
			logger.info("Product hasn't been successfully transferred");
		}
	}

	public void clickOnTransferList() {
		staticWait(2000);
		click(By.xpath("//div/span/a[@data-original-title='Transferred List']"), "transfer list ", 30);
		try {
			WebElement transferlistpage = driver.findElement(By.xpath("//div/span[text()='Transferred List']"));
			if (transferlistpage.isDisplayed()) {
				logger.info(" Transferred List page opened succesfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(" Transferred List page not opened succesfully");
		}
	}

	public void enterProductNameInsearchField() {
		staticWait(1000);
		enter(By.xpath("//div/input[@placeholder='Search by Product Name']"), productName, "Product Name", 30);

	}

	public void verifyproductinlistingpage() {
		staticWait(1000);
		try {
			WebElement productInListingPage = driver
					.findElement(By.xpath("//tbody/tr/td/span[text()='" + productName + "']"));
			String acceptedquantity = driver.findElement(By.xpath("//*[@id='tblProjectList']/tbody/tr[1]/td[6]/span"))
					.getText();
			if (productInListingPage.isDisplayed() && acceptedquantity.equals(prop.getProperty("transferquantity"))) {
				logger.info("Product is present in Transfered list page");
				logger.info("Product is succesfully Acceptad");
			} else {
				logger.info("Product is present in Transfered list page");
				logger.info("Product is succesfully Rejected");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product is not present in Transfered list page");
		}
	}

	/*-------------------------------------------------------------------------------------------------------------------------*/
	/* TestScript for Edit Product */
	public void clickOnProduct() {
		staticWait(1000);
		click(By.xpath("//a/span[contains(text(),'" + productName + "')]"), "Product", 30);

	}

	public void clickOncloseChatpopup() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@class='cht-collapse']"), "communication popup", 30);

	}

	public void clickOnActionButton() {
		staticWait(3000);
		click(By.xpath("//table/tbody/tr/td/span[@class='actions mobileaction']"), "Action Button", 30);

	}

	public void clickOnEditButton() {
		staticWait(1000);
		click(By.xpath("//span/a[@data-original-title='Edit']"), "Edit Button", 30);

	}

	public void clickOnNext() {
		staticWait(1000);
		click(By.xpath("//div/a/span[text()='Next']"), "Next", 30);

	}

	public void clickOnDeployProduct() {
		staticWait(1000);
		click(By.xpath("//div/ul/li/a[@data-original-title='Deploy Product']"), "Deploy Product", 30);

	}

	public void clickOnLocation() {
		staticWait(2000);
		clickByJavascript(By.xpath("//table/tbody/tr/td/a[@data-original-title='Dallas']"), "Location", 30);

	}

	public void clickOnSelectDepreciationRule() {
		staticWait(5000);
		selectValueWithText(By.xpath("//div/select[@id='depreciationId']"), "Units of Production", "Depreciation Rule",
				30);

	}

	public void enterProductLiffe() {
		staticWait(1000);
		enter(By.xpath("//tg-input/input[@id='ItemLife']"), prop.getProperty("productLife"), "Product Life", 30);

	}

	public void clickOnSaveButtonOfDeployProducts() {
		staticWait(1000);
		click(By.xpath("//div/a[@id='saveBtnn']"), "Save button", 30);

	}

	public void notifymessageForDeployProducts() {
		staticWait(1000);

		try {
			WebElement notifymessage = driver.findElement(
					By.xpath("//div/span[contains(text(),'Deploy Product has been successfully updated')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Deploy Product hasn't been successfully updated");
		}

	}

	public void clickOnAttachment() {
		staticWait(1000);
		click(By.xpath("//div/ul/li/a[@data-original-title='Attachments']"), "Attachments", 30);

	}

	public void enterAttachmentName() {
		staticWait(1000);
		enter(By.xpath("//div/tg-input/input[@id='txtAttachment']"), prop.getProperty("attachmentName"),
				"Attachment Name", 30);

	}

	public void uploadimageInAttachmentPage() {
//		findElementVisibility(
//				By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"), 20);
//		uploadDoc(By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"),
//				filePath + prop.getProperty("expenseFileDoc"), "uploaded document", 10);

//		String h = filePath + prop.getProperty("expenseFileDoc");
//		System.out.println("file path is :: " + h);
//		

		/*
		 * driver.findElement(By.
		 * xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"
		 * )) .click();
		 */
		driver.findElement(By.xpath(
				"//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']/label[@for='flFile']"))
				.click();

		// put path to your image in a clipboard
		StringSelection ss = new StringSelection(
				"C:\\Users\\aanand\\eclipse-workspace\\Talygen_Asset_Management_AutomationTestScript\\Talygen_Asset_Management\\src\\main\\resources\\testfiles\\55565.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot;
		try {
			robot = new Robot();

			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(90);
			robot.keyRelease(KeyEvent.VK_ENTER);
			logger.info("image uploaded successfully");
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnSaveButtonOfEditedproduct() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@id='btnSave']"), "Save Button", 30);

	}

	public void notifymessageForUpdatedProducts() {
		staticWait(1000);

		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Product has been successfully updated')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product hasn't been successfully updated");
		}

	}

	/*-------------------------------------------------------------------------------------------------------------------------*/
	/* TestScript for depreciation Product */
	public void clickOndepreciation() {
		staticWait(1000);
		click(By.xpath("//div/span/a[@id='ancDepreciation']"), "depreciation", 30);
	}

	public void enterproductnameIndepreciationSearchField() {
		staticWait(2000);
		enter(By.xpath("//div/input[@id='productNameId']"), productName, "Product name", 20);

	}

	public void clickOnDepreciationSearchbutton() {
		staticWait(1000);
		click(By.xpath("//span/a[@data-original-title='Click here to search']"), "Search Button", 30);
		try {
			WebElement ProductInListingpage = driver
					.findElement(By.xpath("//td/span[contains(text(),'" + productName + "')]"));
			if (ProductInListingpage.isDisplayed()) {
				logger.info("Product Name is Visible in Depreciationlisting page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product Name is not Visible in Depreciation listing page");
		}

	}

	/*-------------------------------------------------------------------------------------------------------------------------*/
	/* TestScript for Add relationship between Product */
	public void clickOnAddRelation() {
		staticWait(1000);
		click(By.xpath("//div/span/a[@data-original-title='Add Relationship']"), "Add relation", 30);
	}
	public void clickOnSearchByProduct() {
		staticWait(1000);
		click(By.xpath("//div/label[@for='SearchProducts']"), "Search By Product", 30);
	}

	public void clickOnSearchButtonOfAddRelation() {
		staticWait(1000);
		click(By.xpath("//div/a[@id='Searchassest']"), "Search Button", 30);
	}

	public void clickOnSelectPairedProduct() {
		staticWait(1000);
		click(By.xpath("//div/select[@id='AssetCatalogRelation']"), "Select product name", 30);
		staticWait(1000);

		pairedProductName = driver.findElement(By.xpath("//div/select[@id='AssetCatalogRelation']/option[2]"))
				.getText();
		click(By.xpath("//div/select[@id='AssetCatalogRelation']/option[2]"), "product name", 30);
	}

	public void clickOnCheckOutToggleButton() {
		staticWait(1000);
		click(By.xpath("//label/input[@id='isVisibleToClientN']/ancestor::asp-checkbox-toggle/descendant::span"),
				"Check Out Toggle Button", 30);
	}

	public void clickOnAddMoreProductButton() {
		staticWait(1000);
		clickByJavascript(By.xpath("//td/a[@id='addProduct']"), "Add More Product", 30);
		try {
			WebElement addMoreProduct = driver.findElement(By.xpath("//tr/td[text()='2']"));
			if (addMoreProduct.isDisplayed()) {
				logger.info("Product is addded successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product is not addded successfully");
		}
	}

	public void clickOnDeleteAddedMoreProductButton() {
		staticWait(1000);
		clickByJavascript(By.xpath("(//td/a[@class='btnDelete'])[last()]"), "Delete", 30);
		try {
			WebElement addMoreProduct = driver.findElement(By.xpath("//tr/td[text()='2']"));
			if (addMoreProduct.isDisplayed()) {
				logger.info("Product is not deleted successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product is deleted successfully");
		}
	}

	public void clickOnSaveAddRelationship() {
		staticWait(1000);
		clickByJavascript(By.xpath("//div/a[@id='ancsaverelationship']"), "Save Button", 30);
	}

	public void captureNotifyMessageOfAddRelationship() {
		staticWait(2000);
		try {
			// WebElement notifyMesage =
			// driver.findElement(By.xpath("//div/span[contains(text(),'Add Relationship
			// Submitted Successfully')]"));
			WebElement notifyMesage = driver.findElement(By.xpath("//div/span[text()='Product List']"));
			if (notifyMesage.isDisplayed()) {
				logger.info("Add Relationship is Submitted Successfully");
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Add Relationship is not Submitted Successfully");
		}
	}

	public void verifyAddRelationShipProductInProductListpage() {
		staticWait(2000);
		try {

			WebElement relatedProduct = driver.findElement(By.xpath("//td/span/a[@class='relatedproduct']"));
			if (relatedProduct.isDisplayed()) {
				logger.info("Product is showing in Related product List");
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product is not showing in Related product List");
		}
	}

	public void clickOnRelatedProduct() {
		staticWait(1000);
		click(By.xpath("//td/span/a[@class='relatedproduct']"), "Related product", 30);
		try {
			staticWait(1000);
			WebElement relatedProductPage = driver.findElement(By.xpath("//div/h5[text()='Related Product']"));
			if (relatedProductPage.isDisplayed()) {
				logger.info("Related Product page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Related Product page opened successfully");
		}
	}

	public void verifyRelatedProduct() {
		staticWait(1000);

		try {
			staticWait(1000);
			WebElement relatedProduct = driver
					.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'" + pairedProductName + "')]"));
			if (relatedProduct.isDisplayed()) {
				logger.info("Product is available in Related product page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product is not available in Related product page");
		}
	}

	public void clickOnCloseButton() {
		staticWait(1000);
		click(By.xpath("//div/button[text()='Close']"), "Close Button", 30);
	}

	/*-------------------------------------------------------------------------------------------------------------------------*/
	/* TestScript for Verify Check Avability functionality */
	public void clickOnCheckAvabilityButton() {
		staticWait(1000);
		click(By.xpath("//div/span/a[@id='ancCheckAvailability']"), "Check Avability Button", 30);
		try {
			WebElement productAvability = driver.findElement(By.xpath("//div/h5[text()='Product Availability']"));
			if (productAvability.isDisplayed()) {
				logger.info("Product Avability page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product Avability page not opened successfully");
		}
	}

	public void clickOnSearchByProductRadioButton() {
		staticWait(3000);
		click(By.xpath(
				"//div/input[@id='SearchProducts']/ancestor::div[@type='radiobutton']/descendant::label[@for='SearchProducts']"),
				"Search by product radio Button", 30);
	}

	public void selecttomorrowDate() throws AWTException {
		staticWait(1000);
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date date = cal.getTime();
        String tomorrowDate = dateFormat.format(date);
		click(By.xpath("//div/tg-input/input[@id='AssignedTill']"), "Assigned Till", 30);
		 Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_A);
		 robot.keyRelease(KeyEvent.VK_A);
		 robot.keyRelease(KeyEvent.VK_CONTROL);
		 robot.keyPress(KeyEvent.VK_BACK_SPACE);
		 robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		 enter(By.xpath("//div/tg-input/input[@id='AssignedTill']"), tomorrowDate, "Tomorrow Date", 30);
	}

	public void clickOnCheckAvability() {
		staticWait(1000);
		clickByJavascript(By.xpath("//div/a[@id='btnCheckAvailability']"), "Check Avability", 30);
	}

	public void validateNotificationPopup() {
		staticWait(1000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Please select a Product')]"));
			if (notifymessage.isDisplayed()) {
				logger.info("Notify message is displayed -" + notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Notify message popup not displayed");
		}
	}

	public void CheckProductAvabilityAndQuantity() {
		staticWait(1000);

		try {
			WebElement productAvability = driver
					.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'" + productName + "')]"));
			String productQuantity = driver.findElement(By.xpath("//table[@id='tblUniqueItems']/tbody/tr/td[last()]"))
					.getText();
			if (productAvability.isDisplayed()) {
				logger.info("Product is Available in Product Avability page");
				logger.info("Available quantity of product is : " + productQuantity);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product is not Available in Product Avability page");
		}
	}

	public void clickOnProductAvaibilityCheckBox() {
		staticWait(1000);
		click(By.xpath("//table[@id='tblUniqueItems']/thead/tr/th/div[@class='custom-control custom-checkbox']"),
				"Product avability checkbox", 30);
	}
	public void clickOnTermsAndConditionCheckBox() {
		staticWait(1000);
		click(By.xpath("//label[contains(text(),'I agree to the Terms and Conditions')]"),
				"Terms and Conditions checkbox", 30);
	}

	public void clickOnProceedToCheckOut() {
		staticWait(1000);
		click(By.xpath("//div/a[@id='btnCheckout']"), "Proceed to checkout", 30);
		try {
			staticWait(75000);
			WebElement newcheckoutpage = driver.findElement(By.xpath("//div/span[text()='New Checkout']"));
			if (newcheckoutpage.isDisplayed()) {
				logger.info("New checkout page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("New checkout page not opened successfully");
		}
	}

	public void clickOnSaveButtonOfNewCheckOutPage() {
		staticWait(5000);
		click(By.xpath("//div/a[@id='ancsaverequest']"), "Save Button", 30);
		try {
			WebElement checkoutListpage = driver.findElement(By.xpath("//div/span[contains(text(),'Check-Out List')]"));
			if (checkoutListpage.isDisplayed()) {
				logger.info("Check Out request submitted successfully");
				logger.info("Check Out list page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Check Out list page not opened successfully");
			logger.info("Check Out request submitted successfully");
		}
	}

	public void clickOnExpandOrCollapseAllSearchField() {
		staticWait(3000);

		WebElement expandAllFilter = driver
				.findElement(By.xpath("//span[@class='expand_all_filters']/span[@class='ancExpandAllCollapseAll']"));
		Actions action = new Actions(driver);
		action.moveToElement(expandAllFilter).click().perform();
		logger.info("Expand All or Collapse All clicked successfully");
	}

	public void enterProductNameInsearchFieldOfCheckOutList() {
		staticWait(1000);
		enter(By.xpath("//div[@class='input-group customsearchbox']/input[@type='text']"), productName, "Product Name",
				30);
		staticWait(1000);
		click(By.xpath("//label[text()='" + productName + "']"), "Product Radio button", 30);
	}

	public void clickOnSearchbuttonOfCheckOutList() {
		staticWait(1000);
		click(By.xpath("//span/a[@data-original-title='Click here to search']"), "Search Button", 30);
		try {
			WebElement ProductInListingpage = driver
					.findElement(By.xpath("//td/span[contains(text(),'" + productName + "')]"));
			if (ProductInListingpage.isDisplayed()) {
				logger.info("Product is available in Check Out listing page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product is not available in Check Out listing page");
		}

	}

	public void clickOnRejectButton() {
		staticWait(1000);
		click(By.xpath("//td/a[@id='Cancel']"), "Reject Button", 30);
	}

	/*-------------------------------------------------------------------------------------------------------------------------*/
	/* TestScript for Verify import product functionality */
	public void clickOnImportButton() {
		staticWait(3000);
		click(By.xpath("//a[@id='ancImportItem']"), "Import Button", 30);
	}

	public void updateExceldata() throws EncryptedDocumentException, IOException {
		try {
			staticWait(2000);
			FileInputStream fileInputStream = new FileInputStream(
					"C:\\Users\\aanand\\eclipse-workspace\\Talygen_Asset_Management_AutomationTestScript\\Talygen_Asset_Management\\src\\main\\resources\\testfiles\\ProductSample.xls");
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = workbook.getSheet("productname");
			Row row = sheet.getRow(1);
			Row row1 = sheet.getRow(2);
			Cell cell = row.getCell(1);
			Cell cell1 = row1.getCell(1);
			cell.setCellValue("Spark" + datevalue);
			cell1.setCellValue("Nexus" + datevalue);
			FileOutputStream fileOutputStream = new FileOutputStream(
					"C:\\Users\\aanand\\eclipse-workspace\\Talygen_Asset_Management_AutomationTestScript\\Talygen_Asset_Management\\src\\main\\resources\\testfiles\\ProductSample.xls");
			workbook.write(fileOutputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readupdateExceldata() throws EncryptedDocumentException, IOException {
		try {
			staticWait(3000);
			FileInputStream fileInputStream = new FileInputStream(
					"C:\\Users\\aanand\\eclipse-workspace\\Talygen_Asset_Management_AutomationTestScript\\Talygen_Asset_Management\\src\\main\\resources\\testfiles\\ProductSample.xls");
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = workbook.getSheet("productname");
			// get the last used row count
			// int count = sheet.getLastRowNum();
			// for(int i=1; i<count;i++) {
			Row row = sheet.getRow(1);
			Row row1 = sheet.getRow(2);
			firstrowdata = row.getCell(1).getStringCellValue();
			secondrowdata = row1.getCell(1).getStringCellValue();
			logger.info("Product Name present in Excel sheet" + firstrowdata + "\t" + secondrowdata);
			// }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void uploadDocument() {
// 		findElementVisibility(
// 				By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"), 20);
// 		uploadDoc(By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"),
// 				filePath + prop.getProperty("expenseFileDoc"), "uploaded document", 10);

// 		String h = filePath + prop.getProperty("expenseFileDoc");
// 		System.out.println("file path is :: " + h);
// 		

		/*
		 * driver.findElement(By.
		 * xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"
		 * )) .click();
		 */
		driver.findElement(By.xpath(
				"//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']/label[@for='flFile']"))
				.click();

		// put path to your image in a clipboard
		StringSelection ss = new StringSelection(
				"C:\\Users\\aanand\\eclipse-workspace\\Talygen_Asset_Management_AutomationTestScript\\Talygen_Asset_Management\\src\\main\\resources\\testfiles\\ProductSample.xls");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot;
		try {
			robot = new Robot();

			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(90);
			robot.keyRelease(KeyEvent.VK_ENTER);
			logger.info("Document uploaded successfully");
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnImportFromExcelFile() {
		staticWait(2000);
		click(By.xpath("//div/a[@id='btnImportFile']"), "Import From Excel File Button", 30);
	}

	public void clickOnConfirmationButtonForImportProduct() {
		staticWait(1000);
		click(By.xpath("//button[@title='OK']"), "OK Button", 30);

	}

	public void clickOnSubmitButton() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/a[@id='aSubmit']"), "Submit Button", 30);
	}

	public void verifyImportProductType() {
		try {

			WebElement successfulpopUpMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'File has been successfully imported')]"));
			String popUpMessage = successfulpopUpMessage.getText();
			if (successfulpopUpMessage.isDisplayed()) {
				logger.info(successfulpopUpMessage.getText());
				staticWait(2000);
				clickOnExpandOrCollapseAllSearchFieldForImportProduct();
				enter(By.xpath("//div[@class='form-group']/input[@id='search']"), firstrowdata, " Product Name", 20);
				staticWait(2000);
				clickOnSearchButton();
				staticWait(3000);
				String producttypename = driver
						.findElement(By.xpath("//td/a/span[contains(text(),'" + firstrowdata + "')]")).getText();
				if (producttypename.contains(firstrowdata)) {
					logger.info(producttypename + " " + popUpMessage);

				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			WebElement popUpMessage = driver.findElement(By.xpath(
					"//div/span[contains(text(),'If the product already exists, it will be considered as a new deployment request. File has these existing Products')]"));
			if (popUpMessage.isDisplayed()) {
				logger.info(popUpMessage.getText());
			}
			e.printStackTrace();
		}

	}

	public void clickOnExpandOrCollapseAllSearchFieldForImportProduct() {
		staticWait(3000);

		WebElement expandAllFilter = driver.findElement(By
				.xpath("//span[@class='expand_all_filters']/span[@data-original-title='Expand All or Collapse All']"));
		Actions action = new Actions(driver);
		action.moveToElement(expandAllFilter).doubleClick().perform();
		logger.info("Expand All or Collapse All clicked successfully");
	}

}
