package p02_json_object_local_apis;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class TC05_DeleteUser {

        private static final int EXPECTED_STATUSCODE = 200;

    @Test 
    public void delete_User(){

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

        when()
            .delete("http://localhost:3000/students/f2a9")      
        .then()
            .statusCode(EXPECTED_STATUSCODE)
            .log().all();
    }
}