/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.usuario.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.dbmanager.config.DAOImpl;

import pe.edu.pucp.usuario.dao.ProveedorDAO;
import pe.edu.pucp.usuario.model.Proveedor;

/**
 *
 * @author usuario
 */
public class ProveedorDAOImpl extends DAOImpl implements ProveedorDAO {

    private Proveedor proveedor;

    public ProveedorDAOImpl() {
        this.proveedor = null;
    }

    @Override
    protected String getProcedure_Insertar() {
        return "INSERTAR_PROVEEDOR";
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
        return "LISTAR_PROVEEDORES_POR_NOMBRE_RUC";
    }

    @Override
    protected String getProcedure_ObtenerPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamEntrada_Insertar() {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = df.format(this.proveedor.getFecha_registro());
            this.registrarParametroEntrada("__doi", this.proveedor.getDoi());
            this.registrarParametroEntrada("_correo", this.proveedor.getCorreo());
            this.registrarParametroEntrada("_fecha_registro", fecha);
            this.registrarParametroEntrada("_Nombre", this.proveedor.getNombre());
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            if (this.proveedor.getNombre() == null) {
                this.registrarParametroNulo("_nombre", Types.VARCHAR);
            } else {
                this.registrarParametroEntrada("_nombre", this.proveedor.getNombre());
            }

            if (this.proveedor.getDoi()== null) {
                this.registrarParametroNulo("_RUC", Types.VARCHAR);
            } else {
                this.registrarParametroEntrada("_RUC", this.proveedor.getDoi());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    @Override
    protected void getParamEntrada_ObtenerPorId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    protected void getParamSalida_Insertar() {
        try {
            this.registrarParametroSalida("_idUsuario", Types.INTEGER);
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            Integer id = (Integer) this.obtenerParametroSalida("_idUsuario", Types.INTEGER);
            this.proveedor.setIdProveedor(id);
            this.proveedor.setCodigo("PROV-" + id);
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        Proveedor prov = new Proveedor();
        try {
            prov.setDoi(String.valueOf(lector.getInt("ruc")));
            prov.setNombre(lector.getString("nombre"));
            prov.setFecha_registro(lector.getDate("fechaRegistro"));
            return prov;
        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public Integer insertar(Proveedor proveedor) {
        this.nroParametros = 5;
        this.proveedor = proveedor;
        super.insertar();
        this.nroParametros = 0;

        return this.proveedor.getIdProveedor();
    }

    @Override
    public ArrayList<Proveedor> listarPorRucNombre(Proveedor proveedor) {
        this.nroParametros = 2;
        this.proveedor = proveedor;
        ArrayList<Proveedor> lista = new ArrayList<>();
        for (Object obj : super.listar()) {
            lista.add((Proveedor) obj);
        }
        this.nroParametros = 0;
        return lista;
    }

}
