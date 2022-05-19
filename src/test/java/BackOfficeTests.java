import hexacta.pageObjects.BackOfficePlatform.RegisterNewUserPage;
import hexacta.pageObjects.BackOfficePlatform.HomeBackOffice;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BackOfficeTests extends BaseTest {
    protected String url = "http://hxv-evaluaciondev.backoffice.hexacta.com";

    @Before
    public void NavigateToBackOffice() {
        HomeBackOffice homeBackOffice = new HomeBackOffice();
        homeBackOffice.navigateTo(url);
    }

    @Test
    public void CreateNewUserWithNonTechnicalExamsAssociated() {
        HomeBackOffice homeBackOffice = new HomeBackOffice();
        homeBackOffice.clickOnCreateUserButton();
        RegisterNewUserPage registerNewUserPage = new RegisterNewUserPage();
        registerNewUserPage.setUsernameField("testingAcademy5.0.0");
        registerNewUserPage.setPasswordField("abc123");
        registerNewUserPage.selectLogicalExam();
        registerNewUserPage.selectEnglishExam();
        registerNewUserPage.clickSubmitButton();
        assertEquals("El usuario se registró correctamente", registerNewUserPage.getUserCreatedText());
    }

    @Test
    public void CreateNewUserWithTechnicalExamAssociated() {
        HomeBackOffice homeBackOffice = new HomeBackOffice();
        homeBackOffice.clickOnCreateUserButton();
        RegisterNewUserPage registerNewUserPage = new RegisterNewUserPage();
        registerNewUserPage.setUsernameField("testingAcademy5.0.1");
        registerNewUserPage.setPasswordField("abc123");
        registerNewUserPage.selectTechnicalExam();
        registerNewUserPage.clickSubmitButton();
        assertEquals("El usuario se registró correctamente", registerNewUserPage.getUserCreatedText());
    }

    @Test
    public void CreateNewUserWithTestingTechnicalExamAssociated() {
        HomeBackOffice homeBackOffice = new HomeBackOffice();
        homeBackOffice.clickOnCreateUserButton();
        RegisterNewUserPage registerNewUserPage = new RegisterNewUserPage();
        registerNewUserPage.setUsernameField("testingAcademy5.0.2");
        registerNewUserPage.setPasswordField("abc123");
        registerNewUserPage.selectTestingTechnicalExam();
        registerNewUserPage.clickSubmitButton();
        assertEquals("El usuario se registró correctamente", registerNewUserPage.getUserCreatedText());
    }

    @Test
    public void CreateNewUserWithTestingExamAssociated() {
        HomeBackOffice homeBackOffice = new HomeBackOffice();
        homeBackOffice.clickOnCreateUserButton();
        RegisterNewUserPage registerNewUserPage = new RegisterNewUserPage();
        registerNewUserPage.setUsernameField("testingAcademy5.0.3");
        registerNewUserPage.setPasswordField("abc123");
        registerNewUserPage.selectTestingExam();
        registerNewUserPage.clickSubmitButton();
        assertEquals("El usuario se registró correctamente", registerNewUserPage.getUserCreatedText());
    }

    @Test
    public void UnableToCreateANewUserWithoutAnyExamAssociated() {
        HomeBackOffice homeBackOffice = new HomeBackOffice();
        homeBackOffice.clickOnCreateUserButton();
        RegisterNewUserPage registerNewUserPage = new RegisterNewUserPage();
        registerNewUserPage.setUsernameField("testingAcademy5.0.X");
        registerNewUserPage.setPasswordField("abc123");
        registerNewUserPage.clickSubmitButton();
        assertEquals("Ha ocurrido un error: tiene que seleccionar al menos un test", registerNewUserPage.getAlertMessage());
    }

    @Test
    public void CreateButtonIsDisabled() {
        HomeBackOffice homeBackOffice = new HomeBackOffice();
        homeBackOffice.clickOnCreateUserButton();
        RegisterNewUserPage registerNewUserPage = new RegisterNewUserPage();
        assertFalse("Submit button is enabled.", registerNewUserPage.clickSubmitButtonIsEnabled());
        
    }

}
