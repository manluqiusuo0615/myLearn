package aproxy2080705.test1;

/**
 * @author 肖长路
 * @description
 * @date 2018年07月05日 15:32
 */
public class RealMovie implements Movie{
    @Override
    public void play() {
        System.out.println("您正在观看电影 《肖申克的救赎》");
    }
}
