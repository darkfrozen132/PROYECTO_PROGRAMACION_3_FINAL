
package pe.edu.pucp.cbancaria.model;

import java.util.Date;
import pe.edu.pucp.usuario.model.Usuario;

public class CuentaBancaria {
    private Integer idCuentaBancaria;
    private Banco banco;
    private Usuario persona;
    private String codigo;
    private Integer IBAN;
    private Estado_CB estado;
    private Date fecha_registro;
    private Date fecha_inactividad;

    public CuentaBancaria(Integer idCuentaBancaria, Banco banco, Usuario persona, String codigo, Integer IBAN, Estado_CB estado, Date fecha_registro, Date fecha_inactividad) {
        this.idCuentaBancaria = idCuentaBancaria;
        this.banco = banco;
        this.persona = persona;
        this.codigo = codigo;
        this.IBAN = IBAN;
        this.estado = estado;
        this.fecha_registro = fecha_registro;
        this.fecha_inactividad = fecha_inactividad;
    }
    
    public CuentaBancaria() {
        this.banco = new Banco();
        this.persona = new Usuario();
        this.idCuentaBancaria = null;
        this.banco = null;
        this.persona = null;
        this.codigo = null;
        this.IBAN = null;
        this.estado = null;
        this.fecha_registro = null;
        this.fecha_inactividad = null;
    }

    /**
     * @return the idCuentaBancaria
     */
    public Integer getIdCuentaBancaria() {
        return idCuentaBancaria;
    }

    /**
     * @param idCuentaBancaria the idCuentaBancaria to set
     */
    public void setIdCuentaBancaria(Integer idCuentaBancaria) {
        this.idCuentaBancaria = idCuentaBancaria;
    }

    /**
     * @return the banco
     */
    public Banco getBanco() {
        return banco;
    }

    /**
     * @param banco the banco to set
     */
    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    /**
     * @return the persona
     */
    public Usuario getPersona() {
        return persona;
    }

    /**
     * @param persona the persona to set
     */
    public void setPersona(Usuario persona) {
        this.persona = persona;
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
     * @return the IBAN
     */
    public Integer getIBAN() {
        return IBAN;
    }

    /**
     * @param IBAN the IBAN to set
     */
    public void setIBAN(Integer IBAN) {
        this.IBAN = IBAN;
    }

    /**
     * @return the estado
     */
    public Estado_CB getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado_CB estado) {
        this.estado = estado;
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
     * @return the fecha_inactividad
     */
    public Date getFecha_inactividad() {
        return fecha_inactividad;
    }

    /**
     * @param fecha_inactividad the fecha_inactividad to set
     */
    public void setFecha_inactividad(Date fecha_inactividad) {
        this.fecha_inactividad = fecha_inactividad;
    }
    
}
