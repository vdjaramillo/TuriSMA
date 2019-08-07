package agentes;

import general.Actualizador;
import general.MSGListenner;
import jade.core.Agent;

public class AgenteReservas extends Agent {
	private static final long serialVersionUID = -8703842323150040172L;

	protected void setup() {
		super.getAID().setLocalName("AgenteReservas");
		//addBehaviour(new Actualizador(this,3));
		addBehaviour(new MSGListenner(this));
	}
}
