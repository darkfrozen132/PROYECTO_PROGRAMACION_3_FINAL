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
    public class ClienteBO : BaseBO
    {
        public BindingList<cliente> listarTodos()
        {
            cliente[] lista = this.ServicioWS.cliente_listarClientes();
            return new BindingList<cliente>(lista);
        }


        public BindingList<cliente> listarTodosNombreCodigo(string nombre, string codigo)
        {
            cliente[] lista = this.ServicioWS.cliente_listarClientesNombreCodigo(nombre, codigo);
            return new BindingList<cliente>(lista);
        }
        public int insertarCliente(string tipo_usuario, string doi, string tipo_doi, string correo, string fechaRegistro, string nombre, string telefono)
        {
            return this.ServicioWS.usuario_insertar_cliente(tipo_usuario, doi, tipo_doi, correo, fechaRegistro, nombre, telefono);
        }
    }
}
