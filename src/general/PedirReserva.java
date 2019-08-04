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
		/*aquí va toda la lógica relacionada con
		 * pedir reserva*/
		
		while(true) {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			Reserva rsv = new Reserva();
			System.out.println("¿Qué cliente desea pedir una reserva?");
			int i;
			for(i = 0; i<DBTemporal.usuarios.size();i++) {
				System.out.println("("+(i+1)+") "+DBTemporal.usuarios.get(i).getNombre());
			}
			rsv.setCliente(DBTemporal.usuarios.get(input.nextInt()-1));
			System.out.println("¿En qué hotel desea pedir una reserva?");
			for(i = 0; i<DBTemporal.hoteles.size();i++) {
				System.out.println("("+(i+1)+") "+DBTemporal.hoteles.get(i).getNombreHotel());
			}
			rsv.setHotel(DBTemporal.hoteles.get(input.nextInt()-1));
			System.out.println("¿Qué tipo de habitación desea?");
			for(i = 0; i<rsv.getHotel().getHabitaciones().length;i++) {
				System.out.println("("+(i+1)+") "+rsv.getHotel().getHabitaciones()[i].getTipo());
			}
			rsv.setNombreHabitacion(rsv.getHotel().getHabitaciones()[input.nextInt()-1].getTipo());
			System.out.println("Confirma los datos de tu reserva \n"
					+ "Hotel: "+rsv.getHotel().getNombreHotel()+"\n"
					+ "Tipo Habitación: "+rsv.getNombreHabitacion()+"\n"
					+ "Para el usuario: "+rsv.getCliente().getNombre());
			System.out.println("¿Todo es correcto? (1) sí (otro) no");
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
