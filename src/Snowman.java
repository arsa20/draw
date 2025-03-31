import javax.swing.*;
import java.awt.*;

public class Snowman extends Canvas {


    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //преобразуем Graphics в Graphics2D (для сглаживания)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));//выставляем способ наложения фигур
        g2.setStroke(new BasicStroke(3));//ширина бордюров
        drawArm(new int[]{480-50,480-150,480-155,480-55,480-45,480-40,480-43,480-25,480-23,480-40,480-30,480-35}, new int[] {290,330,315,280,260,263,275,270,277,285,300,305}, Color.WHITE, Color.black, g2);//рука правая, для Х из общей ширины вычитаем уже ранее подобранные значения, получаем симметричную руку
        drawOvalWithBorder(100,400,280, 230, Color.WHITE, Color.black, g2);//низ
        drawOvalWithBorder(130,250,220, 200, Color.WHITE, Color.black, g2);//середина
        drawOvalWithBorder(160,140,160, 140, Color.WHITE, Color.black, g2);//голова
        drawOvalWithBorder(150,140,180, 20, Color.WHITE, Color.black, g2);//низ шляпы
        g2.setColor(Color.white);
        g2.fillRoundRect(190, 70, 100, 75, 20, 15);//заливка шляпы
        g2.setColor(Color.black);
        g2.drawRoundRect(190, 70, 100, 75, 20, 15);//контур шляпы
        g2.drawLine(190,130,290,130);
        drawArm(new int[]{50,150,155,55,45,40,43,25,23,40,30,35}, new int[] {290,330,315,280,260,263,275,270,277,285,300,305}, Color.WHITE, Color.black, g2);//рука левая
        g2.setStroke(new BasicStroke(2));//ширина бордюров
        for (int i = 0; i < 90; i=i+30)
            drawOvalWithBorder(260,320+i,10, 10, Color.red, Color.black, g2);//пуговицы
        for (int i = 0; i < 80; i=i+40) {
            drawOvalWithBorder(230 + i, 180, 20, 15, Color.CYAN, Color.black, g2);//глаз
            drawOvalWithoutBorder(240 + i, 182, 10, 10, Color.black, g2);//зрачок
        }
        drawOvalWithoutBorder(230,230,60, 30, Color.BLACK, g2);//рот
        drawOvalWithoutBorder(220,228,80, 20, Color.WHITE, g2);//перекрытие рта
        g2.setColor(Color.ORANGE);
        g2.fillPolygon(new int[]{260,350,255}, new int[] {230,220,215}, 3);//заливка носа
        g2.setColor(Color.black);
        g2.drawPolyline(new int[]{260,350,255}, new int[] {230,220,215}, 3);//контур носа

    }

    public void drawOvalWithBorder (int x, int y, int width, int height, Color colorOval, Color colorBorder, Graphics2D g2){//метод для рисования залитого овала и его бордюра разными цветами
        g2.setColor(colorOval);
        g2.fillOval(x,y,width,height);
        g2.setColor(colorBorder);
        g2.drawOval(x,y,width,height);
    }

    public void drawArm (int [] i, int [] y, Color colorOval, Color colorBorder, Graphics2D g2) {//метод для рисования рук
        g2.setColor(colorOval);
        g2.fillPolygon(i, y, i.length);
        g2.setColor(colorBorder);
        g2.drawPolygon(i, y, i.length);
    }

    public void drawOvalWithoutBorder (int x, int y, int width, int height, Color colorOval, Graphics2D g2){//метод для рисования залитого овала без бордера
        g2.setColor(colorOval);
        g2.fillOval(x,y,width,height);
    }
    public void drawOvalBorder (int x, int y, int width, int height, Color colorOval, Graphics2D g2){//метод для рисования залитого овала без бордера
        g2.setColor(colorOval);
        g2.drawOval(x,y,width,height);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Снеговик");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width/2-200,dim.height/2-350, 500,700);
        Snowman m=new Snowman();
        frame.add(m);
        frame.setVisible(true);
    }
}