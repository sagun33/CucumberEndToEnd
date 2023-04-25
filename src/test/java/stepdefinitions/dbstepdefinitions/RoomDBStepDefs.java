package stepdefinitions.dbstepdefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static stepdefinitions.MedunnaRoomStepDefs.roomNumber;

public class RoomDBStepDefs {

    @Given("Olusan odayi room_number ile dogrula")
    public void olusan_odayi_room_number_ile_dogrula() throws SQLException {
        Connection connection=DriverManager.getConnection("jdbc:postgresql://medunna.com:5432/medunna_db_v2","select_user","Medunna_pass_@6");
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("SELECT * FROM room ORDER BY created_date DESC");

        List<Integer>roomNumberList=new ArrayList<>();
        while(resultSet.next()){
            roomNumberList.add(resultSet.getInt(2));
        }
        System.out.println("roomNumberList.get(3) = " + roomNumberList.get(3));

        assertTrue(roomNumberList.contains(roomNumber));
        System.out.println("roomNumber = " + roomNumber);


    }
}