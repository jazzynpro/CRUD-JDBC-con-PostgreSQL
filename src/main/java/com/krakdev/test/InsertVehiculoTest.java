package com.krakdev.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.entidades.Vehiculo;
import com.krakdev.jdbc.InsertVehiculo;

public class InsertVehiculoTest {
	private static final Logger log = LogManager.getLogger(InsertVehiculoTest.class); 
	public static void main(String[] args) {
		
		Vehiculo vehiculo = new Vehiculo("PDA-1235", "KIA","Rio", 2023, 20000.99,"Gris", true);
		InsertVehiculo.insertar(vehiculo);

	}

}
