package stepdefs;

import base_urls.ContactBaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utilities.Driver;

import static io.restassured.RestAssured.given;

public class CreateContactStepDef extends ContactBaseUrl {




    @Given("user goes to {string}")
    public void userGoesTo(String url) {
        Driver.getDriver().get(url);
        spec.pathParam("1" , "contacts");
    }

    @When("user goes to url and add contact")
    public void user_goes_to_url_and_add_contact() {



        String expectedStr = """
                {
                    "firstName": "John",
                    "lastName": "Doe",
                    "birthdate": "1970-01-01",
                    "email": "jdoe@fake.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "Anytown",
                    "stateProvince": "KS",
                    "postalCode": "12345",
                    "country": "USA"
                }""";

       Response response = given(spec).body(expectedStr).post("{1}");
       response.prettyPrint();

    }

    @And("User reads the contact")
    public void user_reads_the_contact() {

        Response response = given(spec).when().get("{1}");
        response.prettyPrint();

    }

    @And("user updates the contact")
    public void user_updates_the_contact() {
        String expectedUpdate = """
                {
                    "firstName": "Amy",
                    "lastName": "Miller",
                    "birthdate": "1992-02-02",
                    "email": "amiller@fake.com",
                    "phone": "8005554242",
                    "street1": "13 School St.",
                    "street2": "Apt. 5",
                    "city": "Washington",
                    "stateProvince": "QC",
                    "postalCode": "A1A1A1",
                    "country": "Canada"
                }""";

        Response response = given(spec).body(expectedUpdate).put("{1}");
        response.prettyPrint();

    }

    @And("user delete the created contact")
    public void user_delete_the_created_contact() {

        Response response = given(spec).delete("{1}");

    }

    @Then("negative assert the deleted contact")
    public void negative_assert_the_deleted_contact() {

    }

}
