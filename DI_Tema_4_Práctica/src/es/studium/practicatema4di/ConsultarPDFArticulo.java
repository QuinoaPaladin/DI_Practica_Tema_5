package es.studium.practicatema4di;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConsultarPDFArticulo
{
	public ArrayList<String> consultarPDFArticulo(Connection conexion)
	{
		ArrayList<String> datos = new ArrayList<String>();
		Statement statement = null;
		ResultSet rs = null;
		//Crear una sentencia
		try
		{
			statement = conexion.createStatement();
			String sentencia = "SELECT idArticulo, descripcionArticulo AS 'Nombre', precioArticulo AS 'Precio', cantidadArticulo AS 'Cantidad' FROM articulos ORDER BY 1;";
			rs = statement.executeQuery(sentencia);
			while(rs.next())
			{
				datos.add(rs.getString("Nombre"));
				datos.add(rs.getString("Precio"));
				datos.add(rs.getString("Cantidad"));
			
			}
		}
		catch (SQLException e)
		{
			System.out.println("Error 4-"+e.getMessage());
		}
		return(datos);
	}
}
