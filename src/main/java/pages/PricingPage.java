package pages;

import org.openqa.selenium.By;

import static locators.PricingPageLocators.*;

public class PricingPage extends BasePage {

    private final By getStartedButton = By.cssSelector(GET_STARTED_BUTTON.getLocator());
    private final By startEditingButton = By.cssSelector(START_EDITING_BUTTON.getLocator());
    private final By tryForFreeButton = By.cssSelector(TRY_FOR_FREE_BUTTON.getLocator());
    private final By createTeamButton = By.cssSelector(CREATE_TEAM_BUTTON.getLocator());
    private final By oneSeatButton = By.cssSelector(ONE_SEAT.getLocator());
    private final By threeSeatsButton = By.cssSelector(THREE_SEATS.getLocator());
    private final By fiveSeatsButton = By.cssSelector(FIVE_SEATS.getLocator());
    private final By tenSeatsButton = By.cssSelector(TEN_SEATS.getLocator());
    private final By freePricingCard = By.cssSelector(FREE_PRICING_CARD.getLocator());
    private final By goldPricingCard = By.cssSelector(GOLD_PRICING_CARD.getLocator());
    private final By teamsPricingCard = By.cssSelector(TEAMS_PRICING_CARD.getLocator());
    private final By monthlyYearlySwitcher = By.cssSelector(MONTHLY_YEARLY_SWITCHER.getLocator());

    @Override
    public String getUrl() {
        return BASE_URL + "/gold";
    }

    @Override
    public boolean isLoaded() {
        return isElementDisplayed(getStartedButton);
    }


    public void scrollToPricingPlans() {
        scrollToElement(startEditingButton);
    }

    public void clickStartEditingButton() {
        click(startEditingButton);
    }

    public void clickTryForFreeButton() {
        click(tryForFreeButton);
    }

    public void clickCreateATeamButton() {
        click(createTeamButton);
    }

    public void clickOneSeatButton() {
        click(oneSeatButton);
    }

    public void clickThreeSeatsButton() {
        click(threeSeatsButton);
    }

    public void clickFiveSeatsButton() {
        click(fiveSeatsButton);
    }

    public void clickTenSeatsButton() {
        click(tenSeatsButton);
    }

    public void clickMonthlyYearlySwitcher() {
        click(monthlyYearlySwitcher);
    }

    public String getFreePricingCardText() {
        return getText(freePricingCard);
    }

    public String getGoldPricingCardText() {
        return getText(goldPricingCard);
    }

    public String getTeamsPricingCardText() {
        return getText(teamsPricingCard);
    }

}
