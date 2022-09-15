package cl.fernandagarayn.dto;

import java.util.Date;

/**
 *
 * @author Ferna
 */
public class Suscripcion {
    private int numero;
    private Usuario usuario;
    private Date fechaInicio;
    private int abonoTotal;
    private String equipos;
    private int correlativoVenta;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if(numero > -1){
            this.numero = numero;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getAbonoTotal() {
        return abonoTotal;
    }

    public void setAbonoTotal(int abonoTotal) {
        this.abonoTotal = abonoTotal;
    }

    public String getEquipos() {
        return equipos;
    }

    public void setEquipos(String equipos) {
        this.equipos = equipos;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getCorrelativoVenta() {
        return correlativoVenta;
    }

    public void setCorrelativoVenta(int correlativoVenta) {
        this.correlativoVenta = correlativoVenta;
    }
    
    public void agregarClubDeportivo(ClubDeportivo club){
        if(this.equipos == null){
            this.equipos = "";
        }
        if(!this.equipos.equals("")){
            this.equipos += "; ";
        }
        this.equipos += club.paraSuscripcion();
        this.abonoTotal += club.getValorSuscripcion();
    }

    @Override
    public String toString() {
        return "Suscripcion{" + "numero=" + numero + ", usuario=" + usuario.paraSuscripcion() + ", fechaInicio=" + fechaInicio + ", abonoTotal=" + abonoTotal + ", equipos=" + equipos + ", correlativoVenta=" + correlativoVenta + '}';
    }
}
