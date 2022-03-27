import java.util.concurrent.*;

/**
 * @author hansiyuan
 * @date 2022年03月27日 18:40
 */
public class ExampleV1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        ExecutorService exec = Executors.newFixedThreadPool(1);
        Future<Integer> fs = exec.submit(ExampleV1::sum);
        int result = fs.get();
        exec.shutdown();

        // 确保  拿到result 并输出
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
