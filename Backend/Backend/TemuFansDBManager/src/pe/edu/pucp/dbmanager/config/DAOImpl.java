package pe.edu.pucp.dbmanager.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.sql.Types;
import java.sql.Date;
import pe.edu.pucp.dbmanager.db.DBManager;

public abstract class DAOImpl {

    protected Connection conexion;
    protected CallableStatement statement;
    protected ResultSet resultSet;
    protected Integer nroParametros;

    public DAOImpl() {
        this.nroParametros = 0;
    }

    protected void iniciarTransaccion() throws SQLException {
        this.abrirConexion();
        this.conexion.setAutoCommit(false);
    }

    protected void comitarTransaccion() throws SQLException {
        this.conexion.commit();
    }

    protected void rollbackTransaccion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.rollback();
        }
    }

    protected void abrirConexion() {
        this.conexion = DBManager.getInstance().getConnection();
    }

    protected void cerrarConexion() throws SQLException {
        if (this.conexion != null) {
            this.conexion.close();
            this.conexion = null;
        }
    }
    
    /* insertar , modificar eliminar */
    protected Integer insertar(){
        return this.ejecutar_DML(Tipo_Operacion.INSERTAR);
    }
    
    protected Integer modificar(){
        return this.ejecutar_DML(Tipo_Operacion.MODIFICAR);
    }
    
    protected Integer eliminar(){
        return this.ejecutar_DML(Tipo_Operacion.ELIMINAR);
    }
    
    protected Integer ejecutar_DML(Tipo_Operacion tipo){
        Integer resultado = 0;
        try {
            //iniciar la transaccion
            this.iniciarTransaccion();
            //generar la sentencia SQL para CallableStatement
            String sql = this.generarSentenciaSql(tipo);
            System.out.println(sql);
            //colocar la sentencia SQL
            this.colocarSQLenStatement(sql);
            //obtener parametros de entrada
            this.getProcedure_ParamEntrada(tipo);
            //obtener parametros de salida
            this.getProcedure_ParamSalida(tipo);
            //ejecutar el Callable Statement
            resultado = this.ejecutarModificacionEnBD();
            System.out.println("El resultado fue: " + resultado.toString());
            //si hay parametros de salida, devolver los valores
            this.setProcedure_ParamSalida(tipo);
            //comitar la transaccion ya que no se devolvieron excepciones
            this.comitarTransaccion();
        } catch (SQLException ex) {
            try {
                System.err.println("Error al intentar ejecutar el comando SQL - " + ex);
                this.rollbackTransaccion();
            } catch (SQLException ex1) {
                System.err.println("Error al intentar hacer rollback - " + ex);
            }
        } finally {
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }
        }
        return resultado;
    }
    
    protected void colocarSQLenStatement(String sql) throws SQLException{
        this.statement = this.conexion.prepareCall(sql);
    }
    
    protected Integer ejecutarModificacionEnBD() throws SQLException {
        return this.statement.executeUpdate();
    }

    protected void ejecutarConsultaEnBD() throws SQLException {
        this.resultSet = this.statement.executeQuery();
    }
    
    protected String generarSentenciaSql(Tipo_Operacion tipo){
        String sql = "{call ";
        //nombre procedure y los ? para los parametros
        switch(tipo){
            case Tipo_Operacion.INSERTAR ->
                sql += this.getProcedure_Insertar();
            case Tipo_Operacion.MODIFICAR ->
                sql += this.getProcedure_Modificar();
            case Tipo_Operacion.ELIMINAR ->
                sql += this.getProcedure_Eliminar();
            case Tipo_Operacion.LISTAR ->
                sql += this.getProcedure_Listar();
            case Tipo_Operacion.OBTENER_POR_ID ->
                sql += this.getProcedure_ObtenerPorId();
        }
        //cantidad de parametros (lo setea cada clase)
        Integer nroParam = this.nroParametros;
        if(nroParam == 0){
            //si no tiene parametros -> {call nombreProcedure}
            sql += "}";
            return sql;
        }
        //con parametros -> {call nroProcedure(?, ... )}
        sql += "(";
        for(int i=0;i<nroParam;i++){
            sql += "?";
            if(i < nroParam-1) sql += ","; 
        }
        sql += ")}";
        return sql;
    }
    
    protected void getProcedure_ParamEntrada(Tipo_Operacion tipo){
        switch(tipo){
            case Tipo_Operacion.INSERTAR ->
                this.getParamEntrada_Insertar();
            case Tipo_Operacion.MODIFICAR ->
                this.getParamEntrada_Modificar();
            case Tipo_Operacion.ELIMINAR ->
                this.getParamEntrada_Eliminar();
            case Tipo_Operacion.LISTAR ->
                this.getParamEntrada_Listar();
            case Tipo_Operacion.OBTENER_POR_ID->
                this.getParamEntrada_ObtenerPorId();
        }
    }
    
    protected void getProcedure_ParamSalida(Tipo_Operacion tipo){
        switch(tipo){
            case Tipo_Operacion.INSERTAR ->
                this.getParamSalida_Insertar();
            case Tipo_Operacion.MODIFICAR ->
                this.getParamSalida_Modificar();
            case Tipo_Operacion.ELIMINAR ->
                this.getParamSalida_Eliminar();
        }
    }
    
    protected void setProcedure_ParamSalida(Tipo_Operacion tipo){
        switch(tipo){
            case Tipo_Operacion.INSERTAR ->
                this.setParamSalida_Insertar();
            case Tipo_Operacion.MODIFICAR ->
                this.setParamSalida_Modificar();
            case Tipo_Operacion.ELIMINAR ->
                this.setParamSalida_Eliminar();
        }
    }
    
    protected abstract String getProcedure_Insertar();
    protected abstract String getProcedure_Modificar();
    protected abstract String getProcedure_Eliminar();
    protected abstract String getProcedure_Listar();
    protected abstract String getProcedure_ObtenerPorId();
    protected abstract void getParamEntrada_Insertar();
    protected abstract void getParamEntrada_Modificar();
    protected abstract void getParamEntrada_Eliminar();
    protected abstract void getParamEntrada_Listar();
    protected abstract void getParamEntrada_ObtenerPorId();
    protected abstract void getParamSalida_Insertar();
    protected abstract void getParamSalida_Modificar();
    protected abstract void getParamSalida_Eliminar();
    protected abstract void setParamSalida_Insertar();
    protected abstract void setParamSalida_Modificar();
    protected abstract void setParamSalida_Eliminar();
    
    /* listar */
    
    protected ArrayList<Object> listar(){
        ArrayList<Object> lista = new ArrayList<>();
        try {
            //no necesita de transaccion
            this.abrirConexion();
            //generar la sentencia SQL para CallableStatement
            String sql = this.generarSentenciaSql(Tipo_Operacion.LISTAR);
            //colocar la setencia SQL
            this.colocarSQLenStatement(sql);
            //obtener parametros de entrada (no hay parametros de salida)
            this.getProcedure_ParamEntrada(Tipo_Operacion.LISTAR);
            //ejecutar el Callable Statement (en ResultSet estan los datos)
            this.ejecutarConsultaEnBD();
            //leer el resultSet y agregar cada fila a la lista de Object
            while (this.resultSet.next()) {
                //obtener el Object de la fila actual de ResultSet
                lista.add(agregarObjetoALaLista(this.resultSet));
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar ejecutar el comando SQL - " + ex);
        } finally{
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }
        }
        return lista;
    }
    
    protected abstract Object agregarObjetoALaLista(ResultSet lector);
    
    /* obtener por id , setear en atributo de la misma clase */
    
    protected void obtenerPorId(){
        try {
            //no necesita de transaccion
            this.abrirConexion();
            //generar la sentencia SQL para el CallableStatement
            String sql = this.generarSentenciaSql(Tipo_Operacion.OBTENER_POR_ID);
            //colocar la sentencia SQL
            this.colocarSQLenStatement(sql);
            //obtener parametros de entrada (el id y/o otras cosas mas)
            this.getProcedure_ParamEntrada(Tipo_Operacion.OBTENER_POR_ID);
            //ejecutar en Callable Statement (me retorna 1 fila unicamente)
            this.ejecutarConsultaEnBD();
            //leer la unica fila en el ResultSet+
            if(this.resultSet.next()){
                //instanciar los datos de la unica fila de ResultSet en la clase
                this.instanciarObjetoDelResultSet(this.resultSet);
            }else{
                //limpiar el objeto del ResultSet
                this.limpiarObjetoDelResultSet();
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar ejecutar el comando SQL - " + ex);
        } finally{
            try {
                this.cerrarConexion();
            } catch (SQLException ex) {
                System.err.println("Error al intentar cerrar la conexion - " + ex);
            }
        }
    }
    
    protected abstract void instanciarObjetoDelResultSet(ResultSet lector);
    protected abstract void limpiarObjetoDelResultSet();
    
    /* metodo para registrar un parametro de salida */
    protected void incluirParametroString(String nombre, String valor, Boolean es_entrada) throws SQLException {
        if(es_entrada){
            //parametro de entrada
            if (valor == null) {
                //setear valor nulo
                this.statement.setNull(nombre, Types.VARCHAR);
            } else {
                //setear el String
                this.statement.setString(nombre, valor);
            }
        }else{
            //parametro de salida
            this.statement.registerOutParameter(nombre, Types.VARCHAR);
        }
    }
    
    /* metodo para obtener un parametro de salida
        - Integer id = obtenerParametroSalida("_idProductora",Types.INTEGER);
        - String codigoGenerado  = obtenerParametroSalida("_codigo",Types.VARCHAR);
    */
    protected Object obtenerParametroSalida(String nombre, Integer sqlType) throws SQLException{
        Object valor = null;
        switch (sqlType) {
            case Types.INTEGER -> valor = this.statement.getInt(nombre);
            case Types.VARCHAR -> valor = this.statement.getString(nombre);
            case Types.DOUBLE -> valor = this.statement.getDouble(nombre);
            case Types.BOOLEAN -> valor = this.statement.getBoolean(nombre);
            case Types.DATE -> valor = this.statement.getDate(nombre);
            // Agregar más tipos según sea necesario
        }
        return valor;
    }
    
    /* metodo para registrar un parametro de salida
        - registrarParametroSalida("_idProductora",Types.INTEGER);
    */
    protected void registrarParametroSalida(String nombre, Integer sqlType) throws SQLException{
        this.statement.registerOutParameter(nombre,sqlType);
    }
    
    /*
        metodo para registrar un parametro de entrada
        - registrarParametroEntrada("_descripcion",producto.getDescripcion());
    */
    
    protected void registrarParametroEntrada(String nombre,Object valor) throws SQLException{
        switch (valor) {
                case Integer entero -> this.statement.setInt(nombre, entero);
                case String cadena -> this.statement.setString(nombre, cadena);
                case Double decimal -> this.statement.setDouble(nombre, decimal);
                case Boolean booleano -> this.statement.setBoolean(nombre, booleano);
                case Date fecha -> this.statement.setDate(nombre, new Date(fecha.getTime()));
                case byte[] bytes -> this.statement.setBytes(nombre, bytes);
                default -> {
			this.statement.setString(nombre, valor.toString());
                    }
        // Agregar más tipos según sea necesario
        }
    }
    
    /*
        metodo para incluir un parametro de entrada nulo
        - registrarParametroEntrada ("_descripcion", Types.VARCHAR);
    */
    protected void registrarParametroNulo(String nombre,Integer sqlType) throws SQLException{
        this.statement.setNull(nombre,sqlType);
    }
    
 }
