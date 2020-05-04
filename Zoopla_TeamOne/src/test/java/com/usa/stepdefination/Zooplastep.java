package com.usa.stepdefination;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.usa.Zooplapagefactory.MasterPagefactory;
import com.usa.basepage.SupperClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Zooplastep extends SupperClass {
	MasterPagefactory pf;
	@Given("^User open browser$")
	public void user_open_browser() throws Throwable {
		//super.setUp();
		//SupperClass.initialization();
		SupperClass.InitializeCucumberBDD();
		
	    
	    }

	@Given("^enter application url - https://www\\.zoopla\\.com\\.uk/$")
	public void enter_application_url_https_www_zoopla_com_uk() throws Throwable {
		
		driver.get("http://www.zoopla.com");
		pf=PageFactory.initElements(driver, MasterPagefactory.class);
		pf.getCookie().click();
		System.out.println("Zoopla Page Open###############");
	}

	@When("^User click on login button$")
	public void user_click_on_login_button() throws Throwable {
		pf.getSingIn().click();
	    
	    
	}

	@When("^User enter valid credential$")
	public void user_enter_valid_credential() throws Throwable {
		pf.getUserName().sendKeys("saifa.irin@gmail.com");
		pf.getUserPassword().sendKeys("Sumon0680");
	    
	    
	}

	@When("^submit login button\\.$")
	public void submit_login_button() throws Throwable {
		pf.getSubmit().click();
	    
	    
	}

	@Then("^Varifi application title\\.$")
	public void varifi_application_title() throws Throwable {
		String title = driver.getTitle();
		System.out.println("Zoopla Page Title :"+title);
		Assert.assertEquals(title, "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
	    
	    
	}

	@When("^User enter loction New York , Lincolnhire\\.$")
	public void user_enter_loction_New_York_Lincolnhire() throws Throwable {
		pf.getLocationBox().sendKeys("New York, Lincolnshire");
	    
	    
	}
	@When("^user click suerch button$")
	public void user_click_suerch_button() throws Throwable {
	   pf.getSearchButton().click();
	}

	@When("^User check all the price values\\.$")
	public void user_check_all_the_price_values() throws Throwable {
		List<WebElement> Price = pf.getAllPrice();
		//System.out.println(Price);
		for(int i=0; i<Price.size();i++) {
			System.out.println("Property Price :"+Price.get(i).getText());
			}
		}

	@When("^User need to select thard property in the list\\.$")
	public void user_need_to_select_thard_property_in_the_list() throws Throwable {
	  List<WebElement>Price = pf.getAllPrice();
	  for(int i = 0;i<Price.size();i++) {
		  if (i>=2) {
			Price.get(i).click();
			break;
			}	  
	  }
	   }

	@Then("^Thard property  agent name & phone number varify\\.$")
	public void thard_property_agent_name_phone_number_varify() throws Throwable {
	   String agentinf = pf.getAgentInfo().getText(); 
	   System.out.println();
	   System.out.println(agentinf);
	   Assert.assertEquals(agentinf, "Agent information\n" + 
	   		"View Agent profile\n" + 
	   		"Longsons Premier Stock\n" + 
	   		"Agent address,\n" + 
	   		"Call\n" + 
	   		"01760 751059");
	    
	}

	@When("^User click logout button & go to zoopla home page\\.$")
	public void user_click_logout_button_go_to_zoopla_home_page() throws Throwable {
	    Actions action = new Actions(driver);
	    action.moveToElement(pf.getMyzoopla()).build().perform();
	    pf.getSinOut().click();
	    System.out.println("User Page Sing Out");
	    }

	@When("^User close the browser$")
	public void user_close_the_browser() throws Throwable {
	    
	    driver.close();
	}

}
