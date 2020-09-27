package pages;



import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.*;

public class HeaderPage {
	WebDriver driver;

	public static float CardPricee =0;
	// By Catogaries = By.xpath("//span[contains(text(),'Toggle Nav')]");
	By Catogaries = By.xpath(ExcelUtil.ReadExcel(ExcelUtil.ElementLocationExcelFileName, 0, 0, 1));
	By SeaFoodMenu = By.xpath(ExcelUtil.ReadExcel(ExcelUtil.ElementLocationExcelFileName, 0, 1, 1));
	By SeaFoodItem = By.xpath(ExcelUtil.ReadExcel(ExcelUtil.ElementLocationExcelFileName, 0, 2, 1));
	By Card = By.cssSelector(ExcelUtil.ReadExcel(ExcelUtil.ElementLocationExcelFileName, 0, 3, 1));
	By CardPrice = By.cssSelector(ExcelUtil.ReadExcel(ExcelUtil.ElementLocationExcelFileName, 0, 4, 1));
//.....
	By MeatMenu = By.xpath(ExcelUtil.ReadExcel(ExcelUtil.ElementLocationExcelFileName, 0, 5, 1));
	By  BeefVeal= By.xpath(ExcelUtil.ReadExcel(ExcelUtil.ElementLocationExcelFileName, 0, 5, 1));


	public HeaderPage(WebDriver driver) throws IOException {
		this.driver = driver;

	}

	public void ClickCatogaries() throws InterruptedException {


		/*
		 * WebDriverWait wait = new WebDriverWait(driver,50); 
		 * WebElement Category =
		 * wait.until(ExpectedConditions.elementToBeClickable(Catogaries));
		 */ 
		System.out.println(Catogaries);
		Thread.sleep(1000);

		 driver.findElement(Catogaries).click();


	}

	public void ClickOnSeaFood() throws InterruptedException {


		/*
		 * WebDriverWait wait = new WebDriverWait(driver,30); WebElement SeaFoodMen =
		 * wait.until(ExpectedConditions.elementToBeClickable(SeaFoodMenu));
		 */
		Thread.sleep(100);

		Base base = new Base(driver);
		base.MouseHover(driver.findElement(Catogaries));
		//SeaFoodMen.click();


	}


	public void selectRandam() {

		List<WebElement> AddItems = driver.findElements(SeaFoodItem);
		Random rand = new Random(); 

		int rand_int1 = rand.nextInt(AddItems.size()-1);
		AddItems.get(rand_int1).click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ; 

	}

	public void OpenCard() {

		driver.findElement(Card).click();

	}

	public void GetCardPrice() {

		String Cardrice =	driver.findElement(CardPrice).getText();
		Cardrice.replaceAll("[a-zA-Z[!-#$%*()+@.^:,]]", "");
		 CardPricee = Float.parseFloat(Cardrice);

	}	
//...........
	public void ClickOnMeat() {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement MeatMen = wait.until(ExpectedConditions.elementToBeClickable(MeatMenu)); 
		Base base = new Base(driver);
		base.MouseHover(MeatMen);
	//	MeatMen.click();

	}
	public void Beef_Veal() {

		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement MeatMen = wait.until(ExpectedConditions.elementToBeClickable(MeatMenu)); 	
		MeatMen.click();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ; 


	}
	
}
