package lotto.ch01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LottoFrame extends JFrame implements ActionListener {

    private JButton button;

    public LottoFrame(){
        initData();
        setInitData();
        addEventListener();
    }

    private void initData(){
        setTitle("로또게임");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new JButton("게임스타트");
    }
    private void setInitData(){
        add(button, BorderLayout.NORTH);

        setVisible(true);
    }
    private void addEventListener(){
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("그림 그려라");
    }

    //메인함수
    public static void main(String[] args) {
        new LottoFrame();
    }//end of main
}//end of public class
