import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spider extends JFrame {

    private static final int WIDTH = 600;  // Ширина окна
    private static final int HEIGHT = 600; // Высота окна
    private int x = 0; // Начальная позиция по оси X
    private int y = 0; // Начальная позиция по оси Y

    private ImageIcon imageIcon; // Для хранения изображения

    public Spider() {
        // Устанавливаем параметры окна
        setTitle("Двигающееся изображение");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Загружаем изображение
        imageIcon = new ImageIcon("C://Users//Arina//IdeaProjects//draw//src//3fd562f060d3d2d0fe7bfdfd0de57d50.png"); // Укажите путь к вашему изображению

        // Создаем панель для отображения изображения
        MovingPanel panel = new MovingPanel();
        add(panel);

        // Таймер для анимации
        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Обновляем позицию изображения
                x += 1;
                y += 1;

                // Если изображение выходит за пределы окна, перемещаем его в начало
                if (x > WIDTH) {
                    x = 0;
                }
                if (y > HEIGHT) {
                    y = 0;
                }

                // Перерисовываем панель
                repaint();
            }
        });
        timer.start();
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
                Spider movingImage = new Spider();
                movingImage.setVisible(true);
            }
        });
    }
}
