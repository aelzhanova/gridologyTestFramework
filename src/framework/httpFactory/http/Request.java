package framework.httpFactory.http;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import framework.ApplicationManager;

import java.net.URI;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Класс для работы с request
 */
public class Request {

    private static ApplicationManager app = ApplicationManager.getInstance();
    CloseableHttpClient httpClient = HttpClient.getInstance();

    private URIBuilder builder = new URIBuilder();
    private static HttpContext basicContext = new BasicHttpContext();

    private URI uri;

    public Request(String url)
    {
        try
        {
            this.uri = new URI(url);
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
    }

    public Response executeGetWithoutStatusAssertion(HttpContext context)
    {
        HttpGet httpget = new HttpGet(uri);
        Response resp = new Response(uri);
        try
        {
            resp.setMethod(httpget.getMethod());
            long startTime = System.currentTimeMillis();
            HttpResponse response = httpClient.execute(httpget, context);
            long finishTime =  System.currentTimeMillis() - startTime;
            resp.setResponseTime(finishTime);
            resp.setUrlAfterRedirects(context);
            resp.setPageHtml(response);
            resp.setStatusCode(response.getStatusLine().getStatusCode());
        }
        catch(Exception e)  {
            assertTrue("Execute get error!" + e.getMessage() + "\nUrl = " + uri.toString(), false);
        }
        finally
        {
            httpget.releaseConnection();
        }
        return resp;
    }


    public Response executeGet()
    {
        return executeGet(basicContext);
    }

    public Response executeGet(HttpContext context)
    {
        Response response = executeGetWithoutStatusAssertion(context);
        response.assertStatusCode(HttpStatus.SC_UNAUTHORIZED);
        return response;
    }

}
