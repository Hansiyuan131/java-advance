package filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author hansiyuan
 * @date 2022年03月20日 14:49
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("Authorization", "QXV0aG9yaXphdGlvbg==");
    }
}
