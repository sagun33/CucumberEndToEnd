package stepdefinitions.apistepdefinitions;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import pojos.Room;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static base_urls.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;


public class RoomCreationStepDefs {
    Response response;
    int roomNumber = Faker.instance().number().numberBetween(1000, 1000000);
    Room expectedData;

    @Given("user sends post request for room data")
    public void user_sends_post_request_for_room_data() {
        //Set the url
        spec.pathParams("first", "api", "second", "rooms");

        //Set the expected data
        expectedData = new Room("Api'dan yeni oda", 123, roomNumber, "TWIN", true);

        //Send the request and get the response
        response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();
    }

    @Then("user gets the room data and assert")
    public void user_gets_the_room_data_and_assert() throws IOException {
        assertEquals(201, response.statusCode());

        //1. Validation
        response.
                then().
                body("roomNumber", equalTo(roomNumber)).
                body("roomType", equalTo("TWIN")).
                body("status", equalTo(true)).
                body("price", equalTo(123)).
                body("description", equalTo("Api'dan yeni oda"));

        //2. Validation
        JsonPath jsonPath = response.jsonPath();
        assertEquals((int) expectedData.getRoomNumber(), jsonPath.getInt("roomNumber"));
        assertEquals(expectedData.getRoomType(), jsonPath.getString("roomType"));
        assertEquals(expectedData.getStatus(), jsonPath.getBoolean("status"));
        assertEquals((int) expectedData.getPrice(), jsonPath.getInt("price"));
        assertEquals(expectedData.getDescription(), jsonPath.getString("description"));

        //3. Validation
        Map<String, Object> actualDataMap = response.as(HashMap.class);

        assertEquals(expectedData.getRoomNumber(), actualDataMap.get("roomNumber"));
        assertEquals(expectedData.getRoomType(), actualDataMap.get("roomType"));
        assertEquals(expectedData.getStatus(), actualDataMap.get("status"));
        assertEquals(expectedData.getPrice(), actualDataMap.get("price"));
        assertEquals(expectedData.getDescription(), actualDataMap.get("description"));

        //4. Validation
        Room actualDataPojo = response.as(Room.class);

        assertEquals(expectedData.getRoomNumber(), actualDataPojo.getRoomNumber());
        assertEquals(expectedData.getRoomType(), actualDataPojo.getRoomType());
        assertEquals(expectedData.getStatus(), actualDataPojo.getStatus());
        assertEquals(expectedData.getPrice(), actualDataPojo.getPrice());
        assertEquals(expectedData.getDescription(), actualDataPojo.getDescription());

        //5. Validation
        Room actualDataObjectMapper = new ObjectMapper().readValue(response.asString(), Room.class);

        assertEquals(expectedData.getRoomNumber(), actualDataObjectMapper.getRoomNumber());
        assertEquals(expectedData.getRoomType(), actualDataObjectMapper.getRoomType());
        assertEquals(expectedData.getStatus(), actualDataObjectMapper.getStatus());
        assertEquals(expectedData.getPrice(), actualDataObjectMapper.getPrice());
        assertEquals(expectedData.getDescription(), actualDataObjectMapper.getDescription());

        //6. Validation
        Room actualDataGson = new Gson().fromJson(response.asString(), Room.class);

        assertEquals(expectedData.getRoomNumber(), actualDataGson.getRoomNumber());
        assertEquals(expectedData.getRoomType(), actualDataGson.getRoomType());
        assertEquals(expectedData.getStatus(), actualDataGson.getStatus());
        assertEquals(expectedData.getPrice(), actualDataGson.getPrice());
        assertEquals(expectedData.getDescription(), actualDataGson.getDescription());

    }
}