package com.yuan.dynamic.datasource.infrastructure.mapper;

import org.springframework.util.StopWatch;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: 订单批量插入线程池
 * @author: hansiyuan
 * @date: 2022/4/17 5:51 PM
 */
public class OrderBitchInsertThreadPool {
    public static final int CORE = Math.min(Runtime.getRuntime().availableProcessors(), 16); // 12
    public static final int PAGE_SIZE = 100;

    static class NameTreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "order-insert-" + mThreadNum.getAndIncrement());
        }
    }

    public static void main(String[] args) throws Exception {
        extracted();
    }

    private static void extracted() throws InterruptedException {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(CORE, CORE * 2, 60,
                        TimeUnit.SECONDS, new LinkedBlockingQueue<>(CORE * 4 * 16), new NameTreadFactory());
        // 时间测试
        StopWatch stopWatch = new StopWatch("Test");
        stopWatch.start("send");
        // 统计信息
        AtomicLong successfulNum = new AtomicLong(0);
        AtomicLong errorNum = new AtomicLong(0);
        // 任务参数配置
        int currentCount = CORE;
        int count = PAGE_SIZE * currentCount * 10;
        int pageSize = PAGE_SIZE;
        int totalPage = (count / pageSize) + (count % pageSize == 0 ? 0 : 1);
        // 总页码统计信息
        CountDownLatch totalPageCount = new CountDownLatch(totalPage);
        // 计算需发送批次
        int sendSum = (totalPage / currentCount) + (totalPage % currentCount == 0 ? 0 : 1);
        System.out.println("共需发送批次：" + sendSum + "，共需发送数据量：" + count);
        Thread.sleep(3000);
        int surplusPage = totalPage;
        System.out.println("========" + executor.getActiveCount());
        for (int i = 1; i <= sendSum; i++) {
            int loopCount = currentCount;
            System.out.println("剩余页数：" + surplusPage);
            if (surplusPage <= currentCount) {
                loopCount = surplusPage;
            }
            // 第一批执行数据量
            System.out.println("第" + i + "批发送页数量：" + loopCount);
            CountDownLatch batchPageCount = new CountDownLatch(loopCount);
            for (int j = 1; j <= loopCount; j++) {
                TaskParams taskParams = new TaskParams();
                taskParams.setErrorNum(errorNum);
                taskParams.setSuccessfulNum(successfulNum);
                taskParams.setPageNum(j + currentCount * (i - 1));
                taskParams.setBatchPageCount(batchPageCount);
                taskParams.setTotalPageCount(totalPageCount);
                taskParams.setSize(pageSize);
                executor.submit(new OrderBatchInsertTask(taskParams));
            }
            batchPageCount.await();
            surplusPage = surplusPage - currentCount;
        }
        try {
            totalPageCount.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println("errorNum " + errorNum);
        System.out.println("sendNum " + successfulNum);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(stopWatch.getTotalTimeSeconds());
    }
}
