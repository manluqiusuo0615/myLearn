package learn.jdbc.mybatis.InterfaceDao;

import learn.jdbc.mybatis.modal.Test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 肖长路
 * @description
 * @date 2017年12月05日 15:14
 */
public class InterfaceTest {
    public void getOne() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        MapperDao mapperDao = sqlSession.getMapper(MapperDao.class);
        Test test = new Test();
        test.setRybh("001");
        Test back = mapperDao.getOne(test);
        System.out.println(back.toString());
    }

    public static void main(String[] args) throws IOException {
        InterfaceTest interfaceTest = new InterfaceTest();
        interfaceTest.getOne();
    }
}
