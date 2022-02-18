package es.studium.practicatema4di;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextArea;

public class VistaConsultaArticulo
{
	Frame frmConsultaArticulos = new Frame("Consulta Articulos");
	TextArea listadoArticulos = new TextArea(5, 40);
	Button btnPdfArticulos = new Button("PDF");
	Button btnCancelarConsultaArticulos = new Button("Cancelar");
	
	public VistaConsultaArticulo()
	{
		frmConsultaArticulos.setLayout(new FlowLayout());
		frmConsultaArticulos.add(listadoArticulos);
		frmConsultaArticulos.add(btnPdfArticulos);	
		frmConsultaArticulos.add(btnCancelarConsultaArticulos);

		frmConsultaArticulos.setSize(350,200);
		frmConsultaArticulos.setResizable(false);
		frmConsultaArticulos.setLocationRelativeTo(null);
	}
}
