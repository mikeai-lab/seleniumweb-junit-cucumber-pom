package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.MenuBurgerPage;
import utilities.CommonFlows;

public class BurgerMenuStepDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final MenuBurgerPage menuBurgerPage = new MenuBurgerPage();
    private final LoginPage loginPage = new LoginPage();


    @Given("El usuario entra logueado y abre el burger menu")
    public void openBurgerMenu() {
        commonFlows.openBurgerMenu();
    }

    @When("El usuario hace click en la opcion de logout")
    public void clickLogoutOption() {
        menuBurgerPage.clickLogout();
    }

    @Then("La aplicacion redirige a la pagina de Login")
    public void verifyNavigatesLoginPage() {
        loginPage.waitPageToLoad();
        loginPage.verifyPage();
    }

    @Then("El usuario verifica que la opcion de About tenga el link correcto de {string}")
    public void verifyAboutLink(String url) {
        menuBurgerPage.verifyAboutLink(url);
    }
}
