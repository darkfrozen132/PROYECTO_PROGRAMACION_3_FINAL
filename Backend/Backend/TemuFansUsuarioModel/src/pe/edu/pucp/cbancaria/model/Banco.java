
package pe.edu.pucp.cbancaria.model;

public class Banco {
    private Integer idBanco;
    private String codigo;
    private String nombre;
    private String swift_bic;
    private Integer telefono;

    public Banco(Integer idBanco, String codigo, String nombre, String swift_bic, Integer telefono) {
        this.idBanco = idBanco;
        this.codigo = codigo;
        this.nombre = nombre;
        this.swift_bic = swift_bic;
        this.telefono = telefono;
    }

    public Banco() {
        this.idBanco = null;
        this.codigo = null;
        this.nombre = null;
        this.swift_bic = null;
        this.telefono = null;
    }

    /**
     * @return the idBanco
     */
    public Integer getIdBanco() {
        return idBanco;
    }

    /**
     * @param idBanco the idBanco to set
     */
    public void setIdBanco(Integer idBanco) {
        this.idBanco = idBanco;
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
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the swift_bic
     */
    public String getSwift_bic() {
        return swift_bic;
    }

    /**
     * @param swift_bic the swift_bic to set
     */
    public void setSwift_bic(String swift_bic) {
        this.swift_bic = swift_bic;
    }

    /**
     * @return the telefono
     */
    public Integer getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
    
}
