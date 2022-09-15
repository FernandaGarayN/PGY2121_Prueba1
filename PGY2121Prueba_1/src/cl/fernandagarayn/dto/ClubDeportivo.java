package cl.fernandagarayn.dto;

/**
 *
 * @author Ferna
 */
public class ClubDeportivo {
    private String codigo;
    private String nombre;
    private String nombreFundador;
    private int anioFundacion;
    private String paisOrigen;
    private String lema;
    private int valorSuscripcion;
    private String colores;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLema() {
        return lema;
    }

    public void setLema(String lema) {
        this.lema = lema;
    }

    public int getValorSuscripcion() {
        return valorSuscripcion;
    }

    public void setValorSuscripcion(int valorSuscripcion) {
        this.valorSuscripcion = valorSuscripcion;
    }

    public String getColores() {
        return colores;
    }

    public void setColores(String colores) {
        this.colores = colores;
    }

    public String getNombreFundador() {
        return nombreFundador;
    }

    public void setNombreFundador(String nombreFundador) {
        this.nombreFundador = nombreFundador;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    
    public String paraSuscripcion() {
        return codigo + " $" + valorSuscripcion;
    }

    @Override
    public String toString() {
        return "ClubDeportivo{" + "codigo=" + codigo + ", nombre=" + nombre + ", nombreFundador=" + nombreFundador + ", anioFundacion=" + anioFundacion + ", paisOrigen=" + paisOrigen + ", lema=" + lema + ", valorSuscripcion=" + valorSuscripcion + ", colores=" + colores + '}';
    }
}
