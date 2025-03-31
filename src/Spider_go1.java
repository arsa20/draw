import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Spider_go1 {
    static JFrame frame = new JFrame();//создаем форму
    static JLabel l;//объект с картинкой
    static int change=50;//на сколько точек двигаем объект

    static public void move(KeyEvent e){//метод движения по клавиатуре
        switch (e.getKeyCode()){//делаем проверку на границы формы, пользуясь реальным размером окна, а не первоначально заданным, а также смещением на 5, чтобы вписаться в panel
            case (KeyEvent.VK_LEFT):
                l.setLocation(l.getX()-change>=0?l.getX()-change:(int) frame.getContentPane().getSize().getWidth()-l.getWidth()-5,l.getY());
                break;
            case (KeyEvent.VK_RIGHT):
                l.setLocation(l.getX()+change<(int) frame.getContentPane().getSize().getWidth()-l.getWidth()?l.getX()+change:5,l.getY());
                break;
            case (KeyEvent.VK_UP):
                l.setLocation(l.getX(),l.getY()-change>=0?l.getY()-change:(int) frame.getContentPane().getSize().getHeight()-l.getHeight()+5);
                break;
            case (KeyEvent.VK_DOWN):
                l.setLocation(l.getX(),l.getY()+change<(int) frame.getContentPane().getSize().getHeight()-l.getHeight()?l.getY()+change:5);
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//способ выхода из формы
        frame.setTitle("Сложное перемещение клавиатурой");//заголовок формы
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//определяем разрешение монитора
        int width=300, height=300;//задаем размер окна
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);//выставляем размеры окна
        BufferedImage im = ImageIO.read(new URL("https://avatars.mds.yandex.net/i?id=359ed88bfc42c98caeb53bec58dcfcdd_l-3707062-images-thumbs&n=13"));
        JPanel panel = new JPanel (new FlowLayout(FlowLayout.LEFT));//создаем панель, чтобы ей отлавливать события клавиатуры, ставим ее слева
        panel.setFocusable(true);//делаем у панели возможность принимать фокус, иначе она не сможет отловить события клавиатуры
        l = new JLabel(new ImageIcon(im),JLabel.RIGHT);//создаем объект слева
        panel.add(l, BorderLayout.NORTH);//добавляем на панель
        frame.add(panel);//добавляем панель на форму
        panel.addKeyListener(new KeyAdapter() {//добавляем слушателя на панель
            public void keyReleased(KeyEvent e) {
                move(e);//метод движения
            }
        });
        frame.setVisible(true);//делаем форму видимой
    }
}