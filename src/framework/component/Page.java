package framework.component;

import framework.ApplicationManager;
import framework.helpers.BaseHelperForGridology;
import framework.helpers.HelperValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Класс для работы со страницей
 */
public abstract class Page extends BaseHelperForGridology implements HelperValue{

    public Page(ApplicationManager app)
    {
        super(app);
    }

    protected InputText getInputText(By by)
    {
        return new InputText(app, by);
    }



    public boolean isLinkPresent(By by)
    {
        return isElementPresent(by);
    }

}
