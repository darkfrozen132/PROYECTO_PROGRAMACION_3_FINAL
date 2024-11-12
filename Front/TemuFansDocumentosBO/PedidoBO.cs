using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TemuFansBO;
using TemuFansBO.ServicioWS;
namespace TemuFansDocumentosBO
{
    public class PedidoBO:BaseBO
    {
        public void modificar_pago(int idPedido, string estado)
        {        
            this.ServicioWS.pedido_modificarPago(idPedido, estado);
        }

        public BindingList<resumenPorFecha> listarPedidosPorFechas(string fechaInicio, string fechaFin)
        {
            resumenPorFecha[] lista = this.ServicioWS.pedido_listar_fecha(fechaInicio, fechaFin);
            return new BindingList<resumenPorFecha>(lista);
        }
    }
}
