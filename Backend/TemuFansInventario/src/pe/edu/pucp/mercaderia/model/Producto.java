
package pe.edu.pucp.mercaderia.model;

import java.util.Date;


public class Producto {
    private Integer idProducto; // autogenerado
    private String codigo; // autoogenerado
    private String nombre;
    private Estado estado;
    private Double precio;
    private Marca marca;
    private Date fechaRegistro;

    public Producto(Integer idProducto, String codigo, Estado estado, String nombre, Double precio) {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.estado = estado;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public Producto() {
        this.idProducto = null;
        this.codigo = null;
        this.estado = null;
        this.nombre = null;
        this.precio = null;
        this.marca = null;
        this.fechaRegistro = null;
    }
    
    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
        this.codigo = null;
        this.estado = null;
        this.nombre = null;
        this.precio = null;
        this.marca = null;
        this.fechaRegistro = null;
    }
    
    public Producto(Double precio, String nombre, String estado, Integer idMarca){
        this.idProducto = null;
        this.codigo = null;
        this.estado = Estado.valueOf(estado);
        this.nombre = nombre;
        this.precio = precio;
        this.marca = new Marca(idMarca);
        this.fechaRegistro = new Date();
        System.out.println(this.fechaRegistro);
    }
    
    public Producto(Integer idProducto, Double precio, String nombre, String estado){
        this.idProducto = idProducto;
        this.codigo = null;
        if(estado != null){
            this.estado = Estado.valueOf(estado);
        }else{
            this.estado = null;
        }
        this.nombre = nombre;
        this.precio = precio;
        this.marca = null;
        this.fechaRegistro = null;
    }
 
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the peso to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    /**
     * @return the idProducto
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
}
