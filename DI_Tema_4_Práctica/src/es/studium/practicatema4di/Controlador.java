package es.studium.practicatema4di;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.List;


public class Controlador implements ActionListener, WindowListener
{

	Modelo modelo = null;
	VistaMenu menu = null;
	VistaAltaArticulo altaArticulo = null;
	VistaBajaArticulo bajaArticulo = null;
	VistaModificacionArticulo modificacionArticulo = null;
	VistaConsultaArticulo consultaArticulo = null;
	VistaAltaTicket altaTicket = null;
	VistaConsultaTicket consultaTicket = null;
	ConsultarInformeArticulos consultaInformeArticulo = null;
	ConsultarInformeTickets consultaInformeTicket = null;

	Modelo bd;
	String sentencia = "";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;

	List ListaDetallesArticuloModificar = new List(8, false);

	ConsultarPDFArticulo pdfConsultaArticulo;
	ConsultarPDFTicket pdfConsultaTicket;



	public Controlador(Modelo modelo, VistaMenu menu, VistaAltaArticulo altaArticulo, VistaBajaArticulo bajaArticulo, VistaModificacionArticulo modificacionArticulo, VistaConsultaArticulo consultaArticulo, 
			VistaAltaTicket altaTicket, VistaConsultaTicket consultaTicket, ConsultarInformeArticulos consultaInformeArticulo, ConsultarInformeTickets consultaInformeTicket )
	{

		//AÑADIR LISTENERS

		this.modelo = modelo;
		this.menu = menu;
		this.altaArticulo = altaArticulo;
		this.bajaArticulo = bajaArticulo;
		this.modificacionArticulo = modificacionArticulo;
		this.consultaArticulo = consultaArticulo;
		this.altaTicket = altaTicket;
		this.consultaTicket = consultaTicket;
		this.consultaInformeArticulo = consultaInformeArticulo;
		this.consultaInformeTicket = consultaInformeTicket;


		menu.frmMenu.addWindowListener(this);
		menu.mniAltaArticulo.addActionListener(this);
		menu.mniBajaArticulo.addActionListener(this);
		menu.mniModificacionArticulo.addActionListener(this);
		menu.mniConsultaArticulo.addActionListener(this);	
		menu.mniConsultaInformeArticulo.addActionListener(this);
		menu.mniConsultaInformeTicket.addActionListener(this);

		menu.mniAltaTicket.addActionListener(this);
		menu.mniConsultaTicket.addActionListener(this);
		menu.mniConsultaInformeTicket.addActionListener(this);


		altaArticulo.frmAltaArticulo.addWindowListener(this);
		altaArticulo.btnAltaArticulo.addActionListener(this);
		altaArticulo.btnCancelarAltaArticulo.addActionListener(this);
		altaArticulo.dlgConfirmarAltaFactura.addWindowListener(this);

		bajaArticulo.frmBajaArticulo.addWindowListener(this);
		bajaArticulo.btnBorrarArticulo.addActionListener(this);
		bajaArticulo.btnCancelarArticulo.addActionListener(this);
		bajaArticulo.dlgSeguroArticulo.addWindowListener(this);
		bajaArticulo.btnSiSeguroArticulo.addActionListener(this);
		bajaArticulo.btnNoSeguroArticulo.addActionListener(this);
		bajaArticulo.dlgConfirmacionBajaArticulo.addWindowListener(this);		

		modificacionArticulo.frmModificacionArticuloElegir.addWindowListener(this);
		modificacionArticulo.btnElegirArticulo.addActionListener(this);
		modificacionArticulo.btnCancelarArticulo.addActionListener(this);

		modificacionArticulo.frmModificacionArticulo.addWindowListener(this);
		modificacionArticulo.btnModificacionArticulo.addActionListener(this);
		modificacionArticulo.btnCancelarModificacionArticulo.addActionListener(this);
		modificacionArticulo.dlgConfirmarModificacionArticulo.addWindowListener(this);

		consultaArticulo.frmConsultaArticulos.addWindowListener(this);
		consultaArticulo.btnPdfArticulos.addActionListener(this);
		consultaArticulo.btnCancelarConsultaArticulos.addActionListener(this);

		consultaInformeArticulo.frmInformeArticulos.addWindowListener(this);
		consultaInformeArticulo.btnImprimirInformeArticulo.addActionListener(this);
		consultaInformeArticulo.btnCancelarInformeArticulo.addActionListener(this);

		altaTicket.frmAltaTicket.addWindowListener(this);
		altaTicket.dlgConfirmarAltaTicket.addWindowListener(this);
		altaTicket.btnAceptarTicket.addActionListener(this);
		altaTicket.btnCancelarTicket.addActionListener(this);

		consultaTicket.frmConsultaTickets.addWindowListener(this);
		consultaTicket.btnPdfTickets.addActionListener(this);
		consultaTicket.btnCancelarTickets.addActionListener(this);

		consultaInformeTicket.frmInformeTickets.addWindowListener(this);
		consultaInformeTicket.btnImprimirInformeTicket.addActionListener(this);
		consultaInformeTicket.btnCancelarInformeArticulo.addActionListener(this);

	}

	public void actionPerformed(ActionEvent evento)
	{
		// MENÚ PRINCIPAL ----> MENÚS ESPECÍFICOS

		if(evento.getSource().equals(menu.mniAltaArticulo))
		{
			altaArticulo.frmAltaArticulo.setVisible(true);
		}

		if(evento.getSource().equals(menu.mniBajaArticulo))
		{
			bd = new Modelo();
			connection = bd.conectar();			
			sentencia = "SELECT * FROM articulos";
			try
			{
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = statement.executeQuery(sentencia);
				bajaArticulo.choArticulos.removeAll();
				while(rs.next())
				{
					bajaArticulo.choArticulos.add(rs.getString("idArticulo") + "-" + rs.getString("descripcionArticulo") + "-"+ rs.getString("precioArticulo") + "-" +rs.getString("cantidadArticulo"));
				}
			}
			catch (SQLException sqle)
			{

			}
			bajaArticulo.frmBajaArticulo.setVisible(true);
		}

		if(evento.getSource().equals(menu.mniModificacionArticulo))
		{
			bd = new Modelo();
			connection = bd.conectar();			
			sentencia = "SELECT * FROM articulos";
			try
			{
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = statement.executeQuery(sentencia);
				modificacionArticulo.choArticulos.removeAll();
				while(rs.next())
				{
					modificacionArticulo.choArticulos.add(rs.getString("idArticulo") + "-" + rs.getString("descripcionArticulo") + "-"+ rs.getString("precioArticulo") + "-" +rs.getString("cantidadArticulo"));
				}
			}
			catch (SQLException sqle)
			{

			}
			modificacionArticulo.frmModificacionArticuloElegir.setVisible(true);
		}

		if(evento.getSource().equals(modificacionArticulo.btnElegirArticulo))
		{

			bd = new Modelo();
			connection = bd.conectar();
			String[] articuloelegido = modificacionArticulo.choArticulos.getSelectedItem().split("-");

			modificacionArticulo.txtidArticulo.setText(articuloelegido[0]); 
			modificacionArticulo.txtidArticulo.setEnabled(false);
			modificacionArticulo.txtDescripcionArticulo.setText(articuloelegido[1]);
			modificacionArticulo.txtPrecioArticulo.setText(articuloelegido[2]);
			modificacionArticulo.txtCantidadArticulo.setText(articuloelegido[3]);

			modificacionArticulo.frmModificacionArticuloElegir.setVisible(false);
			modificacionArticulo.frmModificacionArticulo.setVisible(true);
		}

		if(evento.getSource().equals(menu.mniConsultaArticulo))
		{
			bd = new Modelo();
			connection = bd.conectar();
			sentencia = "SELECT * FROM articulos";
			try
			{
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = statement.executeQuery(sentencia);
				consultaArticulo.listadoArticulos.selectAll();
				consultaArticulo.listadoArticulos.setText("");
				consultaArticulo.listadoArticulos.append("Nombre\tPrecio\tCantidad\n");
				while(rs.next())
				{
					consultaArticulo.listadoArticulos.append(rs.getString("descripcionArticulo")+"\t"+rs.getInt("precioArticulo")+"\t"+rs.getString("cantidadArticulo")+"\n");
				}
			}
			catch (SQLException sqle)
			{
				consultaArticulo.listadoArticulos.setText("Se ha producido un error en la consulta");
			}
			finally
			{

			}
			consultaArticulo.frmConsultaArticulos.setVisible(true);
		}

		if(evento.getSource().equals(menu.mniConsultaInformeArticulo))
		{
			consultaInformeArticulo.frmInformeArticulos.setVisible(true);
		}

		if(evento.getSource().equals(menu.mniAltaTicket))
		{
			bd = new Modelo();
			connection = bd.conectar();			
			sentencia = "SELECT * FROM articulos";
			try
			{
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = statement.executeQuery(sentencia);
				altaTicket.choArticulos.removeAll();
				while(rs.next())
				{
					altaTicket.choArticulos.add(rs.getString("idArticulo") + "-" + rs.getString("descripcionArticulo") + "-"+ rs.getString("precioArticulo") + "-" +rs.getString("cantidadArticulo"));
				}
			}
			catch (SQLException sqle)
			{

			}
			altaTicket.frmAltaTicket.setVisible(true);
		}
		if(evento.getSource().equals(menu.mniConsultaTicket))
		{bd = new Modelo();
		connection = bd.conectar();
		sentencia = "SELECT * FROM tickets";
		try
		{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = statement.executeQuery(sentencia);
			consultaTicket.listadoTickets.selectAll();
			consultaTicket.listadoTickets.setText("");
			consultaTicket.listadoTickets.append("Fecha\t\tArtículos\tTotal\n");
			while(rs.next())
			{
				consultaTicket.listadoTickets.append(rs.getString("fechaTicket")+"\t"+rs.getString("articulosTicket")+"\t"+rs.getString("totalTicket")+"\n");
			}
		}
		catch (SQLException sqle)
		{
			consultaTicket.listadoTickets.setText("Se ha producido un error en la consulta");
		}
		finally
		{

		}
		consultaTicket.frmConsultaTickets.setVisible(true);
		}
		if(evento.getSource().equals(menu.mniConsultaInformeTicket))
		{
			consultaInformeTicket.frmInformeTickets.setVisible(true);
		}


		// CONFIRMACIONES DE FRAMES ( PONER DENTRO DE LAS ACCIONES AL TERMINAR )

		if(evento.getSource().equals(bajaArticulo.btnBorrarArticulo))
		{
			bajaArticulo.dlgSeguroArticulo.setVisible(true);
		}

		if(evento.getSource().equals(bajaArticulo.btnNoSeguroArticulo))
		{
			bajaArticulo.dlgSeguroArticulo.setVisible(false);
		}

		if(evento.getSource().equals(modificacionArticulo.btnModificacionArticulo))
		{
			modificacionArticulo.dlgConfirmarModificacionArticulo.setVisible(true);
		}

		if(evento.getSource().equals(consultaArticulo.btnPdfArticulos))
		{
			connection = bd.conectar();
			pdfConsultaArticulo = new ConsultarPDFArticulo();
			ArrayList<String> datos = pdfConsultaArticulo.consultarPDFArticulo(connection);
			Document documento = new Document();
			try
			{
				FileOutputStream ficheroPdf = new FileOutputStream("ConsultaArtículo.pdf");
				PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
				documento.open();
				documento.add(new Paragraph("Listado de Artículos",
						FontFactory.getFont("arial", // fuente 
								22, // tamaño 
								Font.ITALIC, // estilo 
								BaseColor.CYAN)));
				documento.add(new Paragraph());
				PdfPTable tabla = new PdfPTable(3);
				tabla.addCell("Nombre");
				tabla.addCell("Precio");
				tabla.addCell("Cantidad");
				for(int i = 0; i < datos.size(); i++)
				{
					tabla.addCell(datos.get(i));
				}
				documento.add(tabla);
				documento.close();
				try
				{
					File path = new File ("ConsultaArtículo.pdf");
					Desktop.getDesktop().open(path);
				}
				catch(IOException ex)
				{
					System.out.println("Se ha producido un error al abrir el archivo PDF");
				}
			}
			catch (Exception e)
			{
				System.out.println("Se ha producido un error al abrir el archivo PDF");
			}
			bd.desconectar(connection);
		}

		if(evento.getSource().equals(altaTicket.btnAceptarTicket))
		{

		}

		// CONFIRMACIONES DE DIÁLOGOS

		if(evento.getSource().equals(altaArticulo.btnAltaArticulo))
		{
			bd = new Modelo();
			connection = bd.conectar();
			try
			{
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				sentencia = "INSERT INTO articulos VALUES(null, '" + altaArticulo.txtDescripcionArticulo.getText() + "', '" + altaArticulo.txtPrecioArticulo.getText() + "', '" + altaArticulo.txtCantidadArticulo.getText() + "');";
				System.out.println(sentencia);
				statement.executeUpdate(sentencia);				
			}
			catch (SQLException sqle)
			{

			}
			finally
			{
				altaArticulo.dlgConfirmarAltaFactura.setVisible(true);
			}
		}

		if(evento.getSource().equals(bajaArticulo.btnSiSeguroArticulo))
		{
			bd = new Modelo();
			connection = bd.conectar();
			String[] elegido = bajaArticulo.choArticulos.getSelectedItem().split("-");
			sentencia = "DELETE FROM articulos WHERE idArticulo = "+elegido[0];

			try
			{
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				statement.executeUpdate(sentencia);
				System.out.println(sentencia);
				bajaArticulo.dlgConfirmacionBajaArticulo.setVisible(true);

			}
			catch (SQLException sqle)
			{
				bajaArticulo.lblConfirmacionBajaArticulo.setText("Error en Baja");
			}


		}


		if(evento.getSource().equals(modificacionArticulo.btnModificacionArticulo))
		{
			bd = new Modelo();
			connection = bd.conectar();																							
			sentencia = "UPDATE articulos SET descripcionArticulo='"+modificacionArticulo.txtDescripcionArticulo.getText() + "', precioArticulo='"+ modificacionArticulo.txtPrecioArticulo.getText()+"', cantidadArticulo='"+modificacionArticulo.txtCantidadArticulo.getText()+"' WHERE idArticulo="+modificacionArticulo.txtidArticulo.getText();
			try
			{

				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);				
				statement.executeUpdate(sentencia);
				modificacionArticulo.lblMensajeModificacionArticuloCorrecto.setText("Actualización de distribuidor Correcta");
			}
			catch (SQLException sqle)
			{
				modificacionArticulo.lblMensajeModificacionArticuloCorrecto.setText("Error");
			}
			finally
			{
				bd.desconectar(connection);
			}
		}

		if(evento.getSource().equals(altaTicket.btnAceptarTicket))
		{
			bd = new Modelo();
			connection = bd.conectar();
			try
			{
				String[] fechaEuropea = altaTicket.txtFechaTicket.getText().split("-");
				String[] elegido = altaTicket.choArticulos.getSelectedItem().split("-");
				statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				if(((altaTicket.txtFechaTicket.getText().length())!=0)&&(( altaTicket.txtFechaTicket.getText().length())!=0))
				{
					sentencia = "INSERT INTO tickets VALUES(null, '" + fechaEuropea[2] + "-" + fechaEuropea[1] + "-" + fechaEuropea[0] + "', '"+ elegido[1] + "' , '"+ altaTicket.txtTotalTicket.getText() + "')";
					System.out.println(sentencia);
					statement.executeUpdate(sentencia);
					altaTicket.lblMensajeAltaTicket.setText("Alta de Factura Correcta");
				}
				else
				{
					altaTicket.lblMensajeAltaTicket.setText("Faltan datos");
				}
			}
			catch (SQLException sqle)
			{
				altaTicket.lblMensajeAltaTicket.setText("Error en ALTA");
			}
			finally
			{
				bd.desconectar(connection);
			}
			altaTicket.dlgConfirmarAltaTicket.setVisible(true);
		}

		if(evento.getSource().equals(consultaTicket.btnPdfTickets))
		{
			connection = bd.conectar();
			pdfConsultaTicket = new ConsultarPDFTicket();
			ArrayList<String> datos = pdfConsultaTicket.consultarPDFTicket(connection);
			Document documento = new Document();
			try
			{
				FileOutputStream ficheroPdf = new FileOutputStream("ConsultaTickets.pdf");
				PdfWriter.getInstance(documento, ficheroPdf).setInitialLeading(20);
				documento.open();
				documento.add(new Paragraph("Listado de Artículos",
						FontFactory.getFont("arial", // fuente 
								22, // tamaño 
								Font.ITALIC, // estilo 
								BaseColor.CYAN)));
				documento.add(new Paragraph());
				PdfPTable tabla = new PdfPTable(3);
				tabla.addCell("Fecha");
				tabla.addCell("Artículos");
				tabla.addCell("Total");
				for(int i = 0; i < datos.size(); i++)
				{
					tabla.addCell(datos.get(i));
				}
				documento.add(tabla);
				documento.close();
				try
				{
					File path = new File ("ConsultaTickets.pdf");
					Desktop.getDesktop().open(path);
				}
				catch(IOException ex)
				{
					System.out.println("Se ha producido un error al abrir el archivo PDF");
				}
			}
			catch (Exception e)
			{
				System.out.println("Se ha producido un error al abrir el archivo PDF");
			}
			bd.desconectar(connection);
		}


		// CONSULTAS DE IREPORT

		if(evento.getSource().equals(consultaInformeArticulo.btnImprimirInformeArticulo))
		{
			try
			{
				// Compilar el informe generando fichero jasper
				JasperCompileManager.compileReportToFile("C:\\\\Users\\\\Varo\\\\InformeArticulosBonito.jrxml");
				// Objeto para guardar parámetros necesarios para el informe
				HashMap<String,Object> parametros = new HashMap<String,Object>();
				// Cargar el informe compilado
				JasperReport report = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\Varo\\InformeArticulosBonito.jasper");
				// Conectar a la base de datos para sacar la información
				Class.forName("com.mysql.cj.jdbc.Driver");
				String servidor = "jdbc:mysql://localhost:3306/empresadi?useSSL=false";
				String usuarioDB = "root";
				String passwordDB = "Studium2020;";
				Connection conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
				// Completar el informe con los datos de la base de datos
				JasperPrint print = JasperFillManager.fillReport(report, parametros, conexion);
				// Mostrar el informe en JasperViewer
				JasperViewer.viewReport(print, false);
				consultaInformeArticulo.frmInformeArticulos.setVisible(false);
			}
			catch (Exception e)
			{
				System.out.println("Error: " + e.toString());
			}

		}

		if(evento.getSource().equals(consultaInformeTicket.btnImprimirInformeTicket))
		{
			
			try 
			{
				// Compilar el informe generando fichero.jasper
				JasperCompileManager.compileReportToFile("C:\\Users\\Varo\\InformeTickets.jrxml");
				//Usando variables para dar los valores de losparámetros del informe.
				String fechaDesde = consultaInformeTicket.txtFechaTicketDesde.getText();			
				String fechaHasta = consultaInformeTicket.txtFechaTicketHasta.getText();
				HashMap<String, Object> parametros = new HashMap<String, Object>();
				//Los valores del método put tiene que ser todos de tipo String
				parametros.put("fechaDesde", fechaDesde);
				parametros.put("fechaHasta", fechaHasta);
				// Cargar el informe compilado
				JasperReport report = (JasperReport)
						JRLoader.loadObjectFromFile("C:\\Users\\Varo\\InformeTickets.jasper");
				// Conectar a la base de datos para sacar la información
				Class.forName("com.mysql.cj.jdbc.Driver");
				String servidor ="jdbc:mysql://localhost:3306/empresadi?useSSL=false";
				String usuarioDB = "root";
				String passwordDB = "Studium2020;";
				Connection conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
				// Completar el informe con los datos de la base de datos
				JasperPrint print = JasperFillManager.fillReport(report, parametros, conexion);
				// Mostrar el informe en JasperViewer
				JasperViewer.viewReport(print, false);
				consultaInformeTicket.txtFechaTicketDesde.setText("");
				consultaInformeTicket.txtFechaTicketHasta.setText("");
				consultaInformeTicket.frmInformeTickets.setVisible(false);
				
			} 
			catch (Exception o) 
			{
				System.out.println("Error: " + o.toString());
			}
		}

		// BOTONES CANCELAR DE LOS MENUS

		if(evento.getSource().equals(altaArticulo.btnCancelarAltaArticulo))
		{
			altaArticulo.frmAltaArticulo.setVisible(false);
		}
		if(evento.getSource().equals(bajaArticulo.btnCancelarArticulo))
		{
			bajaArticulo.frmBajaArticulo.setVisible(false);
		}
		if(evento.getSource().equals(modificacionArticulo.btnCancelarModificacionArticulo))
		{
			modificacionArticulo.frmModificacionArticulo.setVisible(false);
		}
		if(evento.getSource().equals(modificacionArticulo.btnCancelarArticulo))
		{
			modificacionArticulo.frmModificacionArticuloElegir.setVisible(false);
		}
		if(evento.getSource().equals(consultaArticulo.btnCancelarConsultaArticulos))
		{
			consultaArticulo.frmConsultaArticulos.setVisible(false);
		}
		if(evento.getSource().equals(consultaInformeArticulo.btnCancelarInformeArticulo))
		{
			consultaInformeArticulo.frmInformeArticulos.setVisible(false);
		}
		if(evento.getSource().equals(altaTicket.btnCancelarTicket))
		{
			altaTicket.frmAltaTicket.setVisible(false);
		}
		if(evento.getSource().equals(consultaTicket.btnCancelarTickets))
		{
			consultaTicket.frmConsultaTickets.setVisible(false);
		}
		if(evento.getSource().equals(consultaInformeTicket.btnCancelarInformeArticulo))
		{
			consultaInformeTicket.frmInformeTickets.setVisible(false);
		}

	}

	public void windowClosing(WindowEvent evento)
	{
		//CERRAR VENTANAS DE MENUS

		if(evento.getSource().equals(menu.frmMenu))
		{
			System.exit(0);
		}

		if(evento.getSource().equals(altaArticulo.frmAltaArticulo))
		{
			altaArticulo.frmAltaArticulo.setVisible(false);
		}

		if(evento.getSource().equals(bajaArticulo.frmBajaArticulo))
		{
			bajaArticulo.frmBajaArticulo.setVisible(false);
		}

		if(evento.getSource().equals(modificacionArticulo.frmModificacionArticulo))
		{
			modificacionArticulo.frmModificacionArticulo.setVisible(false);
		}

		if(evento.getSource().equals(consultaArticulo.frmConsultaArticulos))
		{
			consultaArticulo.frmConsultaArticulos.setVisible(false);
		}

		if(evento.getSource().equals(consultaInformeArticulo.frmInformeArticulos))
		{
			consultaInformeArticulo.frmInformeArticulos.setVisible(false);
		}

		if(evento.getSource().equals(altaTicket.frmAltaTicket))
		{
			altaTicket.frmAltaTicket.setVisible(false);
		}

		if(evento.getSource().equals(consultaTicket.frmConsultaTickets))
		{
			consultaTicket.frmConsultaTickets.setVisible(false);
		}

		//CERRAR DIÁLOGOS DE CONFIRMACIÓN		

		if(evento.getSource().equals(altaArticulo.dlgConfirmarAltaFactura))
		{
			altaArticulo.dlgConfirmarAltaFactura.setVisible(false);
			altaArticulo.txtDescripcionArticulo.setText("");
			altaArticulo.txtPrecioArticulo.setText("");
			altaArticulo.txtCantidadArticulo.setText("");
			altaArticulo.txtDescripcionArticulo.requestFocus();
		}

		if(evento.getSource().equals(bajaArticulo.dlgConfirmacionBajaArticulo))
		{
			bajaArticulo.dlgConfirmacionBajaArticulo.setVisible(false);
			bajaArticulo.dlgSeguroArticulo.setVisible(false);
		}

		if(evento.getSource().equals(modificacionArticulo.dlgConfirmarModificacionArticulo))
		{
			modificacionArticulo.dlgConfirmarModificacionArticulo.setVisible(false);
		}

		if(evento.getSource().equals(modificacionArticulo.frmModificacionArticuloElegir))
		{
			modificacionArticulo.frmModificacionArticuloElegir.setVisible(false);
		}

		if(evento.getSource().equals(altaTicket.dlgConfirmarAltaTicket))
		{
			altaTicket.dlgConfirmarAltaTicket.setVisible(false);
		}

		if(evento.getSource().equals(bajaArticulo.dlgSeguroArticulo))
		{
			bajaArticulo.dlgSeguroArticulo.setVisible(false);
		}
		if(evento.getSource().equals(bajaArticulo.dlgConfirmacionBajaArticulo))
		{
			bajaArticulo.dlgConfirmacionBajaArticulo.setVisible(false);
		}
		if(evento.getSource().equals(consultaInformeTicket.frmInformeTickets))
		{
			consultaInformeTicket.frmInformeTickets.setVisible(false);
		}

	}

	public void windowActivated(WindowEvent arg0)
	{}

	public void windowClosed(WindowEvent arg0)
	{}

	public void windowDeactivated(WindowEvent arg0)
	{}

	public void windowDeiconified(WindowEvent arg0)
	{}

	public void windowIconified(WindowEvent arg0)
	{}

	public void windowOpened(WindowEvent arg0)
	{}

}
