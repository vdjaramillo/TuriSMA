package general;

import java.io.IOException;
import java.io.Serializable;

import jade.core.AID;
import jade.lang.acl.ACLMessage;
import ontologia.TuriSMAOntology;

public class TuriMSG extends ACLMessage {
	private static final long serialVersionUID = -1205981458725310907L;
	String contenido;
	Serializable objeto;
	public TuriMSG(int performativa) {
		super(performativa);
    	setOntology(TuriSMAOntology.ONTOLOGY_NAME);
    }
	public TuriMSG(String nombreReceptor, String contenido, int performativa){
		super(performativa);
		setLanguage("Spanish");
		AID id = new AID();
		id.setLocalName(nombreReceptor);
    	addReceiver(id);
    	setOntology(TuriSMAOntology.ONTOLOGY_NAME);
    	setContent(contenido);
	}
	public TuriMSG(String nombreReceptor, String contenido, Serializable objeto, int performativa) throws IOException{
		this(nombreReceptor,contenido,performativa);
		setContentObject(objeto);
	}
	public void setReceptor(String nombreReceptor) {
		AID id = new AID();
		id.setLocalName(nombreReceptor);
    	addReceiver(id);
	}
	public void setContent(String content) {
		contenido = content;
	}
	public String getContent() {
		return contenido;
	}
	public void setContentObject(Serializable object) {
		objeto = object;
	}
	public Serializable getContentObject() {
		return objeto;
	}
}
