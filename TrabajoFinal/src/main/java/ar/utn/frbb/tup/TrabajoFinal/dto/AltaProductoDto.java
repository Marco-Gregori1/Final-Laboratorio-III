package ar.utn.frbb.tup.TrabajoFinal.dto;

public class AltaProductoDto {

    private String id;
    private String marca;
    private String modelo;

    private double precioLista;
    private double precioContado;
    private boolean ventaOnline;
    private static final double descuentoOnline = 0.15;
    private boolean configurable;
    private String configuracion;
// marca modelo precioLista precioContado ventaOnline configurable

    public AltaProductoDto(String marca, String modelo, double precioLista) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioLista = precioLista;
        this.precioContado = precioLista - (precioLista * descuentoOnline);
        this.ventaOnline = false;
        this.configurable = false;
    }
/*
this.precioContado = precioLista - (precioLista * descuentoOnline);
    public AltaProductoDto(String marca, String modelo, double precioLista, double precioContado, boolean ventaOnline, boolean configurable, String configuracion) {
        this.marca = marca;
        this.modelo = modelo;
        this.precioLista = precioLista;
        this.precioContado = precioContado;
        this.ventaOnline = ventaOnline;
        this.configurable = configurable;
        this.configuracion = configuracion;
    }
*/
    public String getId() {
        return id;
    }

    public void setId(String idProducto) {
        this.id = idProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(double precioLista) {
        this.precioLista = precioLista;
    }

    public double getPrecioContado() {
        return precioContado;
    }

    public void setPrecioContado(double precioContado) {
        this.precioContado = precioContado;
    }

    public boolean isVentaOnline() {
        return ventaOnline;
    }

    public void setVentaOnline(boolean ventaOnline) {
        this.ventaOnline = ventaOnline;
    }

    public boolean isConfigurable() {
        return configurable;
    }

    public void setConfigurable(boolean configurable) {
        this.configurable = configurable;
    }

    public String getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(String configuracion) {
        this.configuracion = configuracion;
    }
}
