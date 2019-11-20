package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.base.TestBase;
import com.qa.testpages.HomePage;
import com.qa.testpages.LoginPage;

public class HomeTest extends TestBase {

	HomePage homePage;
	LoginPage loginpage;

	public HomeTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() {

		System.out.println("INTIALLLLIXXXXXXXXX................");
		intilization();
		loginpage = new LoginPage();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
