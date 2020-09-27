package pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.*;

public class SeaFoodPage {
	WebDriver driver;
	By AddButton = By.xpath(ExcelUtil.ReadExcel(ExcelUtil.ElementLocationExcelFileName, 1, 0, 1));
	By Location = By.xpath(ExcelUtil.ReadExcel(ExcelUtil.ElementLocationExcelFileName, 1, 1, 1));
	By Address = By.xpath(ExcelUtil.ReadExcel(ExcelUtil.ElementLocationExcelFileName, 1, 2, 1));

	public static float prices =0;

	public SeaFoodPage(WebDriver driver) throws IOException {
		this.driver = driver;

	}

	public void AddToCard() {
		List<WebElement> AddItems = driver.findElements(AddButton);
		System.out.println(AddItems.size());

		for (int i = 0; i < AddItems.size(); i++) {

			WebElement Price = AddItems.get(i).findElement(By.xpath("../../div[2]/span/span/span"));  
			System.out.println(Price);
			System.out.println(Price.getText());
			String ItemPrice = Price.getText().replaceAll("[a-zA-Z[!-#$%*()+@.^:,]]", "");
			float Pricee = Float.parseFloat(ItemPrice);
			prices = prices+ Pricee ;
			AddItems.get(i).click();
			if (driver.findElement(Location).isDisplayed()) {
				
				driver.findElement(Address).click();
				driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ; 

				
			}
			

		}
		System.out.println("Total Price"+prices);



	}



}
