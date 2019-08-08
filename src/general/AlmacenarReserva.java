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
	public AlmacenarReserva(Agent myAgent, Serializable contentObject, int parametro1, Object preserva) {
		this(myAgent, contentObject);
		edit = parametro1;
		this.preserva = (Reserva) preserva;
	}
	public AlmacenarReserva(Agent myAgent, Serializable contentObject, int parametro1, int parametro2) {
		this(myAgent,contentObject);
		edit = (parametro1);
		elim = parametro2;
		
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
		reserva = rh.getReserva();
		try {
			conn2 = DriverManager.getConnection(DatosDB.url);
		    conn2.setAutoCommit(false);
			stmnt=conn2.createStatement();
			stmnt.executeUpdate("DELETE from reserva WHERE id = "+reserva.getId()+";");
			stmnt.executeUpdate("UPDATE tipo_habitacion SET cantidad = cantidad + 1 WHERE nombre = '"+reserva.getNombreHabitacion()+"' AND hotel = '"+reserva.getHotel().getNombreHotel()+"';");
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
		System.out.println("Eliminando reserva "+elim);
	}
	private void editar() {
		Statement stmnt = null;
		Connection conn2 = null;
		try {
			conn2 = DriverManager.getConnection(DatosDB.url);
		    conn2.setAutoCommit(false);
			stmnt=conn2.createStatement();
			System.out.println(preserva.getHotel().getNombreHotel()  +" - "+ rh.getReserva().getHotel().getNombreHotel());
			System.out.println(preserva.getNombreHabitacion() +" - "+rh.getReserva().getNombreHabitacion());
			if(preserva.getHotel().getNombreHotel() != rh.getReserva().getHotel().getNombreHotel()) {			
				stmnt.executeUpdate("UPDATE tipo_habitacion SET cantidad = cantidad + 1 WHERE nombre = '"+preserva.getNombreHabitacion()+"' AND hotel = '"+preserva.getHotel().getNombreHotel()+"';");
				stmnt.executeUpdate("UPDATE tipo_habitacion SET cantidad = cantidad - 1 WHERE nombre = '"+rh.getReserva().getNombreHabitacion()+"' AND hotel = '"+rh.getReserva().getHotel().getNombreHotel()+"';");
			}else if(preserva.getNombreHabitacion() != rh.getReserva().getNombreHabitacion()) {
				stmnt.executeUpdate("UPDATE tipo_habitacion SET cantidad = cantidad + 1 WHERE nombre = '"+preserva.getNombreHabitacion()+"' AND hotel = '"+preserva.getHotel().getNombreHotel()+"';");
				stmnt.executeUpdate("UPDATE tipo_habitacion SET cantidad = cantidad - 1 WHERE nombre = '"+rh.getReserva().getNombreHabitacion()+"' AND hotel = '"+rh.getReserva().getHotel().getNombreHotel()+"';");
			}
			stmnt.executeUpdate("UPDATE reserva set hotel = '"+rh.getReserva().getHotel().getNombreHotel()+"', tipo_habitacion = '"+rh.getReserva().getNombreHabitacion()+"', fecha = '"+rh.getReserva().getFecha()+"';");
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
		System.out.println("Editando reserva "+edit);
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
			stmnt.executeUpdate("UPDATE tipo_habitacion SET cantidad = cantidad - 1 WHERE nombre = '"+rh.getReserva().getNombreHabitacion()+"' AND hotel = '"+rh.getReserva().getHotel().getNombreHotel()+"';");
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

