package com.fer.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.fer.Vista.VistaLibro;
import com.fer.Vista.VistaPrincipal;
import com.fer.modelo.Libro;

public class Cliente implements ActionListener{
	String ip;
	Cliente(String ip){
		VistaPrincipal vistaPrincipal = new VistaPrincipal();
		vistaPrincipal.addListeners(this);
		this.ip = ip;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "libro1":
			programa("1");
			break;
		case "libro2":
			programa("2");
			break;
		case "libro3":
			programa("3");
			break;
		}
	}
	public void programa(String numLibro) {
		
		try {
			
			int puerto = 6500;
			Socket socket = new Socket(ip, puerto);
			PrintWriter fSalida = new PrintWriter(socket.getOutputStream(),true);
			fSalida.println(numLibro);
			ObjectInputStream oEntrada = new ObjectInputStream(socket.getInputStream());
			Libro libro = (Libro) oEntrada.readObject();
			VistaLibro vistaLibro1 = new VistaLibro(libro);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main (String[]args) {
		new Cliente(args[0]);
	}
}
