package pe.edu.pucp.usuario.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente extends Usuario{
    private Integer idCliente;
    private String codigo;

    public Cliente(Integer idUsuario, Tipo_Usuario tipo_persona, String doi, Tipo_Doi tipo_doi, 
            String correo, Date fecha_registro, String nombre, 
            Integer idCliente, String telefono) {
        super(idUsuario, tipo_persona, doi, tipo_doi, correo, fecha_registro, nombre,telefono);
        this.idCliente = idCliente;
        this.codigo = null;
    }
    
    
    public Cliente() {
        super();
        this.idCliente = null;
        this.codigo = null;
        
    }

//    public Cliente(String tipo_usuario, String doi, String tipo_doi, String correo, String fechaRegistro, String nombre, String telefono) throws ParseException{
//        
//        Tipo_Usuario tipUs = Tipo_Usuario.valueOf(tipo_usuario);
//        Tipo_Doi tipDoi = Tipo_Doi.valueOf(tipo_doi);
//        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date fecha = sdf.parse(fechaRegistro);
//        
//        super(null, tipUs, doi, tipDoi, correo, fecha, nombre, telefono);
//        
//        this.idCliente = null;
//        this.codigo = null;
//    }

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
    
}
