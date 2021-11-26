package utils;

import base.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class DriverFactory
{
    public static WebDriver driver;
    public static Properties prop;
    public static String browserName;


    public static WebDriver getDriver()
    {
        prop = new Properties();
        try
        {
            FileInputStream fs = new FileInputStream("src/main/java/config/data.properties");
            prop.load(fs);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        browserName = prop.getProperty("browser");
        if(browserName.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        else if(browserName.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("Invalid browser name");
        }
        driver.manage().window().maximize();
        BasePage.initPages();

        return driver;
    }


    public static void closeDriver()
    {
        driver.quit();
    }


}
