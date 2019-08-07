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
	int parametro1;
	int parametro2;
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
	public int getParametro1() {
		return parametro1;
	}
	public void setParametro1(int p) {
		parametro1 = p;
	}
	public int getParametro2() {
		return parametro2;
	}
	public void setParametro2(int p) {
		parametro1 = p;
	}
}
