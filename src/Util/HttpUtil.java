package Util;

import Entity.svraddr;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
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
import java.text.RuleBasedCollator;


/**
 * @author lenovo2
 */
public class HttpUtil {

    public static String proxyNoAuth(String webUrl) throws IOException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(webUrl);
        request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:69.0) Gecko/20100101 Firefox/69.0");
        request.setConfig(RequestConfig.custom().setProxy(new HttpHost("127.0.0.1", 1081, "http")).build());
        String result = "";

        System.out.println(EntityUtils.toString(client.execute(request).getEntity()));
        CloseableHttpResponse response = client.execute(request);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            result = EntityUtils.toString(response.getEntity());
        }
        client.close();

        return result;
    }

    public static String postToTest(String svrName, Integer num) throws IOException {

        String url = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://172.17.17.13:18090/msagent/service/svraddr");
        StringEntity entity = null;

        entity = new StringEntity("{\n" +
                "    \"SeqNo\": \"123456\",\n" +
                "    \"Token\": \"c1cb11d5c57e4298bace55dd8d75fb4a\",\n" +
                "    \"Tenant\": \"head\",\n" +
                "    \"DyncParam\": {},\n" +
                "    \"PartId\": \"QDGJJ\",\n" +
                "    \"SvrName\": \"" + svrName + "\"\n" +
                "}");

        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:69.0) Gecko/20100101 Firefox/69.0");
        httpPost.setEntity(entity);


        HttpResponse response = httpClient.execute(httpPost);
        String result = EntityUtils.toString(response.getEntity());

        Gson gson = new Gson();
        svraddr svraddr = gson.fromJson(result, svraddr.class);
        if (svraddr.getRetCode().equals("SUCCESS")) {
            url = svraddr.getCOM_HTTP().getURL();
            url = url.substring(0, 17) + num + url.substring(18) + "/" + svrName;
        } else {
            url = svraddr.getRetCode();
        }


        return url;
    }

    public static String Post(String url, String param) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = null;

        entity = new StringEntity(param);

        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:69.0) Gecko/20100101 Firefox/69.0");
        httpPost.setEntity(entity);
        String result = "";

        HttpResponse httpResponse = httpClient.execute(httpPost);
        result = EntityUtils.toString(httpResponse.getEntity());
        result = JsonUtil.toPrettyFormat(result);

        return result;
    }
}
