package framework.module.energyBreakthrough.main;

import framework.ApplicationManager;
import framework.helpers.BaseHelperForGridology;
import framework.module.energyBreakthrough.main.entities.MainPageLocator;
import org.testng.Assert;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;
/**
 * Класс-связующий для главной страницы
 */
public class MainPageManager extends BaseHelperForGridology {

    private static MainPageManager singleton;

    public MainPageManager(ApplicationManager app) {
        super(app);
    }

    public static MainPageManager getInstance()
    {
        if (singleton == null)
            singleton = new MainPageManager(ApplicationManager.getInstance());
        return singleton;
    }

    public void openMainPage()
    {
        app.getNavigationHelper().open(MainPageLocator.mainPage);
    }

    public void assertLinksExist(String path)
    {

    }
}
