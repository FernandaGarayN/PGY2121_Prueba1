package cl.fernandagarayn;

import cl.fernandagarayn.dto.ClubDeportivo;
import cl.fernandagarayn.dto.Suscripcion;
import cl.fernandagarayn.dto.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ferna
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario usuario1 = nuevoUsuario(1000, "David Cogiolle", 16276866, '2', "1990/12/01", "56123456", "dcog", "david.cogiolle@gmail.com", "Afds22231");
        Usuario usuario2 = nuevoUsuario(1001, "Gerr Adere", 16796705, '1', "1980/06/03", "56987654", "ggft", "gerr.adere@live.cl", "G1ovanniGg34");
        Usuario usuario3 = nuevoUsuario(1002, "Sergio Villanueva", 1, '9', "1970/05/20", "56887755", "scodiio", "sergio.villanueva@gmail.com", "5534Gato33");
        
        System.out.println(usuario1);
        System.out.println(usuario2);
        System.out.println(usuario3);
        
        int correlativoEquipos = 10;
        String deporte = "Handball";
        ClubDeportivo club1 = nuevoClub(correlativoEquipos++, deporte, "Arsenal de Coquimbo", "Carlos Martinez", 1925, "Chile", "Cañones a los puertos", 10050, "Amarillo, Rojo");
        ClubDeportivo club2 = nuevoClub(correlativoEquipos++, deporte, "Manquehue City", "Sandra Sanchez", 1962, "Chile", "Vivir y Fuerza", 15100, "Celeste, Blanco");
        ClubDeportivo club3 = nuevoClub(correlativoEquipos++, deporte, "Los Cóndores Unidos", "Miguel Garay", 1959, "Chile", "Desde lo alto al sol", 13200, "Amarillo, Naranjo");
        
        
        System.out.println(club1);
        System.out.println(club2);
        System.out.println(club3);
        
        int correlativoVenta = 1;
        int folio = 10000;
        Suscripcion suscripcion1 = nuevaSuscripcion(folio, usuario1, "2020/12/10", correlativoVenta++);
        suscripcion1.agregarClubDeportivo(club1);
        suscripcion1.agregarClubDeportivo(club2);
        
        folio += 10;
        Suscripcion suscripcion2 = nuevaSuscripcion(folio, usuario2, "2020/10/10", correlativoVenta++);
        suscripcion2.agregarClubDeportivo(club3);
        
        folio += 10;
        Suscripcion suscripcion3 = nuevaSuscripcion(folio, usuario3, "2021/05/23", correlativoVenta++);
        suscripcion3.agregarClubDeportivo(club3);
        suscripcion3.agregarClubDeportivo(club2);
        
        
       
    }
    
    public static Usuario nuevoUsuario(int ID, String nombreCompleto, int rut, char dv, String fechaNacimiento, String telefono, String nombreUsuario, String email, String contrasena){
        Usuario usuario = new Usuario();
        usuario.setID(ID);
        usuario.setNombreCompleto(nombreCompleto);
        usuario.validarRut(rut, dv);
        usuario.setFechaNacimiento(validarFechaNacimiento(fechaNacimiento));
        usuario.setTelefono(validarTelefono(telefono));
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
    
    public static Suscripcion nuevaSuscripcion(int numero, Usuario usuario, String fechaInicio, int correlativo){
        Suscripcion suscripcion = new Suscripcion();
        suscripcion.setNumero(numero);
        suscripcion.setUsuario(usuario);
        suscripcion.setFechaInicio(validarFecha(fechaInicio));
        suscripcion.setCorrelativoVenta(correlativo);
        return suscripcion;
    }
    
    private static Date validarFecha(String fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            return sdf.parse(fecha);
        } catch (ParseException ex) {
            System.out.println("Fecha no valida: " + fecha); 
            return null;
        }
    }
    
    private static Date validarFechaNacimiento(String fecha){
        Date fechaNacimiento = validarFecha(fecha);
        if(fechaNacimiento != null){
            Date actual = new Date();
            int anioNacimiento = fechaNacimiento.getYear();
            int anioActual = actual.getYear();
            if(anioActual - anioNacimiento > 17) {
                return fechaNacimiento;
            }
        }
        System.out.println("Fecha de nacimiento no valido: " + fecha); 
        return null;
    }

    private static String validarNombreUsuario(String nombreUsuario) {
        if(nombreUsuario != null && nombreUsuario.length() > 3){
            return nombreUsuario;
        }
        System.out.println("Nombre de usuario no valida: " + nombreUsuario); 
        return null;
    }

    private static String validarEmail(String email) {
        if(email != null && email.indexOf("@") > 0
                && (email.endsWith(".com") || email.endsWith(".cl"))){
            return email;
        }
        System.out.println("Email no valido: " + email); 
        return null;
    }

    private static String validarContrasena(String contrasena) {
        if(contrasena != null && contrasena.length() > 5){
            return contrasena;
        }
        System.out.println("Constrasena no valida: " + contrasena);  
        return null;
    }

    private static int validarTelefono(String telefono) {
        if(telefono != null && telefono.length() > 7 && telefono.startsWith("56")){
            return Integer.parseInt(telefono);
        }
        System.out.println("Telefono no valido: " + telefono);       
        return 0;
    }
}
