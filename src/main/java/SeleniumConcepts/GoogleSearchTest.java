package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hns\\Downloads\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); //Launch chrome

        driver.manage().window().maximize(); //Maximize window
        driver.manage().deleteAllCookies(); //Delete all the cookies

//        Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://www.google.com"); //enter URL

        driver.findElement(By.id("lst-ib")).sendKeys("testing");

        //Use descendant to travers to child element 

        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));
        System.out.println("Total number of suggestions are ======>>>> " + list.size());

        for (WebElement element : list
        ) {
            System.out.println(element.getText());
            if (element.getText().equals("testing life cycle")) {
                element.click();
                break;
            }
        }

    }
}
