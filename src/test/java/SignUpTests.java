import components.SignUpPopupComponent;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import setup.WaitHelper;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

//NOTE: Password field had an issue, such that it was impossible to erase its content using
//      .clear() method, or in any other way, so I have splitted password field tests
//      into very small 1-step tests to still keep the coverage.

public class SignUpTests extends TestBase {

    @Test
    public void emailFieldPositiveTest() {
        SoftAssert softAssert = new SoftAssert();
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Positive scenario
        signUpPopupComponent.clickEmailField();
        softAssert.assertFalse(signUpPopupComponent.isEmailRedAlertDisplayed(), "Positive scenario 1: The field became red");

        //Positive scenario
        signUpPopupComponent.typeInEmailField("armen_armenakyan@edu.aua.am");
        softAssert.assertFalse(signUpPopupComponent.isEmailRedAlertDisplayed(), "Positive scenario 2: The field became red");
        signUpPopupComponent.clearEmailField();

        softAssert.assertAll();

    }

    @Test
    public void emailFieldNegativeTest() {
        SoftAssert softAssert = new SoftAssert();
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Negative scenario
        signUpPopupComponent.typeInEmailField("armen_armenakyanedu.aua.am");
        softAssert.assertTrue(signUpPopupComponent.isEmailRedAlertDisplayed(), "Negative scenario 1: The field didn't become red");
        signUpPopupComponent.clearEmailField();

        //Negative scenario
        softAssert.assertTrue(signUpPopupComponent.isEmailRedAlertDisplayed(), "Negative scenario 2: The field didn't become red");

        softAssert.assertAll();

    }

    @Test
    public void passwordFieldPositiveTest() {
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Positive scenario: don't be red when just clicking
        signUpPopupComponent.clickPasswordField();
        assertFalse(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Positive scenario 1: The field became red");

    }

    @Test
    public void passwordFieldPositiveNormalSequenceTest() {
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Positive scenario: normal sequence
        signUpPopupComponent.typeInPasswordField("Armenia123");
        assertFalse(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Positive scenario 2: The field became red");
    }

    @Test
    public void passwordFieldPositive8CharsTest() {
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Positive scenario: 8
        signUpPopupComponent.typeInPasswordField("Aaaaaa11");
        WaitHelper.getInstance(1).waitForSeconds();
        assertFalse(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Positive scenario 3: The field became red");
    }

    @Test
    public void passwordFieldPositive16CharsTest() {
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Positive scenario: 16
        signUpPopupComponent.typeInPasswordField("Aaaaaaaaaaaa1111");
        WaitHelper.getInstance(1).waitForSeconds();
        assertFalse(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Positive scenario 4: The field became red");
    }

    @Test
    public void passwordFieldNegativeOnlyNumbersTest() {
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Negative scenario: only numbers
        signUpPopupComponent.typeInPasswordField("111111111");
        assertTrue(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Negative scenario 1: The field didn't become red");
    }

    @Test
    public void passwordFieldNegativeOnlyLettersTest() {
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Negative scenario: only letters
        signUpPopupComponent.typeInPasswordField("aaaaaaaaa");
        assertTrue(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Negative scenario 2: The field didn't become red");
    }

    @Test
    public void passwordFieldNegativeTooShortTest() {
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Negative scenario: too short - 7
        signUpPopupComponent.typeInPasswordField("aaaaa11");
        assertTrue(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Negative scenario 3: The field didn't become red");
    }

    @Test
    public void passwordFieldNegativeTooLongTest() {
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Negative scenario: too long - 17
        signUpPopupComponent.typeInPasswordField("aaaaaaaaaaaaaaaa1");
        assertTrue(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Negative scenario 4: The field didn't become red");
    }


    @Test
    public void signUpButtonClickabilityNegativeWrongPasswordTest() {
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Negative scenario: correct email, wrong password
        signUpPopupComponent.typeInEmailField("armen_armenakyan@edu.aua.am");
        signUpPopupComponent.typeInPasswordField("aaaa");
        assertTrue(signUpPopupComponent.isCreateAccountButtonClickable(), "Negative scenario 2: Create Account Button was clickable");

    }

    @Test
    public void signUpButtonClickabilityPositiveTest() {
        SoftAssert softAssert = new SoftAssert();
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Positive scenario: correct email, correct password
        signUpPopupComponent.typeInEmailField("armen_armenakyan@edu.aua.am");
        signUpPopupComponent.typeInPasswordField("Armenia123");
        softAssert.assertTrue(signUpPopupComponent.isCreateAccountButtonClickable(), "Positive scenario 1: Create Account Button wasn't clickable");
    }
}
