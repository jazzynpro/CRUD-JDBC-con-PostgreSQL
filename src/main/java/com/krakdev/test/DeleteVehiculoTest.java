package com.krakdev.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakdev.jdbc.DeleteVehiculo;

public class DeleteVehiculoTest {
	private static final Logger log = LogManager.getLogger(DeleteVehiculoTest.class);
	public static void main(String[] args) {
		DeleteVehiculo.delete("PDA-1234");

	}

}
