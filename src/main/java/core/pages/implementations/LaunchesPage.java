package core.pages.implementations;

import core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LaunchesPage extends BasePage {

    @FindBy(xpath = "(//a[contains(@href,'#ta_project/launches/all/')])[1]")
    WebElement firstLaunch;

    public LaunchesPage(WebDriver driver) {
        super(driver);
    }

    public void assertLaunchElementText(String title) {
        waitForElementToAppear(By.xpath("(//*[contains(text(),'" + title + "')])[1]"));
        assertTrue(driver.findElement(By.xpath("(//*[contains(text(),'" + title + "')])[1]")).isDisplayed());
    }

    public void clickFirstLaunch() {
        firstLaunch.click();
    }

    public void dragDropPhoto() {
        WebElement From = driver.findElement(By.xpath("//*[@id='credit2']/a"));
        WebElement To = driver.findElement(By.xpath("//*[@id='bank']/li"));
        Actions act = new Actions(driver);
        act.dragAndDrop(From, To).build().perform();
    }

    public void scrollToTestElement() {
        WebElement element = driver.findElement(By.xpath("//*[@id='credit2']/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void jsClick(){
        WebElement element = driver.findElement(By.xpath("//*[@id='credit2']/a"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }
}
