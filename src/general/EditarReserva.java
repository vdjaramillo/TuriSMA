package general;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class EditarReserva extends Behaviour {

	public EditarReserva(Agent myAgent) {
		super(myAgent);
	}

	@Override
	public void action() {
		/*aquí va toda la lógica relacionada con
		 * editar reserva*/
	}

	@Override
	public boolean done() {
		System.out.println("Reserva Editada " + myAgent.getLocalName());
		ACLMessage msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		myAgent.send(msj);
    	return true;
	}

}
