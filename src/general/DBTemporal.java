package general;

import java.util.LinkedList;

import ontologia.Cliente;
import ontologia.Hotel;
import ontologia.Reserva;
import ontologia.TipoHabitacion;

public interface DBTemporal {
	LinkedList<Cliente> usuarios = new LinkedList<>();
	LinkedList<Hotel> hoteles = new LinkedList<>();
	LinkedList<Reserva> reservas = new LinkedList<>();
	static void temporal() {
		usuarios.add(new Cliente("Sebas",1,1,1));
		usuarios.add(new Cliente("Alex",1,1,1));
		usuarios.add(new Cliente("Meme",1,1,1));
		usuarios.add(new Cliente("Sagil",1,1,1));
		TipoHabitacion[] th2 = new TipoHabitacion[3];
		th2[0] = new TipoHabitacion("Suite",30,1000);
		th2[1] = new TipoHabitacion("Pent",20,2000);
		th2[2] = new TipoHabitacion("Pres",10,5000);
		hoteles.add(new Hotel("Hotel 1",true,"dir h1",true,1,1,1,th2));
		th2[1] = new TipoHabitacion("Pentho",20,20000);
		hoteles.add(new Hotel("Hotel 2",true,"dir h2",true,2,3,5,th2));
		th2[1] = new TipoHabitacion("Pent BIG",20,200000);
		th2[2] = new TipoHabitacion("Presiden",5,500000);
		hoteles.add(new Hotel("Hotel 3",true,"dir h3",true,5,7,10,th2));
		
	}
}
