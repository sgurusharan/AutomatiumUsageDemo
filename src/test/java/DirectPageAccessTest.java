import com.automatium.action.ActionChain;
import com.automatium.test.AutomatiumTest;
import com.automatium.utils.TestUtils;
import org.junit.Test;
import page.DemoHomePage;
import page.LogoutPage;
import page.WelcomePage;

/**
 * Created by sgurusharan on 8/1/17.
 */
public class DirectPageAccessTest extends AutomatiumTest {
    @Override
    protected Class<LogoutPage> getExpectedFirstPage() {
        return LogoutPage.class;
    }

    @Test
    public void testAccessWelcomePageWithoutLoggingIn() {

        currentPage = ActionChain.start(currentPage)
                .gotoUrl(testConfiguration.getStartUrl() + "/welcome.jsp")
                .perform();

        TestUtils.assertTrue(currentPage instanceof WelcomePage && currentPage.waitForPage(DemoHomePage.class, 10L), "FAIL: Accessing welcome page without logging in does not take user back to home page");
    }
}
