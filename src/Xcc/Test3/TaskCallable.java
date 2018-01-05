package Xcc.Test3;

import java.util.concurrent.Callable;

/**
 * @author 肖长路
 * @description
 * @date 2018年01月04日 20:19
 */
public class TaskCallable implements Callable<String> {
    private int id;
    public TaskCallable(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        return "result of taskWithResult "+id;
    }
}
