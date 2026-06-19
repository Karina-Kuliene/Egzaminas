package tests;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.CalculatorPage;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest extends BaseTest{

    @Test
    void calculateSuccessful(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.login("Jonas", "Password1");
        calculatorPage.calculate("1", "2");

        wait.until(ExpectedConditions.titleIs("Calculate"));
        assertEquals("Calculate", driver.getTitle());
    }

    @Test
    void calculateUnsuccessful(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.login("Jonas", "Password1");
        calculatorPage.calculate("", "");

        assertEquals("Calculator", driver.getTitle());
    }

//    @Test
//    void searchSuccessful(){
//        CalculatorPage calculatorPage = new CalculatorPage(driver);
//        RegistrationPage registrationPage = new RegistrationPage(driver);
//        registrationPage.login("Jonas", "Password1");
//        calculatorPage.clickCalculations();
//    }

    @Test
    void editSuccessful(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.login("Jonas", "Password1");
        calculatorPage.clickCalculations();
        calculatorPage.edit("5");

        wait.until(ExpectedConditions.textToBe(By.xpath("//tr[.//b[text()='First number:']]//td[2]"), "5"));
        assertEquals("5", driver.findElement(By.xpath("//tr[.//b[text()='First number:']]//td[2]")).getText());
    }

    @Test
    void editUnsuccessful(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.login("Jonas", "Password1");
        calculatorPage.clickCalculations();
        calculatorPage.edit("");

        assertEquals("", driver.findElement(By.name("number1")).getText());
    }

    @Test
    void deleteSuccessful(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.login("Jonas", "Password1");
        calculatorPage.clickCalculations();
        calculatorPage.delete();
        calculatorPage.acceptAlert();

        assertThrows(NoAlertPresentException.class, () -> driver.switchTo().alert());
    }

    @Test
    void deleteUnsuccessful(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.login("Jonas", "Password1");
        calculatorPage.clickCalculations();
        calculatorPage.delete();

        assertDoesNotThrow(() -> driver.switchTo().alert());
    }
}
