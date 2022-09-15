package cl.fernandagarayn.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ferna
 */
public class Usuario {
    private int ID;
    private String nombreCompleto;
    private int rut;
    private char dv;
    private Date fechaNacimiento;
    private int telefono;
    private String nombreUsuario;
    private String email;
    private String contrasena;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        if(ID > -1) {
            this.ID = ID;
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = validarNombreUsuario(nombreUsuario);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = validarEmail(email);
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = validarContrasena(contrasena);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = validarFechaNacimiento(fechaNacimiento);
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        int tel = validarTelefono(telefono);
        if(tel > -1){
            this.telefono = tel;
        }
    }

    public void validarRut(int rut, char dv) {
        if(rut > -1) {
            boolean validacion = false;
            int m = 0, s = 1;
            for (; rut != 0; rut /= 10) {
                s = (s + rut % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

            if (validacion) {
                setRut(rut);
                setDv(dv);
            } else {  
                System.out.println("Rut no valido: " + rut + "-" + dv);
            }
        } else {
            System.out.println("Rut no valido: " + rut + "-" + dv);
        }
    }

    @Override
    public String toString() {
        return "Usuario{" + "ID=" + ID + ", nombreCompleto=" + nombreCompleto + ", rut=" + rut + ", dv=" + dv + ", fechaNacimiento=" + fechaNacimiento + ", telefono=" + telefono + ", nombreUsuario=" + nombreUsuario + ", email=" + email + ", contrasena=" + contrasena + '}';
    }

    String paraSuscripcion() {
        return getNombreUsuario() + ": " +getNombreCompleto();
    }
    
    private Date validarFechaNacimiento(String fecha){
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
    
    private Date validarFecha(String fecha){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            return sdf.parse(fecha);
        } catch (ParseException ex) {
            System.out.println("Fecha no valida: " + fecha); 
            return null;
        }
    }

    private String validarNombreUsuario(String nombreUsuario) {
        if(nombreUsuario != null && nombreUsuario.length() > 3){
            return nombreUsuario;
        }
        System.out.println("Nombre de usuario no valida: " + nombreUsuario); 
        return null;
    }

    private int validarTelefono(String telefono) {
        if(telefono != null && telefono.length() > 7 && telefono.startsWith("56")){
            return Integer.parseInt(telefono);
        }
        System.out.println("Telefono no valido: " + telefono);       
        return 0;
    }

    private String validarContrasena(String contrasena) {
        if(contrasena != null && contrasena.length() > 5){
            return contrasena;
        }
        System.out.println("Constrasena no valida: " + contrasena);  
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
}
