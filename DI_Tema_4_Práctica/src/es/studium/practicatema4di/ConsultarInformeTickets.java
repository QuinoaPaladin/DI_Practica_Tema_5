package es.studium.practicatema4di;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class ConsultarInformeTickets
{
	Frame frmInformeTickets = new Frame("Informe de artículos");
	
	Label lblFechaTicketDesde = new Label("Fecha desde:");
	TextField txtFechaTicketDesde = new TextField(20); 
	
	Label lblFechaTicketHasta = new Label("Fecha hasta:");
	TextField txtFechaTicketHasta = new TextField(20); 
	
	Button btnImprimirInformeTicket = new Button("Imprimir");
	Button btnCancelarInformeArticulo = new Button("Cancelar");
	
	public ConsultarInformeTickets()
	{
		frmInformeTickets.setLayout(new FlowLayout());
		
		frmInformeTickets.add(lblFechaTicketDesde);
		frmInformeTickets.add(txtFechaTicketDesde);
		frmInformeTickets.add(lblFechaTicketHasta);
		frmInformeTickets.add(txtFechaTicketHasta);
		frmInformeTickets.add(btnImprimirInformeTicket);
		frmInformeTickets.add(btnCancelarInformeArticulo);
		
		frmInformeTickets.setSize(220,220);
		frmInformeTickets.setResizable(false);
		frmInformeTickets.setLocationRelativeTo(null);
	}
}
