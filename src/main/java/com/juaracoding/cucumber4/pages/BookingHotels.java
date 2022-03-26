package com.juaracoding.cucumber4.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.cucumber4.drivers.DriverSingleton;

public class BookingHotels {
	
private WebDriver driver;
	
	public BookingHotels() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#fadein > header > div.header-menu-wrapper.padding-right-100px.padding-left-100px > div > div > div > div > div.main-menu-content > nav > ul > li:nth-child(2) > a")
	WebElement menuHotels;
	
	@FindBy(css = "#fadein > span > span > span.select2-search.select2-search--dropdown > input")
	WebElement btnSearch;
	
	@FindBy(id = "select2-hotels_city-container")
	WebElement  searchCity;
	
	@FindBy(css = "#select2-hotels_city-results > li")
	WebElement btnKlik;

	@FindBy(id = "checkin")
	WebElement checkIn;
	
	@FindBy(xpath = "//*[@id=\"fadein\"]/div[2]/div[1]/table/tbody/tr[5]/td[4]")
	WebElement btnTgl;
	
	@FindBy(id = "checkout")
	WebElement checkOut;
	
	@FindBy(xpath = "//*[@id=\"hotels-search\"]/div/div/div[3]/div/div/div/a/p")
	WebElement Travellers;
	
	@FindBy(xpath ="//*[@id=\"hotels-search\"]/div/div/div[3]/div/div/div/div/div[1]/div/div/div[3]")
	WebElement btnRooms;

	@FindBy(xpath = "//*[@id=\"hotels-search\"]/div/div/div[3]/div/div/div/div/div[2]/div/div/div[2]/i")
	WebElement btnAdults;
	
	@FindBy(xpath = "//*[@id=\"hotels-search\"]/div/div/div[3]/div/div/div/div/div[3]/div/div/div[2]")
	WebElement btnChilds;
	
	@FindBy(id = "nationality")
	WebElement btnNational;
	
	@FindBy(xpath = "//*[@id=\"nationality\"]/option[105]")
	WebElement klikN;
	
	@FindBy(css = "#submit")
	WebElement btnSubmit;

	@FindBy(css = "#rendezvous\\ hotels > div > div.card-body.p-0 > div > div.col-4.p-3 > div > a > span.ladda-label")
	WebElement btnDetails;
	

	public void goToMenuHotels() {
		menuHotels.click();
	}
	
	public String gettxtTitleHotelsPage() {
		return driver.getTitle();
	}
	
	public void pageHotels() {
		searchCity.click();
		btnSearch.sendKeys("singapore");
		tunggu();
		btnKlik.click();
	}
	
	public void checkIn() {
		checkIn.click();
		btnTgl.click();
	}
	
	public void checkOut() {
		checkOut.click();
	}
	
	public void travellers() {
		Travellers.click();
		btnRooms.click();
		btnAdults.click();
		btnChilds.click();
		btnNational.sendKeys("id");
		klikN.click();
		
	}
	
	public void submit() {
		btnSubmit.click();
	}
	
	public String gettxtSearchHotelPage() {
		return driver.getTitle();
	}
	
	public void details() {
		btnDetails.click();	
		
	}
	
	public static void tunggu() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
