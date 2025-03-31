import javax.swing.*;
import java.awt.*;

public class TrafficLight extends Canvas {


    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //преобразуем Graphics в Graphics2D (для сглаживания)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        //устанавливаем цвет и рисуем фигуру такого цвета
        g.setColor(Color.black);
        g.fillRect(100, 50,100, 280);
        g.setColor(Color.red);
        g.fillOval(110,60,80, 80);
        g.setColor(Color.yellow);
        g.fillOval(110,150,80, 80);
        g.setColor(Color.green);
        g.fillOval(110,240,80, 80);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Светофор");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width/2-150,dim.height/2-215, 300,430);
        TrafficLight m=new TrafficLight();
        frame.add(m);
        frame.setVisible(true);
    }
}