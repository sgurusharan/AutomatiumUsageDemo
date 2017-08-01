import com.automatium.action.ActionChain;
import com.automatium.test.AutomatiumTest;
import com.automatium.utils.TestUtils;
import org.junit.Test;
import page.DemoHomePage;
import page.WelcomePage;

/**
 * Created by sgurusharan on 8/1/17.
 */
public class DirectPageAccessTest extends AutomatiumTest {
    @Override
    protected Class<WelcomePage> getExpectedFirstPage() {
        return WelcomePage.class;
    }

    @Test
    public void testAccessWelcomePageWithoutLoggingIn() {

        currentPage.goBackToHomePage();
        currentPage = currentPage.getCurrentPage();

        currentPage = ActionChain.start(currentPage)
                .gotoUrl(testConfiguration.getStartUrl() + "/welcome.jsp")
                .perform();

        TestUtils.assertTrue(currentPage.waitForPage(DemoHomePage.class, 10L), "FAIL: Accessing welcome page without logging in does not take user back to home page");
    }
}
