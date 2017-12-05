import learn.jdbc.mybatis.modal.Test;
import java.util.List;

/**
 * @author 肖长路
 * @description
 * @date 2017年12月05日 15:08
 */
public interface MapperDao {
    public Test getOne(Test test);
    public List<Test> getAll(Test test);
}
