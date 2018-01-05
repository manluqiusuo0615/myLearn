package Xcc.TestCallable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 肖长路
 * @description
 * @date 2018年01月04日 19:58
 */
public class ThreadPool {
    /**
     * 线程池维护线程的最少数量
     */
    private static final int CORE_SIZE = 8;
    /**
     * 线程池维护线程的最大数量
     */
    private static final int MAX_SIZE = 12;
    /**
     * 线程池维护线程所允许的空闲时间
     */
    private static final long KEEP_ALIVE_TIME = 30;
    /**
     * 线程池维护线程所允许的空闲时间的单位
     */
    private static final TimeUnit SECONDS = TimeUnit.SECONDS;
    /**
     * 线程池所使用的缓冲队列
     */
    private static final int QUEUE_SIZE = 50000;

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            CORE_SIZE,
            MAX_SIZE,
            KEEP_ALIVE_TIME,
            SECONDS,
            new ArrayBlockingQueue<Runnable>(QUEUE_SIZE),
            new ThreadPoolExecutor.AbortPolicy());

    public static ThreadPoolExecutor getThreadPool() {
        return threadPool;
    }
}
