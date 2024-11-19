using System;
using System.Data;
using System.Web.UI;
using System.Web.UI.WebControls;
using TemuFansBO.ServicioWS;
using TemuFansUsuarioBO;

namespace PruebaBootstrap
{
    public partial class Listar_Proveedores : System.Web.UI.Page
    {
        private DataTable proveedoresData;
        private ProveedorBO proveedorbo = new ProveedorBO();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                // Cargar datos iniciales al cargar la página
                proveedoresData = ObtenerProveedores("","");
                ViewState["ProveedoresData"] = proveedoresData;
                gvProveedores.DataSource = proveedoresData;
                gvProveedores.DataBind();
            }
        }

        private DataTable ObtenerProveedores(string ruc, string razonSocial)
        {
            if (ruc == null) ruc = "";
            if (razonSocial == null) razonSocial = "";
            // Simulación de datos
            DataTable dt = new DataTable();
            dt.Columns.Add("RUC", typeof(string));
            dt.Columns.Add("RazonSocial", typeof(string));
            dt.Columns.Add("FechaRegistro", typeof(DateTime));
            
            foreach (proveedor prov in proveedorbo.listarPorNombreRuc(ruc, razonSocial))
            {
                dt.Rows.Add(prov.doi.ToString(),prov.nombre,prov.fecha_registro.ToString());
            }
            return dt;
        }

        protected void btnFiltrar_Click(object sender, EventArgs e)
        {
            // Recuperar filtros
            string razonSocial = txtRazonSocial.Text;
            string ruc = txtRUC.Text;

            // Filtrar datos
            DataTable dtFiltrado = ObtenerProveedores(ruc, razonSocial);

            // Actualizar el GridView
            ViewState["ProveedoresFiltrados"] = dtFiltrado;
            gvProveedores.DataSource = dtFiltrado;
            gvProveedores.DataBind();
        }

        protected void gvProveedores_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvProveedores.PageIndex = e.NewPageIndex;
            DataTable dt = ViewState["ProveedoresFiltrados"] as DataTable ?? ViewState["ProveedoresData"] as DataTable;
            gvProveedores.DataSource = dt;
            gvProveedores.DataBind();
        }
    }
}
