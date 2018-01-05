package Xcc.Test3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author 肖长路
 * @description
 * @date 2018年01月04日 20:20
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        List<TaskCallable> list = new ArrayList<TaskCallable>();
        for(int i = 0 ; i < 10 ;i++){
            list.add(new TaskCallable(i));
        }
        //线程执行完成后的结果
        List<Future<String>> results = exec.invokeAll(list,10,TimeUnit.SECONDS);

        System.out.println("*****"+results.size());
        for(int i=0;i<results.size();i++){
            while(!results.get(i).isDone()){}
            System.out.println("======"+results.get(i).get());
        }

    }
}
