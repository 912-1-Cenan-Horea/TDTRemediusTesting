package ssvv.features.remedius;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ssvv.steps.serenity.RemediusSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/remediusRegister.csv")
public class ValidateRegisterInputsStory {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    public RemediusSteps remediusSteps;
    public String email;
    public Boolean emailValid;
    public String password;
    public Boolean passwordValid;


    public String phone;
    public Boolean phoneValid;

    public String postalCode;
    public Boolean postalCodeValid;

    @Issue("REMEDIUS_REGISTER")
    @Test
    public void validateRegisterInputs() {
        remediusSteps.toRegisrationPage();
        WebDriverWait wait = new WebDriverWait(
                webdriver,
                5
        );
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        webdriver.findElement(By.xpath("//button[.='Accept']"))
                )
        );
        remediusSteps.acceptCookies();
        remediusSteps.enterEmail(email);
        remediusSteps.enterPassword(password);
        remediusSteps.enterPhone(phone);
        remediusSteps.enterPostalCode(postalCode);
        remediusSteps.clickSubmit();
        if (emailValid) {
            remediusSteps.shouldEmailNotContainError();
        } else {
            remediusSteps.shouldEmailContainError();
        }
        if (passwordValid) {
            remediusSteps.shouldPasswordNotContainError();
        } else {
            remediusSteps.shouldPasswordContainError();
        }
        if (phoneValid) {
            remediusSteps.shouldPhoneNotContainError();
        } else {
            remediusSteps.shouldPhoneContainError();
        }
        if (postalCodeValid) {
            remediusSteps.shouldPostalCodeNotContainError();
        } else {
            remediusSteps.shouldPostalCodeContainError();
        }
    }


}
