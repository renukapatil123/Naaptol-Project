package pom;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaptolHomePage  {

	@FindBy (xpath="//div[@class='cate_head']")private WebElement categories;
	@FindBy (xpath="//input[@id='header_search_text']")private WebElement searchfield;
	@FindBy (xpath ="(//div[@class='search']//a)[2]") private WebElement search;
	@FindBy (xpath="//div[@class='grid_Square ']")private List<WebElement> products;
	//@FindBy (xpath="//a[@id='quickViewId1']")private WebElement quickView;
	@FindBy (xpath="//a[@class='bt_compare icon chat quickFancyBox']")private List<WebElement> quickView;
	@FindBy (xpath="(//div[@class='item_title'])[1]")private List<WebElement> productTitle;
	@FindBy (xpath="//span[@class='offer-price']")private WebElement offerPrice;
	@FindBy (xpath="//div[@id='square_Details']")private WebElement productTitleOnQuickView;
	@FindBy (xpath="//a[@class='cart-panel-link']")private WebElement cart;
	@FindBy (xpath="//a[@title='Buy online']")private WebElement addToCart;
	@FindBy (xpath="//button[@type='button']")private WebElement close;
	private WebDriver driver;
	private int index;
	
	public NaptolHomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	public void enterProductToSearch(String product) {
		searchfield.sendKeys(product);
	}
	
	public void clickOnSearch() {
		search.click();
	}
	public int getNumberOfProduct() {
		return products.size();
	}
	
	
	public void clickOnQuickView(int index) {
	           quickView.get(index).click();
	}
	
	public void moveToQuickViewOnDesiredProduct(WebDriver driver, int index) {
		Actions a=new Actions(driver);
		a.moveToElement(products.get(index));
		a.perform();
	}
	public void closeQuickViewWindow() {
		close.click();
	}
	public String getProductTitle(int index) {
		return productTitle.get(index).getText();
	}
	
	public String getProductPrice(int index) {
		return offerPrice.getText();
	}
	public String getProductTitleInQuickView(int index) {
		return productTitleOnQuickView.getText();
	}
	public boolean isRemoveButtonDisplayed(int index) {
		boolean result=addToCart.isDisplayed();
		return result;
	}
	public void clickOnShoppingCategories() {
		categories.click();
	}
	
	public void clickOnAddToCart() {
		addToCart.click();
	}
	
	public void clickOnCart() {
		cart.click();
	}

	
}
