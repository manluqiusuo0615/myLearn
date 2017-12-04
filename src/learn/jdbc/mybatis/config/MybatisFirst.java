package learn.jdbc.mybatis.config;

/**
 * @description 
 * @author 肖长路
 * @date 2017/12/4 11:59
 */
public class MybatisFirst {
    //根据id查询用户信息，得到一条记录结果

    private void findUserByIdTest() throws IOException{
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
        User user = sqlSession.selectOne("test.findUserById",'001');

        System.out.println(user);

        // 释放资源
        sqlSession.close();

    }

    // 根据用户名称模糊查询用户列表

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
        List<User> list = sqlSession.selectList("test.findUserByName", "00");
        System.out.println(list);
        sqlSession.close();

    }

    public static void main(String[] args) {
        MybatisFirst mf = new MybatisFirst();
        mf.findUserByIdTest();
    }
}
