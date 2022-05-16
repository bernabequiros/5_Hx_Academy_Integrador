package hexacta.pageObjects.BackOfficePlatform;

import hexacta.controls.Button;
import hexacta.controls.Checkbox;
import hexacta.controls.Link;
import hexacta.controls.TextBox;
import hexacta.pageObjects.BasePageObject;
import org.openqa.selenium.By;

public class RegisterNewUserPage extends BasePageObject {

    private By usernameField = By.id("usr");
    private By passwordField = By.id("pwd");
    private By logicaExamCheckbox = By.cssSelector("input[name='logica']");
    private By inglesExamCheckbox = By.cssSelector("input[name='ingles']");
    private By tecnicoExamCheckbox = By.cssSelector("input[name='tecnico']");
    private By testingExamCheckbox = By.cssSelector("input[name='testing']");
    private By testingTecnicoExamCheckbox = By.cssSelector("input[name='testingTecnico']");
    private By goBackButton = By.cssSelector("button[class='btn btn-outline']");
    private By createUserButton = By.cssSelector("button[ng-click='user.save()']");
    private By alertMessageText = By.cssSelector("p[ng-bind='user.message']");
    private By userCreatedText = By.cssSelector("strong[class='ng-binding']");

    public RegisterNewUserPage() {
        super(By.id("page-container"));
    }

    public void setUsernameField(String user) {
        waitUntil(() -> this.usernameFieldIsDisplayed());
        new TextBox(usernameField).write(user);
    }

    public boolean usernameFieldIsDisplayed() {
        boolean result = false;

        if (new TextBox(usernameField).isDisplayed()) {
            result = true;
        }
        return result;
    }

    public void setPasswordField(String password) {
        new TextBox(passwordField).write(password);
    }

    public void selectLogicalExam() {
        new Checkbox(logicaExamCheckbox).click();
    }

    public boolean logicalExamIsSelected() {
        return new Checkbox(logicaExamCheckbox).isSelected();
    }

    public void selectEnglishExam() {
        new Checkbox(inglesExamCheckbox).click();
    }

    public void selectTechnicalExam() {
        new Checkbox(tecnicoExamCheckbox).click();
    }

    public void selectTestingExam() {
        new Checkbox(testingExamCheckbox).click();
    }

    public void selectTestingTechnicalExam() {
        new Checkbox(testingTecnicoExamCheckbox).click();
    }

    public String getAlertMessage() {
        try {
            return new Link(alertMessageText).getText();

        } catch (Exception e) {
            return null;
        }
    }


    public void clickGoBackButton() {
        new Button(goBackButton).click();
    }

    public String getUserCreatedText() {
        try {
            return new Link(userCreatedText).getText();

        } catch (Exception e) {
            return null;
        }
    }

    public boolean clickSubmitButtonIsEnabled() {
        boolean result = false;

        if (new Button(createUserButton).isEnabled()) {
            new Button(createUserButton).click(); {
                result = true; }
            } 
        return result;
    }

    public void clickSubmitButton() {
        waitUntil(() -> this.clickSubmitButtonIsEnabled());
    }

}
