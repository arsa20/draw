import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class Car extends Canvas {
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g; //преобразуем Graphics в Graphics2D (для сглаживания)
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //сглаживание
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));//выставляем способ наложения фигур
        //рисуем колеса
        drawWheel(200,450, 150, 50, new Color(112, 148, 144), Color.black, g2);//колесо 1
        drawWheel(750,450, 150, 50, new Color(112, 148, 144), Color.black, g2);//колесо 2
        //рисуем кузов
        Path2D.Double path = new Path2D.Double();
        double x = 165, y = 525;//стартовая точка кузова машины - первая колесная арка, идем против часовой
        path.moveTo(x, y);//задаем стартовую точку
        path.curveTo(x, y-150, x+220, y-150, x+220, y);//арка первого колеса
        path.lineTo(x+=550,y);//днище
        path.curveTo(x, y-150, x+=220, y-150, x, y);//арка второго колеса
        path.lineTo(x+=120,y);//низ передка
        path.quadTo(x+100, y-15, x+60,y-70 );//передний бампер
        path.quadTo(x+100, y-200, x-=180,y-=250 );//капот
        double xGlass=x, yGlass=y;//запоминаем эти координаты для рисования стекол в дальнейшем
        path.quadTo(x-400, y-330, x-=700,y-=30);//крыша
        path.quadTo(x-100, y+20, x-=100,y+=190);//багажник
        path.quadTo(x-50, y+20, x+15,525);//задний бампер, финиш
        path.closePath(); //соединяем линии
        g2.setColor(new Color(0, 139, 139));
        g2.fill(path);//рисуем созданный кузов
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(6));//ширина бордюров
        g2.draw(path);//рисуем окантовку кузова
        path.reset();//очищаем путь
        //рисуем переднее стекло
        path.moveTo(xGlass-50, yGlass);//начальная точка стекла
        path.quadTo(xGlass-220, yGlass-140, xGlass-370,yGlass-145);//первая линия
        path.lineTo(xGlass-=370, yGlass);//вторая линия
        path.closePath();//соединяем
        g2.setColor(new Color(255, 228, 196));
        g2.fill(path);//рисуем стекло
        g2.setColor(Color.black);
        g2.draw(path);//рисуем окантовку стекла
        path.reset();//очищаем путь
        //рисуем заднее стекло
        path.moveTo(xGlass-30, yGlass-145);//начальная точка стекла
        path.quadTo(xGlass-180, yGlass-140, xGlass-280,yGlass-40);//первая линия
        path.lineTo(xGlass-280+60, yGlass);//вторая линия
        path.lineTo(xGlass-30, yGlass);//третья линия
        path.closePath();//соединяем
        g2.setColor(new Color(255, 228, 196));
        g2.fill(path);//рисуем стекло
        g2.setColor(Color.black);
        g2.draw(path);//рисуем окантовку стекла
        path.reset();//очищаем путь
        //рисуем ручки
        g2.setStroke(new BasicStroke(6));//ширина бордюров
        g2.drawLine(520, 320 ,550, 320);//ручка передней двери
        g2.drawLine(240, 320 ,270, 320);//ручка задней двери
        //рисуем переднюю фару
        path.moveTo(1116,400);
        path.quadTo(1130,350, 1080,350);
        path.quadTo(1100,420, 1116,400);
        g2.setColor(Color.yellow);
        g2.fill(path);//рисуем фару
        g2.setColor(Color.black);
        g2.draw(path);//рисуем окантовку фары
        path.reset();//очищаем путь
        //рисуем заднюю фару
        path.moveTo(114,280);
        path.quadTo(80,280, 80,362);
        path.quadTo(120,290, 114,280);
        // path.quadTo(1100,420, 50,400);
        g2.setColor(Color.red);
        g2.fill(path);//рисуем фару
        g2.setColor(Color.black);
        g2.draw(path);//рисуем окантовку фары
        path.reset();//очищаем путь
    }

    public void drawWheel (int x, int y, int diameter, int border, Color colorOval, Color colorBorder, Graphics2D g2){//метод для рисования колеса
        g2.setColor(colorOval);//цвет диска
        g2.fillOval(x,y,diameter,diameter);//диск
        g2.setColor(colorBorder);//цвет шины
        g2.setStroke(new BasicStroke(border));//ширина шины
        g2.fillOval(x+diameter/2-diameter/10/2,y+diameter/2-diameter/10/2,diameter/10,diameter/10);//ось колеса
        g2.drawOval(x,y,diameter,diameter);//шина
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Машинка");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(dim.width/2-600,dim.height/2-350, 1200,700);
        Car m=new Car();
        frame.add(m);
        frame.setVisible(true);
    }
}