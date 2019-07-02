package TravelsNet.PageObject;

import TravelsNet.helper.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
//    @FindBy(xpath="//div[@class='select2-input']")
    //select2-results-dept-1 select2-result select2-result-selectable
    private WebElement searchCityInput;

    @FindBy(name ="checkin")
    private WebElement checkInInput;

    @FindBy(name ="checkout")
    private WebElement checkOutInput;

    @FindBy(id ="travellersInput")
    private WebElement travellersInput;

    @FindBy(id ="adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(id ="childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath ="//button[text() = 'Search']")
    private WebElement searchButton;

    @FindBy(xpath ="//table[@class = 'bgwhite table table-striped']")
    private WebElement resultsTable ;

    @FindBy(xpath="//li[@class='select2-results-dept-1 select2-result']")
    private WebElement selectResult;

    //create field SeleniumHelper with variable, use helper with locator
    private SeleniumHelper helper;

    //use helper with WebElement
    private WebDriver driver;

    //methods

    // creating constructor and in them I use method PageFactory.initElements (to use searchSpan and searchCityInput)
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        //use helper, use Constructor
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
    }
    //put the name of the city

    public void setCityHotel (String cityName)  {
        searchSpan.click();
        searchCityInput.sendKeys(cityName);

        //use helper with locator
//        By locationLabel = By.xpath("//table[@class = 'bgwhite table table-striped']");
//        By locationLabel = By.xpath("//div[@class='select2-result-label']");
//        helper.waitForElementToBeDesplayed(locationLabel);
        //use helper with drvier
        helper.waitForElementToBeDesplayed(selectResult);
//        Thread.sleep(5000);
        searchCityInput.sendKeys(Keys.ENTER);
    }

    //methods to set the Date range - check in and out
    public void setDateRange(String checkInDate, String checkOutDate ) {
        checkInInput.sendKeys(checkInDate);
        checkOutInput.sendKeys(checkOutDate);
        checkOutInput.click();
    }

    //method for opening a modal selection of parents and childen

    public void openTravellersModal() {
        travellersInput.click();
//    	Thread.sleep(2000);
        helper.waitForElementToBeDesplayed(adultPlusBtn);
    }

    //method to add parents
    public void addAdult() {
        adultPlusBtn.click();
    }


//    method to add children
    public void addChild() {
        childPlusBtn.click();
    }

    //methods to click button Search
    public void performSearch() {
        searchButton.click();
    }

//  I collected hotel's names and checked it

    public List<String> getHotelNames() {
        List<String> hotelNames = new ArrayList<>();
//	   Thread.sleep(3000);
        helper.waitForLisOfWebElements(resultsTable.findElements(By.xpath(".//h4//b")));
        List<WebElement> hotelNameWebElements = resultsTable.findElements(By.xpath(".//h4//b"));
        for(WebElement hotelNameElement: hotelNameWebElements) {
            System.out.println(hotelNameElement.getText());
            hotelNames.add(hotelNameElement.getText());
        }
        return hotelNames;
    }


    //  I checked prices
    public void getHotelPrices() {
        List<WebElement> hotelPrices = resultsTable.findElements(By.xpath("//di[contains(@class,'price_tab')]//b"));
        hotelPrices.stream().forEach(hotelPrice ->
                System.out.println(hotelPrice.getText()));
    }
}