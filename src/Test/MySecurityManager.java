package Test;

import java.io.FileInputStream;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-20 13:45
 */
public class MySecurityManager extends SecurityManager{
    @Override
    public void checkRead(String file) {
        if (file.endsWith("test")){
            throw new SecurityException("你没有读取的本文件的权限");
        }
    }

    public static void main(String[] args) {
        //System.setSecurityManager(new MySecurityManager());
        //这个是安装安全管理器的另外一种方法
        System.setSecurityManager(new MySecurityManager());
        try{
            FileInputStream fis = new FileInputStream("test");
            System.out.println(fis.read());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
