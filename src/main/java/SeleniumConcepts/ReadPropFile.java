package SeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropFile {

    static WebDriver driver;


    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileInputStream ip = new FileInputStream("src\\main\\java\\SeleniumConcepts\\config.properties");
        prop.load(ip);
        System.out.println(prop.getProperty("name"));
        System.out.println(prop.getProperty("age"));

        String url = prop.getProperty("url");
        System.out.println(url);

        String browserName = prop.getProperty("browser");
        System.out.println(browserName);

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\hns\\Downloads\\chromedriver.exe");
            driver = new ChromeDriver(); //Launch chrome
        } else if (browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\hns\\Downloads\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equals("IE")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\hns\\Downloads\\internetexplorer.exe");
            driver = new InternetExplorerDriver();
        }

        driver.get(url);

        driver.findElement(By.xpath(prop.getProperty("firstName_xPath"))).sendKeys(prop.getProperty("firstName"));
        driver.findElement(By.xpath(prop.getProperty("lastName_xPath"))).sendKeys(prop.getProperty("lastName"));
        driver.findElement(By.xpath(prop.getProperty("email_xPath"))).sendKeys(prop.getProperty("email"));

    }
}
