Feature: Create Pet

  @GET

  Scenario Outline: Successfully create a pet

    When I send a request to the endpoint "<endpoint>" with pet id "<id>"
    Then I Validate that the response code is "<code>"

    Examples:
      | endpoint | id | code |
      | /pet     | /1  | 200  |