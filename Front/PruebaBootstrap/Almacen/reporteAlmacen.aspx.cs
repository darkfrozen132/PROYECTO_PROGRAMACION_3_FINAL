using iTextSharp.text.pdf;
using iTextSharp.text;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Web;
using System.Web.UI.WebControls;
using TemuFansBO.ServicioWS;
using TemuFansInventarioBO;
using ListItem = System.Web.UI.WebControls.ListItem;
using System.Linq;

namespace PruebaBootstrap.Almacen
{
    public partial class reporteAlmacen : System.Web.UI.Page
    {
        private AlmacenBO almacenBO = new AlmacenBO();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarNombresAlmacenes();
                lblMensaje.Visible = false; // Ocultar mensaje de error al cargar la página
            }
        }

        private void CargarNombresAlmacenes()
        {
            BindingList<almacen> almacenes = this.almacenBO.listarTodos();
            almacenesCheckBoxList.DataSource = almacenes;
            almacenesCheckBoxList.DataTextField = "direccion";
            almacenesCheckBoxList.DataValueField = "idAlmacen";
            almacenesCheckBoxList.DataBind();
        }

        protected void btnSelectAll_Click(object sender, EventArgs e)
        {
            bool selectAll = almacenesCheckBoxList.Items.Cast<ListItem>().All(item => item.Selected);
            foreach (ListItem item in almacenesCheckBoxList.Items)
            {
                item.Selected = !selectAll;
            }
            btnSelectAll.Text = selectAll ? "Seleccionar Todos" : "Deseleccionar Todos";
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            List<int> almacenesSeleccionados = new List<int>();
            foreach (ListItem item in almacenesCheckBoxList.Items)
            {
                if (item.Selected)
                {
                    almacenesSeleccionados.Add(int.Parse(item.Value));
                }
            }

            if (almacenesSeleccionados.Count == 0)
            {
                // Mostrar mensaje si no hay almacenes seleccionados
                lblMensaje.Text = "Por favor, seleccione al menos un almacén para generar el reporte.";
                lblMensaje.Visible = true;
            }
            else
            {
                lblMensaje.Visible = false;
                GenerarReporte(almacenesSeleccionados);
            }
        }

        private void GenerarReporte(List<int> almacenesSeleccionados)
        {
            try
            {
                using (MemoryStream memoryStream = new MemoryStream())
                {
                    Document pdfDoc = CrearDocumento(memoryStream);
                    pdfDoc.Open();

                    AgregarTitulo(pdfDoc, "Reporte de Almacen General");

                    foreach (int idAlmacen in almacenesSeleccionados)
                    {
                        PdfPTable table = CrearTablaCabecera();
                        LlenarTablaConDatos(table, idAlmacen);
                        pdfDoc.Add(table);
                    }

                    pdfDoc.Close();
                    DescargarPDF(memoryStream);
                }
            }
            catch (Exception ex)
            {
                lblMensaje.Text = "Error generando el reporte: " + ex.Message;
                lblMensaje.Visible = true;
            }
        }

        private Document CrearDocumento(Stream memoryStream)
        {
            Document pdfDoc = new Document(PageSize.A4, 10, 10, 10, 10);
            PdfWriter.GetInstance(pdfDoc, memoryStream);
            return pdfDoc;
        }

        private void AgregarTitulo(Document pdfDoc, string titulo)
        {
            Font titleFont = FontFactory.GetFont("Arial", 18, Font.BOLD);
            pdfDoc.Add(new Paragraph(titulo, titleFont));
            pdfDoc.Add(new Paragraph("Fecha: " + DateTime.Now.ToString("dd/MM/yyyy")));
            pdfDoc.Add(new Paragraph(" ")); // Espacio en blanco
        }

        private PdfPTable CrearTablaCabecera()
        {
            PdfPTable table = new PdfPTable(8);
            table.WidthPercentage = 100;
            table.SetWidths(new float[] { 15f, 20f, 15f, 10f, 10f, 10f, 10f, 10f });

            Font headerFont = FontFactory.GetFont("Arial", 10, Font.BOLD, BaseColor.WHITE);
            List<string> cabeceras = new List<string>
            {
                "Código Producto", "Nombre Producto", "Marca", "Nº Torre", "Cantidad Paquetes", "Estado Producto", "Precio Producto", "Fecha de Registro"
            };

            foreach (string cad in cabeceras)
            {
                PdfPCell header = new PdfPCell(new Phrase(cad, headerFont))
                {
                    BackgroundColor = BaseColor.DARK_GRAY,
                    HorizontalAlignment = Element.ALIGN_CENTER
                };
                table.AddCell(header);
            }

            return table;
        }

        private void LlenarTablaConDatos(PdfPTable table, int idAlmacen)
        {
            BindingList<consultaStock> consulta = almacenBO.reportePorId(idAlmacen);

            foreach (consultaStock item in consulta)
            {
                table.AddCell(item.producto.codigo + "-" + item.producto.idProducto.ToString());
                table.AddCell(item.producto.nombre);
                table.AddCell(item.marca.nombre);
                table.AddCell(item.torre.nro_torre.ToString());
                table.AddCell(item.torre.cantidad_paquete.ToString());
                table.AddCell(item.producto.estado.ToString());
                table.AddCell(item.producto.precio.ToString("C"));
                table.AddCell(item.producto.fechaRegistro.ToString("dd/MM/yyyy"));
            }
        }

        private void DescargarPDF(MemoryStream memoryStream)
        {
            byte[] bytes = memoryStream.ToArray();

            Response.Clear();
            Response.ContentType = "application/pdf";
            Response.AddHeader("Content-Disposition", "attachment; filename=Reporte_Stock_" + DateTime.Now.ToString("ddMMyyyy") + ".pdf");
            Response.Buffer = true;
            Response.Cache.SetCacheability(HttpCacheability.NoCache);
            Response.BinaryWrite(bytes);
            Response.End();
        }
        protected void almacenesCheckBoxList_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}


