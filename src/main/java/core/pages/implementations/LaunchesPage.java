package core.pages.implementations;

import core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LaunchesPage extends BasePage {

    @FindBy(xpath = "(//a[contains(@href,'#ta_project/launches/all/')])[1]")
    WebElement firstLaunch;
    public LaunchesPage(WebDriver driver) {
        super(driver);
    }

    public void assertLaunchElementText(String title){
        waitForElementToAppear(By.xpath("(//*[contains(text(),'" + title + "')])[1]"));
        assertTrue(driver.findElement(By.xpath("(//*[contains(text(),'" + title + "')])[1]")).isDisplayed());
    }
    public void clickFirstLaunch(){
        firstLaunch.click();
    }
}
