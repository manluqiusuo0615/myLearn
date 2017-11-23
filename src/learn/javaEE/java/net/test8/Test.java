package learn.javaEE.java.net.test8;

import java.io.*;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-29 17:21
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("请输入数据:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("br打印:"+br.readLine());

            PrintWriter printWriter = new PrintWriter(new File("D:/test.txt"));
            printWriter.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
