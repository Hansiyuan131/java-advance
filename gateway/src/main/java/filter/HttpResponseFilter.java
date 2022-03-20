package filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * @author hansiyuan
 * @date 2022年03月20日 14:50
 */
public interface HttpResponseFilter {

    void filter(FullHttpResponse response);

}
