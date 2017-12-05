package learn.jdbc.mybatis.InterfaceDao;

import java.util.List;

/**
 * @author 肖长路
 * @description
 * @date 2017年12月05日 15:05
 */
public interface Mapper<T> {
    public T getOne(T t);
    public List<T> getAll(T t);
}
