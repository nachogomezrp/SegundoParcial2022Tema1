package modelo;

import java.time.LocalDate;

public abstract class Servicio {
	protected int idServicio;
	protected String codIngreso;
	protected LocalDate fechaIngreso;
	protected boolean checkOut;
	protected Persona responsable;

	public Servicio(int idServicio, String codIngreso, LocalDate fechaIngreso, boolean checkOut, Persona responsable)
			throws Exception {
		super();
		this.idServicio = idServicio;
		this.setCodIngreso(codIngreso);
		this.fechaIngreso = fechaIngreso;
		this.checkOut = checkOut;
		this.responsable = responsable;
	}

	public boolean esValidoDigitoControl(String codIngreso) {
		boolean valido = false;
		int acum = 0;

		for (int i = 0; i < codIngreso.length() - 1; i++) {
			char caracter = codIngreso.charAt(i);
			acum = acum + Character.getNumericValue(caracter);
		}

		char ultimaPos = codIngreso.charAt(codIngreso.length() - 1);
		int ultimaPosNum = Character.getNumericValue(ultimaPos);

		if (acum % 10 == ultimaPosNum) {
			valido = true;
		}

		return valido;
	}

	public abstract double calcularPrecioFinal();

	public int getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getCodIngreso() {
		return codIngreso;
	}

	public void setCodIngreso(String codIngreso) throws Exception {
		if (esValidoDigitoControl(codIngreso) == false) {
			throw new Exception("CODIGO INVALIDO");
		}
		this.codIngreso = codIngreso;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public boolean isCheckOut() {
		return checkOut;
	}

	public void setCheckOut(boolean checkOut) {
		this.checkOut = checkOut;
	}

	public Persona getResponsable() {
		return responsable;
	}

	public void setResponsable(Persona responsable) {
		this.responsable = responsable;
	}

	@Override
	public String toString() {
		return "\nServicio [idServicio=" + idServicio + ", codIngreso=" + codIngreso + ", fechaIngreso=" + fechaIngreso
				+ ", checkOut=" + checkOut + ", responsable=" + responsable + "]";
	}

}
