package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import ontologia.Cliente;
import ontologia.Hotel;
import ontologia.Reserva;
import ontologia.TipoHabitacion;

public class Actualizador extends Behaviour {
	int code;
	// 1 usuarios
	// 2 hoteles
	// 3 reservas
	public Actualizador(Agent myAgent, int code) {
		super(myAgent);
		this.code = code;
	}
	@Override
	public void action() {
		switch(code) {
			case 1:
				clientes();
				for(int i = 0 ; i<DatosDB.usuarios.size();i++) {
					System.out.println(DatosDB.usuarios.get(i).getNombre());
				}
				break;
			case 2:
				hoteles();
				for(int i = 0 ; i<DatosDB.hoteles.size();i++) {
					System.out.println(DatosDB.hoteles.get(i).getNombreHotel());
				}
				break;
			case 3:
				reservas();
				for(int i = 0 ; i<DatosDB.reservas.size();i++) {
					System.out.println(DatosDB.reservas.get(i).getId());
				}
				break;
		}
	}

	private void reservas() {
		Statement stmnt = null;
		DatosDB.reservas.clear();
		Connection conn1 = null;
		try {
			conn1 = DriverManager.getConnection(DatosDB.url);
		    conn1.setAutoCommit(false);
			stmnt = conn1.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM reserva;");
			while(rs.next()) {
				Hotel htl = ConsultasHotel(rs.getString("hotel"));
				Cliente clt = ConsultaCliente(rs.getInt("cliente"));
				DatosDB.reservas.add(new Reserva(rs.getInt("id"),clt,htl,rs.getString("tipo_habitacion"),rs.getString("fecha")));
			}
			stmnt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private Cliente ConsultaCliente(int cc) {
		Statement stmnt = null;
		Cliente clt = null;
		Connection conn3 = null;
		try {
			conn3 = DriverManager.getConnection(DatosDB.url);
		    conn3.setAutoCommit(false);
			stmnt = conn3.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM cliente WHERE cedula == '"+cc+"';");
			clt = new Cliente(rs.getString("nombre"),cc,rs.getFloat("presupuesto"),rs.getInt("preferencias"));
			stmnt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn3.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return clt;
	}
	private Hotel ConsultasHotel(String hotel) {
		Statement stmnt = null;
		Hotel htl = null;
		Connection conn4 = null;
		try {
			conn4 = DriverManager.getConnection(DatosDB.url);
		    conn4.setAutoCommit(false);
			stmnt = conn4.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM hotel WHERE nombre == '"+hotel+"';");
			TipoHabitacion[] th = null;
			th = TipoHabitacion(hotel);
			htl = new Hotel(rs.getString("nombre"),rs.getBoolean("idiomas"),rs.getString("direccion"),rs.getBoolean("cafeterias"),rs.getInt("seguridad"),rs.getInt("telefono"),rs.getInt("calificacion"),th);
			stmnt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn4.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return htl;
	}
	private TipoHabitacion[] TipoHabitacion(String hotel) {
		Statement stmnt = null;
		TipoHabitacion[] th = null;
		Connection conn5 = null;
		try {
			conn5 = DriverManager.getConnection(DatosDB.url);
		    conn5.setAutoCommit(false);
			stmnt = conn5.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT COUNT(*) FROM tipo_habitacion WHERE hotel = '"+hotel+"';");
			th = new TipoHabitacion[rs.getInt("COUNT(*)")];
			rs = stmnt.executeQuery("SELECT * FROM tipo_habitacion WHERE hotel = '"+hotel+"';");
			int i = 0; 
			while(rs.next()) {
				th[i]=new TipoHabitacion(rs.getString("nombre"),rs.getInt("cantidad"),rs.getFloat("costo"));
				i++;
			}		
			stmnt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn5.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return th;
	}
	private void hoteles() {
		Statement stmnt2 = null;
		DatosDB.hoteles.clear();
		Connection conn2 = null;
		try {
			conn2 = DriverManager.getConnection(DatosDB.url);
		    conn2.setAutoCommit(false);
			stmnt2 = conn2.createStatement();
			ResultSet rs = stmnt2.executeQuery("SELECT * FROM hotel;");
			while(rs.next()) {
				DatosDB.hoteles.add(new Hotel(rs.getString("nombre"),rs.getBoolean("idiomas"),rs.getString("direccion"),rs.getBoolean("cafeterias"),rs.getInt("seguridad"),rs.getInt("telefono"),rs.getInt("calificacion"),TipoHabitacion(rs.getString("nombre"))));
			}
			stmnt2.close();
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
	private void clientes() {
		Statement stmnt = null;
		DatosDB.usuarios.clear();
		Connection conn6 = null;
		try {
			conn6 = DriverManager.getConnection(DatosDB.url);
		    conn6.setAutoCommit(false);
			stmnt = conn6.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM cliente;");
			while(rs.next()) {
				DatosDB.usuarios.add(new Cliente(rs.getString("nombre"),rs.getInt("cedula"),rs.getFloat("presupuesto"),rs.getInt("preferencias")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn6.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	@Override
	public boolean done() {
		// TODO Auto-generated method stub
		return true;
	}
}