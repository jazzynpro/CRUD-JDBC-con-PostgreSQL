package com.krakdev.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.entidades.Vehiculo;
import com.krakdev.jdbc.UpdateVehiculo;

public class UpdateVehiculoTest {
	
	private static final Logger log = LogManager.getLogger(UpdateVehiculoTest.class);
	
	public static void main(String[] args) {
		
		Vehiculo vehiculo = new Vehiculo("PDA-1235", "Cherry", "Tigo 7 pro max", 2020, 15000, "naranja", true);
		
		UpdateVehiculo.update(vehiculo);

	}

}
