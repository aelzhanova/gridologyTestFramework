package framework.httpFactory.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.net.URI;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Класс для работы с response
 */
public class Response {

    private URI uri;

    private long responseTime;
    private String method;
    private int statusCode;
    private String pageHtml;
    private String urlAfterRedirects;

    public Response(URI uri)
    {
        this.uri = uri;
    }

    public void setResponseTime(long responseTime)
    {
        this.responseTime = responseTime;
    }

    /**
     * Время ответа
     */
    public long getResponseTime()
    {
        return this.responseTime;
    }

    public void setMethod(String method)
    {
        this.method = method;
    }


    public void setStatusCode(int code)
    {
        this.statusCode = code;
    }

    /**
     * Возвращает содержимое страницы
     */
    public String getPageHtml()
    {
        return this.pageHtml;
    }

    /**
     *   Сохраняет содержимое страницы
     */
    public void setPageHtml(HttpResponse response)
    {
        try
        {
            String pagehtml;
            HttpEntity entity = response.getEntity();
            pagehtml = EntityUtils.toString(entity);
            //assertTrue("Error getting page html. Status code is " + getStatusCode() , pagehtml!=null);
            this.pageHtml = pagehtml;
        }
        catch(Exception e)  {
            System.err.println(e);
        }
    }

    /**
     * Возвращает URL  -  результат запроса с автоматическим переходом по редиректам
     */
    public String getUrlAfterRedirects()
    {
        return this.urlAfterRedirects;
    }

    /**
     *  Сохраняет URL после преехода по всем редиректам
     */
    public void setUrlAfterRedirects(HttpContext context)
    {
        HttpUriRequest request = (HttpUriRequest) context.getAttribute(ExecutionContext.HTTP_REQUEST);
        this.urlAfterRedirects = uri.getScheme() +"://" + uri.getHost() + request.getURI().toString();
    }

    /**
     *  Проверка, что код ответа соответствует ожидаемому
     */
    public void assertStatusCode(int expectedStatusCode)
    {
        assertTrue("\nStatus code is: " + this.statusCode
                        + "\nExpected: " + expectedStatusCode
                        + "\n Method: " + this.method
                        + "\n Url: " + this.urlAfterRedirects,
                this.statusCode==expectedStatusCode);
    }


}
