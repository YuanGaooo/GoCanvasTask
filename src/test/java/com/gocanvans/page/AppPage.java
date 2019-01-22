package com.gocanvans.page;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.gocanvas.utils.BrowserUtils;
import com.gocanvas.utils.Driver;

public class AppPage {
	public AppPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//div[@class='brand pull-left ']/input")
	public WebElement typeAppName;
	
	@FindBy(xpath="(//li[@ng-model='field'])[1]/span")
	public WebElement shorTextBtn;
	
	@FindBy(xpath="//div[@id='screen-name']/div")
	public WebElement ScreenName;
	
	@FindBy(xpath="//li[@title='Fields']")
	public WebElement Fields;
	
	@FindBy(xpath="//li[@title='Settings']")
	public WebElement SettingIcon;
	
	@FindBy(xpath="(//textarea[@placeholder='New Short Text'])[1]")
	public WebElement newShortText;
	
	@FindBy(xpath="//span[contains(text(),'Save')]")
	public WebElement saveBtn;
	
	@FindBy(xpath="//a[@title='Publish to device']")
	public WebElement publishToDevice;
	
	@FindBy(xpath="//button[@class='btn ng-binding cvs-prim-btn']")
	public WebElement pop_publishToDevice;
	
	@FindBy(xpath="//button[contains(text(),'Next: Assign to Groups')]")
	public WebElement next_assignToGroups;
	
	@FindBy(xpath="//button[contains(text(),'Next: Assign to Users')]")
	public WebElement assignToUsers;
	
	@FindBy(xpath="//th/label[@class='icheckbox']")
	public WebElement toggleAll;
	
	@FindBy(xpath="//button[@ng-show='!publishing']")
	public WebElement final_publish;
	
	@FindBy(xpath="//h4[contains(text(),'Publish Successful!')]")
	public WebElement SucessText;
	
	@FindBy(xpath="//table[@class='table table-hover table-striped']/tbody/tr/td/label/input")
	public List<WebElement> assignToUserTable;
	
	
	public void typeTitleName(String name) {
		typeAppName.click();
		typeAppName.clear();
		typeAppName.sendKeys(name);
		Assert.assertEquals(true, typeAppName.getAttribute("value").equals(name),"Type Wrong Title Name");
	}
	
	public void giveScreenName(String name) {
		ScreenName.click();
		ScreenName.clear();
		ScreenName.sendKeys(name);
		assertEquals(true, ScreenName.getText().trim().equals(name.trim()),"Type Wrong Screen Name");
	}
	
	public void clickShortTextSave(String text) {
		Fields.click();
		shorTextBtn.click();
		SettingIcon.click();
		newShortText.click();
		newShortText.sendKeys(text);
		assertEquals(true, newShortText.getText().trim().equals(text.trim()),"Type Wrong Short Text");
		
	}
	
	public void PublishToDevice() {
		publishToDevice.click();
		pop_publishToDevice.click();
		next_assignToGroups.click();
		assignToUsers.click();
		toggleAll.click();
		for(WebElement assToUser:assignToUserTable) {
			boolean assign=Boolean.parseBoolean(assToUser.getAttribute("ng-checked"));
			Assert.assertTrue(assign,"Missing select user");
		}
		final_publish.click();
		
		
	}
	
	public boolean publishSucess() {
		
		return SucessText.isDisplayed();
	}
	
	
	
	
}
