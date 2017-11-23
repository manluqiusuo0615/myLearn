package chatting_software.view.views;

import chatting_software.view.baseView.BaseJFrame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * @author 肖长路
 * @Description ${DESCRIPTION}
 * @create 2017-09-22 16:26
 */
public class ServerManager extends BaseJFrame {
    private JPanel jPanel1, jPanel2, jPanel3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField ServerIP;
    private JTextField ServerPORT;
    private JButton start;
    private JButton stop;

    private JScrollPane jScrollPane1,jScrollPane2;
    private JTextArea clientMessage;
    private JTextArea chatMessage;

    /**
     * 构造初始化框架
     * 并添加面板元素
     *
     * @param titleName 框架标题
     */
    public ServerManager(String titleName) {
        super(titleName);
        this.setSize(450, 520);
        //设置布局
        this.setLayout(new GridLayout(3, 6));

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();

        jLabel1 = new JLabel("服务器IP:");
        jLabel2 = new JLabel("服务器port:");
        ServerIP = new JTextField(8);
        ServerPORT = new JTextField(4);
        start = new JButton("启动");
        stop = new JButton("停止");

        jPanel1.add(jLabel1);
        jPanel1.add(ServerIP);
        jPanel1.add(jLabel2);
        jPanel1.add(ServerPORT);
        jPanel1.add(start);
        jPanel1.add(stop);
        jPanel1.setBorder(new TitledBorder("服务器配置"));





        clientMessage = new JTextArea(50,15);
        chatMessage = new JTextArea(50,15);
        clientMessage.setEditable(false);
		clientMessage.setAutoscrolls(true);
		chatMessage.setEditable(false);
		chatMessage.setAutoscrolls(true);
		jScrollPane1 = new JScrollPane(clientMessage);
		jScrollPane2 = new JScrollPane(chatMessage);

		jPanel2.add(jScrollPane1);
		jPanel2.add(jScrollPane2);

		jPanel2.setBorder(new TitledBorder("服务器监控"));

		this.addElements(jPanel1);
        this.addElements(jPanel2);
        this.addElements(jPanel3);

		//设置框架大小可变
        this.setVisible(true);
        
    }

    public static void main(String[] args) {
        ServerManager serverManager = new ServerManager("服务器管理中心");
    }
}
