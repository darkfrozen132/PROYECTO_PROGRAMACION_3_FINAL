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
import pe.edu.pucp.inventario.model.Torre_Un_Paquete;
import pe.edu.pucp.mercaderia.dao.Torre_Un_PaqueteDAO;
import pe.edu.pucp.mercaderia.model.Estado;

/**
 *
 * @author usuario
 */
public class Torre_Un_PaqueteDAOImpl extends DAOImpl implements Torre_Un_PaqueteDAO {
    //private ConsultaStock consultaStock;
    private Torre_Un_Paquete consultaStock;
    
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
        this.consultaStock = new Torre_Un_Paquete();
        try{
            this.consultaStock.getProducto().setNombre(lector.getString("Nombre"));
            this.consultaStock.setCantidad_paquete(lector.getInt("Stock"));
            this.consultaStock.getAlmacen().setDireccion(lector.getString("Direccion"));
            this.consultaStock.setNro_torre(lector.getInt("nroTorre"));
            this.consultaStock.getProducto().getMarca().setNombre(lector.getString("Marca"));
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
            this.consultaStock.setCantidad_paquete(lector.getInt("Stock"));
            this.consultaStock.getProducto().setEstado(Estado.valueOf(lector.getString("Estado_Producto")));
            this.consultaStock.getProducto().setPrecio(lector.getDouble("Precio"));
            this.consultaStock.getProducto().setFechaRegistro(lector.getDate("FechaRegistro"));
            this.consultaStock.getAlmacen().setDireccion(lector.getString("Direccion"));
            this.consultaStock.setNro_torre(lector.getInt("nroTorre"));
            this.consultaStock.getProducto().getMarca().setNombre(lector.getString("Marca"));
        } catch (SQLException ex) {
            Logger.getLogger(Torre_Un_PaqueteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Torre_Un_Paquete consultarStockProductoPorId(Integer idProducto) {
        this.nroParametros = 1;
        this.consultaStock = new Torre_Un_Paquete(idProducto);
        super.obtenerPorId();
        this.nroParametros = 0;
        return this.consultaStock;
    }

    @Override
    public ArrayList<Torre_Un_Paquete> alertasDeStock() {
        ArrayList<Torre_Un_Paquete> lista = new ArrayList<>();
        this.nroParametros = 0;

        for (Object obj : super.listar()) {
            lista.add((Torre_Un_Paquete) obj);
        }
        return lista; 
    }
    
}
