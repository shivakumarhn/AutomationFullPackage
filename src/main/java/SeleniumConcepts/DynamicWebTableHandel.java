package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Method;


public class DynamicWebTableHandel {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\hns\\Downloads\\chromedriver.exe");

        WebDriver driver = new ChromeDriver(); //Launch chrome

        driver.manage().window().maximize(); //Maximize window
        driver.manage().deleteAllCookies(); //Delete all the cookies

       /* Dynamic wait
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); */

        driver.get("https://www.freecrm.com"); //enter URL
        driver.findElement(By.name("username")).sendKeys("naveenk");
        driver.findElement(By.name("password")).sendKeys("test@123");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.switchTo().frame("mainpanel");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[contains(text(),'contacts')]"));

        //*[@id='vContactsForm']/table/tbody/tr[4]/td[2]/a
        //*[@id='vContactsForm']/table/tbody/tr[5]/td[2]/a
        //*[@id='vContactsForm']/table/tbody/tr[6]/td[2]/a
        //*[@id='vContactsForm']/table/tbody/tr[7]/td[2]/a

//        Method-1 : Using for loop

        String before_xpath = "//*[@id='vContactsForm']/table/tbody/tr[";
        String after_xpath = "]/td[2]/a";

        for (int i = 4; i <= 7; i++) {
            String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
            System.out.println(name);

            if (name.equals("test2 test2")) {
                driver.findElement(By.xpath(before_xpath + i + after_xpath)).click();
            }

        }

//        Method-2 : Using custom xPath
//        1.Using Parent and preceding-sibling (previous) .

        driver.findElement(By.xpath("//a[contains(text(),'test2 test2')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'ui uii')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();


    }

}
