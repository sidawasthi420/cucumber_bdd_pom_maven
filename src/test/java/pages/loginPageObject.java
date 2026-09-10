package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import context.TestContext;

public class loginPageObject {

    private WebDriver driver;
    
    @FindBy(className = "btn-primary")
    private WebElement initialloginBtn;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement pass_word;

    @FindBy(className = "login-btn")
    private WebElement loginBtn;

    @FindBy(className = "logout-btn")
    private WebElement logoutBtn;

    public loginPageObject(TestContext context){
        PageFactory.initElements(context.getDriver(), this);
        driver = context.getDriver();
    }

    public void enterURL(String url){
        driver.get(url);
    }

    public void clkInitLoginbtn(){
        initialloginBtn.click();
    }

    public void enterUsername(String user){
        username.sendKeys(user);
    }

    public void enterPassword(String password){
        pass_word.sendKeys(password);
    }
    
    public void clkLoginbtn(){
        loginBtn.click();
    }
    
    public void clkLogoutbtn(){
        logoutBtn.click();
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
