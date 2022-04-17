import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.CountDownLatch;

/**
 * @author: hansiyuan
 * @date: 2022/3/28 8:00 PM
 */
@Data
public class ExampleV4 {
    private volatile Integer result = 0;
    private CountDownLatch count = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();
        ExampleV4 exampleV4 = new ExampleV4();
        new MyThread(exampleV4).start();
        exampleV4.getCount().await();
        int result = exampleV4.getResult();

        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }


    public static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}

@AllArgsConstructor
class MyThread extends Thread {
    private ExampleV4 exampleV4;

    @Override
    public void run() {
        exampleV4.setResult(ExampleV4.sum());
        exampleV4.getCount().countDown();
    }
}
