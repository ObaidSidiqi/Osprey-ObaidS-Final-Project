package tek.tdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;



public class BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);


    private static WebDriver driver;

    private Properties properties;

//Read Property File In Constructor of BaseSetup Class.
    public BaseSetup(){
        try {
            //File Path
            String filePath = System.getProperty("user.dir")
                    + "/src/test/resources/config/application-config.properties";
            LOGGER.info("Configuration File path"+filePath);
            File propertyFile = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(propertyFile);
            properties = new Properties();
            properties.load(fileInputStream);

        }catch (IOException ex ){
            throw new RuntimeException("Config file is not accessible" + ex.getMessage());
        }

    }
    private String getProperty(String key){
        LOGGER.debug("Retrieving property for key"+key);
        String property = this.properties.getProperty(key);
        LOGGER.debug("property Value");
        return property;
    }
    public void openBrowser(){

        String retailUrl = this.properties.getProperty("ui.url");
        String browserType = this.properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(this.properties.getProperty("ui.isHeadless"));

        //Cross Browsing Setup.
        switch (browserType) {
            case "chrome" :
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) chromeOptions.addArguments("--headless");
                driver = new ChromeDriver(chromeOptions);
            break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if(isHeadless) edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
            break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
            break;
            default: throw new RuntimeException("Wrong Browser Type");

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(retailUrl);

    }
    public void quitBrowser(){
        LOGGER.debug("close browser");
        if (driver !=null)
            driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
