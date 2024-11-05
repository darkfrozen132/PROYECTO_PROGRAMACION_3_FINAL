using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using TemuFansDocumentosBO;

namespace TemuFansPedidoTestxd
{
    internal class Program
    {
        static void Main(string[] args)
        {
            PedidoBO pedidoBO=new PedidoBO();
            pedidoBO.modificar_pago(17, "CANCELADO");
        }
    }
}
