package stepDefs;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.android.PreferenceMainPage;
import pages.android.SwitchPage;
import utilities.Driver;

public class SwitchStepDefs {
    PreferenceMainPage preferenceMainPage = new PreferenceMainPage();
    SwitchPage switchPage = new SwitchPage();
    TouchAction touchAction = new TouchAction(Driver.getAppiumDriver());

    @When("kullanici Switch tiklasin")
    public void kullanici_switch_tiklasin() {
        preferenceMainPage.presswtich.click();

    }

    @When("ilk switch butonu acik olmali")
    public void ilk_switch_butonu_acik_olmali() {
        if(switchPage.firstswitch.getAttribute("checked").equals("false")) {
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(switchPage.firstswitch))).perform();
        }


    }

    @Then("ilk switch butonunu acik oldugunu onayla")
    public void ilk_switch_butonunu_acik_oldugunu_onayla() {
        Assert.assertEquals(switchPage.firstswitch.getText(), "ON");
    }
    @And("ilk switch butonu kapali olmali")
    public void ilkSwitchButonuKapaliOlmali() {
        if(switchPage.firstswitch.getText().equals("ON")){
           touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(switchPage.firstswitch))).perform();
        }
    }

    @Then("ilk switch buttonunun kapali oldugunu onaylayin")
    public void ilkSwitchButtonununKapaliOldugunuOnaylayin() {
        Assert.assertEquals(switchPage.firstswitch.getText(), "OFF");
    }

    @And("ikinci swtich butonu acik olmali")
    public void ikinciSwtichButonuAcikOlmali() {
        if(switchPage.secondSwitchButton.getText().equals("NO")){
            touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(switchPage.secondSwitchButton))).perform();
        }
    }

    @Then("ikinci swtich butonunun acik oldugunu onaylayin")
    public void ikinciSwtichButonununAcikOldugunuOnaylayin() {
        Assert.assertEquals(switchPage.secondSwitchButton.getText(), "YES");
    }
}
