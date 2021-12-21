package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium04 {
     /*
//    lunch GestureTool app
//    click addGesture button
//    send text to name box "testing"
//    click done
//    verify testing gesture is created
     */

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/orcun/IdeaProjects/com.techproedjavaproject/App/gestureTool.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
        driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
        Thread.sleep(1000);
        driver.findElementById("com.davemac327.gesture.tool:id/gesture_name").sendKeys("testing");
        driver.findElementById("com.davemac327.gesture.tool:id/gestures_overlay").click();
        Thread.sleep(2000);
        driver.findElementById("com.davemac327.gesture.tool:id/done").click();
        Thread.sleep(1000);
        String expectedTitle = "testing";
        Thread.sleep(1000);
        String actualTitle = driver.findElementByXPath("//android.widget.TextView[@text='testing'][1]").getText();
        Assert.assertEquals(actualTitle, expectedTitle);


    }
}
