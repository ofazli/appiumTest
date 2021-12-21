package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,"C:/Users/orcun/IdeaProjects/com.techproedjavaproject/App/gestureTool.apk");
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), desiredCapabilities);
//        driver.findElementById("com.davemac327.gesture.tool:id/addButton").click();
//        driver.findElementByXPath("(//android.widget.Button)[2]").click();
//        driver.findElementByXPath("//*[@text='Add gesture']").click();
        driver.findElementById("com.davemac327.gesture.tool:id/testButton").click();
        Thread.sleep(1000);
        String actualTitle = driver.findElementById("android:id/title").getText();
        System.out.println(actualTitle);
        String expectedTitle = "Test a gesture";
        Assert.assertEquals(actualTitle, expectedTitle);


        /*
        lunch gestureTool app
        click test button
        verify title "Test a gesture"
        close app
         */


    }
}
