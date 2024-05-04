package stepdefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pages.ContactListAddUserPage;
import pages.ContactListLoginPage;
import pojos.UserResponsePojo;
import utilities.Driver;
import utilities.ObjectMapperUtilities;

import static base_urls.ContactListBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;
import static utilities.ObjectMapperUtilities.convertJsonToJava;

public class CreateUserStepDefinitions {

    public static String firstName;
    public  static String lastName;

   public static String email ;

    public static String password;
    ContactListLoginPage loginPage = new ContactListLoginPage();
    ContactListAddUserPage addUserPage = new ContactListAddUserPage();


    @Given("user goes to {string}")
    public void userGoesTo(String url) {
        Driver.getDriver().get(url);

    }

    @When("user clicks on sign up button")
    public void userClicksOnSignUpButton() {
        loginPage.signupButton.click();

    }

    @And("User enters firstname, lastname, email, password")
    public void userEntersFirstnameLastnameEmailPassword() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        password = "Password.123";

        addUserPage.firstNameFiled.sendKeys(firstName);
        addUserPage.lastNameFiled.sendKeys(lastName);
        addUserPage.emailField.sendKeys(email);
        addUserPage.passwordField.sendKeys(password);

    }

    @And("user clicks on submit button")
    public void userClicksOnSubmitButton() {
        addUserPage.submitButton.click();
    }

    @And("user closes browser")
    public void userClosesBrowser() {
        Driver.tearDown();
    }

    @Then("verify the user via API request")
    public void verifyTheUserViaAPIRequest() {
        //set url
        spec.pathParams("1" ,"users" , "2" , "me");

        // set expected data
        String payliadStr = """
                {
                  "_id": null,
                  "firstName": "Test",
                  "lastName": "User",
                  "email": "test@fake.com",
                  "__v": 1
                }""";


        UserResponsePojo expectedData = convertJsonToJava(payliadStr, UserResponsePojo.class);


        //send req and get res
        Response response = given(spec).when().get("{1}/{2}");
        response.prettyPrint();

        // do assertion
        UserResponsePojo actualData = convertJsonToJava(response.asString() , UserResponsePojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstName(),actualData.getLastName());
        assertEquals(expectedData.getLastName(),actualData.getLastName());
        assertEquals(expectedData.getEmail(),actualData.getEmail());
    }
}
