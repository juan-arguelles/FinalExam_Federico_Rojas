import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.inside.UserPage;
import pages.outside.AccessPage;
import pages.outside.WelcomePage;

public class TestLogOut extends TestBase
{
    private UserPage userPage;
    @BeforeMethod
    @Parameters({"email", "password"})
    public void beforeMethodLogIn(String email, String password)
    {
        this.getWelcomePage().goToOptions();
        AccessPage accessPage = this.getWelcomePage().goToAccess();
        userPage = accessPage.doLogin(email, password);
    }

    @Test
    @Parameters({"url"})
    public void logout(String url)
    {
        this.userPage.goToProfileOptions();
        WelcomePage welcomePage = this.userPage.doLogout(url);
        welcomePage.goToOptions();
        System.out.println(welcomePage.getWelcomeLabel());
        Assert.assertTrue(welcomePage.getWelcomeLabel().equals("Welcome!"), "He hasn't logout");
        log.info("LOG OUT TEST FINISHED");
    }
}
