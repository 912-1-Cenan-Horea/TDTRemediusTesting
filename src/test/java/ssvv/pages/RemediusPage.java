package ssvv.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("https://www.remedius.ro/inregistrare")
public class RemediusPage extends PageObject {
    @FindBy(id = "customer_signup__email")
    public WebElementFacade emailField;

    @FindBy(id = "customer_signup__password")
    public WebElementFacade passwordField;

    //phone
    @FindBy(id = "customer_signup__phone")
    public WebElementFacade phoneField;

    //postal code
    @FindBy(id = "customer_signup__postal_code")
    public WebElementFacade postalCodeField;


    //signup_submit
    @FindBy(id = "customer_signup__submit")
    public WebElementFacade submitButton;

    public void acceptCookies() {
        find(By.xpath("//button[.='Accept']")).click();
    }


    //methods to enter data in fields
    public void enterEmail(String email) {
        emailField.type(email);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void enterPhone(String phone) {
        phoneField.type(phone);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.type(postalCode);
    }

    public void clickSubmit() {
        submitButton.click();
    }
}

