package Ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Vista.Cliente;

public class VentanaSeguir extends JFrame {

	private String nombreASeguir;
	
	public  VentanaSeguir() {
		super("Ventana de seguimiento");
		JFrame ventana = new JFrame();
		JPanel principal = new JPanel(new BorderLayout());
		JLabel encabezado = new JLabel("Dime el nombre del usuario que deseas seguir");
		principal.add(encabezado, BorderLayout.NORTH);
		
		JPanel central = new JPanel(new BorderLayout());
		JLabel nombre = new JLabel("Nombre:");
		JTextField textoNombre = new JTextField(20);
		central.add(nombre, BorderLayout.EAST);
		central.add(textoNombre, BorderLayout.WEST);
		principal.add(central, BorderLayout.CENTER);
		
		nombreASeguir = textoNombre.getText();
		
		JButton seguir = new JButton("Seguir");
		principal.add(seguir, BorderLayout.SOUTH);	
		seguir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Cliente().enviar(nombreASeguir);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		
		this.add(principal);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		pack();
		
		
	}
}
