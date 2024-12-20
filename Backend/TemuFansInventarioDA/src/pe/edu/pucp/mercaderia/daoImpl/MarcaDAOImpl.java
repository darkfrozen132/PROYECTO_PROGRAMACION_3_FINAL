/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.mercaderia.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.pucp.dbmanager.config.DAOImpl;
import pe.edu.pucp.mercaderia.dao.MarcaDAO;
import pe.edu.pucp.mercaderia.model.Marca;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author usuario
 */
public class MarcaDAOImpl extends DAOImpl implements MarcaDAO{
    private Marca marca;
    private Integer tipo_listado;
    
    public MarcaDAOImpl(){
        this.marca = null;
        this.tipo_listado = 1;
    }
    
    
    @Override
    public ArrayList<Marca> listarPorNombre(String nombre) {
        ArrayList<Marca> lista = new ArrayList<>();
        this.nroParametros = 1;
        this.tipo_listado = 1;
        this.marca = new Marca();
        this.marca.setNombre(nombre);
        for(Object obj : super.listar()){
            lista.add((Marca)obj);
        }
        this.nroParametros = 0;
        return lista;    
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
        switch (this.tipo_listado) {
            case 1 -> {
                return "LISTAR_POR_NOMBRE_MARCA";
            }
            case 2 -> {
                return "LISTAR_MARCAS";
            }
            default -> throw new AssertionError();
        }
    }

    @Override
    protected String getProcedure_ObtenerPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        try {
            switch(this.tipo_listado){
                case 1 ->{
                    this.registrarParametroEntrada("_nombre", this.marca.getNombre());
                }
                case 2 ->{
                    //no hay parametros de entrada
                }
                default -> throw new AssertionError();
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void getParamEntrada_ObtenerPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        this.marca = new Marca();
        try {
            switch(this.tipo_listado){
                case 1 -> {
                    this.marca.setIdMarca(lector.getInt("idMarca"));
                    this.marca.setCodigo_marca(lector.getString("codigo"));
                    this.marca.setNombre(lector.getString("nombre"));
                    this.marca.setDescripcion(lector.getString("descripcion"));
                    return this.marca;
                }
                case 2 -> {
                    this.marca.setIdMarca(lector.getInt("idMarca"));
                    this.marca.setNombre(lector.getString("nombre"));
                    return this.marca;
                }
                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.marca;
    }

    @Override
    protected void instanciarObjetoDelResultSet(ResultSet lector) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Marca> listarMarcas() {
        ArrayList<Marca> lista = new ArrayList<>();
        this.nroParametros = 0;
        this.tipo_listado = 2;
        
        for(Object obj : super.listar()){
            lista.add((Marca)obj);
        }
        return lista;    
    }
    
}
