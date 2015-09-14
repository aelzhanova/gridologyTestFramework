package framework.helpers;

/**
 * Created by alsu on 7/31/2015.
 */
import com.google.common.base.Function;
import framework.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * базовый хелпер, объединяет в себе методы для работы с приложением gridology. В него следует добавлять обработку
 * типовых контролов, типовых способов заполнения форм и прочего, что связано с приложением (в виде локаторов).
 */
public class BaseHelperForGridology extends BaseHelperWithWebDriver implements HelperValue
{

    private static String XPATH_FORMAT = "strong[contains(text(),'%s')]";

    protected String value;

    public BaseHelperForGridology(ApplicationManager app)
    {
        super(app);
    }

    public String getInputValue(By by)
    {
    }

    public void pressButton(By by)
    {
    }

    protected void clickWithoutWait(By by)
    {
    }


    /**
     * Переход по указанной ссылке
     *
     * @param path ссылка, по которой осуществляется переход
     */
    protected void clickLink(String path)
    {
    }



}