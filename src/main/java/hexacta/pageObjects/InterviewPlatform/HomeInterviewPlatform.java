package hexacta.pageObjects.InterviewPlatform;

import hexacta.controls.Button;
import hexacta.controls.Link;
import hexacta.controls.TextBox;
import hexacta.pageObjects.BasePageObject;

import org.openqa.selenium.By;

public class HomeInterviewPlatform extends BasePageObject {

    private By userField = By.id("log-usuario");
    private By passwordField = By.id("log-pwd");
    private By invalidLoginMessage = By.cssSelector("div.alert.alert-danger.ng-binding");
    private By submitButton = By.cssSelector("button.btn.btn-default.boton-ingreso");

    public HomeInterviewPlatform() {
        super(By.cssSelector("body[class='ng-scope']"));
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void setUsernameField(String user) {
        new TextBox(userField).write(user);
    }

    public void setPasswordField(String password) {
        new TextBox(passwordField).write(password);
    }

    public void clickSubmitButton() {
        new Button(submitButton).click();
    }



public String getInvalidLoginMessage() {
    
    waitUntil(() -> new Link(invalidLoginMessage).isDisplayed()? true : false);
    
    try {
        return new Link(invalidLoginMessage).getText();
        
    } catch (Exception e) {
        return null; 
    }
}


}

