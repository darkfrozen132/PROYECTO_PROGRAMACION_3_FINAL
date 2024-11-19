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
import pe.edu.pucp.documento.pedido.model.PagoPedidoCliente;
import pe.edu.pucp.documento.pedido.model.ResumenHistorialVentas;
import pe.edu.pucp.documento.pedido.model.ResumenPorFecha;
import pe.edu.pucp.inventario.model.Almacen;
import pe.edu.pucp.inventario.model.ConsultaStock;
import pe.edu.pucp.inventario.model.Torre_Un_Paquete;
import pe.edu.pucp.mercaderia.bo.AlmacenBO;
import pe.edu.pucp.mercaderia.bo.MarcaBO;
import pe.edu.pucp.mercaderia.bo.Torre_Un_PaqueteBO;
import pe.edu.pucp.mercaderia.model.Marca;
import pe.edu.pucp.mercaderia.model.Producto;
import pe.edu.pucp.usuario.BO.ProveedorBO;
import pe.edu.pucp.usuario.model.Proveedor;

/**
 *
 * @author divano132
 */
@WebService(serviceName = "ServicioWS")
public class ServicioWS {
   
    private final ClienteBO clientebo;
    private final PedidoBO pedidobo;
    private final DetallePedidoBO detallePedidoBo;
    private final ProductoBO productobo;
    private final MarcaBO marcabo;
    private final Torre_Un_PaqueteBO torrebo;
    private final AlmacenBO almacenbo;
    private final ProveedorBO proveedorbo;
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
        this.almacenbo = new AlmacenBO();
        this.proveedorbo = new ProveedorBO();
    }
    
    /////////////////////////////////////////////////////////////////
    ///////////////////     CLIENTE     /////////////////////////////
    /////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName = "usuario_insertar_cliente")
    public Integer usuario_insertar_cliente(@WebParam(name = "tipo_usuario")String tipo_usuario,
            @WebParam(name = "doi")String doi, @WebParam(name = "tipo_doi")String tipo_doi,
            @WebParam(name = "correo")String correo, @WebParam(name = "fecha_registro")String fechaRegistro, 
            @WebParam(name = "nombre")String nombre, @WebParam(name = "telefono")String telefono) throws ParseException{
        
        return this.clientebo.insertarCliente(tipo_usuario, doi, tipo_doi, correo, fechaRegistro, nombre, telefono);
    }
    
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
    
    @WebMethod(operationName = "usuario_existe_cliente")
    public boolean usuario_existe_cliente(@WebParam(name = "doi")String doi){
        return this.clientebo.existeCliente(doi);
    }
    
    @WebMethod(operationName = "cliente_obtenerPorId")
    public Cliente cliente_obtenerPorId(
            @WebParam(name = "idCliente")Integer idCliente){
        return this.clientebo.obtenerPorId(idCliente);
    }
    
    /////////////////////////////////////////////////////////////////
    ///////////////////     PRODUCTO     ////////////////////////////
    /////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName = "producto_buscarProductosCriterio")
    public ArrayList<Producto> buscarProductosCriterio(
            @WebParam(name = "nombre")String nombre,
            @WebParam(name = "codigo")String codigo){
        return this.productobo.buscarProductosCriterio(nombre,codigo);
    }
    
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
    
    /////////////////////////////////////////////////////////////////
    ///////////////////       TORRE      ////////////////////////////
    /////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName = "torre_consultarStockProducto")
    public Torre_Un_Paquete torre_consultarStockProducto(@WebParam(name = "idProducto")Integer id){
        return this.torrebo.consultarStockProductoPorId(id);
    }
    
    @WebMethod(operationName = "torre_listarAlertasDeStock")
    public ArrayList<Torre_Un_Paquete> torre_listarAlertasDeStock(){
        return this.torrebo.listarAlertasDeStock();
    }
    
    /////////////////////////////////////////////////////////////////
    ///////////////////      ALMACEN      ////////////////////////////
    /////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName = "almacen_listarAlmacenes")
    public ArrayList<Almacen> almacen_listarAlmacenes(){
        return this.almacenbo.listarTodos();
    }
    
    @WebMethod(operationName = "almacen_reportePorId")
    public ArrayList<ConsultaStock> almacen_reportePorId(@WebParam(name = "idAlmacen")Integer id){
        return this.almacenbo.reportePorId(id);
    }
    
    @WebMethod(operationName = "almacen_listarTorresPorAlmacen")
    public ArrayList<ConsultaStock> almacen_listarTorresPorAlmacen(@WebParam(name = "idAlmacen")Integer id){
        return this.almacenbo.reportePorId(id);
    }
    
    /////////////////////////////////////////////////////////////////
    ///////////////////      PEDIDO      ////////////////////////////
    /////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName = "pedido_listar_fecha")
    public ArrayList<ResumenPorFecha> pedido_listar_fecha(
            @WebParam(name = "fechaInicio")String fechaInicio,
            @WebParam(name = "fechaFin")String fechaFin){
        return this.pedidobo.obtenerResumenPorFecha(fechaInicio, fechaFin);
    }
    
    // Nuevo método - Jairo
    @WebMethod(operationName = "pedido_listar_historial_ventas")
    public ArrayList<ResumenHistorialVentas> pedido_listar_historial_ventas(
            @WebParam(name = "fechaInicio") String fechaInicio,
            @WebParam(name = "fechaFin") String fechaFin,
            @WebParam(name = "fechaPagoInicio") String fechaPagoInicio,
            @WebParam(name = "fechaPagoFin") String fechaPagoFin,
            @WebParam(name = "ruc") String ruc,
            @WebParam(name = "razonSocial") String razonSocial,
            @WebParam(name = "metodoPago") String metodoPago) {
        return this.pedidobo.obtenerHistorialVentasFiltrado(fechaInicio, fechaFin, fechaPagoInicio, fechaPagoFin, ruc, razonSocial, metodoPago);
    }
    
    @WebMethod(operationName = "pedido_listar_pago")
    public ArrayList<PagoPedidoCliente> pedido_listar_pago(
            @WebParam(name = "fechaInicio")String fechaInicio,
            @WebParam(name = "fechaFin")String fechaFin){
        return this.pedidobo.obtenerListaPago(fechaInicio, fechaFin);
    }
    
    @WebMethod(operationName = "pedido_insertarVenta")
    public Integer insertarVenta(
            @WebParam(name = "idUsuario")Integer idUsuario,
            @WebParam(name = "idEmpleado")Integer idEmpleado,
            @WebParam(name = "subtotal")double subtotal,
            @WebParam(name = "impuesto")double impuesto,
            @WebParam(name = "total")double total){
        return this.pedidobo.insertarVenta(idUsuario, idEmpleado, subtotal, impuesto, total);
    }
    
    /////////////////////////////////////////////////////////////////
    ///////////////////   DETALLE PEDIDO  ///////////////////////////
    /////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName = "detallePedido_obtenerLineasPedido")
    public ArrayList<DetallePedido> detallePedido_obtenerLineasPedido(@WebParam(name = "id")Integer id){
        return this.detallePedidoBo.listarLineasDePedido(id);
    }
    
    @WebMethod(operationName = "detallePed_insertarPorLoteDetalles")
    public void insertarPorLoteDetalles(
            @WebParam(name = "detalles")ArrayList<DetallePedido> detalles){
        this.detallePedidoBo.insertarPorLoteLineaPed(detalles);
    }
    
    /////////////////////////////////////////////////////////////////
    ////////////////////       MARCA      ///////////////////////////
    /////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName = "marca_listarMarcas")
    public ArrayList<Marca> marca_listarMarcas(){
        return this.marcabo.listarMarcas();
    }
    
    /////////////////////////////////////////////////////////////////
    ////////////////////     PROVEEDOR    ///////////////////////////
    /////////////////////////////////////////////////////////////////
    
    @WebMethod(operationName = "proveedor_insertar")
    public Integer proveedor_insertar(@WebParam(name = "doi")String doi,@WebParam(name = "correo")String correo, 
            @WebParam(name = "nombre")String nombre){
        
        return this.proveedorbo.insertar(doi, correo, nombre);
    }
    
    @WebMethod(operationName = "proveedor_listarPorNombreRuc")
    public ArrayList<Proveedor> proveedor_listarPorNombreRuc(@WebParam(name = "doi")String doi,@WebParam(name = "nombre") String nombre){
        return this.proveedorbo.listarPorNombreRuc(doi, nombre);
    }
}
