/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.mercaderia.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.dbmanager.config.DAOImpl;
import pe.edu.pucp.inventario.model.ConsultaStock;
import pe.edu.pucp.mercaderia.dao.Torre_Un_PaqueteDAO;
import pe.edu.pucp.mercaderia.model.Estado;

/**
 *
 * @author usuario
 */
public class Torre_Un_PaqueteDAOImpl extends DAOImpl implements Torre_Un_PaqueteDAO {
    private ConsultaStock consultaStock;
    
    public Torre_Un_PaqueteDAOImpl(){
        this.consultaStock = null;
    }

    @Override
    protected String getProcedure_Insertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        return "LISTAR_PRODUCTOS_ALERTA_DE_STOCK";
    }

    @Override
    protected String getProcedure_ObtenerPorId() {
        return "CONSULTAR_STOCK_POR_IDPRODUCTO";
    }

    @Override
    protected void getParamEntrada_Insertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        //sin parametros de entrada
    }

    @Override
    protected void getParamEntrada_ObtenerPorId() {
        try {
            this.registrarParametroEntrada("_idProducto", this.consultaStock.getProducto().getIdProducto());
        } catch (SQLException ex) {
            Logger.getLogger(Torre_Un_PaqueteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void getParamSalida_Insertar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        this.consultaStock = new ConsultaStock();
        try{
            this.consultaStock.getProducto().setNombre(lector.getString("Nombre"));
            this.consultaStock.getTorre().setCantidad_paquete(lector.getInt("Stock"));
            this.consultaStock.getAlmacen().setDireccion(lector.getString("Direccion"));
            this.consultaStock.getTorre().setNro_torre(lector.getInt("nroTorre"));
            this.consultaStock.getMarca().setNombre(lector.getString("Marca"));
            return this.consultaStock;
        } catch (SQLException ex) {
            Logger.getLogger(Torre_Un_PaqueteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //Nombre, Stock, Estado_Producto, Precio, FechaRegistro, Direccion, nroTorre, Marca
    @Override
    protected void instanciarObjetoDelResultSet(ResultSet lector) {
        try {
            this.consultaStock.getProducto().setNombre(lector.getString("Nombre"));
            this.consultaStock.getTorre().setCantidad_paquete(lector.getInt("Stock"));
            this.consultaStock.getProducto().setEstado(Estado.valueOf(lector.getString("Estado_Producto")));
            this.consultaStock.getProducto().setPrecio(lector.getDouble("Precio"));
            this.consultaStock.getProducto().setFechaRegistro(lector.getDate("FechaRegistro"));
            this.consultaStock.getAlmacen().setDireccion(lector.getString("Direccion"));
            this.consultaStock.getTorre().setNro_torre(lector.getInt("nroTorre"));
            this.consultaStock.getMarca().setNombre(lector.getString("Marca"));
        } catch (SQLException ex) {
            Logger.getLogger(Torre_Un_PaqueteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ConsultaStock consultarStockProductoPorId(Integer idProducto) {
        this.nroParametros = 1;
        this.consultaStock = new ConsultaStock(idProducto);
        super.obtenerPorId();
        this.nroParametros = 0;
        return this.consultaStock;
    }

    @Override
    public ArrayList<ConsultaStock> alertasDeStock() {
        ArrayList<ConsultaStock> lista = new ArrayList<>();
        this.nroParametros = 0;

        for (Object obj : super.listar()) {
            lista.add((ConsultaStock) obj);
        }
        return lista; 
    }
    
}
