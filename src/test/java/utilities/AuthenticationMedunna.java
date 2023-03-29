package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;


import static io.restassured.RestAssured.given;

public class AuthenticationMedunna {

    public static String generateToken(){

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("password","Batch.103");
        bodyMap.put("rememberMe",true);
        bodyMap.put("username","batch_yuzuc");

        Response response = given().contentType(ContentType.JSON).body(bodyMap).post("https://medunna.com/api/authenticate");
        return  response.jsonPath().getString("id_token");
    }
}