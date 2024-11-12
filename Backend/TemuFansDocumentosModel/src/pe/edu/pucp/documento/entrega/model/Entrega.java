
package pe.edu.pucp.documento.entrega.model;

import java.util.Date;
import pe.edu.pucp.documento.pedido.model.Pedido;

public class Entrega {
    private Pedido pedido;
    private Integer nro_entrega_pedido;
    private String codigo;
    private Date fecha_entrega;
    private String direccion;

    public Entrega(Pedido pedido, Integer nro_entrega_pedido, String codigo, Date fecha_entrega, String direccion) {
        this.pedido = pedido;
        this.nro_entrega_pedido = nro_entrega_pedido;
        this.codigo = codigo;
        this.fecha_entrega = fecha_entrega;
        this.direccion = direccion;
    }
    
    public Entrega() {
        this.pedido = null;
        this.pedido = null;
        this.nro_entrega_pedido = null;
        this.codigo = null;
        this.fecha_entrega = null;
        this.direccion = null;
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
     * @return the nro_entrega_pedido
     */
    public Integer getNro_entrega_pedido() {
        return nro_entrega_pedido;
    }

    /**
     * @param nro_entrega_pedido the nro_entrega_pedido to set
     */
    public void setNro_entrega_pedido(Integer nro_entrega_pedido) {
        this.nro_entrega_pedido = nro_entrega_pedido;
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
     * @return the fecha_entrega
     */
    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    /**
     * @param fecha_entrega the fecha_entrega to set
     */
    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
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
    
}
