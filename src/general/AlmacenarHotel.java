package general;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import ontologia.Hotel;
import ontologia.RegistrarCaracteristicasDelHotel;
import ontologia.TipoHabitacion;

public class AlmacenarHotel extends Behaviour {
/**
	 * 
	 */
	private static final long serialVersionUID = -8731324418407412631L;
RegistrarCaracteristicasDelHotel rch;
TipoHabitacion th;
	public AlmacenarHotel(Agent myAgent, Serializable contentObject) {
		super(myAgent);
		rch = (RegistrarCaracteristicasDelHotel) contentObject;
	}

	@Override
	public void action() {
		//lógica de almacenamiento del hotel
		Statement stmnt = null;
		Connection conn2 = null;
		try {
			conn2 = DriverManager.getConnection(DatosDB.url);
		    conn2.setAutoCommit(false);
		    Hotel hotel = rch.getHotel();
		    TipoHabitacion[] tipoHabitacion = hotel.getHabitaciones();
			stmnt=conn2.createStatement();
			stmnt.executeUpdate(""
					+ "INSERT INTO hotel "
					+ "(nombre,idiomas,direccion,cafeterias,seguridad,telefono,calificacion)"
					+ "VALUES"
					+ "('"+hotel.getNombreHotel()+"',"+hotel.getCertificaciónDeIdiomas()+",'"+hotel.getDireccion()+"',"+hotel.getCafeteriasyRestaurantes()+","+hotel.getNivelDeSeguridad()+","+hotel.getTelefono()+","+hotel.getCalificacion()+");");
			for(int i=0;i<tipoHabitacion.length;i++){
				stmnt.executeUpdate(""
					+ "INSERT INTO tipo_habitacion "
					+ "(nombre,cantidad,costo,hotel)"
					+ "VALUES"
					+ "('"+tipoHabitacion[i].getTipo()+"',"+tipoHabitacion[i].getPrecioNoche()+","+tipoHabitacion[i].getCantidad()+",'"+hotel.getNombreHotel()+"');");
			}
			stmnt.close();
			conn2.commit();
		}catch (SQLException e) {
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
		System.out.println("Almacenando hotel");
		DatosDB.hoteles.add(rch.getHotel());
	}

	@Override
	public boolean done() {
		ACLMessage msj = new TuriMSG("AgenteHotel","UHotel",ACLMessage.INFORM);
		ACLMessage msj2 = new TuriMSG("AgenteSistema","Volver",ACLMessage.INFORM);
		myAgent.send(msj);
		myAgent.send(msj2);
		return true;
	}

}
