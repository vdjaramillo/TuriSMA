package agentes;

import jade.core.Agent;
import ontologia.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import general.ConnectionSQL;
import general.DatosDB;
import general.MSGListenner;

public class AgenteCliente extends Agent {
	private static final long serialVersionUID = 7289272472167274407L;

	protected void setup() {
		super.getAID().setLocalName("AgenteCliente");
		cargarClientes();
		addBehaviour(new MSGListenner(this));
	}
	
	protected void cargarClientes() {
		Statement stmnt = null;
		try {
			ConnectionSQL.connect();
			ConnectionSQL.conn.setAutoCommit(false);
			stmnt = ConnectionSQL.conn.createStatement();
			ResultSet rs = stmnt.executeQuery("SELECT * FROM cliente;");
			while(rs.next()) {
				DatosDB.usuarios.add(new Cliente(rs.getString("nombre"),rs.getInt("cedula"),rs.getFloat("presupuesto"),rs.getInt("preferencias")));
			}
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
}
