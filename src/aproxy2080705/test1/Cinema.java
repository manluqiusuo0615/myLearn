package aproxy2080705.test1;

/**
 * @author 肖长路
 * @description
 * @date 2018年07月05日 15:34
 */
public class Cinema implements Movie{
    RealMovie movie;
    public Cinema(RealMovie movie) {
        super();
        this.movie = movie;
    }
    public void guanggao(boolean isStart){
        if ( isStart ) {
            System.out.println("电影马上开始了，爆米花、可乐、口香糖9.8折，快来买啊！");
        } else {
            System.out.println("电影马上结束了，爆米花、可乐、口香糖9.8折，买回家吃吧！");
        }
    }
    @Override
    public void play() {
        guanggao(true);

        movie.play();

        guanggao(false);
    }
}
