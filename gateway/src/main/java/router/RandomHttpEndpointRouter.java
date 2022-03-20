package router;

import java.util.List;
import java.util.Random;

/**
 * @author hansiyuan
 * @date 2022年03月20日 14:52
 */
public class RandomHttpEndpointRouter implements HttpEndpointRouter {
    @Override
    public String route(List<String> urls) {
        int size = urls.size();
        Random random = new Random(System.currentTimeMillis());
        return urls.get(random.nextInt(size));
    }
}
