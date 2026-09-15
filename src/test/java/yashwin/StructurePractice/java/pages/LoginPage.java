package yashwin.StructurePractice.java.pages;

import yashwin.StructurePractice.java.context.TestContext;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private TestContext testContext;
    private WebDriverWait wait;

    @FindBy(className = "btn-primary")
    private WebElement firstLoginButton;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(className = "login-btn")
    private WebElement secondLoginButton;

    public LoginPage(TestContext testContext) {

        this.testContext = testContext;
        this.wait = testContext.getWait();

        PageFactory.initElements(testContext.getDriver(), this);
    }

    public void navigateToUrl(String url) {

        testContext.getDriver().get(url);
        wait.until(ExpectedConditions.titleIs("Shivoham Automation Expert - Consultancy Services"));
    }

    public void clickFirstLoginButton() {

        wait.until(ExpectedConditions.elementToBeClickable(firstLoginButton)).click();
    }

    public void enterUsername(String username) {

        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
    }

    public void enterPassword(String password) {

        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }

    public void clickSecondLoginButton() {

        wait.until(ExpectedConditions.elementToBeClickable(secondLoginButton)).click();
    }

    public boolean isLoginSuccessful() {

        wait.until(ExpectedConditions.titleIs("Shivoham Automation Expert - Consultancy Services - Admin Dashboard"));

        return testContext.getDriver().getTitle().equals("Shivoham Automation Expert - Consultancy Services - Admin Dashboard");
    }
}