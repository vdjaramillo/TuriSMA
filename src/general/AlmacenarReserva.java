package general;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.Reserva;
import ontologia.ReservarHotel;
import ontologia.Reserva;
import ontologia.TipoHabitacion;

public class AlmacenarReserva extends Behaviour {
	private static final long serialVersionUID = 1589756164826324694L;
	ReservarHotel rh;
	Reserva reserva;
	TipoHabitacion tipoHabitacion;
	int edit = -1;
	int elim = -1;
	Reserva preserva;
	public AlmacenarReserva(Agent myAgent, Serializable contentObject) {
		super(myAgent);
		rh = (ReservarHotel) contentObject;
	}
	public AlmacenarReserva(Agent myAgent, Serializable contentObject, int parametro1) {
		this(myAgent, contentObject);
		edit = parametro1;
	}
	public AlmacenarReserva(Agent myAgent, Serializable contentObject, int parametro1, int parametro2, Object preserva) {
		this(myAgent,contentObject,parametro1);
		elim = parametro2;
		this.preserva = (Reserva) preserva;
	}
	public void action() {
		if(edit==-1 && elim ==-1) {
			almacenar();
		}else if(elim!=-1){
			eliminar();
		}else {
			editar();
		}
	}
	private void eliminar() {
		Statement stmnt = null;
		Connection conn2 = null;
		try {
			conn2 = DriverManager.getConnection(DatosDB.url);
		    conn2.setAutoCommit(false);
			stmnt=conn2.createStatement();
			stmnt.executeUpdate("DELETE reserva where id = "+reserva.getId()+";");
			stmnt.executeUpdate("UPDATE tipo_habitacion set cantidad = cantidad +1 where nombre = "+reserva.getNombreHabitacion()+" and hotel = "+reserva.getHotel()+";");
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
		System.out.println("Eliminando reserva "+edit);
	}
	private void editar() {
		/*Statement stmnt = null;
		Connection conn2 = null;
		try {
			conn2 = DriverManager.getConnection(DatosDB.url);
		    conn2.setAutoCommit(false);
			stmnt=conn2.createStatement();
			String consulta = "UPDATE " +
			stmnt.executeUpdate("UPDATE cliente set nombre = '"+cliente.getNombre()+"', cedula = "+cliente.getCedula()+", presupuesto = "+cliente.getPresupuesto()+",preferencias = "+cliente.getPreferencias()+" where cedula = "+editar+";");
			
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
		System.out.println("Editando reserva "+edit);*/
	}
	private void almacenar() {
		Statement stmnt = null;
		Connection conn2 = null;
		try {
			conn2 = DriverManager.getConnection(DatosDB.url);
		    conn2.setAutoCommit(false);
			stmnt = conn2.createStatement();
			stmnt.executeUpdate(""
					+ "INSERT INTO reserva (cliente,hotel,tipo_habitacion,fecha)"
					+ "VALUES("+rh.getReserva().getCliente().getCedula()+",'"
							+ rh.getReserva().getHotel().getNombreHotel()+"','"
							+ rh.getReserva().getNombreHabitacion()+"','"
							+ rh.getReserva().getFecha()+"')");
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

