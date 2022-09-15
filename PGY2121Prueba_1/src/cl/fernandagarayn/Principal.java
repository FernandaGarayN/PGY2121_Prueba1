package cl.fernandagarayn;

import cl.fernandagarayn.dto.ClubDeportivo;
import cl.fernandagarayn.dto.Suscripcion;
import cl.fernandagarayn.dto.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ferna
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario usuario1 = nuevoUsuario(1000, "David Cogiolle", 0, 'K', "1990/12/01", 123456789, "dcog", "david.cogiolle@gmail.com", "Afds22231");
        Usuario usuario2 = nuevoUsuario(1001, "Gerr Adere", 0, 'K', "1980/06/03", 987654321, "ggft", "gerr.adere@live.cl", "G1ovanniGg34");
        Usuario usuario3 = nuevoUsuario(1002, "Sergio Villanueva", 0, 'K', "1970/05/20", 887755443, "scodiio", "sergio.villanueva@gmail.com", "5534Gato33");
        
        int correlativoEquipos = 10;
        String deporte = "Handball";
        ClubDeportivo club1 = nuevoClub(correlativoEquipos++, deporte, "Arsenal de Coquimbo", "Carlos Martinez", 1925, "Chile", "Cañones a los puertos", 10050, "Amarillo, Rojo");
        ClubDeportivo club2 = nuevoClub(correlativoEquipos++, deporte, "Manquehue City", "Sandra Sanchez", 1962, "Chile", "Vivir y Fuerza", 15100, "Celeste, Blanco");
        ClubDeportivo club3 = nuevoClub(correlativoEquipos++, deporte, "Los Cóndores Unidos", "Miguel Garay", 1959, "Chile", "Desde lo alto al sol", 13200, "Amarillo, Naranjo");
        
        int correlativoVenta = 1;
        
        Suscripcion suscripcion1 = nuevaSuscripcion(1010, usuario1, new Date(), correlativoVenta++);
        suscripcion1.agregarClubDeportivo(club1);
        suscripcion1.agregarClubDeportivo(club2);
        
        Suscripcion suscripcion2 = nuevaSuscripcion(1020, usuario2, new Date(), correlativoVenta++);
        suscripcion2.agregarClubDeportivo(club3);
        
        Suscripcion suscripcion3 = nuevaSuscripcion(1030, usuario3, new Date(), correlativoVenta++);
        suscripcion3.agregarClubDeportivo(club3);
        suscripcion3.agregarClubDeportivo(club2);
       
    }
    
    public static Usuario nuevoUsuario(int ID, String nombreCompleto, int rut, char dv, String fechaNacimiento, int telefono, String nombreUsuario, String email, String contrasena){
        Usuario usuario = new Usuario();
        usuario.setID(ID);
        usuario.setNombreCompleto(nombreCompleto);
        usuario.validarRut(rut, dv);
        usuario.setFechaNacimiento(validarFecha(fechaNacimiento));
        usuario.setTelefono(telefono);
        usuario.setNombreUsuario(validarNombreUsuario(nombreUsuario));
        usuario.setEmail(validarEmail(email));
        usuario.setContrasena(validarContrasena(contrasena));
        return usuario;
    }
    
    public static ClubDeportivo nuevoClub(int correlativo, String deporte, String nombre, String nombreFundador, int anioFundacion, String paisOrigen, String lema, int valorSubscripcion, String colores){
        ClubDeportivo club = new ClubDeportivo();
        String codigo = nombre.substring(0, 2).toUpperCase() + deporte.substring(0, 1) + correlativo;
        club.setCodigo(codigo);
        club.setNombre(nombre);
        club.setNombreFundador(nombreFundador);
        club.setAnioFundacion(anioFundacion);
        club.setPaisOrigen(paisOrigen);
        club.setLema(lema);
        club.setValorSuscripcion(valorSubscripcion);
        club.setColores(colores);
        return club;
    }
    
    public static Suscripcion nuevaSuscripcion(int numero, Usuario usuario, Date fechaInicio, int correlativo){
        Suscripcion suscripcion = new Suscripcion();
        suscripcion.setNumero(numero);
        suscripcion.setUsuario(usuario);
        suscripcion.setFechaInicio(fechaInicio);
        suscripcion.setCorrelativoVenta(correlativo);
        return suscripcion;
    }
    
    private static Date validarFecha(String fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date fechaNacimiento = sdf.parse(fecha);
            Date actual = new Date();
            int anioNacimiento = fechaNacimiento.getYear();
            int anioActual = actual.getYear();
            if(anioActual - anioNacimiento > 17) {
                return fechaNacimiento;
            }
            return null;
        } catch (ParseException ex) {
            return null;
        }
    }

    private static String validarNombreUsuario(String nombreUsuario) {
        if(nombreUsuario != null && nombreUsuario.length() > 4){
            return nombreUsuario;
        }
        return null;
    }

    private static String validarEmail(String email) {
        if(email != null && email.indexOf("@") > 0
                && (email.endsWith(".com") || email.endsWith(".cl"))){
            return email;
        }
        return null;
    }

    private static String validarContrasena(String contrasena) {
        if(contrasena != null && contrasena.length() > 5){
            return contrasena;
        }
        return null;
    }
}
