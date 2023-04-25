package stepdefinitions.apistepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.sl.In;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.openqa.selenium.json.Json;
import pojos.Room;

import java.io.IOException;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static stepdefinitions.MedunnaRoomStepDefs.roomNumber;

public class RoomGetStepDefs {
    @Given("user sends get request and validate")
    public void user_sends_get_request_and_validate() throws IOException {
        //Set the url
        //https://medunna.com/api/rooms?sort=createdDate,desc
        spec.pathParams("first","api","second","rooms").
                queryParam("sort","createdDate,desc");
        //Set the expected data
        Room expectedData = new Room("Created By Selenium For Api Test",123,roomNumber,"SUITE",true);

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        assertEquals(200,response.statusCode());


        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.getList("roomNumber"));
        System.out.println("roomNumber = " + roomNumber);

        assertTrue(jsonPath.getList("roomNumber").contains(expectedData.getRoomNumber()));
        assertTrue(jsonPath.getList("roomType").contains(expectedData.getRoomType()));
        assertTrue(jsonPath.getList("status").contains(expectedData.getStatus()));
//        assertTrue(jsonPath.getList("price").contains(123.0));
        assertTrue(jsonPath.getList("description").contains(expectedData.getDescription()));


    }
}