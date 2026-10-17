package com.krakdev.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.entidades.Vehiculo;
import com.krakdev.jdbc.InsertVehiculo;

public class InsertVehiculoTest {
	private static final Logger log = LogManager.getLogger(InsertVehiculoTest.class); 
	public static void main(String[] args) {
		
		Vehiculo vehiculo = new Vehiculo("PDA-1239", "Chevrolet","Rojo", 1997, 32000.99,"Gris", true, 19500);
		InsertVehiculo.insertar(vehiculo);

	}

}
