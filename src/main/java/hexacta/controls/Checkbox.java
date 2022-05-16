package hexacta.controls;

import org.openqa.selenium.By;

public class Checkbox extends BaseControl {
    public Checkbox(By locator) {
        super(locator);
    }

    public void click() {
        this.webElement().click();
    }

    public boolean isSelected() {
        if (this.webElement().isSelected()) {
            return true;
        } else {
            return false;
        }
    }

}
