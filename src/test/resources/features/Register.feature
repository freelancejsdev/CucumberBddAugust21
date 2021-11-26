Feature: User Registration

  Background: navigate to url and click on register link
    Given i am on the nopCommerce home page get page title
    When  i click on register link from the navbar and get page title

   @regression
  Scenario: Verify user registration by entering data in all mandatory fields

    And   i select gender as male
    And   i enter firstName lastName email password confPassword
      | firstName | lastName | email            | password    | confPassword |
      | user      | qa       | userqa2@test.com | Testing@123 | Testing@123  |
    And  i enter date of birth
    And  i click on register button
    Then i should be registered successfully

 @sanity  @ui
  Scenario:  Verify user registration by not entering data in all mandatory fields

    And  i click on register button
    Then i should see error messages for all mandatory fields
