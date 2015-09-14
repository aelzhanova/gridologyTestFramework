package framework.helpers;

import framework.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * отвечает за запуск и остановку браузера. В нем описывается какой браузер и как запускать.
 */
public class WebDriverHelper
{
    private static WebDriver driver;
    private static WebDriverWait wait;
    @SuppressWarnings ("unused")
    private final ApplicationManager app;

    /**
     * Инициализирует драйвер, выставляет время ожидания, максимально раскрывает окно.
     *
     * @param app ссылка на ApplicationaManager
     */
    public WebDriverHelper(ApplicationManager app)
    {
        this.app = app;
        String browser = app.getProperty("browser");
        switch (browser)
        {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                driver = new HtmlUnitDriver();
                break;
        }
        this.turnOnImplicitWaits();
        maximizeWindow();
    }

    // Включить таймаут
    protected void turnOnImplicitWaits()
    {

    }


    /**
     * Останавливает драйвер.
     */
    public void stop()
    {
        driver.quit();
    }

    /**
     * Возвращает ссылку на текущий драйвер.
     *
     * @return ссылка на драйвер
     */
    public WebDriver getDriver()
    {
        return driver;
    }

    private void maximizeWindow()
    {
        driver.manage().window().maximize();
    }

}