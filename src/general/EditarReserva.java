package general;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class EditarReserva extends Behaviour {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5383558470414502313L;

	public EditarReserva(Agent myAgent) {
		super(myAgent);
	}

	@Override
	public void action() {
		/*aqu� va toda la l�gica relacionada con
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
