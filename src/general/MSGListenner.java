package general;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.MessageTemplate;
import ontologia.TuriSMAOntology;

public class MSGListenner extends CyclicBehaviour{
		
	private static final long serialVersionUID = -8303429277705296458L;
		String tipoEscucha;
		TuriMSG msg;
		boolean escucha;
		public MSGListenner(Agent a){
			super(a);
			escucha = false;
		}
	/* piensen en este action como en un servidor
	 este action lo que hace es que recibe 
	 todos los mensajes de todos los agentes
	 como cada agente tiene una instancia de 
	 este comportamiento, cada instancia recibe 
	 s�lo los mensajes de su agente poseedor
	 y lo que hace es que, seg�n el mensaje que se env�e
	 crea en su agente el comportamiento acorde 
	*/
	public void action() {
		AID[] aid = new AID[1];
		aid[0] = myAgent.getAID();
		MessageTemplate mt = MessageTemplate.and(
				MessageTemplate.MatchReceiver(aid),
				MessageTemplate.MatchOntology(TuriSMAOntology.ONTOLOGY_NAME)
			);
		msg = (TuriMSG) myAgent.receive(mt);  				
		if(msg != null) {
			if(msg.getContent().equals("RCliente")) {
				//comportamiento para registrar un usuario/cliente
				myAgent.addBehaviour(new RegistrarCliente(myAgent));
			}else if(msg.getContent().equals("ECliente")){
				//comportamiento para registrar un usuario/cliente
				myAgent.addBehaviour(new EditarCliente(myAgent));
			}else if(msg.getContent().equals("RHotel")) {
				//comportamiento para registrar un hotel
				myAgent.addBehaviour(new RegistrarHotel(myAgent));
			}else if(msg.getContent().equals("Volver")){
				//se recarga el men� inicial
				myAgent.addBehaviour(new MenuInicial(myAgent));
			}else if(msg.getContent().equals("PReserva")) {
				//comportamiento para pedir una reserva
				myAgent.addBehaviour(new PedirReserva(myAgent));
			}else if(msg.getContent().equals("EReserva")) {
				//comportamiento para editar una reserva
				myAgent.addBehaviour(new EditarReserva(myAgent));
			}else if(msg.getContent().equals("ACliente")) {
				//comportamiento para almacenar un usuario
				try {
					myAgent.addBehaviour(new AlmacenarCliente(myAgent,msg.getContentObject()));
				} catch (Exception e) {
					System.out.println("Error al comportar el almacenamiento del usuario");
				}
			}else if(msg.getContent().equals("AECliente")){
				//comportamiento para almacenar la edicion de un cliente
				try {
					myAgent.addBehaviour(new AlmacenarCliente(myAgent,msg.getContentObject(),msg.getParametro1()));
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
				//comportamiento para almacenar una reserva
				try {
					myAgent.addBehaviour(new AlmacenarReserva(myAgent,msg.getContentObject()));
				} catch (Exception e) {
					System.out.println("Error al comportar el almacenamiento de la reserva");
				}
			}else if(msg.getContent().equals("AEReserva")) {
				//edici�n de una reserva
				myAgent.addBehaviour(new AlmacenarReserva(myAgent,msg.getContentObject(),msg.getParametro1(),msg.getObjeto2()));
			}else if(msg.getContent().equals("AElReserva")) {
				//eliminaci�n de una reserva 
				myAgent.addBehaviour(new AlmacenarReserva(myAgent,msg.getContentObject(),msg.getParametro1(),msg.getParametro2()));
			}else if(msg.getContent().equals("CReserva")) {
				//comportamiento para confirmar la edici�n o creaci�n de una reserva
				myAgent.addBehaviour(new ConfirmarReserva(myAgent,msg.getContentObject()));
			}else if(msg.getContent().equals("UCliente")) {
				myAgent.addBehaviour(new Actualizador(myAgent,1));
			}else if(msg.getContent().equals("UReserva")) {
				myAgent.addBehaviour(new Actualizador(myAgent,3));
			}else if(msg.getContent().equals("UHotel")) {
				myAgent.addBehaviour(new Actualizador(myAgent,2));
			}
			escucha = true;
		}else {
			block();
		}
		
	}
}
