package general;

import java.io.Serializable;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.RegistrarCaracteristicasDelHotel;

public class AlmacenarHotel extends Behaviour {
RegistrarCaracteristicasDelHotel rch;
	public AlmacenarHotel(Agent myAgent, Serializable contentObject) {
		super(myAgent);
		rch = (RegistrarCaracteristicasDelHotel) contentObject;
	}

	@Override
	public void action() {
		System.out.println("Almacenando hotel");
	}

	@Override
	public boolean done() {
		ACLMessage msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		myAgent.send(msj);
		return true;
	}

}
