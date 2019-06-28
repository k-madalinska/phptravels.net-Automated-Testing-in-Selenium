package TravelsNet.tests;

import TravelsNet.PageObject.HomePage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class searchHotelTest extends TestOnChrome {

    @Test
    //methods test
    public void  searchHotelTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.get("https://www.phptravels.net/");

        driver.get(" http://www.kurs-selenium.pl/demo/");
        //I use object the class HomePage using constructor
        HomePage homePage = new HomePage(driver);
        //I initializaed the method - sendkeystoCityInput with parametr - city name
        homePage.setCityHotel("Dubai");
        homePage.setDateRange("23/12/2019", "30/12/2019");



    }
}
