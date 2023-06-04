package BaabarHomeWork;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class homeWork2 {
    @Test
    public void case1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println(actualTitle);
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement passport = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passport.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        Thread.sleep(3000);
        String actualGetTitle = driver.getTitle();
        String expectedGetTitle = "Web Orders";
        Assert.assertEquals(actualGetTitle,expectedGetTitle);
        System.out.println(actualGetTitle);
        WebElement header = driver.findElement(By.xpath("//h2"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader,expectedHeader);
        System.out.println(actualHeader);
    }

    @Test
    public void case2() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement passport = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passport.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement viewAllProduct = driver.findElement(By.linkText("View all products"));
        viewAllProduct.click();
        WebElement viewAllProductSelected = driver.findElement(By.xpath("//li[@class='selected']"));
        Assert.assertTrue(viewAllProductSelected.isSelected());
        System.out.println(viewAllProduct);
        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "List of Products";
        Assert.assertEquals(actualHeader, expectedHeader);
        System.out.println(actualHeader);
        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains("Products")) {
            System.out.println("Validate has Products keyword");
        } else {
            System.out.println("Validate : does not have Product keyword ");
        }
        driver.close();
    }
    @Test
    public void test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement passport = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passport.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement viewAllOrdersLink = driver.findElement(By.linkText("View all orders"));
        WebElement viewAllProductsLink = driver.findElement(By.linkText("View all products"));
        WebElement ordersLink = driver.findElement(By.linkText("Order"));
        // Validate their href values
        String expectedViewAllOrdersHref = "Default.aspx";
        String expectedViewAllProductsHref = "Products.aspx";
        String expectedOrdersHref = "Process.aspx";
        if (viewAllOrdersLink.getAttribute("href").equals(expectedViewAllOrdersHref)) {
            System.out.println("View all orders href is correct");
        } else {
            System.out.println("View all orders href is incorrect");
        }
        if (viewAllProductsLink.getAttribute("href").equals(expectedViewAllProductsHref)) {
            System.out.println("View all products href is correct");
        } else {
            System.out.println("View all products href is incorrect");
        }
        if (ordersLink.getAttribute("href").equals(expectedOrdersHref)) {
            System.out.println("Orders href is correct");
        } else {
            System.out.println("Orders href is incorrect");
        }
        driver.quit();


    }
    @Test
    public void test4() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");
        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");
        WebElement passport = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passport.sendKeys("test");
        WebElement loginButton = driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
        loginButton.click();
        Thread.sleep(2000);
        WebElement order = driver.findElement(By.linkText("Order"));
        order.click();
        WebElement product = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        BrowserUtils.selectBy(product,"ScreenSaver","value");
        WebElement quantity = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        quantity.clear();
        Thread.sleep(2000);
        quantity.sendKeys("5");
        WebElement customerName = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys("CodeFish IT School");
        WebElement street = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys("2200 E devon");
        WebElement city = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys("Des Plaines");
        WebElement state = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys("Illinois");
        WebElement zip = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zip.sendKeys("60018");
        WebElement card =driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_cardList_1"));
        if (card.isDisplayed()&&!card.isSelected()){
            card.click();
        }
        WebElement cardNumber =driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumber.sendKeys("444993876233");
        WebElement expirationDate = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("03/24");
        WebElement processButton = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        // Part 2

        WebElement textMessage = driver.findElement(By.xpath("//strong"));
        String actualMessage = BrowserUtils.getText(textMessage);
        String expectedMessage = "New order has been successfully added.";
        Thread.sleep(2000);
        Assert.assertEquals(actualMessage,expectedMessage);
        WebElement viewAllProduct = driver.findElement(By.linkText("View all orders"));
        viewAllProduct.click();
        Thread.sleep(2000);

        // Validate new order is added and all inputs are matching with new order








    }
}
