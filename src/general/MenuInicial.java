package general;

import java.util.Scanner;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

public class MenuInicial extends Behaviour {
	private static final long serialVersionUID = -4487620200254667600L;
	Scanner input;
	public MenuInicial(Agent myAgent) {
		super(myAgent);
	}
	@Override
	public void action() {
		int in = 0;
		TuriMSG msj = new TuriMSG(ACLMessage.INFORM);
		boolean wh = true;
		while(wh) {
			input = new Scanner(System.in);
			System.out.println("¿Qué desea hacer? \n"
					+ "(0) Registrar Cliente \n"
					+ "(1) Editar Cliente \n"
					+ "(2) Registrar Hotel \n"
					+ "(3) Pedir Reservación \n"
					+ "(4) Editar Reservación \n");
			try {
				in = input.nextInt();
			}catch(Exception e) {
				System.out.println("Debe digitar un valor entre 1  y 4");
			}
			switch(in) {
				case 0:
					msj.setReceptor("AgenteCliente");
		        	msj.setContent("RCliente");
		        	myAgent.send(msj);
		        	wh = false;
		        	break;
				case 1:
					msj.setReceptor("AgenteCliente");
		        	msj.setContent("ECliente");
		        	myAgent.send(msj);
					wh = false;
					break;
				case 2:
					msj.setReceptor("AgenteHotel");
		        	msj.setContent("RHotel");
		        	myAgent.send(msj);
		        	wh = false;
					break;
				case 3:
					msj.setReceptor("AgenteHotel");
		        	msj.setContent("PReserva");
		        	myAgent.send(msj);
					wh = false;
					break;
				case 4:
					msj.setReceptor("AgenteHotel");
		        	msj.setContent("EReserva");
		        	myAgent.send(msj);
					wh = false;
					break;
				default:
					System.out.println("Debe digitar un valor entre 1  y 4");
				
			}
			System.out.println("________________________________________________");
			//Esta debe ser la ultima linea del inicio
		}
	}

	@Override
	public boolean done() {
		return true;
	}

}
