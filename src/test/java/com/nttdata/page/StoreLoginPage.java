package com.nttdata.page;

import org.openqa.selenium.By;

public class StoreLoginPage {

    //Localizadores de elementos
    public static By userInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By signOutButton = By.xpath("//div[@class='user-info']//a[contains(@class, 'logout')]");

}
