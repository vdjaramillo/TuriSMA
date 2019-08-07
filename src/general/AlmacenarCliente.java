package general;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.Cliente;
import ontologia.RegistrarPerfilDelCliente;

public class AlmacenarCliente extends Behaviour {
	private static final long serialVersionUID = 3476774726773649822L;
	Cliente cliente;
	int editar = -1;
	public AlmacenarCliente(Agent myAgent, Serializable rpc) {
		super(myAgent);
		cliente = ((RegistrarPerfilDelCliente)rpc).getCliente();
	}
	public AlmacenarCliente(Agent myAgent, Serializable contentObject, int edit) {
		this(myAgent,contentObject);
		editar=edit;
	}
	@Override
	public void action() {
		if(editar==-1) {
			almacenar();
		}else {
			editar();
		}
	}
	@Override
	public boolean done() {
		ACLMessage msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		myAgent.send(msj);
		return true;
	}
	void almacenar() {
		Statement stmnt = null;
		try {
			ConnectionSQL.connect();
			ConnectionSQL.conn.setAutoCommit(false);
			stmnt = ConnectionSQL.conn.createStatement();
			stmnt.executeUpdate(""
					+ "INSERT INTO cliente "
					+ "(nombre,cedula,presupuesto,preferencias)"
					+ "VALUES"
					+ "('"+cliente.getNombre()+"',"+cliente.getCedula()+","+cliente.getPresupuesto()+","+cliente.getPreferencias()+")");
			stmnt.close();
			ConnectionSQL.conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ConnectionSQL.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	void editar() {
		System.out.println("Editando");
	}
}
