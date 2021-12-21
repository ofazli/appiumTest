package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.android.ApiDemosMainPage;
import pages.android.ApiDemosPage;
import pages.android.PreferenceDependenciesPage;
import pages.android.PreferenceMainPage;
import utilities.Driver;

public class ApiDemosDefs {
    ApiDemosMainPage apiDemosMainPage = new ApiDemosMainPage();
    ApiDemosPage apiDemosPage = new ApiDemosPage();
    PreferenceMainPage preferenceMainPage = new PreferenceMainPage();
    PreferenceDependenciesPage preferenceDependenciesPage = new PreferenceDependenciesPage();

    @Given("open app on the phone")
    public void openAppOnThePhone() {
        Driver.getAppiumDriver();
    }

    @And("click API Demos button")
    public void clickAPIDemosButton() {
        apiDemosMainPage.apiDemos.click();

    }

    @And("click Preference button")
    public void clickPreferenceButton() {
        apiDemosPage.preference.click();
    }

    @And("click Preference depedencies button")
    public void clickPreferenceDepedenciesButton() {
        preferenceMainPage.preferenceDependencies.click();
    }

    @And("click checkbox icon")
    public void clickCheckboxIcon() {
        if (preferenceDependenciesPage.checkBox.getAttribute("checked").equals("false")){
            preferenceDependenciesPage.checkBox.click();
        }else if(preferenceDependenciesPage.checkBox.getAttribute("checked").equals("true")) {
              preferenceDependenciesPage.checkBox.click();
        }

    }

    @Then("check wifi settings is activate.")
    public void checkWifiSettingsIsActivate() {
        String actualResult = preferenceDependenciesPage.checkBox.getAttribute("enabled");
        String excualResult = "true";
        Assert.assertEquals(actualResult, excualResult);
    }

    @And("close app")
    public void closeApp() {
        Driver.quitAppiumDriver();
    }
}
