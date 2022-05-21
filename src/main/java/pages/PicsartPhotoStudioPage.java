package pages;

import locators.PicsartPhotoStudioPageLocators;
import org.openqa.selenium.By;

public class PicsartPhotoStudioPage extends BasePage {

    private By pictures = By.cssSelector(PicsartPhotoStudioPageLocators.PICTURES.getLocator());

    @Override
    public String getUrl() {
        return BASE_URL + "/apps/picsart-photo-studio";
    }

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(pictures);
    }

    public int getPicturesCount() {
        return getNumberOfElements(pictures);
    }
}
