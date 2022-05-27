package TaskCheckConfig;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Zadanie1 {

    private WebDriver driver;


    @Given("user is logged in and is on address form page")
    public void logInToPresta() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl");

        WebElement logInButton = driver.findElement(By.cssSelector("a[title='Log in to your customer account'] span[class='hidden-sm-down']"));
        logInButton.click();

        WebElement emailInput = driver.findElement(By.name("email"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement signInButton = driver.findElement(By.id("submit-login"));

        emailInput.clear();
        emailInput.sendKeys("fojitswppurxjijdbh@kvhrw.com");
        passwordInput.clear();
        passwordInput.sendKeys("KawazMlekiem");
        signInButton.click();

        WebElement addressButton = driver.findElement(By.xpath("//a[normalize-space()='Addresses']"));
        addressButton.click();
        driver.findElement(By.xpath("//span[normalize-space()='Create new address']")).click();
        Thread.sleep(1000);
    }

    @And("^a keyword (.*) is entered in phone field")
    public void addPhone(String phone) {
        WebElement phoneForm = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneForm.clear();
        phoneForm.sendKeys(phone);
    }
    @And("^a keyword (.*) is entered in alias field")
    public void addAlias(String field) {
        WebElement alias = driver.findElement(By.xpath("//input[@name='alias']"));
        alias.clear();
        alias.sendKeys(field);
    }
    @And("^a keyword (.*) is entered in address field")
    public void addAddress(String keyword) {
        WebElement address1Form = driver.findElement(By.xpath("//input[@name='address1']"));
        address1Form.clear();
        address1Form.sendKeys(keyword);
    }
    @And("^a keyword (.*) is entered in zip code field")
    public void addZip(String keyword) {
        WebElement zipForm = driver.findElement(By.xpath("//input[@name='postcode']"));
        zipForm.clear();
        zipForm.sendKeys(keyword);
    }
    @And("^a keyword (.*) is entered in city field")
    public void addCity(String keyword) {
        WebElement cityForm = driver.findElement(By.xpath("//input[@name='city']"));
        cityForm.clear();
        cityForm.sendKeys(keyword);
    }
    @When("a country is chosen from country field")
    public void countryForm() {
        WebElement selectCountry = driver.findElement(By.xpath("//select[@name='id_country']"));
        Select country = new Select(selectCountry);
        country.selectByIndex(1);
    }
    @And("confirm by save button")
    public void saveAddress() {
        WebElement saveButton = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        saveButton.click();
    }
    @Then("check if data is correct")
    public void checkData() {
        String checkText = driver.findElement(By.xpath("//body//main//address[1]")).getText();

        //System.out.println(checkText);

        String[] list = checkText.split("\n");
        Assert.assertEquals(list[0], "Anna Wanna");
        Assert.assertEquals(list[1], "Diagonal");
        Assert.assertEquals(list[2], "Barcelona");
        Assert.assertEquals(list[3], "08-013");
        Assert.assertEquals(list[4], "United Kingdom");
        Assert.assertEquals(list[5], "666777888");
    }
}