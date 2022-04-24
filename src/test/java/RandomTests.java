import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.HomePage;
import pages.RemoveBackgroundBlogPage;

import static errors.ErrorMessages.PAGE_NOT_OPENED;

public class RandomTests extends TestBase {

    @Test
    public void homePageAndBlogNavigateTest() {
        HomePage homePage = new HomePage();
        BlogPage blogPage = new BlogPage();

        Assert.assertTrue(homePage.getPressAndReviewsHeading().contains("Press and Reviews"));
        homePage.clickBlogButton();
        Assert.assertEquals(blogPage.getCurrentUlr(), blogPage.getUrl(), PAGE_NOT_OPENED.getMessage());
    }

    @Test
    public void blogPageAndRemoveBackgroundNavigateTest() {
        BlogPage blogPage = new BlogPage();
        RemoveBackgroundBlogPage removeBackgroundBlogPage;

        blogPage.open();
        blogPage.scrollToMostPopularCarousel();
        blogPage.clickMostPopularCarouselNextButton();
        removeBackgroundBlogPage = blogPage.clickChangeBackgroundButton();
        Assert.assertEquals(removeBackgroundBlogPage.getCurrentUlr(), removeBackgroundBlogPage.getUrl(), PAGE_NOT_OPENED.getMessage());
    }

}
