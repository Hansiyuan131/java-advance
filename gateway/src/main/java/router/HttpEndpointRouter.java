package router;

import java.util.List;

/**
 * @author hansiyuan
 * @date 2022年03月20日 14:51
 */
public interface HttpEndpointRouter {
    String route(List<String> endpoints);

// Load Balance
// Random
// RoundRibbon
// Weight
// - server01,20
// - server02,30
// - server03,50
}
