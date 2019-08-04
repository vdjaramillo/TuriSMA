package general;

import java.util.Scanner;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.Cliente;
import ontologia.RegistrarPerfilDelCliente;

public class RegistrarUsuario extends Behaviour {
	/**
	 * 
	 */
	private static final long serialVersionUID = 926330579801615147L;
	RegistrarPerfilDelCliente rpc;
	Scanner input;
	public RegistrarUsuario(Agent myAgent) {
		super(myAgent);
	}

	@Override
	public void action() {
		input = new Scanner(System.in);
		Cliente cliente = new Cliente();
		System.out.println("Digite el nombre del nuevo cliente");
		cliente.setNombre(input.nextLine());
		System.out.println("Digite la cédula del nuevo cliente");
		cliente.setCedula(input.nextInt());
		System.out.println("Digite el presupuesto del nuevo cliente");
		cliente.setPresupuesto(input.nextFloat());
		System.out.println("Digite la cantidad de estrellas que prefiere el nuevo cliente");
		cliente.setPreferencias(input.nextInt());
		rpc = new RegistrarPerfilDelCliente();
		rpc.setCliente(cliente);
	}

	@Override
	public boolean done() {
		try {
			TuriMSG msj = new TuriMSG("AgenteSistema","AUsuario",rpc,ACLMessage.INFORM);
			myAgent.send(msj);
		} catch (Exception e) {
			System.out.println("Error al cargar/enviar el usuario");
		}
		return true;
	}

}
