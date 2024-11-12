using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using TemuFansBO.ServicioWS;
using TemuFansInventarioBO;

namespace PruebaBootstrap.Inventario
{
    public partial class AlertasDeStock : System.Web.UI.Page
    {
        private DataTable resumenData;
        protected void Page_Load(object sender, EventArgs e)
        {
            resumenData = ObtenerDatosDeResumen();
            if (!IsPostBack)
            {
                // Cargar los datos al iniciar la página

                ViewState["ResumenData"] = resumenData; // Guardar datos en ViewState
                gvAlertas.DataSource = resumenData;
                gvAlertas.DataBind();
            }
            else
            {
                resumenData = ViewState["ResumenData"] as DataTable; // Recuperar datos desde ViewState
            }
        }

        private DataTable ObtenerDatosDeResumen()
        {
            Torre_Un_PaqueteBO torreBO = new Torre_Un_PaqueteBO();
            BindingList<consultaStock> lista = torreBO.listarAlertasDeStock();

            DataTable dt = new DataTable();
            dt.Columns.Add("Producto", typeof(string));
            dt.Columns.Add("Marca", typeof(string));
            dt.Columns.Add("Direccion", typeof(string));
            dt.Columns.Add("NroTorre", typeof(int));
            dt.Columns.Add("Stock", typeof(int));

            foreach (consultaStock consulta in lista)
            {
                dt.Rows.Add(consulta.producto.nombre, consulta.marca.nombre, consulta.almacen.direccion,
                    consulta.torre.nro_torre, consulta.torre.cantidad_paquete
                    );
            }
            return dt;
        }
        protected void gvAlertas_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvAlertas.PageIndex = e.NewPageIndex;
            gvAlertas.DataSource = ViewState["ResumenData"] as DataTable; // Recuperar los datos completos
            gvAlertas.DataBind();
        }

        protected void gvAlertas_RowDataBound(object sender, GridViewRowEventArgs e)
        {


        }
    }
}