package page;

import com.automatium.action.ActionChain;
import com.automatium.data.TestData;
import com.automatium.page.BaseHomePage;
import com.automatium.page.BasePage;
import org.openqa.selenium.By;

/**
 * Created by Gurusharan on 21-05-2017.
 */
public class DemoHomePage extends BaseHomePage {

    private static final TestData testData = TestData.getSingletonInstance();

    private static final String LOGIN_EMAIL = "loginEmail";
    private static final String LOGIN_PASSWORD = "loginPassword";
    private static final String FORGOT_PASSWORD_LINK = "forgotPasswordLink";
    private static final String LOGIN_BUTTON = "loginButton";
    private static final String LOGIN_CLEAR_BUTTON = "loginClearButton";
    private static final String REGISTER_EMAIL = "registerEmail";
    private static final String REGISTER_PASSWORD = "registerPassword";
    private static final String REGISTER_RE_PASSWORD = "registerRePassword";
    private static final String REGISTER_BUTTON = "registerButton";
    private static final String REGISTER_CLEAR_BUTTON = "registerClearButton";
    private static final String NOTIFICATION_DIV = "notificationDiv";

    @Override
    public void addLocators() {
        addLocator(LOGIN_EMAIL, By.id("loginEmail"));
        addLocator(LOGIN_PASSWORD, By.id("loginPassword"));
        addLocator(FORGOT_PASSWORD_LINK, By.linkText("Forgot password?"));
        addLocator(LOGIN_BUTTON, By.id("loginButton"));
        addLocator(LOGIN_CLEAR_BUTTON, By.xpath("//*[@id='loginForm']/descendants::input[@value='Clear']"));
        addLocator(REGISTER_EMAIL, By.id("registerEmail"));
        addLocator(REGISTER_PASSWORD, By.id("registerPassword"));
        addLocator(REGISTER_RE_PASSWORD, By.id("registerRePassword"));
        addLocator(REGISTER_BUTTON, By.id("registerButton"));
        addLocator(REGISTER_CLEAR_BUTTON, By.xpath("//*[@id='registerForm']/descendants::input[@value='Clear']"));
        addLocator(NOTIFICATION_DIV, By.id("notificationDiv"));
    }

    public String getNotifcationString() {
        return getTextInElement(NOTIFICATION_DIV);
    }

    public boolean isNotificationDisplayed(String expectedNotification) {
        try {
            return getNotifcationString().equalsIgnoreCase(expectedNotification);
        }
        catch (Exception e) {
            return false;
        }
    }

    public DemoHomePage enterLoginEmailID(String emailId) {
        type(LOGIN_EMAIL, emailId);
        return this;
    }

    public DemoHomePage enterLoginPassword(String password) {
        type(LOGIN_PASSWORD, password);
        return this;
    }

    public DemoHomePage clickForgotPasswordLink() {
        click(FORGOT_PASSWORD_LINK);
        return this;
    }

    public DemoHomePage clickLoginButton() {
        click(LOGIN_BUTTON);
        return this;
    }

    public DemoHomePage clickLoginClearButton() {
        click(LOGIN_CLEAR_BUTTON);
        return this;
    }

    public DemoHomePage enterRegistrationEmailID(String emailId) {
        clearAndType(REGISTER_EMAIL, emailId);
        return this;
    }

    public DemoHomePage enterRegistrationPassword(String password) {
        clearAndType(REGISTER_PASSWORD, password);
        return this;
    }

    public DemoHomePage enterRegistrationRePassword(String password) {
        clearAndType(REGISTER_RE_PASSWORD, password);
        return this;
    }

    public DemoHomePage clickRegisterButton() {
        click(REGISTER_BUTTON);
        return this;
    }

    public DemoHomePage clickRegisterClearButton() {
        click(REGISTER_CLEAR_BUTTON);
        return this;
    }

    public BasePage loginAsTestUser1() {

        ActionChain.start(this)
                .type(getLocator(LOGIN_EMAIL), testData.get("email1"))
                .type(getLocator(LOGIN_PASSWORD), testData.get("password1"))
                .click(getLocator(LOGIN_BUTTON))
                .perform();

        waitForPage(WelcomePage.class, 10L);

        return getCurrentPage();
    }

    @Override
    public boolean isAtPage() {
        return ( true
                && getTitle().equals("Automatium Demo")
        );
    }
}
