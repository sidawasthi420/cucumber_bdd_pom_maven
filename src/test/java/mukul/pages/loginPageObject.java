package mukul.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mukul.context.TestContext;

public class loginPageObject {

    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "submit")
    private WebElement submit;

    public loginPageObject(TestContext context) {
        PageFactory.initElements(context.getDriver(), this);
        driver = context.getDriver();
    }

    public void enterURL(String url) {
        driver.get(url);
    }

    public void enterUsername(String user) {
        username.sendKeys(user);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clkLoginbtn() {
        submit.click();
    }
    
}