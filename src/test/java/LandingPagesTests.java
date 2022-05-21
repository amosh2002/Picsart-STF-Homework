import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EditorPage;
import pages.LandingPage;
import setup.WaitHelper;

import java.util.List;

import static errors.ErrorMessages.*;

public class LandingPagesTests extends TestBase {

    ////////////////////////////////////////// Flyer Maker Page //////////////////////////////////////////

    List<String> flyerTitles = List.of("Use Flyer Maker To Promote Your Product in Style",
            "Flyers That Are Fully Customizable and Easy to Use",
            "This Flyer Creator Won’t Cost a Penny",
            "Create Professional, High-Quality Business Flyers",
            "Make Beautiful Flyers For Any Occasion");

    List<String> flyerDescriptions = List.of("Create custom-made flyer designs for any business, industry or purpose.",
            "The Picsart Flyer Maker has been designed to make the process of creating flyers a quick and simple one.",
            "When creating visuals for promotional purposes, it’s a myth that you need to hire a professional to do the job",
            "Anyone can use the Picsart Flyer Maker to design high-quality, professional flyers in minutes",
            "No matter what you’re publicizing, the Picsart Flyer Maker can help you create the flyer you need");


    @Test
    public void flyerMakerButtonsTest() {
        SoftAssert softAssert = new SoftAssert();
        LandingPage flyerMakerPage = new LandingPage("flyer-maker");
        EditorPage editorPage;

        flyerMakerPage.open();
        for (int i = 0; i < 5; i++) {
            editorPage = flyerMakerPage.clickButton(i);
            WaitHelper.getInstance(2).waitForSeconds();
            softAssert.assertTrue(editorPage.getDropDownText().contains("Flyer"), BUTTON_DIDNT_WORK.getMessage() + i);
            flyerMakerPage.open();
        }

        softAssert.assertAll();
    }

    @Test
    public void flyerMakerTitlesTest() {
        SoftAssert softAssert = new SoftAssert();
        LandingPage flyerMakerPage = new LandingPage("flyer-maker");

        flyerMakerPage.open();
        for (int i = 0; i < 5; i++) {
            softAssert.assertTrue(flyerMakerPage.getTitleText(i).contains(flyerTitles.get(i)), TITLE_TEXT_INCORRECT.getMessage() + i);
        }

        softAssert.assertAll();
    }

    @Test
    public void flyerMakerDescriptionsTest() {
        SoftAssert softAssert = new SoftAssert();
        LandingPage flyerMakerPage = new LandingPage("flyer-maker");

        flyerMakerPage.open();
        for (int i = 0; i < 5; i++) {
            softAssert.assertTrue(flyerMakerPage.getDescriptionText(i).contains(flyerDescriptions.get(i)), DESCRIPTION_TEXT_INCORRECT.getMessage() + i);
        }

        softAssert.assertAll();
    }

    //////////////////////////////////////// Brochure Maker Page //////////////////////////////////////////

    List<String> brochureTitles = List.of("The Professional Brochure Maker That Anyone Can Use",
            "Why Pay When You Can Create Brochures Online Today?",
            "Brochure Design That Doesn’t Require Design Skill",
            "Customize Brochures to Your Specification",
            "Make Professional Brochures for Any Occasion",
            "Choose From a Wide Selection of Brochure Templates");

    List<String> brochureDescriptions = List.of("It’s free, it’s simple and it’ll help you create sleek and stylish brochure designs.",
            "The Picsart Brochure Maker won’t cost you a penny, but it will save you a lot of time and hassle",
            "With the Picsart Brochure Maker, you don’t need to have any programming or design skills to create beautiful brochures",
            "To give your professional brochure a one-of-kind feel and make it stand out from the competition, you can customize it with ease.",
            "Whether you’re a professional photographer creating a brochure for your wedding services, a travel agent showcasing seasonal deals, a realtor",
            "Along with the handy Brochure Maker, Picsart offers an array of templates to use. From bold to understated and everything in between");

    @Test
    public void brochureMakerButtonsTest() {
        SoftAssert softAssert = new SoftAssert();
        LandingPage brochureMakerPage = new LandingPage("brochure-maker");
        EditorPage editorPage;

        brochureMakerPage.open();
        for (int i = 0; i < 5; i++) {
            editorPage = brochureMakerPage.clickButton(i);
            WaitHelper.getInstance(4).waitForSeconds();
            softAssert.assertTrue(editorPage.getSearchFieldText().contains("brochure"), BUTTON_DIDNT_WORK.getMessage() + i);
            brochureMakerPage.open();
        }

        softAssert.assertAll();
    }

    @Test
    public void brochureMakerTitlesTest() {
        SoftAssert softAssert = new SoftAssert();
        LandingPage brochureMakerPage = new LandingPage("brochure-maker");

        brochureMakerPage.open();
        for (int i = 0; i < 5; i++) {
            softAssert.assertTrue(brochureMakerPage.getTitleText(i).contains(brochureTitles.get(i)), TITLE_TEXT_INCORRECT.getMessage() + i);
        }

        softAssert.assertAll();
    }

    @Test
    public void brochureMakerDescriptionsTest() {
        SoftAssert softAssert = new SoftAssert();
        LandingPage brochureMakerPage = new LandingPage("brochure-maker");

        brochureMakerPage.open();
        for (int i = 0; i < 5; i++) {
            softAssert.assertTrue(brochureMakerPage.getDescriptionText(i).contains(brochureDescriptions.get(i)), DESCRIPTION_TEXT_INCORRECT.getMessage() + i);
        }

        softAssert.assertAll();
    }
}

