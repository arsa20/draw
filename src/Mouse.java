import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Mouse extends JFrame {

    private ArrayList<Point> points;  // Список точек, где появились объекты

    public Mouse() {
        setTitle("Нажмите для создания объектов");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        points = new ArrayList<>();  // Инициализируем список точек

        // Добавляем обработчик событий мыши
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Добавляем точку, где произошел клик
                points.add(e.getPoint());
                repaint();  // Перерисовываем панель, чтобы отобразить новые объекты
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Рисуем объекты в точках, где произошли клики
        for (Point point : points) {
            g.setColor(Color.RED);  // Устанавливаем цвет для объектов
            g.fillRect(point.x - 25, point.y - 25, 50, 50);  // Рисуем квадрат 50x50
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Создаем и показываем окно
                Mouse frame = new Mouse();
                frame.setVisible(true);
            }
        });
    }
}
