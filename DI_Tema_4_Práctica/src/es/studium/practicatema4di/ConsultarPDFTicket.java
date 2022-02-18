package es.studium.practicatema4di;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsultarPDFTicket
{
	public ArrayList<String> consultarPDFTicket(Connection conexion)
	{
		ArrayList<String> datos = new ArrayList<String>();
		Statement statement = null;
		ResultSet rs = null;
		try
		{
			statement = conexion.createStatement();
			String sentencia = "SELECT idTicket, fechaTicket AS 'Fecha', articulosTicket AS 'Articulos', totalTicket AS 'Total' FROM tickets ORDER BY 1;";
			rs = statement.executeQuery(sentencia);
			while(rs.next())
			{
				datos.add(rs.getString("Fecha"));
				datos.add(rs.getString("Articulos"));
				datos.add(rs.getString("Total"));
			
			}
		}
		catch (SQLException e)
		{
			System.out.println("Error 4-"+e.getMessage());
		}
		return(datos);
	}
}
