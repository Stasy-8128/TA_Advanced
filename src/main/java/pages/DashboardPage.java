package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardTitlePresent (){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        return driver.findElement(By.xpath("//span[@title='All Dashboards']")).isDisplayed();
    }
}
