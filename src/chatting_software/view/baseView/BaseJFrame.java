package chatting_software.view.baseView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-22 10:08
 */
public class BaseJFrame extends JFrame {
    /**
     * 构造初始化框架
     * 并添加面板元素
     * @param titleName 框架标题
     */
    public BaseJFrame(String titleName){
        super(titleName);
        //设置为边界布局，组件间横向、纵向间距均为5像素
        this.setLayout(new BorderLayout(10, 10));
        //设置字体
        this.setFont(new Font("Helvetica", Font.PLAIN, 14));
        //处理关闭事件的通常方法
//        this.addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        //让窗体自适应组建大小
        this.pack();
        //setVisible的对象一般是该对象的使用者调用的
        //如果setVisible在某个控件的内部
        //那么在setVisible函数后面添加的控件就显示不出来了
        //setVisible(true)并不是告诉JVM让该控件可见
        //而是在内部调用repaint方法把各个控件画出来进行显示
        //如果在控件还没完全添加完其他控件就setVisible(true)那么在方法后面添加的控件都不能显示
        this.setVisible(false);
        //让窗体居中显示
        this.setLocationRelativeTo(null);
        //让Frame窗口失去边框和标题栏的修饰
        //this.setUndecorated(true);

    }

    /**
     * 面板中添加元素
     * @param component
     */
    public void addElements(Component component){
        this.add(component);
    }

    protected void showErrorMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
