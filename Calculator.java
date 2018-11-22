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
    JPanel numbers = new JPanel (new GridLayout(4,3)); //creates number panel 0-9 (y,x)
    JPanel operators = new JPanel (new GridLayout(3,2));

    JTextArea result = new JTextArea();
    String[] input = {"","",""}; //first number, operator, second number

    public GUI(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setSize(380,300);
        setResizable(false);
        setLayout(null);
        setVisible(true);

        CreateNumbersJPanel();
        numbers.setBounds(50,100,125,125);
        add(numbers);

        CreateOperatorsJPanel();
        operators.setBounds(200,100,125,125);
        add(operators);

        result.setBounds(0,0,380,50);
        add(result);
    }

    public void actionPerformed(ActionEvent e){
//FOR NUMBERS
        for(JButton button: number){
            if(e.getSource().equals(button)){
                if(input[1].equals("")){
                    input[0] = input[0]+button.getText();
                    result.setText(input[0]);
                }
                else{
                    input[2] = input[2]+button.getText();
                    result.setText(input[2]);
                }
            }
        }
//FOR OPERATORS
        for(JButton button: operator){
            if(e.getSource().equals(button)){
                if(button.getText().equals("=")){
                    Show();
                }
                else if(button.getText().equals("C")){
                    Clear();
                }
                else{
                    result.setText("");
                    input[1]= button.getText();
                }
            }
        }
    }

    private void CreateNumbersJPanel(){
        for(int i=0;i<number.length;i++){
            number[i] = new JButton(Integer.toString(i)); // converts integers 0-9 to String to print them on buttons
            number[i].addActionListener(this);
            numbers.add(number[i]); //add the buttons 0-9

        }
    }

    private void CreateOperatorsJPanel() {
        //creating each button seperately
        operator[0] = new JButton("+");
        operator[1] = new JButton("-");
        operator[2] = new JButton("x");
        operator[3] = new JButton("/");
        operator[4] = new JButton("=");
        operator[5] = new JButton("C");

        for (JButton o : operator) { //for each loop to add each button from array
            o.addActionListener(this);
            operators.add(o);
        }
    }

    private void Clear() {
        input[0] = input[1] = input[2] = ""; //clears the inputs
        result.setText(""); //clears the JTextArea
    }

    private int Calculation(String calc){
        if(calc.equals("+")){
            return Integer.parseInt(input[0])+Integer.parseInt(input[2]);
        }
        else if(calc.equals("-")){
            return Integer.parseInt(input[0])-Integer.parseInt(input[2]);
        }
        else if(calc.equals("x")){
            return Integer.parseInt(input[0])*Integer.parseInt(input[2]);
        }
        else if(calc.equals("/")){
            return Integer.parseInt(input[0])/Integer.parseInt(input[2]);
        }
        else
            return 0;
    }

    private void Show(){
        result.setText(Integer.toString(Calculation(input[1])));
        input[0] = result.getText();
        input[1] = "";
        input[2] = "";
    }
}


