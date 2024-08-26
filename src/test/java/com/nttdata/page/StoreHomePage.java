package com.nttdata.page;

import org.openqa.selenium.By;

public class StoreHomePage {

    //Localizadores de elementos
    public static By butonSignIn = By.xpath("//div[@class='user-info']//a");
    public static By firstProduct = By.xpath("//a[contains(@class, 'thumbnail') and contains(@class, 'product-thumbnail')]");
    public static By inputQuantity = By.id("quantity_wanted");
    public static By buttonAddToCart = By.xpath("//button[@data-button-action='add-to-cart']");
    public static By TitleModal = By.id("myModalLabel");

    //Localizadores en el modal
    public static By precioProductoModal = By.xpath("//p[@class='product-price']");
    public static By cantidadProductoModal = By.xpath("//span[@class='product-quantity']//strong");
    public static By totalPrecioModal = By.xpath("//p[@class='product-total']//span[@class='value']");
    public static By butonProceedToCheckout = By.xpath("//div[@class='cart-content-btn']//a");

    //Localizadores en el carrito compra final
    public static By titleCart = By.xpath("//div[@class='card-block']//h1");
    public static By precioProductoCart = By.xpath("//span[@class='price']");
    public static By cantidadProductoCart = By.xpath("//span[contains(@class, 'js-subtotal')]");
    public static By totalPrecioCart = By.xpath("//div[contains(@class,'cart-total')]//span[@class='value']");

    public static By category(String categoria) {
        return By.xpath("//a[.//text()[contains(., '" + categoria + "')]]");
    }

    public static By subCategory(String subcategoria) {
        return By.xpath("//ul[@class='subcategories-list']//a[@title='" + subcategoria + "']");
    }
}
