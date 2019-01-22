package com.gocanvans.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gocanvas.utils.Driver;

public class TemplatePage {
	
	public TemplatePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//li/span/img[@alt]")
	public List<WebElement> tempItems;
	
	@FindBy(id="start-tamplate")
	public WebElement startBtn;
	
	
	
	public void seleteTempItem(String item) {
		
		for(WebElement It: tempItems) {
			if(It.getAttribute("alt").equalsIgnoreCase(item)) {
				It.click();
			}
			
		}
		startBtn.click();
		
		
	}
}
