import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    public static void main(String args[]){
        new GUI();
    }
}

class GUI extends JFrame implements ActionListener{
    JButton[] number = new JButton[10]; // 0-9 buttons
    JButton[] operator = new JButton[6]; // +,-,x,/,=, clear
    JPanel numbers = new JPanel (new GridLayout(4,3)); //creates number panel 0-9
    JPanel operators = new JPanel (new GridLayout(3,2));

    public GUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setSize(380,400);
        setResizable(false);
        setLayout(null);
        setVisible(true);

        CreateNumbersJPanel();
        numbers.setBounds(50,100,125,125);
        add(numbers);

        CreateOperatorsJPanel();
        operators.setBounds(200,100,125,125);
        add(operators);
    }
    public void actionPerformed(ActionEvent e){

    }

    private void CreateNumbersJPanel(){
        for(int i=0;i<number.length;i++){
            number[i] = new JButton(Integer.toString(i)); //from int to String
            number[i].addActionListener(this); //pressing the button
            numbers.add(number[i]); //add the buttons 0-9

        }
    }

    private void CreateOperatorsJPanel(){
        operator[0] = new JButton("+");
        operator[1] = new JButton("-");
        operator[2] = new JButton("x");
        operator[3] = new JButton("÷");
        operator[4] = new JButton("=");
        operator[5] = new JButton("C");

        for(JButton o:operator) //for each loop
            operators.add(o);
    }
}


