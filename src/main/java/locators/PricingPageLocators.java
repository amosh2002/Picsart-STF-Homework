package locators;

public enum PricingPageLocators {

    START_EDITING_BUTTON("[data-test=\"start-editing-button\"]"),
    TRY_FOR_FREE_BUTTON("[data-test=\"subscription-main-button\"]"),
    CREATE_TEAM_BUTTON("[aria-label=\"Try Picsart Team for Free\"]"),
    GET_STARTED_BUTTON("[data-test=\"subscription-banner-button\"]"),
    ONE_SEAT("[class*=\"count-select\"] :nth-child(1) :nth-child(2)"),
    THREE_SEATS("[class*=\"count-select\"] :nth-child(2) :nth-child(2)"),
    FIVE_SEATS("[class*=\"count-select\"] :nth-child(3) :nth-child(2)"),
    TEN_SEATS("[class*=\"count-select\"] :nth-child(4) :nth-child(2)"),
    FREE_PRICING_CARD("#free [data-test*=y-price]"),
    GOLD_PRICING_CARD("#gold [data-test*=y-price]"),
    TEAMS_PRICING_CARD("#teams [data-test*=y-price]"),
    MONTHLY_YEARLY_SWITCHER(".gold-pricing-options-wrapper div label");

    private final String locator;

    PricingPageLocators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return this.locator;
    }

}
