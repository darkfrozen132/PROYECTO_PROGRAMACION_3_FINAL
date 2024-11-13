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
    public class AlmacenBO : BaseBO
    {
        public BindingList<almacen> listarTodos()
        {
            almacen[] almacens = this.ServicioWS.almacen_listarAlmacenes();
            return new BindingList<almacen>(almacens);
        }
   
        public BindingList<consultaStock> reportePorId(int id)
        {
            consultaStock[] consulta = this.ServicioWS.almacen_reportePorId(id);
            return new BindingList<consultaStock>(consulta);
        }


    }
}
