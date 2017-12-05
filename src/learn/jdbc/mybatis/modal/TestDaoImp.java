package learn.jdbc.mybatis.modal;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

/**
 * @author 肖长路
 * @description
 * @date 2017年12月05日 10:50
 */
public class TestDaoImp implements TestDao<Test>{
    // 需要向dao实现类中注入SqlSessionFactory
    // 这里通过构造方法注入
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    public TestDaoImp(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory=sqlSessionFactory;
        this.sqlSession = sqlSessionFactory.openSession();
    }
    @Override
    public Test getOne(Test test) {
        Test back = sqlSession.selectOne("test.findUserById",test);
        return back;
    }

    @Override
    public List<Test> getAll(Test test) {
        List<Test> back = sqlSession.selectList("test.findUserByName",test);
        return back;
    }
}
