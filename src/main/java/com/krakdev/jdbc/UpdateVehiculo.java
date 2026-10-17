package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.entidades.Vehiculo;

public class UpdateVehiculo {

	private static final Logger log = LogManager.getLogger(UpdateVehiculo.class);

	public static void update(Vehiculo vehiculo) {
		
		if(vehiculo == null || vehiculo.getPlaca()== null || vehiculo.getPlaca().isBlank()) {
			log.info("Vehiculo vacio o nulo no se puede actualizar");
			return;
		}
		
		Connection con = null;
		PreparedStatement ps = null;

		String sql = """
				update vehiculos set
				marca = ?,
				modelo = ?,
				anio = ?,
				precio = ?,
				color = ?,
				disponible = ?
				where placa = ?;
								""";

		try {
			con = Conexion.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vehiculo.getMarca()); 
			ps.setString(2, vehiculo.getModelo()); 
			ps.setInt(3, vehiculo.getAnio()); 
			ps.setDouble(4, vehiculo.getPrecio()); 
			ps.setString(5, vehiculo.getColor());
			ps.setBoolean(6, vehiculo.isDisponible());
			
			//condicion where
			
			ps.setString(7, vehiculo.getPlaca());
			
			int filas = ps.executeUpdate(); 
			
			log.info("Conexion Exitosa"); 
			log.info("Filas insertadas: " + filas); 
			
			
		} catch (Exception e) {
			log.error("Ocurrio un error al actualizar vehiculo: " + e.getMessage());
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
