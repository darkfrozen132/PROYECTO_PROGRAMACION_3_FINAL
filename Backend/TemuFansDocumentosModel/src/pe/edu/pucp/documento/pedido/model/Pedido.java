
package pe.edu.pucp.documento.pedido.model;

import java.util.Date;
import pe.edu.pucp.usuario.model.*;

public class Pedido {
    private Integer id_pedido;
    private Usuario usuario; //cliente o proveedor
    private Empleado empleado; //responsable de registro
    private Tipo_Pedido tipo_pedido;
    private String codigo;
    private Estado_Pedido estado_pedido;    
    private double subtotal;
    private double impuestos;
    private double total;
    private Date fecha_creacion;
    private Date fecha_pago;
    private Date fecha_vencimiento;
    private Date fecha_cancelacion;
    
    public Pedido(){
        this.id_pedido = null;
        this.usuario = new Usuario();
        this.empleado = new Empleado();
        this.tipo_pedido = null;
        this.codigo = null;
        this.estado_pedido = null;
        this.subtotal = 0;
        this.impuestos = 0;
        this.total = 0;
        this.fecha_creacion = null;
        this.fecha_pago = null;
        this.fecha_vencimiento = null;
        this.fecha_cancelacion = null;
    }
    
    //obliga a setear el tipo de pedido
    public Pedido(Tipo_Pedido tipo){
        this.id_pedido = null;
        this.usuario = null;
        this.empleado = null;
        this.tipo_pedido = tipo;
        this.codigo = null;
        this.estado_pedido = null;
        this.subtotal = 0;
        this.impuestos = 0;
        this.total = 0;
        this.fecha_creacion = null;
        this.fecha_pago = null;
        this.fecha_vencimiento = null;
        this.fecha_cancelacion = null;
    }

    /**
     * @return the id_pedido
     */
    public Integer getId_pedido() {
        return id_pedido;
    }

    /**
     * @param id_pedido the id_pedido to set
     */
    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }
    
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
     * @return the estado_pedido
     */
    public Estado_Pedido getEstado_pedido() {
        return estado_pedido;
    }

    /**
     * @param estado_pedido the estado_pedido to set
     */
    public void setEstado_pedido(Estado_Pedido estado_pedido) {
        this.estado_pedido = estado_pedido;
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
