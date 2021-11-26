package steps;

import base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions
{
    String homePageExpectedTitle = "nopCommerce demo store";
    String homePageActualTitle;

    String registerPageExpectedTitle = "nopCommerce demo store. Register";
    String registerPageActualTitle;

    String registerExpectedConfMsg = "Your registration completed";
    String registerActualConfMsg;


    String loginPageExpectedTitle = "nopCommerce demo store. Login";
    String loginPageActualTitle;

    @Given("i navigate to url {string}")
    public void i_navigate_to_url(String url)
    {
        BasePage.driverUtils.navigateToUrl(url);
    }

    @Then("i should be navigated to home page")
    public void i_should_be_navigated_to_home_page()
    {
        homePageActualTitle = BasePage.driverUtils.getPageTitle();
        Assertions.assertEquals(homePageExpectedTitle,homePageActualTitle);
    }

    @When("i click on login link from the navbar")
    public void i_click_on_login_link_from_the_navbar()
    {
        BasePage.homePage.clickLoginLink();
    }

    @Then("i should be navigated to login page")
    public void i_should_be_navigated_to_login_page()
    {
        loginPageActualTitle = BasePage.driverUtils.getPageTitle();
        Assertions.assertEquals(loginPageExpectedTitle,loginPageActualTitle);
    }

    @When("i enter email as {string}")
    public void i_enter_email_as(String email)
    {
        BasePage.loginPage.enterEmail(email);
    }
    @When("i enter password as {string}")
    public void i_enter_password_as(String pw)
    {
        BasePage.loginPage.enterPassword(pw);
    }

    @When("i click on login button")
    public void i_click_on_login_button()
    {
        BasePage.loginPage.clickLogin();
    }

    @Then("i should be logged in successfully")
    public void i_should_be_logged_in_successfully()
    {

    }


    @Given("i am on the nopCommerce home page get page title")
    public void i_am_on_the_nop_commerce_home_page_get_page_title()
    {
        BasePage.driverUtils.load();
        homePageActualTitle = BasePage.driverUtils.getPageTitle();
        Assertions.assertEquals(homePageExpectedTitle,homePageActualTitle);

    }
    @When("i click on register link from the navbar and get page title")
    public void i_click_on_register_link_from_the_navbar_and_get_page_title()
    {
        BasePage.homePage.clickRegisterLink();
        registerPageActualTitle = BasePage.driverUtils.getPageTitle();
        Assertions.assertEquals(registerPageExpectedTitle,registerPageActualTitle);
    }
    @When("i select gender as male")
    public void i_select_gender_as_male()
    {
        BasePage.registerPage.clickMaleRadioButton();
    }
    @When("i enter firstName lastName email password confPassword")
    public void i_enter_first_name_last_name_email_password_conf_password(io.cucumber.datatable.DataTable dataTable)
    {
        BasePage.registerPage.enterFirstName(dataTable.cell(1,0));
        BasePage.registerPage.enterLastName(dataTable.cell(1,1));
        BasePage.registerPage.enterEmail(dataTable.cell(1,2));
        BasePage.registerPage.enterPassword(dataTable.cell(1,3));
        BasePage.registerPage.enterConfPassword(dataTable.cell(1,4));
    }
    @When("i enter date of birth")
    public void i_enter_date_of_birth()
    {
        BasePage.registerPage.selectDay();
        BasePage.registerPage.selectMonth();
        BasePage.registerPage.selectYear();
    }
    @When("i click on register button")
    public void i_click_on_register_button()
    {
        BasePage.registerPage.clickRegisterButton();
    }
    @Then("i should be registered successfully")
    public void i_should_be_registered_successfully()
    {
        registerActualConfMsg = BasePage.registerPage.getRegistrationText();
        Assertions.assertEquals(registerExpectedConfMsg,registerActualConfMsg);
    }


    @Then("i should see error messages for all mandatory fields")
    public void iShouldSeeErrorMessagesForAllMandatoryFields()
    {

    }
}
