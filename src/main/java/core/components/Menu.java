package core.components;

import core.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Menu extends BasePage {
    @FindBy(xpath = "//*[contains(@class,'sidebar-container')]")
    private WebElement menuBar;
    @FindBy(xpath = "(//div[contains(@class,'projectSelector__show-list-icon')])[1]")
    private WebElement projectSelector;
    @FindBy(xpath = "//a[@href='#ta_project']")
    private WebElement taProjectLink;
    //@FindBy(xpath = "//*[contains(text(),'Launches')]")
    @FindBy(xpath = "//a[@href='#ta_project/launches']")
    private WebElement launchesButton;

    public Menu(WebDriver driver) {
        super(driver);
    }

    public void assertMenuAppeared() {
        waitForElementToAppear(By.xpath("//*[contains(@class,'sidebar-container')]"));
        assertTrue(menuBar.isDisplayed());
    }

    public void clickLaunchesButton() {
        launchesButton.click();
    }

    public void pickTAProject() {
        assertTrue(projectSelector.isDisplayed());
        projectSelector.click();
        taProjectLink.click();
    }
}
