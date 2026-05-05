package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.YourInformationPage;
import utilities.CommonFlows;

public class YourInformationStepDefinitions {
    private final CommonFlows commonFlows = new CommonFlows();
    private final YourInformationPage yourInformationPage = new YourInformationPage();

    @Given("El usuario navega a la pagina del Your Information")
    public void goToYourInformationPage() {
        commonFlows.goYourInformationPage();
    }

    @When("El usuario escribe el nombre {string}, el apellido {string}, el zipcode {string} y presiona continue")
    public void fillUserInfo(String name, String lastname, String zipcode ) {
        yourInformationPage.fillData(name, lastname, zipcode);
    }

    @Then("El mensaje de error {string} debe aparecer")
    public void verifyErrorMessage(String message) {
        yourInformationPage.verifyErrorMessage(message);
    }

}
