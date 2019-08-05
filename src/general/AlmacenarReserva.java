package general;

import java.io.Serializable;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.ReservarHotel;

public class AlmacenarReserva extends Behaviour {
	private static final long serialVersionUID = 1589756164826324694L;
	ReservarHotel rh;
	
	public AlmacenarReserva(Agent myAgent, Serializable contentObject) {
		super(myAgent);
		rh = (ReservarHotel) contentObject;
	}
	public void action() {
		System.out.println("Reservando");
		
	}
	public boolean done() {
		System.out.println("************************* \n"
				+ "Reserva Confirmada \n"
				+ "Hotel: "+rh.getReserva().getHotel().getNombreHotel()+"\n"
				+ "Tipo Habitación: "+rh.getReserva().getNombreHabitacion()+"\n"
				+ "Para el usuario: "+rh.getReserva().getCliente().getNombre());
		ACLMessage msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		myAgent.send(msj);
		return true;
	}

}
