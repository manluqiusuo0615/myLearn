package chatting_software.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author 肖长路
 * @Description 配置文件工具类
 * @create 2017-09-22 9:25
 */
public class PropertiesUtil {
    //系统配置文件路径
    private static final String PROP_FILE =
            "/chatting_software/resources/System.properties";
    private static Properties properties = new Properties();

    static {
        InputStream inputStream = PropertiesUtil.class.getResourceAsStream(PROP_FILE);
        try {
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("项目中不存在"+PROP_FILE+"配置文件!");
        }
    }

    /**
     * 获取配置文件中的键值对值
     * @param key
     * @return
     */
    public static String getValue(String key){
        String value ;
        if(key!=null&&!key.equals("")){
             value = properties.getProperty(key);
             if (value==null){
                 throw new RuntimeException("配置文件中不存在"+key+"配置项目!");
             }
        }else{
            throw new RuntimeException("配置文件属性需确定名称!");
        }
        return value;
    }

//    public static void main(String[] args) {
//        System.out.println(PropertiesUtil.getValue("nickName"));
//    }
}
