import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ImagesSearchPage;
import setup.WaitHelper;

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
        WaitHelper.getInstance().waitForSeconds(1000);
        softAssert.assertTrue(stickersSubCategory.isLoaded(), "Stickers button doesn't work");
        softAssert.assertEquals(stickersSubCategory.getUrl(), stickersSubCategory.getCurrentUrl());

        WaitHelper.getInstance().waitForSeconds(1000);
        imagesSubCategory = imagesSearchPage.clickImagesCategoryButton();
        softAssert.assertTrue(imagesSubCategory.isLoaded(), "Images button doesn't work");
        softAssert.assertEquals(imagesSubCategory.getUrl(), imagesSubCategory.getCurrentUrl(), "Images subcategory URL is wrong");

        WaitHelper.getInstance().waitForSeconds(1000);
        hashtagsSubCategory = imagesSearchPage.clickHashtagsCategoryButton();
        softAssert.assertTrue(hashtagsSubCategory.isLoaded(), "Hashtags button doesn't work");
        softAssert.assertEquals(hashtagsSubCategory.getUrl(), hashtagsSubCategory.getCurrentUrl(), "Hashtags subcategory URL is wrong");

        WaitHelper.getInstance().waitForSeconds(1000);
        artistsSubCategory = imagesSearchPage.clickArtistsCategoryButton();
        softAssert.assertTrue(artistsSubCategory.isLoaded(), "Artists button doesn't work");
        softAssert.assertEquals(artistsSubCategory.getUrl(), artistsSubCategory.getCurrentUrl(), "Artists subcategory URL is wrong");

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
        WaitHelper.getInstance().waitForSeconds(1000);
        softAssert.assertFalse(imagesSearchPage.isSearchSuggestionListPresent(), "Negative scenario: Search suggestions are displayed");

        softAssert.assertAll();

    }

    @Test
    public void searchInputFieldSuggestionRedirectionTest() {
        ImagesSearchPage imagesSearchPage = new ImagesSearchPage();

        imagesSearchPage.open();

        imagesSearchPage.typeInSearchInputField("love");
        imagesSearchPage.clickFirstSearchSuggestionItem();
        WaitHelper.getInstance().waitForSeconds(2000);
        assertEquals(imagesSearchPage.getCurrentUrl(), "https://picsartstage2.com/hashtag/love", "Redirection works wrong");


    }

}
