/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.detallepedido.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.dbmanager.config.DAOImpl;
import pe.edu.pucp.detallepedido.dao.DetPedDAO;
import pe.edu.pucp.documento.pedido.model.*;
import pe.edu.pucp.mercaderia.model.Producto;

/**
 *
 * @author rodri
 */
public class DetPedDAOImpl extends DAOImpl implements DetPedDAO{
    
    private DetallePedido detalle;
    
    @Override
    public Integer insertar(DetallePedido det){
        this.nroParametros = 5;
        this.detalle = det;
        Integer resOperation = super.insertar();
        this.nroParametros = 0;
        return resOperation;
    }
    
    @Override
    public ArrayList<DetallePedido> listarLineasDePedido(Integer id) {
        this.nroParametros = 1;
        Pedido ped = new Pedido();
        ped.setId_pedido(id);
        this.detalle = new DetallePedido();
        this.detalle.setPedido(ped);
        //listar
        ArrayList<DetallePedido> lista = new ArrayList<>();
        for(Object obj : this.listar()){
            lista.add((DetallePedido)obj);
        }
        this.nroParametros = 0;
        return lista;
    }
    
    @Override
    public void insertarPorLote(ArrayList<DetallePedido> detalles){
        try {
            this.usarTransaccion = false;
            this.iniciarTransaccion();
            /*
                datos del procedimiento para el insertar
            */
            this.nroParametros = 5;
            for(DetallePedido det : detalles){
                this.detalle = det;
                Integer resOp = super.insertar();
                System.out.println("El resultado de la operacion es : " + resOp);
            }
            this.comitarTransaccion();
        } catch (SQLException ex) {
            try {
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                Logger.getLogger(DetPedDAOImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            try {
                this.cerrarConexion();
                this.usarTransaccion = true;
                this.nroParametros = 0;
            } catch (SQLException ex) {
                Logger.getLogger(DetPedDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    protected String getProcedure_Insertar() {
        return "INSERTAR_LINEA_PEDIDO";
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
        return "OBTENER_POR_ID_DETALLE_PEDIDO";
    }

    @Override
    protected String getProcedure_ObtenerPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamEntrada_Insertar() {
        try {
            this.registrarParametroEntrada("_idPedido", this.detalle.getPedido().getId_pedido());
            this.registrarParametroEntrada("_idProducto", this.detalle.getProducto().getIdProducto());
            this.registrarParametroEntrada("_cantidad", this.detalle.getCantidad());
            this.registrarParametroEntrada("_monto", this.detalle.getMonto());
            this.registrarParametroEntrada("_descripcion", this.detalle.getDescripcion());
        } catch (SQLException ex) {
            Logger.getLogger(DetPedDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            this.registrarParametroEntrada("_idPedido", this.detalle.getPedido().getId_pedido());
        } catch (SQLException ex) {
            Logger.getLogger(DetPedDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    @Override
    protected void getParamEntrada_ObtenerPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamSalida_Insertar() {
        //no hay nada
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
        //no hay nada
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
        this.detalle = null;
        try {
            this.detalle = new DetallePedido();
            Producto prod = new Producto();
            prod.setIdProducto(lector.getInt("idProducto"));
            prod.setNombre(lector.getString("nombreProducto"));
            prod.setCodigo(lector.getString("codigo"));
            this.detalle.setProducto(prod);
            this.detalle.setCantidad(lector.getInt("cantidad"));
            this.detalle.setDescripcion(lector.getString("descripcion"));
            this.detalle.setMonto(lector.getDouble("monto"));
            this.detalle.setCantidad_por_entregar(lector.getInt("cantidad_por_entregar"));
        } catch (SQLException ex) {
            Logger.getLogger(DetPedDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return this.detalle;
    }

    @Override
    protected void instanciarObjetoDelResultSet(ResultSet lector) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
