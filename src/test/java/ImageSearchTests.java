import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ImagesSearchPage;
import setup.WaitHelper;

import static errors.ErrorMessages.BUTTON_DIDNT_WORK;
import static errors.ErrorMessages.URL_IS_WRONG;
import static org.testng.Assert.assertEquals;

public class ImageSearchTests extends TestBase {

    @Test
    public void categoryButtonsTest() {
        SoftAssert softAssert = new SoftAssert();
        ImagesSearchPage imagesSearchPage = new ImagesSearchPage();
        ImagesSearchPage.StickersSubCategory stickersSubCategory;
        ImagesSearchPage.ImagesSubCategory imagesSubCategory;
        ImagesSearchPage.HashtagsSubCategory hashtagsSubCategory;
        ImagesSearchPage.ArtistsSubCategory artistsSubCategory;

        imagesSearchPage.open();

        stickersSubCategory = imagesSearchPage.clickStickersCategoryButton();
        WaitHelper.getInstance(1).waitForSeconds();
        softAssert.assertTrue(stickersSubCategory.isLoaded(), "Stickers " + BUTTON_DIDNT_WORK.getMessage());
        softAssert.assertEquals(stickersSubCategory.getUrl(), stickersSubCategory.getCurrentUrl());

        WaitHelper.getInstance(1).waitForSeconds();
        imagesSubCategory = imagesSearchPage.clickImagesCategoryButton();
        softAssert.assertTrue(imagesSubCategory.isLoaded(), "Images " + BUTTON_DIDNT_WORK.getMessage());
        softAssert.assertEquals(imagesSubCategory.getUrl(), imagesSubCategory.getCurrentUrl(), "Images " + URL_IS_WRONG.getMessage());

        WaitHelper.getInstance(1).waitForSeconds();
        hashtagsSubCategory = imagesSearchPage.clickHashtagsCategoryButton();
        softAssert.assertTrue(hashtagsSubCategory.isLoaded(), "Hashtags " + BUTTON_DIDNT_WORK.getMessage());
        softAssert.assertEquals(hashtagsSubCategory.getUrl(), hashtagsSubCategory.getCurrentUrl(), "Hashtags " + URL_IS_WRONG.getMessage());

        WaitHelper.getInstance(1).waitForSeconds();
        artistsSubCategory = imagesSearchPage.clickArtistsCategoryButton();
        softAssert.assertTrue(artistsSubCategory.isLoaded(), "Artists " + BUTTON_DIDNT_WORK.getMessage());
        softAssert.assertEquals(artistsSubCategory.getUrl(), artistsSubCategory.getCurrentUrl(), "Artists " + URL_IS_WRONG.getMessage());

        softAssert.assertAll();
    }

    @Test
    public void searchInputFieldTest() {
        SoftAssert softAssert = new SoftAssert();
        ImagesSearchPage imagesSearchPage = new ImagesSearchPage();

        imagesSearchPage.open();

        // Positive scenario
        imagesSearchPage.clickSearchInputField();
        softAssert.assertFalse(imagesSearchPage.isSearchSuggestionListPresent(), "Positive scenario: Search suggestions are displayed");

        // Positive scenario
        imagesSearchPage.typeInSearchInputField("love");
        softAssert.assertTrue(imagesSearchPage.getSearchSuggestionItemText().contains("love"), "Positive scenario: Search suggestion is displayed wrong");
        imagesSearchPage.clearSearchInputFieldContent();

        // Negative scenario
        imagesSearchPage.typeInSearchInputField("hac_panir_pomidor");
        WaitHelper.getInstance(1).waitForSeconds();
        softAssert.assertFalse(imagesSearchPage.isSearchSuggestionListPresent(), "Negative scenario: Search suggestions are displayed");

        softAssert.assertAll();

    }

    @Test
    public void searchInputFieldSuggestionRedirectionTest() {
        ImagesSearchPage imagesSearchPage = new ImagesSearchPage();

        imagesSearchPage.open();

        imagesSearchPage.typeInSearchInputField("love");
        imagesSearchPage.clickFirstSearchSuggestionItem();
        WaitHelper.getInstance(2).waitForSeconds();
        assertEquals(imagesSearchPage.getCurrentUrl(), "https://picsartstage2.com/hashtag/love", "Redirection works wrong");


    }

}
