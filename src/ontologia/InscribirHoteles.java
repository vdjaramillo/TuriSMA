package ontologia;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: InscribirHoteles
* @author ontology bean generator
* @version 2019/08/2, 23:50:21
*/
public class InscribirHoteles implements Predicate {

   /**
* Protege name: agenteSistema
   */
   private AgenteSistema agenteSistema;
   public void setAgenteSistema(AgenteSistema value) { 
    this.agenteSistema=value;
   }
   public AgenteSistema getAgenteSistema() {
     return this.agenteSistema;
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
* Protege name: agenteHotel
   */
   private AgenteHoteles agenteHotel;
   public void setAgenteHotel(AgenteHoteles value) { 
    this.agenteHotel=value;
   }
   public AgenteHoteles getAgenteHotel() {
     return this.agenteHotel;
   }

}
