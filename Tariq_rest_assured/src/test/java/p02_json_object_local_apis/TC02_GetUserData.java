package p02_json_object_local_apis;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import org.testng.annotations.Test;

@Test 
public class TC02_GetUserData {

        private static final int AGE = 29;
        private static final String ID= "1";

    public void get_User_Data(){

        given()
            .get("http://localhost:3000/students/1")
        .then()
            .statusCode(200)
            // .body("age", equalTo(29))
            // .body("id", equalTo(1));
            .body("age", equalTo(AGE))
            .body("id", containsString(ID));
    }
}