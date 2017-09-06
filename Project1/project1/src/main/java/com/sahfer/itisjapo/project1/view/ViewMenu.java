package com.sahfer.itisjapo.project1.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMenu {

	private JFrame frmHpVentas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMenu window = new ViewMenu();
					window.frmHpVentas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHpVentas = new JFrame();
		frmHpVentas.setTitle("HP - Ventas");
		frmHpVentas.setBounds(100, 100, 257, 188);
		frmHpVentas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHpVentas.getContentPane().setLayout(null);
		
		JButton btnAltas = new JButton("Altas");
		btnAltas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewAltas altas=new ViewAltas();
				
				altas.setVisible(true);
			}
		});
		btnAltas.setBounds(59, 11, 126, 23);
		frmHpVentas.getContentPane().add(btnAltas);
		
		JButton btnBajas = new JButton("Bajas");
		btnBajas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBaja bajas=new ViewBaja();
				bajas.setVisible(true);
			}
		});
		btnBajas.setBounds(59, 45, 126, 23);
		frmHpVentas.getContentPane().add(btnBajas);
		
		JButton btnConsultas = new JButton("Consultas");
		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewConsulta con=new ViewConsulta();
				con.setVisible(true);
			}
		});
		btnConsultas.setBounds(59, 79, 126, 23);
		frmHpVentas.getContentPane().add(btnConsultas);
		
		JButton btnLibre = new JButton("Libre");
		btnLibre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewPerzonalidado().setVisible(true);
			}
		});
		btnLibre.setBounds(59, 113, 126, 23);
		frmHpVentas.getContentPane().add(btnLibre);
	}
}
