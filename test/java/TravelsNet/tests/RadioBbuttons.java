import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioBbuttons {
    @Test
    public void ChooseRadioButtons() throws InterruptedException {
        String drivePath = "C:\\Users\\user\\IdeaProjects\\kursselenium2\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", drivePath);
        WebDriver driver = new ChromeDriver();

        driver.get("https://antycaptcha.amberteam.pl:5443/exercises/exercise4?seed=a22a421d-57bc-4149-8a42-ccdf6e5e9643");

        WebElement group0 = driver.findElement(By.xpath("//input[@value='v00']"));
        group0.click();
        WebElement group1 = driver.findElement(By.xpath("//input[@value='v61']"));
        group1.click();
        WebElement group2 = driver.findElement(By.xpath("//input[@value='v22']"));
        group2.click();
        WebElement group3 = driver.findElement(By.xpath("//input[@value='v13']"));
        group3.click();
        Thread.sleep(5000);
        //create variable for button Check solution
        WebElement solution = driver.findElement(By.id("solution"));

        //click button Check solution
        solution.click();




    }

}
