import core.components.Menu;
import core.pages.implementations.LaunchPage;
import core.pages.implementations.LaunchesPage;
import core.pages.implementations.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import utility.enums.Builds;
import utility.enums.DefectTypes;
import utility.enums.LaunchesFields;


public class LaunchesTest extends BaseTest{
    static Logger log = LogManager.getLogger(LaunchesTest.class);

    //This test checks the fields for launches
    @ParameterizedTest
    @EnumSource(LaunchesFields.class)
    void launchesTest1(LaunchesFields launch) {
        log.info("Start Test");
        getDriver().get("http://localhost:8080/ui/#login");
        log.info("Opened login page");
        LoginPage loginPage = new LoginPage(getDriver());
        log.info("Log in with credentials");
        loginPage.login("superadmin","erebus");
        log.info("Click Launches on menu");
        Menu menuBar = new Menu(getDriver());
        menuBar.assertMenuAppeared();
        menuBar.clickLaunchesButton();
        log.info("Verify Launch Text for " + launch.getState());
        LaunchesPage launches = new LaunchesPage(getDriver());
        launches.assertLaunchElementText(launch.getState());
    }

    //This test checks build numbers in the listed launches
    @ParameterizedTest
    @EnumSource(Builds.class)
    void launchesTest2(Builds build) {
        log.info("Start Test");
        getDriver().get("http://localhost:8080/ui/#login");
        log.info("Opened login page");
        LoginPage loginPage = new LoginPage(getDriver());
        log.info("Log in with credentials");
        loginPage.login("superadmin","erebus");
        log.info("Click Launches on menu");
        Menu menuBar = new Menu(getDriver());
        menuBar.assertMenuAppeared();
        menuBar.clickLaunchesButton();
        log.info("Verify Contains build " + build.getbuildNum());
        LaunchesPage launches = new LaunchesPage(getDriver());
        launches.assertLaunchElementText(build.getbuildNum());
    }

    //This test checks the defect labels on specific launch page
    @ParameterizedTest
    @EnumSource(DefectTypes.class)
    void launchesTest3(DefectTypes defectType) {
        log.info("Start Test");
        getDriver().get("http://localhost:8080/ui/#login");
        log.info("Opened login page");
        LoginPage loginPage = new LoginPage(getDriver());
        log.info("Log in with credentials");
        loginPage.login("superadmin","erebus");
        log.info("Click Launches on menu");
        Menu menuBar = new Menu(getDriver());
        menuBar.assertMenuAppeared();
        menuBar.clickLaunchesButton();
        log.info("Verify Contains build " + defectType.name());
        LaunchesPage launches = new LaunchesPage(getDriver());
        launches.clickFirstLaunch();
        LaunchPage launchPage = new LaunchPage(getDriver());
        launchPage.assertLaunchDefectType(defectType.name());
    }

}
