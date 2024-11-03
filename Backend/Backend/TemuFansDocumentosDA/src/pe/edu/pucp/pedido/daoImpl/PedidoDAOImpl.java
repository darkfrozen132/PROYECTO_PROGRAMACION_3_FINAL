
package pe.edu.pucp.pedido.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Types;
import pe.edu.pucp.documento.pedido.model.*;
import pe.edu.pucp.pedido.dao.PedidoDAO;
import pe.edu.pucp.dbmanager.config.DAOImpl;
import pe.edu.pucp.usuario.model.*;

public class PedidoDAOImpl extends DAOImpl implements PedidoDAO{
    
    private Pedido pedido;
    private Tipo_Pedido tipo;
    private Usuario usuario;

    @Override
    public Integer insertar(Tipo_Pedido tipo,Pedido pedido) {
        this.nroParametros = 8;
        this.pedido = pedido;
        this.tipo = tipo;
        Integer resOperacion = super.insertar(); //resultado de executeUpdate
        Integer id = this.pedido.getId_pedido(); 
        this.nroParametros = 0;
        return id;
    }

    @Override
    public Pedido obtenerPorId(Integer idPedido) {
        this.nroParametros = 1;
        this.pedido = new Pedido();
        this.pedido.setId_pedido(idPedido);
        super.obtenerPorId(); //rellena el this.pedido
        this.nroParametros = 0;
        return this.pedido;
    }
    
    @Override
    protected String getProcedure_Insertar() {
        return "INSERTAR_PEDIDO";
    }

    @Override
    protected String getProcedure_Modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String getProcedure_Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String getProcedure_Listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected String getProcedure_ObtenerPorId() {
        return "OBTENER_POR_ID_PEDIDO";
    }
    
    @Override
    protected void getParamEntrada_Insertar() {
        try {
            this.registrarParametroEntrada("_tipo_pedido", this.tipo.toString());
            this.registrarParametroEntrada("_idUsuario", this.pedido.getUsuario().getIdUsuario());
            this.registrarParametroEntrada("_idEmpleado", this.pedido.getEmpleado().getIdEmpleado());
            this.registrarParametroEntrada("_estado", Estado_Pedido.PENDIENTE.toString());
            this.registrarParametroEntrada("_subtotal", this.pedido.getSubtotal());
            this.registrarParametroEntrada("_impuesto", this.pedido.getImpuestos());
            this.registrarParametroEntrada("_total",this.pedido.getTotal());
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void getParamEntrada_Modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamEntrada_Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamEntrada_Listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamEntrada_ObtenerPorId() {
        try {
            this.registrarParametroEntrada("_idPedido", this.pedido.getId_pedido());
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void getParamSalida_Insertar() {
        try {
            this.registrarParametroEntrada("_idPedido", Types.INTEGER);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void getParamSalida_Modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamSalida_Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void setParamSalida_Insertar() {
        try {
            Integer id = (Integer)this.obtenerParametroSalida("_idPedido", Types.INTEGER);
            this.pedido.setId_pedido(id);
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void setParamSalida_Modificar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void setParamSalida_Eliminar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected Object agregarObjetoALaLista(ResultSet lector) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void instanciarObjetoDelResultSet(ResultSet lector) {
        try {
            //leer el tipo de pedido
            this.tipo = Tipo_Pedido.valueOf(lector.getString("tipo_pedido"));
            this.pedido.setTipo_pedido(this.tipo);
            //setear datos del this.usuario Cliente o Proveedor que luego asigno a this.pedidos
            Integer id_ClienteProveedor = lector.getInt("idClienteProveedor");
            System.out.println("El id del cliente o proveedor es : " + id_ClienteProveedor);
            if(this.tipo == Tipo_Pedido.COMPRA){
                //usuario es Proveedor
                Proveedor prov = new Proveedor();
                prov.setIdProveedor(id_ClienteProveedor);
                this.usuario = prov;
            }else{
                //usuario est Cliente
                Cliente cli = new Cliente();
                cli.setIdCliente(id_ClienteProveedor);
                this.usuario = cli;
            }
            this.usuario.setIdUsuario(lector.getInt("idUsuario"));
            this.usuario.setNombre(lector.getString("nombreUsuario"));
            System.out.println("Nombre : " + this.usuario.getNombre());
            this.usuario.setDoi(lector.getString("doi"));
            this.usuario.setTipo_doi(Tipo_Doi.RUC); //siempre es Empresa el Pedido
            this.usuario.setTelefono(lector.getString("telefonoUsuario"));
            this.pedido.setUsuario(this.usuario);
            //setear datos generales del pedido
            Estado_Pedido estado = Estado_Pedido.valueOf(lector.getString("estado"));
            this.pedido.setEstado_pedido(estado);
            this.pedido.setSubtotal(lector.getDouble("subtotal"));
            System.out.println("El subtotal del pedido es : " + this.pedido.getSubtotal());
            this.pedido.setImpuestos(lector.getDouble("impuesto"));
            this.pedido.setTotal(lector.getDouble("total"));
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
    }

}
