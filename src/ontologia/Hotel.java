package ontologia;


import jade.content.*;
import java.util.LinkedList;

import general.DatosDB;

/**
* Protege name: Hotel
* @author ontology bean generator
* @version 2019/08/2, 23:50:21
*/
public class Hotel implements Concept {
	public Hotel() {}
	public Hotel(String nh, boolean ci, String dir, boolean cyr, int seg, int calif, int tel, TipoHabitacion[] th) {
		setNombreHotel(nh);
		setCertificaciónDeIdiomas(ci);
		setDireccion(dir);
		setCafeteriasyRestaurantes(cyr);
		setNivelDeSeguridad(seg);
		setTelefono(tel);
		setCalificacion(calif);
		setHabitaciones(th);
	}
	public static LinkedList<Hotel> getHoteles(float pres) {
		boolean prueb=false;
		LinkedList<Hotel> htlr = new LinkedList<>();
		for(int i = 0; i<DatosDB.hoteles.size();i++) {
			for(int j =0; j<DatosDB.hoteles.get(i).getHabitaciones().length;j++) {
				if(DatosDB.hoteles.get(i).getHabitaciones()[j].getPrecioNoche()<=pres) {
					prueb=true;
				}
			}
			if(prueb) {
				htlr.add(DatosDB.hoteles.get(i));
			}
			prueb = false;
		}
		return htlr;
	}
   /**
* Protege name: NombreHotel
   */
   private String nombreHotel;
   public void setNombreHotel(String value) { 
    this.nombreHotel=value;
   }
   public String getNombreHotel() {
     return this.nombreHotel;
   }

   /**
* Protege name: CertificaciónDeIdiomas
   */
   private boolean certificaciónDeIdiomas;
   public void setCertificaciónDeIdiomas(boolean value) { 
    this.certificaciónDeIdiomas=value;
   }
   public boolean getCertificaciónDeIdiomas() {
     return this.certificaciónDeIdiomas;
   }

   /**
* Protege name: Direccion
   */
   private String direccion;
   public void setDireccion(String value) { 
    this.direccion=value;
   }
   public String getDireccion() {
     return this.direccion;
   }
   /**
* Protege name: CafeteriasyRestaurantes
   */
   private boolean cafeteriasyRestaurantes;
   public void setCafeteriasyRestaurantes(boolean value) { 
    this.cafeteriasyRestaurantes=value;
   }
   public boolean getCafeteriasyRestaurantes() {
     return this.cafeteriasyRestaurantes;
   }

   /**
* Protege name: NivelDeSeguridad
   */
   private int nivelDeSeguridad;
   public void setNivelDeSeguridad(int value) { 
    this.nivelDeSeguridad=value;
   }
   public int getNivelDeSeguridad() {
     return this.nivelDeSeguridad;
   }

   /**
* Protege name: Calificacion
   */
   private int calificacion;
   public void setCalificacion(int value) { 
    this.calificacion=value;
   }
   public int getCalificacion() {
     return this.calificacion;
   }

   /**
* Protege name: Telefono
   */
   private int telefono;
   public void setTelefono(int value) { 
    this.telefono=value;
   }
   public int getTelefono() {
     return this.telefono;
   }
   
   private TipoHabitacion[] habitaciones;
   public TipoHabitacion[] getHabitaciones() {
	   return habitaciones;
   }
   public void setHabitaciones(TipoHabitacion[] th) {
	   habitaciones=th;
   }
}