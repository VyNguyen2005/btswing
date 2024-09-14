/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaiTap03;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author nguye
 */
public class DemoCalculator3 extends JFrame {

    private JLabel lbNum1, lbNum2, lbPhepTinh, lbResult;
    private JTextField txtNum1, txtNum2, txtResult;
    private JComboBox comboBox;
    private JButton btnTinh, btnNhapLai;

    public DemoCalculator3(String title) {
        super(title);

        createGUI();

        setResizable(false);
        txtResult.setEditable(false);
        setSize(370, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        DemoCalculator3 frame = new DemoCalculator3("Simple Calculator");
        frame.setVisible(true);
    }

    private void createGUI() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(lbNum1 = new JLabel("Số 1"));
        panel.add(txtNum1 = new JTextField());
        panel.add(lbNum2 = new JLabel("Số 2"));
        panel.add(txtNum2 = new JTextField());
        panel.add(lbPhepTinh = new JLabel("Phép tính"));
        String[] items = {"Cộng", "Trừ", "Nhân", "Chia"};
        panel.add(comboBox = new JComboBox(items));
        panel.add(lbResult = new JLabel("Kết quả"));
        panel.add(txtResult = new JTextField());

        panel.add(btnTinh = new JButton("Tính"));
        panel.add(btnNhapLai = new JButton("Nhập lại"));

        comboBox.setSelectedIndex(0);

        lbNum1.setBounds(30, 20, 80, 30);
        txtNum1.setBounds(120, 20, 200, 30);

        lbNum2.setBounds(30, 70, 80, 30);
        txtNum2.setBounds(120, 70, 200, 30);

        lbPhepTinh.setBounds(30, 120, 100, 30);
        comboBox.setBounds(120, 120, 200, 30);

        lbResult.setBounds(30, 170, 80, 30);
        txtResult.setBounds(120, 170, 200, 30);

        btnTinh.setBounds(55, 220, 120, 30);
        btnNhapLai.setBounds(185, 220, 120, 30);

        add(panel);

        btnTinh.addActionListener(
                (e) -> {

                    txtResult.setBackground(Color.white);

                    Object selectedItem = comboBox.getSelectedItem();
                    String pheptinh = selectedItem.toString();

                    String text1 = txtNum1.getText().trim();
                    String text2 = txtNum2.getText().trim();

                    if (text1.isEmpty() || text2.isEmpty()) {
                        txtResult.setText("Nội dung TextBox không được rỗng");
                        txtResult.setBackground(Color.red);
                        return;
                    } else if (!tryParseDouble(text1) || !tryParseDouble(text2)) {
                        txtResult.setText("Nội dung TextBox phải là kiểu số");
                        txtResult.setBackground(Color.red);
                        return;
                    } else {
                        double Num1 = Double.parseDouble(txtNum1.getText());
                        double Num2 = Double.parseDouble(txtNum2.getText());
                        double result = 0.0;

                        switch (pheptinh) {
                            case "Cộng":
                                result = Num1 + Num2;
                                break;
                            case "Trừ":
                                result = Num1 - Num2;
                                break;
                            case "Nhân":
                                result = Num1 * Num2;
                                break;
                            case "Chia":
                                if (Num2 == 0) {
                                    txtResult.setText("Không chia được cho 0");
                                    txtResult.setBackground(Color.red);
                                    return;
                                } else {
                                    result = Num1 / Num2;
                                }
                            default:
                                txtResult.setText("Vui lòng chọn phép tính");
                                txtResult.setBackground(Color.white);
                                break;
                        }
                        txtResult.setText(String.valueOf(result));
                    }

                }
        );

        btnNhapLai.addActionListener(
                (e) -> {
                    txtNum1.setText("");
                    txtNum2.setText("");
                    comboBox.setSelectedIndex(0);
                    txtResult.setText("");
                    txtResult.setBackground(Color.white);
                    txtNum1.requestFocus();
                }
        );

        txtNum1.setFocusable(true);

    }

    public boolean tryParseDouble(String text) {
        try {
            Double.parseDouble(text);
            return true;
        } catch (NumberFormatException e) {
            txtResult.setText("Nội dung TextBox không được rỗng");
            return false;
        }
    }
}
