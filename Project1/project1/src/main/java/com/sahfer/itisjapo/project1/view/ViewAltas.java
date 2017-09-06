package com.sahfer.itisjapo.project1.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.sahfer.itisjapo.project1.dao.VendedoresDAO;
import com.sahfer.itisjapo.project1.entity.Vendedores;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Dialog.ModalityType;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewAltas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtnombre;
	private JTextField txtciudad;
	private JTextField txtventas;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ViewAltas dialog = new ViewAltas();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public ViewAltas() {
		setResizable(false);
		setModal(true);
		setModalityType(ModalityType.TOOLKIT_MODAL);
		setBounds(100, 100, 362, 239);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Dar alta:  ", TitledBorder.LEFT,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 11, 296, 124);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 28, 76, 14);
		panel.add(lblNombre);

		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 53, 76, 14);
		panel.add(lblCiudad);

		JLabel lblVentas = new JLabel("Ventas:");
		lblVentas.setBounds(10, 81, 76, 14);
		panel.add(lblVentas);

		txtnombre = new JTextField();
		txtnombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtnombre.setBounds(96, 25, 162, 20);
		panel.add(txtnombre);
		txtnombre.setColumns(10);

		txtciudad = new JTextField();
		txtciudad.setHorizontalAlignment(SwingConstants.CENTER);
		txtciudad.setBounds(96, 50, 162, 20);
		panel.add(txtciudad);
		txtciudad.setColumns(10);

		txtventas = new JTextField();
		txtventas.setHorizontalAlignment(SwingConstants.CENTER);
		txtventas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (Character.isLetter(c) && !evt.isAltDown()) {
					evt.consume();
				}
			}
		});
		txtventas.setBounds(96, 78, 162, 20);
		panel.add(txtventas);
		txtventas.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setBounds(44, 134, 207, 14);
		lblEstado.setVisible(false);
		contentPanel.add(lblEstado);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Vendedores v = new Vendedores();
						v.setNombre(txtnombre.getText());
						v.setCiudad(txtciudad.getText());
						v.setVentas(Double.valueOf(txtventas.getText()));
						VendedoresDAO controlador = new VendedoresDAO();
						try {
							controlador.create(v);
							lblEstado.setVisible(true);
							lblEstado.setText("Listo");
							lblEstado.setForeground(Color.GREEN);
							txtnombre.setText(null);
							txtciudad.setText(null);
							txtventas.setText("0.0");
						} catch (Exception e) {
							lblEstado.setVisible(true);
							lblEstado.setText("Hay un error");
							lblEstado.setForeground(Color.RED);
						}

					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Limpiar");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						txtnombre.setText(null);
						txtciudad.setText(null);
						txtventas.setText("0.0");
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
