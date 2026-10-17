package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.entidades.Vehiculo;

public class DeleteVehiculo {
	private static final Logger log = LogManager.getLogger(DeleteVehiculo.class);
	
	public static void delete(String placa) {
		if(placa == null || placa.isBlank()) {
			log.info("Placa es vacia o nula");
			return;
		}
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = """
		delete from vehiculos where placa = ?;
						""";
		
		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, placa);
			
			int filas = ps.executeUpdate(); 
			
			log.info("Conexion Exitosa"); 
			log.info("Filas insertadas: " + filas); 
			
		}catch(Exception e) {
			log.error("Ocurrio un error al eliminar vehiculo: " + e.getMessage());
		}finally {
			try {
				con.close();
				ps.close();
				
				log.info("Conexiones cerradas");
			}catch(Exception e) {
				log.error("Ocurrio un error al cerrar las conexiones: " + e.getMessage());
			}
		}
	}
}
