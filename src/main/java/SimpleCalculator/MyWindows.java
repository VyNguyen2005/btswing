/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SimpleCalculator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

/**
 *
 * @author ADMIN
 */
public class MyWindows extends JFrame{
    private JLabel lbNum1, lbNum2, lbResult;
    private JTextField txtNum1, txtNum2, txtResult;
    private JButton btnAdd, btnSub, btnMul, btnDiv;

    public MyWindows(String title){
        super(title);
        
        createGUI();
        
        setResizable(false);
        txtResult.setEditable(false);
        setSize(450, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        MyWindows frame = new MyWindows("Simple Calculator");
        frame.setVisible(true);
    }

    private void createGUI() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(lbNum1 = new JLabel("Number 1"));
        panel.add(txtNum1 = new JTextField());
        panel.add(lbNum2 = new JLabel("Number 2"));
        panel.add(txtNum2 = new JTextField());
        panel.add(lbResult = new JLabel("Result"));
        panel.add(txtResult = new JTextField());

        panel.add(btnAdd = new JButton("Add"));
        panel.add(btnSub = new JButton("Sub"));
        panel.add(btnMul = new JButton("Mul"));
        panel.add(btnDiv = new JButton("Div"));
        
        btnAdd.setIcon(new ImageIcon(this.getClass().getResource("/images/add.png")));
        btnSub.setIcon(new ImageIcon(this.getClass().getResource("/images/sub.png")));
        btnMul.setIcon(new ImageIcon(this.getClass().getResource("/images/cancel.png")));
        btnDiv.setIcon(new ImageIcon(this.getClass().getResource("/images/divide.png")));
        
        lbNum1.setBounds(30, 10, 180, 30);
        txtNum1.setBounds(100, 10, 280, 30);
        
        lbNum2.setBounds(30, 50, 180, 30);
        txtNum2.setBounds(100, 50, 280, 30);
        
        lbResult.setBounds(30, 90, 180, 30);
        txtResult.setBounds(100, 90, 280, 30);
        
        btnAdd.setBounds(30, 140, 90, 30);
        btnSub.setBounds(130, 140, 90, 30);
        btnMul.setBounds(230, 140, 90, 30);
        btnDiv.setBounds(330, 140, 90, 30);
       
        add(panel);
        

        
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double Num1 = Double.parseDouble(txtNum1.getText());
                double Num2 = Double.parseDouble(txtNum2.getText());
                
                double kq = Num1 + Num2;
                
                txtResult.setText(String.valueOf(kq));
            }
        });
        
        btnSub.addActionListener((e) -> {
            double Num1 = Double.parseDouble(txtNum1.getText());
                double Num2 = Double.parseDouble(txtNum2.getText());
                
                double kq = Num1 - Num2;
                
                txtResult.setText(String.valueOf(kq));
        });
        
        btnMul.addActionListener((e) -> {
            double Num1 = Double.parseDouble(txtNum1.getText());
                double Num2 = Double.parseDouble(txtNum2.getText());
                
                double kq = Num1 * Num2;
                
                txtResult.setText(String.valueOf(kq));
        });
        
        btnDiv.addActionListener((e) -> {
            double Num1 = Double.parseDouble(txtNum1.getText());
                double Num2 = Double.parseDouble(txtNum2.getText());
                if(Num2 == 0){
                    txtResult.setText("Không chia được cho 0");
                    txtResult.setBackground(Color.red);
                }
                else{
                    double kq = Num1 / Num2;
                    txtResult.setText(String.valueOf(kq));
                }             
        });
    }
    
}
