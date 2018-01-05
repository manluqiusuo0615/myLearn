package Xcc.TestCallable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author 肖长路
 * @description
 * @date 2018年01月04日 19:58
 */
public class TestCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<Callable<List<Long>>> tasks = new ArrayList<Callable<List<Long>>>();
        for (int i = 0; i < 10; i++) {
            Callable<List<Long>> task = new Callable<List<Long>>() {
                @Override
                public List<Long> call() throws Exception {
                    return Arrays.asList(1L,2L);
                }
            };

            tasks.add(task);
        }

        List<Long> finalResults = new ArrayList<Long>(10);
        List<Future<List<Long>>> results = ThreadPool.getThreadPool().invokeAll(tasks);
        for(Future<List<Long>> ele : results) {
            List<Long> list = ele.get();
            finalResults.addAll(list);
        }

        System.out.println(finalResults);
    }
}
