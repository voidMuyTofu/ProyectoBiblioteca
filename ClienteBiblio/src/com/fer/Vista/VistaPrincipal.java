package com.fer.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class VistaPrincipal extends JFrame {
	public JLabel lblBibliotecaOnline;
	public JButton btLibro1;
	public JButton btLibro2;
	public JButton btLibro3;

	public VistaPrincipal() {
		
		setSize(435,275);
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
		    return new ColorUIResource(new Color(174, 214, 241));
		  }
		}
			setUndecorated(true);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			
			lblBibliotecaOnline = new JLabel("Biblioteca Online");
			lblBibliotecaOnline.setFont(new Font("Consolas", Font.BOLD, 17));
			lblBibliotecaOnline.setBounds(132, 26, 177, 14);
			getContentPane().add(lblBibliotecaOnline);
			
			btLibro1 = new JButton("Libro 1");
			btLibro1.setBounds(27, 101, 104, 42);
			getContentPane().add(btLibro1);
			
			btLibro2 = new JButton("Libro 2");
			btLibro2.setBounds(161, 101, 104, 42);
			getContentPane().add(btLibro2);
			
			btLibro3 = new JButton("Libro 3");
			btLibro3.setBounds(289, 101, 104, 42);
			getContentPane().add(btLibro3);
			setActionCommands();
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
		}
		public void addListeners(ActionListener listener) {
			btLibro1.addActionListener(listener);
			btLibro2.addActionListener(listener);
			btLibro3.addActionListener(listener);
		}
		public void setActionCommands() {
			btLibro1.setActionCommand("libro1");
			btLibro2.setActionCommand("libro2");
			btLibro3.setActionCommand("libro3");
		}
}
