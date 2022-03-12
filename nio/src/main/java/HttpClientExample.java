import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author hansiyuan
 * @date 2022年03月12日 23:35
 */
@Slf4j
public class HttpClientExample {
    public static void main(String[] args) {
        invoke();
    }

    public static String invoke() {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String url = "https://www.baidu.com";
            log.info(url);
            HttpGet httpGet = new HttpGet(url);
            String responseBody = httpClient.execute(httpGet, httpResponse -> {
                int status = httpResponse.getStatusLine().getStatusCode();
                if (status < 200 || status >= 300) {
                    log.warn("unsuccessful request");
                }
                HttpEntity entity = httpResponse.getEntity();
                return entity != null ? EntityUtils.toString(entity) : null;
            });
            log.info(String.valueOf(responseBody));
            return responseBody;

        } catch (IOException e) {
            log.error("invoke exception", e);
            return null;
        }
    }

}

