package stepDefinitions;

import java.util.List;

import hooks.hook;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login {


    @Given("^Navigate to url \"([^\"]*)\"$")
    public void navigate_to_url(String url) {
       hook.driver.get(url);
    }

    @When("^User enter the username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enter_the_username_and_password(String username, String password) {
        System.out.println("User name is " + username);
        System.out.println("Password is "+ password);
    }

    @When("^User clicks on Login button$")
    public void user_clicks_on_login_button() {
        System.out.println("Login button clicked");
    }

    @Then("^User should get logged in successfully$")
    public void user_should_get_logged_in_successfully() {
        System.out.println("User logged in successfully");
    }

    @Then("^User should not get logged-in into the application$")
    public void user_should_not_get_logged_in_successfully() {
        System.out.println("User login failed");
    }

    @And("^Enter the data in the user table given below$")
    public void enter_the_data_in_user_table(DataTable userData) {
         List<List<String>> userInfo = userData.asLists();

         for(int i=0; i<userInfo.size(); i++)
         {
           for(int j=0; j<userInfo.get(i).size(); j++)
           {
            System.out.print(userInfo.get(i).get(j) + "  ");
           }
           System.out.println();
         }
    }
}
