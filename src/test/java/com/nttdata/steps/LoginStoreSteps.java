package com.nttdata.steps;

import com.nttdata.page.StoreLoginPage;
import com.nttdata.page.StoreHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginStoreSteps {

    private WebDriver driver;
    private WebElement userInputElement;
    private WebElement passInputElement;
    //constructor
    public LoginStoreSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Hacer click en el botón Sign In de la esquina superior derecha
     */

    public void clickSignIn() {
        this.driver.findElement(StoreHomePage.butonSignIn).click();
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */

    public void typeUser(String user){
        userInputElement = driver.findElement(StoreLoginPage.userInput);
        userInputElement.sendKeys(user);
    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        passInputElement = driver.findElement(StoreLoginPage.passInput);
        passInputElement.sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login(){
        this.driver.findElement(StoreLoginPage.loginButton).click();
    }

    public void validarAutenticacion() {
        //para validar en vez de Sign In debería aparecer Sign Out
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(StoreLoginPage.signOutButton));
        }
        catch (Exception e) {
            String mensaje = "Autenticación fallida.";
            System.out.println(mensaje);
            throw new AssertionError(mensaje); // Lanzar un AssertionError para marcar el fallo
        }

    }
}
