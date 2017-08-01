package page;

import com.automatium.page.BaseHomePage;
import com.automatium.page.BasePage;
import com.automatium.page.TestEntryPage;
import org.openqa.selenium.By;

/**
 * Created by sgurusharan on 8/1/17.
 */
public class LogoutPage extends BasePage {
    private static final String HOME_PAGE_LINK = "homePageLink";

    @Override
    public void goBackToHomePage() {
        click(HOME_PAGE_LINK);
        waitForPage(DemoHomePage.class, 10L);
    }

    @Override
    public void addLocators() {
        addLocator(HOME_PAGE_LINK, By.tagName("a"));
    }

    @Override
    public boolean isAtPage() {
        return (true
            && getTitle().equals("Logout Automatium Demo"));
    }
}
