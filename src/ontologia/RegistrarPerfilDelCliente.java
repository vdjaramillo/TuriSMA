package ontologia;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: RegistrarPerfilDelCliente
* @author ontology bean generator
* @version 2019/08/2, 23:50:21
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
* Protege name: agenteCliente
   */
   private AgenteClientes agenteCliente;
   public void setAgenteCliente(AgenteClientes value) { 
    this.agenteCliente=value;
   }
   public AgenteClientes getAgenteCliente() {
     return this.agenteCliente;
   }

}
