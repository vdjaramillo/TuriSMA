package general;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
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
		ACLMessage msj = new TuriMSG("AgenteCliente","UCliente",ACLMessage.INFORM);
		ACLMessage msj2 = new TuriMSG("AgenteReservas","UReserva",ACLMessage.INFORM);
		ACLMessage msj3 = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		myAgent.send(msj);
		myAgent.send(msj2);
		myAgent.send(msj3);
		return true;
	}
	private void almacenar() {
		Statement stmnt = null;
		Connection conn2 = null;
		try {
			conn2 = DriverManager.getConnection(DatosDB.url);
		    conn2.setAutoCommit(false);
			stmnt=conn2.createStatement();
			stmnt.executeUpdate(""
					+ "INSERT INTO cliente "
					+ "(nombre,cedula,presupuesto,preferencias)"
					+ "VALUES"
					+ "('"+cliente.getNombre()+"',"+cliente.getCedula()+","+cliente.getPresupuesto()+","+cliente.getPreferencias()+")");
			stmnt.close();
			conn2.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	private void editar() {
		Statement stmnt = null;
		Connection conn2 = null;
		try {
			conn2 = DriverManager.getConnection(DatosDB.url);
		    conn2.setAutoCommit(false);
			stmnt=conn2.createStatement();
			stmnt.executeUpdate("UPDATE cliente set nombre = '"+cliente.getNombre()+"', cedula = "+cliente.getCedula()+", presupuesto = "+cliente.getPresupuesto()+",preferencias = "+cliente.getPreferencias()+" where cedula = "+editar+";");
			if(editar != cliente.getCedula()) {
				stmnt.executeUpdate("UPDATE reserva set cliente = "+cliente.getCedula()+" where cliente = "+editar+";");
			}
			stmnt.close();
			conn2.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn2.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
