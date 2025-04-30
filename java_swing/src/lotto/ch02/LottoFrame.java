package lotto.ch02;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LottoFrame extends JFrame implements ActionListener {

    private JButton button;
    private LottoRandomNumber lottoRandomNumber;
    int testNumber;

    public LottoFrame() {
        initData();
        setInitData();
        addEventListener();
    }

    private void initData() {
        setTitle("로또게임");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button = new JButton("게임스타트");
        lottoRandomNumber = new LottoRandomNumber();
    }

    private void setInitData() {
        add(button, BorderLayout.NORTH);

        setVisible(true);
    }

    private void addEventListener() {
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("그림 그려라");

        lottoRandomNumber.createNumber();

        testNumber = 1234;

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Font f = new Font("궁서체" , Font.BOLD ,20);
        g.setFont(f);

        g.drawString(testNumber + "," ,100 , 300);
    }

    //메인함수
    public static void main(String[] args) {
        new LottoFrame();


    }//end of main
}//end of public class
