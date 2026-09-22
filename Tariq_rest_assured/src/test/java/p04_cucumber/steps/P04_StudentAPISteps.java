package p04_cucumber.steps;

import static org.testng.Assert.assertEquals;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONArray;
import org.json.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class P04_StudentAPISteps {

    Response response;

    String studentId;

    @Given("student API is available")
    public void student_api_is_available() {

        System.out.println("Student API is available");
    }

    @When("^I send POST request to create student$")
public void i_send_post_request_to_create_student() {

    final int EXPECTED_STATUSCODE = 201;
    final String NAME = "Tariq Ahmad";
    final int AGE = 28;

    JSONArray objectArray = new JSONArray();
    objectArray.put("Hindi");
    objectArray.put("Sanskrit");
    objectArray.put("Computer");
    objectArray.put("Chemistry");

        JSONObject request = new JSONObject();
        request.put("name", "Tariq Ahmad");
        request.put("age", 28);
        request.put("grade", "11th");
        request.put("subjects", objectArray);

    response = RestAssured
            .given()
                .header("Content-Type", "application/json")
                .body(request.toString())

            .when()
                .post("http://localhost:3000/students")

            .then()
                .statusCode(EXPECTED_STATUSCODE)
                .body("age", equalTo(AGE))
                .body("name", containsString(NAME))
                .extract()
                .response();

        studentId = response.jsonPath().getString("id");

        System.out.println("POST RESPONSE");
        System.out.println("User ID: " + response.jsonPath().getString("id"));
        System.out.println("User Name: " + response.jsonPath().getString("name"));
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Content Type: " + response.contentType());
        System.out.println("Response Time: " + response.getTime());
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Response Body: " + response.getBody().asPrettyString());
    }

    @When("^I send GET request for created student$")
    public void i_send_get_request_for_created_student() {

        response = RestAssured
                .get("http://localhost:3000/students/" + studentId);

        System.out.println("GET RESPONSE");
        System.out.println("User ID: " + response.jsonPath().getString("id"));
        System.out.println("User Name: " + response.jsonPath().getString("name"));
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Content Type: " + response.contentType());
        System.out.println("Response Time: "  +response.getTime());
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Response Body: " + response.getBody().asPrettyString());
    }

    @When("^I send PUT request to update created student$")
    public void i_send_put_request_to_update_created_student() {

        JSONArray objectArray = new JSONArray();
        objectArray.put("Java");
        objectArray.put("Selenium");
        objectArray.put("Rest Assured");
        objectArray.put("Cucumber");

        JSONObject request = new JSONObject();
        request.put("name", "Tariq");
        request.put("age", 30);
        request.put("grade", "12th");
        request.put("subjects", objectArray);

        response = RestAssured
                .with()
                .body(request.toString())
                .put("http://localhost:3000/students/" + studentId);

        System.out.println("PUT RESPONSE");
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Content Type: " + response.contentType());
        System.out.println("Response Time: " + response.getTime());
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Response Body: " + response.getBody().asPrettyString());
        System.out.println("User ID: " + response.jsonPath().getString("id"));
    }

    @When("^I send PATCH request to partially update created student$")
    public void i_send_patch_request_to_partially_update_created_student() {

        JSONArray objectArray = new JSONArray();
        objectArray.put("API Testing");
        objectArray.put("Postman");
        objectArray.put("Rest Assured");

        JSONObject request = new JSONObject();
        request.put("name", "Tariq Ahmad Updated");
        request.put("age", 31);
        request.put("subjects", objectArray);

        response = RestAssured
                .with()
                .body(request.toString())
                .patch("http://localhost:3000/students/" + studentId);

        System.out.println("PATCH RESPONSE");
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Content Type: " + response.contentType());
        System.out.println("Response Time: " + response.getTime());
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Response Body: " + response.getBody().asPrettyString());
        System.out.println("User ID: " + response.jsonPath().getString("id"));
    }

    @When("^I send DELETE request for created student$")
    public void i_send_delete_request_for_created_student() {

        response = RestAssured
                .delete("http://localhost:3000/students/" + studentId);

        System.out.println("DELETE RESPONSE");
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Content Type: " + response.contentType());
        System.out.println("Response Time: " + response.getTime());
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Response Body: " + response.getBody().asPrettyString());
        System.out.println("User ID: " + response.jsonPath().getString("id"));
    }

    @Then("^response status code should be \"([^\"]*)\"$")
    public void response_status_code_should_be(int expectedStatusCode) {

        assertEquals(response.statusCode(), expectedStatusCode);
        System.out.println("Expected Status Code: " + expectedStatusCode);
        System.out.println("Actual Status Code: " + response.statusCode());
    }
}