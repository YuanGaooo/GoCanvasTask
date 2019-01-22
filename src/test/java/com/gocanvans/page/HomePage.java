package com.gocanvans.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.gocanvas.utils.Driver;
public class HomePage {
	public HomePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Create App')]")
	public WebElement createApp;
	
	
	
	
	public void clickCreateApp() {
		createApp.click();
		
	}
	
}
