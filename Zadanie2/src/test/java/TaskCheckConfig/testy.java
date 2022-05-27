package TaskCheckConfig;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testy {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        // ustawiamy systemowe property aby móć skorzystać z odpowiedniego drivera - tutaj akurat jest chrome driver

        WebDriver driver = new ChromeDriver(); // tworzymy obiekt ChromeDriver
        driver.manage().window().maximize(); // maksymalizujemy okno przeglądarki

        driver.get("https://hotel-testlab.coderslab.pl/en/");

        WebElement hotelLocationInput = driver.findElement(By.id("hotel_location"));
        WebElement searchRoomButton = driver.findElement(By.id("search_room_submit"));
        WebElement newsletterInput = driver.findElement(By.id("newsletter-input"));

        hotelLocationInput.clear();
        hotelLocationInput.sendKeys("Warsaw");
        newsletterInput.clear();
        newsletterInput.sendKeys("test@test.com");

    }
}

