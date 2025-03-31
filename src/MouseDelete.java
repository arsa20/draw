import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MouseDelete extends JFrame {

    private ArrayList<Rectangle> objects;  // Список объектов
    private static final int OBJECT_SIZE = 50;  // Размер объекта (квадрата)

    public MouseDelete() {
        setTitle("Нажмите для добавления и колесиком для удаления объектов");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        objects = new ArrayList<>();  // Инициализируем список объектов

        // Добавляем обработчик событий для мыши
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Добавляем новый объект при левом клике
                if (SwingUtilities.isLeftMouseButton(e)) {
                    objects.add(new Rectangle(e.getX() - OBJECT_SIZE / 2, e.getY() - OBJECT_SIZE / 2, OBJECT_SIZE, OBJECT_SIZE));
                    repaint();
                }
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                // Удаляем объект при прокрутке колесика мыши
                Point mousePoint = e.getPoint();
                for (int i = 0; i < objects.size(); i++) {
                    Rectangle object = objects.get(i);
                    if (object.contains(mousePoint)) {
                        objects.remove(i);
                        repaint();
                        break;
                    }
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Рисуем все объекты
        for (Rectangle obj : objects) {
            g.setColor(Color.RED);  // Цвет объектов
            g.fillRect(obj.x, obj.y, obj.width, obj.height);  // Рисуем квадрат
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Создаем и показываем окно
                MouseDelete frame = new MouseDelete();
                frame.setVisible(true);
            }
        });
    }
}
