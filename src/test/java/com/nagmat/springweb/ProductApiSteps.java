package com.nagmat.springweb;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@CucumberContextConfiguration
public class ProductApiSteps {

    private Response response;

    @Given("I set the base URI for the API")
    public void iSetTheBaseUriForTheApi() {
        RestAssured.baseURI = "http://localhost:8080/productapi/";
    }

    @When("I send a GET request to {string}")
    public void iSendAGetRequestTo(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        System.out.println("Response: " + response.asString()+"Status code: "+statusCode);
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response should contain {string}")
    public void theResponseShouldContain(String expectedValue) {
        response.then().body("name", equalTo(expectedValue));
    }

}
