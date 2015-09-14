package framework.helpers;

import framework.ApplicationManager;
//import framework.httpFactory.DataGenerationManager;
import org.apache.log4j.Logger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * базовый хелпер, от него наследуются все хелперы. Он хранит ссылку на менеджера и тем самым сообщает всем потомкам,
 * где лежит менеджер. В этот хелпер следует помещать методы не связанные с селениумом или приложением. Например,
 * такие как: sleep() или getCurrentDate().
 */
public class BaseHelper
{
    protected final ApplicationManager app;
    protected static Logger log;

    public BaseHelper(ApplicationManager app)
    {
        this.app = app;
        log = app.getLogger();
    }

    /**
     * Останавливает выполнение на заданное количество секунд
     *
     * @param seconds задержка в секундах
     */
    public void sleep(double seconds)
    {
        try
        {
            Thread.sleep((long)seconds * 1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }


}