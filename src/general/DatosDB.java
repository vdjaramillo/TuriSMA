package general;

import java.util.LinkedList;

import ontologia.Cliente;
import ontologia.Hotel;
import ontologia.Reserva;

public interface DatosDB {
	static final String url = "jdbc:sqlite:db/TuriSMA.db";
	LinkedList<Cliente> usuarios = new LinkedList<>();
	LinkedList<Hotel> hoteles = new LinkedList<>();
	LinkedList<Reserva> reservas = new LinkedList<>();
}
