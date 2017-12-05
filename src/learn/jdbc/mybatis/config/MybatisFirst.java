import learn.jdbc.mybatis.modal.Test;
import learn.jdbc.mybatis.modal.TestDaoImp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @description 
 * @author 肖长路
 * @date 2017/12/4 11:59
 */
public class MybatisFirst {
    //根据id查询用户信息，得到一条记录结果

    private void findUserByIdTest() throws IOException {
        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis配置文件的信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 通过SqlSession操作数据库
        // 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
        // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
        // sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
        // selectOne查询出一条记录
        Test user = sqlSession.selectOne("test.findUserById","001");

        System.out.println(user.toString());

        // 释放资源
        sqlSession.close();

    }

    public void findUserByNameTest() throws IOException {
        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 创建会话工厂，传入mybatis的配置文件信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);

        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // list中的user和映射文件中resultType所指定的类型一致
        List<Test> list = sqlSession.selectList("test.findUserByName", "00");
        for(Test one:list){
            System.out.println(one.toString());
        }
        sqlSession.close();
    }

    public void getDataForDao(Test test) throws IOException {
        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis配置文件的信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        TestDaoImp testDaoImp = new TestDaoImp(sqlSessionFactory);

        System.out.println(testDaoImp.getOne(test).toString());
    }

    public void getData2ForDao(Test test) throws IOException{
        // mybatis配置文件
        String resource = "SqlMapConfig.xml";
        // 得到配置文件流
        InputStream inputStream =  Resources.getResourceAsStream(resource);
        //创建会话工厂，传入mybatis配置文件的信息
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        TestDaoImp testDaoImp = new TestDaoImp(sqlSessionFactory);

        System.out.println(testDaoImp.getAll(test).toString());
    }
    public static void main(String[] args) throws IOException {
        MybatisFirst mf = new MybatisFirst();
        //mf.findUserByIdTest();
        //mf.findUserByNameTest();
        Test test = new Test();
        test.setRybh("001");
        mf.getDataForDao(test);
        test.setRybh("00");
        mf.getData2ForDao(test);
    }
}
