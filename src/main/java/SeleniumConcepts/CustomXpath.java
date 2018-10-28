package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CustomXpath {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hns\\Downloads\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); //Launch chrome

        driver.manage().window().maximize(); //Maximize window
        driver.manage().deleteAllCookies(); //Delete all the cookies

//        Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

        driver.get("http://www.half.ebay.com"); //enter URL

      /*  Absolute xPath : Exact address of the element
     Example:  .//*[@id='mainContent']/div[1]/ul/li[9]/div[2]/div[1]/div[2]/ul/li[1]/a
     1. Performance issue
     2. Not reliable
     3. Can be changed at any time in future*/

       /* driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("java");
        driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("java");
        driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("Appium");*/
        driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]")).sendKeys("Iphone");

        /* id = test_123
         By.id("test_123")

        starts-with
         id = test_456
         id = test_789
         id = test_test_4657_test

        ends-with
         id = 124_test_t
         id = 345_test_t
         id = 465_test_t*/

      /*  driver.findElement(By.xpath("//input[contains(@id,'test_')]")).sendKeys("contains");
        driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("starts-with");
        driver.findElement(By.xpath("//input[ends-with(@id,'_test_t']")).sendKeys("ends with");*/

         /*For links: Custom paths
         All the links are represented by <a> html tag*/

        driver.findElement(By.xpath("//a[contains(text(),'Sell')]")).click();

    }
}
