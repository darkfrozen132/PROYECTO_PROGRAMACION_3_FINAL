package pe.edu.pucp.documento.pedido.model;

import java.util.Date;

/**
 *
 * @author Ricardo
 */
public class ResumenPorFecha {
    private Date fecha;
    private Integer cantPedidos;
    private double total;
    
    public ResumenPorFecha(){
        this.fecha=null;
        this.cantPedidos=null;
        this.total=0;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the cantPedidos
     */
    public Integer getCantPedidos() {
        return cantPedidos;
    }

    /**
     * @param cantPedidos the cantPedidos to set
     */
    public void setCantPedidos(Integer cantPedidos) {
        this.cantPedidos = cantPedidos;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }
    
    
}