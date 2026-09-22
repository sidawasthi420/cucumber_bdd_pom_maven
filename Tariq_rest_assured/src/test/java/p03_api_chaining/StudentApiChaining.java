package p03_api_chaining;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class StudentApiChaining {

    @Test
    public void studentApiChaining() {

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

        Response response = RestAssured
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

        System.out.println();
        System.out.println("GET RESPONSE");
        String studentId = response.jsonPath().getString("id");
        System.out.println("Student ID: " + studentId);
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Student Name: " + response.jsonPath().getString("name"));
        System.out.println("Student Age: " + response.jsonPath().getString("age"));
        System.out.println("Student Grade: " + response.jsonPath().getString("grade"));
        System.out.println("Student Subjects: " + response.jsonPath().getString("subjects"));
        System.out.println("Response Body: " + response.getBody().asPrettyString());

        Response getResponse = RestAssured
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
        System.out.println("Status Code: " + getResponse.statusCode());
        System.out.println("Student ID: " + getResponse.jsonPath().getString("id"));
        System.out.println("Student Name: " + getResponse.jsonPath().getString("name"));
        System.out.println("Student Age: " + getResponse.jsonPath().getString("age"));
        System.out.println("Student Grade: " + getResponse.jsonPath().getString("grade"));
        System.out.println("Student Subjects: " + getResponse.jsonPath().getString("subjects"));
        System.out.println("Response Body: " + getResponse.getBody().asPrettyString());

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

        Response putResponse = RestAssured
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
        System.out.println("Status Code: " + putResponse.statusCode());
        System.out.println("Student ID: " + putResponse.jsonPath().getString("id"));
        System.out.println("Student Name: " + putResponse.jsonPath().getString("name"));
        System.out.println("Student Age: " + putResponse.jsonPath().getString("age"));
        System.out.println("Student Grade: " + putResponse.jsonPath().getString("grade"));
        System.out.println("Student Subjects: " + putResponse.jsonPath().getString("subjects"));
        System.out.println("Response Body: " + putResponse.getBody().asPrettyString());

        JSONArray partiallyUpdatedSubjects = new JSONArray();
        partiallyUpdatedSubjects.put("Manual");

        JSONObject partiallyUpdatedRequest = new JSONObject();
        partiallyUpdatedRequest.put("name", "Manoj");
        partiallyUpdatedRequest.put("age", 25);
        partiallyUpdatedRequest.put("subjects", partiallyUpdatedSubjects);

        Response patchResponse = RestAssured
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
        System.out.println("Status Code: " + patchResponse.statusCode());
        System.out.println("Student ID: " + patchResponse.jsonPath().getString("id"));
        System.out.println("Student Name: " + patchResponse.jsonPath().getString("name"));
        System.out.println("Student Age: " + patchResponse.jsonPath().getString("age"));
        System.out.println("Student Grade: " + patchResponse.jsonPath().getString("grade"));
        System.out.println("Student Subjects: " + patchResponse.jsonPath().getString("subjects"));
        System.out.println("Response Body: " + patchResponse.getBody().asPrettyString());

        Response deleteResponse = RestAssured
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
        System.out.println("Status Code: " + deleteResponse.statusCode());
        System.out.println("Deleted Student ID: " + studentId);
    }
}