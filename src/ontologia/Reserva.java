package ontologia;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Reserva
* @author ontology bean generator
* @version 2019/08/7, 10:54:08
*/
public class Reserva implements Concept {

	public Reserva() {}
	public Reserva(int id, Cliente cliente, Hotel hotel, String nombreHabitacion, String fecha) {
		setCliente(cliente);
		this.id = id;
		setHotel(hotel);
		setNombreHabitacion(nombreHabitacion);	
		setFecha(fecha);
	}
   /**
* Protege name: cliente
   */
   private Cliente cliente;
   public void setCliente(Cliente value) { 
    this.cliente=value;
   }
   public Cliente getCliente() {
     return this.cliente;
   }

   /**
* Protege name: fecha
   */
   private String fecha;
   public void setFecha(String value) { 
    this.fecha=value;
   }
   public String getFecha() {
     return this.fecha;
   }

   /**
* Protege name: NumeroHabitacion
   */
   private String nombreHabitacion;
   public void setNombreHabitacion(String value) { 
    this.nombreHabitacion=value;
   }
   public String getNombreHabitacion() {
     return this.nombreHabitacion;
   }

   /**
* Protege name: hotel
   */
   private Hotel hotel;
   public void setHotel(Hotel value) { 
    this.hotel=value;
   }
   public Hotel getHotel() {
     return this.hotel;
   }

   /**
* Protege name: id
   */
   private int id;
   public int getId() {
     return this.id;
   }

}
