package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage  {

	@FindBy (xpath="//u1[@id='cartData]")  private List<WebElement> cartItems;
	@FindBy (xpath="//div[@class='cart_info']") private List<WebElement> productName;
	@FindBy (xpath="//li[@class='head_UPrice']") private List<WebElement> unitPrice;
	@FindBy (xpath="//li[@class='head_ship']") private List<WebElement> shippingPrice;
	@FindBy (xpath="//li[text()='Order Amount']") private List<WebElement> orderAmount;
	@FindBy (xpath="//a[text()='Remove']") private WebElement remove;
	@FindBy (xpath="//a[@class='red_button2']") private WebElement checkout;
	@FindBy (xpath="//a[@onclick='cart.continueShopping()']") private WebElement continueShopping;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int getCartItem() {
		return cartItems.size();
	}
	public String getProductName(int index) {
		return productName.get(index).getText();
	}
	public double getUnitPrice(int index) {
		return Double.parseDouble(unitPrice.get(index).getText());
	}
	public double getShippingPrice(int index) {
		return Double.parseDouble(shippingPrice.get(index).getText());
	}
	public double getOrdeAmount(int index) {
		return Double.parseDouble(orderAmount.get(index).getText());
	}
	
	
	public void clickOnRemove() {
		remove.click();
	}
	public void clickOnCheckout() {
		checkout.click();
	}
	public void clickOnContinueShopping() {
		continueShopping.click();
	}
}

