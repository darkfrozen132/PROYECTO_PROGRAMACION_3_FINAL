using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TemuFansBO;
namespace TemuFansDocumentosBO
{
    public class PedidoBO:BaseBO
    {
        public void modificar_pago(int idPedido, string estado)
        {        
            this.ServicioWS.pedido_modificarPago(idPedido, estado);
        }
    }
}
