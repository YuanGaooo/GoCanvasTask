package com.gocanvans.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ReportAggregatesListener;
import com.gocanvas.utils.ConfigurationReader;
import com.gocanvas.utils.Driver;


public class LoginPage {
	public  LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	
	
	@FindBy(linkText="Log In")
	public WebElement logIn;
	
	@FindBy(id="login")
	public WebElement email;
	
	@FindBy(xpath="//h2[.='App Builder Redesign & Page Numbers']")
	public WebElement alert;
	
	@FindBy(xpath="//a[@aria-label='Close Appcues modal']")
	public WebElement xIcon;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="btn_Log In")
	public WebElement loginbtn;
	
	
	public void loginAcc() {
		logIn.click();
		email.sendKeys(ConfigurationReader.getProperty("username"));
		password.sendKeys(ConfigurationReader.getProperty("password"));
		loginbtn.click();

		
	}
	
}
