package general;
import java.util.Scanner;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.Cliente;
import ontologia.RegistrarPerfilDelCliente;

public class EditarCliente extends Behaviour {
	private static final long serialVersionUID = -8505661414638648402L;
	Cliente cliente;
	RegistrarPerfilDelCliente rpc;
	Scanner input;
	int ccedit;
	public EditarCliente(Agent myAgent) {
		super(myAgent);
	}

	@SuppressWarnings("resource")
	@Override
	public void action() {
		input = new Scanner(System.in);
		System.out.println(myAgent.getLocalName()+" ¿Qué cliente desea editar?");
		for(int i = 0; i<DatosDB.usuarios.size();i++) {
			System.out.println("("+(i+1)+") "+DatosDB.usuarios.get(i).getNombre());
		}
		cliente = DatosDB.usuarios.get(input.nextInt()-1);
		ccedit=cliente.getCedula();
		System.out.println("¿Desea editar el nombre? (1) sí (otro) no");
		if(input.nextInt()==1) {
			input = new Scanner(System.in);
			System.out.println("Digite el nombre del cliente");
			cliente.setNombre(input.nextLine());
		}
		System.out.println("¿Desea editar la cédula? (1) sí (otro) no");
		if(input.nextInt()==1) {
			System.out.println("Digite la cédula del nuevo cliente");
			cliente.setCedula(input.nextInt());
		}
		System.out.println("¿Desea editar el presupuesto? (1) sí (otro) no");
		if(input.nextInt()==1) {
			System.out.println("Digite el presupuesto del nuevo cliente");
			cliente.setPresupuesto(input.nextFloat());
		}
		System.out.println("¿Desea editar la cantidad de estrellas preferidas? (1) sí (otro) no");
		if(input.nextInt()==1) {
			System.out.println("Digite la cantidad de estrellas que prefiere el nuevo cliente");
			cliente.setPreferencias(input.nextInt());
		}
		rpc = new RegistrarPerfilDelCliente();
		rpc.setCliente(cliente);
	}
	@Override
	public boolean done() {
		try {
			TuriMSG msj = new TuriMSG("AgenteSistema","AECliente",rpc,ACLMessage.INFORM);
			msj.setParametro1(ccedit);
			myAgent.send(msj);
		} catch (Exception e) {
			System.out.println("Error al cargar/enviar el usuario");
		}		
		return true;
	}

}
