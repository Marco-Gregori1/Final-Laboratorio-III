package ar.utn.frbb.tup.TrabajoFinal.model;

public class Producto implements Comparable <Producto>{

    private String id;
    private String marca;
    private String modelo;

    private double precioLista;
    private double precioContado;
    private boolean ventaOnline;
    private static final double descuentoOnline = 0.15;
    private boolean configurable;
    private String configuracion;

    public Producto(String id, String marca, String modelo, String descripcion, double precioLista) {
        this.id = id;
        this.precioContado = precioLista - (precioLista * descuentoOnline);
        this.marca = marca;
        this.modelo = modelo;
        this.precioLista = precioLista;
        if (precioLista <= 0){throw new IllegalArgumentException("El precio debe ser mayor a 0");}
        this.precioContado = precioLista - (precioLista * descuentoOnline);
        this.ventaOnline = false;
        this.configurable = false;
    }

    public Producto(String marca, int precioLista){
        this.id = "";
        this.marca = marca;
        this.modelo = "";
        this.precioLista = precioLista;
        if (precioLista <= 0){throw new IllegalArgumentException("El precio debe ser mayor a 0");}
        this.precioContado = precioLista - (precioLista * descuentoOnline);
        this.ventaOnline = false;
        this.configurable = false;
        this.configuracion = "";
    }

    public Producto(){}

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public int compareTo(Producto x) {
        return this.getMarca().compareTo(x.getMarca());

    }
    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", precioLista=" + precioLista +
                ", precioContado=" + precioContado +
                ", ventaOnline=" + ventaOnline +
                ", configurable=" + configurable +
                ", configuracion='" + configuracion + '\'' +
                '}';
    }
}
