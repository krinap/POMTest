package com.qa.testcases;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.qa.base.TestBase;
import com.qa.testpages.HomePage;
import com.qa.testpages.LoginPage;


public class LoginTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage;

	public LoginTest() {
		// TODO Auto-generated constructor stub
		super();
	}

	@BeforeMethod()
	public void setUp() {

		System.out.println("INTIALLLLIXXXXXXXXX................");
		intilization();
		loginpage = new LoginPage();

	}

	@Test(priority = 1)
	public void pageTitle() {
		String title = loginpage.validateTitle();
		Assert.assertEquals(title, "Log in to MyBell");
	}

	@Test(priority = 2)
	public void loginValidation() {

		System.out.println("CALLING TEST................");
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
