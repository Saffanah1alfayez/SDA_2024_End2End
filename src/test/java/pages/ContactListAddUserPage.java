package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactListAddUserPage {

    public ContactListAddUserPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "firstName")

    public WebElement firstNameFiled;

    @FindBy(id = "lastName")

    public WebElement lastNameFiled;


    @FindBy(id = "email")

    public WebElement emailField;

    @FindBy(id = "password")

    public WebElement passwordField;


    @FindBy(id = "submit")

    public WebElement submitButton;













}
