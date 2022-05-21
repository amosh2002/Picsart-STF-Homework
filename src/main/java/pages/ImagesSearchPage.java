package pages;

import org.openqa.selenium.By;

import static locators.ImagesSearchPageLocators.*;

public class ImagesSearchPage extends BasePage {

    private final By stickersCategoryButton = By.cssSelector(STICKERS_CATEGORY_BUTTON.getLocator());
    private final By imagesCategoryButton = By.cssSelector(IMAGES_CATEGORY_BUTTON.getLocator());
    private final By hashtagsCategoryButton = By.cssSelector(HASHTAGS_CATEGORY_BUTTON.getLocator());
    private final By artistsCategoryButton = By.cssSelector(ARTISTS_CATEGORY_BUTTON.getLocator());
    private final By searchInputField = By.cssSelector(SEARCH_INPUT_FIELD.getLocator());
    private final By searchSuggestionItem = By.cssSelector(SEARCH_SUGGESTION_ITEM.getLocator());

    @Override
    public String getUrl() {
        return BASE_URL + "/search";
    }

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(imagesCategoryButton);
    }

    public StickersSubCategory clickStickersCategoryButton() {
        click(stickersCategoryButton);
        return new StickersSubCategory();
    }

    public ImagesSubCategory clickImagesCategoryButton() {
        click(imagesCategoryButton);
        return new ImagesSubCategory();
    }

    public HashtagsSubCategory clickHashtagsCategoryButton() {
        click(hashtagsCategoryButton);
        return new HashtagsSubCategory();
    }

    public ArtistsSubCategory clickArtistsCategoryButton() {
        click(artistsCategoryButton);
        return new ArtistsSubCategory();
    }

    public void clickSearchInputField() {
        click(searchInputField);
    }

    public void clickFirstSearchSuggestionItem() {
        click(searchSuggestionItem);
    }

    public void typeInSearchInputField(String text) {
        typeIn(searchInputField, text);
    }

    public void clearSearchInputFieldContent() {
        clearContent(searchInputField);
    }

    public String getSearchSuggestionItemText() {
        return getText(searchSuggestionItem);
    }

    public boolean isSearchSuggestionListPresent() {
        return isElementDisplayed(searchSuggestionItem);
    }

    public class StickersSubCategory extends BasePage {

        private final By stickersCategoryStickerItem = By.cssSelector(STICKERS_CATEGORY_STICKER_ITEM.getLocator());

        @Override
        public String getUrl() {
            return ImagesSearchPage.this.getUrl() + "/stickers";
        }

        @Override
        public boolean isLoaded() {
            return isElementDisplayed(stickersCategoryStickerItem);
        }
    }

    public class ImagesSubCategory extends BasePage {

        private final By imagesCategoryImageItem = By.cssSelector(IMAGES_CATEGORY_IMAGE_ITEM.getLocator());

        @Override
        public String getUrl() {
            return ImagesSearchPage.this.getUrl() + "/images";
        }

        @Override
        public boolean isLoaded() {
            return isElementDisplayed(imagesCategoryImageItem);
        }
    }

    public class HashtagsSubCategory extends BasePage {

        private final By hashtagsCategoryHashtagItem = By.cssSelector(HASHTAGS_CATEGORY_HASHTAG_ITEM.getLocator());

        @Override
        public String getUrl() {
            return ImagesSearchPage.this.getUrl() + "/tags";
        }

        @Override
        public boolean isLoaded() {
            return isElementDisplayed(hashtagsCategoryHashtagItem);
        }
    }

    public class ArtistsSubCategory extends BasePage {

        private final By artistsCategoryArtistItem = By.cssSelector(ARTISTS_CATEGORY_ARTIST_ITEM.getLocator());

        @Override
        public String getUrl() {
            return ImagesSearchPage.this.getUrl() + "/artists";
        }

        @Override
        public boolean isLoaded() {
            return isElementDisplayed(artistsCategoryArtistItem);
        }
    }
}
