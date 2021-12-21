package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.hu.De;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium05 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:/Users/orcun/IdeaProjects/com.techproedjavaproject/App/Calculator.apk");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);

        WebElement num1 = driver.findElementById("com.google.android.calculator:id/digit_1");
        WebElement num5 = driver.findElementById("com.google.android.calculator:id/digit_5");
        WebElement carp = driver.findElementById("com.google.android.calculator:id/op_mul");
        WebElement num3 = driver.findElementById("com.google.android.calculator:id/digit_3");
        WebElement equ = driver.findElementById("com.google.android.calculator:id/eq");

        num1.click();
        num5.click();
        carp.click();
        num3.click();

        String actualTotal = driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        String expectedTotal = "45";
        Assert.assertEquals(actualTotal,expectedTotal);
        Thread.sleep(2000);
        equ.click();
        String actualEq = driver.findElementById("com.google.android.calculator:id/result_final").getText();
        String extualEq = "45";

        Assert.assertEquals(actualEq,extualEq);
        driver.quit();




    }
}
