package bdd.steps;

import core.components.Menu;
import core.pages.implementations.LaunchPage;
import core.pages.implementations.LaunchesPage;
import core.pages.implementations.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class TestSteps {
    private WebDriver driver;
    static Logger log = LogManager.getLogger();
    @Given("^I am logged into Report Portal$")
    public void log_in() {
        getDriver().get("http://localhost:8080/ui/#login");
        log.info("Opened login page");
        LoginPage loginPage = new LoginPage(getDriver());
        log.info("Log in with credentials");
        loginPage.login("superadmin","erebus");
    }

    @When("^I have a test execution with test results$")
    public void menu_visible(){
        Menu menuBar = new Menu(getDriver());
        menuBar.assertMenuAppeared();
    }

    @When("^When I navigate to the 'Launchers' section$")
    public void clickLaunchers(){
        Menu menuBar = new Menu(getDriver());
        menuBar.clickLaunchesButton();
    }

    @Then("^Then I should see a list of available test results \"(.*)\"$")
    public void assertLaunchers(String launch){
        LaunchesPage launches = new LaunchesPage(getDriver());
        launches.assertLaunchElementText(launch);
    }

    @Then("^I should see a  build with '(.*)'$")
    public void assertBuild(String build){
        LaunchesPage launches = new LaunchesPage(getDriver());
        launches.assertLaunchElementText(build);
    }

    @When("^I navigate to 'Launcher' page$")
    public void navigateToLauncher(){
        LaunchesPage launches = new LaunchesPage(getDriver());
        launches.clickFirstLaunch();
    }

    @Then("^I should see a  defect type '(.*)'$")
    public void assertDefect(String defect){
        LaunchPage launchPage = new LaunchPage(getDriver());
        launchPage.assertLaunchDefectType(defect);
    }
    public WebDriver getDriver() {
        return driver;
    }

}
