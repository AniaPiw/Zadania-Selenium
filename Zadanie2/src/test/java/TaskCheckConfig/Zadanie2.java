package TaskCheckConfig;

import org.apache.maven.shared.utils.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

import static java.lang.System.out;

public class Zadanie2 {

    @Test
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");

        WebElement logInButton = driver.findElement(
                By.cssSelector("a[title='Log in to your customer account'] span[class='hidden-sm-down']"));
        logInButton.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement signInButton = driver.findElement(By.id("submit-login"));

        //emailInput.clear();
        emailInput.sendKeys("fojitswppurxjijdbh@kvhrw.com");
        //passwordInput.clear();
        passwordInput.sendKeys("KawazMlekiem");
        signInButton.click();

        WebElement clothesButton = driver.findElement(
                By.xpath("//a[normalize-space()='Clothes']"));
        clothesButton.click();
        WebElement sweaterButton = driver.findElement(
                By.xpath("//a[normalize-space()='Hummingbird printed sweater']"));
        sweaterButton.click();

        WebElement selectSize = driver.findElement(By.xpath("//select[@id='group_1']"));
        Select size = new Select(selectSize);
        size.selectByIndex(1);
        WebElement selectQuantity = driver.findElement(By.name("qty"));
        selectQuantity.clear();
        selectQuantity.sendKeys("5");

        WebElement addToChartButton = driver.findElement(
                By.xpath("//button[@class='btn btn-primary add-to-cart']"));
        addToChartButton.click();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=cart&action=show");
        
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=order");

        WebElement confirmButton = driver.findElement(By.name("confirm-addresses"));
        confirmButton.click();

        driver.findElement(By.xpath("//button[@name='confirmDeliveryOption']")).click();
        WebElement payByCheckButton = driver.findElement(By.cssSelector("#payment-option-1"));
        payByCheckButton.click();

        driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")).click();
        WebElement orderButton = driver.findElement(
                By.xpath("//button[normalize-space()='Order with an obligation to pay']"));
        orderButton.click();

        TakesScreenshot scrShot = (TakesScreenshot) driver;
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("src/test/resources/screenshot.png"));

    }
}

