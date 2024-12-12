package test;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.ITestListener;

import pojo.Browser;
import pom.CartPage;
import pom.NaptolHomePage;
import utility.Reports;



@Listeners(test.Listener.class)
public class CartTest extends BaseTest{
	@BeforeTest
	   public void configureReports() {
		  reports = Reports.createReport();
	   }
	
	@BeforeMethod
	public void LaunchApplication() {
		driver=Browser.openBrowser();
	}
	@Test
	public void VerifyAddProductToCartUsingQuickView() {
		test=reports.createTest("VerifyAddProductToCartUsingQuickView");
		NaptolHomePage NaptolHomePage=new NaptolHomePage(driver);
		NaptolHomePage.enterProductToSearch("mobile");
		NaptolHomePage.clickOnSearch();
		NaptolHomePage.moveToQuickViewOnDesiredProduct(driver, 0);
		NaptolHomePage.clickOnQuickView(0);
		NaptolHomePage.clickOnAddToCart();
		//String productName=NaptolHomePage.getProductTitleInQuickView(0);
		//CartPage cartPage=new CartPage(driver);
		//Assert.assertEquals(cartPage.getProductName(0), productName);
	}
	@Test
	public void VerifyAddProductToCartUsingProductDetailPage() {
		test=reports.createTest("VerifyAddProductToCartUsingProductDetailPage");
		NaptolHomePage NaptolHomePage=new NaptolHomePage(driver);
		NaptolHomePage.enterProductToSearch("mobile");
		NaptolHomePage.clickOnSearch();
		
	}
	@Test
	public void VerifyAddingMultipleProductToCart() {
		test=reports.createTest("VerifyAddingMultipleProductToCart");
		NaptolHomePage NaptolHomePage=new NaptolHomePage(driver);
		NaptolHomePage.enterProductToSearch("mobile");
		NaptolHomePage.clickOnSearch();
		NaptolHomePage.moveToQuickViewOnDesiredProduct(driver, 0);
		NaptolHomePage.clickOnQuickView(0);
		NaptolHomePage.clickOnAddToCart();
		CartPage cartPage=new CartPage(driver);
		cartPage.clickOnContinueShopping();
		NaptolHomePage.closeQuickViewWindow();
		
		NaptolHomePage.moveToQuickViewOnDesiredProduct(driver, 1);
		NaptolHomePage.clickOnQuickView(1);
		NaptolHomePage.clickOnAddToCart();
		cartPage.clickOnContinueShopping();
		NaptolHomePage.closeQuickViewWindow();
		
	}
	@Test
	public void VerifyRemovingProductFromCart() {
		test=reports.createTest("VerifyRemovingProductFromCart");
		NaptolHomePage NaptolHomePage=new NaptolHomePage(driver);
		NaptolHomePage.enterProductToSearch("mobile");
		NaptolHomePage.clickOnSearch();
		NaptolHomePage.moveToQuickViewOnDesiredProduct(driver, 0);
		NaptolHomePage.clickOnQuickView(0);
		NaptolHomePage.clickOnAddToCart();
		CartPage cartPage=new CartPage(driver);
		cartPage.clickOnRemove();
		Assert.assertTrue(NaptolHomePage.isRemoveButtonDisplayed(0));
	}
	@Test
	public void VerifyOnChangingProductQuantityCorrectAmountIsDisplyed() {
		test=reports.createTest("VerifyOnChangingProductQuantityCorrectAmountIsDisplyed");
			NaptolHomePage NaptolHomePage=new NaptolHomePage(driver);
			NaptolHomePage.enterProductToSearch("mobile");
			NaptolHomePage.clickOnSearch();
			NaptolHomePage.moveToQuickViewOnDesiredProduct(driver, 1);
			NaptolHomePage.clickOnQuickView(1);
			NaptolHomePage.clickOnAddToCart();
			//NaptolHomePage.clickOnCart();
			CartPage cartPage=new CartPage(driver);
			Assert.assertEquals(cartPage.getOrdeAmount(1), (cartPage.getUnitPrice(1)+cartPage.getShippingPrice(1)));
	}
	
}
