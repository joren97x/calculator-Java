package calc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numBtn = new JButton[10];
    JButton[] funcBtn = new JButton[8];
    JButton addBtn, subBtn, mulBtn, divBtn;
    JButton decimalBtn, equalBtn, clearBtn, deleteBtn;
    JPanel panel;
    Font font = new Font("Monospaced", Font.BOLD, 30);

    double n1 = 0, n2= 0, result = 0;
    char operator;

    Calculator() {
        
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,450);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(28, 50, 275, 50);
        textfield.setFont(font);
        textfield.setEditable(false);

        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        decimalBtn = new JButton(".");
        equalBtn = new JButton("=");
        clearBtn = new JButton("clr");
        deleteBtn = new JButton("del");

        funcBtn[0] = addBtn;
        funcBtn[1] = subBtn;
        funcBtn[2] = mulBtn;
        funcBtn[3] = divBtn;
        funcBtn[4] = decimalBtn;
        funcBtn[5] = equalBtn;
        funcBtn[6] = clearBtn;
        funcBtn[7] = deleteBtn;

        for(int i = 0; i < 8; i++) {
            funcBtn[i].addActionListener(this);
            funcBtn[i].setFont(font);
        }
        
        for(int i = 0; i < 10; i++) {
            numBtn[i] = new JButton(String.valueOf(i));
            numBtn[i].addActionListener(this);
            numBtn[i].setFont(font);
        }

        panel = new JPanel();
        panel.setBounds(28, 120, 275, 220);
        panel.setLayout(new GridLayout(4,4, 5, 5));

        deleteBtn.setBounds(27,350, 275/2, 40);
        clearBtn.setBounds(168,350, 275/2, 40);

        panel.add(numBtn[1]);
        panel.add(numBtn[2]);
        panel.add(numBtn[3]);
        panel.add(funcBtn[0]);
        panel.add(numBtn[4]);
        panel.add(numBtn[5]);
        panel.add(numBtn[6]);
        panel.add(funcBtn[1]);
        panel.add(numBtn[7]);
        panel.add(numBtn[8]);
        panel.add(numBtn[9]);
        panel.add(funcBtn[2]);
        panel.add(funcBtn[4]);
        panel.add(numBtn[0]);
        panel.add(funcBtn[5]);
        panel.add(funcBtn[3]);


        frame.add(panel);
        frame.add(clearBtn);
        frame.add(deleteBtn);
        frame.add(textfield);
        frame.setVisible(true);

    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello");
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        for(int i = 0; i < 10; i++) {
            if(e.getSource() == numBtn[i]){
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == deleteBtn) {
            String str = textfield.getText();
            textfield.setText("");
            for(int i = 0; i < str.length()-1; i++) {
                textfield.setText(textfield.getText()+(str.charAt(i)));
            }
        }

        if(e.getSource() == clearBtn) {
            n1 = 0;
            n2 = 0;
            result =0;
            textfield.setText("");
        }

        if(e.getSource() == decimalBtn) {
            textfield.setText(textfield.getText().concat(String.valueOf(".")));
        }
        if(e.getSource() == addBtn) {
            n1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource() == subBtn) {
            n1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource() == mulBtn) {
            n1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource() == divBtn) {
            n1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        if(e.getSource() == equalBtn) {
            n2 = Double.parseDouble(textfield.getText());
            switch(operator) {
                case '+':
                    result = n1 + n2;
                    break;
                case '-':
                    result = n1 - n2;
                    break;
                case '*':
                    result = n1 * n2;
                    break;
                case '/':
                    result = n1 / n2;
                    break;
            }
            textfield.setText(String.valueOf(result));
        }

        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");

    }
}
