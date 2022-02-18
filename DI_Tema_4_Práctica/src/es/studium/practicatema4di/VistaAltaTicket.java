package es.studium.practicatema4di;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class VistaAltaTicket
{

	Frame frmAltaTicket = new Frame("Alta Ticket");
	
	Label lblFechaTicket = new Label("Fecha:");
	TextField txtFechaTicket = new TextField(20); 
	
	Label lblArticulosTicket = new Label("Artículos:");
	Choice choArticulos = new Choice();
	TextArea listadoArticulos = new TextArea(4, 30);
	
	Label lblTotalTicket = new Label("Total ticket:");
	TextField txtTotalTicket = new TextField(20);  
	
	Button btnAceptarTicket = new Button("Aceptar");
	Button btnCancelarTicket = new Button("Cancelar");
	
	Dialog dlgConfirmarAltaTicket = new Dialog(frmAltaTicket, "Alta Ticket", true);
	Label lblMensajeAltaTicket = new Label("Alta de Ticket Correcta");
	
	public VistaAltaTicket()
	{
		frmAltaTicket.setLayout(new FlowLayout());
		
		frmAltaTicket.add(lblFechaTicket);
		frmAltaTicket.add(txtFechaTicket);
		
		frmAltaTicket.add(lblArticulosTicket);
		frmAltaTicket.add(choArticulos);
		frmAltaTicket.add(listadoArticulos);
		frmAltaTicket.add(lblTotalTicket);
		frmAltaTicket.add(txtTotalTicket);
		frmAltaTicket.add(btnAceptarTicket);
		frmAltaTicket.add(btnCancelarTicket);		
		
		frmAltaTicket.setSize(240,350);
		frmAltaTicket.setResizable(false);
		frmAltaTicket.setLocationRelativeTo(null);
		
		dlgConfirmarAltaTicket.setLayout(new FlowLayout());
		dlgConfirmarAltaTicket.setSize(200,80);
		dlgConfirmarAltaTicket.setResizable(false);
		dlgConfirmarAltaTicket.setLocationRelativeTo(null);
		dlgConfirmarAltaTicket.add(lblMensajeAltaTicket);
	}
}
