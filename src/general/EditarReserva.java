package general;

import java.util.Scanner;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.Reserva;

public class EditarReserva extends Behaviour {
	Reserva reserva;
	int idedit;
	/**
	 * 
	 */
	private static final long serialVersionUID = 5383558470414502313L;
	boolean edit = false;
	public EditarReserva(Agent myAgent) {
		super(myAgent);
	}
	@Override
	public void action() {
		if(!DatosDB.reservas.isEmpty()) {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.println("¿Qué reserva desea editar?");
			for(int i = 0; i<DatosDB.usuarios.size();i++) {
				System.out.println("("+(i+1)+") "+DatosDB.usuarios.get(i).getNombre());
			}
		reserva = DatosDB.reservas.get(input.nextInt()-1);
			idedit=reserva.getId();
			
		}else {
			System.out.println("No hay reservas para editar");
		}
	}
	@Override
	public boolean done() {
		ACLMessage msj;
		if(edit) {
			msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		 	}else {
			msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		}
		myAgent.send(msj);
    	return true;
	}

}
