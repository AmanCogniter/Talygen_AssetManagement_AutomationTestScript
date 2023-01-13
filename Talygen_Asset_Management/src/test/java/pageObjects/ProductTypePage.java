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
import java.text.SimpleDateFormat;
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

import com.relevantcodes.extentreports.LogStatus;

import utils.PropertiesLoader;
import utils.WebBasePage;

public class ProductTypePage extends WebBasePage{
	 WebDriver driver;
	 String pattern="yyMMddHHmmss";
	 Date date = new Date();
	 SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
	 String datevalue = dateformat.format(date);
	 static  String tagname;
	 static  String productname;
	 static  String firstrowdata;
	 static  String secondrowdata;
	 String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\testfiles\\";
	    private final static String FILE_NAME = System.getProperty("user.dir")+"\\src\\main\\resources\\testdata.properties";
	    private static Properties prop = new PropertiesLoader(FILE_NAME).load();
	
	public ProductTypePage(WebDriver driver)
	{
		super(driver,"Product Type Page");
		this.driver= driver;
	}
	
	
	
	public void clickFullMenuDropDown() {
		staticWait(3000);
        click(By.cssSelector("a#navbarDropdownPortfolio"), "Full Menu", 30);
        
    }
     public void clickOnAssetManagement()
     {
    	 staticWait(2000);
    	// click(By.xpath("//a[contains(text(),'COMPANY SETUP')]"),"Company Setup Link", 30);
    	 click(By.xpath("//li[@data-name='Asset Management ']/span"),"Asset Management", 30);
   
     }
     public void clickOnProductType()
     {
    	 staticWait(2000);
    	 click(By.xpath("//div/ul/li/a[@data-original-title='Product Type']"),"Product Type", 30);
    	 staticWait(2000);
    	 WebElement productTypePage = driver.findElement(By.xpath("//div/span[@id='titleName']"));
    	 if (productTypePage.isDisplayed()) {
    		 logger.info("Product Type page opened successfully");
			
		} else {
			logger.info("Product Type page not opened successfully");
		}
    	 
     }
     public void clickOnAddProductType()
     {
    	 staticWait(2000);
    	 click(By.xpath("//div/span/a[@id='ancCreateDepartment']"),"Add Product Type", 30);
    	 staticWait(2000);
    	 WebElement addproductTypePage = driver.findElement(By.xpath("//div/span[text()='Add Product Type']"));
    	 if (addproductTypePage.isDisplayed()) {
    		 logger.info("Add Product Type page opened successfully");
			
		} else {
			logger.info("Add Product Type page not opened successfully");
		}
    	 
     }
     public void clickOnSaveButton()
     {
    	 staticWait(2000);
    	// click(By.xpath("//a[contains(text(),'COMPANY SETUP')]"),"Company Setup Link", 30);
    	 click(By.xpath("//div/a[@id='btnSave']"),"Save Button", 30);
   
     }
     public void clickOnCancelButtonofAddProductType()
     {
    	 staticWait(2000);
    	// click(By.xpath("//a[contains(text(),'COMPANY SETUP')]"),"Company Setup Link", 30);
    	 clickByJavascript(By.xpath("//div/a[@id='gobacktolistscreen']"),"Cancel Button", 30);
   
     }
     public void closeNotifyMessagePopUp()
     {
    	 staticWait(2000);
    	 WebElement notifyMessagePopUp = driver.findElement(By.xpath("//div/span[contains(text(),'Please correct the highlighted errors')]"));
    	 if (notifyMessagePopUp.isDisplayed()) {
    		 logger.info("Notify Message Popup opened successfully");
    		 click(By.xpath("//button[@id='closenotifymessage']"),"Close notify message Button", 30);
		} else {
			logger.info("Notify Message Popup opened successfully");
		}
  
   
     }
     public void VerifyMandatoryFieldValidationOfAddProductTypePage()
	 {
		 int i=0;
		 String actualText;
		 String expectedText;
		 
	        List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//div[@class='form-group']//span[contains(@class,'invalid-feedback')]"), 15);
	        String[] expectedValue = {"Product Type Name"};
	        for(Object expected : expectedValue)
	        {
	        	WebElement AsteriskField = findElementVisibility(By.xpath("//label[text()='" + expected +"']/parent::tg-input/descendant::span[@class='mandatory']"), 20);
	        	if (AsteriskField!= null)
	        	{
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
                    getTest().log(LogStatus.PASS, "Error message for \"" + expected + "\" field is displayed as expected");
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
     public void clickOnImportProductType()
     {
    	 staticWait(2000);
    	 click(By.xpath("//div/span/a[@id='ancImportItemType']"),"Import Product Type", 30);
    	 staticWait(2000);
    	 WebElement importproductTypePage = driver.findElement(By.xpath("//div/span[text()='Import Product Type']"));
    	 if (importproductTypePage.isDisplayed()) {
    		 logger.info("Import Product Type page opened successfully");
			
		} else {
			logger.info("Import Product Type page not opened successfully");
		}
    	 
     }
     public void clickOnImportFromExcelFile()
     {
    	 staticWait(2000);
    	 clickByJavascript(By.xpath("//div/a[@id='btnImportFile']"),"Import From Excel File", 30);
     }
     public void clickOnCancel()
     {
    	 staticWait(2000);
    	 click(By.xpath("//div/a[@data-original-title='Cancel']"),"Cancel Button", 30);
     }
     public void VerifyMandatoryFieldValidationOfImportProductTypePage()
	 {
		 int i=0;
		 String actualText;
		 String expectedText;
		 
	        List<WebElement> errorMessageLocator = findMultipleElement(By.xpath("//span[contains(@class,'invalid-feedback')]"), 15);
	        String[] expectedValue = {"Upload a File"};
	        for(Object expected : expectedValue)
	        {
	        	
	        	WebElement AsteriskField = findElementVisibility(By.xpath("//label[text()='" + expected +"']/parent::div[@class='form-group']/descendant::span[@class='text-danger']"), 20);
	        	if (AsteriskField!= null)
	        	{
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
                    getTest().log(LogStatus.PASS, "Error message for \"" + expected + "\" field is displayed as expected");
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
     public void updateExceldata() throws EncryptedDocumentException, IOException {
    	 try {
    		 staticWait(2000);
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\aanand\\eclipse-workspace\\Talygen_Asset_Management\\src\\main\\resources\\testfiles\\ProductTypeSample.xls");
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = workbook.getSheet("producttypename");
			Row row = sheet.getRow(1);
			Row row1 = sheet.getRow(2);
			Cell cell = row.getCell(0);
			Cell cell1 = row1.getCell(0);
			cell.setCellValue("Laptop"+datevalue);
			cell1.setCellValue("Hand Gloves"+datevalue);
			FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\aanand\\eclipse-workspace\\Talygen_Asset_Management\\src\\main\\resources\\testfiles\\ProductTypeSample.xls");
			workbook.write(fileOutputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
     public void readupdateExceldata() throws EncryptedDocumentException, IOException {
    	 try {
    		 staticWait(2000);
			FileInputStream fileInputStream = new FileInputStream("C:\\Users\\aanand\\eclipse-workspace\\Talygen_Asset_Management\\src\\main\\resources\\testfiles\\ProductTypeSample.xls");
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			Sheet sheet = workbook.getSheet("producttypename");
			//get the last used row count
			//int count = sheet.getLastRowNum();
			//for(int i=1; i<count;i++) {
				Row row=sheet.getRow(1);
				Row row1=sheet.getRow(2);
				firstrowdata= row.getCell(0).getStringCellValue();
				secondrowdata= row1.getCell(0).getStringCellValue();
				logger.info("Product type Name present in Excel sheet"+firstrowdata + "\t" + secondrowdata );
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
 		driver.findElement(By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']/label[@for='flFile']"))
 		.click();

 		// put path to your image in a clipboard
 		StringSelection ss = new StringSelection(
 				"C:\\Users\\aanand\\eclipse-workspace\\Talygen_Asset_Management\\src\\main\\resources\\testfiles\\ProductTypeSample.xls");
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
     public void clickOnConfirmationButton()
     {
    	 staticWait(2000);
    	 click(By.xpath("//button[@title='OK']"),"Ok Button", 30);
     }
     public void clickOnSubmitButton()
     {
    	 staticWait(2000);
    	 clickByJavascript(By.xpath("//div/a[@id='aSubmit']"),"Submit Button", 30);
     }
     public void clickOnSearchButton()
     {
    	 staticWait(2000);
    	 clickByJavascript(By.xpath("//div/a[@id='Go']"),"search Button", 30);
     }
     public void verifyImportProductType() {
    	 try {
    		 
			WebElement successfulpopUpMessage = driver.findElement(By.xpath("//div/span[contains(text(),'File has been successfully imported')]"));
			String popUpMessage = successfulpopUpMessage.getText();
			if (successfulpopUpMessage.isDisplayed()) {
			logger.info(successfulpopUpMessage.getText());
			staticWait(2000);
			enter(By.xpath("//div/input[@id='search']"),firstrowdata," Product Type Name", 20);
			staticWait(2000);
			clickOnSearchButton();
			staticWait(3000);
			String producttypename = driver.findElement(By.xpath("//td/a[contains(text(),'"+firstrowdata+"')]")).getText();
			if (producttypename.contains(firstrowdata)) {
				logger.info(producttypename+" "+popUpMessage);
				
			}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			WebElement popUpMessage = driver.findElement(By.xpath("//div/span[contains(text(),'File has Duplicate Item Name for -Laptop,Hand Gloves.Rest Products added successfully')]"));
			if (popUpMessage.isDisplayed()) {
				logger.info(popUpMessage.getText());
			}
			  e.printStackTrace();
		}
    	 
     }
     public void clickOnCheckBox() {
    	 staticWait(2000);
    	 click(By.xpath("//tbody/tr/td/div[@class='custom-control custom-checkbox']"),"CheckBox", 30);
    	 
     }
     public void clickOnActive() {
    	 staticWait(2000);
    	 click(By.xpath("//span/a[@id='ancActInact']/span[contains(text(),'Active')]"),"Active ", 30);
    	 clickOnConfirmationButton();
    	 staticWait(1000);
    	 WebElement successmessage = driver.findElement(By.xpath("//div/span[contains(text(),'Status has been successfully updated')]"));
    	 if (successmessage.isDisplayed()) {
    		 logger.info("Status has been successfully updated");
			
		} else {
			logger.info("Status hasn't been successfully updated");
		}
    	 
     }
     public void clickOnInActive() {
    	 staticWait(2000);
    	 click(By.xpath("//span/a[@id='ancActInact']/span[contains(text(),'Inactive')]"),"InActive ", 30);
    	 clickOnConfirmationButton();
    	 WebElement successmessage = driver.findElement(By.xpath("//div/span[contains(text(),'Status has been successfully updated')]"));
    	 if (successmessage.isDisplayed()) {
    		 logger.info("Status has been successfully updated");
			
		} else {
			logger.info("Status hasn't been successfully updated");
		}
    	 
     }
     public void clickOnDelete() {
    	 staticWait(2000);
    	 click(By.xpath("//span/a[@id='DeleteMultiple']/span[contains(text(),'Delete')]"),"Delete button ", 30);
    	 clickOnConfirmationButton();
    	 WebElement successmessage = driver.findElement(By.xpath("//div/span[contains(text(),'Product Type has been successfully deleted')]"));
    	 if (successmessage.isDisplayed()) {
    		 logger.info("Product Type has been successfully deleted");
			
		} else {
			logger.info("Product Type hasn't been successfully deleted");
		}
     }
     public void checkDeleteFunctionality() {
    	 try {
    		 enter(By.xpath("//div/input[@id='search']"),firstrowdata," Product Type Name", 20);
 			staticWait(2000);
 			clickOnSearchButton();
 			staticWait(3000);
 			String producttypename = driver.findElement(By.xpath("//td/a[contains(text(),'"+firstrowdata+"')]")).getText();
 			if (producttypename.contains(firstrowdata)) {
 				clickOnCheckBox();
 				clickOnInActive();
 				clickOnCheckBox();
 				clickOnActive();
 				clickOnCheckBox();
 				clickOnDelete();
 				staticWait(3000);
 				enter(By.xpath("//div/input[@id='search']"),secondrowdata," Product Type Name", 20);
 				staticWait(2000);
 	 			clickOnSearchButton();
 	 			clickOnCheckBox();
 	 			staticWait(2000);
 	 			clickOnDelete();
		}
    	 }catch (Exception e) {
			// TODO: handle exception
    		 logger.info("Delete button is not working");
		}
     }
     
     public void EnterProductTypeName()
	  {
    	 staticWait(3000);
		  String latestproductname = prop.getProperty("producttypename")+datevalue;
		  enter(By.xpath("//div[@class='form-group']/tg-input/input"),latestproductname," Product Type Name", 20);
		  
		  System.out.println(latestproductname);
		  productname =latestproductname;
	  }
     public void uploadimage() {
//  		findElementVisibility(
//  				By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"), 20);
//  		uploadDoc(By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"),
//  				filePath + prop.getProperty("expenseFileDoc"), "uploaded document", 10);

//  		String h = filePath + prop.getProperty("expenseFileDoc");
//  		System.out.println("file path is :: " + h);
//  		

  		/*
  		 * driver.findElement(By.
  		 * xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']"
  		 * )) .click();
  		 */
  		driver.findElement(By.xpath("//span[@class='group-span-filestyle input-group-btn input-group-text bg-white']/label[@for='flProductTypeFile']"))
  		.click();

  		// put path to your image in a clipboard
  		StringSelection ss = new StringSelection(
  				"C:\\Users\\aanand\\eclipse-workspace\\Talygen_Asset_Management\\src\\main\\resources\\testfiles\\55565.jpg");
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
     public void clickOnResetButton()
     {
    	 staticWait(2000);
    	 click(By.xpath("(//span/a[@data-original-title='Clear'])[last()]"),"Reset Button", 30);
     }
     public void EnterDescription()
	  {
    	 staticWait(2000);
		  enter(By.xpath("//tg-textarea/textarea[@id='Description']"),prop.getProperty("Description")+datevalue,"description", 20);
		  
		  
	  }
     public void clickOnAssetToggleButton()
     {
    	 staticWait(2000);
    	 click(By.xpath("//input[@id='IsAssetN']/ancestor::asp-checkbox-toggle/descendant::span"),"Asset Toggle Button", 30);
     }
     public void clickOnConsumableToggleButton()
     {
    	 staticWait(2000);
    	 click(By.xpath("//input[@id='IsConsumableN']/ancestor::asp-checkbox-toggle/descendant::span"),"Consumable Toggle Button", 30);
     }
     public void clickOnAddNewTag()
     {
    	 staticWait(2000);
    	 click(By.xpath("//i[@title='Add']"),"Add New Tag", 30);
    	 WebElement tagname = driver.findElement(By.xpath("//div/h5[text()='Tag Name']"));
    	 if (tagname.isDisplayed()) {
    		 logger.info("Tag Name page opened successfully");
			
		}else {
			 logger.info("Tag Name page not opened successfully");
		}
     }
     public void EnterTagNameTitle()
	  {
   	 staticWait(2000);
   	tagname=prop.getProperty("tagName")+datevalue;
		  enter(By.xpath("//div/input[@id='TagName']"),tagname,"Tag Name Title", 20);
		  
		  
	  }

     public void clicksaveButtonOfTagNameTitle()
	  {
  	 staticWait(2000);
  	click(By.xpath("//div/a[@id='Save']"),"Tag Name Title Save button", 30);
		  
		  
	  }
     public void clickOnIsTransferableToggleButton()
     {
    	 staticWait(2000);
    	 click(By.xpath("//input[@id='IsTransferableN']/ancestor::asp-checkbox-toggle/descendant::span"),"IsTransferable Toggle Button", 30);
     }
     public void clickOnSelfCheckoutToggleButton()
     {
    	 staticWait(2000);
    	 click(By.xpath("//input[@id='IsSelfCheckOutN']/ancestor::asp-checkbox-toggle/descendant::span"),"SelfCheckout Toggle Button", 30);
     }
     public void clickOnEnableTermsAndConditionToggleButton()
     {
    	 staticWait(2000);
    	 click(By.xpath("//input[@id='IsEnableTermsN']/ancestor::asp-checkbox-toggle/descendant::span"),"Enable Terms and Condition Toggle Button", 30);
     }
     public void clickOnProductCostToggleButton()
     {
    	 staticWait(2000);
    	 click(By.xpath("//input[@id='IsItemCostN']/ancestor::asp-checkbox-toggle/descendant::span"),"Product cost Toggle Button", 30);
     }
     public void clickOnDepreciableToggleButton()
     {
    	 staticWait(2000);
    	 click(By.xpath("//input[@id='IsDepreciableN']/ancestor::asp-checkbox-toggle/descendant::span"),"Depreciable Toggle Button", 30);
     }
     public void checkProductTypename() {
    	 try {
    		 enter(By.xpath("//div/input[@id='search']"),productname," Product Type Name", 20);
 			staticWait(2000);
 			clickOnSearchButton();
 			staticWait(3000);
 			String producttypename = driver.findElement(By.xpath("//td/a[contains(text(),'"+productname+"')]")).getText();
 			if (producttypename.contains(productname)) {
 				logger.info(productname +" "+"is present in product type name list page" );
		}
    	 }catch (Exception e) {
			// TODO: handle exception
    		 logger.info(productname +" "+"is not present in product type name list page");
		}
     }
     public void checkDeleteFunctionalityOfAddProductType() {
    	 try {
    		 enter(By.xpath("//div/input[@id='search']"),productname," Product Type Name", 20);
 			staticWait(2000);
 			clickOnSearchButton();
 			staticWait(3000);
 			String producttypename = driver.findElement(By.xpath("//td/a[contains(text(),'"+productname+"')]")).getText();
 			if (producttypename.contains(productname)) {
 				clickOnCheckBox();
 				//clickOnInActive();
 				//clickOnCheckBox();
 				//clickOnActive();
 				//clickOnCheckBox();
 				clickOnDelete();
 				
		}
    	 }catch (Exception e) {
			// TODO: handle exception
    		 logger.info("Delete button is not working");
		}
     }

}
