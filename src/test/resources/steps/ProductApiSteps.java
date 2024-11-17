package com.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.rest-assured.RestAssured;
import io.rest-assured.response.Response;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductApiSteps {

    private Response response;

    @Given("I set the base URI for the API")
    public void i_set_the_base_uri_for_the_api() {
        RestAssured.baseURI = "http://localhost:8080/productapi"; // Adjust as needed
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = RestAssured.get(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String key) {
        response.then().body("$", hasKey(key));
    }
}
