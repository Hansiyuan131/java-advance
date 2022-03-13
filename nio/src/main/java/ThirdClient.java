/**
 * @author hansiyuan
 * @date 2022年03月13日 16:25
 */
public class ThirdClient {
    public static void main(String[] args) {
        String entity = (String) HttpClientUtils.doGet("https://www.baidu.com");
        System.out.println(entity);
    }
}
