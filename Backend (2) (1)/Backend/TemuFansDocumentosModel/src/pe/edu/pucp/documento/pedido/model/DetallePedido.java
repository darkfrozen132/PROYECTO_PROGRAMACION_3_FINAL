
package pe.edu.pucp.documento.pedido.model;

import pe.edu.pucp.mercaderia.model.Producto;

public class DetallePedido {
    private Pedido pedido;
    private Producto paquete;
    private String codigo;
    private Integer cantidad;
    private double monto;
    private String descripcion;
    private Integer cantidad_por_entregar;

    public DetallePedido(Pedido pedido, Producto paquete, String codigo, Integer cantidad, double monto, String descripcion, Integer cantidad_por_entregar) {
        this.pedido = pedido;
        this.paquete = paquete;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.monto = monto;
        this.descripcion = descripcion;
        this.cantidad_por_entregar = cantidad_por_entregar;
    }
    
    public DetallePedido() {
        this.pedido = null;
        this.paquete = null;
        this.pedido = null;
        this.paquete = null;
        this.codigo = null;
        this.cantidad = null;
        this.monto = 0;
        this.descripcion = null;
        this.cantidad_por_entregar = null;
    }

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the paquete
     */
    public Producto getPaquete() {
        return paquete;
    }

    /**
     * @param paquete the paquete to set
     */
    public void setPaquete(Producto paquete) {
        this.paquete = paquete;
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
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the cantidad_por_entregar
     */
    public Integer getCantidad_por_entregar() {
        return cantidad_por_entregar;
    }

    /**
     * @param cantidad_por_entregar the cantidad_por_entregar to set
     */
    public void setCantidad_por_entregar(Integer cantidad_por_entregar) {
        this.cantidad_por_entregar = cantidad_por_entregar;
    }
    
}
