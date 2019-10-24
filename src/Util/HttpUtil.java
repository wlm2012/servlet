package Util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;


/**
 * @author lenovo2
 */
public class HttpUtil {

    public static String proxyNoAuth(String webUrl) {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(webUrl);
        request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:69.0) Gecko/20100101 Firefox/69.0");
        request.setConfig(RequestConfig.custom().setProxy(new HttpHost("127.0.0.1", 1081, "http")).build());
        String result = "";
        try {
            System.out.println(EntityUtils.toString(client.execute(request).getEntity()));
            CloseableHttpResponse response = client.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity());
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
