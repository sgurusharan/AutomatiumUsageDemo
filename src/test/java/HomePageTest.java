import com.automatium.action.ActionChain;
import com.automatium.test.AutomatiumTest;
import org.junit.Test;
import page.DemoHomePage;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Created by Gurusharan on 21-05-2017.
 */
public class HomePageTest extends AutomatiumTest {

    @Override
    protected Class<DemoHomePage> getExpectedFirstPage() {
        return DemoHomePage.class;
    }

    @Test
    public void testInvalidLoginCredentials() {
        currentPage = ActionChain.start(currentPage)
                .pageAction("enter login email ID", "test@test.com")
                .pageAction("enter login password", "testPassword")
                .pageAction("click login button")
                .assertPageAction("is notification displayed", "Invalid login credentials")
                .perform();
    }

    @Test
    public void testInvalidRegistration() throws URISyntaxException {
        currentPage = ActionChain.start(currentPage)
                .fromFile(new File(getClass().getClassLoader().getResource("testInvalidRegistration1.csv").toURI()).getAbsolutePath())
                .fromFile(new File(getClass().getClassLoader().getResource("testInvalidRegistration2.xlsx").toURI()).getAbsolutePath())
                .perform();
    }
}
