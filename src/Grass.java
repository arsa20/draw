import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Grass {
    static JFrame frame = new JFrame();//создаем форму
    static int size=50;//размер текстуры

    public static class AddTextura {//класс для добавления текстур
        public JLabel l;
        public AddTextura(BufferedImage im, int i, int j) {//получаем на вход картинку и шаги циклов
            l = new JLabel(new ImageIcon(im));//создаем объект с текстурой
            l.setBounds(i*size, j*size, size, size);//устанавливаем его координаты
            frame.add(l);//добавляем на форму
        }
    }

    public static void main(String[] args) throws IOException {
        int width=800, height=600;//задаем размер окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//способ выхода из формы
        frame.setTitle("Текстура");//заголовок формы
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//определяем разрешение монитора
        frame.setBounds(dim.width / 2 - width / 2, dim.height / 2 - height / 2, width, height);//выставляем размеры окна
        BufferedImage im = ImageIO.read(new URL("https://www.honda.co.uk/engineroom/power/preparing-your-garden-for-winter/assets/88FVGBDtZ1/grass-2560x1440.jpeg")).getSubimage(0,0,size,size);//скачиваем картинку с травой и обрезаем ее
        for (int i = 0; i <= width/size; i++)
            for (int j = 0; j <= height/size; j++)
                new AddTextura(im,i,j);//создаем объект с текстурой и размещаем его в цикле
        frame.setVisible(true);//делаем форму видимой
    }
}