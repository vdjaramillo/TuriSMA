package ontologia;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: AgenteHoteles
* @author ontology bean generator
* @version 2019/08/2, 23:50:21
*/
public class AgenteHoteles extends AID{ 

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
* Protege name: CaracteristicaDelHotel
   */
   private Hotel caracteristicaDelHotel;
   public void setCaracteristicaDelHotel(Hotel value) { 
    this.caracteristicaDelHotel=value;
   }
   public Hotel getCaracteristicaDelHotel() {
     return this.caracteristicaDelHotel;
   }

}
