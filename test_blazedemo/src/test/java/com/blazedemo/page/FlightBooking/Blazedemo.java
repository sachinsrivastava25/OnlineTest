package com.blazedemo.page.FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.blazedemo.base.utils.BasePage;
import com.blazedemo.base.utils.BaseTest;

public class Blazedemo extends BasePage{
	
	SoftAssert softAssert;

	public Blazedemo(WebDriver driver) throws InterruptedException {
		super(driver);
		softAssert = super.getSoftAssert();
	}
	
	BaseTest baseTest = new BaseTest();
	
	private final By departureCityDropdown = By.xpath("//select[@name = 'fromPort']");
	public final By destinationCityDropdown = By.xpath("//select[@name='toPort']");
	public final By findFlightButton = By.xpath("//input[@value='Find Flights']");
	
	
	/**
	 * @author SachinK.Srivastava 
	 */
	public Blazedemo chooseDepartureCity(String fromCity) throws Exception {
		waitForElementPresent(departureCityDropdown);
		Select sel = new Select(driver.findElement(departureCityDropdown));
		sel.selectByVisibleText(fromCity);
		wait(3000);
		return this;
	}


	/**
	 * @author SachinK.Srivastava 
	 */
	public Blazedemo chooseDestinationCity(String toCity) throws Exception {
		waitForElementPresent(destinationCityDropdown);
		Select sel = new Select(driver.findElement(destinationCityDropdown));
		sel.selectByVisibleText(toCity);
		wait(3000);
		return this;
	}
	
	public Blazedemo findFligh()
	{
		waitForElementPresent(findFlightButton);
		click(findFlightButton);
		return this;
	}
	
	/**
	 * @author SachinK.Srivastava 
	 */
	public Blazedemo selectFlight(String airlineName) throws Exception {
		//waitForElementPresent(destinationCityDropdown);
		click(By.xpath("//td[contains(text(), '" + airlineName + "')]/..//input[@value = 'Choose This Flight']"));

		wait(3000);
		return this;
	}

	/**
	 * @author SachinK.Srivastava 
	 */
	public Blazedemo selectFlight(int flightId) throws Exception {
		//waitForElementPresent(destinationCityDropdown);
		click(By.xpath("//td[contains(text(), '" + flightId + "')]/..//input[@value = 'Choose This Flight']"));
		wait(3000);
		return this;
	}
	
	/**
	 * @author SachinK.Srivastava 
	 */
	/*public Blazedemo flyerDetails(String name, String age) throws Exception {
		//waitForElementPresent(destinationCityDropdown);
		click(By.xpath("//td[contains(text(), '" + name + "')]/..//input[@value = 'Choose This Flight']"));
		wait(3000);
		return this;
	}*/

}

