package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CampingNacional {
	private List<Persona> lstPersonas;
	private List<Servicio> lstServicios;

	public CampingNacional() {
		super();
		this.lstPersonas = new ArrayList<Persona>();
		this.lstServicios = new ArrayList<Servicio>();
	}

	public Persona traerPersona(long dni) {
		boolean encontrada = false;
		Persona personaAux = null;
		int i = 0;

		while (!encontrada && i < lstPersonas.size()) {
			if (lstPersonas.get(i).getDni() == dni) {
				encontrada = true;
				personaAux = lstPersonas.get(i);
			}
			i++;
		}
		return personaAux;
	}

	public boolean agregarPersona(String apellido, String nombre, long dni) throws Exception {
		if (traerPersona(dni) != null) {
			throw new Exception("ESE DNI YA EXISTE");
		}
		int id = 1;

		if (lstPersonas.size() > 0) {

			int tamanio = lstPersonas.size();
			id = lstPersonas.get(tamanio - 1).getIdPersona() + 1;

		}

		return lstPersonas.add(new Persona(id, apellido, nombre, dni));
	}

	public int calcularId() {
		int id = 1;
		if (lstServicios.size() > 0) {
			int tamanio = lstServicios.size();
			id = lstServicios.get(tamanio - 1).getIdServicio() + 1;
		}
		return id;
	}

	public boolean agregarRecreo(String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona persona,
			int cantPersonas, double precioPersona) throws Exception {
		int id = calcularId();
		return lstServicios
				.add(new Recreo(id, codIngreso, fechaIngreso, checkOut, persona, cantPersonas, precioPersona));
	}

	public boolean agregarCampamento(String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable,
			LocalDate fechaEgreso, int cantCarpas, double precioCarpa) throws Exception {
		int id = calcularId();
		return lstServicios.add(new Campamento(id, codIngreso, fechaIngreso, checkOut, responsable, fechaEgreso,
				cantCarpas, precioCarpa));
	}

	public List<Campamento> traerCampamentosPorDias(int mayorIgualA) {
		ArrayList<Campamento> listaAux = new ArrayList<Campamento>();

		for (Servicio s : lstServicios) {
			if (s instanceof Campamento) {
				if (((Campamento) s).cantidadDias() > mayorIgualA) {
					listaAux.add((Campamento) s);
				}
			}

		}
		return listaAux;

	}

	public List<Servicio> traerServiciosPorPrecioFinal(double mayorIgualA) {
		ArrayList<Servicio> listaAux = new ArrayList<Servicio>();
		for (Servicio servicio : lstServicios) {
			if (servicio.checkOut && servicio.calcularPrecioFinal() > mayorIgualA) {
				listaAux.add(servicio);
			}
		}
		return listaAux;
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	public List<Servicio> getLstServicios() {
		return lstServicios;
	}

	public void setLstServicios(List<Servicio> lstServicios) {
		this.lstServicios = lstServicios;
	}

	@Override
	public String toString() {
		return "CampingNacional [lstPersonas=" + lstPersonas + ", lstServicios=" + lstServicios + "]\n";
	}

}
