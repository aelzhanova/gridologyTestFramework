package framework.helpers;

import framework.ApplicationManager;
import org.openqa.selenium.By;

/**
 * отвечает за перемещения по приложению.
 */
public class NavigationHelper extends BaseHelperForGridology {

    public NavigationHelper(ApplicationManager app) {
        super(app);
    }

    /**
     * Открывает главную страницу приложения (и авторизуется)
     */
    public void openMainPage()
    {

    }

    /**
     * Открывает модуль по ссылке с главной страницы
     */
    public void open(String path)
    {
    }

    /**
     * Открывает спейс в модуле по нажатию на этот спейс
     */
    public void openTab(String path)
    {
    }
}
