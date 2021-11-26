Feature: Login To nop commerce

  @ui
  Scenario Outline: verify login with valid credentials
    Given i navigate to url "https://demo.nopcommerce.com/"
    Then  i should be navigated to home page
    When  i click on login link from the navbar
    Then  i should be navigated to login page
    When  i enter email as "<email>"
    And   i enter password as "<password>"
    And   i click on login button
    Then  i should be logged in successfully

    Examples:

      | email         | password    |
      | user1@nop.com | Testing@123 |
      | user2@nop.com | Testing@123 |
      | user3@nop.com | Testing@123 |




