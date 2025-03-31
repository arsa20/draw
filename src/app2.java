import javax.swing.*;
public class app2 {
    public static void main(String[] args) {
        String dim [] ={"300x300","640x480","800x768","1024x800","1200x1024"};
        Object d= JOptionPane.showInputDialog(null,"Choice dimension","Dimension",JOptionPane.QUESTION_MESSAGE,null,dim,dim[0]);
        String a [] =d.toString().split("x");
        System.out.println(a[0]+" "+a[1]);
        JFrame frame = new JFrame();
        frame.setSize(Integer.parseInt(a[0]),Integer.parseInt(a[1]));
        frame.setVisible(true);
    }
}