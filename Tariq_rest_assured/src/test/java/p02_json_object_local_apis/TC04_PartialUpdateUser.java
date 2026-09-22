package p02_json_object_local_apis;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TC04_PartialUpdateUser {

        private static final int EXPECTED_STATUSCODE = 200;
        private static final int AGE = 12;
        private static final String NAME = "test_user_1000";

    @Test 
    public void partial_update_User(){

//       {
//     "name": "Siddhant Awasthi",
//     "age": 29,
//     "grade": "12th",
//     "subjects": [
//       "Maths",
//       "Physics",
//       "Chemistry",
//       "Computer"
//     ],
//     "id": "1"
//   }

        JSONArray objectArray = new JSONArray();
        objectArray.put("German");

        JSONObject request = new JSONObject();
        request.put("name", NAME);
        request.put("age", AGE);
        request.put("subjects", objectArray);

        given()
            .header("Content-Type", "application/json")
            .body(request.toString())
        .when()
            .put("http://localhost:3000/students/bf34")      
        .then()
            .statusCode(EXPECTED_STATUSCODE)
        //   .body("status code", equalTo(EXPECTED_STATUSCODE))
            .body("age", equalTo(AGE))
            .body("name", containsString(NAME));
    }
}