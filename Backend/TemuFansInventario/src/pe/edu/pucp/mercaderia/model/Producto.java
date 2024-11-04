
package pe.edu.pucp.mercaderia.model;


public class Producto {
    private Integer idProducto;
    private String codigo;
    private String nombre;
    private Integer cantidad;
    private double precio;

    public Producto(Integer idProducto, String codigo, Integer cantidad, String nombre, double precio) {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public Producto() {
        this.idProducto = null;
        this.codigo = null;
        this.cantidad = null;
        this.nombre = null;
        this.precio = 0;
    }

 
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the peso to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * @return the idProducto
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    
}
