package es.studium.practicatema4di;

import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;

public class VistaAltaArticulo
{
	Frame frmAltaArticulo = new Frame("Alta de Artículo");
	
	Label lblDescripcionArticulo = new Label("Descripción:");
	TextField txtDescripcionArticulo = new TextField(20);	
	Label lblPrecioArticulo = new Label("Precio:");
	TextField txtPrecioArticulo = new TextField(20);	
	Label lblCantidadArticulo = new Label("Cantidad:");
	TextField txtCantidadArticulo = new TextField(20);
	
	Button btnAltaArticulo = new Button("Aceptar");
	Button btnCancelarAltaArticulo = new Button("Cancelar");
	
	Dialog dlgConfirmarAltaFactura = new Dialog(frmAltaArticulo, "Alta Artículo", true);
	Label lblMensajeAltaFactura = new Label("Alta de Artículo Correcta");

	
	public VistaAltaArticulo()
	{
		frmAltaArticulo.setLayout(new FlowLayout());
		
		frmAltaArticulo.add(lblDescripcionArticulo);
		txtDescripcionArticulo.setText("");
		frmAltaArticulo.add(txtDescripcionArticulo);
		
		frmAltaArticulo.add(lblPrecioArticulo);
		txtPrecioArticulo.setText("");
		frmAltaArticulo.add(txtPrecioArticulo);
		
		frmAltaArticulo.add(lblCantidadArticulo);
		txtCantidadArticulo.setText("");
		frmAltaArticulo.add(txtCantidadArticulo);
		
		
		frmAltaArticulo.add(btnAltaArticulo);
		frmAltaArticulo.add(btnCancelarAltaArticulo);

		frmAltaArticulo.setSize(200,260);
		frmAltaArticulo.setResizable(false);
		frmAltaArticulo.setLocationRelativeTo(null);
		txtDescripcionArticulo.requestFocus();
		
		dlgConfirmarAltaFactura.setLayout(new FlowLayout());
		dlgConfirmarAltaFactura.setSize(200,80);
		dlgConfirmarAltaFactura.setResizable(false);
		dlgConfirmarAltaFactura.setLocationRelativeTo(null);
		dlgConfirmarAltaFactura.add(lblMensajeAltaFactura);
	}
}
