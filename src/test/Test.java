package test;

import java.time.LocalDate;

import modelo.CampingNacional;

public class Test {

	public static void main(String[] args) {
		CampingNacional campingNacional = new CampingNacional();

		// Agregar e imprimir siguientes personas
		System.out.println("---------------------------------------TEST 1---------------------------------------");
		try {
			campingNacional.agregarPersona("Lopez", "Sergio", 11111111);
			campingNacional.agregarPersona("Rodriguez", "Juan", 22222222);
			campingNacional.agregarPersona("Fernandez", "Maria", 33333333);
			campingNacional.agregarPersona("Vazquez", "Juan", 44444444);
			campingNacional.agregarPersona("Martinez", "Ana", 55555555);
			System.out.println(campingNacional.getLstPersonas());
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

		// Agregar e imprimir los siguientes servicios
		System.out.println("---------------------------------------TEST 2---------------------------------------");
		try {
			campingNacional.agregarRecreo("7358902", null, false, campingNacional.traerPersona(11111111), 5, 300);
			campingNacional.agregarCampamento("6573540", LocalDate.of(2022, 9, 2), false,campingNacional.traerPersona(22222222), null, 1, 1500);
			campingNacional.agregarRecreo("3571398", LocalDate.of(2022, 9, 3), true,campingNacional.traerPersona(33333333), 10, 300);
			campingNacional.agregarCampamento("2583941", LocalDate.of(2022, 9, 3), true,campingNacional.traerPersona(44444444), LocalDate.of(2022, 9, 8), 2, 1500);
			campingNacional.agregarRecreo("5243925", LocalDate.of(2022, 9, 3), true,campingNacional.traerPersona(55555555), 8, 300);
			System.out.println(campingNacional.getLstServicios());

		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

		// Traer e imprimir los Servicios con precio final mayor a 1000 y que hayan
		// finalizado su estadia
		System.out.println("---------------------------------------TEST 3---------------------------------------");
		System.out.println(campingNacional.traerServiciosPorPrecioFinal(1000));

		// Traer e imprimir los Campamentos con más de 5 días en el predio
		System.out.println("---------------------------------------TEST 4---------------------------------------");
		System.out.println(campingNacional.traerCampamentosPorDias(5));

		// Intentar agregar a la siguiente Persona que ya existe en la lista:
		System.out.println("---------------------------------------TEST 5---------------------------------------");
		try {
			campingNacional.agregarPersona("Fernandez", "Maria", 33333333);
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

		// Intentar agregar el siguiente servicio con codingreso inválido:
		System.out.println("---------------------------------------TEST 6---------------------------------------");
		try {
			campingNacional.agregarRecreo("5732927", LocalDate.of(2022, 10, 2), false, campingNacional.traerPersona(11111111), 5, 300);
		} catch (Exception e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}

	}

}
