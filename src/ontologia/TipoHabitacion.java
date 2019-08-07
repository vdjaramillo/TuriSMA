package ontologia;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: TipoHabitacion
* @author ontology bean generator
* @version 2019/08/4, 14:41:11
*/
public class TipoHabitacion implements Concept {

	public TipoHabitacion() {}
	public TipoHabitacion(String tipo, int cantidad, float precioNoche) {
		setTipo(tipo);
		setCantidad(cantidad);
		setPrecioNoche(precioNoche);
	}
   /**
* Protege name: tipo
   */
   private String tipo;
   public void setTipo(String value) { 
    this.tipo=value;
   }
   public String getTipo() {
     return this.tipo;
   }

   /**
* Protege name: precioNoche
   */
   private float precioNoche;
   public void setPrecioNoche(float value) { 
    this.precioNoche=value;
   }
   public float getPrecioNoche() {
     return this.precioNoche;
   }

   /**
* Protege name: cantidad
   */
   private int cantidad;
   public void setCantidad(int value) { 
    this.cantidad=value;
   }
   public int getCantidad() {
     return this.cantidad;
   }

}
