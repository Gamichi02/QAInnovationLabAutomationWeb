package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginStoreSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class LoginStoreStepsDef {

    private WebDriver driver;
    private LoginStoreSteps loginStoreSteps;


    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @When("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        loginStoreSteps = new LoginStoreSteps(driver);
        loginStoreSteps.clickSignIn();
        loginStoreSteps.typeUser(user);
        loginStoreSteps.typePassword(password);
        screenShot();
        loginStoreSteps.login();
        screenShot();
        loginStoreSteps.validarAutenticacion();
    }
}
