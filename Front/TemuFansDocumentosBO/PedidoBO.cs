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

        public BindingList<resumenHistorialVentas> listarHistorialVentas(
        string fechaInicio, string fechaFin, string fechaPagoInicio,
        string fechaPagoFin, string ruc, string razonSocial, string metodoPago)
        {
            // Llama al método del servicio web en Java con todos los parámetros necesarios
            resumenHistorialVentas[] lista = this.ServicioWS.pedido_listar_historial_ventas(
                fechaInicio, fechaFin, fechaPagoInicio, fechaPagoFin, ruc, razonSocial, metodoPago);

            // Devuelve los resultados en un BindingList
            return new BindingList<resumenHistorialVentas>(lista);
        }

        public BindingList<pagoPedidoCliente> listarPedidosPagos(string fechaInicio, string fechaFin)
        {
            pagoPedidoCliente[] lista2 = this.ServicioWS.pedido_listar_pago(fechaInicio, fechaFin);

            return new BindingList<pagoPedidoCliente>(lista2);
        }
    }
}
