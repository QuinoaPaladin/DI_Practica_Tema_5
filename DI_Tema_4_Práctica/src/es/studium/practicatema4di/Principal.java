package es.studium.practicatema4di;

public class Principal
{

	public static void main(String[] args)
	{
		Modelo modelo = new Modelo();
		VistaMenu menu = new VistaMenu();
		VistaAltaArticulo altaArticulo = new VistaAltaArticulo();
		VistaBajaArticulo bajaArticulo = new VistaBajaArticulo();
		VistaModificacionArticulo modificacionArticulo = new VistaModificacionArticulo();
		VistaConsultaArticulo consultaArticulo = new VistaConsultaArticulo();
		VistaAltaTicket altaTicket = new VistaAltaTicket();
		VistaConsultaTicket consultaTicket = new VistaConsultaTicket();
		ConsultarInformeArticulos consultaInformeArticulo = new ConsultarInformeArticulos();
		ConsultarInformeTickets consultaInformeTicket = new ConsultarInformeTickets();
		
		new Controlador(modelo, menu, altaArticulo, bajaArticulo, modificacionArticulo, consultaArticulo, altaTicket, consultaTicket, consultaInformeArticulo, consultaInformeTicket);
	}

}
