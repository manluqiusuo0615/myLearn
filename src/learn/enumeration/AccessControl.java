package learn.enumeration;

/**
 * @author 肖长路
 * @Description 枚举是一个离散的概念
 * 而且规定了这个类,只能有这么几个实例
 * 就是对于某个方法参数只接受那么几个有限的参数值
 * @create 2017-09-18 13:50
 */
public class AccessControl {

    public static boolean checkRight(AccessRight accessRight){
        if(accessRight == AccessRight.MANAGER){
            return true;
        }else if(accessRight==AccessRight.DEPARTEMENT){
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        //valueOf将一个字符串转换为一个枚举类型
        AccessRight accessRight = AccessRight.valueOf("MANAGER");
        System.out.println(checkRight(accessRight));
    }
}
