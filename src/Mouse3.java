import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Mouse3 extends JFrame {

    private ArrayList<Rectangle> objects;  // Список объектов
    private static final int OBJECT_SIZE = 50;  // Размер объекта (квадрата)
    private Rectangle selectedObject;  // Выбранный для перетаскивания объект
    private Point mouseOffset;  // Смещение относительно верхнего левого угла объекта

    public Mouse3() {
        setTitle("Перетаскивание объекта с ПКМ");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        objects = new ArrayList<>();  // Инициализируем список объектов
        selectedObject = null;  // Изначально нет выбранного объекта

        // Добавляем обработчик событий для мыши
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Если нажата правая кнопка мыши
                if (SwingUtilities.isRightMouseButton(e)) {
                    Point mousePoint = e.getPoint();
                    // Проверяем, находится ли клик по одному из объектов
                    for (Rectangle obj : objects) {
                        if (obj.contains(mousePoint)) {
                            selectedObject = obj;
                            mouseOffset = new Point(mousePoint.x - obj.x, mousePoint.y - obj.y); // Сохраняем смещение
                            break;
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Отпускаем объект
                selectedObject = null;
                mouseOffset = null;
            }
        });

        // Обработчик движения мыши
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                // Если объект выбран для перетаскивания
                if (selectedObject != null) {
                    Point mousePoint = e.getPoint();
                    // Перемещаем объект в новую позицию
                    selectedObject.setLocation(mousePoint.x - mouseOffset.x, mousePoint.y - mouseOffset.y);
                    repaint(); // Перерисовываем панель
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
                Mouse3 frame = new Mouse3();
                frame.setVisible(true);

                // Добавляем несколько объектов для теста
                frame.objects.add(new Rectangle(100, 100, OBJECT_SIZE, OBJECT_SIZE));
                frame.objects.add(new Rectangle(200, 200, OBJECT_SIZE, OBJECT_SIZE));
                frame.objects.add(new Rectangle(300, 300, OBJECT_SIZE, OBJECT_SIZE));
            }
        });
    }
}
