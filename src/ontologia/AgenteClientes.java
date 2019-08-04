package ontologia;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: AgenteClientes
* @author ontology bean generator
* @version 2019/08/2, 23:50:21
*/
public class AgenteClientes extends AID{ 

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
