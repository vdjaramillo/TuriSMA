package general;

import java.io.Serializable;
import java.sql.SQLException;
import java.sql.Statement;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.ReservarHotel;

public class AlmacenarReserva extends Behaviour {
	private static final long serialVersionUID = 1589756164826324694L;
	ReservarHotel rh;
	int edit = -1;
	public AlmacenarReserva(Agent myAgent, Serializable contentObject) {
		super(myAgent);
		rh = (ReservarHotel) contentObject;
	}
	public void action() {
		System.out.println("Reservando");
		if(edit==-1) {
			almacenar();
		}else {
			editar();
		}
	}
	private void editar() {
		
	}
	private void almacenar() {
		Statement stmnt = null;
		try {
			ConnectionSQL.connect();
			ConnectionSQL.conn.setAutoCommit(false);
			stmnt = ConnectionSQL.conn.createStatement();
			stmnt.executeUpdate(""
					+ "INSERT INTO reserva "
					+ "VALUES("+rh.getReserva().getCliente().getCedula()+",'"
							+ rh.getReserva().getHotel().getNombreHotel()+"','"
							+ rh.getReserva().getNombreHabitacion()+"','aunno')");
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
	public boolean done() {
		System.out.println("************************* \n"
				+ "Reserva Confirmada \n"
				+ "Hotel: "+rh.getReserva().getHotel().getNombreHotel()+"\n"
				+ "Tipo Habitación: "+rh.getReserva().getNombreHabitacion()+"\n"
				+ "Para el usuario: "+rh.getReserva().getCliente().getNombre());
		ACLMessage msj = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		myAgent.send(msj);
		return true;
	}

}
