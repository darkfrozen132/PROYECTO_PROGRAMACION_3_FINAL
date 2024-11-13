/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.pucp.mercaderia.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.dbmanager.config.DAOImpl;
import pe.edu.pucp.mercaderia.dao.ProductoDAO;
import pe.edu.pucp.mercaderia.model.Estado;
import pe.edu.pucp.mercaderia.model.Marca;
import pe.edu.pucp.mercaderia.model.Producto;

/**
 *
 * @author usuario
 */
public class ProductoDAOImpl extends DAOImpl implements ProductoDAO {

    private Producto producto;
    private Marca marca;
    private Integer tipo_listado;

    public ProductoDAOImpl() {
        this.producto = null;
        this.tipo_listado = 1;
    }

    @Override
    protected String getProcedure_Insertar() {
        return "INSERTAR_PRODUCTO";
    }

    @Override
    protected String getProcedure_Modificar() {
        return "MODIFICAR_PRODUCTO";
    }

    @Override
    protected String getProcedure_Eliminar() {
        return "ELIMINAR_PRODUCTO";
    }

    //LISTAR_PRODUCTOS_NOMBRE
    @Override
    protected String getProcedure_Listar() {
        switch (this.tipo_listado) {
            case 1 -> {
                return "LISTAR_FILTRADO_PRODUCTO";
            }
            case 2 -> {
                return "LISTAR_PRODUCTOS_NOMBRE";
            }
            default -> throw new AssertionError();
        }
    }

    @Override
    protected String getProcedure_ObtenerPorId() {
        return "OBTENER_POR_ID_PRODUCTO_NOMBRE";
    }

    @Override
    protected void getParamEntrada_Insertar() {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd"); // necesario para que la bd acepte el util.Date

            this.registrarParametroEntrada("_idMarca", this.producto.getMarca().getIdMarca());
            this.registrarParametroEntrada("_precio", this.producto.getPrecio());
            this.registrarParametroEntrada("_nombre", this.producto.getNombre());
            this.registrarParametroEntrada("_estado", this.producto.getEstado().toString());
            this.registrarParametroEntrada("_fechaRegistro", formato.format(this.producto.getFechaRegistro()));
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void getParamEntrada_Modificar() {
        try {
            this.registrarParametroEntrada("_idProducto", this.producto.getIdProducto());

            if (this.producto.getPrecio() == null) {
                this.registrarParametroNulo("_precio", Types.DECIMAL);
            } else {
                this.registrarParametroEntrada("_precio", this.producto.getPrecio());
            }
            if (this.producto.getNombre() == null) {
                this.registrarParametroNulo("_nombre", Types.VARCHAR);
            } else {
                this.registrarParametroEntrada("_nombre", this.producto.getNombre());
            }
            if (this.producto.getEstado() == null) {
                this.registrarParametroNulo("_estado", Types.VARCHAR);
            } else {
                this.registrarParametroEntrada("_estado", this.producto.getEstado().toString());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void getParamEntrada_Eliminar() {
        try {
            this.registrarParametroEntrada("_idProducto", this.producto.getIdProducto());
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void getParamEntrada_Listar() {
        try {
            switch (this.tipo_listado) {
                case 1 -> {
                    this.registrarParametroEntrada("_nombre", this.producto.getNombre());
                    this.registrarParametroEntrada("_idMarca", this.marca.getIdMarca());
                }
                case 2 -> {
                    //sin parametros de entrada
                }
                default -> throw new AssertionError();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void getParamEntrada_ObtenerPorId() {
        try {
            this.registrarParametroEntrada("_idProducto", this.producto.getIdProducto());
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void getParamSalida_Insertar() {
        try {
            this.registrarParametroEntrada("_idProducto", Types.INTEGER);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void getParamSalida_Modificar() {
    }

    @Override
    protected void getParamSalida_Eliminar() {
    }

    @Override
    protected void setParamSalida_Insertar() {
        try {
            Integer id = (Integer) this.obtenerParametroSalida("_idProducto", Types.INTEGER);
            this.producto.setIdProducto(id);
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void setParamSalida_Modificar() {
    }

    @Override
    protected void setParamSalida_Eliminar() {
    }

    @Override
    protected Object agregarObjetoALaLista(ResultSet lector) {
        this.producto = new Producto();
        try {
            switch (this.tipo_listado) {
                case 1 -> {
                    this.producto.setIdProducto(lector.getInt("id"));
                    this.producto.setCodigo(lector.getString("codigo"));
                    this.producto.setNombre(lector.getString("nombre"));
                    this.producto.setPrecio(lector.getDouble("precio"));
                    this.marca = new Marca();
                    this.marca.setNombre(lector.getString("marca"));
                    this.producto.setMarca(this.marca);
                    return this.producto;
                }
                case 2 -> { //idProducto, nombre, estado, precio
                    this.producto.setIdProducto(lector.getInt("idProducto"));
                    this.producto.setNombre(lector.getString("nombre"));
                    this.producto.setEstado(Estado.valueOf(lector.getString("estado")));
                    this.producto.setPrecio(lector.getDouble("precio"));
                    return this.producto;
                }
                default -> throw new AssertionError();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.producto;
    }

    @Override
    protected void instanciarObjetoDelResultSet(ResultSet lector) {
        try {
            this.producto.setIdProducto(lector.getInt("id"));
            this.producto.setNombre(lector.getString("nombre"));
            this.producto.setPrecio(lector.getDouble("precio"));
            this.producto.setEstado(Estado.valueOf(lector.getString("estado")));
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer insertarProducto(Producto producto) {
        this.nroParametros = 6;
        this.producto = producto;
        super.insertar();
        Integer id = this.producto.getIdProducto();
        this.nroParametros = 0;
        return id;
    }

    @Override
    public void eliminarProducto(Producto producto) {
        this.nroParametros = 1;
        this.producto = producto;
        super.eliminar();
        this.nroParametros = 0;
    }

    //id, nombre, precio, estado
    @Override
    public void modificarProducto(Producto producto) {
        this.nroParametros = 4;
        this.producto = producto;
        super.modificar();
        this.nroParametros = 0;
    }

    @Override
    public ArrayList<Producto> listarFiltrado(String nombre, Integer idMarca) {
        ArrayList<Producto> lista = new ArrayList<>();
        this.nroParametros = 2;
        this.tipo_listado = 1;
        this.producto = new Producto();
        this.producto.setNombre(nombre);
        this.marca = new Marca();
        this.marca.setIdMarca(idMarca);
        this.producto.setMarca(marca);
        for (Object obj : super.listar()) {
            lista.add((Producto) obj);
        }
        return lista;
    }

    @Override
    public Producto obtenerPorId(Integer id) {
        this.nroParametros = 1;
        this.producto = new Producto();
        this.producto.setIdProducto(id);
        super.obtenerPorId(); //rellena this.producto
        this.nroParametros = 0;
        return this.producto;
    }

    @Override
    public ArrayList<Producto> listarProductosNombre() {
        ArrayList<Producto> lista = new ArrayList<>();
        this.nroParametros = 0;
        this.tipo_listado = 2;

        for (Object obj : super.listar()) {
            lista.add((Producto) obj);
        }
        return lista;
    }
}
