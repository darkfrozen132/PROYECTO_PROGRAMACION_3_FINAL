using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PruebaBootstrap
{
    public partial class MasterVentas_GestionClientes : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            // Obtener el nombre de la página actual
            string currentPage = System.IO.Path.GetFileName(Request.Path);

            // Establecer clase y atributo según la página actual
            if (currentPage == "Gestion_de_Clientes.aspx")
            {
                idNuevoCliente.Attributes["class"] = "nav-link active";
                idNuevoCliente.Attributes["aria-current"] = "true";
            }
            else if (currentPage == "Listar_Clientes.aspx")
            {
                idListarClientes.Attributes["class"] = "nav-link active";
                idListarClientes.Attributes["aria-current"] = "true";
            }
        }
    }
}