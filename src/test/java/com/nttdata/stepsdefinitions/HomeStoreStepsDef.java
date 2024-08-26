package com.nttdata.stepsdefinitions;

import com.nttdata.steps.HomeStoreSteps;
import com.nttdata.steps.LoginStoreSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;


public class HomeStoreStepsDef {

    private WebDriver driver;
    private HomeStoreSteps homeStoreSteps;

    @And("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        driver = getDriver();
        homeStoreSteps = new HomeStoreSteps(driver);
        homeStoreSteps.navegarCategoria(categoria, subcategoria);
        screenShot();
    }


    @And("agrego {string} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(String cantidad) {
        homeStoreSteps = new HomeStoreSteps(driver);
        homeStoreSteps.clickEnPrimerProducto();
        homeStoreSteps.agregarAlCarrito(cantidad);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        homeStoreSteps = new HomeStoreSteps(driver);
        homeStoreSteps.validarPopup();
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        homeStoreSteps = new HomeStoreSteps(driver);
        homeStoreSteps.validarMontoTotal();
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        homeStoreSteps = new HomeStoreSteps(driver);
        homeStoreSteps.finalizarCompra();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        homeStoreSteps = new HomeStoreSteps(driver);
        homeStoreSteps.validarTituloCarrito("Shopping Cart");
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        homeStoreSteps = new HomeStoreSteps(driver);
        homeStoreSteps.validarCalculoPrecios();
        screenShot();
    }
}
