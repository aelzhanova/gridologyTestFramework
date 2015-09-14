package framework.httpFactory;

/**
 * Класс связующий
 */
public class HttpClientManager {

    private static HttpClientManager singleton;

    public static HttpClientManager getInstance()
    {
        if (singleton == null)
            singleton = new HttpClientManager();
        return singleton;
    }
}
