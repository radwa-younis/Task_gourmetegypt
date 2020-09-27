package stepDefinations;

import java.io.IOException;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HeaderPage;
import pages.SeaFoodPage;
import pages.VeetPage;
import runner.Runner;

public class StepDefination extends Runner {
	// WebDriver driver = super.Driver;
	SeaFoodPage SeaFoodP = null;

	HeaderPage HeaderP = null;
	VeetPage VeetP = null;

//.....Seafood section...................
	
	  @Given("open SeaFood Menu") 
	  public void open_SeaFood_Menu() throws
	  IOException,InterruptedException 
	  {
		  
		  HeaderP = new HeaderPage(Driver);
			HeaderP.ClickCatogaries();
			HeaderP.ClickOnSeaFood();
	//		HeaderP.selectRandam();
			
	  }
	 
	  @Then("Add to Card") 
	  public void Add_Card() throws
	  IOException,InterruptedException 
	  {
		  
		  SeaFoodP = new SeaFoodPage(Driver);
		  SeaFoodP.AddToCard();
	  }

	  @Then("check on total price") 
	  public void check_on_total_price() throws	  
	  IOException,InterruptedException 
	  {
		  HeaderP.OpenCard();
		  
		Assert.assertEquals(SeaFoodP.prices,HeaderP.CardPricee, "Card Price are not equal");

	  }
	  
	  //....Meat & Poultry section............................
	  
	  @Given("open Meat_Poultry Menu") 
	  public void open_Meat_Poultry_Menu () throws
	  IOException,InterruptedException 
	  {
		  HeaderP = new HeaderPage(Driver);

			HeaderP.ClickCatogaries();
			HeaderP.ClickOnMeat();
			HeaderP.Beef_Veal();
			
	  }
	  @When("select Beef and Veet") 
	  public void select_Beef_and_Veet () throws
	  IOException,InterruptedException 
	  {
		  
			HeaderP.Beef_Veal();
			
	  }
	  @Then("Display Herf of Special Offers") 
	  public void Display_Herf_of_Special_Offers () throws
	  IOException,InterruptedException 
	  {
		  VeetP = new VeetPage(Driver);
		  VeetP.SpcialOfferLink();
			
	  }  
	  
	  
	  
}