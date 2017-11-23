package chatting_software.view.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-22 16:37
 */
public class FrameDemo extends JFrame implements ActionListener {
JTextField jtf1;
    JButton jbHello, jbBye;

    public FrameDemo() {
        setLayout(new GridLayout(3, 1));// 3行1列布局
        JPanel jp1 = new JPanel();// 第一行
        JButton jb1 = new JButton("第一个按钮");
        JButton jb2 = new JButton("第二个按钮");
        JButton jb3 = new JButton("第三个按钮");
        jp1.add(jb1);
        jp1.add(jb2);
        jp1.add(jb3);
        add(jp1);
        JPanel jp2 = new JPanel();// 第二行
        jtf1 = new JTextField(10);
        jp2.add(jtf1);
        add(jp2);
        JPanel jp3 = new JPanel();// 第三行
        jbHello = new JButton("你好");
        jbHello.addActionListener(this);
        jbBye = new JButton("再见");
        jbBye.addActionListener(this);
        jp3.add(jbHello);
        jp3.add(jbBye);
        add(jp3);

        setSize(380, 180);
        setTitle("窗口");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    //点击按钮后响应
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("你好")) {
            jtf1.setText("你好，****");
        } else if (cmd.equals("再见")) {
            jtf1.setText("再见!****");
        }
    }

    public static void main(String[] args) {
        new FrameDemo();
    }
}
