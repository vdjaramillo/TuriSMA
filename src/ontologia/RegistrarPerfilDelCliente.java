package ontologia;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: RegistrarPerfilDelCliente
* @author ontology bean generator
* @version 2019/08/4, 14:41:11
*/
public class RegistrarPerfilDelCliente implements Predicate {

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

}
