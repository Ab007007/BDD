package pom.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CustomerCreationPage {

	WebDriver driver = null;

	public CustomerCreationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(id = "customerLightBox_nameField")
	WebElement customerName;

	@FindBy(id = "customerLightBox_descriptionField")
	WebElement customerDesc;

	@FindBy(id = "customerLightBox_commitBtn")
	WebElement ccButton;

	@FindBy(xpath = "//div[@class='toast']")
	WebElement toastMessage;

	
	public void enterCustomerName(String name)
	{
		customerName.sendKeys(name);
	}
	public void enterCustomerDesc(String name)
	{
		customerDesc.sendKeys(name);
	}
	public void clickOnCC()
	{
		ccButton.click();
		
	}
	
	
	public WebElement getToastEle()
	{
		return toastMessage;
	}
}
