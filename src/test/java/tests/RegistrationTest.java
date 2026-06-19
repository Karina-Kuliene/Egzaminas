package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest extends BaseTest{

    @Test
    void registrationSuccessful(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterBtn();
        registrationPage.register("Jonas4", "jonas6@test.com", "Password1");

        wait.until(ExpectedConditions.titleIs("Login"));
        assertEquals("Login", driver.getTitle());
    }

    @Test
    void registrationUnsuccessful(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickRegisterBtn();
        registrationPage.register("", "", "");

        wait.until(ExpectedConditions.titleIs("Register"));
        assertEquals("Register", driver.getTitle());
    }

    @Test
    void loginSuccessful(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.login("Jonas", "Password1");

        assertEquals("Calculator", driver.getTitle());
    }

    @Test
    void loginUnsuccessful(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.login("Petras", "password");

        assertEquals("Invalid username or password.", driver.findElement(By.cssSelector(".error-message-login")).getText());
    }

}
