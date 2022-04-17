import java.util.concurrent.*;

/**
 * @author: hansiyuan
 * @date: 2022/3/28 7:50 PM
 */
public class ExampleV3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(ExampleV3::sum);
        int result = future.get();

        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}
