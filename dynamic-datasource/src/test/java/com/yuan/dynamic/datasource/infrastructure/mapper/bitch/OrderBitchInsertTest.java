package com.yuan.dynamic.datasource.infrastructure.mapper.bitch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author hansiyuan
 * @date 2022年04月17日 18:06
 */
@SpringBootTest
@Slf4j
public class OrderBitchInsertTest {
    /**
     * 核心线程数
     */
    public static final int CORE = Math.max(Runtime.getRuntime().availableProcessors(), 36);
    /**
     * 单批次插入数据量
     */
    public static final int PAGE_SIZE = 28000;

    /**
     * 预计插入数据量 1000_0000
     */
    public static final int INSERT_TOTAL_COUNT = PAGE_SIZE * 36;
    //public static final int INSERT_TOTAL_COUNT = 1000_0000;

    @Test
    public void test() throws InterruptedException {
        // 创建线程池
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(CORE, CORE, 60,
                        TimeUnit.SECONDS, new LinkedBlockingQueue<>(2000), new OrderInsertTreadFactory());
        // 时间测试
        StopWatch stopWatch = new StopWatch("Test");
        stopWatch.start("order-insert");
        // 统计信息
        AtomicLong successfulNum = new AtomicLong(0);
        AtomicLong errorNum = new AtomicLong(0);
        // 执行
        long start = System.currentTimeMillis();
        doBitchInset(executor, successfulNum, errorNum);
        System.out.println(System.currentTimeMillis() - start);
        log.info("errorNum:{},sendNum:{}", errorNum, successfulNum);
        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        System.out.println(stopWatch.getTotalTimeMillis());
        // 关闭线程池
        executor.shutdown();
    }

    private static void doBitchInset(ThreadPoolExecutor executor, AtomicLong successfulNum, AtomicLong errorNum) throws InterruptedException {
        // 线程池单次可执行插入量
        int currentCount = CORE;
        // 总批次
        int totalBatch = getTotalBatch(INSERT_TOTAL_COUNT, PAGE_SIZE);
        // 总批次统计信息
        CountDownLatch totalBatchCount = new CountDownLatch(totalBatch);
        // 计算需发送批次
        int sendSum = (totalBatch / currentCount) + (totalBatch % currentCount == 0 ? 0 : 1);
        log.info("共需发送批次：" + sendSum + "，共需发送数据量：" + INSERT_TOTAL_COUNT);
        int surplusBatch = totalBatch;
        for (int i = 1; i <= sendSum; i++) {
            // 可执行批次计数
            int loopCount = currentCount;
            log.info("剩余批次：" + surplusBatch);
            if (surplusBatch <= currentCount) {
                loopCount = surplusBatch;
            }
            // 第一批执行数据量
            log.info("线程池单次执行批次:{}", loopCount);
            CountDownLatch loopBatchCount = new CountDownLatch(loopCount);
            for (int j = 1; j <= loopCount; j++) {
                TaskParams taskParams = new TaskParams();
                taskParams.setErrorNum(errorNum);
                taskParams.setSuccessfulNum(successfulNum);
                taskParams.setLoopBatchCount(loopBatchCount);
                taskParams.setTotalBatchCount(totalBatchCount);
                taskParams.setSize(PAGE_SIZE);
                executor.submit(new OrderBatchInsertTask(taskParams));
            }
            loopBatchCount.await();
            surplusBatch = surplusBatch - currentCount;
        }
        try {
            totalBatchCount.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int getTotalBatch(int insertTotalCount, int pageSize) {
        return (insertTotalCount / pageSize) + (insertTotalCount % pageSize == 0 ? 0 : 1);
    }
}
