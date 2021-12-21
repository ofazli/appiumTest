package pages.android;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;

public class DragAndDropPage {
    public DragAndDropPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAppiumDriver(), Duration.ofSeconds(15)), this);
    }
    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_1")
    public MobileElement dot1;
    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_2")
    public MobileElement dot2;
    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/drag_dot_3")
    public MobileElement dot3;
    @AndroidFindBy(id = "com.touchboarder.android.api.demos:id/drag_text")
    public MobileElement text;

    String actualDropMessage = "Dot : com.example.android.apis.view.DraggableDot{b0b82bc VFED..CL. ...P..I. 0,137-414,551 #7f1301b5 app:id/drag_dot_1}";

}
