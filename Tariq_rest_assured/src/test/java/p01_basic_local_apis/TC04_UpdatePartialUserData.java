package p01_basic_local_apis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC04_UpdatePartialUserData{

    @Test
    public void updatePartialUserData() {

        String requestBody = """
                {
                    "course": "Rest Assured"
                }
                """;
                
        Response response = RestAssured
                .with()
                .body(requestBody)
                .patch("http://localhost:3000/students/b191");

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Content Type: " + response.contentType());
        System.out.println("Response Time: " + response.getTime());
        System.out.println("Status Line: " + response.getStatusLine());
        System.out.println("Response Body: " + response.getBody().asPrettyString());
                System.out.println("User ID: " + response.jsonPath().getString("id"));

    }
}
