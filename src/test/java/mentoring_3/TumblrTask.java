package mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TumblrTask {
    @Test
    public void task() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.tumblr.com/");
        WebElement logIn = driver.findElement(By.xpath("//a[.='Log in']"));
        Thread.sleep(2000);
        logIn.click();
        Thread.sleep(2000);
        WebElement register = driver.findElement(By.xpath("//button[.='Continue with email']"));
        register.click();
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("eegii@gmail.com");
        email.click();
        WebElement submit1 = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
        submit1.click();
        WebElement passport = driver.findElement(By.xpath("//input[@placeholder='Set a password']"));
        passport.sendKeys("123");
        WebElement passportRepeat = driver.findElement(By.xpath("//input[@placeholder='Repeat password']"));
        passportRepeat.sendKeys("123");
        WebElement submit = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
        submit.click();
        WebElement text = driver.findElement(By.xpath("//div[@class='CkEXb']"));
        String actualText = text.getText().trim();
        String  expectedText = "The password must be at least 8 characters long";
        Assert.assertEquals(actualText,expectedText);

    }
}
