package Xcc.Test2;

import java.io.Serializable;

/**
 * @author 肖长路
 * @description
 * @date 2018年01月04日 20:09
 */
public class ThreadPoolTask implements Runnable,Serializable {

    private Object threadPoolTaskData;
    private static int produceTaskSleepTime = 10000;

    public ThreadPoolTask(Object threadPoolTaskData) {
        super();
        this.threadPoolTaskData = threadPoolTaskData;
    }

    @Override
    public void run() {
        System.out.println("start..."+threadPoolTaskData);
        try {
            System.out.println("模拟线程正在执行任务");
            Thread.sleep(produceTaskSleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("stop..."+threadPoolTaskData);
        threadPoolTaskData = null;
    }

    public Object getTask(){
        return this.threadPoolTaskData;
    }
}
