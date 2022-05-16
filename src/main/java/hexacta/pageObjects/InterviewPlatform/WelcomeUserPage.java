package hexacta.pageObjects.InterviewPlatform;

import org.openqa.selenium.By;

import hexacta.controls.Button;
import hexacta.controls.Link;
import hexacta.pageObjects.BasePageObject;

public class WelcomeUserPage extends BasePageObject {

    private By usernameText = By.className("data-user");

    private By welcomeText = By.className("h6-seccion");

    private By logOutButton = By.className("log-out");

    public WelcomeUserPage() {
        super(By.id("page-container"));
    }

    public String getUsernameText() {
        try {
            return new Link(usernameText).getText();

        } catch (Exception e) {
            return null;
        }
    }

    public String getWelcomeText() {
        try {
            return new Link(welcomeText).getText();

        } catch (Exception e) {
            return null;
        }
    }

    public void logOut() {
        new Button(logOutButton).click();
    }

}
