import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardTitlePresent (){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
        return driver.findElement(By.xpath("//span[@title='All Dashboards']")).isDisplayed();
    }
}
