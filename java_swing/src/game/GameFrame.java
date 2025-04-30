package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameFrame extends JFrame implements KeyListener {

    BufferedImage backgroundImage;
    BufferedImage player1;
    BufferedImage player2;

    private ImagePanel imagePanel;

    private int playerX = 200;
    private int playerY = 800;

    private int player2X = 400;
    private int player2Y = 800;

    private boolean flag = true;

    public GameFrame() {
        initData();
        setInitLayout();
        addEventListener();

        Thread thread1 = new Thread(imagePanel);
        thread1.start();
        //imagepanel안에 구현한 run(){}메서드가 시작된다
    }

    private void initData() {
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        try {
            backgroundImage = ImageIO.read(new File("images/backgroundMap.png"));
            player1 = ImageIO.read(new File("images/palyer1.png"));
            player2 = ImageIO.read(new File("images/palyer2.png"));
            //todo player 이미지도 올려야함
        } catch (IOException e) {
            e.printStackTrace();
        }

        imagePanel = new ImagePanel();

    }

    private void setInitLayout() {
        add(imagePanel);
        setVisible(true);

    }

    private void addEventListener() {
        //JFrame 자체에 키 이벤트 리스너를 등록한다
        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keycode : " + e.getKeyCode());
        //todo 화살표만 추출해낼 예정
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            playerY -= 10;
        } else if (code == KeyEvent.VK_DOWN) {
            playerY += 10;
        } else if (code == KeyEvent.VK_LEFT) {
            playerX -= 10;
        } else if (code == KeyEvent.VK_RIGHT) {
            playerX += 10;
        }

        //동일 좌표에 있는 상태 판별
        if (playerX == player2X && playerY == player2Y) {
            System.out.println("좌표선상에서 같은위치");
            player1 = null;
        }


//그림을 다시그려라
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    //내부클래스 생성
    private class ImagePanel extends JPanel implements Runnable {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, 1000, 1000, null);
            g.drawImage(player1, playerX, playerY, 100, 100, null);
            g.drawImage(player2, player2X, player2Y, 100, 100, null);


        }

        @Override
        public void run() {
            //direction 값이 true라면 오른쪽으로 가고있는 상태 false라면 왼쪽으로 가고있는 상태
            boolean direction = true;

            //서브작업자가 해야할일을 명시하도록 약속

            while (flag) {

                if (direction == true) {
                    player2X += 5;
                } else {
                    player2X -= 5;
                }

                if (player2X >= 800) {
                    direction = false;
                }

                if (player2X <= 100) {
                    direction = true;
                }


                try {
                    Thread.sleep(100);

                    repaint();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
