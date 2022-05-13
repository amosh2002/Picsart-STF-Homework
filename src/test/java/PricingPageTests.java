import components.SignUpPopupComponent;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.PhotoEditingToolsPage;
import pages.PricingPage;

public class PricingPageTests extends TestBase {

    @Test
    public void plansButtonsFunctionalityTest() {
        SoftAssert softAssert = new SoftAssert();
        PricingPage pricingPage = new PricingPage();
        PhotoEditingToolsPage photoEditingToolsPage = new PhotoEditingToolsPage();
        SignUpPopupComponent signUpPopupComponent = new SignUpPopupComponent();

        pricingPage.open();
        pricingPage.scrollToPricingPlans();

        pricingPage.clickStartEditingButton();
        softAssert.assertTrue(photoEditingToolsPage.isLoaded(), "Start Editing button doesn't work");
        photoEditingToolsPage.navigateBack();

        pricingPage.clickTryForFreeButton();
        softAssert.assertTrue(signUpPopupComponent.isLoaded(), "Try For Free button doesn't work");
        signUpPopupComponent.clickCloseButton();

        pricingPage.clickCreateATeamButton();
        softAssert.assertTrue(signUpPopupComponent.isLoaded(), "Try For Free button doesn't work");
        signUpPopupComponent.clickCloseButton();

        softAssert.assertAll();
    }


    @Test
    public void yearlyPackagePricesTest() {
        SoftAssert softAssert = new SoftAssert();
        PricingPage pricingPage = new PricingPage();

        pricingPage.open();
        pricingPage.scrollToPricingPlans();
        softAssert.assertTrue(pricingPage.getFreePricingCardText().contains("$0/mo"), "Price of Free package is wrong");
        softAssert.assertTrue(pricingPage.getGoldPricingCardText().contains("$4.66/mo"), "Price of Gold package is wrong");
        softAssert.assertTrue(pricingPage.getTeamsPricingCardText().contains("$6.24/mo"), "Price of Teams package is wrong");

        pricingPage.clickThreeSeatsButton();
        softAssert.assertTrue(pricingPage.getTeamsPricingCardText().contains("$14.99/mo"), "Price of Teams package is wrong");
        pricingPage.clickFiveSeatsButton();
        softAssert.assertTrue(pricingPage.getTeamsPricingCardText().contains("$23.74/mo"), "Price of Teams package is wrong");
        pricingPage.clickTenSeatsButton();
        softAssert.assertTrue(pricingPage.getTeamsPricingCardText().contains("$45.61/mo"), "Price of Teams package is wrong");
        pricingPage.clickOneSeatButton();
        softAssert.assertTrue(pricingPage.getTeamsPricingCardText().contains("$6.24/mo"), "Price of Teams package is wrong");

        softAssert.assertAll();
    }


    @Test
    public void monthlyPackagePricesTest() {
        SoftAssert softAssert = new SoftAssert();
        PricingPage pricingPage = new PricingPage();

        pricingPage.open();
        pricingPage.clickMonthlyYearlySwitcher();
        pricingPage.scrollToPricingPlans();
        softAssert.assertTrue(pricingPage.getFreePricingCardText().contains("$0/mo"), "Price of Free package is wrong");
        softAssert.assertTrue(pricingPage.getGoldPricingCardText().contains("$11.99/mo"), "Price of Gold package is wrong");
        softAssert.assertTrue(pricingPage.getTeamsPricingCardText().contains("$14.99/mo"), "Price of Teams package is wrong");

        pricingPage.clickThreeSeatsButton();
        softAssert.assertTrue(pricingPage.getTeamsPricingCardText().contains("$35.97/mo"), "Price of Teams package is wrong");
        pricingPage.clickFiveSeatsButton();
        softAssert.assertTrue(pricingPage.getTeamsPricingCardText().contains("$56.95/mo"), "Price of Teams package is wrong");
        pricingPage.clickTenSeatsButton();
        softAssert.assertTrue(pricingPage.getTeamsPricingCardText().contains("$109.39/mo"), "Price of Teams package is wrong");
        pricingPage.clickOneSeatButton();
        softAssert.assertTrue(pricingPage.getTeamsPricingCardText().contains("$14.99/mo"), "Price of Teams package is wrong");

        softAssert.assertAll();
    }
}












