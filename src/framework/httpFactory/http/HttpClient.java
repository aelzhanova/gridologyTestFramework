package framework.httpFactory.http;

import framework.ApplicationManager;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import static org.testng.AssertJUnit.assertTrue;

/**
 * фабрика для создания httpClient
 */
public class HttpClient {

    private static CloseableHttpClient singleton;


    public static CloseableHttpClient getInstance() {
        if (singleton == null) {
            PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
            // Increase max total connection to 200
            cm.setMaxTotal(200);
            // Increase default max connection per route to 20
            cm.setDefaultMaxPerRoute(20);
            // Increase max connections for localhost:80 to 50
            HttpHost localhost = new HttpHost("locahost", 80);
            cm.setMaxPerRoute(new HttpRoute(localhost), 50);

            singleton = HttpClientBuilder.create()
                    .setRedirectStrategy(new LaxRedirectStrategy())
                    .setConnectionManager(cm)
                    .build();
        }
        return singleton;
    }

    public static void shutdown()
    {
        if (singleton != null)
        {
            getInstance().getConnectionManager().shutdown();
            singleton = null;
        }
    }

    private static void login()
    {
        Request requestHomePage = new Request(ApplicationManager.getInstance().getProperty("baseUrl")+"/");
        requestHomePage.executeGet();
    }

}
