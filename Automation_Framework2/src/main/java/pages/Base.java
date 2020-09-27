package pages;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public class Base {

  WebDriver driver ;
	
	
	public Base(WebDriver driver) {
		this.driver = driver;

	}

	Actions action ;

	public void MouseHover( WebElement element) {
		// TODO Auto-generated method stub
		action = new Actions(driver);
		action.moveToElement(element).perform();	
	}

	public int GetNumberOfWebElement( By elementLocation) {
		List<WebElement> NumWebelemnt = driver.findElements(elementLocation);
		return	 NumWebelemnt.size();
	}


}
