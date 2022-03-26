package com.juaracoding.cucumber4.glue;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.juaracoding.cucumber4.config.AutomationFrameworkConfig;
import com.juaracoding.cucumber4.drivers.DriverSingleton;
import com.juaracoding.cucumber4.pages.BookingHotels;
import com.juaracoding.cucumber4.pages.LoginPage;
import com.juaracoding.cucumber4.utlis.ConfigurationProperties;
import com.juaracoding.cucumber4.utlis.Constants;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class TestLogin {

	private WebDriver driver;
	private LoginPage loginPage;
	private BookingHotels bookingHotels;
	
	@Autowired
	ConfigurationProperties configurationProperties;
	
	@Before
	public void initializeObjects() {
		DriverSingleton.getInstance(configurationProperties.getBrowser());
		loginPage = new LoginPage();
		bookingHotels = new BookingHotels();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@Given("Customer mengakses url")
	public void customer_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
	}
	
	@When("Customer klik login button")
	public void customer_klik_login_button() {
		loginPage.submitLogin(configurationProperties.getEmail(), configurationProperties.getPassword());
	}
	
	@Then("Customer berhasil login")
	public void customer_berhasil_login() {
		//refresh
		driver.navigate().refresh();
		tunggu();
		assertEquals(configurationProperties.getTxtWelcome(), loginPage.getTxtWelcome());
	}
	
	 @When("Customer klik menu Hotels")
	 public void customer_klik_menu_hotels() {
		 bookingHotels.goToMenuHotels();
	 }
	 
	 @Then("Customer melihat page Hotels") 
	 public void customer_melihat_page_hotels() {
		assertEquals(configurationProperties.gettxtTitleHotelsPage(), bookingHotels.gettxtTitleHotelsPage());
	 }
	
	 @When("Customer klik button search Hotels")
		public void customer_klik_button_search_hotels() {
		 bookingHotels.pageHotels();
	 }		
	 
	 @And("Customer search Hotels with location Singapore")
		 public void customer_search_Hotels_with_location_singapore() {
		 bookingHotels.gettxtTitleHotelsPage();
		 
	 }
	 @And("Customer klik button checkin")
	 	public void customer_klik_button_checkin() {
		 bookingHotels.checkIn();
	 }
	 
	 @And("Customer klik button checkout")
	 	public void customer_klik_button_checkout() {
		 bookingHotels.checkOut();
	 }
	 
	 @And("Customer klik button Travellers")
	 	public void customer_klik_button_Travellers() {
		 bookingHotels.travellers();
	 }
	 
	 @And("Customer klik button Submit")
	 	public void customer_klik_button_submit() {
		 bookingHotels.submit();
	 }
	 
	 @Then("Customer melihat page Hotels in singapore")
		 public void customer_melihat_page_hotels_in_singapore() {
			assertEquals(configurationProperties.gettxtsearchHotelPage(), bookingHotels.gettxtSearchHotelPage());
		 }
	
	 @When("Customer klik button Details")
	 	public void customer_klik_button_details() {
		 bookingHotels.details();
	 }
	 
	 
	 public static void tunggu() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
