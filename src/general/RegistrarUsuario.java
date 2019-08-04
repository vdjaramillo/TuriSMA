package general;

import java.io.IOException;
import java.util.Scanner;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.Cliente;
import ontologia.RegistrarPerfilDelCliente;
import ontologia.TuriSMAOntology;

public class RegistrarUsuario extends Behaviour {
	RegistrarPerfilDelCliente rpc;
	public RegistrarUsuario(Agent myAgent) {
		super(myAgent);
	}

	@Override
	public void action() {
		Scanner input = new Scanner(System.in);
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
