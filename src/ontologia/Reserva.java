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
* Protege name: NumeroHabitacion
   */
   private int numeroHabitacion;
   public void setNumeroHabitacion(int value) { 
    this.numeroHabitacion=value;
   }
   public int getNumeroHabitacion() {
     return this.numeroHabitacion;
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
