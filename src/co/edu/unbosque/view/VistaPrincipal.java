package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class VistaPrincipal extends JFrame{
	
	private PanelTablero pTablero;
	private PanelHistorial pHistorial;
	
	public VistaPrincipal() {
		setTitle("Cuatriqui");
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(242, 241, 254));
		getContentPane().setLayout(new BorderLayout());

		inicializarComponentes();

		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void inicializarComponentes() {
		pTablero = new PanelTablero();
		getContentPane().add(pTablero, BorderLayout.CENTER);
		
		pHistorial = new PanelHistorial();
		getContentPane().add(pHistorial, BorderLayout.EAST);
	}

	public PanelTablero getpTablero() {
		return pTablero;
	}

	public void setpTablero(PanelTablero pTablero) {
		this.pTablero = pTablero;
	}

}