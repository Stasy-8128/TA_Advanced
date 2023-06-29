package core.pages.implementations;

import core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DashboardPage extends BasePage{

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDashboardTitlePresent (){
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
        return driver.findElement(By.xpath("//span[@title='All Dashboards']")).isDisplayed();
    }
}
