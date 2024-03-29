// file: ontologia.java generated by ontology bean generator.  DO NOT EDIT, UNLESS YOU ARE REALLY SURE WHAT YOU ARE DOING!
package ontologia;

import jade.content.onto.*;
import jade.content.schema.*;
import jade.util.leap.HashMap;
import jade.content.lang.Codec;
import jade.core.CaseInsensitiveString;

/** file: ontologia.java
 * @author ontology bean generator
 * @version 2019/08/4, 14:41:11
 */
public class TuriSMAOntology extends jade.content.onto.Ontology  {
  //NAME
  public static final String ONTOLOGY_NAME = "turiSMA";
  // The singleton instance of this ontology
  private static ReflectiveIntrospector introspect = new ReflectiveIntrospector();
  private static Ontology theInstance = new TuriSMAOntology();
  public static Ontology getInstance() {
     return theInstance;
  }


   // VOCABULARY
    public static final String REGISTRARCARACTERISTICASDELHOTEL_HOTEL="hotel";
    public static final String REGISTRARCARACTERISTICASDELHOTEL="RegistrarCaracteristicasDelHotel";
    public static final String RESERVARHOTEL_RESERVA="reserva";
    public static final String RESERVARHOTEL="ReservarHotel";
    public static final String REGISTRARPERFILDELCLIENTE_CLIENTE="cliente";
    public static final String REGISTRARPERFILDELCLIENTE="RegistrarPerfilDelCliente";
    public static final String HOTELESPOTENCIALES_MENSAJE="mensaje";
    public static final String HOTELESPOTENCIALES="HotelesPotenciales";
    public static final String CONFIRMACIÓNCAMBIODERESERVA_MENSAJE="mensaje";
    public static final String CONFIRMACIÓNCAMBIODERESERVA="ConfirmaciónCambiodeReserva";
    public static final String CANCELACIONEXITOSA_MENSAJE="mensaje";
    public static final String CANCELACIONEXITOSA="CancelacionExitosa";
    public static final String ENTREGADEINFORMACION_MENSAJE="mensaje";
    public static final String ENTREGADEINFORMACION="EntregaDeInformacion";
    public static final String TIPOHABITACION_CANTIDAD="cantidad";
    public static final String TIPOHABITACION_PRECIONOCHE="precioNoche";
    public static final String TIPOHABITACION_TIPO="tipo";
    public static final String TIPOHABITACION="TipoHabitacion";
    public static final String RESERVA_HOTEL="hotel";
    public static final String RESERVA_NOMBREHABITACION="nombreHabitacion";
    public static final String RESERVA_CLIENTE="cliente";
    public static final String RESERVA="Reserva";
    public static final String HOTEL_TELEFONO="Telefono";
    public static final String HOTEL_CALIFICACION="Calificacion";
    public static final String HOTEL_NIVELDESEGURIDAD="NivelDeSeguridad";
    public static final String HOTEL_CAFETERIASYRESTAURANTES="CafeteriasyRestaurantes";
    public static final String HOTEL_HABITACIONES="Habitaciones";
    public static final String HOTEL_DIRECCION="Direccion";
    public static final String HOTEL_CERTIFICACIÓNDEIDIOMAS="CertificaciónDeIdiomas";
    public static final String HOTEL_NOMBREHOTEL="NombreHotel";
    public static final String HOTEL="Hotel";
    public static final String CLIENTE_PRESUPUESTO="Presupuesto";
    public static final String CLIENTE_PREFERENCIAS="Preferencias";
    public static final String CLIENTE_CEDULA="Cedula";
    public static final String CLIENTE_NOMBRE="Nombre";
    public static final String CLIENTE="Cliente";

  /**
   * Constructor
  */
  private TuriSMAOntology(){ 
    super(ONTOLOGY_NAME, BasicOntology.getInstance());
    try { 

    // adding Concept(s)
    ConceptSchema clienteSchema = new ConceptSchema(CLIENTE);
    add(clienteSchema, ontologia.Cliente.class);
    ConceptSchema hotelSchema = new ConceptSchema(HOTEL);
    add(hotelSchema, ontologia.Hotel.class);
    ConceptSchema reservaSchema = new ConceptSchema(RESERVA);
    add(reservaSchema, ontologia.Reserva.class);
    ConceptSchema tipoHabitacionSchema = new ConceptSchema(TIPOHABITACION);
    add(tipoHabitacionSchema, ontologia.TipoHabitacion.class);

    // adding AgentAction(s)
    AgentActionSchema cancelacionExitosaSchema = new AgentActionSchema(CANCELACIONEXITOSA);
    add(cancelacionExitosaSchema, ontologia.CancelacionExitosa.class);
    AgentActionSchema confirmaciónCambiodeReservaSchema = new AgentActionSchema(CONFIRMACIÓNCAMBIODERESERVA);
    add(confirmaciónCambiodeReservaSchema, ontologia.ConfirmaciónCambiodeReserva.class);
    // adding AID(s)

    // adding Predicate(s)
    PredicateSchema registrarPerfilDelClienteSchema = new PredicateSchema(REGISTRARPERFILDELCLIENTE);
    add(registrarPerfilDelClienteSchema, ontologia.RegistrarPerfilDelCliente.class);
    PredicateSchema reservarHotelSchema = new PredicateSchema(RESERVARHOTEL);
    add(reservarHotelSchema, ontologia.ReservarHotel.class);
    PredicateSchema registrarCaracteristicasDelHotelSchema = new PredicateSchema(REGISTRARCARACTERISTICASDELHOTEL);
    add(registrarCaracteristicasDelHotelSchema, ontologia.RegistrarCaracteristicasDelHotel.class);


    // adding fields
    clienteSchema.add(CLIENTE_NOMBRE, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    clienteSchema.add(CLIENTE_CEDULA, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    clienteSchema.add(CLIENTE_PREFERENCIAS, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    clienteSchema.add(CLIENTE_PRESUPUESTO, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    hotelSchema.add(HOTEL_NOMBREHOTEL, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    hotelSchema.add(HOTEL_CERTIFICACIÓNDEIDIOMAS, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.OPTIONAL);
    hotelSchema.add(HOTEL_DIRECCION, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    hotelSchema.add(HOTEL_HABITACIONES, tipoHabitacionSchema, 1, ObjectSchema.UNLIMITED);
    hotelSchema.add(HOTEL_CAFETERIASYRESTAURANTES, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.OPTIONAL);
    hotelSchema.add(HOTEL_NIVELDESEGURIDAD, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    hotelSchema.add(HOTEL_CALIFICACION, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    hotelSchema.add(HOTEL_TELEFONO, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    reservaSchema.add(RESERVA_CLIENTE, clienteSchema, ObjectSchema.OPTIONAL);
    reservaSchema.add(RESERVA_NOMBREHABITACION, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    reservaSchema.add(RESERVA_HOTEL, hotelSchema, ObjectSchema.OPTIONAL);
    tipoHabitacionSchema.add(TIPOHABITACION_TIPO, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    tipoHabitacionSchema.add(TIPOHABITACION_PRECIONOCHE, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    tipoHabitacionSchema.add(TIPOHABITACION_CANTIDAD, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    cancelacionExitosaSchema.add(CANCELACIONEXITOSA_MENSAJE, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    confirmaciónCambiodeReservaSchema.add(CONFIRMACIÓNCAMBIODERESERVA_MENSAJE, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    registrarPerfilDelClienteSchema.add(REGISTRARPERFILDELCLIENTE_CLIENTE, clienteSchema, ObjectSchema.OPTIONAL);
    reservarHotelSchema.add(RESERVARHOTEL_RESERVA, reservaSchema, ObjectSchema.OPTIONAL);
    registrarCaracteristicasDelHotelSchema.add(REGISTRARCARACTERISTICASDELHOTEL_HOTEL, hotelSchema, ObjectSchema.OPTIONAL);

    // adding name mappings

    // adding inheritance

   }catch (java.lang.Exception e) {e.printStackTrace();}
  }
  }
