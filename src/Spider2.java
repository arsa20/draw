import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spider2
        extends JFrame {

    private static final int WIDTH = 600;  // Ширина окна
    private static final int HEIGHT = 600; // Высота окна
    private static final int IMAGE_SIZE = 50; // Размер изображения
    private static final int SPEED = 5; // Скорость движения (пиксели за шаг)

    private int x = 50; // Начальная позиция по оси X
    private int y = 50; // Начальная позиция по оси Y
    private int direction = 0; // Направление движения (0 - вверх, 1 - вправо, 2 - вниз, 3 - влево)

    private ImageIcon imageIcon; // Для хранения изображения

    public Spider2() {
        // Устанавливаем параметры окна
        setTitle("Двигающееся изображение по квадрату");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Загружаем изображение
        imageIcon = new ImageIcon("C://Users//Arina//IdeaProjects//draw//src//3fd562f060d3d2d0fe7bfdfd0de57d50.png"); // Укажите путь к вашему изображению

        // Создаем панель для отображения изображения
        MovingPanel panel = new MovingPanel();
        add(panel);

        // Таймер для анимации
        Timer timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Обновляем позицию изображения в зависимости от направления
                moveImage();
                repaint(); // Перерисовываем панель
            }
        });
        timer.start();
    }

    private void moveImage() {
        // Двигаем изображение по квадрату
        switch (direction) {
            case 0: // Двигаемся вверх
                y -= SPEED;
                if (y <= 50) direction = 1; // Переход к следующей стороне
                break;
            case 1: // Двигаемся вправо
                x += SPEED;
                if (x >= WIDTH - IMAGE_SIZE - 50) direction = 2;
                break;
            case 2: // Двигаемся вниз
                y += SPEED;
                if (y >= HEIGHT - IMAGE_SIZE - 50) direction = 3;
                break;
            case 3: // Двигаемся влево
                x -= SPEED;
                if (x <= 50) direction = 0; // Вернуться к начальной точке
                break;
        }
    }

    private class MovingPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Рисуем изображение в текущей позиции
            imageIcon.paintIcon(this, g, x, y);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Создаем и отображаем окно с анимацией
                Spider2 squareMovement = new Spider2();
                squareMovement.setVisible(true);
            }
        });
    }
}
