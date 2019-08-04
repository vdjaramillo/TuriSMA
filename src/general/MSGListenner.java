package general;
import agentes.AgenteSistema;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.MessageTemplate;

public class MSGListenner extends CyclicBehaviour{
		
	private static final long serialVersionUID = -8303429277705296458L;
		String tipoEscucha;
		TuriMSG msg;
		Boolean escucha;
		public MSGListenner(Agent a){
			super(a);
			escucha = false;
		}
	public void action() {
		AID[] aid = new AID[1];
		aid[0] = myAgent.getAID();
		System.out.println("El que escucha es: " + myAgent.getAID().getLocalName());
		MessageTemplate mt = MessageTemplate.and(
				MessageTemplate.MatchReceiver(aid),
				MessageTemplate.MatchOntology("TuriSMA")
			);
		msg = (TuriMSG) myAgent.receive(mt);  				
		if(msg != null) {
			if(msg.getContent().equals("RUsuario")) {
				//comportamiento para registrar un usuario/cliente
				myAgent.addBehaviour(new RegistrarUsuario(myAgent));
			}else if(msg.getContent().equals("RHotel")) {
				//comportamiento para registrar un hotel
				myAgent.addBehaviour(new RegistrarHotel(myAgent));
			}else if(msg.getContent().equals("Volver")){
				//se recarga el menú inicial
				((AgenteSistema)myAgent).inicio(true);
			}else if(msg.getContent().equals("PReserva")) {
				//comportamiento para pedir una reserva
				myAgent.addBehaviour(new PedirReserva(myAgent));
			}else if(msg.getContent().equals("EReserva")) {
				//comportamiento para editar una reserva
				myAgent.addBehaviour(new EditarReserva(myAgent));
			}else if(msg.getContent().equals("AUsuario")) {
				//comportamiento para almacenar un usuario
				try {
					myAgent.addBehaviour(new AlmacenarUsuario(myAgent,msg.getContentObject()));
				} catch (Exception e) {
					System.out.println("Error al comportar el almacenamiento del usuario");
				}
			}else if(msg.getContent().equals("AHotel")) {
				//comportamiento para almacenar un hotel
				try {
					myAgent.addBehaviour(new AlmacenarHotel(myAgent,msg.getContentObject()));
				} catch (Exception e) {
					System.out.println("Error al comportar el almacenamiento del hotel");
				}
			}else if(msg.getContent().equals("AReserva")) {
				//comportamiento para almacenar una 
				//reserva
			}else if(msg.getContent().equals("AEReserva")) {
				//comportamiento para almacenar la edición
				//de una reserva
			}else if(msg.getContent().equals("DHabitacio")) {
				//comportamiento para disminuir la cantidad
				//de habitaciones de un hotel
			}
			escucha = true;
		}else {
			block();
		}
		
	}
}
