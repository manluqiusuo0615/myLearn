package chatting_software.view.views;

import chatting_software.utils.CheckUtil;
import chatting_software.view.baseView.BaseJFrame;
import chatting_software.view.baseView.ElementAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-22 13:32
 */
public class Login extends BaseJFrame {

    private JPanel jPanel1, jPanel2, jPanel3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField userName;
    private JPasswordField password;
    private JButton login;
    private JButton register;

    public Login(String titleName) {
        super(titleName);

        this.setSize(420, 220);
        //设置布局
        this.setLayout(new GridLayout(3, 1));
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();


        jLabel1 = new JLabel("账号");
        jLabel2 = new JLabel("密码");
        userName = new JTextField(15);
        password = new JPasswordField(15);
        login = new JButton("登陆");
        register = new JButton("注册");

        jPanel1.add(jLabel1);
        jPanel1.add(userName);

        jPanel2.add(jLabel2);
        jPanel2.add(password);

        jPanel3.add(login);
        jPanel3.add(register);

        this.addElements(jPanel1);
        this.addElements(jPanel2);
        this.addElements(jPanel3);
        //设置框架大小可变
        this.setVisible(true);

        login.addActionListener(new ElementAction() {
            public void actionPerformed(ActionEvent e) {
                //基本检验
                if(CheckUtil.isNull(userName.getText())){
                    showErrorMessage("用户名不能为空!");
                }
                if(CheckUtil.isNull(password.getText())){
                    showErrorMessage("密码不能为空!");
                }
                //数据库检验

            }
        });
    }





    public static void main(String[] args) {
        Login login = new Login("登陆界面");
    }


}
