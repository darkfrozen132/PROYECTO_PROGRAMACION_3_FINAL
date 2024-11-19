using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TemuFansBO;
using TemuFansBO.ServicioWS;

namespace TemuFansInventarioBO
{
    public class Torre_Un_PaqueteBO : BaseBO
    {
        public torreUnPaquete consultarStockProductoPorId(int idProducto)
        {
            return this.ServicioWS.torre_consultarStockProducto(idProducto);

        }

        public BindingList<torreUnPaquete> listarAlertasDeStock()
        {
            torreUnPaquete[] consultaStocks = this.ServicioWS.torre_listarAlertasDeStock();
            return new BindingList<torreUnPaquete>(consultaStocks);
        }
    }
}
