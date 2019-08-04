package general;

import java.io.Serializable;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.RegistrarCaracteristicasDelHotel;

public class AlmacenarHotel extends Behaviour {
/**
	 * 
	 */
	private static final long serialVersionUID = -8731324418407412631L;
RegistrarCaracteristicasDelHotel rch;
	public AlmacenarHotel(Agent myAgent, Serializable contentObject) {
		super(myAgent);
		rch = (RegistrarCaracteristicasDelHotel) contentObject;
	}

	@Override
	public void action() {
		//lógica de almacenamiento del hotel
		System.out.println("Almacenando hotel");
		DBTemporal.hoteles.add(rch.getHotel());
	}

	@Override
	public boolean done() {
		ACLMessage msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		myAgent.send(msj);
		return true;
	}

}
