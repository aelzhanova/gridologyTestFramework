package framework;

//import framework.component.PatientInfoPanel;
import framework.helpers.NavigationHelper;
import framework.helpers.WebDriverHelper;
//import framework.module.services.ServiceModuleManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

/**
 * Класс связующий между классами-помощниками
 */
public class ApplicationManager
{
    private static ApplicationManager singleton;
    private Properties props;
    private static Logger log;

    private WebDriverHelper webDriverHelper;
    private NavigationHelper navigationHelper;

    public static ApplicationManager getInstance()
    {
        return getInstance(null);
    }

    public static ApplicationManager getInstance(String configFile)
    {
        if (singleton == null)
            singleton = new ApplicationManager();
        log = Logger.getLogger("framework");
        log.trace(new File(".").getAbsolutePath());
        log.trace("configFile = " + configFile);
        if (configFile != null)
            singleton.setProperties(loadProperties(configFile));
        return singleton;
    }

    public void setProperties(Properties props)
    {
        this.props = props;
    }

    public String getProperty(String key)
    {
        return props.getProperty(key);
    }

    public String getProperty(String key, String defaultValue)
    {
        return props.getProperty(key, defaultValue);
    }

    public int getIntProperty(String key)
    {
        return Integer.parseInt(getProperty(key));
    }

    public int getIntProperty(String key, String defaultValue)
    {
        return Integer.parseInt(getProperty(key, defaultValue));
    }

    private static Properties loadProperties(String configFile)
    {
        Properties props = new Properties();
        try
        {
            props.load(new FileReader(configFile));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return props;
    }

    public Logger getLogger()
    {
        return log;
    }

    public void stop()
    {
        if (webDriverHelper != null)
            webDriverHelper.stop();
    }

    public WebDriverHelper getWebDriverHelper()
    {
        if (webDriverHelper == null)
            webDriverHelper = new WebDriverHelper(this);
        return webDriverHelper;
    }

    public NavigationHelper getNavigationHelper()
    {
        if (navigationHelper == null)
            navigationHelper = new NavigationHelper(this);
        return navigationHelper;
    }
}
