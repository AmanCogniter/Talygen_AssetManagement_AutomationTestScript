package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class MyProductsPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);
	static String productname;
	static String firstrowdata;
	static String pairedProductName;
	// static String productName;
	static String secondrowdata;
	ProductTypePage productTypePage;
	ManageProductPage manageProductPage;
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public MyProductsPage(WebDriver driver) {
		super(driver, "My Products Page");
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

	public void clickOnMyProducts() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[text()='My Products']"), "My Products", 30);
		staticWait(2000);
		WebElement myproductsPage = driver.findElement(By.xpath("//div/span[text()='My Products ']"));
		if (myproductsPage.isDisplayed()) {
			logger.info("My Products list page opened successfully");

		} else {
			logger.info("My Products list page not opened successfully");
		}

	}

	public void clickOnCheckAvailability() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/span/a[@id='ancCheckAvailability']"), "Check Availability", 30);
		staticWait(2000);
		WebElement productAvailabilityPage = driver.findElement(By.xpath("//div/h5[text()='Product Availability']"));
		if (productAvailabilityPage.isDisplayed()) {
			logger.info("Product Availability page opened successfully");

		} else {
			logger.info("Product Availability page not opened successfully");
		}

	}

	public void clickOnProceedToAssign() {
		staticWait(1000);
		click(By.xpath("//div/a[text()='Proceed to Assign']"), "Proceed to Assign", 30);
		try {
			WebElement productAssignmentpage = driver.findElement(By.xpath("//div/span[text()='Product Assignment']"));
			if (productAssignmentpage.isDisplayed()) {
				logger.info("Product Assignment page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product Assignment page not opened successfully");
		}
	}
	public void enterRequestQuantityInTextField() {
		staticWait(3000);
		
		enter(By.xpath("//td/input[@class='txtitems form-control  txtAssetQuentity']"), prop.getProperty("requestquantitys"), "Request Quantity", 20);

	}

	public void clickOnProceedToCheckOut() {
		staticWait(1000);
		click(By.xpath("//div/a[text()='Proceed to Checkout']"), "Proceed to Checkout", 30);
		try {
			WebElement productcCheckOutpage = driver.findElement(By.xpath("//div/span[text()='New Checkout']"));
			if (productcCheckOutpage.isDisplayed()) {
				logger.info("Product CheckOut page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product CheckOut page not opened successfully");
		}
	}

	public void clickOnSaveButtonOfProductAssignmentPage() {
		staticWait(1000);
		click(By.xpath("//div/a[@id='btnSave']"), "Save Button", 30);
		try {
			WebElement checkoutListpage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Product Assignment')]"));
			if (checkoutListpage.isDisplayed()) {
				logger.info("product assigned successfully");
				logger.info("Product Assignment list page opened successfully");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product Assignment list page not opened successfully");
			logger.info("product not assigned successfully");
		}
	}

	public void clickOnSaveButtonOfProductCheckOutPage() {
		staticWait(3000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Save']"), "Save Button", 30);
		/*
		 * try { WebElement checkoutListpage = driver
		 * .findElement(By.xpath("//div/span[contains(text(),'Product Assignment')]"));
		 * if (checkoutListpage.isDisplayed()) {
		 * logger.info("product assigned successfully");
		 * logger.info("Product Assignment list page opened successfully");
		 * 
		 * } } catch (Exception e) { // TODO: handle exception
		 * logger.info("Product Assignment list page not opened successfully");
		 * logger.info("product not assigned successfully"); }
		 */
	}

	public void clickOnExpandAllorCollapseAll() {
		staticWait(3000);
		click(By.xpath("//div/a[text()='Expand All or Collapse All']"), "Expand All or Collapse All", 30);
	}

	public void enterproductnameInSearchField() {
		staticWait(3000);
		productname = manageProductPage.productName;
		logger.info("Product Name " + productname);
		enter(By.xpath("//div/input[@name='searchItemCode']"), productname, "Product name", 20);

	}

	public void enterproductnameInSearchFieldforNormalUser() {
		staticWait(3000);
		productname = manageProductPage.productName;
		logger.info("Product Name " + productname);
		enter(By.xpath("//div/input[@placeholder='Search']"), productname, "Product name", 20);
		click(By.xpath("//div/label[contains(text(),'" + productname + "')]"), "Search Button", 30);
	}

	public void clickOnSearchButton() {
		staticWait(1000);
		clickByJavascript(By.xpath("//span/a[@id='Go']"), "Search Button", 30);
	}

	public void validateProductName() {
		try {
			staticWait(3000);
			WebElement validateProductName = driver
					.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'" + productname + "')]"));
			if (validateProductName.isDisplayed()) {
				logger.info("Product name is displayed in product assignment page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product name is not displayed in product assignment page");
		}

	}

	public void clickOnCheckBox() {
		staticWait(1000);
		click(By.xpath("//table/thead/tr/th/div[@class='custom-control custom-checkbox']"), "Check Box", 30);
	}

	public void clickOnActionButton() {
		staticWait(2000);
		click(By.xpath("//tbody/tr/td/span[@class='actions mobileaction']"), "Action Button", 30);

	}

	public void clickOnCloseCommunicationPopUp() {
		staticWait(1000);
		click(By.xpath("//div/a/i[@id='arrow-rotate']"), "Close Communication PopUp", 30);

	}

	public void clickOnCloseActionButton() {
		staticWait(1000);
		click(By.xpath("//i[@class='fa fa-times close close-action']"), "Close Action Button", 30);
	}

	public void clickOnNotReturn() {
		staticWait(1000);
		clickByJavascript(By.xpath("//span/a[@data-original-title='Not Returned']"), "Not Return", 30);

		try {
			WebElement returnPage = driver.findElement(By.xpath("//div/h5[text()='Return']"));
			if (returnPage.isDisplayed()) {
				logger.info("Return Page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Return Page opened successfully");
		}
	}

	public void enterTitle() {
		staticWait(2000);
		enter(By.xpath("//div/tg-input/input[@id='Title']"), prop.getProperty("titlename"), "Return Title name", 20);
	}

	public void enterComment() {
		staticWait(2000);
		enter(By.xpath("//div/textarea[@id='Comment']"), prop.getProperty("Description"), "Return Comment", 20);
	}

	public void enterProductName() {
		staticWait(3000);
		enter(By.xpath("//div/input[@id='productName']"), manageProductPage.productName, "Product Name", 20);
	}

	public void clickOnMyProductSearchButton() {
		staticWait(1000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Search']"), "Search Button", 30);
	}

	public void verifyProductOnMyProductListPage() {
		staticWait(3000);

		try {
			WebElement myProductListPage = driver
					.findElement(By.xpath("//table/tbody/tr/td/span[contains(text(),'" + manageProductPage.productName + "')]"));
			if (myProductListPage.isDisplayed()) {
				logger.info("Product name is Displayed on My Products List page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product name is not Displayed on My Products List page");
		}
	}

	public void clickOnAcceptTermsAndCondition() {
		staticWait(2000);
		clickByJavascript(By.xpath("//a[@data-original-title='Accept Terms and Conditions']"),
				"Accept Terms And Condition", 30);
		WebElement termsAndCondition = driver.findElement(By.xpath("//div/h5[contains(text(),'Terms & Conditions')]"));
		try {
			if (termsAndCondition.isDisplayed()) {
				logger.info("Accept Terms And Condition page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Accept Terms And Condition page not opened successfully");
		}
	}

	public void clickOnTermsAndConditionCheckBox() {
		staticWait(1000);
		click(By.xpath("//div/label[contains(text(),'I agree to the Terms and Conditions')]"), "Check Box", 30);
	}

	public void clickOnTermsAndConditionsaveButton() {
		staticWait(1000);
		click(By.xpath("//div/a[@data-original-title='Save']"), "Save Button", 30);
	}

	/*---------------------------------------------------------------------Self Assignment--------------------------------------------------------------------------*/
	public void clickOnSelfAssignment() {
		staticWait(1000);
		click(By.xpath("//div/span/a[@data-original-title='Self Assignment']"), "Self Assignment", 30);

		try {
			WebElement productAssignment = driver.findElement(By.xpath("//div/span[text()='Product Assignment']"));
			if (productAssignment.isDisplayed()) {
				logger.info("Product Assignment page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product Assignment page not opened successfully");
		}
	}

	public void enterRemark() {
		staticWait(2000);
		enter(By.xpath("//div/tg-textarea/textarea[@id='Remarks']"), prop.getProperty("Description"), "Remark", 20);
	}

	public void selectProductType() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div/select[@id='AssetTypeFilter']"), productTypePage.productname,
				"Product Type", 30);
	}

	public void selectProductName() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div/select[@id='AssetCatalogFilter']"), manageProductPage.productName,
				"Product Name", 30);
	}

	public void enterName() {
		staticWait(2000);
		click(By.xpath("//div/a[@id='customddlinput']"), "Enter Name dropdown", 30);
		staticWait(1000);
		click(By.xpath("//div[@class='unique_dynamicdatalist']/ul/li"), "Enter Name ", 30);
	}

	public void clickOnAddProductOfSelfAssignment() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/span/a[text()='Add Product']"), "Add Product", 30);
	}

	public void clickOnTermsAndConditionCheckBoxOfSelfAssignment() {
		staticWait(2000);
		click(By.xpath("//div/a/label[contains(text(),'I agree to the Terms and Conditions')]"), "Check Box", 30);
	}

	public void validateNotificationPopupOfSelfAssignment() {
		staticWait(1000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[text()='Please add at least one Item']"));
			if (notifymessage.isDisplayed()) {
				logger.info("Notify message is displayed -" + notifymessage.getText());
				click(By.xpath("//div/button[@id='closenotifymessage']"), "Close notify message", 30);
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Notify message popup not displayed");
		}
	}

	public void clickOnAddToItem() {
		staticWait(2000);
		click(By.xpath("//td/a/i[@title='Add to item']"), "Add to item", 30);
	}

	public void enterproductnameInSelfAssignmentSearchField() {
		staticWait(3000);
		logger.info(manageProductPage.productName);
		enter(By.xpath("//div/input[@id='productName']"), manageProductPage.productName, "Product name", 20);

	}

	public void clickOnSearchButtonOfSelfAssignment() {
		staticWait(1000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Search']"), "Search Button", 30);
	}

	public void verifyProductNameInMyProductListPage() {
		staticWait(1000);

		try {
			WebElement productName = driver.findElement(
					By.xpath("//table/tbody/tr/td/span[contains(text(),'" + manageProductPage.productName + "')]"));
			if (productName.isDisplayed()) {
				logger.info("Product is displayed in Check Out List Page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product is not displayed in Check Out List Page");
		}
	}

	/*---------------------------------------------------------------------Add Check Out Request--------------------------------------------------------------------------*/
	public void clickOnAddCheckOutRequest() {
		staticWait(1000);
		click(By.xpath("//span/a[@data-original-title='Add Check Out Request']"), "Add Check Out Request", 30);

		try {
			WebElement newCheckout = driver.findElement(By.xpath("//div/span[text()='New Checkout']"));
			if (newCheckout.isDisplayed()) {
				logger.info("Add Check Out Request page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Add Check Out Request page not opened successfully");
		}
	}

	public void enterAddCheckOutRequestComment() {
		staticWait(2000);
		enter(By.xpath("//div/textarea[@id='Comment']"), prop.getProperty("Description"), "Comment", 20);
	}

	public void clickOnAddProduct() {
		staticWait(1000);
		clickByJavascript(By.xpath("//div/h5/small/a[@data-original-title='Add Products']"), "Add Products", 30);

		try {
			WebElement searchItems = driver.findElement(By.xpath("//div/h5[text()='Search Items']"));
			if (searchItems.isDisplayed()) {
				logger.info("Search Items page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Search Items page not opened successfully");
		}
	}

	public void clickOnSelectProductType() {
		staticWait(5000);
		click(By.xpath("//div/select[@id='AssetTypeFilter']"), "Select Product type", 30);
		staticWait(75000);
		selectValueWithText(By.xpath("//div/select[@id='AssetTypeFilter']"), productTypePage.productname,
				"Product Type", 30);
	}

	public void clickOnSelectProductName() {
		staticWait(75000);
		// selectValueWithText(By.xpath("//div/select[@id='AssetCatalogFilter']"),
		// productname, "Product name", 30);
		click(By.xpath("//div/select[@id='AssetCatalogFilter']"), "Select Product", 30);
		staticWait(1000);
		click(By.xpath("//div/select[@id='AssetCatalogFilter']/option[last()]"), "Product Name", 30);
	}

	public void clickOnSelectItem() {
		staticWait(1000);
		clickByJavascript(By.xpath("//div/a[@id='customddlinput']"), "Select Item", 30);
		staticWait(1000);
		click(By.xpath("//div[@class='unique_dynamicdatalist']/ul/li"), "Item", 30);
	}

	public void clickOnSearch() {
		staticWait(1000);
		clickByJavascript(By.xpath("//span/a[@data-original-title='Click here to search']"), "Search Button", 30);
	}
	public void clickOnClose() {
		staticWait(1000);
		click(By.xpath("//div/button/span[contains(text(),'×')]"), "Close Button", 30);
	}
	public void clickOnTermsAndCondition() {
		staticWait(1000);
		click(By.xpath("//div[contains(@class,'form-group custom-control custom-checkbox mt')]"), "Terms & Condition CheckBox", 30);
	}

	public void clickOnCheckBoxofSearchItem() {
		staticWait(80000);
		click(By.xpath("//table/tbody/tr/td/div[@class='custom-control custom-checkbox']"), "Check Box", 30);
	}

	public void clickOnAddToList() {
		staticWait(5000);
		click(By.xpath("//td[@class='align-middle']/input"), "Request Quantity Check Box", 30);
		click(By.xpath("//div/button[text()='Add To List']"), "Add To List", 30);
		staticWait(5000);
	}
	public void waitforElement() {
		staticWait(75000);
		waitForVisibilityOfElement(By.xpath("//div/span[contains(text(),'New Checkout')]"), 50);
	}

	public void clickOnSave() {
		staticWait(75000);
		clickByJavascript(By.xpath("//div/a[@data-original-title='Save']"), "save Button", 30);
	}
	public void clickOnRequestQuantityOfProductAssignmentReport() {
		staticWait(7000);
		click(By.xpath("//td[@class='align-middle']/input"), "Request Quantity", 30);
	}

	public void validateNotificationPopup() {
		staticWait(1000);
		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Please add at least one item')]"));
			if (notifymessage.isDisplayed()) {
				logger.info("Notify message is displayed -" + notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Notify message popup not displayed");
		}
	}

	public void enterproductnameInCheckOutListSearchField() {
		staticWait(3000);
		logger.info(manageProductPage.productName);
		enter(By.xpath("//div/input[@placeholder='Search']"), manageProductPage.productName, "Product name", 20);
		staticWait(1000);
		click(By.xpath("//div/label[text()='" + manageProductPage.productName + "']"), "Product Name", 30);
	}

	public void verifyProductNameInProductListPage() {
		staticWait(1000);

		try {
			WebElement productName = driver.findElement(
					By.xpath("//table/tbody/tr/td/span[contains(text(),'" + manageProductPage.productName + "')]"));
			if (productName.isDisplayed()) {
				logger.info("Product is displayed in Check Out List Page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product is not displayed in Check Out List Page");
		}
	}

	/*---------------------------------------------------------------------Check Out Request List--------------------------------------------------------------------------*/
	public void clickOnCheckOutRequestList() {
		staticWait(1000);
		click(By.xpath("//div/span/a[@id='ancMyCheckOutRequest']"), "Check Out Request List", 30);

		try {
			WebElement checkOutList = driver.findElement(By.xpath("//div/span[contains(text(),'Check-Out List')]"));
			if (checkOutList.isDisplayed()) {
				logger.info("Check-Out List page not opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Check-Out List page not opened successfully");
		}
	}

	public void clickOnCancelButton() {
		staticWait(1000);
		click(By.xpath("//a[@data-original-title='Cancel']"), "Cancel Button", 30);
	}

	public void clickOnConfirmationButton() {
		staticWait(1000);
		click(By.xpath("//div/button[contains(text(),'OK')]"), "Ok Button", 30);
	}

	public void enterRejectionReason() {
		staticWait(3000);
		enter(By.xpath("//div/textarea[@id='RequsitionRejectComment']"), prop.getProperty("reason"), "Rejection reason",
				20);
	}

	public void clickOnSaveButton() {
		staticWait(1000);
		click(By.xpath("//div/a[@id='btnSaveReqReject']"), "Save Button", 30);
		try {
			WebElement status = driver.findElement(By.xpath("//span[contains(text(),'Cancelled')]"));
			if (status.isDisplayed()) {
				logger.info("In Status field Cancelled is showing");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("In Status field Cancelled is not showing");
		}
	}

	public void clickOnReturnButton() {
		staticWait(2000);
		click(By.xpath("//a/span[text()='Return']"), "Return Button", 30);
		staticWait(2000);
		WebElement returnPage = driver.findElement(By.xpath("//div/h5[contains(text(),'Return')]"));
		if (returnPage.isDisplayed()) {
			logger.info("Return Page Opened Succesfully");

		} else {
			logger.info("Return Page not Opened Succesfully");
		}
	}

	public void selectReason() {
		staticWait(3000);
		selectValueWithText(By.xpath("//tg-select/select[@id='RetrunStatus']"), "Damaged", "Reason", 20);
	}

	public void enterQuantity() {
		staticWait(3000);
		enter(By.xpath("//tg-input/input[@id='NumberOfItems']"), prop.getProperty("quantitys"), "Quantity", 20);
	}

	public void clickOnSubmitButton() {
		staticWait(1000);
		click(By.xpath("//div/a[@id='btnSaveReturn']"), "save Button", 30);
	}

	public void notifyMessage() {
		staticWait(1000);

		try {
			WebElement notifyMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Return Request successfully added')]"));
			if (notifyMessage.isDisplayed()) {
				logger.info(notifyMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Return Request not successfully added");
		}
	}
	/*---------------------------------------------------------------------Code for check the functionality of Accept Button--------------------------------------------------------------------------*/
	public void clickOnAcceptButton() {
		staticWait(2000);
		click(By.xpath("//span/a[@data-original-title='Accept']"), "Accept Button", 30);
		
	}
	/*---------------------------------------------------------------------Code for check the functionality of Reject Button--------------------------------------------------------------------------*/
	public void clickOnRejectButton() {
		staticWait(2000);
		click(By.xpath("//span/a[@data-original-title='Reject']"), "Reject Button", 30);
		
	}
	public void validateRejectedProduct() {
		staticWait(2000);
		try {
			WebElement rejectedProduct = driver.findElement(By.xpath("//table/tbody/tr/td[contains(text(),'No record(s) found')]"));
			if (rejectedProduct.isDisplayed()) {
				logger.info("Product is rejected successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product is not rejected successfully");
		}
		
	}
	/*---------------------------------------------------------------------Code for check the functionality of Consume--------------------------------------------------------------------------*/
	public void clickOnConsumeButton() {
		staticWait(2000);
		click(By.xpath("//span/a[@data-original-title='Consume']"), "Consume Button", 30);
		WebElement returnPage = driver.findElement(By.xpath("//div/h5[contains(text(),'Consume Product')]"));
		if (returnPage.isDisplayed()) {
			logger.info("Consume Product Page Opened Succesfully");

		} else {
			logger.info("Consume Product Page not Opened Succesfully");
		}
	}

	public void enterTag() {
		staticWait(3000);
		enter(By.xpath("//div/textarea[@name='Tag']"), prop.getProperty("tagName"), "Tag", 20);
	}

	public void enterRemarks() {
		staticWait(3000);
		enter(By.xpath("//div/textarea[@id='txtRemarks']"), prop.getProperty("remarks"), "Remarks", 20);
	}

	public void clickOnConsumeSaveButton() {
		staticWait(1000);
		click(By.xpath("//div/a[text()='Save']"), "save Button", 30);
	}

	public void validateConsumequantity() {
		staticWait(1000);

		try {
			String consumequantity = driver.findElement(By.xpath("//span[@class='noti-circle noti-green']")).getText();
			if (!consumequantity.equals(prop.getProperty("quantity"))) {
				logger.info("Available quantity display succesfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Consume quantity is not substracted from available quantity");
		}
	}

	/*---------------------------------------------------------------------Code for check the functionality of Replace requset--------------------------------------------------------------------------*/
	public void clickOnReplaceButton() {
		staticWait(2000);
		click(By.xpath("//a/span[text()='Replace Request']"), "Replace Request", 30);
		WebElement returnPage = driver.findElement(By.xpath("//div/h5[contains(text(),'Replace Request')]"));
		if (returnPage.isDisplayed()) {
			logger.info("Replace Request Page Opened Succesfully");

		} else {
			logger.info("Replace Request Page not Opened Succesfully");
		}
	}
	

	public void enterReplaceRequestRemarks() {
		staticWait(3000);
		enter(By.xpath("//tg-textarea/textarea[@id='Comment']"), prop.getProperty("remarks"), "Remarks", 20);
	}

	public void notifyMessageForReplaceRequest() {
		staticWait(1000);

		try {
			WebElement notifyMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Replace Request sent successfully')]"));
			if (notifyMessage.isDisplayed()) {
				logger.info(notifyMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Replace Request not sent successfully");
		}
	}
	/*---------------------------------------------------------------------Code for check the functionality of Self Check Out request--------------------------------------------------------------------------*/
	public void clickOnSelfCheckOutButton() {
		staticWait(2000);
		click(By.xpath("//a/span[text()='Self Check Out']"), "Self Check Out", 30);
		WebElement selfCheckOutPage = driver.findElement(By.xpath("//div/h5[contains(text(),'Self Checkout')]"));
		if (selfCheckOutPage.isDisplayed()) {
			logger.info("Self Checkout Request Page Opened Succesfully");

		} else {
			logger.info("Self Checkout Request Page not Opened Succesfully");
		}
	}
	public void enternumaberofProducts() {
		staticWait(3000);
		enter(By.xpath("//tg-input/input[@id='NumberOfItems']"), prop.getProperty("quantitys"), "Product Quantity", 20);
	}


	public void enterSelfCheckoutRequestRemarks() {
		staticWait(3000);
		enter(By.xpath("//tg-textarea/textarea[@id='txtremarks']"), prop.getProperty("remarks"), "Remarks", 20);
	}

	public void notifyMessageForSelfCheckOutRequest() {
		staticWait(1000);

		try {
			WebElement notifyMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Self Check-Out Successfully')]"));
			if (notifyMessage.isDisplayed()) {
				logger.info(notifyMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Self Check-Out not Successfully");
		}
	}
	/*---------------------------------------------------------------------Code for check the functionality of Product Transfer--------------------------------------------------------------------------*/
	public void clickOnTransferButton() {
		staticWait(2000);
		click(By.xpath("//a/span[text()='Transfer']"), "", 30);
		WebElement transferPage = driver.findElement(By.xpath("//div/h5[contains(text(),'Product Transfer')]"));
		if (transferPage.isDisplayed()) {
			logger.info("Transfer Request Page Opened Succesfully");

		} else {
			logger.info("Transfer Request Page not Opened Succesfully");
		}
	}
	public void clickOnProductCheckBox() {
		staticWait(3000);
		click(By.xpath("//td/div[@class='custom-control custom-checkbox']"), "Check Box", 20);
	}
	public void enterTranferProductsQuantity() {
		staticWait(3000);
		enter(By.xpath("//td/input[@id='txtAvailableItems1']"), prop.getProperty("quantitys"), "Product Quantity", 20);
	}
	public void selectlLocation() {
		staticWait(1000);
		click(By.xpath("//div/span[text()='Select']"), "Location Dropdown", 20);
		staticWait(1000);
		click(By.xpath("//a/span[text()='Texas']"), "Location ", 20);
	}

	public void selectUser() {
		staticWait(3000);
		selectValueWithText(By.xpath("//div/select[@id='AssetUserId']"), "David Bush", "User", 20);
	}

	public void enterTransferRequestRemarks() {
		staticWait(3000);
		enter(By.xpath("//div/textarea[@id='txtRemarks']"), prop.getProperty("remarks"), "Remarks", 20);
	}

	public void notifyMessageForTransferRequest() {
		staticWait(1000);

		try {
			WebElement notifyMessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Products has been successfully transferred')]"));
			if (notifyMessage.isDisplayed()) {
				logger.info(notifyMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Products hasn't been successfully transferred");
		}
	}


	/*---------------------------------------------------------------------Code for check the functionality of Request quantity--------------------------------------------------------------------------*/
	public void clickOnRequestQuantity() {
		staticWait(2000);
		click(By.xpath("//a[@data-original-title='Request Quantity']/span[text()='Request Quantity']"),
				"Request Quantity", 30);
		WebElement requestQuantityPage = driver.findElement(By.xpath("//div/h5[contains(text(),'Request Product')]"));
		if (requestQuantityPage.isDisplayed()) {
			logger.info("Request Product Page Opened Succesfully");

		} else {
			logger.info("Request Product Page not Opened Succesfully");
		}
	}

	public void enterRequesQuantitytRemarks() {
		staticWait(3000);
		enter(By.xpath("//div/textarea[@id='Comment']"), prop.getProperty("remarks"), "Remarks", 20);
	}

}
