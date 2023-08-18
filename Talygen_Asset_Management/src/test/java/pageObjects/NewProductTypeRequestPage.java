package pageObjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class NewProductTypeRequestPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);
	static String producttypename;
	static String productname;
	ProductTypePage productTypePage;
	ManageProductPage manageProductPage;
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public NewProductTypeRequestPage(WebDriver driver) {
		super(driver, "New Product Type Request Page");
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

	public void clickOnNewProductTypeRequest() {
		staticWait(2000);
		WebElement Element = driver.findElement(By.xpath("//div/h4[text()='Item Assignment']"));
		staticWait(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		staticWait(1000);
		click(By.xpath("//div/ul/li/a[@data-original-title='New Product Type Request']"), "New Product Type Request",
				30);
		staticWait(2000);
		WebElement newProductTypeRequest = driver
				.findElement(By.xpath("//div/span[text()='New Product Type Request']"));
		if (newProductTypeRequest.isDisplayed()) {
			logger.info("New Product Type Request page opened successfully");

		} else {
			logger.info("New Product Type Request page not opened successfully");
		}

	}

	public void clickOnNewRequestProductType() {
		staticWait(3000);
		click(By.xpath("//div/span/a[@id='ancCreateJob']"), "New Product Type Request", 30);
		staticWait(2000);
		WebElement NewProductTypeRequest = driver
				.findElement(By.xpath("//div/span[contains(text(),'New Product Type Request')]"));
		if (NewProductTypeRequest.isDisplayed()) {
			logger.info("New Product Type Request page opened successfully");

		} else {
			logger.info("New Product Type Request page not opened successfully");
		}

	}

	public void clickOnSave() {
		staticWait(2000);

		click(By.xpath("//div/button[contains(text(),'Save')]"), "Save Button", 30);

	}
	public void verifyNotifyMessage() {
		staticWait(2000);

		WebElement notifyMessage = driver.findElement(By.xpath("//div/span[contains(text(),'Please correct the highlighted errors')]"));
		try {
			if (notifyMessage.isDisplayed()) {
				logger.info("Notify Message dispayed succesfully");
				click(By.xpath("//button[@id='closenotifymessage']"), "Close NotifyMessage popup", 30);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("Notify Message not dispayed succesfully");
		}
	}

	public void VerifyMandatoryFieldValidationOfAddProductPage() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='form-group']//span[contains(@class,'invalid-feedback')]"), 15);
		String[] expectedValue = { "Location","Product Name","Requested Quantity","Description","Vendor" };
		for (Object expected : expectedValue) {
			WebElement AsteriskField = findElementVisibility(By.xpath("//label[contains(text(),'" + expected
					+ "')]/ancestor::div[@class='form-group']/descendant::span[text()='*']"), 20);
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

	public void clickOnCancel() {
		staticWait(2000);

		click(By.xpath("//div/a[@data-original-title='Cancel']"), "Cancel Button", 30);

	}
	public void selectLocation() {
		staticWait(3000);
		click(By.xpath("//div[@type='button']"), "Location Dropdown", 30);
		click(By.xpath("//li/a/span[text()='Dallas']"), "Location", 20);

	}
	public void EnterProductName() {
		staticWait(3000);
		productname = prop.getProperty("productname") + datevalue;
		
		enter(By.xpath("//div/input[@name='productName']"), productname, " Product Name", 20);

	}
	public void EnterRequestQuantity() {
		staticWait(3000);
		String quantity = prop.getProperty("quantity") ;
		
		enter(By.xpath("//div/input[@id='Quantity']"), quantity, "Requested Quantity", 20);

	}

	public void EnterProductTypeName() {
		staticWait(3000);
		producttypename = productTypePage.productname;
		click(By.xpath("//div/select[@id='AssetTypeFilter']"), "Product Type Dropdown", 30);
		logger.info(producttypename);
		staticWait(2000);
		selectValueWithText(By.xpath("//div/select[@id='AssetTypeFilter']"), producttypename, " Product Type Name", 20);

	}

	public void EnterDescription() {
		staticWait(2000);

		enter(By.xpath("//tg-textarea/textarea[@id='Description']"), prop.getProperty("Description"), " Description",
				20);

	}
	public void selectVendor() {
		staticWait(3000);
		
		selectValueWithText(By.xpath("//div/select[@id='QVendor']"), "Vendor", "Vendor", 20);

	}
	public void EnterVendorRequestQuantity() {
		staticWait(3000);
		String quantity = prop.getProperty("quantity") ;
		
		enter(By.xpath("//div/input[@id='QuoteQuantity']"), quantity, "Requested Quantity", 20);

	}
	public void selectCurrency() {
		staticWait(3000);
		
		selectValueWithText(By.xpath("//div/select[@id='QCurrency']"), "United States dollar (USD)", "Currency", 20);

	}
	public void EnterUnitPrice() {
		staticWait(3000);
		String unitPrice = prop.getProperty("unitPrice") ;
		
		enter(By.xpath("//div/input[@id='QuoteAmount']"), unitPrice, "Unit Price", 20);
		click(By.xpath("//div/input[@id='QuoteQuantity']"), "Requested Quantity", 30);

	}
	 public void UploadAttachment()
     {
    	 
    	 uploadDoc(By.cssSelector("input#flFile"),filePath+prop.getProperty("testfileDoc"), "Attachment", 30);
     }

	public void validateNotifyMessage() {
		staticWait(2000);

		try {
			WebElement noifyMessage = driver.findElement(
					By.xpath("//div/span[contains(text(),'New Product Type Request successfully added')]"));
			if (noifyMessage.isDisplayed()) {
				logger.info(noifyMessage.getText());

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("New Product Type Request not added successfully");
		}
	}

	public void clickOnExpandAllorCollapseAll() {
		staticWait(2000);

		clickByJavascript(By.xpath("//div/a[text()='Expand All or Collapse All']"), "Expand All or Collapse All", 30);

	}
	public void EnterTitle() {
		staticWait(2000);

		enter(By.xpath("//div/input[@id='search']"),producttypename , "Title",
				20);

	}
	public void clickOnSearch() {
		staticWait(2000);

		clickByJavascript(By.xpath("//span/a[@data-original-title='Click here to search']"), "Search Button", 30);

	}

	public void validateNewaddedProductTypeInProductListPage() {
		staticWait(2000);
		
		try {
			WebElement productType = driver.findElement(
					By.xpath("//table/tbody/tr/td/span[contains(text(),'"+producttypename+"')]"));
			if (productType.isDisplayed()) {
				logger.info(productType.getText()+"Is displayed on New Product Type Request List Page");

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product is not displayed on New Product Type Request List Page");
		}
	}
	public void clickOnCheckBox() {
		staticWait(2000);

		click(By.xpath("//div[@class='custom-control custom-checkbox']"), "Check Box", 30);

	}
	public void clickOnRemoveButton() {
		staticWait(2000);

		clickByJavascript(By.xpath("//div/span/a[@data-original-title='Delete Product Type Request']"), "Remove Button", 30);

	}
	public void clickOnConfirmationButton() {
		staticWait(2000);

		click(By.xpath("//div/button[@title='OK']"), "Ok", 30);
		
	}
	public void validateNotifyMessageForRemoveProductType() {
		staticWait(2000);

		try {
			WebElement noifyMessage = driver.findElement(
					By.xpath("//div/span[contains(text(),'New Product Type Requests has been successfully deleted')]"));
			if (noifyMessage.isDisplayed()) {
				logger.info(noifyMessage.getText());

			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("New Product Type Requests has not been successfully deleted");
		}
	}
	public void clickOnViewButton() {
		staticWait(2000);

		click(By.xpath("//table/tbody/tr/td/a[@data-original-title='View']"), "View Button", 30);
		
	}
	public void EnterApprovedCommentTitle() {
		staticWait(2000);

		enter(By.xpath("//div/input[@id='CommentTitle']"),prop.getProperty("approveComment") , "Comment title",
				20);

	}
	public void EnterRejectedCommentTitle() {
		staticWait(2000);

		enter(By.xpath("//div/input[@id='CommentTitle']"),prop.getProperty("rejectedComment") , "Comment title",
				20);

	}
	public void EnterCommentDescription() {
		staticWait(2000);

		enter(By.xpath("//div/textarea[@id='CommentDescription']"),prop.getProperty("Description") , "Description",
				20);

	}
	public void clickOnPostComment() {
		staticWait(2000);

		clickByJavascript(By.xpath("//div/a[@data-original-title='Post New Comment']"), "Post New Comment", 30);
		
		try {
			WebElement commentNotifyMessage = driver.findElement(By.xpath("//div/span[contains(text(),'Comment has been successfully submitted')]"));
			if (commentNotifyMessage.isDisplayed()) {
				logger.info(commentNotifyMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Comment hasn't been successfully submitted");
		}
	}
	public void clickOnApproveButton() {
		staticWait(2000);

		click(By.xpath("//div/span/input[@title='Approve']"), "Approved", 30);
		staticWait(1000);
		WebElement approveNotifyMessage = driver.findElement(By.xpath("//div/span[contains(text(),'New Product Type Request has been successfully approved ')]"));
		try {
			if (approveNotifyMessage.isDisplayed()) {
				logger.info(approveNotifyMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("New Product Type Request hasn't been successfully approved");
		}
	}
	public void clickOnRejectButton() {
		staticWait(2000);

		click(By.xpath("//div/span/input[@title='Reject']"), "Reject", 30);
		staticWait(1000);
		WebElement rejectNotifyMessage = driver.findElement(By.xpath("//div/span[contains(text(),'New Product Type Request has been successfully rejected')]"));
		try {
			if (rejectNotifyMessage.isDisplayed()) {
				logger.info(rejectNotifyMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("New Product Type Request hasn't been successfully rejected");
		}
	}

}
