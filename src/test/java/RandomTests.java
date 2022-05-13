import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlogPage;
import pages.HomePage;
import pages.RemoveBackgroundBlogPage;

import static errors.ErrorMessages.*;

public class RandomTests extends TestBase {

    @Test
    public void homePageAndBlogNavigateTest() {
        HomePage homePage = new HomePage();
        BlogPage blogPage = new BlogPage();

        Assert.assertTrue(homePage.getPressAndReviewsHeading().contains("Press and Reviews"));
        homePage.clickBlogButton();
        Assert.assertEquals(blogPage.getCurrentUrl(), blogPage.getUrl(), PAGE_NOT_OPENED.getMessage());
    }

    @Test
    public void blogPageAndRemoveBackgroundNavigateTest() {
        BlogPage blogPage = new BlogPage();
        RemoveBackgroundBlogPage removeBackgroundBlogPage;

        blogPage.open();
        blogPage.scrollToMostPopularCarousel();
        blogPage.clickMostPopularCarouselNextButton();
        removeBackgroundBlogPage = blogPage.clickChangeBackgroundButton();
        Assert.assertEquals(removeBackgroundBlogPage.getCurrentUrl(), removeBackgroundBlogPage.getUrl(), PAGE_NOT_OPENED.getMessage());
    }

    @Test
    public void removeBackgroundAndHomeNavigateTest() {
        HomePage homePage;
        RemoveBackgroundBlogPage removeBackgroundBlogPage = new RemoveBackgroundBlogPage();

        removeBackgroundBlogPage.open();
        Assert.assertEquals(removeBackgroundBlogPage.getRemoveBackgroundTitle(), "Welcome to Picsart, the world’s largest creative platform and community! Every month, more than 150 million people use Picsart to express unique, fun, inspiring moments through the power of visual storytelling.");
        homePage = removeBackgroundBlogPage.clickPicsartLogo();
        Assert.assertEquals(homePage.getCurrentUrl(), homePage.getUrl() + "/", PAGE_NOT_OPENED.getMessage());
    }

    @Test
    public void allPagesNavigateTest() {
        HomePage homePage = new HomePage();
        RemoveBackgroundBlogPage removeBackgroundBlogPage;
        BlogPage blogPage = homePage.clickBlogButton();

        blogPage.scrollToMostPopularCarousel();
        blogPage.clickMostPopularCarouselNextButton();
        removeBackgroundBlogPage = blogPage.clickChangeBackgroundButton();
        removeBackgroundBlogPage.scrollToNextPostButton();
        Assert.assertTrue(removeBackgroundBlogPage.isNextPostButtonPresent(), ELEMENT_NOT_FOUND.getMessage());
    }

}
