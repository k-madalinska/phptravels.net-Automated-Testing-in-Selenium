package TravelsNet.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchCityInput;

    //methods
    // creating constructor and in them I use method PageFactory.initElements (to use searchSpan and searchCityInput)
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }



    //put the name of the city
    public void sendkeystoCityInput (String cityName) throws InterruptedException {
        searchSpan.click();
        searchCityInput.sendKeys(cityName);
        Thread.sleep(5000);
        searchCityInput.sendKeys(Keys.ENTER);








    }
}
