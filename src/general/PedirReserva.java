package general;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.Hotel;
import ontologia.Reserva;
import ontologia.ReservarHotel;

public class PedirReserva extends Behaviour {
	private static final long serialVersionUID = 8724669545248283806L;
	ReservarHotel rh;
	boolean reserva=true;
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
			System.out.println(myAgent.getLocalName()+"¿Qué cliente desea pedir una reserva?");
			int i;
			for(i = 0; i<DatosDB.usuarios.size();i++) {
				System.out.println("("+(i+1)+") "+DatosDB.usuarios.get(i).getNombre());
			}
			rsv.setCliente(DatosDB.usuarios.get(input.nextInt()-1));
			System.out.println("¿En qué hotel desea pedir una reserva?");
			for(i = 0; i<DatosDB.hoteles.size();i++) {
				System.out.println("("+(i+1)+") "+DatosDB.hoteles.get(i).getNombreHotel());
			}
			rsv.setHotel(DatosDB.hoteles.get(input.nextInt()-1));
			System.out.println("¿Qué tipo de habitación desea?");
			int hab;
			for(i = 0; i<rsv.getHotel().getHabitaciones().length;i++) {
				if(rsv.getHotel().getHabitaciones()[i].getCantidad()>0) {
					System.out.println("("+(i+1)+") "+rsv.getHotel().getHabitaciones()[i].getTipo());
				}
			}
			hab = input.nextInt()-1;
			rsv.setNombreHabitacion(rsv.getHotel().getHabitaciones()[hab].getTipo());
			System.out.println("¿Para qué fecha? dd/mm/yyyy");
			input = new Scanner(System.in);
			rsv.setFecha(input.nextLine());
			System.out.println("Confirma los datos de tu reserva \n"
					+ "Hotel: "+rsv.getHotel().getNombreHotel()+"\n"
					+ "Tipo Habitación: "+rsv.getNombreHabitacion()+"\n"
					+ "Para el usuario: "+rsv.getCliente().getNombre()+"\n"
					+ "Para: "+rsv.getFecha());
			//verificacion del presupuesto
			if(rsv.getHotel().getHabitaciones()[hab].getCantidad()>rsv.getCliente().getPresupuesto()) {
				System.out.println("El costo de la habitacion es mayor \n"
						+ "al presupuesto del cliente. ¿Desea continuar? \n"
						+ "(1) si (otro) no");
				input = new Scanner(System.in);
				if(input.nextInt()!=1) {
					System.out.println("¿Qué tipo de habitación desea?");
					boolean habpres = false;
					for(i = 0; i<rsv.getHotel().getHabitaciones().length;i++) {
						if(rsv.getHotel().getHabitaciones()[i].getCantidad()>0 && rsv.getHotel().getHabitaciones()[i].getCantidad()<=rsv.getCliente().getPresupuesto()) {
							System.out.println("("+(i+1)+") "+rsv.getHotel().getHabitaciones()[i].getTipo());
							habpres = true;
						}
					}
					if(habpres) {
						rsv.setNombreHabitacion(rsv.getHotel().getHabitaciones()[input.nextInt()-1].getTipo());
					}else {
						System.out.println("En el hotel: " + rsv.getHotel().getNombreHotel()+" \n "
								+ "no tiene habitaciones disponibles para su presupuesto \n"
								+ "Elija otro hotel: ");
						LinkedList<Hotel> htl = Hotel.getHoteles(rsv.getCliente().getPresupuesto());
						if(htl.size()<1) {
							System.out.println("No hay hoteles disponibles para el \n"
									+ "presupuesto del cliente");
							reserva = false;
							//falta organizar el condicional para que, si no hay habitaciones disponibles
							//no almacene la reserva, el booleano se llama reserva
							break;
						}else {
							System.out.println("¿En qué hotel desea pedir una reserva?");
							for(i = 0; i<htl.size();i++) {
								System.out.println("("+(i+1)+") "+htl.get(i).getNombreHotel());
							}
							rsv.setHotel(htl.get(input.nextInt()-1));
							System.out.println("¿Qué tipo de habitación desea?");
							for(i = 0; i<rsv.getHotel().getHabitaciones().length;i++) {
								if(rsv.getHotel().getHabitaciones()[i].getCantidad()>0 && rsv.getHotel().getHabitaciones()[i].getCantidad()<=rsv.getCliente().getPresupuesto()) {
									System.out.println("("+(i+1)+") "+rsv.getHotel().getHabitaciones()[i].getTipo());
									habpres = true;
								}
							}
							hab = input.nextInt()-1;
							rsv.setNombreHabitacion(rsv.getHotel().getHabitaciones()[hab].getTipo());
							System.out.println("¿Para qué fecha? dd/mm/yyyy");
							rsv.setFecha(input.nextLine());
							System.out.println("Confirma los datos de tu reserva \n"
									+ "Hotel: "+rsv.getHotel().getNombreHotel()+"\n"
									+ "Tipo Habitación: "+rsv.getNombreHabitacion()+"\n"
									+ "Para el usuario: "+rsv.getCliente().getNombre()+"\n"
											+ "Para: "+rsv.getFecha());
						}
					}
				}
			}
			
			if(reserva) {
				System.out.println("¿Todo es correcto? (1) sí (otro) no");
				if(input.nextInt()==1){
					rh = new ReservarHotel();
					rh.setReserva(rsv);
					ACLMessage msj;
					try {
						msj = new TuriMSG("AgenteHotel","DHabitacion",rh,ACLMessage.INFORM);
						myAgent.send(msj);
					} catch (IOException e) {
						System.out.println("Error al disminuir la cantidad de habitaciones");
					}
					reserva = true;
					break;
				}
			}else {
				TuriMSG msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
				myAgent.send(msj);
			}
		}
	}

	@Override
	public boolean done() {
		if(reserva) {
			ACLMessage msj;
			try {
				msj = new TuriMSG("AgenteSistema","AReserva",rh,ACLMessage.INFORM);
				myAgent.send(msj);
				System.out.println("Reserva Pedida " + myAgent.getLocalName());
			} catch (IOException e) {
				System.out.println("Error al pedir la reserva");
			}	
		}
		return true;
	}
}
