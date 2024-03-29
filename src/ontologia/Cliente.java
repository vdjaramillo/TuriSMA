package ontologia;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: Cliente
* @author ontology bean generator
* @version 2019/08/4, 14:41:11
*/
public class Cliente implements Concept {

	public Cliente() {}
	public Cliente(String n, int cc, float ppto, int pfr) {
		setNombre(n);
		setCedula(cc);
		setPresupuesto(ppto);
		setPreferencias(pfr);
	}
   /**
* Protege name: Nombre
   */
   private String nombre;
   public void setNombre(String value) { 
    this.nombre=value;
   }
   public String getNombre() {
     return this.nombre;
   }

   /**
* Protege name: Cedula
   */
   private int cedula;
   public void setCedula(int value) { 
    this.cedula=value;
   }
   public int getCedula() {
     return this.cedula;
   }

   /**
* Protege name: Preferencias
   */
   private int preferencias;
   public void setPreferencias(int value) { 
    this.preferencias=value;
   }
   public int getPreferencias() {
     return this.preferencias;
   }

   /**
* Protege name: Presupuesto
   */
   private float presupuesto;
   public void setPresupuesto(float value) { 
    this.presupuesto=value;
   }
   public float getPresupuesto() {
     return this.presupuesto;
   }

}
