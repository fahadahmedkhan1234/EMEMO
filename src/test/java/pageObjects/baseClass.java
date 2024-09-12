package pageObjects;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;
//import static com.sun.tools.internal.ws.wsdl.parser.Util.fail;

public class baseClass {
    public static WebDriver driver;
    public final static int TIMEOUT = 500;
    public final static int PAGE_LOAD_TIMEOUT = 500;
    public baseClass() {
        PageFactory.initElements(driver, this);
    }

    //////////////// WAIT ////////////////
    public void waitForElement(WebElement element){
        try{
            WebDriverWait driverWait= (new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)));
            driverWait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e){
            fail("Timeout to wait for element: "+ element);
        }
    }

    public static void waitForPageToLoad() {
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //////////////// CLICK ////////////////
    public void click(WebElement element){
        element.click();
        waitForPageToLoad();
    }

    //////////////// INPUT ////////////////
    public void enter(WebElement element, String value){
        waitForElement(element);
        element.sendKeys(value);
    }

    //////////////// ALERTS ////////////////
    public void Alert(){
        driver.switchTo().alert().accept();
    }

    public void Accept_Alert(){
        int count = 2;
        while (count > 0){
            Alert alert = driver.switchTo().alert();
            alert.accept();

            count--;
        }
    }

}
