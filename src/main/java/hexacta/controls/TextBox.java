package hexacta.controls;

import org.openqa.selenium.By;

public class TextBox extends Button {
    public TextBox(By locator) {
        super(locator);
    }

    public void write(String text) {
        this.webElement().clear();
        this.webElement().sendKeys(text);
    }
}