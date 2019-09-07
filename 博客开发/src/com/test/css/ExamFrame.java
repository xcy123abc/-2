package com.test.css;



import javax.swing.*;
import java.awt.*;

public class ExamFrame extends BaseFrame {

    //三个区域
    private JPanel mainPanel = new JPanel();
    private JPanel messagePanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    //组件
    private JTextField examArea = new JTextField();
    private JScrollPane scrollPane = new JScrollPane(examArea);
    //
    private JLabel pictureLabel = new JLabel();
    private JLabel newNumLabel = new JLabel("当前题号：");
    private JLabel totalCountLabel = new JLabel("题目总数：");
    private JLabel answerCountLabel = new JLabel("已答题目：");
    private JLabel unanswerCountLabel = new JLabel("未答题目：");

    private JTextField newNumField = new JTextField("0");
    private JTextField totalCountField = new JTextField("0");
    private JTextField answerCountField = new JTextField("0");
    private JTextField unanswerField = new JTextField("0");
    private JLabel timeLabel = new JLabel("剩余答题时间");
    private JLabel realTimeLabel = new JLabel("00:00:00");
    //添加按钮
    private JButton aButton = new JButton("A");
    private JButton bButton = new JButton("A");
    private JButton cButton = new JButton("A");
    private JButton dButton = new JButton("A");
    private JButton prevButton = new JButton("上一题");
    private JButton nextButton = new JButton("下一题");
    private JButton submitButton = new JButton("提交");


    public ExamFrame(){
        this.setFontAndSoOn();
        this.addElement();
        this.addListener();
        this.setFrameSelf();
    }

    @Override
    protected void setFontAndSoOn() {
        //设置panel布局管理
        try{
            mainPanel.setLayout(null);
            mainPanel.setBackground(Color.LIGHT_GRAY);
        }catch (Exception e){
            e.printStackTrace();
        }

        //
        messagePanel.setLayout(null);
        messagePanel.setBounds(680,10,300,550);
        messagePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        //
        buttonPanel.setLayout(null);
        buttonPanel.setBounds(16,470,650,90);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        //设置每一个组件的位置
        scrollPane.setBounds(16,10,650,450);
        examArea.setFont(new Font("黑体",Font.BOLD,34));
        examArea.setEnabled(false);//文本域文字不能改
        //message
        pictureLabel.setBounds(10,10,280,230);
        pictureLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        newNumLabel.setBounds(40,270,100,30);
        newNumLabel.setFont(new Font("黑体",Font.PLAIN,20));
        newNumField.setBounds(150,270,100,30);
        newNumField.setFont(new Font("黑体",Font.BOLD,20));
        newNumField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        newNumField.setEnabled(false);
    }



    @Override
    protected void addElement() {
        messagePanel.add(pictureLabel);
        messagePanel.add(newNumLabel);
        messagePanel.add(newNumField);
        mainPanel.add(scrollPane);
        mainPanel.add(messagePanel);
        mainPanel.add(buttonPanel);
        this.add(mainPanel);

    }



    @Override
    protected void addListener() {

    }



    @Override
    protected void setFrameSelf() {
        this.setBounds(260,130,1000,600);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ExamFrame();
    }
}
