package Xcc.Test4;

import com.sun.glass.ui.Size;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author 肖长路
 * @description
 * @date 2018年01月18日 17:37
 */
public class TaskTest {


    public static void main(String[] args) {
        ThreadPoolExecutor producerPool = new ThreadPoolExecutor(10,
                20, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(20),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        List<Future<String>> future = new ArrayList<Future<String>>();
        Map<String,Person> personMap = new HashMap<String, Person>();
        for(int i=0;i<10;i++){
            Person person = new Person();
            future.add(producerPool.submit(new TaskCallable(person,personMap)));
        }

        while(future.size()!=0){
            Iterator<Future<String>> futureIterator = future.iterator();
            while(futureIterator.hasNext()){
                Future<String> one = futureIterator.next();
                if(one.isDone()){
                    try {
                        System.out.println("======"+one.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    futureIterator.remove();
                }
            }
        }

        System.out.println("==========**********************===========");
        for (Map.Entry<String, Person> entry : personMap.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= "+entry.getValue());
        }
    }
}
