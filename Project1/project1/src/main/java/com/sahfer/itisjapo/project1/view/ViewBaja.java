package com.sahfer.itisjapo.project1.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sahfer.itisjapo.project1.dao.VendedoresDAO;
import com.sahfer.itisjapo.project1.entity.Vendedores;

public class ViewBaja extends JDialog {

	 private final JPanel contentPanel = new JPanel();
	    private JTextField txtid;
	    private JLabel lblID;
	    private JLabel lblNOMBRE;
	    private JLabel lblCIUDAD;
	    private JLabel lblVENTA;
	    private JButton btnConfirmarEliminar;
	    private Vendedores v;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewBaja dialog = new ViewBaja();
//					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//					dialog.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the dialog.
	 */
	public ViewBaja() {

        setBounds(100, 100, 355, 355);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEFT, TitledBorder.TOP, null, null));
            panel.setBounds(10, 11, 319, 57);
            contentPanel.add(panel);
            panel.setLayout(null);
            {
                JLabel lblId = new JLabel("ID");
                lblId.setBounds(10, 23, 46, 14);
                panel.add(lblId);
            }
            {
                txtid = new JTextField();
                txtid.setBounds(52, 20, 86, 20);
                panel.add(txtid);
                txtid.setColumns(10);
            }
            {
                JButton btnBuscar = new JButton("Buscar");
                btnBuscar.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                         v = new VendedoresDAO().findVendedores(Integer.parseInt(txtid.getText()));
                        if (v == null) {
                            lblID.setText("No se encontro");
                            lblNOMBRE.setText(null);
                            lblCIUDAD.setText(null);
                            lblVENTA.setText(null);
                            btnConfirmarEliminar.setVisible(false);
                        } else {
                            lblID.setText(v.getIdVendedor().toString());
                            lblNOMBRE.setText(v.getNombre());
                            lblCIUDAD.setText(v.getCiudad());
                            lblVENTA.setText(v.getVentas().toString());
                            btnConfirmarEliminar.setVisible(true);
                        }
                    }
                });
                btnBuscar.setBounds(162, 19, 89, 23);
                panel.add(btnBuscar);
            }
        }
        {
            JPanel panel = new JPanel();
            panel.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEFT, TitledBorder.TOP, null, null));
            panel.setBounds(10, 79, 319, 193);
            contentPanel.add(panel);
            panel.setLayout(null);
            {
                JLabel lblId_1 = new JLabel("ID:");
                lblId_1.setBounds(10, 28, 64, 14);
                panel.add(lblId_1);
            }
            {
                JLabel lblNombre = new JLabel("Nombre:");
                lblNombre.setBounds(10, 53, 64, 14);
                panel.add(lblNombre);
            }
            {
                JLabel lblCiudad = new JLabel("Ciudad:");
                lblCiudad.setBounds(10, 78, 64, 14);
                panel.add(lblCiudad);
            }
            {
                JLabel lblVenta = new JLabel("Venta:");
                lblVenta.setBounds(10, 103, 64, 14);
                panel.add(lblVenta);
            }
            {
                lblID = new JLabel("");
                lblID.setBounds(100, 28, 209, 14);
                panel.add(lblID);
            }
            {
                lblNOMBRE = new JLabel("");
                lblNOMBRE.setBounds(100, 53, 209, 14);
                panel.add(lblNOMBRE);
            }
            {
                lblCIUDAD = new JLabel("");
                lblCIUDAD.setBounds(100, 78, 209, 14);
                panel.add(lblCIUDAD);
            }
            {
                lblVENTA = new JLabel("");
                lblVENTA.setBounds(100, 103, 209, 14);
                panel.add(lblVENTA);
            }
            {
                btnConfirmarEliminar = new JButton("<html><center>Confirmar<br>eliminar</center></html>");
                btnConfirmarEliminar.setVisible(false);
                btnConfirmarEliminar.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent arg0) {
                		new VendedoresDAO().deleteVendedor(v);
                        lblID.setText("No se encontro");
                        lblNOMBRE.setText(null);
                        lblCIUDAD.setText(null);
                        lblVENTA.setText(null);
                        btnConfirmarEliminar.setVisible(false);
                	}
                });
                btnConfirmarEliminar.setBounds(92, 128, 100, 43);
                panel.add(btnConfirmarEliminar);
            }
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
