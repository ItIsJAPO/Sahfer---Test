package com.sahfer.itisjapo.project1.view;

import com.sahfer.itisjapo.project1.dao.VendedoresDAO;
import com.sahfer.itisjapo.project1.entity.Vendedores;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewConsulta extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable table;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        try {
//            ViewConsulta dialog = new ViewConsulta();
//            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//            dialog.setVisible(true);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Create the dialog.
     */
    public ViewConsulta() {

        List<Vendedores> v = new VendedoresDAO().getAll();
        System.out.println(v.size());
        System.out.println(v.toArray().toString());
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(null, "Datos dentro de la base de datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
            panel.setBounds(10, 11, 414, 206);
            contentPanel.add(panel);
            panel.setLayout(null);

            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setBounds(10, 27, 394, 168);
            panel.add(scrollPane);

            Object[] columnNames = {"ID", "Nombre", "Ciudad", "Ventas"};
            DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);
            for (Vendedores vlist : v) {
                Object[] o = new Object[4];
                o[0] = vlist.getIdVendedor();
                o[1] = vlist.getNombre();
                o[2] =vlist.getCiudad();
                o[3]=vlist.getVentas();
                model.addRow(o);
            }
            

            table = new JTable();
            table.setColumnSelectionAllowed(true);
            table.setCellSelectionEnabled(true);
            table.setFillsViewportHeight(true);
            table.setEnabled(false);
            scrollPane.setViewportView(table);
            table.setModel(model);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("OK");
                okButton.setActionCommand("OK");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
        }
    }
}
