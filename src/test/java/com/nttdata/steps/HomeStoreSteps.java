package com.nttdata.steps;

import com.nttdata.page.StoreHomePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


import java.time.Duration;


public class HomeStoreSteps {

    private WebDriver driver;
    private WebElement userInputElement;
    private WebElement passInputElement;
    //constructor
    public HomeStoreSteps(WebDriver driver){
        this.driver = driver;
    }

    public void navegarCategoria(String categoria, String subcategoria) {
        try {
            driver.findElement(StoreHomePage.category(categoria)).click();
            driver.findElement(StoreHomePage.subCategory(subcategoria)).click();
        } catch (Exception e) {
            // Manejar el caso donde no se encuentra el elemento
            String mensaje = "Error: No se encontró categoría o subcategoría.";
            System.out.println(mensaje);
            throw new AssertionError(mensaje);
        }
    }

    public void clickEnPrimerProducto() {
        //hacemos click en el primer producto
        driver.findElement(StoreHomePage.firstProduct).click();
    }

    public void agregarAlCarrito(String cantidad) {
        // Obtener el elemento de entrada
        WebElement inputQuantity = driver.findElement(StoreHomePage.inputQuantity);

        // Seleccionartodo el texto existente y sobrescribirlo con la nueva cantidad
        inputQuantity.sendKeys(Keys.chord(Keys.CONTROL, "a"));  // Seleccionatodo el texto
        inputQuantity.sendKeys(Keys.DELETE); // Elimina el valor actual

        // Escribir la nueva cantidad
        inputQuantity.sendKeys(cantidad);

        //hacemos click en el botón de agregar al carrito
        driver.findElement(StoreHomePage.buttonAddToCart).click();
    }

    public void validarPopup() {
        //validamos el popup, espera hasta que el popup sea visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StoreHomePage.TitleModal));
    }

    public void validarMontoTotal() {
        // Obtener el texto de los elementos
        String precioProducto = driver.findElement(StoreHomePage.precioProductoModal).getText();
        String cantidadProducto = driver.findElement(StoreHomePage.cantidadProductoModal).getText();
        String totalPrecio = driver.findElement(StoreHomePage.totalPrecioModal).getText();

        // Eliminar la moneda y reemplazar comas por puntos para la conversión
        precioProducto = formatearMoneda(precioProducto);
        totalPrecio = formatearMoneda(totalPrecio);

        // Convertir a double e int
        double precioProductoDouble = Double.parseDouble(precioProducto);
        double totalPrecioDouble = Double.parseDouble(totalPrecio);
        int cantidadProductoInt = Integer.parseInt(cantidadProducto);

        // Validar que el monto total sea igual al precio del producto por la cantidad
        Assertions.assertEquals(precioProductoDouble * cantidadProductoInt, totalPrecioDouble, 0.01);
    }

    private String formatearMoneda(String valor) {
        return valor.replace("PEN", "").replace(",", ".");
    }

    public void finalizarCompra() {
        //hacemos click en el botón de proceder al checkout
        driver.findElement(StoreHomePage.butonProceedToCheckout).click();
    }

    public void validarTituloCarrito(String tittlecarrito) {
        //validamos el título de la página
        String title = driver.findElement(StoreHomePage.titleCart).getText();
        //si el navegador está en español, el título será 'Carrito', si está en inglés será 'Shopping Cart'
        Assertions.assertTrue(tittlecarrito.equals("Carrito") || tittlecarrito.equals("Shopping Cart"),
                "El título debería ser 'Carrito' o 'Shopping Cart', pero fue: " + title);
    }

    public void validarCalculoPrecios() {
        // Obtener el texto de los elementos
        String precioProducto = driver.findElement(StoreHomePage.precioProductoCart).getText();
        String cantidadProducto = driver.findElement(StoreHomePage.cantidadProductoCart).getText();
        String totalPrecio = driver.findElement(StoreHomePage.totalPrecioCart).getText();

        // Formatear los valores
        precioProducto = formatearMoneda(precioProducto);
        totalPrecio = formatearMoneda(totalPrecio);
        cantidadProducto = formatearCantidad(cantidadProducto);

        // Convertir a double e int
        double precioProductoDouble = Double.parseDouble(precioProducto);
        double totalPrecioDouble = Double.parseDouble(totalPrecio);
        int cantidadProductoInt = Integer.parseInt(cantidadProducto);

        // Validar que el monto total sea igual al precio del producto por la cantidad
        Assertions.assertEquals(precioProductoDouble * cantidadProductoInt, totalPrecioDouble, 0.01);
    }

    // Método auxiliar para formatear el texto de la cantidad
    private String formatearCantidad(String valor) {
        return valor.replaceAll("[^0-9]", "");
        // Eliminar todo lo que no sea un número
    }
}
