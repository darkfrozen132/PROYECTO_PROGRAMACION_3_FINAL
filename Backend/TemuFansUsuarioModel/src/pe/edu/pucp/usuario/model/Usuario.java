
package pe.edu.pucp.usuario.model;

import java.util.Date;

public class Usuario {
    private Integer idUsuario;
    private Tipo_Persona tipo_persona;
    private String doi;
    private Tipo_Doi tipo_doi;
    private String correo;
    private Date fecha_registro;

    public Usuario(Integer idUsuario, Tipo_Persona tipo_persona, String doi, Tipo_Doi tipo_doi, String correo, Date fecha_registro) {
        this.idUsuario = idUsuario;
        this.tipo_persona = tipo_persona;
        this.doi = doi;
        this.tipo_doi = tipo_doi;
        this.correo = correo;
        this.fecha_registro = fecha_registro;
    }
    
    public Usuario() {
        this.idUsuario = null;
        this.tipo_persona = null;
        this.doi = null;
        this.tipo_doi = null;
        this.correo = null;
        this.fecha_registro = null;
    }

    /**
     * @return the idPersona
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idPersona to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the tipo_persona
     */
    public Tipo_Persona getTipo_persona() {
        return tipo_persona;
    }

    /**
     * @param tipo_persona the tipo_persona to set
     */
    public void setTipo_persona(Tipo_Persona tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    /**
     * @return the doi
     */
    public String getDoi() {
        return doi;
    }

    /**
     * @param doi the doi to set
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }

    /**
     * @return the tipo_doi
     */
    public Tipo_Doi getTipo_doi() {
        return tipo_doi;
    }

    /**
     * @param tipo_doi the tipo_doi to set
     */
    public void setTipo_doi(Tipo_Doi tipo_doi) {
        this.tipo_doi = tipo_doi;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
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
