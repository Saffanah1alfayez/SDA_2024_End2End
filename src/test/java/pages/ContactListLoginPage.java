package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactListLoginPage {

    public ContactListLoginPage (){
        PageFactory.initElements(Driver.getDriver() ,this);
    }

    @FindBy(id = "signup")
    public WebElement signupButton;














}
