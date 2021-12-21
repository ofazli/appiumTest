package stepDefs;

import com.sun.glass.ui.TouchInputSupport;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import pages.android.DataWidgetsPage;
import pages.android.InlinePage;
import pages.android.ViewPage;
import utilities.Driver;

public class SwipeStepDefs {
    ViewPage viewPage = new ViewPage();
    DataWidgetsPage dataWidgetsPage = new DataWidgetsPage();
    TouchAction touchAction = new TouchAction(Driver.getAppiumDriver());
    InlinePage inlinePage = new InlinePage();

    @When("kullanici Data Widgets tiklasin")
    public void kullaniciDataWidgetsTiklasin() {
        viewPage.dateWidgets.click();
    }

    @When("kullanici Inline tiklasin")
    public void kullaniciInlineTiklasin() {
        dataWidgetsPage.inline.click();
    }

    @And("kullanici {int} a kaydirsin")
    public void kullaniciAKaydirsin(int arg0) {
        touchAction.longPress(ElementOption.element(inlinePage.num12)).
                moveTo(ElementOption.element(inlinePage.num9)).release().perform();
    }

    @Then("kullanici {int} ten {int} e kaydirsin")
    public void kullaniciTenEKaydirsin(int arg0, int arg1) {
        touchAction.longPress(ElementOption.element(inlinePage.num15)).
                moveTo(ElementOption.element(inlinePage.num45)).release().perform();
    }
}
