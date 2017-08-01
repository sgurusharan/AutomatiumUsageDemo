package page;

import com.automatium.page.BaseHomePage;
import com.automatium.page.TestEntryPage;
import org.openqa.selenium.By;

/**
 * Created by sgurusharan on 8/1/17.
 */
public class WelcomePage extends TestEntryPage {
    private static final String LOGOUT_LINK = "logoutLink";

    @Override
    public void navigateToPageFromHomePage(BaseHomePage homePage) {
        ((DemoHomePage) homePage).loginAsTestUser1();
    }

    @Override
    public void goBackToHomePage() {
        click(LOGOUT_LINK);
        waitForPage(DemoHomePage.class, 10L);
    }

    @Override
    public void addLocators() {
        addLocator(LOGOUT_LINK, By.linkText("Logout"));
    }

    @Override
    public boolean isAtPage() {
        return (true
            && getTitle().equals("Welcome to Automatium Demo Site"));
    }
}
