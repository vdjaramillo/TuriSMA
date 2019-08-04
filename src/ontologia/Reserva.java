package ontologia;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Reserva
* @author ontology bean generator
* @version 2019/08/2, 23:50:21
*/
public class Reserva implements Concept {

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
* Protege name: NombreHabitacion
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

}
