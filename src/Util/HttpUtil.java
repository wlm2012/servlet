package Util;

import Entity.svraddr;
import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


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

    public static String postToTest(String svrName) {

        String url = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://172.17.17.13:18090/msagent/service/svraddr");
        StringEntity entity = null;
        try {
            entity = new StringEntity("{\n" +
                    "    \"SeqNo\": \"123456\",\n" +
                    "    \"Token\": \"c1cb11d5c57e4298bace55dd8d75fb4a\",\n" +
                    "    \"Tenant\": \"head\",\n" +
                    "    \"DyncParam\": {},\n" +
                    "    \"PartId\": \"QDGJJ\",\n" +
                    "    \"SvrName\": \"" + svrName + "\"\n" +
                    "}");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:69.0) Gecko/20100101 Firefox/69.0");
        httpPost.setEntity(entity);

        try {
            HttpResponse response = httpClient.execute(httpPost);
            String result = EntityUtils.toString(response.getEntity());
//            System.out.println(result);
            Gson gson = new Gson();
            url = gson.fromJson(result, svraddr.class).getCOM_HTTP().getURL();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }
}
