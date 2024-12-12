package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolHomePage;
import utility.Reports;

@Listeners(Listener.class)

public class NaptolHomePageTest extends BaseTest {

	@BeforeTest
	   public void configureReports() {
		  reports = Reports.createReport();
	   }
	
	@BeforeMethod
	public void LaunchApplication() {
		driver = Browser.openBrowser();
	}
	@Test
	public void SearchValidProduct() {
		test=reports.createTest("SearchValidProduct");
		NaptolHomePage NaptolHomePage=new NaptolHomePage(driver);
		NaptolHomePage.enterProductToSearch("mobile");
		NaptolHomePage.clickOnSearch();
		Assert.assertTrue(NaptolHomePage.getNumberOfProduct()>0);
	}
	@Test
	public void SearchInvalidProduct() {
		test=reports.createTest("SearchInvalidProduct");
		NaptolHomePage NaptolHomePage=new NaptolHomePage(driver);
		NaptolHomePage.enterProductToSearch("iphone15");
		NaptolHomePage.clickOnSearch();
		Assert.assertTrue(NaptolHomePage.getNumberOfProduct()<0);
	}
	@Test
	public void VerifyOnClickingShoppingCategories() {
		test=reports.createTest("VerifyOnClickingShoppingCategories");
		NaptolHomePage NaptolHomePage=new NaptolHomePage(driver);
		NaptolHomePage.clickOnShoppingCategories();	
	}
	@Test
	public void VerifyIfProductDetailsAreCorectIfViewInQuickView() {
		test=reports.createTest("VerifyIfProductDetailsAreCorectIfViewInQuickView");
		NaptolHomePage NaptolHomePage=new NaptolHomePage(driver);
		NaptolHomePage.enterProductToSearch("mobile");
		NaptolHomePage.clickOnSearch();
		NaptolHomePage.moveToQuickViewOnDesiredProduct(driver, 0);
		//Thread.sleep(2000);
		//String productName= NaptolHomePage.getProductTitle(0);
		//String productPrice=NaptolHomePage.getProductPrice(0);
		NaptolHomePage.clickOnQuickView(1);
		//Assert.assertEquals(NaptolHomePage.getProductTitleInQuickView(0), productName);
			}
	
}
