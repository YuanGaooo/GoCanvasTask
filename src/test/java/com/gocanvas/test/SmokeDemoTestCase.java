package com.gocanvas.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gocanvans.page.AppPage;
import com.gocanvans.page.HomePage;
import com.gocanvans.page.LoginPage;
import com.gocanvans.page.TemplatePage;

public class SmokeDemoTestCase extends testBase {
	LoginPage loginpage=new LoginPage();
	HomePage homePage= new HomePage();
	TemplatePage tempPage= new TemplatePage();
	AppPage appPage=new AppPage();
	
	
	@Test(groups= {"smoke"})
	public void SmokeDemo() throws InterruptedException {
		extentLogger = report.createTest("login successfully");
		loginpage.loginAcc();
		homePage.clickCreateApp();
		tempPage.seleteTempItem("blank");
		appPage.typeTitleName("yuan gao");
		appPage.giveScreenName("SDET");
		appPage.clickShortTextSave("that was easy");
		appPage.PublishToDevice();
		Assert.assertTrue(appPage.publishSucess());		

		
	}
}
