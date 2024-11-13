
package pe.edu.pucp.usuario.model;

import java.util.Date;

public class Usuario {
    private Integer idUsuario;
    private Tipo_Usuario tipo_usuario;
    private String doi;
    private Tipo_Doi tipo_doi;
    private String correo;
    private Date fecha_registro;
    private String nombre;
    private String telefono;

    public Usuario(){
        this.idUsuario = null;
        this.tipo_usuario = null;
        this.doi = null;
        this.tipo_doi = null;
        this.correo = null;
        this.fecha_registro = null;
        this.nombre = null;
        this.telefono = null;
    }
    
    public Usuario(Integer idUsuario, Tipo_Usuario tipo_usuario, String doi, Tipo_Doi tipo_doi, String correo, Date fecha_registro, String nombre, String telefono) {
        this.idUsuario = idUsuario;
        this.tipo_usuario = tipo_usuario;
        this.doi = doi;
        this.tipo_doi = tipo_doi;
        this.correo = correo;
        this.fecha_registro = fecha_registro;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the tipo_usuario
     */
    public Tipo_Usuario getTipo_usuario() {
        return tipo_usuario;
    }

    /**
     * @param tipo_usuario the tipo_usuario to set
     */
    public void setTipo_usuario(Tipo_Usuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
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
