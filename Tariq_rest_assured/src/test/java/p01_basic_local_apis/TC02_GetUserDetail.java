package p01_basic_local_apis;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC02_GetUserDetail {

    @Test
    public void getUserDetail() {

        Response response = RestAssured.get("http://localhost:3000/students");

        System.out.println("statusCode:- " + response.statusCode());
        System.out.println("contentType:- " + response.contentType());
        System.out.println("getContentType:- " + response.getContentType());
        System.out.println("getTime:- " + response.getTime());
        System.out.println("getStatusLine:- " + response.getStatusLine());
        System.out.println("getBody().asPrettyString():- " + response.getBody().asPrettyString());

        int statusCode = response.statusCode();
        String contentType = response.contentType();
        String getContentType = response.getContentType();
        long getTime = response.getTime();
        String getStatusLine = response.getStatusLine();
        String getBody = response.getBody().asPrettyString();
        System.out.println("statusCode:- " + statusCode);
        System.out.println("contentType:- " + contentType);
        System.out.println("getContentType:- " + getContentType);
        System.out.println("getTime:- " + getTime);
        System.out.println("getStatusLine:- " + getStatusLine);
        System.out.println("getBody().asPrettyString():- " + getBody);
    }
}
