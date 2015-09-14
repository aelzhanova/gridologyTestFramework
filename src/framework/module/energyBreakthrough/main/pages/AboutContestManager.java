package framework.module.energyBreakthrough.main.pages;

import framework.ApplicationManager;
import framework.module.energyBreakthrough.main.MainPageManager;
import framework.module.energyBreakthrough.main.entities.MainPageLocator;
import framework.module.energyBreakthrough.main.pages.aboutContest.entities.AboutContestLocator;
import org.testng.Assert;

/**
 * Класс-связующий для работы с классами для страницы "О конкурсе"
 */
public class AboutContestManager extends MainPageManager{

    private static AboutContestManager singleton;

    public AboutContestManager(ApplicationManager app) {
        super(app);
    }

    public static AboutContestManager getInstance()
    {
        if (singleton == null)
            singleton = new AboutContestManager(ApplicationManager.getInstance());
        return singleton;
    }

    public void openAboutContestPage()
    {
        openMainPage();
        app.getNavigationHelper().open(AboutContestLocator.aboutContestPage);
    }

    public void assertAllLinksExist()
    {
//        проверка, что все ссылки на странице есть
    }
}
