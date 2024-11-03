
package pe.edu.pucp.mercaderia.model;

public class Marca {
    private Integer idMarca;
    private String nombre;
    private String descripcion;
    private String codigo_marca;

    public Marca(Integer idMarca, String nombre, String descripcion, String codigo_marca) {
        this.idMarca = idMarca;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo_marca = codigo_marca;
    }
    
    public Marca() {
        this.idMarca = null;
        this.nombre = null;
        this.descripcion = null;
        this.codigo_marca = null;
    }

    /**
     * @return the idMarca
     */
    public Integer getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the codigo_marca
     */
    public String getCodigo_marca() {
        return codigo_marca;
    }

    /**
     * @param codigo_marca the codigo_marca to set
     */
    public void setCodigo_marca(String codigo_marca) {
        this.codigo_marca = codigo_marca;
    }
    
}
