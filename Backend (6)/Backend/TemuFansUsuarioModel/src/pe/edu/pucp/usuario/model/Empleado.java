
package pe.edu.pucp.usuario.model;

public class Empleado extends Usuario{
    private Integer idEmpleado;
    private String codigo;
    private double sueldo;

    public Empleado(Integer idEmpleado, String codigo, double sueldo) {
        this.idEmpleado = idEmpleado;
        this.codigo = codigo;
        this.sueldo = sueldo;
    }
    
    public Empleado() {
        this.idEmpleado = null;
        this.codigo = null;
        this.sueldo = 0;
    }

    /**
     * @return the idEmpleado
     */
    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    /**
     * @param idEmpleado the idEmpleado to set
     */
    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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
     * @return the sueldo
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
}
