package framework.component;

import framework.ApplicationManager;
import framework.helpers.BaseHelperForGridology;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Класс для работы с компонентом InputText
 */
public class InputText extends BaseHelperForGridology
{
    private By by;

    public InputText(ApplicationManager app)
    {
        super(app);
    }

    public InputText(ApplicationManager app, By by)
    {
        super(app);
        this.by = by;
    }

    public WebElement takeInputText()
    {
        return findElement(by);
    }

    /**
     * Получение значения
     * @return значение
     */
    public String getValue()
    {
        return takeInputText().getAttribute("value");
    }

    /**
     * Установка значения
     * @param value значение, которое надо установить
     */
    public void setValue(String value)
    {
        WebElement field = takeInputText();
        field.click();
        field.clear();
        field.sendKeys(value);
    }

}
