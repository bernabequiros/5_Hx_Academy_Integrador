import hexacta.pageObjects.InterviewPlatform.HomeInterviewPlatform;
import hexacta.pageObjects.InterviewPlatform.WelcomeUserPage;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class InterviewPlatformTests extends BaseTest {

    protected String url = "http://hxv-evaluaciondev.interview.hexacta.com";

    @Before
    public void NavigateToInterviewPlatform() {
        HomeInterviewPlatform homeInterviewPlatform = new HomeInterviewPlatform();
        homeInterviewPlatform.navigateTo(url);
    }

    @Test
    public void LoginWithPendingExams() {
        HomeInterviewPlatform homeInterviewPlatform= new HomeInterviewPlatform();
        homeInterviewPlatform.setUsernameField("testingAcademy4.0");
        homeInterviewPlatform.setPasswordField("abc123");
        homeInterviewPlatform.clickSubmitButton();
        WelcomeUserPage welcomeUserPage = new WelcomeUserPage();
        assertEquals("Bienvenido a nuestro proceso de selección!", welcomeUserPage.getWelcomeText());  
    }

    @Test
    public void LoginSettingBlankFields() {
        HomeInterviewPlatform homeInterviewPlatform = new HomeInterviewPlatform();
        homeInterviewPlatform.clickSubmitButton();
        assertEquals("Ha ocurrido un error: Invalid login", homeInterviewPlatform.getInvalidLoginMessage());
    }

    @Test
    public void LoginWithoutPendingExams() {
        HomeInterviewPlatform homeInterviewPlatform = new HomeInterviewPlatform();
        homeInterviewPlatform.setUsernameField("testingAcademyPQ");
        homeInterviewPlatform.setPasswordField("abc123");
        homeInterviewPlatform.clickSubmitButton();
        assertEquals("Ha ocurrido un error: Ya se completaron todos los examenes", homeInterviewPlatform.getInvalidLoginMessage());
    }

    @Test
    public void LoginWithInvalidCredentials() {
        HomeInterviewPlatform homeInterviewPlatform = new HomeInterviewPlatform();
        homeInterviewPlatform.setUsernameField("INVALIDCREDENTIAL010101");
        homeInterviewPlatform.setPasswordField("INVALIDPASSWORS010101");
        homeInterviewPlatform.clickSubmitButton();
        assertEquals("Ha ocurrido un error: Invalid login", homeInterviewPlatform.getInvalidLoginMessage());
    }

}
