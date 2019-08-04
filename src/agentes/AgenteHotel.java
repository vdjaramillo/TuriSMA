package agentes;

import general.MSGListenner;
import jade.core.Agent;

public class AgenteHotel extends Agent {
	private static final long serialVersionUID = -3321238939424456633L;

	protected void setup() {
		super.getAID().setLocalName("AgenteHotel");
		addBehaviour(new MSGListenner(this));
	}
}
