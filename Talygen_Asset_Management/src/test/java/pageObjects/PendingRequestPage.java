package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class PendingRequestPage extends WebBasePage {
	WebDriver driver;
	String pattern = "yyMMddHHmmss";
	Date date = new Date();
	SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	String datevalue = dateformat.format(date);
	// static String productname;
	static String firstrowdata;
	static String pairedProductName;
	static String productName;
	static String secondrowdata;
	ManageProductPage manageProductPage;
	ProductTypePage productTypePage;
	String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	private final static String FILE_NAME = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\testdata.properties";
	private static Properties prop = new PropertiesLoader(FILE_NAME).load();

	public PendingRequestPage(WebDriver driver) {
		super(driver, "Pending Request Page");
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

	public void clickOnPendingRequest() {
		staticWait(2000);
		WebElement Element = driver.findElement(By.xpath("//div/h4[text()='Item Assignment']"));
		staticWait(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		click(By.xpath("//div/ul/li/a[@data-original-title='Pending Requests']"), "Pending request", 30);
		staticWait(3000);
		WebElement pemdingRequestPage = driver.findElement(By.xpath("//div/span[text()='Pending Check Out Request']"));
		if (pemdingRequestPage.isDisplayed()) {
			logger.info("Pending Check Out Request list page opened successfully");

		} else {
			logger.info("Pending Check Out Request list page not opened successfully");
		}

	}

	public void clickOnSelectProductName() {
		staticWait(3000);
		click(By.xpath("//div/select[@id='catalogId']"), "Product Name DropDown", 30);
		selectValueWithText(By.xpath("//div/select[@id='catalogId']"), manageProductPage.productName, "Product Name", 30);

	}

	public void clickOnSearchButton() {
		staticWait(1000);
		click(By.xpath("//div/a/span[text()='Search']"), "search button", 30);
	}
	public void verifyProductName() {
		staticWait(5000);
		try {
			WebElement productname = driver.findElement(By.xpath("//table/tbody/tr/td/span[contains(text(),'"+manageProductPage.productName+"')]"));
			if (productname.isDisplayed()) {
				logger.info(manageProductPage.productName +"Is Displayed in Pending Request Page");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info(manageProductPage.productName +"Is not Displayed in Pending Request Page");
			  e.printStackTrace();
			
		}
		
		
	}
	public void clickOnenterProductName() {
		staticWait(2000);
		selectValueWithText(By.xpath("//div/input[@id='Search']"), manageProductPage.productName, "Product Name", 30);

	}
	public void clickOnSearch() {
		staticWait(1000);
		click(By.xpath("(//div/a/span[text()='Search'])[last()]"), "search button", 30);
	}
	public void clickOnCheckBox() {
		staticWait(1000);
		click(By.xpath("//div[@class='custom-control custom-checkbox']"), "Ckeck Box", 30);
		
	}
	public void clickOnApproveButton() {
		staticWait(1000);
		clickByJavascript(By.xpath("//div/span/a[@id='ancApprove']"), "Approve Button", 30);
		
	}
	public void clickOnSaveButton() {
		staticWait(1000);
		click(By.xpath("(//div/a[@id='btnUpdateReturnStatus'])[last()]"), "Save Button", 30);
		
	}
	public void validateNotifyMessageForApprove() {
		staticWait(1000);
		try {
			WebElement notifyMessage = driver.findElement(By.xpath("//div/span[contains(text(),'Product Return Request has been Approved')]"));
			if (notifyMessage.isDisplayed()) {
				logger.info(notifyMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	}
	public void clickOnRejectButton() {
		staticWait(1000);
		clickByJavascript(By.xpath("//div/span/a[@id='ancReject']"), "Reject Button", 30);
		
	}
	public void validateNotifyMessageForReject() {
		staticWait(1000);
		try {
			WebElement notifyMessage = driver.findElement(By.xpath("//div/span[contains(text(),'Product Return Request has been Rejected')]"));
			if (notifyMessage.isDisplayed()) {
				logger.info(notifyMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	}
	public void clickOnAssignButton() {
		staticWait(1000);
		click(By.xpath("//td[@class='text-center single-action']/a[@data-original-title='Assign']/i"), "Assign Button", 30);
		
	}
	public void clickOnSave() {
		staticWait(1000);
		click(By.xpath("//div/a[@id='btnSave']"), "Save Button", 30);
		
	}
	
	/*----------------------------------------------Code for reservation---------------------------------------------------------------------------*/
	public void clickOnReservation() {
		staticWait(1000);
		click(By.xpath("//div/ul/li/a[contains(text(),'Reservation')]"), "Reservation", 30);
		
	}
	/*----------------------------------------------Code for Return Request---------------------------------------------------------------------------*/
	public void clickOnReturnRequest() {
		staticWait(1000);
		click(By.xpath("//div/ul/li/a[contains(text(),'Return Request')]"), "Return Request", 30);
		
	}
	public void clickOnenterReturnRequestProductName() {
		staticWait(2000);
		enter(By.xpath("//div/input[@id='Search']"), manageProductPage.productName, "Product Name", 30);

	}
	/*----------------------------------------------Code for Replace Request---------------------------------------------------------------------------*/
	public void clickOnReplaceRequest() {
		staticWait(1000);
		click(By.xpath("//div/ul/li/a[contains(text(),'Replace Request')]"), "Replace Request", 30);
		
		try {
			WebElement replacepage = driver.findElement(By.xpath("//div/span[text()='Replace Request']"));
			if (replacepage.isDisplayed()) {
				logger.info("Replace request page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Replace request page not opened successfully");
		}
		
	}
	public void clickOnApproveOrRejectReplaceRequest() {
		staticWait(1000);
		click(By.xpath("//td[@class='text-center single-action']/a[@data-original-title='Approve/Reject Request']"), "Approve/Reject Request", 30);
		
		try {
			WebElement approveOrRejectRequest = driver.findElement(By.xpath("//div/h5[contains(text(),'Replace Request')]"));
			if (approveOrRejectRequest.isDisplayed()) {
				logger.info("Replace request Approve or Reject page opened successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Replace request Approve or Reject  page not opened successfully");
		}
		
	}
	public void enterRemark() {
		staticWait(2000);
		enter(By.xpath("//textarea[@id='txtComment']"), prop.getProperty("remarks"), "Remark", 30);

	}
	public void clickOnsaveButton() {
		staticWait(2000);
		click(By.xpath("//div/a[text()='Save']"), "Save Button", 30);

	}
	public void validateNotifyMessageForApproveReplaceRequset() {
		staticWait(1000);
		try {
			WebElement notifyMessage = driver.findElement(By.xpath("//div/span[contains(text(),'Product Replace Request has been Approved')]"));
			if (notifyMessage.isDisplayed()) {
				logger.info(notifyMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	}
	public void clickOnselectStatus() {
		staticWait(2000);
		selectValueWithText(By.xpath("//tg-select/select[@id='ReplaceRequestStatus']"), "Rejected", "Status", 30);

	}
	public void validateNotifyMessageForRejecteReplaceRequset() {
		staticWait(1000);
		try {
			WebElement notifyMessage = driver.findElement(By.xpath("//div/span[contains(text(),'Product Replace Request has been Rejected')]"));
			if (notifyMessage.isDisplayed()) {
				logger.info(notifyMessage.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	}
}

