
@TC01_Api
Feature: Room Creation
  Scenario: TC01_Post_Room
    Given user sends post request for room data
    Then user gets the room data ans assert