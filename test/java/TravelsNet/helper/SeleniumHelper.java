package TravelsNet.helper;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

//all methods that I use in every tests
public class SeleniumHelper {
// Replacing Thread.sleep () on Wait

//create field where we could assign driver
    private WebDriver driver;

    //use Constructor SeleniumHelper
    public SeleniumHelper(WebDriver driver) {
        //assign field from constructor in class driver, which will be deliver in constructor
        this.driver = driver;
    }

    //method that waits to our Element, when it will be visibility, set the FluentWait, TimeOut -how Exception will be ignoring, how often will be checked the condition
    public void waitForElementToBeDesplayed(By locator) {

//		public void waitForElementToBeDesplayed(WebDriver driver, By locator) { - driver is in the bellow constructor
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //bellow we can use helper with locator but down by WebElement
    public void waitForElementToBeDesplayed(WebElement element) {
//		public void waitForElementToBeDesplayed(WebDriver driver, By locator) { - driver is in the bellow constructor
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }



    public void waitForLisOfWebElements(List<WebElement> elementList) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(1000))
                .ignoring(NoSuchElementException.class);
        wait.until(driver1 ->
        elementList.size()>0);
    }
}
