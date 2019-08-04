package agentes;

import jade.core.Agent;
import general.MSGListenner;

public class AgenteCliente extends Agent {
	private static final long serialVersionUID = 7289272472167274407L;

	protected void setup() {
		super.getAID().setLocalName("AgenteCliente");
		addBehaviour(new MSGListenner(this));
	}
	
}
