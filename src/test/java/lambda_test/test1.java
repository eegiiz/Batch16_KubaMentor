package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;


public class test1 {


    @Test()
    public void test(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");
        WebElement InputForm = driver.findElement(By.xpath("//a[contains(text(),'Input Form Submit')]")) ;
        InputForm.click();
        WebElement name = driver.findElement(By.xpath("//input[@id='name']"));
        name.sendKeys("enky");
        WebElement email= driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("temugen123@yahoo.com");
        WebElement passport = driver.findElement(By.xpath("//input[@type='password']"));
        passport.sendKeys("123456");
        WebElement company = driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("techtorial");
        WebElement website = driver.findElement(By.xpath("//input[@id='websitename']"));
        website.sendKeys("https://www.lambdatest.com/selenium-playground");
        WebElement country = driver.findElement(By.xpath("//option[contains(text(),'Nigeria')]"));
        company.sendKeys("Nigeria");
        WebElement city = driver.findElement(By.xpath("//input[@id='inputCity']"));
        city.sendKeys("chicago");
        WebElement address1 = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        city.sendKeys("123 devon ave");
        WebElement address2 = driver.findElement(By.xpath("//input[@id='inputAddress2']"));
        city.sendKeys("123 devon ave");
        WebElement state = driver.findElement(By.xpath("//input[@id='inputState']"));
        city.sendKeys("illinois");
        WebElement zip = driver.findElement(By.xpath("/input[@id='inputZip']"));
        city.sendKeys("60018");
        WebElement submit = driver.findElement(By.xpath("/input[@id='inputZip']"));
        city.sendKeys("60018");
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();


    }

}
