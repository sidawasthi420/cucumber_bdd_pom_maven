package p02_json_object_local_apis;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TC01_CreateUser
 {

    private static final int EXPECTED_STATUSCODE = 201;
    private static final int AGE = 20;
    private static final String NAME = "test01";

    @Test
    public void create_User() {
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
        objectArray.put("Hindi");
        objectArray.put("Sanskrit");
        objectArray.put("Computer");
        objectArray.put("Chemistry");

        JSONObject request = new JSONObject();
        request.put("name", NAME);
        request.put("age", AGE);
        request.put("grade", "11th");
        request.put("subjects", objectArray);

        given()
            .header("Content-Type", "application/json")
            .body(request.toString())

        .when()
            .post("http://localhost:3000/students")

        .then()
            .statusCode(EXPECTED_STATUSCODE)
            .body("age", equalTo(AGE))
            .body("name", containsString(NAME));
    }
}