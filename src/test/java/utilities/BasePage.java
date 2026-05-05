package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    private final static int defaultTimeout = 5;
    private final int timeOut;

    public BasePage(int timeOut){
        this.timeOut = timeOut;
    }

    public BasePage(){
        this(defaultTimeout);//llamo al constructor de arriba con el default timeout
    }

    protected WebDriver getDriver(){
        return new WebDriverProvider().get();
    }

    protected void waitPage(By locator, String pageName){
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(this.timeOut));

            Logs.info("Esperando que la pagina %s cargue", pageName);
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(locator));
            Logs.info("%s se ha cargado satiscatoriamente", pageName);

    }

    protected WebElement find(By locator){
        return getDriver().findElement(locator);
    }

    protected void waitElement(By locator, String pageName){
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(this.timeOut));
        Logs.info("Esperando a que el elemento se cargue para la pagina %s", pageName);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(locator));
        Logs.info("el locator para la pagina %s se ha cargado correctamente", pageName);

    }

    protected void waitForAlertAccept(){
        final var wait = new WebDriverWait(getDriver(),Duration.ofSeconds(this.timeOut));
        Logs.info("Obteniendo el alert %s");
        final var alert = (Alert)  wait.until(ExpectedConditions.alertIsPresent());

        Logs.info("Haciendo click en aceptar");
        alert.accept();
    }

    protected Select selectElement(By locator){
        final var selectElement = getDriver().findElement(locator);
        return new Select(selectElement);

    }

    protected List<WebElement> findAll(By locator){
        return getDriver().findElements(locator);
    }

    protected Actions action(By locator){
        WebElement element = getDriver().findElement(locator);
        return new Actions(getDriver())
                .scrollToElement(element)
                .pause(1000);
    }


    public abstract void waitPageToLoad(); //esperar que cargue la pagina
    public abstract void verifyPage(); //verificar la UI de la pagina


}
