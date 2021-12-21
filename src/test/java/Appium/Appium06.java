package Appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06 {
    @Test
    public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AndroidEmulator");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        //driver sorunu ile karsilastigimizda cozum sekli bu sekildedir.
        desiredCapabilities.setCapability("chromedriverExecutable", "C:/Users/orcun/IdeaProjects/com.techproedjavaproject/driver/chromedriver.exe");
        desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),desiredCapabilities);
        driver.get("https://www.amazon.com");
        System.out.println("1 " + driver.getContext());
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@id=\"nav-logobar-greeting\"]").click();
        Thread.sleep(1000);

        Set contextNames = driver.getContextHandles();
        for (Object contextName : contextNames){
            System.out.println(contextName);
            Thread.sleep(3000);
            if(contextName.toString().contains("CHROMIUM")){
                driver.context((String) contextName);
                Thread.sleep(10000);
            }
        }
        System.out.println("2 " + driver.getContext());
        String actualTitle = driver.findElementByXPath("//h2").getText();
        String expectedTitle = "Welcome";
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle);

        System.out.println("3 " + driver.getContext() );
        driver.quit();
    }
}
