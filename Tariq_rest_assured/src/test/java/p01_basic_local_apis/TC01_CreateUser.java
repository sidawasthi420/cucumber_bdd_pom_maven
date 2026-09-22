package p01_basic_local_apis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC01_CreateUser {

    @Test
    public void createUser() {

        String requestBody = """
                {
                    "name": "Tariq Ahmad",
                    "age": 28,
                    "course": "API Testing"
                }
                """;
        
        Response response = RestAssured
                                .with()
                                .body(requestBody)
                                .post("http://localhost:3000/students");

        System.out.println("User ID: " + response.jsonPath().getString("id"));
        System.out.println("User Name: " + response.jsonPath().getString("name"));

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Content Type: " + response.contentType());
        System.out.println("Response Time: " + response.getTime());
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Response Body: " + response.getBody().asPrettyString());
    }
}