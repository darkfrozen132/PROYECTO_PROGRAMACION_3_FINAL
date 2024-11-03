
package pe.edu.pucp.documento.transaccion.model;

import java.util.Date;
import pe.edu.pucp.cbancaria.model.CuentaBancaria;
import pe.edu.pucp.documento.pedido.model.Pedido;

public class Transaccion {
    private Integer idTransaccion;
    private Pedido pedido;
    private String codigo;
    private Date fecha_transaccion;
    private CuentaBancaria cb_emisor;
    private CuentaBancaria cb_receptor;

    public Transaccion(Integer idTransaccion, Pedido pedido, String codigo, Date fecha_transaccion, CuentaBancaria cb_emisor, CuentaBancaria cb_receptor) {
        this.idTransaccion = idTransaccion;
        this.pedido = pedido;
        this.codigo = codigo;
        this.fecha_transaccion = fecha_transaccion;
        this.cb_emisor = cb_emisor;
        this.cb_receptor = cb_receptor;
    }
    
    public Transaccion() {
        this.cb_emisor = null;
        this.cb_receptor = null;
        this.pedido = null;
        this.idTransaccion = null;
        this.pedido = null;
        this.codigo = null;
        this.fecha_transaccion = null;
        this.cb_emisor = null;
        this.cb_receptor = null;
    }

    /**
     * @return the idTransaccion
     */
    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * @param idTransaccion the idTransaccion to set
     */
    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
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
     * @return the fecha_transaccion
     */
    public Date getFecha_transaccion() {
        return fecha_transaccion;
    }

    /**
     * @param fecha_transaccion the fecha_transaccion to set
     */
    public void setFecha_transaccion(Date fecha_transaccion) {
        this.fecha_transaccion = fecha_transaccion;
    }

    /**
     * @return the cb_emisor
     */
    public CuentaBancaria getCb_emisor() {
        return cb_emisor;
    }

    /**
     * @param cb_emisor the cb_emisor to set
     */
    public void setCb_emisor(CuentaBancaria cb_emisor) {
        this.cb_emisor = cb_emisor;
    }

    /**
     * @return the cb_receptor
     */
    public CuentaBancaria getCb_receptor() {
        return cb_receptor;
    }

    /**
     * @param cb_receptor the cb_receptor to set
     */
    public void setCb_receptor(CuentaBancaria cb_receptor) {
        this.cb_receptor = cb_receptor;
    }
    
}
