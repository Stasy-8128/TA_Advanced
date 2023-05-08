import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.DashboardPage;
import pages.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {
    static Logger log = LogManager.getLogger(LoginTest.class);
    WebDriver driver;
    @BeforeEach
    void setup() {
        log.info("BeforeAll driver setup start");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        log.info("BeforeAll driver setup complete");

    }

    @Test
    void loginTest() {
        log.info("Login Test - start");
        driver.get("https://rp.epam.com/");
        log.info("Login Test - opened login page");
        LoginPage loginPage = new LoginPage(driver);
        log.info("Login Test - log in with credentials");
        DashboardPage dashboardPage = loginPage.login("anastasiia_personal","123456");
        log.info("Login Test - verify the next page");
        assertThat(dashboardPage.isDashboardTitlePresent()).isTrue();
    }

    @AfterEach
    void teardown() {
        log.info("Quit driver");
        driver.quit();
    }

}
