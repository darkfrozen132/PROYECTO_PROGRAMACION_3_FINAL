using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.ServiceModel.Channels;
using System.Text;
using System.Threading.Tasks;
using TemuFansBO;
using TemuFansBO.ServicioWS;

namespace TemuFansInventarioBO
{
    public class ProductoBO : BaseBO
    {
        public int insertarProducto(double precio, string nombre, string estado, int idMarca)
        {
            return this.ServicioWS.producto_insertarProducto(precio, nombre, estado, idMarca);
        }

        public void modificarProducto(int idProducto, string nombre, string estado, double precio)
        {
            this.ServicioWS.producto_modificarProducto(idProducto, nombre, estado, precio);
        }

        public void eliminarProducto(int idProducto)
        {
            this.ServicioWS.producto_eliminarProducto(idProducto);
        }

        public BindingList<producto> listarProductosNombre()
        {
            producto[] productos = this.ServicioWS.producto_listarProductosNombre();
            return new BindingList<producto>(productos);
        }

        public producto obtenerProductoPorId(int id)
        {
            return this.ServicioWS.producto_obtenerPorId(id);
        }
    }
}
