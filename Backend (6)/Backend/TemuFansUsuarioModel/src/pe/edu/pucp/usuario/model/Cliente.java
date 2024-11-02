
package pe.edu.pucp.usuario.model;

import java.util.Date;

public class Cliente extends Usuario{
    private Integer idCliente;
    private String codigo;
    private String telefono;

    public Cliente(Integer idUsuario, Tipo_Usuario tipo_persona, String doi, Tipo_Doi tipo_doi, 
            String correo, Date fecha_registro, String nombre, 
            Integer idCliente, String telefono) {
        super(idUsuario, tipo_persona, doi, tipo_doi, correo, fecha_registro, nombre);
        this.idCliente = idCliente;
        this.telefono = telefono;
    }
    
    
    public Cliente() {
        super();
        this.idCliente = null;
        this.codigo = null;
        
    }

    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
