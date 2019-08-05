package ontologia;

import jade.content.Concept;

public class TipoHabitacion implements Concept{
	private String tipo;
	private int cantidad;
	private int precioNoche;
	public TipoHabitacion() {}
	public TipoHabitacion(String tipo, int cantidad, int precioNoche) {
		setTipo(tipo);
		setCantidad(cantidad);
		setPrecioNoche(precioNoche);
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecioNoche() {
		return precioNoche;
	}
	public void setPrecioNoche(int precio) {
		this.precioNoche = precio;
	}
}
