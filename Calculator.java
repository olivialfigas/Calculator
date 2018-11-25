import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * creates a calulator application that can add, subtract,multiply and divide 2 integers
 */
public class Calculator {
    /**
     * main method
     * creating the anonymous class GUI
     * @param args
     */
    public static void main(String args[]){
        new GUI();
    }
}

/**
 * initialises the GUI class
 */
class GUI extends JFrame implements ActionListener{
    JButton[] number = new JButton[10]; // 0-9 buttons
    JButton[] operator = new JButton[6]; // +,-,x,/,=, clear
    JPanel numbers = new JPanel (new GridLayout(4,3)); //creates number panel 0-9 (y,x)
    JPanel operators = new JPanel (new GridLayout(3,2));

    JTextArea result = new JTextArea();
    String[] input = {"","",""}; //first number, operator, second number

    /**
     * creates the JFrame and sets its parameters
     */
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

    /**
     * the numbers loop: when the operators (input 1) is empty,
     * input the first number (input 0),
     * otherwise, ask for second number (input 2).
     *
     * the operators
     * the numbers loop: when the operators is =,
     * then perform Show(), when the operators is C,
     * then perform Clear(), otherwise,
     * goto input 2
     *
     * @param e event handler
     */
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

    /**
     * creates and displays the buttons 0-9
     */
    private void CreateNumbersJPanel(){
        for(int i=0;i<number.length;i++){
            number[i] = new JButton(Integer.toString(i)); // converts integers 0-9 to String to print them on buttons
            number[i].addActionListener(this);
            numbers.add(number[i]); //add the buttons 0-9

        }
    }

    /**
     * creates and displays the buttons +,-,x,/,=,C
     */
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

    /**
     * creates the clear
     * the clear sets the values of input 0, 1 and 2 to an empty String
     * and the text in the JTextArea to an empty String
     */
    private void Clear(){
        input[0] = input[1] = input[2] = ""; //sets the inputs to nothing
        result.setText(""); //sets the text to nothing
    }

    /**
     * creates the operations beneath the operator buttons +,-,x,/
     * @param calc takes in the the operator in use
     * @return returns the value of the operators
     */
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

    /**
     * displays the inputs in the JTextArea
     */
    private void Show(){
        result.setText(Integer.toString(Calculation(input[1])));
        input[0] = result.getText();
        input[1] = "";
        input[2] = "";
    }
}


