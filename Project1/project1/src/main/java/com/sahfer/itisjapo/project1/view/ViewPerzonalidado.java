package com.sahfer.itisjapo.project1.view;

import com.sahfer.itisjapo.project1.dao.VendedoresDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPerzonalidado extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextArea txtrResultados;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        try {
//            ViewPerzonalidado dialog = new ViewPerzonalidado();
//            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//            dialog.setVisible(true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Create the dialog.
     */
    public ViewPerzonalidado() {
        setBounds(100, 100, 510, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblNewLabel = new JLabel("Ingrese query: ");
            lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
            lblNewLabel.setBounds(10, 11, 129, 28);
            contentPanel.add(lblNewLabel);
        }
        {
            textField = new JTextField();
            textField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    txtrResultados.setText(runQuery(textField.getText()));
                }
            });
            textField.setBounds(10, 39, 375, 20);
            contentPanel.add(textField);
            textField.setColumns(10);
        }
        {
            JButton btnEjecutar = new JButton("Ejecutar");
            btnEjecutar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    txtrResultados.setText(runQuery(textField.getText()));
                }
            });
            btnEjecutar.setBounds(395, 38, 89, 23);
            contentPanel.add(btnEjecutar);
        }

        txtrResultados = new JTextArea();
        txtrResultados.setText("Resultados:");
        txtrResultados.setBounds(10, 70, 474, 180);
        contentPanel.add(txtrResultados);
    }

    public String runQuery(String query) {
        java.util.List<String[]> data = new VendedoresDAO().runQuery(query);
        String temp = "";
        for (int i = 0; i < data.size(); i++) {
            temp += data.get(i) + "\n";
        }
        return temp;
    }
}
