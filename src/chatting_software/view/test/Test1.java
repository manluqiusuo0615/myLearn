package chatting_software.view.test;

import chatting_software.view.baseView.BaseJFrame;
import chatting_software.view.baseView.ElementAction;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-22 10:24
 */
public class Test1 extends BaseJFrame{
    private JButton button2 = new JButton("测试按钮");

    
    private JTextField jTextField = new JTextField("5555");
    
    public Test1(String titleName) {
        super(titleName);
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1("测试");
        test1.addElements(test1.button2);
        test1.addElements(test1.jTextField);
        ElementAction elementAction = new ElementAction() {

            public void actionPerformed(ActionEvent e) {
                String buttonName = e.getActionCommand();
                if(buttonName.equals("测试按钮")){
                    System.out.println("执行触发逻辑操作...");
                    //System.out.println(test1.jTextField.getText());
                }

            }
        };
        test1.button2.addActionListener(elementAction);

    }

}
