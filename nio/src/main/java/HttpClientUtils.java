import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author hansiyuan
 * @date 2022年03月13日 16:09
 */
@Slf4j
public class HttpClientUtils {
    public static final CloseableHttpClient httpClient;
    public static final int CONNECT_TIMEOUT = 50000;
    public static final int REQUEST_TIMEOUT = 50000;
    public static final int SOCKET_TIMEOUT = 50000;

    static {
        //创建定制http客户端
        httpClient = HttpClients.custom().build();
    }

    public static RequestConfig getRequestConfig(Integer connectTimeout, Integer requestTimeout, Integer socketTimeout) {
        // 连接主机服务超时时间
        connectTimeout = (connectTimeout == null ? CONNECT_TIMEOUT : connectTimeout);
        // 连接请求超时时间
        requestTimeout = (requestTimeout == null ? REQUEST_TIMEOUT : requestTimeout);
        // 读取数据连接超时时间
        socketTimeout = (socketTimeout == null ? SOCKET_TIMEOUT : socketTimeout);

        return RequestConfig.custom().setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(requestTimeout)
                .setSocketTimeout(socketTimeout).build();
    }

    public static Object doGet(String url) {
        return doGet(url, null, null, null);
    }

    public static Object doGet(String url, Integer connectTimeout, Integer requestTimeout, Integer socketTimeout) {
        CloseableHttpResponse response = null;
        try {
            // 创建httpGet远程连接实例
            HttpGet httpGet = new HttpGet(url);
            // 设置配置请求参数
            RequestConfig requestConfig = getRequestConfig(connectTimeout, requestTimeout, socketTimeout);
            // 为httpGet实例设置配置
            httpGet.setConfig(requestConfig);
            // 执行get请求得到返回对象
            response = httpClient.execute(httpGet);
            String result = EntityUtils.toString(response.getEntity(), "UTF-8");
            EntityUtils.consume(response.getEntity());
            return result;
        } catch (IOException e) {
            log.error("调用HttpClientUtils.doGet()异常", e);
        } finally {
            // 关闭资源
            if (null != response) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
