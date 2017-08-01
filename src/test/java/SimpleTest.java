import com.automatium.action.ActionChain;
import com.automatium.logging.TestLogger;
import com.automatium.system.SystemCommand;
import com.automatium.test.BaseTest;
import org.junit.Test;
import page.DemoHomePage;

/**
 * Created by Gurusharan on 21-05-2017.
 */
public class SimpleTest extends BaseTest {

    @Override
    protected Class<DemoHomePage> getExpectedFirstPage() {
        return DemoHomePage.class;
    }

    @Test
    public void testSample1() throws InterruptedException {

        currentPage = ActionChain.start(currentPage)
                .pageAction("enter login email ID", "test@test.com")
                .pageAction("enter login password", "testPassword")
                .pageAction("click login button")
                .assertPageAction("is notification displayed", "Invalid login credentials")
                .perform();
    }
}
