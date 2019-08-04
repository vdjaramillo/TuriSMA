package ontologia;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: AgenteReservas
* @author ontology bean generator
* @version 2019/08/2, 23:50:21
*/
public class AgenteReservas extends AID{ 

   /**
* Protege name: CambioDeUnaReserva
   */
   private String cambioDeUnaReserva;
   public void setCambioDeUnaReserva(String value) { 
    this.cambioDeUnaReserva=value;
   }
   public String getCambioDeUnaReserva() {
     return this.cambioDeUnaReserva;
   }

   /**
* Protege name: SeguimientoDeUnaReserva
   */
   private String seguimientoDeUnaReserva;
   public void setSeguimientoDeUnaReserva(String value) { 
    this.seguimientoDeUnaReserva=value;
   }
   public String getSeguimientoDeUnaReserva() {
     return this.seguimientoDeUnaReserva;
   }

}
