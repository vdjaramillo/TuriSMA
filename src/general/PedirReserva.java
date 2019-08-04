package general;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class PedirReserva extends Behaviour {

	public PedirReserva(Agent myAgent) {
		super(myAgent);
	}

	@Override
	public void action() {
		/*aquí va toda la lógica relacionada con
		 * pedir reserva*/
		}

	@Override
	public boolean done() {
		System.out.println("Reserva Pedida " + myAgent.getLocalName());
		ACLMessage msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		myAgent.send(msj);
    	return true;
	}

}
