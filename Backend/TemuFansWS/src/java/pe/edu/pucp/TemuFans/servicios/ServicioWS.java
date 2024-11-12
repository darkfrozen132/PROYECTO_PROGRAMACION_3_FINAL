/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.pucp.TemuFans.servicios;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.mercaderia.bo.ProductoBO;
import pe.edu.pucp.usuario.BO.ClienteBO;
import pe.edu.pucp.usuario.model.Cliente;
import pe.edu.pucp.pedido.bo.PedidoBO;
import java.text.ParseException;
import pe.edu.pucp.detallepedido.bo.DetallePedidoBO;
import pe.edu.pucp.documento.pedido.model.DetallePedido;
import pe.edu.pucp.documento.pedido.model.ResumenPorFecha;
import pe.edu.pucp.inventario.model.ConsultaStock;
import pe.edu.pucp.mercaderia.bo.MarcaBO;
import pe.edu.pucp.mercaderia.bo.Torre_Un_PaqueteBO;
import pe.edu.pucp.mercaderia.model.Marca;
import pe.edu.pucp.mercaderia.model.Producto;

/**
 *
 * @author usuario
 */
@WebService(serviceName = "ServicioWS")
public class ServicioWS {
   
    private final ClienteBO clientebo;
    private final PedidoBO pedidobo;
    private final DetallePedidoBO detallePedidoBo;
    private final ProductoBO productobo;
    private final MarcaBO marcabo;
    private final Torre_Un_PaqueteBO torrebo;
    /**
     * This is a sample web service operation
     */
    public ServicioWS(){
        this.clientebo= new ClienteBO();
        this.pedidobo= new PedidoBO();
        this.productobo = new ProductoBO();
        this.detallePedidoBo = new DetallePedidoBO();
        this.marcabo = new MarcaBO();
        this.torrebo = new Torre_Un_PaqueteBO();
    }
    
    /////////////////////////////////////////////////////////////////
    ///////////////////     CLIENTE     /////////////////////////////
    /////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName = "cliente_listarClientes")
    public ArrayList<Cliente> cliente_listarClientes(){
        
        return this.clientebo.listarTodos();
    }
    
    @WebMethod(operationName = "cliente_listarClientesNombreCodigo")
    public ArrayList<Cliente> cliente_listarClientesNombreCodigo(@WebParam(name = "nombre")String nombre, @WebParam(name = "codigo") String codigo){
        
        return this.clientebo.listarTodosNombreCodigo(nombre, codigo);
    }
    @WebMethod(operationName = "pedido_modificarPago")
    public void pedido_modificar_pago(@WebParam(name = "idPedido")Integer idPedido, @WebParam(name = "estado_pedido") String estado_pedido){
        
        
        this.pedidobo.modificar_pago(idPedido,estado_pedido);
    }
    
    @WebMethod(operationName = "cliente_buscarCliente")
    public ArrayList<Cliente> cliente_buscarCliente(
            @WebParam(name = "nombre")String nombre){
        return this.clientebo.buscarCliente(nombre);
    }
    
    /////////////////////////////////////////////////////////////////
    ///////////////////     PRODUCTO     ////////////////////////////
    /////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName = "producto_insertarProducto")
    public Integer producto_insertarProducto(@WebParam(name = "precio")Double precio, 
            @WebParam(name = "nombre")String nombre,@WebParam(name = "estado") String estado,
            @WebParam(name = "idMarca")Integer idMarca){
        
        return this.productobo.insertarProducto(precio, nombre, estado, idMarca);
    }
    
    //Integer idProducto, String nombre, String estado, Double precio
    @WebMethod(operationName = "producto_modificarProducto")
    public void producto_modificarProducto(
            @WebParam(name = "idProducto")Integer idProducto,
            @WebParam(name = "nombre")String nombre,
            @WebParam(name = "estado") String estado,
            @WebParam(name = "precio")Double precio 
            ){
        
        this.productobo.modificarProducto(idProducto, nombre, estado,precio);
    }
    
    @WebMethod(operationName = "producto_eliminarProducto")
    public void producto_eliminarProducto(@WebParam(name = "idProducto")Integer idProducto){
        
        this.productobo.eliminarProducto(idProducto);
    }
    
    @WebMethod(operationName = "producto_obtenerPorId")
    public Producto producto_obtenerPorId(@WebParam(name = "idProducto")Integer id){
        return this.productobo.obtenerPorId(id);
    }
    
    @WebMethod(operationName = "producto_listarProductosNombre")
    public ArrayList<Producto> producto_listarProductosNombre(){
        return this.productobo.listarProductosNombre();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName = "usuario_insertar_cliente")
    public Integer usuario_insertar_cliente(@WebParam(name = "tipo_usuario")String tipo_usuario,
            @WebParam(name = "doi")String doi, @WebParam(name = "tipo_doi")String tipo_doi,
            @WebParam(name = "correo")String correo, @WebParam(name = "fecha_registro")String fechaRegistro, 
            @WebParam(name = "nombre")String nombre, @WebParam(name = "telefono")String telefono) throws ParseException{
        
        return this.clientebo.insertarCliente(tipo_usuario, doi, tipo_doi, correo, fechaRegistro, nombre, telefono);
    }
    
    @WebMethod(operationName = "detallePedido_obtenerLineasPedido")
    public ArrayList<DetallePedido> detallePedido_obtenerLineasPedido(@WebParam(name = "id")Integer id){
        
        return this.detallePedidoBo.listarLineasDePedido(id);
    }
    
    @WebMethod(operationName = "marca_listarMarcas")
    public ArrayList<Marca> marca_listarMarcas(){
        return this.marcabo.listarMarcas();
    }
    
    @WebMethod(operationName = "torre_consultarStockProducto")
    public ConsultaStock torre_consultarStockProducto(@WebParam(name = "idProducto")Integer id){
        return this.torrebo.consultarStockProductoPorId(id);
    }
    
    @WebMethod(operationName = "pedido_listar_fecha")
    public ArrayList<ResumenPorFecha> pedido_listar_fecha(
            @WebParam(name = "fechaInicio")String fechaInicio,
            @WebParam(name = "fechaFin")String fechaFin){
        return this.pedidobo.obtenerResumenPorFecha(fechaInicio, fechaFin);
    }
    
    
    
    @WebMethod(operationName = "torre_listarAlertasDeStock")
    public ArrayList<ConsultaStock> torre_listarAlertasDeStock(){
        return this.torrebo.listarAlertasDeStock();
    }
    
}