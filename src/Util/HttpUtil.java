package Util;

import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;

/**
 * @author lenovo2
 */
public class HttpUtil {

    public static void proxyNoAuth(String proxyIpPort, String webUrl) {
        String proxy_ip = proxyIpPort.split(":")[0];
        Integer proxy_port = Integer.valueOf(proxyIpPort.split(":")[1]);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpHost httpHost = new HttpHost(proxy_ip, proxy_port);

        HttpGet request = new HttpGet(webUrl);
        request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:69.0) Gecko/20100101 Firefox/69.0");

        try {
            System.out.println(EntityUtils.toString(client.execute(request).getEntity()));
            CloseableHttpResponse response = client.execute(httpHost, request);
            System.out.println(response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String result = response.getEntity().toString();
                System.out.println(result);
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
