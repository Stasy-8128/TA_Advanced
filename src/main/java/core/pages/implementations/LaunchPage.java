package core.pages.implementations;

import core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LaunchPage extends BasePage {
    public LaunchPage(WebDriver driver) {
        super(driver);
    }

    public void assertLaunchDefectType(String title) {
        waitForElementToAppear(By.xpath("//span[contains(@class,'defectTypeBlock__title') and contains(text(),'" + title + "')]"));
        assertTrue(driver.findElement(By.xpath("//span[contains(@class,'defectTypeBlock__title') and contains(text(),'" + title + "')]")).isDisplayed());
    }
}
