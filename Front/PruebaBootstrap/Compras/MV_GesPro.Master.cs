using System;
using System.Web.UI;

namespace PruebaBootstrap
{
    public partial class MV_GesPro_Master : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            // Obtener el nombre del archivo de la página actual
            string currentPage = System.IO.Path.GetFileName(Request.Path);

            // Marcar la pestaña activa según la página actual
            if (currentPage == "Gestion_de_Proveedores.aspx")
            {
                idNuevoProveedor.Attributes["class"] = "nav-link active";
                idNuevoProveedor.Attributes["aria-current"] = "true";
            }
            else if (currentPage == "Listar_Proveedores.aspx")
            {
                idListarProveedores.Attributes["class"] = "nav-link active";
                idListarProveedores.Attributes["aria-current"] = "true";
            }
        }
    }
}
