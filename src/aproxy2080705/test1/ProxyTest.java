package aproxy2080705.test1;

/**
 * @author Ф��·
 * @description
 * @date 2018��07��05�� 15:36
 */
public class ProxyTest {
    public static void main(String[] args) {
        RealMovie realmovie = new RealMovie();

        Movie movie = new Cinema(realmovie);

        movie.play();
    }
}
