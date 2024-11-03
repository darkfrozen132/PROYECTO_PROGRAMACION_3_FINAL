
package pe.edu.pucp.usuario.model;

import java.util.Date;

public class Proveedor extends Usuario{
    private Integer idProveedor;
    private String codigo;

    public Proveedor(Integer idUsuario, Tipo_Usuario tipo_persona, String doi, Tipo_Doi tipo_doi, 
            String correo, Date fecha_registro, String nombre, 
            Integer idProveedor, String telefono) {
        super(idUsuario, tipo_persona, doi, tipo_doi, correo, fecha_registro, nombre,telefono);
        this.idProveedor = idProveedor;
        this.codigo = null;
    }
    
    public Proveedor() {
        super();
        this.idProveedor = null;
        this.codigo = null;
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
    
}
