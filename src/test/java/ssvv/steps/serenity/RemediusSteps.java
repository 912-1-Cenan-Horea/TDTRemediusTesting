package ssvv.steps.serenity;

import net.thucydides.core.annotations.Step;
import ssvv.pages.RemediusPage;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class RemediusSteps {
    RemediusPage remediusPage;


    @Step
    public void toRegisrationPage() {
        remediusPage.open();

    }

    @Step
    public void acceptCookies() {
        remediusPage.acceptCookies();
    }

    @Step
    public void enterEmail(String email) {
        remediusPage.enterEmail(email);
    }

    @Step
    public void enterPassword(String password) {
        remediusPage.enterPassword(password);
    }

    @Step
    public void enterPhone(String phone) {
        remediusPage.enterPhone(phone);
    }

    @Step
    public void enterPostalCode(String postalCode) {
        remediusPage.enterPostalCode(postalCode);
    }


    @Step
    public void clickSubmit() {
        remediusPage.clickSubmit();
    }

    @Step
    public void shouldEmailContainError() {
        assertThat(remediusPage.emailField.getAttribute("class"), containsString("parsley-error"));
    }

    @Step
    public void shouldPasswordContainError() {
        assertThat(remediusPage.passwordField.getAttribute("class"), containsString("parsley-error"));
    }

    @Step
    public void shouldPhoneContainError() {
        assertThat(remediusPage.phoneField.getAttribute("class"), containsString("parsley-error"));
    }

    @Step
    public void shouldPostalCodeContainError() {
        assertThat(remediusPage.postalCodeField.getAttribute("class"), containsString("parsley-error"));
    }

    // cases when input is valid
    @Step
    public void shouldEmailNotContainError() {
        assertThat(remediusPage.emailField.getAttribute("class"), containsString("parsley-success"));
    }

    @Step
    public void shouldPasswordNotContainError() {
        assertThat(remediusPage.passwordField.getAttribute("class"), containsString("parsley-success"));
    }

    @Step
    public void shouldPhoneNotContainError() {
        assertThat(remediusPage.phoneField.getAttribute("class"), containsString("parsley-success"));
    }

    @Step
    public void shouldPostalCodeNotContainError() {
        assertThat(remediusPage.postalCodeField.getAttribute("class"), containsString("parsley-success"));
    }


}
