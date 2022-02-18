package es.studium.practicatema4di;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;

public class VistaBajaArticulo
{
	Frame frmBajaArticulo = new Frame("Baja de Articulo");	
	
	Label lblMensajeBajaArticulo = new Label("Seleccionar el artículo:");
	Choice choArticulos = new Choice();
	Button btnBorrarArticulo = new Button("Aceptar");
	Button btnCancelarArticulo = new Button("Cancelar");
	
	Dialog dlgSeguroArticulo = new Dialog(frmBajaArticulo, "¿Seguro?", true);
	Label lblSeguroArticulo = new Label("¿Está seguro de borrar?");
	Button btnSiSeguroArticulo = new Button("Sí");
	Button btnNoSeguroArticulo = new Button("No");
	
	Dialog dlgConfirmacionBajaArticulo = new Dialog(frmBajaArticulo, "Baja Artículo", true);
	Label lblConfirmacionBajaArticulo = new Label("Baja de artículo correcta");
	
	
	public VistaBajaArticulo()
	{
		frmBajaArticulo.setLayout(new FlowLayout());
		frmBajaArticulo.add(lblMensajeBajaArticulo);
		frmBajaArticulo.add(choArticulos);
		frmBajaArticulo.add(btnBorrarArticulo);
		frmBajaArticulo.add(btnCancelarArticulo);
		
		frmBajaArticulo.setSize(200,140);
		frmBajaArticulo.setResizable(false);
		frmBajaArticulo.setLocationRelativeTo(null);
		
		dlgSeguroArticulo.setLayout(new FlowLayout());
		dlgSeguroArticulo.setSize(170,100);
		dlgSeguroArticulo.setResizable(false);
		dlgSeguroArticulo.setLocationRelativeTo(null);
		dlgSeguroArticulo.add(lblSeguroArticulo);
		dlgSeguroArticulo.add(btnSiSeguroArticulo);
		dlgSeguroArticulo.add(btnNoSeguroArticulo);
		
		dlgConfirmacionBajaArticulo.setLayout(new FlowLayout());
		dlgConfirmacionBajaArticulo.setSize(170,100);
		dlgConfirmacionBajaArticulo.setResizable(false);
		dlgConfirmacionBajaArticulo.setLocationRelativeTo(null);
		dlgConfirmacionBajaArticulo.add(lblConfirmacionBajaArticulo);
		
	}
}
