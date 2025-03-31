import javax.swing.*;
import java.awt.event.*;

public class app extends JFrame {

    public app() {
        setTitle("Ввод имени");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // При запуске окна показываем диалог для ввода имени
        String name = JOptionPane.showInputDialog(this, "Введите ваше имя:");

        if (name != null && !name.trim().isEmpty()) {
            // Если имя не пустое, показываем информационное окно
            JOptionPane.showMessageDialog(this, "Ваше имя: " + name);
        } else {
            // Если имя не введено, показываем сообщение об ошибке
            JOptionPane.showMessageDialog(this, "Вы не ввели имя!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Создаем и показываем окно
                app frame = new app();
                frame.setVisible(true);
            }
        });
    }
}
