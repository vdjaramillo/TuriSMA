package general;

import java.io.IOException;
import java.util.Scanner;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.Hotel;
import ontologia.InscribirHoteles;
import ontologia.RegistrarCaracteristicasDelHotel;
import ontologia.TipoHabitacion;

public class RegistrarHotel extends Behaviour {
	RegistrarCaracteristicasDelHotel ih = new RegistrarCaracteristicasDelHotel();
	public RegistrarHotel(Agent myAgent) {
		super(myAgent);
	}
	@Override
	public void action() {
		//Toda la logica de recepcion de datos de hotel va aqui
		Hotel hotel = new Hotel();
		Scanner input = new Scanner(System.in);
		System.out.println("Digite el nombre del hotel");
		hotel.setNombreHotel(input.nextLine());
		System.out.println("Digite el teléfono del hotel");
		hotel.setTelefono(input.nextInt());
		System.out.println("Digite la dirección del hotel");
		input = new Scanner(System.in);
		String dir = input.next();
		hotel.setDireccion(dir);
		System.out.println("¿Tiene certificación de idiomas (1) sí (otro) no?");
		int cert = input.nextInt();
		if(cert == 1) {
			hotel.setCertificaciónDeIdiomas(true);
		}else {
			hotel.setCertificaciónDeIdiomas(false);
		}
		System.out.println("¿Tiene cafetería y/o restaurantes (1) sí (otro) no?");
		if(input.nextInt()==1) {
			hotel.setCafeteriasyRestaurantes(true);
		}else {
			hotel.setCafeteriasyRestaurantes(false);
		}
		System.out.println("Digite el nivel de seguridad del hotel (1 a 10)");
		hotel.setNivelDeSeguridad(input.nextInt());
		System.out.println("Digite el número de estrellas del hotel");
		hotel.setCalificacion(input.nextInt());
		System.out.println("¿Cuántos tipos de habitaciones tiene el hotel?");
		int ctipos = input.nextInt();
		TipoHabitacion[] th = new TipoHabitacion[ctipos];
		for(int i=0; i<ctipos;i++) {
			input = new Scanner(System.in);
			TipoHabitacion tb = new TipoHabitacion();
			System.out.println("Digite el nombre del "+(i+1)+" tipo de habitaciones");
			tb.setTipo(input.nextLine());
			System.out.println("Digite la cantidad de habitaciones del  "+(i+1)+" tipo");
			tb.setCantidad(input.nextInt());
			System.out.println("Digite el precio de las habitaciones del  "+(i+1)+" tipo");
			tb.setPrecioNoche(input.nextInt());
			th[i]=tb;
		}
		hotel.setHabitaciones(th);
		ih.setHotel(hotel);
	}

	@Override
	public boolean done() {
		System.out.println("Hotel Registrado " + myAgent.getLocalName());
		ACLMessage msj;
		try {
			msj = new TuriMSG("AgenteSistema","AHotel",ih,ACLMessage.INFORM);
			myAgent.send(msj);
		} catch (IOException e) {
			System.out.println("Error al cargar/enviar el hotel");
		}
		return true;
	}

}
