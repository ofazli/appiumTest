package stepDefs;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.android.ApiDemosPage;
import pages.android.DragAndDropPage;
import pages.android.ViewPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class DragDropStepDefs {

    ApiDemosPage apiDemosPage = new ApiDemosPage();
    ViewPage viewPage = new ViewPage();
    DragAndDropPage dragAndDropPage = new DragAndDropPage();


    @When("kullanici Views tiklasin")
    public void kullanici_views_tiklasin() {
        apiDemosPage.views.click();

    }

    @When("kullanici drag an drop tiklasin")
    public void kullanici_drag_an_drop_tiklasin() {
        viewPage.dragAndDrop.click();

    }

    @Then("kullanici ilk noktayi alip ucuncu noktaya tasiyacak")
    public void kullanici_ilk_noktayi_alip_ucuncu_noktaya_tasiyacak() {
        TouchAction touchAction = new TouchAction(Driver.getAppiumDriver());
        touchAction.longPress(ElementOption.element(dragAndDropPage.dot1)).
                moveTo(ElementOption.element(dragAndDropPage.dot3)).release().perform();

    }

    @Then("cikan yaziyi onaylayacak")
    public void cikan_yaziyi_onaylayacak() {
        ReusableMethods.waitFor(4);
        Assert.assertTrue(dragAndDropPage.text.isDisplayed());

    }
}
