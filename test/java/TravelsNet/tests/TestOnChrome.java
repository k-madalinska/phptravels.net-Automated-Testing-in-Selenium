package TravelsNet.tests;

//klasa bazowa

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class TestOnChrome {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.out.println("Before test");
        String drivePath = "C:\\Users\\user\\IdeaProjects\\kursselenium2\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", drivePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("C://Users//user/Desktop//Test.html");
    }

    @AfterTest
//    po ponwyzszym tescie wyskakuje blad i okno sie same nie zamyka, rozwiazanie:
    public void tearDown() {
        System.out.println("Wykonuje sie po tescie ");
        driver.quit();
    }

}
