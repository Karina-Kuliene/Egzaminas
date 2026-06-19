package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    private static final By REGISTER_BTN = By.cssSelector(".btn-register");
    private static final By USERNAME_INPUT = By.name("username");
    private static final By EMAIL_INPUT = By.name("email");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By CONFIRM_PASSWORD = By.name("passwordConfirm");
    private static final By SUBMIT_BTN = By.cssSelector(".btn-login");


    public void clickRegisterBtn(){
        driver.findElement(REGISTER_BTN).click();
    }

    public void register(String name, String email, String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_INPUT));
        driver.findElement(USERNAME_INPUT).click();
        driver.findElement(USERNAME_INPUT).sendKeys(name);
        driver.findElement(EMAIL_INPUT).click();
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(CONFIRM_PASSWORD).click();
        driver.findElement(CONFIRM_PASSWORD).sendKeys(password);
        driver.findElement(SUBMIT_BTN).click();
    }

    public void login(String name, String password){
        driver.findElement(USERNAME_INPUT).click();
        driver.findElement(USERNAME_INPUT).sendKeys(name);
        driver.findElement(PASSWORD_INPUT).click();
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(SUBMIT_BTN).click();
    }
}
