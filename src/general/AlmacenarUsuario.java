package general;

import java.io.Serializable;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.Cliente;
import ontologia.RegistrarPerfilDelCliente;

public class AlmacenarUsuario extends Behaviour {
	private static final long serialVersionUID = 3476774726773649822L;
	Cliente cliente;
	public AlmacenarUsuario(Agent myAgent, Serializable rpc) {
		super(myAgent);
		cliente = ((RegistrarPerfilDelCliente)rpc).getCliente();
	}
	@Override
	public void action() {
		System.out.println("Almacenando a: "+cliente.getNombre());
		DBTemporal.usuarios.add(cliente);
	}
	@Override
	public boolean done() {
		ACLMessage msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		myAgent.send(msj);
		return true;
	}

}
