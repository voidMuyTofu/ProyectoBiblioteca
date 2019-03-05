package com.fer.Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

import com.fer.modelo.Libro;


public class VistaLibro extends JFrame implements ActionListener{
	public JButton btAnterior;
	public JButton btSiguiente;
	public JLabel lbPagina;
	public JTextArea area;
	public Libro libro;
	ArrayList<String> lineas;
	public int pagina=0;
	public BufferedReader fr;
	public JScrollPane scrollPane;
	public VistaLibro(Libro libro) {
		this.libro = libro;
		
		class MyDefaultMetalTheme extends DefaultMetalTheme {

			//Cada método establece el color de una parte de la ventan

			/**
			 * Establece el fondo del titulo de la ventana cuando está inactiva	
			 * Con el get nos devuelve el color mediante la devolución de un objeto
			 * ColorUIResource.
			 */
			public ColorUIResource getWindowTitleInactiveBackground() {
				return new ColorUIResource(Color.red);
			}

			/**
			 * Establece el fondo del titulo de la ventana cuando está activa	
			 */
			public ColorUIResource getWindowTitleBackground() {
				return new ColorUIResource(Color.white);
			}
			/*
			 * 
			 * Los siguientes son para partes específicas de la ventana*/

		  //Color del contorno de los controles de la barra de titulo
		  public ColorUIResource getPrimaryControlDarkShadow() {
		    return new ColorUIResource(Color.black);
		  }

		  //color del boton que contiene los controles de la ventana del titulo 
		  public ColorUIResource getPrimaryControl() {
		    return new ColorUIResource(Color.white);
		  }

		  //Cambia el fondo de la aplicación
		  public ColorUIResource getControl() {
		    return new ColorUIResource(new Color(171, 235, 198));
		  }
		}
		lineas = libro.getLibro();
		
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(555,456);
		getContentPane().setLayout(null);
		
		btAnterior = new JButton("Anterior");
		btAnterior.setBounds(27, 336, 121, 41);
		getContentPane().add(btAnterior);
		btAnterior.setBackground(Color.WHITE);
		btAnterior.setEnabled(false);
		
		btSiguiente = new JButton("Siguiente");
		btSiguiente.setBounds(387, 336, 121, 41);
		getContentPane().add(btSiguiente);
		btSiguiente.setBackground(Color.WHITE);
		addListeners(this);
		setActionCommands();
		
		lbPagina = new JLabel("Pagina 1");
		lbPagina.setFont(new Font("Consolas", Font.PLAIN, 17));
		lbPagina.setBounds(232, 341, 92, 29);
		getContentPane().add(lbPagina);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 25, 481, 300);
		
		
		
		
		area = new JTextArea();
		area.setBounds(27, 25, 481, 300);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		scrollPane.setViewportView(area);
		getContentPane().add(scrollPane);
		rellenarPagina(libro.getLibro(), pagina);
		//permite que la decoración del Frame sea la de LookAndFeel
		this.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

		try {
			//Primero cambiamos el tema, el theme.
			//Añade la barra del título con los botones minimizar, maximizar y cerrar
			//con los colores que tengamos definidos en la clase MyDefaultMetalTheme
			//que hereda para ello de la clase DefaultMetalTheme
			MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalTheme());
			UIManager.setLookAndFeel(new MetalLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Esta sentencia hace posible que podamos cambiar el estilo
		//a nuestro gusto cada vez que cambie el estado de la ventana
		SwingUtilities.updateComponentTreeUI(this);
		//area.append("Bienvenido al libro " + libro.getTitulo() + " pulse Siguiente para comenzar a leer");
		
	}
	public void rellenarPagina(List libro,int pagina) {
		area.append((String) libro.get(pagina));
	}
	public void addListeners(ActionListener listener) {
		btSiguiente.addActionListener(listener);
		btAnterior.addActionListener(listener);
	}
	public void setActionCommands() {
		btSiguiente.setActionCommand("siguiente");
		btAnterior.setActionCommand("anterior");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		
		case "siguiente":
			
			area.setText("");
			pagina++;
			rellenarPagina(lineas,pagina);
			lbPagina.setText("Pagina " + String.valueOf(pagina+1));
			btAnterior.setEnabled(true);
			if((pagina+1)>=lineas.size())
				btSiguiente.setEnabled(false);
			break;
			
		case "anterior":
			area.setText("");
			pagina--;
			rellenarPagina(lineas,pagina);
			lbPagina.setText("Pagina " + String.valueOf(pagina+1));
			btSiguiente.setEnabled(true);
			if(pagina<=0)
				btAnterior.setEnabled(false);
			break;
		}
	}
}

