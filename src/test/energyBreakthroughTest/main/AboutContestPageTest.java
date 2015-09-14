package test.energyBreakthroughTest.main;

import framework.helpers.HelperValue;
import framework.module.energyBreakthrough.main.MainPageManager;

import framework.module.energyBreakthrough.main.pages.AboutContestManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.TestBase;

/**
 * Класс с тестами по странице "О конкурсе" главной страницы "Энергопрорыва"
 */
public class AboutContestPageTest extends TestBase implements HelperValue{

    private AboutContestManager aboutContestPage;

    @BeforeClass
    public void initialize()
    {
        aboutContestPage = AboutContestManager.getInstance();
    }

    @Test
    public void testOpenAboutContestPage()
    {
        aboutContestPage.openAboutContestPage();
        //проверки на наличие ссылок и что ссылки открываются корректно
    }
}
