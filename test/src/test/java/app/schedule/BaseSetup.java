package app.schedule;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSetup {

    protected static ChromeDriver driver;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ACER\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void close(){
        driver.quit();
    }
}
