package com.krakdev.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertVehiculo {
	private static final Logger log = LogManager.getLogger(InsertVehiculo.class); 
	
	public void insertar() {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = """ 
				INSERT INTO vehiculos (placa, marca, modelo, anio, precio, color, disponible )
				VALUES(?,?,?,?,?,?,?)
				"""; 
				
		try {
		con = Conexion.getConnection();
		
		ps = con.prepareStatement(sql); 
		
		ps.setString(1, "PDA-1235"); 
		ps.setString(2, "KIA"); 
		ps.setString(3, "Rio"); 
		ps.setInt(4, 2022); 
		ps.setDouble(5, 20000.99); 
		ps.setString(6, "Gris");
		ps.setString(7, true);
		
		int filas = ps.executeUpdate(); 
		
		log.info("Conexion Exitosa"); 
		log.info("Filas insertadas: " + filas); 
		
		}catch(Exception e) {
			log.error("Ocurrio un error durante la ejecucion" + e.getMessage());
		}finally {
			try {
			ps.close();
			con.close();
			log.info("Conexion cerrada");
		}catch(SQLException e){
			log.error("Ocurrio un error al cerrar la conexion: " + e.getMessage());
					}
	}	
	}
}
