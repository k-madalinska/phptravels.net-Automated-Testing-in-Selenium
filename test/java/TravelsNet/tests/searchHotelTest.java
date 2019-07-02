package TravelsNet.tests;

import TravelsNet.PageObject.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class searchHotelTest extends TestOnChrome {



    @Test
    //methods test
    public void  searchHotelTest() throws InterruptedException {

//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); remove, because now that do helper
        driver.get("https://www.phptravels.net/");
//        driver.get(" http://www.kurs-selenium.pl/demo/");

        //I use object the class HomePage using constructor
        HomePage homePage = new HomePage(driver);

        //I initializaed the method - sendkeystoCityInput with parametr - city name
        homePage.setCityHotel("Dubai");
        homePage.setDateRange("23/12/2019", "30/12/2019");
        homePage.openTravellersModal();
        homePage.addAdult();
        homePage.addChild();
        homePage.addChild();
        homePage.performSearch();

        List<String> hotelNames = homePage.getHotelNames();

//      compare the hotels name in our results with names in website
        Assert.assertEquals("Hotel Baluarte",hotelNames.get(0));
        Assert.assertEquals("monks palace",hotelNames.get(1));
        Assert.assertEquals("Rendezvous Hotels",hotelNames.get(2));
        homePage.getHotelPrices();
    }
}
