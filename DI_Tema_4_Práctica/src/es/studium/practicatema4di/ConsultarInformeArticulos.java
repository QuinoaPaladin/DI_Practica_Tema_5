package es.studium.practicatema4di;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class ConsultarInformeArticulos
{
	Frame frmInformeArticulos = new Frame("Informe de artículos");
	
	
	Button btnImprimirInformeArticulo = new Button("Imprimir");
	Button btnCancelarInformeArticulo = new Button("Cancelar");
	
	public ConsultarInformeArticulos()
	{
		frmInformeArticulos.setLayout(new FlowLayout());
		
		frmInformeArticulos.add(btnImprimirInformeArticulo);
		frmInformeArticulos.add(btnCancelarInformeArticulo);
		
		frmInformeArticulos.setSize(250,100);
		frmInformeArticulos.setResizable(false);
		frmInformeArticulos.setLocationRelativeTo(null);
	}
}
