import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ImagesSearchPage;

public class ImageSearchTests extends TestBase {
    @Test
    public void categoryButtonsTest() {
        SoftAssert softAssert = new SoftAssert();
        ImagesSearchPage imagesSearchPage = new ImagesSearchPage();

        imagesSearchPage.open();
        softAssert.assertTrue(imagesSearchPage.clickStickersCategoryButton().isLoaded(), "Stickers button doesn't work");
        softAssert.assertTrue(imagesSearchPage.clickImagesCategoryButton().isLoaded(), "Images button doesn't work");
        softAssert.assertTrue(imagesSearchPage.clickHashtagsCategoryButton().isLoaded(), "Hashtags button doesn't work");
        softAssert.assertTrue(imagesSearchPage.clickArtistsCategoryButton().isLoaded(), "Artists button doesn't work");

        softAssert.assertAll();
    }
}
