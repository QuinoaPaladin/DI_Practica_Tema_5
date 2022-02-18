package es.studium.practicatema4di;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;

public class VistaConsultaTicket
{
	Frame frmConsultaTickets = new Frame("Consulta Tickets");
	TextArea listadoTickets = new TextArea(5, 40);
	Button btnPdfTickets = new Button("PDF");
	Button btnCancelarTickets = new Button("Cancelar");
	
	public VistaConsultaTicket()
	{
		frmConsultaTickets.setLayout(new FlowLayout());
		frmConsultaTickets.add(listadoTickets);
		frmConsultaTickets.add(btnPdfTickets);
		frmConsultaTickets.add(btnCancelarTickets);

		frmConsultaTickets.setSize(350,200);
		frmConsultaTickets.setResizable(false);
		frmConsultaTickets.setLocationRelativeTo(null);		
	}
}
