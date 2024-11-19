using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using TemuFansBO;
using TemuFansBO.ServicioWS;

namespace TemuFansUsuarioBO
{
    public class ProveedorBO : BaseBO
    {
        public int insertar(string doi, string correo, string nombre)
        {
            return this.ServicioWS.proveedor_insertar(doi,correo,nombre);
        }

        public BindingList<proveedor> listarPorNombreRuc(string doi, string nombre)
        {
            proveedor[] prov = this.ServicioWS.proveedor_listarPorNombreRuc(doi,nombre);

            return new BindingList<proveedor>(prov);
        }
    }
}
