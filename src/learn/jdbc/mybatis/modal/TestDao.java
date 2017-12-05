package learn.jdbc.mybatis.modal;

import java.util.List;

/**
 * @author 肖长路
 * @description
 * @date 2017年12月05日 10:48
 */
public interface TestDao<T> {
    public T getOne(T t);
    public List<T> getAll(T t);
}
