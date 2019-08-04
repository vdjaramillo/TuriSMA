package general;

import java.util.Scanner;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.Reserva;

public class PedirReserva extends Behaviour {
	private static final long serialVersionUID = 8724669545248283806L;

	public PedirReserva(Agent myAgent) {
		super(myAgent);
	}

	@Override
	public void action() {
		/*aqu� va toda la l�gica relacionada con
		 * pedir reserva*/
		
		while(true) {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			Reserva rsv = new Reserva();
			System.out.println("�Qu� cliente desea pedir una reserva?");
			int i;
			for(i = 0; i<DBTemporal.usuarios.size();i++) {
				System.out.println("("+(i+1)+") "+DBTemporal.usuarios.get(i).getNombre());
			}
			rsv.setCliente(DBTemporal.usuarios.get(input.nextInt()-1));
			System.out.println("�En qu� hotel desea pedir una reserva?");
			for(i = 0; i<DBTemporal.hoteles.size();i++) {
				System.out.println("("+(i+1)+") "+DBTemporal.hoteles.get(i).getNombreHotel());
			}
			rsv.setHotel(DBTemporal.hoteles.get(input.nextInt()-1));
			System.out.println("�Qu� tipo de habitaci�n desea?");
			for(i = 0; i<rsv.getHotel().getHabitaciones().length;i++) {
				System.out.println("("+(i+1)+") "+rsv.getHotel().getHabitaciones()[i].getTipo());
			}
			rsv.setNombreHabitacion(rsv.getHotel().getHabitaciones()[input.nextInt()-1].getTipo());
			System.out.println("Confirma los datos de tu reserva \n"
					+ "Hotel: "+rsv.getHotel().getNombreHotel()+"\n"
					+ "Tipo Habitaci�n: "+rsv.getNombreHabitacion()+"\n"
					+ "Para el usuario: "+rsv.getCliente().getNombre());
			System.out.println("�Todo es correcto? (1) s� (otro) no");
			if(input.nextInt()==1){break;}
		}
	}

	@Override
	public boolean done() {
		System.out.println("Reserva Pedida " + myAgent.getLocalName());
		ACLMessage msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		myAgent.send(msj);
    	return true;
	}

}
