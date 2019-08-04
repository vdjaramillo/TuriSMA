package agentes;

import java.util.Scanner;

import general.MSGListenner;
import general.TuriMSG;
import jade.core.AID;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;

public class AgenteSistema extends Agent {
	private static final long serialVersionUID = -4212774143203653433L;
	Scanner input = new Scanner(System.in);
	Boolean wh = true;
	protected void setup() {
		super.getAID().setLocalName("AgenteSistema");
		System.out.println("Bienvenido a TuriSMA \n");				
		addBehaviour(new MSGListenner(this));
		inicio();
	}
	public void inicio() {
		wh = true;
		int in;
		TuriMSG msj = new TuriMSG(ACLMessage.INFORM);
		while(wh) {
			System.out.println("¿Qué desea hacer? \n"
					+ "(1) Registrar Usuario \n"
					+ "(2) Registrar Hotel \n"
					+ "(3) Pedir Reservacion \n"
					+ "(4) Editar Reservacion \n");
			in  = 0;
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
