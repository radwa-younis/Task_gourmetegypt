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

public class VeetPage {
	WebDriver driver;
	By SpecialOffer = By.xpath(ExcelUtil.ReadExcel(ExcelUtil.ElementLocationExcelFileName, 2, 0, 1));
	


	public VeetPage(WebDriver driver) throws IOException {
		this.driver = driver;

	}

	public void SpcialOfferLink() {
		List<WebElement> SpecialItems = driver.findElements(SpecialOffer);
		System.out.println(SpecialItems.size());

		for (int i = 0; i < SpecialItems.size(); i++) {

			WebElement SpecialLink = SpecialItems.get(i).findElement(By.xpath("../a"));  
			System.out.println(SpecialLink.getAttribute("href"));
			

		}



	}



}
