using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.UI;

namespace UtilidadesWeb
{
    public static class ScriptsGenericos
    {
        public static void MostrarMensajeError(Page page, string mensaje)
        {
            string script = $"mostrarError('Error: {mensaje}');";
            page.ClientScript.RegisterStartupScript(page.GetType(), "mostrarError", script, true);
        }
    }
}
