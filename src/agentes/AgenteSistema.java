package agentes;

import java.util.Scanner;

import general.MSGListenner;
import general.TuriMSG;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class AgenteSistema extends Agent {
	private static final long serialVersionUID = -4212774143203653433L;
	Scanner input;
	protected void setup() {
		super.getAID().setLocalName("AgenteSistema");
		System.out.println("Bienvenido a TuriSMA \n");				
		addBehaviour(new MSGListenner(this));
		inicio(true);
	}
	public void inicio(boolean wh) {
		int in = 0;
		TuriMSG msj = new TuriMSG(ACLMessage.INFORM);
		while(wh) {
			input = new Scanner(System.in);
			System.out.println("¿Qué desea hacer? \n"
					+ "(1) Registrar Usuario \n"
					+ "(2) Registrar Hotel \n"
					+ "(3) Pedir Reservacion \n"
					+ "(4) Editar Reservacion \n");
			try {
				in = input.nextInt();
			}catch(Exception e) {
				System.out.println("Debe digitar un valor entre 1  y 4");
			}
			switch(in) {
				case 1:
					msj.setReceptor("AgenteCliente");
		        	msj.setContent("RUsuario");
		        	send(msj);
		        	wh = false;
		        	break;
				case 2:
					msj.setReceptor("AgenteHotel");
		        	msj.setContent("RHotel");
		        	send(msj);
		        	wh = false;
					break;
				case 3:
					msj.setReceptor("AgenteHotel");
		        	msj.setContent("PReserva");
		        	send(msj);
					wh = false;
					break;
				case 4:
					msj.setReceptor("AgenteHotel");
		        	msj.setContent("EReserva");
		        	send(msj);
					wh = false;
					break;
				default:
					System.out.println("Debe digitar un valor entre 1  y 4");
				
			}
			System.out.println("________________________________________________");
			//Esta debe ser la ultima linea del inicio
			
		}
	}
}
