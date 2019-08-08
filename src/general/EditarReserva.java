package general;

import java.io.IOException;
import java.util.Scanner;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.Reserva;
import ontologia.ReservarHotel;

public class EditarReserva extends Behaviour {
	Reserva reserva, preserva;
	int idedit;
	private static final long serialVersionUID = 5383558470414502313L;
	boolean edit = false;
	ReservarHotel rh;
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
				System.out.println("("+(i+1)+") "+DatosDB.reservas.get(i).getCliente().getCedula()+" en : "+DatosDB.reservas.get(i).getHotel().getNombreHotel()+" el: "+DatosDB.reservas.get(i).getFecha());
			}
			int ind = input.nextInt()-1;
			reserva = DatosDB.reservas.get(ind);
			preserva = new Reserva(DatosDB.reservas.get(ind).getId(),DatosDB.reservas.get(ind).getCliente(),DatosDB.reservas.get(ind).getHotel(),DatosDB.reservas.get(ind).getNombreHabitacion(),DatosDB.reservas.get(ind).getFecha());
			idedit=reserva.getId();
			System.out.println("¿Desea cancelar la reserva? (1) sí (otro) no");
			if(input.nextInt()==1) {
				TuriMSG msj;
				try {
					rh = new ReservarHotel();
					rh.setReserva(reserva);
					msj = new TuriMSG("AgenteSistema","AElReserva",rh,ACLMessage.INFORM);
					msj.setParametro1(reserva.getId());
					msj.setParametro2(1);
					myAgent.send(msj);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
			System.out.println("¿Desea cambiar de hotel? (1) sí (otro) no");
			if(input.nextInt()==1) {
				edit=true;
				System.out.println("Elija el nuevo hotel");
				for(int i = 0; i<DatosDB.hoteles.size();i++) {
					System.out.println("("+(i+1)+") "+DatosDB.hoteles.get(i).getNombreHotel());
				}
				reserva.setHotel(DatosDB.hoteles.get(input.nextInt()-1));
			}
			System.out.println("¿Desea cambiar de habitación? (1) sí (otro) no");
			if(input.nextInt()==1) {
				edit = true;
				System.out.println("Elija la nueva habitación");
				for(int i = 0; i<reserva.getHotel().getHabitaciones().length;i++) {
					System.out.println("("+(i+1)+") "+reserva.getHotel().getHabitaciones()[i].getTipo());
				}
				reserva.setNombreHabitacion(reserva.getHotel().getHabitaciones()[input.nextInt()-1].getTipo());
			}
			System.out.println("¿Desea cambiar de fecha? (1) sí (otro) no");
			if(input.nextInt()==1) {
				input = new Scanner(System.in);
				edit = true;
				System.out.println("Digite la nueva fecha dd/mm/yy");
				reserva.setFecha(input.nextLine());
			}
			rh = new ReservarHotel();
			rh.setReserva(reserva);
		}else {
			System.out.println("No hay reservas para editar");
		}
	}
	@Override
	public boolean done() {
		TuriMSG msj;
		if(edit) {
			try {
				msj = new TuriMSG("AgenteSistema","AEReserva",rh,ACLMessage.INFORM);
				msj.setParametro1(rh.getReserva().getId());
				msj.setObjeto2(preserva);
				myAgent.send(msj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
			myAgent.send(msj);
		}
		return true;
	}

}
