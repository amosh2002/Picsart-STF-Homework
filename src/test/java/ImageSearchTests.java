import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ImagesSearchPage;
import setup.WaitHelper;

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
}
