/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTap01;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class DemoCalculator1 extends JFrame {

    private JLabel lbNum1, lbNum2, lbResult;
    private JTextField txtNum1, txtNum2, txtResult;
    private JButton btnAdd, btnSub, btnMul, btnDiv, btnExit;

    public DemoCalculator1(String title) {
        super(title);

        createGUI();

        setResizable(false);
        txtResult.setEditable(false);
        setSize(550, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public static void main(String[] args) {
        DemoCalculator1 frame = new DemoCalculator1("Simple Calculator");
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
        panel.add(btnExit = new JButton("Exit"));

        btnAdd.setIcon(new ImageIcon(this.getClass().getResource("/images/add.png")));
        btnSub.setIcon(new ImageIcon(this.getClass().getResource("/images/sub.png")));
        btnMul.setIcon(new ImageIcon(this.getClass().getResource("/images/cancel.png")));
        btnDiv.setIcon(new ImageIcon(this.getClass().getResource("/images/divide.png")));
        btnExit.setIcon(new ImageIcon(this.getClass().getResource("/images/exit.png")));

        lbNum1.setBounds(30, 20, 180, 30);
        txtNum1.setBounds(100, 20, 370, 30);

        lbNum2.setBounds(30, 70, 180, 30);
        txtNum2.setBounds(100, 70, 370, 30);

        lbResult.setBounds(30, 110, 180, 30);
        txtResult.setBounds(100, 110, 370, 30);

        btnAdd.setBounds(30, 160, 90, 30);
        btnSub.setBounds(130, 160, 90, 30);
        btnMul.setBounds(230, 160, 90, 30);
        btnDiv.setBounds(330, 160, 90, 30);
        btnExit.setBounds(430, 160, 90, 30);

        add(panel);

        btnAdd.addActionListener((e) -> {
            txtResult.setBackground(Color.white);
                double Num1 = Double.parseDouble(txtNum1.getText());
                double Num2 = Double.parseDouble(txtNum2.getText());

                double kq = Num1 + Num2;

                txtResult.setText(String.valueOf(kq));
        });

        btnSub.addActionListener((e) -> {
            txtResult.setBackground(Color.white);
            double Num1 = Double.parseDouble(txtNum1.getText());
            double Num2 = Double.parseDouble(txtNum2.getText());

            double kq = Num1 - Num2;

            txtResult.setText(String.valueOf(kq));
        });

        btnMul.addActionListener((e) -> {
            txtResult.setBackground(Color.white);
            double Num1 = Double.parseDouble(txtNum1.getText());
            double Num2 = Double.parseDouble(txtNum2.getText());

            double kq = Num1 * Num2;

            txtResult.setText(String.valueOf(kq));
        });

        btnDiv.addActionListener((e) -> {
            txtResult.setBackground(Color.white);
            double Num1 = Double.parseDouble(txtNum1.getText());
            double Num2 = Double.parseDouble(txtNum2.getText());
            if (Num2 == 0) {
                txtResult.setText("Không chia được cho 0");
                txtResult.setBackground(Color.red);
            } else {
                double kq = Num1 / Num2;
                txtResult.setText(String.valueOf(kq));
            }
        });

        btnExit.addActionListener((e) -> {
            int option = JOptionPane.showConfirmDialog(null, "Xác nhận", "Bạn có chắc chắn muốn đóng ứng dụng?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (option == JOptionPane.OK_OPTION) {
                System.exit(0);
            }

        });
    }

}
