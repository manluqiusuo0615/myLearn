package aproxy2080705.test1;

/**
 * @author Ф��·
 * @description
 * @date 2018��07��05�� 15:34
 */
public class Cinema implements Movie{
    RealMovie movie;
    public Cinema(RealMovie movie) {
        super();
        this.movie = movie;
    }
    public void guanggao(boolean isStart){
        if ( isStart ) {
            System.out.println("��Ӱ���Ͽ�ʼ�ˣ����׻������֡�������9.8�ۣ������򰡣�");
        } else {
            System.out.println("��Ӱ���Ͻ����ˣ����׻������֡�������9.8�ۣ���ؼҳ԰ɣ�");
        }
    }
    @Override
    public void play() {
        guanggao(true);

        movie.play();

        guanggao(false);
    }
}
