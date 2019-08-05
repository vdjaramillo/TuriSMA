package ontologia;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: ReservarHotel
* @author ontology bean generator
* @version 2019/08/2, 23:50:21
*/
public class ReservarHotel implements Predicate {

   /**
* Protege name: cliente
   */
   private Reserva reserva;
   public void setReserva(Reserva value) { 
    this.reserva=value;
   }
   public Reserva getReserva() {
     return this.reserva;
   }

}
