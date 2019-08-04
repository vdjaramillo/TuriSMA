package general;

import java.io.Serializable;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.Cliente;
import ontologia.RegistrarPerfilDelCliente;

public class AlmacenarUsuario extends Behaviour {
	Cliente cliente;
	public AlmacenarUsuario(Agent myAgent, Serializable rpc) {
		super(myAgent);
		cliente = ((RegistrarPerfilDelCliente)rpc).getCliente();
	}

	@Override
	public void action() {
		System.out.println("Almacenando a: "+cliente.getNombre());
		//toda la lógica para almacenar el usuario en la DB y confirmar al usuario. 
	}

	@Override
	public boolean done() {
		ACLMessage msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		myAgent.send(msj);
		return true;
	}

}
