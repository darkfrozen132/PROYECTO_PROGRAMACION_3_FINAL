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
import pe.edu.pucp.usuario.dao.ClienteDAO;
import pe.edu.pucp.usuario.model.Cliente;
import pe.edu.pucp.usuario.model.Tipo_Usuario;

/**
 *
 * @author usuario
 */
public class ClienteDAOImpl extends DAOImpl implements ClienteDAO {

    private Integer tipoListado;
    private Integer tipoObtenerPorID;
    private Cliente cliente;

    public ClienteDAOImpl() {
        this.tipoListado = 1;
        this.tipoObtenerPorID = 1;
        this.cliente = null;
    }

    @Override
    protected String getProcedure_Insertar() {
        return "INSERTAR_CLIENTE";
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
                return "LISTAR_CLIENTES";
            }
            case 2 -> {
                return "LISTAR_CLIENTES_POR_NOMBRE_CODIGO";
            }
            case 3 -> {
                return "LISTAR_POR_NOMBRE_CLIENTE";
            }
            default ->
                throw new AssertionError();
        }
    }

    @Override
    protected String getProcedure_ObtenerPorId() {
        switch (this.tipoObtenerPorID) {
            case 1 -> {
                return "OBTENER_POR_DOI_CLIENTE";
            }
            case 2 -> {
                return "OBTENER_POR_ID_CLIENTE";
            }
            default ->
                throw new AssertionError();
        }
    }

    @Override
    protected void getParamEntrada_Insertar() {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = df.format(cliente.getFecha_registro());
            this.registrarParametroEntrada("_tipo", cliente.getTipo_usuario().toString());
            this.registrarParametroEntrada("__doi", cliente.getDoi());
            this.registrarParametroEntrada("_tipo_doi", cliente.getTipo_doi().toString());
            this.registrarParametroEntrada("_correo", cliente.getCorreo());
            this.registrarParametroEntrada("_fecha_registro", fecha);
            this.registrarParametroEntrada("_Nombre", cliente.getNombre());
            this.registrarParametroEntrada("_telefono", cliente.getTelefono());
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        switch (this.tipoListado) {
            case 1 -> {
                //no tienen parametros de entrada;
            }
            case 2 -> {
                try {
                    if (this.cliente.getNombre() == null) {
                        this.registrarParametroNulo("_nombre", Types.VARCHAR);
                    } else {
                        this.registrarParametroEntrada("_nombre", this.cliente.getNombre());
                    }

                    if (this.cliente.getCodigo() == null) {
                        this.registrarParametroNulo("_codigo", Types.VARCHAR);
                    } else {
                        this.registrarParametroEntrada("_codigo", this.cliente.getCodigo());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 3 -> {
                try {
                    if (this.cliente.getNombre() == null) {
                        this.registrarParametroNulo("_nombre", Types.VARCHAR);
                    } else {
                        this.registrarParametroEntrada("_nombre", this.cliente.getNombre());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            default ->
                throw new AssertionError();

        }
    }

    @Override
    protected void getParamEntrada_ObtenerPorId() {
        try {
            switch (this.tipoObtenerPorID) {
                case 1 -> {
                    this.registrarParametroEntrada("__doi", cliente.getDoi());
                }
                case 2 -> {
                    this.registrarParametroEntrada("_id_cliente", this.cliente.getIdCliente());
                }
                default ->
                    throw new AssertionError();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void getParamSalida_Insertar() {
        try {
            this.registrarParametroSalida("_idUsuario", Types.INTEGER);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            this.cliente.setIdCliente(id);
            this.cliente.setCodigo("CLI-" + id);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        Cliente cli = new Cliente();
        try {
            switch (this.tipoListado) {
                case 1 -> {
                    cli.setNombre(lector.getString("nombre"));
                    cli.setFecha_registro(lector.getDate("fechaRegistro"));
                    String[] cod = lector.getString("codigo").split("-");
                    //logica de asignacion del codgio si por alguna razon el cod tiene "-" incluido
                    //como por ejemplo CLI-GOGO-12
                    int i;
                    String cod_unido = "";
                    for (i = 0; i < cod.length - 1; i++) {
                        cod_unido += cod[i];
                        if (i < cod.length - 2) {
                            cod_unido += "-";
                        }
                    }
                    cli.setCodigo(cod_unido);
                    cli.setIdCliente(Integer.valueOf(cod[i]));
                    return cli;
                }
                case 2 -> {
                    cli.setNombre(lector.getString("nombre"));
                    cli.setFecha_registro(lector.getDate("fechaRegistro"));
                    String[] cod = lector.getString("codigo").split("-");
                    //logica de asignacion del codgio si por alguna razon el cod tiene "-" incluido
                    //como por ejemplo CLI-GOGO-12
                    int i;
                    String cod_unido = "";
                    for (i = 0; i < cod.length - 1; i++) {
                        cod_unido += cod[i];
                        if (i < cod.length - 2) {
                            cod_unido += "-";
                        }
                    }
                    cli.setCodigo(cod_unido);
                    cli.setIdCliente(Integer.valueOf(cod[i]));
                    return cli;
                }
                case 3 -> {
                    /*
                    idCliente,
                    idUsuario,
                    nombre
                     */
                    cli.setIdCliente(lector.getInt("idCliente"));
                    cli.setIdUsuario(lector.getInt("idUsuario"));
                    cli.setNombre(lector.getString("nombre"));
                    return cli;
                }
                default ->
                    throw new AssertionError();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //no deberias de llegar aca, sino hay un error con el tipoListado
        return null;
    }

    @Override
    protected void instanciarObjetoDelResultSet(ResultSet lector) {
        try {
            switch (this.tipoObtenerPorID) {
                case 1 -> {
                    Tipo_Usuario tipoUs = Tipo_Usuario.valueOf(lector.getString("tipo"));
                    this.cliente.setTipo_usuario(tipoUs);
                    this.cliente.setDoi(lector.getString("_doi"));
                }
                case 2 -> {
                    this.cliente.setCodigo(lector.getString("codigo"));
                    this.cliente.setDoi(lector.getString("ruc"));
                    this.cliente.setNombre(lector.getString("nombre"));
                    this.cliente.setTelefono(lector.getString("telefono"));
                    this.cliente.setIdUsuario(lector.getInt("idUsuario"));
                }
                default ->
                    throw new AssertionError();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.cliente.setDoi(null);
        this.cliente.setTipo_doi(null);
    }

    @Override
    public ArrayList<Cliente> listarTodos() {
        this.tipoListado = 1;
        ArrayList<Cliente> lista = new ArrayList<>();
        for (Object obj : super.listar()) {
            lista.add((Cliente) obj);
        }
        return lista;
    }

    @Override
    public ArrayList<Cliente> listarTodosNombreCodigo(String nombre, String codigo) {
        this.nroParametros = 2;
        this.cliente = new Cliente();
        this.cliente.setNombre(nombre);
        this.cliente.setCodigo(codigo);
        this.tipoListado = 2;
        ArrayList<Cliente> lista = new ArrayList<>();
        for (Object obj : super.listar()) {
            lista.add((Cliente) obj);
        }
        this.nroParametros = 0;
        return lista;
    }

    @Override
    public int insertar(Cliente cliente) {
        this.nroParametros = 8;
        this.cliente = cliente;
        Integer resOperacion = super.insertar();
        Integer id = cliente.getIdCliente();
        this.nroParametros = 0;

        return id;
    }

    @Override
    public ArrayList<Cliente> listarPorNombre(String nombre) {
        this.nroParametros = 1;
        this.cliente = new Cliente();
        this.cliente.setNombre(nombre);
        this.tipoListado = 3;
        ArrayList<Cliente> lista = new ArrayList<>();
        for (Object obj : super.listar()) {
            lista.add((Cliente) obj);
        }
        this.nroParametros = 0;
        return lista;
    }

    @Override
    public boolean existeCliente(String doi) {
        this.nroParametros = 1;
        this.tipoObtenerPorID = 1;
        cliente = new Cliente();
        cliente.setDoi(doi);
        super.obtenerPorId();
        this.nroParametros = 0;
        return cliente.getDoi() != null
                && (cliente.getTipo_usuario() == Tipo_Usuario.CLIENTE
                || cliente.getTipo_usuario() == Tipo_Usuario.EMPRESA);
    }

    @Override
    public Cliente obtenerPorId(Integer idCliente) {
        this.nroParametros = 1;
        this.tipoObtenerPorID = 2;
        this.cliente = new Cliente();
        this.cliente.setIdCliente(idCliente);
        super.obtenerPorId();
        this.nroParametros = 0;
        return this.cliente;
    }
}
