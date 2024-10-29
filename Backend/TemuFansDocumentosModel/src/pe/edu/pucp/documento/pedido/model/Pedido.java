
package pe.edu.pucp.documento.pedido.model;

import java.util.Date;
import pe.edu.pucp.usuario.model.Cliente;
import pe.edu.pucp.usuario.model.Empleado;
import pe.edu.pucp.usuario.model.Usuario;
import pe.edu.pucp.usuario.model.Proveedor;

public class Pedido {
    private Integer idPedido;
    private Usuario persona; //puede ser Cliente o Proveedor
    private Empleado empleado; //responsable de registro
    private Tipo_Pedido tipo_pedido;
    private String codigo;
    private Estado_Pedido estado_pedido;
    private Integer nro_entregas_realizadas;
    private double subtotal;
    private double impuestos;
    private double total;
    private Date fecha_creacion;
    private Date fecha_pago;
    private Date fecha_vencimiento;
    private Date fecha_cancelacion;

    public Pedido(Integer idPedido, Usuario persona, Empleado empleado, Tipo_Pedido tipo_pedido, String codigo, Integer nro_entregas_realizadas, double subtotal, double impuestos, double total, Date fecha_creacion, Date fecha_pago, Date fecha_vencimiento, Date fecha_cancelacion) {
        this.idPedido = idPedido;
        this.tipo_pedido = tipo_pedido;
        if(this.tipo_pedido == Tipo_Pedido.COMPRA){
            this.persona = new Proveedor();
        }else{
            this.persona = new Cliente();
        }
        this.persona = persona;
        this.empleado = empleado;
        this.codigo = codigo;
        this.nro_entregas_realizadas = nro_entregas_realizadas;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
        this.total = total;
        this.fecha_creacion = fecha_creacion;
        this.fecha_pago = fecha_pago;
        this.fecha_vencimiento = fecha_vencimiento;
        this.fecha_cancelacion = fecha_cancelacion;
    }
    
    public Pedido() {
        this.idPedido = null;
        this.persona = null;
        this.empleado = null;
        this.tipo_pedido = null;
        this.codigo = null;
        this.nro_entregas_realizadas = null;
        this.subtotal = 0;
        this.impuestos = 0;
        this.total = 0;
        this.fecha_creacion = null;
        this.fecha_pago = null;
        this.fecha_vencimiento = null;
        this.fecha_cancelacion = null;
    }

    /**
     * @return the idPedido
     */
    public Integer getIdPedido() {
        return idPedido;
    }

    /**
     * @param idPedido the idPedido to set
     */
    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    /**
     * @return the persona
     */
    public Usuario getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Usuario persona) {
        this.persona = persona;
    }

    /**
     * @return the empleado
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the tipo_pedido
     */
    public Tipo_Pedido getTipo_pedido() {
        return tipo_pedido;
    }

    /**
     * @param tipo_pedido the tipo_pedido to set
     */
    public void setTipo_pedido(Tipo_Pedido tipo_pedido) {
        this.tipo_pedido = tipo_pedido;
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
     * @return the nro_entregas_realizadas
     */
    public Integer getNro_entregas_realizadas() {
        return nro_entregas_realizadas;
    }

    /**
     * @param nro_entregas_realizadas the nro_entregas_realizadas to set
     */
    public void setNro_entregas_realizadas(Integer nro_entregas_realizadas) {
        this.nro_entregas_realizadas = nro_entregas_realizadas;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the impuestos
     */
    public double getImpuestos() {
        return impuestos;
    }

    /**
     * @param impuestos the impuestos to set
     */
    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the fecha_creacion
     */
    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    /**
     * @param fecha_creacion the fecha_creacion to set
     */
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    /**
     * @return the fecha_pago
     */
    public Date getFecha_pago() {
        return fecha_pago;
    }

    /**
     * @param fecha_pago the fecha_pago to set
     */
    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    /**
     * @return the fecha_vencimiento
     */
    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    /**
     * @param fecha_vencimiento the fecha_vencimiento to set
     */
    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    /**
     * @return the fecha_cancelacion
     */
    public Date getFecha_cancelacion() {
        return fecha_cancelacion;
    }

    /**
     * @param fecha_cancelacion the fecha_cancelacion to set
     */
    public void setFecha_cancelacion(Date fecha_cancelacion) {
        this.fecha_cancelacion = fecha_cancelacion;
    }
    
}
