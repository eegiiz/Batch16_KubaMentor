package mentoring_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.image.Kernel;
import java.time.Duration;
import java.util.List;

public class alertPractice {
    @Test
    public void TC_05() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");
        WebElement JSAlertWindow = driver.findElement(By.xpath("//a[.='Javascript Alerts']"));
        JSAlertWindow.click();
        Thread.sleep(2000);
        WebElement JsAlert = driver.findElement(By.xpath("//p[contains(.,'JS Alert')]//button[@type='button']"));
        JsAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String actualText = alert.getText().trim();
        String expectedText = "";
        Assert.assertEquals(actualText,expectedText);
        WebElement confirmBox = driver.findElement(By.xpath("//p[contains(.,'Confirm box:')]//button[@type='button']"));
        confirmBox.click();
        Alert alert1 =driver.switchTo().alert();
        alert1.dismiss();
        WebElement promptBox =driver.findElement(By.xpath("//p[contains(.,'Prompt box:')]//button[@type='button']"));
        promptBox.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("egy");
        alert2.accept();
        String actualText1 = promptBox.getText().trim();
        String expectedText1 = "";
        Assert.assertEquals(actualText1,expectedText1);


    }
    @Test
    public void TC_06(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");
        WebElement sliders = driver.findElement(By.xpath("//a[.='Drag & Drop Sliders']"));
        sliders.click();
        List<WebElement> allInputs = driver.findElements(By.xpath("//input[@type='range']"));
        List<WebElement> allOutPut = driver.findElements(By.cssSelector("output"));
        for (int i =0 ; i < allInputs.size(); i++){
            while (!allOutPut.get(i).getText().equals("99")) {
                if (allInputs.get(i).getText().equals("99")) {
                    break;
                } else {
                    allInputs.get(i).sendKeys(Keys.ARROW_RIGHT);
                }
            }
        }




    }

}
