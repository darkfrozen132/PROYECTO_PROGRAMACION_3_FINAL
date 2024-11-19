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
import pe.edu.pucp.inventario.model.Almacen;
import pe.edu.pucp.inventario.model.ConsultaStock;

import pe.edu.pucp.mercaderia.dao.AlmacenDAO;
import pe.edu.pucp.mercaderia.model.Estado;

/**
 *
 * @author usuario
 */
public class AlmacenDAOImpl extends DAOImpl implements AlmacenDAO {

    private Almacen almacen;
    private ConsultaStock consulta;
    private Integer tipoListado;

    public AlmacenDAOImpl() {
        this.almacen = null;
        this.consulta = null;
        this.tipoListado = 1;
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
        switch (this.tipoListado) {
            case 1 -> {
                return "LISTAR_ALMACENES_NOMBRE";
            }
            case 2 -> {
                return "LISTAR_TORRE_POR_ALMACEN";
            }
            default -> {
                throw new AssertionError();
            }
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
        switch (this.tipoListado) {
            case 1 -> {
                //No hay
            }
            case 2 -> {
                try {
                    this.registrarParametroEntrada("_idAlmacen", this.consulta.getAlmacen().getIdAlmacen());
                } catch (SQLException ex) {
                    Logger.getLogger(AlmacenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            default -> {
                throw new AssertionError();
            }
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
        this.almacen = new Almacen();
        this.consulta = new ConsultaStock();
        try {
            switch (this.tipoListado) {
                case 1 -> {
                    this.almacen.setIdAlmacen(lector.getInt("idAlmacen"));
                    this.almacen.setDireccion(lector.getString("direccion"));
                    return this.almacen;
                }
                case 2 -> {
                    this.consulta.getProducto().setIdProducto(lector.getInt("idProducto"));
                    this.consulta.getProducto().setNombre(lector.getString("nombre"));
                    this.consulta.getMarca().setNombre(lector.getString("marca"));
                    this.consulta.getTorre().setNro_torre(lector.getInt("nroTorre"));
                    this.consulta.getTorre().setCantidad_paquete(lector.getInt("Stock"));
                    this.consulta.getProducto().setEstado(Estado.valueOf(lector.getString("Estado_Producto")));
                    this.consulta.getProducto().setPrecio(lector.getDouble("Precio"));
                    this.consulta.getProducto().setFechaRegistro(lector.getDate("FechaRegistro"));
                    this.consulta.getProducto().setCodigo("PROD");
                    return this.consulta;
                }
                default -> {
                    throw new AssertionError();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlmacenDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
    public ArrayList<Almacen> listarTodos() {
        ArrayList<Almacen> lista = new ArrayList<>();
        this.nroParametros = 0;
        this.tipoListado = 1;
        for (Object obj : super.listar()) {
            lista.add((Almacen) obj);
        }
        return lista;
    }

    @Override
    public ArrayList<ConsultaStock> reportePorId(Integer idAlmacen) {
        /*
        this.nroParametros = 1;
        this.consulta = new ConsultaStock();
        this.consulta.getAlmacen().setIdAlmacen(idAlmacen);
        super.obtenerPorId();
        this.nroParametros = 0;
        return this.consulta;*/
        ArrayList<ConsultaStock> lista = new ArrayList<>();
        this.nroParametros = 1;
        this.consulta = new ConsultaStock();
        this.consulta.getAlmacen().setIdAlmacen(idAlmacen);
        this.tipoListado = 2;
        for (Object obj : super.listar()) {
            lista.add((ConsultaStock) obj);
        }
        this.nroParametros = 0;
        return lista;
    }

}
