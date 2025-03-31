import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.URL;

public class Spider_go
        extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private int x = 175;  // Начальная позиция по X
    private int y = 175;  // Начальная позиция по Y
    private ImageIcon imageIcon;

    public Spider_go() {
        setTitle("Движущаяся картинка");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Загружаем изображение (размер 50x50)
        try {
            URL imageUrl = new URL("https://avatars.mds.yandex.net/i?id=359ed88bfc42c98caeb53bec58dcfcdd_l-3707062-images-thumbs&n=13"); // Замените на свой URL изображения
            imageIcon = new ImageIcon(imageUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Создаем панель для отрисовки
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Отображаем картинку
                g.drawImage(imageIcon.getImage(), x, y, 50, 50, this);
            }
        };

        // Обрабатываем нажатия клавиш с помощью KeyListener
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();

                // Перемещаем объект в зависимости от нажатой клавиши
                if (keyCode == KeyEvent.VK_UP) {
                    if (y > 0) y -= 50;  // Перемещение вверх
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    if (y < HEIGHT - 50) y += 50;  // Перемещение вниз
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    if (x > 0) x -= 50;  // Перемещение влево
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    if (x < WIDTH - 50) x += 50;  // Перемещение вправо
                }

                // Перерисовываем панель
                repaint();
            }
        });

        panel.setFocusable(true);  // Убедитесь, что панель может получать фокус для обработки событий
        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Создаем и отображаем окно
            Spider_go movingImage = new Spider_go();
            movingImage.setVisible(true);
        });
    }
}
