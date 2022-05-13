package locators;

public enum ImagesSearchPageLocators {
    STICKERS_CARD("[data-testid=\"sticker-card\"]"),
    ALL_CATEGORY_BUTTON("[class*=\"search-tabs-tabsRow\"] a:nth-child(1)"),
    STICKERS_CATEGORY_BUTTON("[class*=\"search-tabs-tabsRow\"] a:nth-child(2)"),
    IMAGES_CATEGORY_BUTTON("[class*=\"search-tabs-tabsRow\"] a:nth-child(3)"),
    HASHTAGS_CATEGORY_BUTTON("[class*=\"search-tabs-tabsRow\"] a:nth-child(4)"),
    ARTISTS_CATEGORY_BUTTON("[class*=\"search-tabs-tabsRow\"] a:nth-child(5)"),

    STICKERS_CATEGORY_STICKER_ITEM("[data-testid=\"photo-card-sticker\"]"),
    IMAGES_CATEGORY_IMAGE_ITEM("[alt=\"Picture of the author\"]"),
    HASHTAGS_CATEGORY_HASHTAG_ITEM("[href=\"/hashtag/freetoedit\"]"),
    ARTISTS_CATEGORY_ARTIST_ITEM("[class*=\"photo-card-artist-profileFollow\"]");

    private final String locator;

    ImagesSearchPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }
}
