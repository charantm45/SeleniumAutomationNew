
package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By userNameTextBox = By.name("username");
    private By passwordTextBox = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void enterUsername(String username) {

        WebElement user = wait.until(
            ExpectedConditions.visibilityOfElementLocated(userNameTextBox));

        user.clear();
        user.sendKeys(username);
    }

    public void enterPassword(String password) {

        WebElement pass = wait.until(
            ExpectedConditions.visibilityOfElementLocated(passwordTextBox));

        pass.clear();
        pass.sendKeys(password);
    }

    public void clickLogin() {

        WebElement login = wait.until(
            ExpectedConditions.elementToBeClickable(loginButton));

        login.click();
    }
}
