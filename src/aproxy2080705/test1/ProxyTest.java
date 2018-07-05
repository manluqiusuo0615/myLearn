package aproxy2080705.test1;

/**
 * @author 肖长路
 * @description
 * @date 2018年07月05日 15:36
 */
public class ProxyTest {
    public static void main(String[] args) {
        RealMovie realmovie = new RealMovie();

        Movie movie = new Cinema(realmovie);

        movie.play();
    }
}
