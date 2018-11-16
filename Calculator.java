import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    public static void main(String args[]){
        new GUI();
    }
}

public class GUI extends JFrame implements ActionListener{
    private JButton number;

    public GUI(){
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setTitle("Calculator");
        GUI.setSize(200,350);
        GUI.setResizable(false);
        GUI.setVisible(true);

        number = new JButton("1");
        GUI.add(number);

    }
public void actionPerformed(ActionEvent e){

}
}


