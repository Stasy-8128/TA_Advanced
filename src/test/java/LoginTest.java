import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest {
    WebDriver driver;
    @BeforeTest
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(description = "Login Test")
    @Parameters({"username","password"})
    void loginTest(String username, String password) {
        driver.get("https://rp.epam.com");
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login(username,password);
        assertThat(dashboardPage.isDashboardTitlePresent()).isTrue();
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }

}
