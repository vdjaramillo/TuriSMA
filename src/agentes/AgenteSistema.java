package agentes;

import general.DatosDB;
import general.MSGListenner;
import general.MenuInicial;
import jade.core.Agent;

public class AgenteSistema extends Agent {
	private static final long serialVersionUID = -4212774143203653433L;
	protected void setup() {
		super.getAID().setLocalName("AgenteSistema");
		DatosDB.temporal();
		System.out.println("Bienvenido a TuriSMA \n");	
		addBehaviour(new MSGListenner(this));
		addBehaviour(new MenuInicial(this));
		
	}
}
