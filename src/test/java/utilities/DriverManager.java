package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverManager {
    private static final Logger log = LoggerFactory.getLogger(DriverManager.class);
    private final boolean runServer = System.getenv("JOB_NAME") !=null ;

    public void builDriver(){
        if(runServer){
            buildRemoteDriver();
        }else{
            buildlocalDriver();
        }
    }

    public void killDriver(){
        Logs.debug("Matando el driver");
        new WebDriverProvider().get().quit();
    }

    private void buildlocalDriver(){
        final var headlessMode = System.getProperty("headless") != null;
        var browserProperty = System.getProperty("browser");

        if(browserProperty == null){
            Logs.debug("Asignando default driver a CHROME");
            browserProperty = "CHROME";
        }

        final var browser = Browser.valueOf(browserProperty.toUpperCase());

        Logs.debug("Inicializando el driver: %s", browser);
        Logs.debug("headless mode? %b", headlessMode);


        final var driver = switch(browser){
            case CHROME ->{
                final var chromeOptions = new ChromeOptions();
                if(headlessMode){
                    chromeOptions.addArguments("--headless=new");
                }
                yield new ChromeDriver(chromeOptions);
            }
            case EDGE -> {
                final var edgeOptions = new EdgeOptions();
                if(headlessMode){
                    edgeOptions.addArguments("--headless=new");
                }
                yield new EdgeDriver(edgeOptions);
            }
            case FIREFOX -> {
                final var firefoxOptions = new FirefoxOptions();
                if(headlessMode){
                    firefoxOptions.addArguments("--headless");
                }
                yield new FirefoxDriver(firefoxOptions);

            }
            case SAFARI -> new SafariDriver();
        };

        Logs.debug("Maximizando Pantalla");
        driver.manage().window().maximize();

        Logs.debug("Borrando cookies");
        driver.manage().deleteAllCookies();

        Logs.debug("Asignando driver al webdriver provider");
        new WebDriverProvider().set(driver);

    }

    private void buildRemoteDriver(){
      //cuando se vea jenkins
    }

    private enum Browser{
        CHROME,
        FIREFOX,
        EDGE,
        SAFARI
    }
}
