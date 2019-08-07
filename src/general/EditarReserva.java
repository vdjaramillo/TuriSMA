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
			for(int i = 0; i<DatosDB.reservas.size();i++) {
				System.out.println("("+(i+1)+") "+DatosDB.usuarios.get(i).getNombre());
			}
			reserva = DatosDB.reservas.get(input.nextInt()-1);
			idedit=reserva.getId();
			System.out.println("¿Desea cancelar la reserva? (1) sí (otro) no");
			if(input.nextInt()==1) {
				//código para cancelar la reserva
				return;
			}
			System.out.println("¿Desea cambiar de hotel? (1) sí (otro) no");
			if(input.nextInt()==1) {
				//código para cambiar de hotel
			}
			System.out.println("¿Desea cambiar de habitación? (1) sí (otro) no");
			if(input.nextInt()==1) {
				//código para cambiar de habitación
			}
		}else {
			System.out.println("No hay reservas para editar");
		}
	}
	@Override
	public boolean done() {
		/*ACLMessage msj;
		if(edit) {
			msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		}else{
			msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		}
		myAgent.send(msj);*/
		System.out.println("Cancelado");
    	return true;
	}

}
