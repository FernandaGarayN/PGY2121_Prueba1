package cl.fernandagarayn.dto;

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
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        if(telefono > -1){
            this.telefono = telefono;
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
    
}
