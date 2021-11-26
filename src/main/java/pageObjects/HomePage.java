package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;

    //locators
    //@FindBy(linkText = "hghjvhjvjv")

    @FindBy(linkText = "Register")
    public WebElement registerLink;


    @FindBy(linkText = "Log in")
    public WebElement logInLink;


    @FindBy(id = "small-searchterms")
    public WebElement searchTextbox;

    @FindBy(className = "search-box-button")
    public WebElement searchButton;

    @FindBy(className = "ico-logout")
    public WebElement logoutLink;


    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);


    }

    //actions
    public void clickRegisterLink()
    {

        registerLink.click();
    }


    public void clickLoginLink()
    {
        logInLink.click();
    }

    public void enterSearchItem(String item)
    {
        searchTextbox.sendKeys(item);
    }


    public void clickSearchButton()
    {
        searchButton.click();
    }


    public void clickLogoutLink()
    {
        logoutLink.click();
    }


    public boolean verifyLogout()
    {
        return  logoutLink.isDisplayed();
    }

}
