package Xcc.Test3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 肖长路
 * @description
 * @date 2018年01月04日 20:56
 */
public class Main1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        //线程执行完成后的结果
        List<Future<String>> results = new ArrayList<Future<String>>();
        for(int i = 0 ; i < 10 ;i++){
            //submit返回一个Future，代表了即将要返回的结果
            results.add(exec.submit(new TaskCallable(i)));
        }

        System.out.println("*****"+results.size());

        for(int i=0;i<results.size();i++){
            while(!results.get(i).isDone()){}
            System.out.println("======"+results.get(i).get());
        }
    }
}
