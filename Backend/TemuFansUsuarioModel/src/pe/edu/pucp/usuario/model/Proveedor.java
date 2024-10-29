
package pe.edu.pucp.usuario.model;

public class Proveedor extends Usuario{
    private Integer idProveedor;
    private String codigo;
    private Integer prioridad;

    public Proveedor(Integer idProveedor, String codigo, Integer prioridad) {
        this.idProveedor = idProveedor;
        this.codigo = codigo;
        this.prioridad = prioridad;
    }
    
    public Proveedor() {
        this.idProveedor = null;
        this.codigo = null;
        this.prioridad = null;
    }

    /**
     * @return the idProveedor
     */
    public Integer getIdProveedor() {
        return idProveedor;
    }

    /**
     * @param idProveedor the idProveedor to set
     */
    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
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
     * @return the prioridad
     */
    public Integer getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(Integer prioridad) {
        this.prioridad = prioridad;
    }
    
}
