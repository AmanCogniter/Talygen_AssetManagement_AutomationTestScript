package pageObjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import utils.DateTime;
import utils.PropertiesLoader;
import utils.WebBasePage;

public class ProductReportPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);
	
	
	  DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); Calendar cal =
	  Calendar.getInstance(); Date todaydate = cal.getTime(); String todaysdate =
	  dateFormat.format(date);
	 
     
	DateTime dateTime;
	ProductTypePage productTypePage;
	ManageProductPage manageProductPage;
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public ProductReportPage(WebDriver driver) {
		super(driver, "Product Report Page");
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

	public void clickOnProductReport() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[text()='Product Report']"), "Product Report", 30);
		staticWait(2000);
		WebElement productreportPage = driver.findElement(By.xpath("//div/span[text()='Product Type Reports']"));
		if (productreportPage.isDisplayed()) {
			logger.info("Product Assignment Report list page opened successfully");

		} else {
			logger.info("Product Assignment Report list page not opened successfully");
		}
	}

	public void clickOnProductAssignmentReport() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[text()='Product Assignment Report']"), "Product Assignment Report", 30);
	}
	public void VerifyMandatoryFieldValidationOfProductAssignmentReport() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='form-group is-invalid']//span[contains(@class,'field-validation-valid')]"), 15);
		String[] expectedValue = { "Location" };
		for (Object expected : expectedValue) {
			WebElement AsteriskField = findElementVisibility(By.xpath("//label[contains(text(),'"+expected+"')]/parent::div[@class='form-group is-invalid']/descendant::span[@class='text-danger']"), 20);
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

	public void clickOnLocationDropDown() {
		staticWait(2000);
		click(By.xpath("//div[@type='button']"), "Location DropDown", 30);
	}

	public void clickOnLocation() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/ol/li/a/span[text()='Dallas']"), "Location", 30);
	}

	public void selectProductType() {
		staticWait(2000);
		click(By.xpath("//div/button[@title='Select']"), "Select Product type dropdown", 30);
		staticWait(1000);
		/*
		 * selectValueWithText(By.xpath("//li/a/label[contains(text(),'" +
		 * productTypePage.productname + "')]"), productTypePage.productname,
		 * "Product Type", 30);
		 */
		click(By.xpath("//li/a/label[contains(text(),'" + productTypePage.productname + "')]"), "Product type", 30);
	}

	public void selectProductName() {
		staticWait(2000);
		click(By.xpath("//div/button[@title='Select']"), "Select Product Name dropdown", 30);
		staticWait(1000);

		click(By.xpath("//li/a/label[contains(text(),'" + manageProductPage.productName + "')]"), "Product Name", 30);
	}

	public void selectTodaydate() {
		staticWait(2000);
		click(By.xpath("//div[@data-target='#datepicker2']"), "Select Date dropdown", 30);
		staticWait(1000);

		click(By.xpath("//div[@data-target='#datepicker2']"), "Today Date", 30);
	}

	public void clickOnSearch() {
		staticWait(3000);
		clickByJavascript(By.xpath("//div/a[contains(text(),'Search')]"), "Search Button", 30);
	}

	public void validateProjectReport() {
		staticWait(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iReport']"));
		driver.switchTo().frame(iframe);
		staticWait(5000);
		WebElement report = driver.findElement(By.xpath("//div[contains(text(),'Item Report')]"));
		try {
			if (report.isDisplayed()) {
				logger.info("Project report displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Project report displayed successfully");
		}
	}

	public void validateProjectNameInReport() {
		staticWait(2000);
		click(By.xpath(
				"//div[@class='e-reportviewer-paragrap']/div[contains(text(),'ginny')]/ancestor::div[@class='e-reportviewer-txtitem e-reportviewer-tab-focus-none']/div"),
				"User name", 30);

		try {
			staticWait(3000);
			String report = driver
					.findElement(By.xpath("//div[contains(text(),'" + productTypePage.productname + "')]")).getText();
			if (report.contains(productTypePage.productname)) {
				logger.info(productTypePage.productname + " is displayed successfully on Report");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(productTypePage.productname + " is not displayed successfully on Report");
		}
		driver.navigate().refresh();
	}

	/*----------------------------------------------------------Audit Log Report-----------------------------------------------------------------------------------------------------------*/
	public void clickOnAuditLogReport() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[text()='Audit Log Report']"), "Audit Log Report", 30);
	}
	public void VerifyMandatoryFieldValidationOfAuditLogReport() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//div[@class='form-group is-invalid']//span[contains(@class,'field-validation-valid')]"), 15);
		String[] expectedValue = { "Location" };
		for (Object expected : expectedValue) {
			WebElement AsteriskField = findElementVisibility(By.xpath("//label[contains(text(),'"+expected+"')]/parent::div[@class='form-group is-invalid']/descendant::span[@class='text-danger']"), 20);
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
	public void selectProductNameForAuditLogReport() {
		staticWait(2000);
		click(By.xpath("//div/button[@title='Select']"), "Select Product Name dropdown", 30);
		staticWait(1000);
		enter(By.xpath("//div/input[@placeholder='Enter Keywords']"), manageProductPage.productName, "Remark", 20);
		staticWait(1000);
		click(By.xpath("//li/a/label[contains(text(),'" + manageProductPage.productName + "')]"), "Product Name", 30);
		staticWait(2000);
	}

	public void validateAuditLogReport() {
		staticWait(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iReport']"));
		driver.switchTo().frame(iframe);
		staticWait(5000);
		WebElement report = driver.findElement(By.xpath("//div[contains(text(),'Item Audit Log Report')]"));
		try {
			if (report.isDisplayed()) {
				logger.info("Audit Log report displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Audit Log report not displayed successfully");
		}
		driver.navigate().refresh();
	}

	/*--------------------------------------------------------------Code for Product Barcode Report------------------------------------------------------------*/
	public void clickOnProductBarcodeReport() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[text()='Product Barcode Report']"), "Product Barcode Report", 30);
	}
	public void VerifyMandatoryFieldValidationOfProductBarcodeReport() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//span[contains(@class,'field-validation-valid')]"), 15);
		String[] expectedValue = { "Location" };
		for (Object expected : expectedValue) {
			WebElement AsteriskField = findElementVisibility(By.xpath("//label[contains(text(),'"+expected+"')]/parent::div[@class='form-group is-invalid']/descendant::span[@class='text-danger']"), 20);
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
	public void validateProductBarcodeReport() {
		staticWait(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iReport']"));
		driver.switchTo().frame(iframe);
		staticWait(5000);
		WebElement report = driver.findElement(By.xpath("//div[contains(text(),'Product Barcode Report')]"));
		try {
			if (report.isDisplayed()) {
				logger.info("Product Barcode Report displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product Barcode Report not displayed successfully");
		}
	}
	public void validateProjectNameInProductBarcodeReport() {
		staticWait(2000);
		

		try {
			staticWait(3000);
			WebElement report = driver
					.findElement(By.xpath("//div[contains(text(),'" + productTypePage.productname + "')]"));
			if (report.isDisplayed()) {
				logger.info(productTypePage.productname + " is displayed successfully on Report");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(productTypePage.productname + " is not displayed successfully on Report");
		}
		driver.navigate().refresh();
	}
	/*--------------------------------------------------------------Item Log History Report------------------------------------------------------------*/
	public void clickOnItemLogHistoryReport() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[text()='Item Log History Report']"), "Item Log History Report", 30);
	}
	public void VerifyMandatoryFieldOfItemLogHistoryReport() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//span[contains(@class,'field-validation-valid invalid-feedback d-block')]"), 15);
		String[] expectedValue = { "Location" };
		for (Object expected : expectedValue) {
			WebElement AsteriskField = findElementVisibility(By.xpath("//label[contains(text(),'"+expected+"')]/parent::div[@class='form-group is-invalid']/descendant::span[@class='text-danger']"), 20);
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
	public void validateItemLogHistoryReport() {
		staticWait(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iReport']"));
		driver.switchTo().frame(iframe);
		staticWait(5000);
		WebElement report = driver.findElement(By.xpath("//div[contains(text(),'Item Log History Report')]"));
		try {
			if (report.isDisplayed()) {
				logger.info("Project report displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Project report displayed successfully");
		}
	}
	public void validateItemInItemLogHistoryReport() {
		staticWait(2000);
		click(By.xpath(
				"//div[@class='e-reportviewer-txtitem e-reportviewer-tab-focus-none']/div[@class='e-reportviewer-toggleicon ej-reportviewericonsexpand txtToggle_viewer']"),
				"Item", 30);

		try {
			staticWait(3000);
			String report = driver
					.findElement(By.xpath("//div[contains(text(),'" + manageProductPage.productName + "')]")).getText();
			if (report.contains(manageProductPage.productName)) {
				logger.info(manageProductPage.productName + " is displayed successfully on Report");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(manageProductPage.productName + " is not displayed successfully on Report");
		}
		driver.navigate().refresh();
	}
	public void selectUniqueProductName() {
		staticWait(2000);
		click(By.xpath("//div/button[@title='Select']"), "Select Unique Product Name dropdown", 30);
		staticWait(2000);

		click(By.xpath("(//li/a/label[contains(text(),'" + manageProductPage.productName + "')])[last()]"), "Unique Product Name", 30);
	}
	public void selectTodaydateOfItemLogHistoryReport() {
		staticWait(2000);
		/*
		 * click(By.xpath("//div[@data-target='#datepickerFromLogHistory']"),
		 * "Select Date dropdown", 30); staticWait(1000);
		 * 
		 * click(By.xpath("//div[@data-target='#datepickerFromLogHistory']"),
		 * "Today Date", 30);
		 */
		
		enter(By.xpath("//div/input[@id='datepickerFromLogHistory']"),todaysdate, "Date", 20);
	}
	public void validateItemInItemLogHistoryReportWithAssignDate() {
		staticWait(2000);
		click(By.xpath(
				"//div[@class='e-reportviewer-txtitem e-reportviewer-tab-focus-none']/div[@class='e-reportviewer-toggleicon ej-reportviewericonsexpand txtToggle_viewer']"),
				"Item", 30);

		try {
			staticWait(3000);
			String report = driver
					.findElement(By.xpath("//div[contains(text(),'" + manageProductPage.productName + "')]")).getText();
			if (report.contains(manageProductPage.productName)) {
				logger.info(manageProductPage.productName + " is displayed successfully on Report");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(manageProductPage.productName + " is not displayed successfully on Report");
		}
		driver.navigate().refresh();
	}
	/*--------------------------------------------------------------Product Count Report------------------------------------------------------------*/
	public void clickOnProductCountReport() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[text()='Product Count Report']"), "Product Count Report", 30);
	}
	public void VerifyMandatoryFieldOfProductCountReport() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//span[contains(@class,'field-validation-valid invalid-feedback d-block')]"), 15);
		String[] expectedValue = { "Location" };
		for (Object expected : expectedValue) {
			WebElement AsteriskField = findElementVisibility(By.xpath("//label[contains(text(),'"+expected+"')]/ancestor::div[@class='row']/descendant::span[@class='text-danger']"), 20);
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
	public void selectProductTypeForProductCountReport() {
		staticWait(2000);
		click(By.xpath("//div/button/span[text()='Select']"), "Select Product type dropdown", 30);
		staticWait(1000);
		/*
		 * selectValueWithText(By.xpath("//li/a/label[contains(text(),'" +
		 * productTypePage.productname + "')]"), productTypePage.productname,
		 * "Product Type", 30);
		 */
		click(By.xpath("//li/a/label[contains(text(),'" + productTypePage.productname + "')]"), "Product type", 30);
	}
	public void clickOnLocationOfProductCountReport() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div/select[@id='LocationId']"), "Dallas (--)", "Location", 30);
	}
	public void selectTodaydateOfProductCountReport() {
		staticWait(2000);
		/*
		 * click(By.xpath("//div[@data-target='#datepickerFromLogHistory']"),
		 * "Select Date dropdown", 30); staticWait(1000);
		 * 
		 * click(By.xpath("//div[@data-target='#datepickerFromLogHistory']"),
		 * "Today Date", 30);
		 */
		
		enter(By.xpath("//div/input[@id='datepicker2']"),todaysdate, "Date", 20);
	}
	/*--------------------------------------------------------------Product Report------------------------------------------------------------*/
	public void clickOnProductReports() {
		staticWait(2000);
		click(By.xpath("(//div/ul/li/a[text()='Product Report'])[last()]"), "Product Report", 30);
	}
	public void VerifyMandatoryFieldOfProductReport() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//span[contains(@class,'field-validation-valid invalid-feedback d-block')]"), 15);
		String[] expectedValue = { "Location" };
		for (Object expected : expectedValue) {
			WebElement AsteriskField = findElementVisibility(By.xpath("//label[contains(text(),'"+expected+"')]/ancestor::div[@class='row']/descendant::span[@class='text-danger']"), 20);
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
	public void selectProductTypeForProductReport() {
		staticWait(2000);
		
		  click(By.xpath("(//div/button[@title='Select'])[2]"),
		  "Select Product type dropdown", 30); 
		  staticWait(2000);
		 
		
			/*
			 * enter(By.
			 * xpath("//button[@title='Select']/ancestor::div[@class='btn-group show']/descendant::div/input[@placeholder='Enter Keywords']"
			 * ), productTypePage.productname, "Product Type", 30); staticWait(1000);
			 */
		click(By.xpath("//li/a/label[contains(text(),'" + productTypePage.productname + "')]"), "Product type", 30);
		staticWait(1000);
		click(By.xpath("(//div/button[@title='Select'])[2]"), "Select Product type dropdown", 30);
	}
	public void selectTagTypeForProductReport() {
		staticWait(2000);
		click(By.xpath("//div/button/span[text()='Select']"), "Select tag type dropdown", 30);
		staticWait(1000);
		/*
		 * selectValueWithText(By.xpath("//li/a/label[contains(text(),'" +
		 * productTypePage.productname + "')]"), productTypePage.productname,
		 * "Product Type", 30);
		 */
		click(By.xpath("//li/a/label[contains(text(),'" + productTypePage.tagname + "')]"), "Tag type", 30);
		click(By.xpath("//div/button/span[text()='Select']"), "Select tag type dropdown", 30);
	}
	public void validateProjectReports() {
		staticWait(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		WebElement iframe = driver.findElement(By.xpath("//iframe[@id='iReport']"));
		driver.switchTo().frame(iframe);
		staticWait(5000);
		WebElement report = driver.findElement(By.xpath("//div[contains(text(),'Product Report')]"));
		try {
			if (report.isDisplayed()) {
				logger.info("Project report displayed successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Project report displayed successfully");
		}
	}
	public void validateProjectNameInProjectReport() {
		staticWait(2000);
		click(By.xpath(
				"//div[@class='e-reportviewer-txtitem e-reportviewer-tab-focus-none']/div[@class='e-reportviewer-toggleicon ej-reportviewericonsexpand txtToggle_viewer']"),
				"Expand arrow", 30);

		try {
			staticWait(3000);
			String report = driver
					.findElement(By.xpath("//div[contains(text(),'" + productTypePage.tagname + "')]")).getText();
			if (report.contains(productTypePage.productname)) {
				logger.info(productTypePage.productname + " is displayed successfully on Report");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(productTypePage.productname + " is not displayed successfully on Report");
		}
		driver.navigate().refresh();
	}
}
