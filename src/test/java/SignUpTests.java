import components.SignUpPopupComponent;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;

public class SignUpTests extends TestBase {

    @Test
    public void emailFieldPositiveTest() {
        SoftAssert softAssert = new SoftAssert();
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Positive scenario
        signUpPopupComponent.clickEmailField();
        softAssert.assertFalse(signUpPopupComponent.isEmailRedAlertDisplayed(), "Positive scenario: The field became red");

        //Positive scenario
        signUpPopupComponent.typeInEmailField("armen_armenakyan@edu.aua.am");
        softAssert.assertFalse(signUpPopupComponent.isEmailRedAlertDisplayed(), "Positive scenario: The field became red");
        signUpPopupComponent.clearEmailField();

        softAssert.assertAll();

    }

    @Test
    public void emailFieldNegativeTest() {
        SoftAssert softAssert = new SoftAssert();
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Negative scenario
        signUpPopupComponent.typeInEmailField("armen_armenakyanedu.aua.am");
        softAssert.assertTrue(signUpPopupComponent.isEmailRedAlertDisplayed(), "Negative scenario: The field didn't become red");
        signUpPopupComponent.clearEmailField();

        //Negative scenario
        softAssert.assertTrue(signUpPopupComponent.isEmailRedAlertDisplayed(), "Negative scenario: The field didn't become red");

        softAssert.assertAll();

    }

    @Test
    public void passwordFieldPositiveTest() {
        SoftAssert softAssert = new SoftAssert();
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Positive scenario: don't be red when just clicking
        signUpPopupComponent.clickPasswordField();
        softAssert.assertFalse(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Positive scenario: The field became red");

        //Positive scenario: normal sequence
        signUpPopupComponent.typeInEmailField("Armenia123");
        softAssert.assertFalse(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Positive scenario: The field became red");
        signUpPopupComponent.clearPasswordField();

        //Positive scenario: 8
        signUpPopupComponent.typeInEmailField("aaaaaa11");
        softAssert.assertFalse(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Positive scenario: The field became red");
        signUpPopupComponent.clearPasswordField();

        //Positive scenario: 16
        signUpPopupComponent.typeInEmailField("aaaaaaaaaaaa1111");
        softAssert.assertFalse(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Positive scenario: The field became red");
        signUpPopupComponent.clearPasswordField();

        softAssert.assertAll();

    }

    @Test
    public void passwordFieldPNegativeTest() {
        SoftAssert softAssert = new SoftAssert();
        SignUpPopupComponent signUpPopupComponent = new HomePage().clickSignUpButton();

        //Negative scenario: only numbers
        signUpPopupComponent.typeInPasswordField("111111111");
        softAssert.assertTrue(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Negative scenario: The field didn't become red");
        signUpPopupComponent.clearPasswordField();

        //Negative scenario: only letters
        signUpPopupComponent.typeInPasswordField("aaaaaaaaa");
        softAssert.assertTrue(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Negative scenario: The field didn't become red");
        signUpPopupComponent.clearPasswordField();

        //Negative scenario: too short - 7
        signUpPopupComponent.typeInPasswordField("aaaaa11");
        softAssert.assertTrue(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Negative scenario: The field didn't become red");
        signUpPopupComponent.clearPasswordField();

        //Negative scenario: too long - 17
        signUpPopupComponent.typeInPasswordField("aaaaaaaaaaaaaaaa1");
        softAssert.assertTrue(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Negative scenario: The field didn't become red");
        signUpPopupComponent.clearPasswordField();

        //Negative scenario: keep red after erasing
        softAssert.assertTrue(signUpPopupComponent.isPasswordRedAlertDisplayed(), "Negative scenario: The field didn't become red");

        softAssert.assertAll();

    }
}
