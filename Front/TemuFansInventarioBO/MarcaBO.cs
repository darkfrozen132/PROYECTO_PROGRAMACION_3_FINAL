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
    public class MarcaBO : BaseBO
    {
        public BindingList<marca> listarMarcas()
        {
            marca[] marcas = this.ServicioWS.marca_listarMarcas();
            return new BindingList<marca>(marcas);
        }
    }
}
