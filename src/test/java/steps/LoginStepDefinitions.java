package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.CommonFlows;

public class LoginStepDefinitions {

    private final CommonFlows commonFlows = new CommonFlows();
    private final LoginPage loginPage = new LoginPage();


    @Given("El usuario navega a la pagina del login")
    public void goToLoginPage() {
        commonFlows.goToLoginPage();
    }

    @When("El usuario escribe el username {string} con el password {string} y presiona el boton de login")
    public void fillLoginForm(String username, String password) {
        loginPage.fillLogin(username, password);
    }

    @Then("Debe aparecer un mensaje de error indicando {string}")
    public void verifyErrorMessage(String errorMessage) {
        loginPage.verifyErrorMessage(errorMessage);
    }

    @Then("El usuario verifica que la UI de la pagina de login sea correcta")
    public void verifyUILogin() {
        loginPage.verifyPage();
    }
}
