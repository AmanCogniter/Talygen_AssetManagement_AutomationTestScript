package pageObjects;

import static reporting.ComplexReportFactory.getTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class ProductContainerListPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);
	static String compartmentName;
	static String tagname;
	static String productname;
	static String containerName;
	ProductTypePage productTypePage;

	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public ProductContainerListPage(WebDriver driver) {
		super(driver, "Product Container List Page");
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

	public void clickOnProductsContainerList() {
		staticWait(2000);
		click(By.xpath("//div/ul/li/a[@data-original-title='Products Container List']"), "Products Container List", 30);
		staticWait(2000);
		WebElement productsContainerPage = driver.findElement(By.xpath("//div/span[@id='titleName']"));
		if (productsContainerPage.isDisplayed()) {
			logger.info("Products Container page opened successfully");

		} else {
			logger.info("Products Container page not opened successfully");
		}

	}

	public void clickOnAddProductContainer() {
		staticWait(2000);
		click(By.xpath("//span/a[@data-original-title='Add Product Container']"), "Add Product Container", 30);
		staticWait(2000);
		WebElement addProductContainerListPage = driver
				.findElement(By.xpath("//div/span[text()='Add Product Container List']"));
		if (addProductContainerListPage.isDisplayed()) {
			logger.info("Add Product Container List page opened successfully");

		} else {
			logger.info("Add Product Container List page not opened successfully");
		}

	}

	public void clickOnSelectProductType() {
		staticWait(3000);
		logger.info(productTypePage.productname);
		selectValueWithText(By.xpath("//tg-select/select[@id='AssetTypeId']"), productTypePage.productname,
				"Product Type", 30);
	}

	public void clickOnSelectLocation() {
		staticWait(2000);
		click(By.xpath("//div[@class='btn form-control']/span"), "Location dropdown", 30);
		staticWait(1000);
		click(By.xpath("//div/ul/li/ol/li/a/span[text()='Dallas']"), "Location", 30);
	}

	public void clickOnSelectProductName() {
		staticWait(2000);
		click(By.xpath("//div/button[@title='Select']/span"), "Product Name dropdown", 30);
		staticWait(1000);
		enter(By.xpath("//div/input[@placeholder='Enter Keywords']"), ManageProductPage.productName, "Product Name",
				30);
		staticWait(1000);
		click(By.xpath(" //a/label[contains(text(),'" + ManageProductPage.productName + "')]"),
				"Product name radio button", 30);
	}

	public void clickOnSelectContainer() {
		staticWait(2000);
		click(By.xpath("//tg-select/select[@id='ParentRelatedInfoId']"), "select container", 30);
		staticWait(2000);
		containerName = driver.findElement(By.xpath("//tg-select/select[@id='ParentRelatedInfoId']/option[2]"))
				.getText();
		click(By.xpath("//tg-select/select[@id='ParentRelatedInfoId']/option[2]"), "Container name", 30);
	}

	public void clickOnSelectCompartments() {
		staticWait(2000);
		click(By.xpath("//div/select[@id='ddlCompartmentId0']"), "select Compartment", 30);
		staticWait(2000);
		click(By.xpath("//div/select[@id='ddlCompartmentId0']/option[2]"), compartmentName, 30);
	}

	public void clickOnAddNewRowPlusIcon() {
		staticWait(2000);
		clickByJavascript(By.xpath("//div/span/a[@id='ancAddRow']"), "Add New Row Plus Icon", 30);
	}

	public void clickOnSelectSecondProductName() {
		staticWait(2000);
		click(By.xpath("//div/button[@title='Select']/span"), "Product Name dropdown", 30);
		staticWait(1000);
		click(By.xpath("(//div/ul[@class='multiselect-container dropdown-menu show']/li)[3]"), " Product Name", 30);

	}

	public void clickOnSelectCompartmentsForSecondProduct() {
		staticWait(2000);
		click(By.xpath("//div/select[@id='AssetsGroupItemsList_1__CompartmentId']"), "select Compartment", 30);
		staticWait(2000);
		click(By.xpath("//div/select[@id='AssetsGroupItemsList_1__CompartmentId']/option[2]"), compartmentName, 30);
	}

	public void clickOnSaveButton() {
		staticWait(2000);
		click(By.xpath("//div/a[text()='Save']"), "Save Button", 30);
	}

	public void VerifyMandatoryFieldValidationOfAddProductTypePage() {
		int i = 0;
		String actualText;
		String expectedText;

		List<WebElement> errorMessageLocator = findMultipleElement(
				By.xpath("//span[contains(@class,'invalid-feedback') or contains(@class,'field-validation')]"), 15);
		String[] expectedValue = { "Location", "Select Container" };
		for (Object expected : expectedValue) {
			WebElement AsteriskField = findElementVisibility(By.xpath("//label[text()='" + expected
					+ "']/ancestor::div[@class='form-group']/descendant::span[@class='mandatory']"), 20);
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

	public void captureNotifyMessage() {
		staticWait(3000);
		try {
			WebElement notifyMessagepopUp = driver
					.findElement(By.xpath("//div/span[contains(text(),'Product Container successfully added')]"));
			if (notifyMessagepopUp.isDisplayed()) {
				logger.info(notifyMessagepopUp.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Product Container not added successfully ");
		}

	}

	public void enterContainerNameInSearchTextField() {
		staticWait(3000);

		enter(By.xpath("//div/input[@id='search']"), containerName, "Product Name", 30);
	}

	public void clickOnSearch() {
		staticWait(2000);

		clickByJavascript(By.xpath("//div/a[@id='Go']"), "Search Button", 30);
	}

	public void clickOnCheckBox() {
		staticWait(2000);

		click(By.xpath("//tbody/tr/td/div[@class='custom-control custom-checkbox']"), "Check Box", 30);
	}

	public void clickOnActiveButton() {
		staticWait(2000);

		click(By.xpath("//span/a[@id='ancActInact']"), "Active Button", 30);
	}

	public void clickOnConfirmationButton() {
		staticWait(2000);

		click(By.xpath("//div/button[contains(text(),'OK')]"), "Ok Button", 30);
	}

	public void validateNotifyMessage() {
		staticWait(2000);

		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Status has been successfully updated')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("Status hasn't been successfully updated");
		}
	}

	public void clickOnINActiveButton() {
		staticWait(2000);

		click(By.xpath("//span/a[@data-original-title='Inactive']"), "InActive Button", 30);
	}
	public void clickOnDeleteeButton() {
		staticWait(2000);

		click(By.xpath("//span/a[@id='DeleteMultiple']"), "Delete Button", 30);
	}
	public void validateNotifyMessageForDeleteButton() {
		staticWait(2000);

		try {
			WebElement notifymessage = driver
					.findElement(By.xpath("//div/span[contains(text(),'Product Container has been successfully deleted')]"));
			if (notifymessage.isDisplayed()) {
				logger.info(notifymessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("Product Container hasn't been successfully deleted");
		}
	}
	public void clickOnrefreshButton() {
		staticWait(2000);

		clickByJavascript(By.xpath("//div/a[contains(@data-original-title,'Clear all')]"), "Refresh Button", 30);
	}
	public void validateNotifyMessageForRefreshButton() {
		staticWait(2000);

		try {
			String notifymessage = driver
					.findElement(By.xpath("//div/input[@id='search']")).getAttribute("value");
			if (notifymessage.contains(containerName)) {
				logger.info("Refresh Button not clicked");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			logger.info("Refresh Button clicked");
		}
	}
}
