
package pe.edu.pucp.inventario.model;


public class Almacen {
    private Integer idAlmacen;
    private String codigo_almacen;
    private String direccion;
    private Integer nro_torres;

    public Almacen(Integer idAlmacen, String codigo_almacen, String direccion, Integer nro_torres) {
        this.idAlmacen = idAlmacen;
        this.codigo_almacen = codigo_almacen;
        this.direccion = direccion;
        this.nro_torres = nro_torres;
    }
    
    public Almacen(){
        this.idAlmacen = null;
        this.codigo_almacen = null;
        this.direccion = null;
        this.nro_torres = null;
    }

    /**
     * @return the idAlmacen
     */
    public Integer getIdAlmacen() {
        return idAlmacen;
    }

    /**
     * @param idAlmacen the idAlmacen to set
     */
    public void setIdAlmacen(Integer idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    /**
     * @return the codigo_almacen
     */
    public String getCodigo_almacen() {
        return codigo_almacen;
    }

    /**
     * @param codigo_almacen the codigo_almacen to set
     */
    public void setCodigo_almacen(String codigo_almacen) {
        this.codigo_almacen = codigo_almacen;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the nro_torres
     */
    public Integer getNro_torres() {
        return nro_torres;
    }

    /**
     * @param nro_torres the nro_torres to set
     */
    public void setNro_torres(Integer nro_torres) {
        this.nro_torres = nro_torres;
    }
    
}
