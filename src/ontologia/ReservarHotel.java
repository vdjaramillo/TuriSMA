package ontologia;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: ReservarHotel
* @author ontology bean generator
* @version 2019/08/4, 14:41:11
*/
public class ReservarHotel implements Predicate {

   /**
* Protege name: reserva
   */
   private Reserva reserva;
   public void setReserva(Reserva value) { 
    this.reserva=value;
   }
   public Reserva getReserva() {
     return this.reserva;
   }

}
