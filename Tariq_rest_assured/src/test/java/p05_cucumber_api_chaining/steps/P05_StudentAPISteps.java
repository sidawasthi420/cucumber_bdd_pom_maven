package p05_cucumber_api_chaining.steps;

import static org.testng.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class P05_StudentAPISteps {

    Response response;

    String studentId;

    @Given("^student API is available$")
    public void student_api_is_available() {

        System.out.println("Student API is available");
    }

    @When("^I send POST request to create student$")
    public void i_send_post_request_to_create_student() {

        JSONArray subjects = new JSONArray();
        subjects.put("Java");
        subjects.put("Selenium");
        subjects.put("Rest Assured");
        subjects.put("Cucumber");

        JSONObject request = new JSONObject();
        request.put("name", "Rahul Sharma");
        request.put("age", 26);
        request.put("grade", "A");
        request.put("subjects", subjects);

        response = RestAssured
                .given()
                    .header("Content-Type", "application/json")
                    .body(request.toString())

                .when()
                    .post("http://localhost:3000/students")

                .then()
                    .statusCode(201)
                    .log().all()
                    .extract()
                    .response();

        studentId = response.jsonPath().getString("id");

        System.out.println();
        System.out.println("POST RESPONSE");
        System.out.println("Student ID: " + studentId);
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Student Name: " + response.jsonPath().getString("name"));
        System.out.println("Student Age: " + response.jsonPath().getString("age"));
        System.out.println("Student Grade: " + response.jsonPath().getString("grade"));
        System.out.println("Student Subjects: " + response.jsonPath().getString("subjects"));
        System.out.println("Response Body: " + response.getBody().asPrettyString());
    }

    @When("^I send GET request for created student$")
    public void i_send_get_request_for_created_student() {

        response = RestAssured
                .given()
                    .pathParam("id", studentId)

                .when()
                    .get("http://localhost:3000/students/{id}")

                .then()
                    .statusCode(200)
                    .log().all()
                    .extract()
                    .response();

        System.out.println();
        System.out.println("GET RESPONSE");
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Student ID: " + response.jsonPath().getString("id"));
        System.out.println("Student Name: " + response.jsonPath().getString("name"));
        System.out.println("Student Age: " + response.jsonPath().getString("age"));
        System.out.println("Student Grade: " + response.jsonPath().getString("grade"));
        System.out.println("Student Subjects: " + response.jsonPath().getString("subjects"));
        System.out.println("Response Body: " + response.getBody().asPrettyString());
    }

    @When("^I send PUT request to update created student$")
    public void i_send_put_request_to_update_created_student() {

        JSONArray updatedSubjects = new JSONArray();
        updatedSubjects.put("Postman");
        updatedSubjects.put("Playwright");
        updatedSubjects.put("Cucumber");
        updatedSubjects.put("Core Java");

        JSONObject updatedRequest = new JSONObject();
        updatedRequest.put("name", "Anil Sharma");
        updatedRequest.put("age", 33);
        updatedRequest.put("grade", "A+");
        updatedRequest.put("subjects", updatedSubjects);

        response = RestAssured
                .given()
                    .header("Content-Type", "application/json")
                    .pathParam("id", studentId)
                    .body(updatedRequest.toString())

                .when()
                    .put("http://localhost:3000/students/{id}")

                .then()
                    .statusCode(200)
                    .log().all()
                    .extract()
                    .response();

        System.out.println();
        System.out.println("PUT RESPONSE");
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Student ID: " + response.jsonPath().getString("id"));
        System.out.println("Student Name: " + response.jsonPath().getString("name"));
        System.out.println("Student Age: " + response.jsonPath().getString("age"));
        System.out.println("Student Grade: " + response.jsonPath().getString("grade"));
        System.out.println("Student Subjects: " + response.jsonPath().getString("subjects"));
        System.out.println("Response Body: " + response.getBody().asPrettyString());
    }

    @When("^I send PATCH request to partially update created student$")
    public void i_send_patch_request_to_partially_update_created_student() {

        JSONArray partiallyUpdatedSubjects = new JSONArray();
        partiallyUpdatedSubjects.put("Manual");

        JSONObject partiallyUpdatedRequest = new JSONObject();
        partiallyUpdatedRequest.put("name", "Manoj");
        partiallyUpdatedRequest.put("age", 25);
        partiallyUpdatedRequest.put("subjects", partiallyUpdatedSubjects);

        response = RestAssured
                .given()
                    .header("Content-Type", "application/json")
                    .pathParam("id", studentId)
                    .body(partiallyUpdatedRequest.toString())

                .when()
                    .patch("http://localhost:3000/students/{id}")

                .then()
                    .statusCode(200)
                    .log().all()
                    .extract()
                    .response();

        System.out.println();
        System.out.println("PATCH RESPONSE");
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Student ID: " + response.jsonPath().getString("id"));
        System.out.println("Student Name: " + response.jsonPath().getString("name"));
        System.out.println("Student Age: " + response.jsonPath().getString("age"));
        System.out.println("Student Grade: " + response.jsonPath().getString("grade"));
        System.out.println("Student Subjects: " + response.jsonPath().getString("subjects"));
        System.out.println("Response Body: " + response.getBody().asPrettyString());
    }

    @When("^I send DELETE request for created student$")
    public void i_send_delete_request_for_created_student() {

        response = RestAssured
                .given()
                    .pathParam("id", studentId)

                .when()
                    .delete("http://localhost:3000/students/{id}")

                .then()
                    .statusCode(200)
                    .log().all()
                    .extract()
                    .response();

        System.out.println();
        System.out.println("DELETE RESPONSE");
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Deleted Student ID: " + studentId);
    }

    @Then("^response status code should be \"([^\"]*)\"$")
    public void response_status_code_should_be(int expectedStatusCode) {

        assertEquals(response.statusCode(), expectedStatusCode);

        System.out.println("Expected Status Code: " + expectedStatusCode);
        System.out.println("Actual Status Code: " + response.statusCode());
    }
}