package app.schedule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Testing extends BaseSetup{

    private final String URL = "http://develop-softserve.herokuapp.com/schedule?semester=53";
    private final String LOGIN_URL = "http://develop-softserve.herokuapp.com/login";

    @Test
    public void toLoginPageTest(){
        driver.get(URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root>div>header>nav.header-blocks.header-blocks_two>a")));

        WebElement loginButton = driver.findElement(By.cssSelector("#root>div>header>nav.header-blocks.header-blocks_two>a"));

        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("under-line")));
        WebElement enterText = driver.findElement(By.className("under-line"));

        System.out.println(enterText.getText());
    }

    @Test
    public void negativeLoginTest(){
        driver.get(LOGIN_URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root>div>div>div>form>div:nth-child(1)>div>input")));

        WebElement loginInput = driver.findElement(By.cssSelector("#root>div>div>div>form>div:nth-child(1)>div>input"));
        WebElement passInput = driver.findElement(By.cssSelector("#root>div>div>div>form>div:nth-child(2)>div>input"));

        loginInput.sendKeys("admin@gmail.com");
        passInput.sendKeys("admin");

        WebElement sendRequestButton = driver.findElement(By.cssSelector("#root>div>div>div>form>button>span.MuiButton-label"));

        sendRequestButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root>div>div>div>form>div:nth-child(1)>p")));

    }

    @Test
    public void languageTest(){
        driver.get(LOGIN_URL);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root>div>header>nav.header-blocks.header-blocks_three>div>label.MuiFormControlLabel-root.languageItem.activeLanguage")));

        WebElement engLanguage = driver.findElement(By.cssSelector("#root>div>header>nav.header-blocks.header-blocks_three>div>label.MuiFormControlLabel-root.languageItem.activeLanguage"));
        engLanguage.click();
        WebElement enHeaderText = driver.findElement(By.cssSelector("#root>div>div>div>h2"));

        Assertions.assertEquals("Login", enHeaderText.getText());


        WebElement uaLanguage = driver.findElement(By.cssSelector("#root>div>header>nav.header-blocks.header-blocks_three>div>label:nth-child(2)"));
        uaLanguage.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#root>div>header>nav.header-blocks.header-blocks_three>div>label.MuiFormControlLabel-root.languageItem.activeLanguage>img")));

        WebElement uaHeaderText = driver.findElement(By.className("#root>div>div>div>h2"));

        Assertions.assertEquals("Вхід", uaHeaderText.getText());
    }

}
