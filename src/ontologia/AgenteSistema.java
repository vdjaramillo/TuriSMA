package ontologia;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: AgenteSistema
* @author ontology bean generator
* @version 2019/08/2, 23:50:21
*/
public class AgenteSistema extends AID{ 

   /**
* Protege name: InformacionDelHotel
   */
   private Hotel informacionDelHotel;
   public void setInformacionDelHotel(Hotel value) { 
    this.informacionDelHotel=value;
   }
   public Hotel getInformacionDelHotel() {
     return this.informacionDelHotel;
   }

   /**
* Protege name: InformacionDelCliente
   */
   private Cliente informacionDelCliente;
   public void setInformacionDelCliente(Cliente value) { 
    this.informacionDelCliente=value;
   }
   public Cliente getInformacionDelCliente() {
     return this.informacionDelCliente;
   }

}
