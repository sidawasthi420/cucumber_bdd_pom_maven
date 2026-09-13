package yashwin.StructurePractice.java.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import yashwin.StructurePractice.java.pages.LoginPage;

public class login {

    private LoginPage loginPage;

    public login(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("^User navigates to url \"([^\"]*)\"$")
    public void user_navigates_to_url(String url) {
        loginPage.navigateToUrl(url);
    }

    @When("^User clicks on Login button$")
    public void user_clicks_on_login_button() {
        loginPage.clickFirstLoginButton();
    }

    @When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("^User clicks on Login button again$")
    public void user_clicks_on_login_button_again() {
        loginPage.clickSecondLoginButton();
    }
}
