package framework.helpers;

import framework.ApplicationManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 *  базовый хелпер, обертка над селениумом. Объединяет в себе методы, чтобы выполнять простые действия над приложением:
 *  click(), type(), findElement()… В него следует добавлять и другие методы по мере необходимости, которые расширяют
 *  возможности selenium. Здесь располагаются только «чистые» методы, без примеси приложения в виде локаторов.
 */
public class BaseHelperWithWebDriver extends BaseHelper
{
    private WebDriver driver;
    private Actions actions;
    private String type="Xpath";
    private int time = 5;

    public BaseHelperWithWebDriver(ApplicationManager app)
    {
        super(app);
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    /**
     * Возвращает найденный по локатору элемент
     *
     * @param by локатор элемента
     * @return найденный элемент
     */
    protected WebElement findElement(By by)
    {
    }

    /**
     * Кликаем по найденному по локатору элементу
     *
     * @param by локатор элемента
     */
    protected void click(By by)
    {
    }


    /**
     * Кликаем по найденному по элементу
     *
     * @param element элемент
     */
    protected void click(WebElement element)
    {
        highlightElement(element);
        element.click();
    }

    /**
     * Проверяет наличие элемента по локатору
     *
     * @param by локатор элемента
     */
    protected boolean isElementPresent(By by)
    {
        try
        {
            findElement(by);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    protected boolean isElementPresent(By by, WebElement parent)
    {

    }

    /**
     * Открывает заданный url
     *
     * @param url адрес страницы
     */
    public void openUrl(String url)
    {
        driver.get(url);
    }

    /**
     * Выполняет JavaScript для элемента
     *
     * @return результат выполнения javascriptа
     */
    protected Object executeJavaScript(String script, WebElement element)
    {

    }

    /**
     * Выполняет JavaScript
     *
     * @param script исполняемый javascript
     * @return результат выполнения javascriptа
     */
    protected Object executeJavaScript(String script)
    {
        return executeJavaScript(script, null);
    }

    /**
     * подсвечивает элемент, с которым работаешь
     * @param element
     */
    protected void highlightElement(WebElement element)
    {
    }


    /**
     * Ожидание завершения ajax на странице
     */
    protected void waitWhileAjaxCompleted() {

    }

    private boolean isAjaxCompleted() {
    }

    public void waitElementPresent(By by)
    {
    }


    public void waitElementIsClickable(By by)
    {
    }
}

