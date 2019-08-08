package general;

import java.io.Serializable;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.ReservarHotel;

public class ConfirmarReserva extends Behaviour {
	private static final long serialVersionUID = 6153392452005199595L;
	ReservarHotel rh;
	public ConfirmarReserva(Agent myAgent,Serializable rh){
		super(myAgent);
		this.rh=(ReservarHotel)rh;
	}
	@Override
	public void action() {
		System.out.println("************************* \n"
				+ "Reserva Confirmada \n"
				+ "Hotel: "+rh.getReserva().getHotel().getNombreHotel()+"\n"
				+ "Tipo Habitación: "+rh.getReserva().getNombreHabitacion()+"\n"
				+ "Para el usuario: "+rh.getReserva().getCliente().getNombre());	
	}

	@Override
	public boolean done() {
		TuriMSG msj = new TuriMSG("AgenteReservas","UReserva",ACLMessage.INFORM);
		myAgent.send(msj);
		TuriMSG msj2 = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		myAgent.send(msj2);
		return true;
	}

}
