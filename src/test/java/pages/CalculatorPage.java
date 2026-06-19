package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalculatorPage extends BasePage{

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    private static final By NUMBER_ONE_INPUT = By.name("number1");
    private static final By NUMBER_TWO_INPUT = By.name("number2");
    private static final By CALCULATE_BTN = By.cssSelector(".btn-calculate");
    private static final By CALCULATIONS_BTN = By.xpath("//button[normalize-space()='Calculations']");
    private static final By EDIT_BTN = By.cssSelector("a[href='/update?id=5']");
    private static final By UPDATE_BTN = By.cssSelector(".btn-update");
    private static final By DELETE_BTN = By.cssSelector("a[href='/delete?id=11']");

    public void calculate(String numberOne, String numberTwo){
        wait.until(ExpectedConditions.visibilityOfElementLocated(NUMBER_ONE_INPUT));
        driver.findElement(NUMBER_ONE_INPUT).click();
        driver.findElement(NUMBER_ONE_INPUT).sendKeys(numberOne);
        driver.findElement(NUMBER_TWO_INPUT).click();
        driver.findElement(NUMBER_TWO_INPUT).sendKeys(numberTwo);
        driver.findElement(CALCULATE_BTN).click();
    }

    public void clickCalculations(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CALCULATIONS_BTN));
        driver.findElement(CALCULATIONS_BTN).click();
    }

    public void edit(String numberOne){
        wait.until(ExpectedConditions.visibilityOfElementLocated(EDIT_BTN));
        driver.findElement(EDIT_BTN).click();
        driver.findElement(NUMBER_ONE_INPUT).click();
        driver.findElement(NUMBER_ONE_INPUT).clear();
        driver.findElement(NUMBER_ONE_INPUT).sendKeys(numberOne);
        driver.findElement(UPDATE_BTN).click();
    }

    public void delete(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(DELETE_BTN));
        driver.findElement(DELETE_BTN).click();
    }

    public void acceptAlert(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }
}
