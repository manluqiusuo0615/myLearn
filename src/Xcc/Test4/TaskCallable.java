package Xcc.Test4;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author 肖长路
 * @description
 * @date 2018年01月18日 17:40
 */
public class TaskCallable implements Callable<String> {
    private Person person;
    private Map<String,Person> personMap;

    TaskCallable(Person person,Map<String,Person> personMap){
        this.person = person;
        this.personMap = personMap;
    }
    @Override
    public String call() throws Exception {
        System.out.println("当前线程名称是：" + Thread.currentThread().getName());
        String ID = getID();
        person.setId(ID);
        personMap.put(ID,person);
        return ID;
    }

    /**
     * @description 随机8位数
     * @author 肖长路
     * @date 2018/1/18 17:48
     */
    private String getID(){
        StringBuffer stringBuffer = new StringBuffer();
        int ID = 0;
        for(int i=0;i<8;i++){
            ID = new Random().nextInt(10);
            stringBuffer.append(ID);
        }
        return stringBuffer.toString();
    }
}
