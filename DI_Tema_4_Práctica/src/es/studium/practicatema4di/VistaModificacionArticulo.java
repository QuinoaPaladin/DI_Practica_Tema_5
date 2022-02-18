package es.studium.practicatema4di;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.TextField;

public class VistaModificacionArticulo
{
	
	Frame frmModificacionArticuloElegir = new Frame("Modificar artículo");
	
	Label lblMensajeModificacionArticulo = new Label("Seleccionar el articulo:");
	Choice choArticulos = new Choice();
	Button btnElegirArticulo = new Button("Aceptar");
	Button btnCancelarArticulo = new Button("Cancelar");
		
	Frame frmModificacionArticulo = new Frame("Modificacion de Artículo");
	
	
	Label lblidArticulo = new Label("ID:");
	TextField txtidArticulo = new TextField(20);
	Label lblDescripcionArticulo = new Label("Descripción:");
	TextField txtDescripcionArticulo = new TextField(20);
	Label lblPrecioArticulo = new Label("Precio:");
	TextField txtPrecioArticulo = new TextField(20);
	Label lblCantidadArticulo = new Label("Cantidad:");
	TextField txtCantidadArticulo = new TextField(20);

	Button btnModificacionArticulo = new Button("Aceptar");
	Button btnCancelarModificacionArticulo = new Button("Cancelar");

	Dialog dlgConfirmarModificacionArticulo = new Dialog(frmModificacionArticulo, "Modificación Artículo", true);
	Label lblMensajeModificacionArticuloCorrecto = new Label("Modificación de Artículo Correcta");

	public VistaModificacionArticulo()
	{
		
		frmModificacionArticuloElegir.setLayout(new FlowLayout());
		
		frmModificacionArticuloElegir.add(lblMensajeModificacionArticulo);
		frmModificacionArticuloElegir.add(choArticulos);
		frmModificacionArticuloElegir.add(btnElegirArticulo);
		frmModificacionArticuloElegir.add(btnCancelarArticulo);
		
		frmModificacionArticuloElegir.setSize(200,130);
		frmModificacionArticuloElegir.setResizable(false);
		frmModificacionArticuloElegir.setLocationRelativeTo(null);
		
		
		frmModificacionArticulo.setLayout(new FlowLayout());

		frmModificacionArticulo.add(lblidArticulo);
		txtDescripcionArticulo.setText("");
		frmModificacionArticulo.add(txtidArticulo);
		
		frmModificacionArticulo.add(lblDescripcionArticulo);
		txtDescripcionArticulo.setText("");
		frmModificacionArticulo.add(txtDescripcionArticulo);

		frmModificacionArticulo.add(lblPrecioArticulo);
		txtPrecioArticulo.setText("");
		frmModificacionArticulo.add(txtPrecioArticulo);

		frmModificacionArticulo.add(lblCantidadArticulo);
		txtCantidadArticulo.setText("");
		frmModificacionArticulo.add(txtCantidadArticulo);


		frmModificacionArticulo.add(btnModificacionArticulo);
		frmModificacionArticulo.add(btnCancelarModificacionArticulo);

		frmModificacionArticulo.setSize(200,300);
		frmModificacionArticulo.setResizable(false);
		frmModificacionArticulo.setLocationRelativeTo(null);
		txtDescripcionArticulo.requestFocus();
		
		dlgConfirmarModificacionArticulo.setLayout(new FlowLayout());
		dlgConfirmarModificacionArticulo.setSize(220,80);
		dlgConfirmarModificacionArticulo.setResizable(false);
		dlgConfirmarModificacionArticulo.setLocationRelativeTo(null);
		dlgConfirmarModificacionArticulo.add(lblMensajeModificacionArticuloCorrecto);
	}
}
