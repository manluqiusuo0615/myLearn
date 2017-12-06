package learn.jdbc.mybatis.InterfaceDao;

import learn.jdbc.mybatis.modal.Test;
import java.util.List;

/**
 * @author 肖长路
 * @description
 * @date 2017年12月05日 15:05
 */
public interface Mapper {
    public Test getOne(Test t);
    public List<Test> getAll(Test t);
}
