
package pe.edu.pucp.inventario.model;

import pe.edu.pucp.mercaderia.model.Producto;

public class Torre_Un_Paquete {
    private Integer idTorre_Un_Paquete;
    private Integer nro_torre;
    private Producto producto;
    private String codigo;
    private Integer cantidad_paquete;
    private Boolean estado;
    private Almacen almacen;
    private Integer cantidad_limite;

    public Torre_Un_Paquete(Integer idTorre_Un_Paquete,Integer nro_torre, Producto producto, String codigo, Integer cantidad_paquete, Boolean estado, Almacen almacen) {
        this.idTorre_Un_Paquete = idTorre_Un_Paquete;
        this.nro_torre = nro_torre;
        this.producto = producto;
        this.codigo = codigo;
        this.cantidad_paquete = cantidad_paquete;
        this.estado = estado;
        this.almacen = almacen;
    }
    
    public Torre_Un_Paquete() {
        this.idTorre_Un_Paquete = null;
        this.codigo = null;
        this.cantidad_paquete = null;
        this.estado = null;
        this.nro_torre = null;
        this.producto = new Producto();
        this.almacen = new Almacen();
        this.cantidad_limite = null;
    }
    
    public Torre_Un_Paquete(Integer idProducto) {
        this.idTorre_Un_Paquete = null;
        this.codigo = null;
        this.cantidad_paquete = null;
        this.estado = null;
        this.nro_torre = 0;
        this.producto = new Producto(idProducto);
        this.almacen = new Almacen();
        this.cantidad_limite = null;
    }

    /**
     * @return the idTorre_Un_Paquete
     */
    public Integer getIdTorre_Un_Paquete() {
        return idTorre_Un_Paquete;
    }

    /**
     * @param idTorre_Un_Paquete the idTorre_Un_Paquete to set
     */
    public void setIdTorre_Un_Paquete(Integer idTorre_Un_Paquete) {
        this.idTorre_Un_Paquete = idTorre_Un_Paquete;
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
     * @return the cantidad_paquete
     */
    public Integer getCantidad_paquete() {
        return cantidad_paquete;
    }

    /**
     * @param cantidad_paquete the cantidad_paquete to set
     */
    public void setCantidad_paquete(Integer cantidad_paquete) {
        this.cantidad_paquete = cantidad_paquete;
    }

    /**
     * @return the estado
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the nro_torre
     */
    public Integer getNro_torre() {
        return nro_torre;
    }

    /**
     * @param nro_torre the nro_torre to set
     */
    public void setNro_torre(Integer nro_torre) {
        this.nro_torre = nro_torre;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the almacen
     */
    public Almacen getAlmacen() {
        return almacen;
    }

    /**
     * @param almacen the almacen to set
     */
    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    /**
     * @return the cantidad_limite
     */
    public Integer getCantidad_limite() {
        return cantidad_limite;
    }

    /**
     * @param cantidad_limite the cantidad_limite to set
     */
    public void setCantidad_limite(Integer cantidad_limite) {
        this.cantidad_limite = cantidad_limite;
    }
    
}
