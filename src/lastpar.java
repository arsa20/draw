import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lastpar extends JDialog {
    private String selectedResolution = "1920x1080";  // Значение по умолчанию

    public lastpar(JFrame parent) {
        super(parent, "Выбор разрешения", true);
        setLayout(new BorderLayout());

        // Панель для радиокнопок
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Создание радиокнопок для разрешений
        JRadioButton radio1 = new JRadioButton("1920x1080");
        JRadioButton radio2 = new JRadioButton("1280x720");
        JRadioButton radio3 = new JRadioButton("1024x768");

        // Группа радиокнопок, чтобы можно было выбрать только одну
        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);

        // Добавляем радиокнопки в панель
        panel.add(radio1);
        panel.add(radio2);
        panel.add(radio3);

        // Устанавливаем по умолчанию выбранной радиокнопкой первую
        radio1.setSelected(true);

        // Кнопка для подтверждения выбора
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Получаем выбранное разрешение
                if (radio1.isSelected()) {
                    selectedResolution = "1920x1080";
                } else if (radio2.isSelected()) {
                    selectedResolution = "1280x720";
                } else if (radio3.isSelected()) {
                    selectedResolution = "1024x768";
                }
                // Закрываем диалоговое окно
                dispose();
            }
        });

        // Добавляем панель с радиокнопками и кнопку "OK"
        add(panel, BorderLayout.CENTER);
        add(okButton, BorderLayout.SOUTH);

        // Настройки окна
        setSize(300, 200);
        setLocationRelativeTo(parent);
    }

    // Метод для получения выбранного разрешения
    public String getSelectedResolution() {
        return selectedResolution;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Создаем главное окно
                JFrame mainFrame = new JFrame("Главное окно");
                mainFrame.setSize(400, 300);
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Создаем диалоговое окно для выбора разрешения
                lastpar dialog = new lastpar(mainFrame);
                dialog.setVisible(true);

                // Получаем выбранное разрешение
                String resolution = dialog.getSelectedResolution();
                System.out.println("Вы выбрали разрешение: " + resolution);

                // Отображаем окно с выбранным разрешением
                JOptionPane.showMessageDialog(mainFrame, "Вы выбрали разрешение: " + resolution);

                mainFrame.setVisible(true);
            }
        });
    }
}
