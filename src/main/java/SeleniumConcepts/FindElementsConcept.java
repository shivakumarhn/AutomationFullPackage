package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class FindElementsConcept {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hns\\Downloads\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); //Launch chrome

        driver.manage().window().maximize(); //Maximize window
        driver.manage().deleteAllCookies(); //Delete all the cookies

       /* Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); */

        driver.get("http://www.half.ebay.com"); //enter URL

      /* 1. Get the total count of links on the page
       2. Get the text of each links on the page */

        List<WebElement> linksList = driver.findElements(By.tagName("a"));

//        Size of linksList
        System.out.println("Total number of links count " + linksList.size());

        /* Iterating using foreach loop
        for (WebElement element : linksList) {
           String linkText= element.getText();
            System.out.println(linkText);
        } */

       /* Iterating using Iterator method
       Iterator<WebElement> itr = linksList.iterator();
        while (itr.hasNext()) {
            WebElement element = itr.next();
            System.out.println(element.getText());
        }*/

        /*Iterating using Iterator method
        for (int i = 0; i < linksList.size(); i++) {
            System.out.println(linksList.get(i).getText());
        }*/
    }
}
