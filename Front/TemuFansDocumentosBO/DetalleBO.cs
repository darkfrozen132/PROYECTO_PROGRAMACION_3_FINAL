using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TemuFansBO.ServicioWS;
using TemuFansBO;

namespace TemuFansDocumentosBO
{
    public class DetalleBO : BaseBO
    {
        /*public void insertarPorLote(BindingList<detallePedido> lista)
        {
            detallePedido[] detalles = new detallePedido[lista.Count];
            int i = 0;
            foreach(detallePedido det in lista)
            {
                detalles[i] = det;
                i++;
            }
            this.ServicioWS.detallePed_insertarPorLoteDetalles(detalles);
        }*/
        public void insertarPorLote(BindingList<detallePedido> lista)
        {
            
            detallePedido[] detalles = new detallePedido[lista.Count];
            int i = 0;
            foreach (detallePedido det in lista)
            {
                detalles[i] = det;
                i++;
            }
            this.ServicioWS.detallePed_insertarPorLoteDetalles(detalles);
        }

    }
}
