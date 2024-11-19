using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PruebaBootstrap.Almacen
{
    public partial class MasterAlmacen : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string currentPage = System.IO.Path.GetFileName(Request.Path);

            if (currentPage == "reporteAlmacen.aspx")
            {
                idReporteAlmacen.Attributes["class"] += " active";
                idReporteAlmacen.Attributes["aria-current"] = "true";
            }
            else if (currentPage == "AsignarProductoEnTorre.aspx")
            {
                idProductoEnTorre.Attributes["class"] += " active";
                idProductoEnTorre.Attributes["aria-current"] = "true";
            }
        }
    }
}