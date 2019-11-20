package com.qa.testpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	@FindBy(id = "USER")
	WebElement username;

	@FindBy(id = "PASSWORD")
	WebElement password;

	@FindBy(xpath = "//a[@id='labelLogin']")
	WebElement btnLogin;
	
	@FindBy(linkText = "Home")
	WebElement Home;

	public HomePage login(String name, String pwd) {

		username.sendKeys(name);
		password.sendKeys(pwd);
		btnLogin.click();

		return new HomePage();
	}

	// check the title
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	// constructor
	public LoginPage() {

		PageFactory.initElements(driver, this);

	}

	
	
	//

}
