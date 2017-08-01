import com.automatium.action.ActionChain;
import com.automatium.test.AutomatiumTest;
import org.junit.Test;
import page.DemoHomePage;

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
    public void testInvalidRegistration() {
        currentPage = ActionChain.start(currentPage)
                .pageAction("enter registration email ID", "abc@abc")
                .pageAction("enter registration password", "testPassword")
                .pageAction("enter registration rePassword", "testPassword")
                .pageAction("click register button")
                .assertPageAction("is notification displayed", "Please enter a valid email ID")
                .pageAction("enter registration email ID", "abc@abc.com")
                .pageAction("enter registration password", "testPassword1")
                .pageAction("click register button")
                .assertPageAction("is notification displayed", "Passwords do not match")
                .pageAction("enter registration password", "abcdefg")
                .pageAction("enter registration rePassword", "abcdefg")
                .pageAction("click register button")
                .assertPageAction("is notification displayed", "Password should be atleast 8 characters long")
                .pageAction("enter registration email ID", "abc@xyz.com")
                .pageAction("enter registration password", "testPassword")
                .pageAction("enter registration rePassword", "testPassword")
                .pageAction("click register button")
                .assertPageAction("is notification displayed", "Email ID already taken - please try logging in")
                .perform();
    }
}
