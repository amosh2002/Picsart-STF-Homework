import components.DownloadAppPopUpComponent;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import setup.WaitHelper;

import java.util.List;

import static errors.ErrorMessages.BUTTON_DIDNT_WORK;
import static errors.ErrorMessages.DESCRIPTION_TEXT_INCORRECT;

public class AppsLandingPageTests extends TestBase {

    List<String> appsDescriptions = List.of("Say Hello to the Only Editing Apps You’ll Ever Need",
            "You could settle for one of the many good photo editing apps available, or you could choose the photo editor app with a difference",
            "Let your creativity roam free with Picsart Color",
            "But if you fancy something even simpler, look no further than paint by number app PixelArt.",
            "See yourself as something of a budding Spielberg?",
            "Picsart Animator – GIF & Video takes the complication out of animation",
            "Why download two apps when you can get the job done in one?");


    @Test
    public void appsPrimaryButtonsTest() {
        SoftAssert softAssert = new SoftAssert();
        AppsLandingPage appsPage = new AppsLandingPage();

        appsPage.open();
        softAssert.assertTrue(appsPage.clickStartFreeTrialButton().isLoaded(), BUTTON_DIDNT_WORK.getMessage() + 0);
        appsPage.open();
        softAssert.assertEquals(appsPage.clickReadMoreButton().getPicturesCount(), 16, BUTTON_DIDNT_WORK.getMessage() + 1);

        softAssert.assertAll();
    }

    @Test
    public void appsSecondaryButtonsTest() {
        SoftAssert softAssert = new SoftAssert();
        AppsLandingPage appsPage = new AppsLandingPage();
        DownloadAppPopUpComponent downloadAppPopUpComponent;

        appsPage.open();
        for (int i = 0; i < 8; i++) {
            if (i == 4) continue;
            downloadAppPopUpComponent = appsPage.clickGetNowButton(i);
            softAssert.assertTrue(downloadAppPopUpComponent.isLoaded(), BUTTON_DIDNT_WORK.getMessage() + i);
            downloadAppPopUpComponent.clickCloseButton();
        }

        softAssert.assertAll();
    }

    @Test
    public void appsDescriptionsTest() {
        SoftAssert softAssert = new SoftAssert();
        AppsLandingPage appsPage = new AppsLandingPage();

        appsPage.open();
        for (int i = 0; i < 6; i++) {
            softAssert.assertTrue(appsPage.getDescriptionText(i).contains(appsDescriptions.get(i)), DESCRIPTION_TEXT_INCORRECT.getMessage() + i);
        }

        softAssert.assertAll();
    }
}

