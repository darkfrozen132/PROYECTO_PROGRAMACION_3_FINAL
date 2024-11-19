
package pe.edu.pucp.documento.entrega.model;

import pe.edu.pucp.documento.pedido.model.DetallePedido;
import pe.edu.pucp.inventario.model.Torre_Un_Paquete;

public class DetalleEntrega {
    private Entrega entrega;
    private DetallePedido detallePedido;
    private Torre_Un_Paquete torre;
    private String codigo;
    private Integer cantidad;

    public DetalleEntrega(Entrega entrega, DetallePedido detallePedido, Torre_Un_Paquete torre, String codigo, Integer cantidad) {
        this.entrega = entrega;
        this.detallePedido = detallePedido;
        this.torre = torre;
        this.codigo = codigo;
        this.cantidad = cantidad;
    }
    
    public DetalleEntrega() {
        this.entrega = new Entrega();
        this.detallePedido = new DetallePedido();
        this.torre = new Torre_Un_Paquete();
        this.codigo = null;
        this.cantidad = null;
    }

    /**
     * @return the entrega
     */
    public Entrega getEntrega() {
        return entrega;
    }

    /**
     * @param entrega the entrega to set
     */
    public void setEntrega(Entrega entrega) {
        this.entrega = entrega;
    }

    /**
     * @return the detallePedido
     */
    public DetallePedido getDetallePedido() {
        return detallePedido;
    }

    /**
     * @param detallePedido the detallePedido to set
     */
    public void setDetallePedido(DetallePedido detallePedido) {
        this.detallePedido = detallePedido;
    }

    /**
     * @return the torre
     */
    public Torre_Un_Paquete getTorre() {
        return torre;
    }

    /**
     * @param torre the torre to set
     */
    public void setTorre(Torre_Un_Paquete torre) {
        this.torre = torre;
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
    
}
