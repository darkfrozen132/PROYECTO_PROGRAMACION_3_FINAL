
package pe.edu.pucp.usuario.model;

import java.util.Date;

public class Cliente extends Usuario{
    private Integer idCliente;
    private String codigo;
    private Date fecha_registro;

    public Cliente(Integer idCliente, String codigo, Date fecha_registro) {
        this.idCliente = idCliente;
        this.codigo = codigo;
        this.fecha_registro = fecha_registro;
    }
    
    public Cliente() {
        this.idCliente = null;
        this.codigo = null;
        this.fecha_registro = null;
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
     * @return the fecha_registro
     */
    public Date getFecha_registro() {
        return fecha_registro;
    }

    /**
     * @param fecha_registro the fecha_registro to set
     */
    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    
}
