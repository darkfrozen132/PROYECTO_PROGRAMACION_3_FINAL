using System;
using System.Web;
using TemuFansBO.ServicioWS;
using TemuFansInventarioBO;
using System.IO;
using iTextSharp.text;
using iTextSharp.text.pdf;

namespace PruebaBootstrap.Inventario
{
    public partial class consultarStockProducto : System.Web.UI.Page
    {
        private ProductoBO productoBO = new ProductoBO();
        private Torre_Un_PaqueteBO torreBO = new Torre_Un_PaqueteBO();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                ddlProducto.DataSource = productoBO.listarProductosNombre();
                ddlProducto.DataTextField = "nombre";
                ddlProducto.DataValueField = "idProducto";
                ddlProducto.DataBind();

                ddlProducto.Items.Insert(0, new System.Web.UI.WebControls.ListItem("Seleccione un producto", "0"));
            }
        }
        protected void ddlProducto_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (ddlProducto.SelectedIndex != 0)
            {
                // Get the selected product ID
                int idProducto = int.Parse(ddlProducto.SelectedValue);

                // Fetch the product details based on the selected product ID
                consultaStock consulta = torreBO.consultarStockProductoPorId(idProducto);

                if (consulta != null)
                {
                    // Populate the fields with the product details
                    txtNombre.Text = consulta.producto.nombre;
                    txtStock.Text = consulta.torre.cantidad_paquete.ToString();
                    rbEstado.Text = consulta.producto.estado.ToString();
                    txtPrecio.Text = consulta.producto.precio.ToString();
                    txtFechaRegistro.Text = consulta.producto.fechaRegistro.ToString();
                    txtDireccion.Text = consulta.almacen.direccion;
                    txtNroTorre.Text = consulta.torre.nro_torre.ToString();
                    txtMarca.Text = consulta.marca.nombre.ToString();
                }
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            // Crear documento PDF
            Document pdfDoc = new Document(PageSize.A4, 25, 25, 30, 30);
            MemoryStream memoryStream = new MemoryStream();
            PdfWriter writer = PdfWriter.GetInstance(pdfDoc, memoryStream);

            // Abrir el documento
            pdfDoc.Open();

            // Agregar un título al documento
            Font titleFont = FontFactory.GetFont("Arial", 18, Font.BOLD);
            pdfDoc.Add(new Paragraph("Reporte de Stock de Producto", titleFont));
            pdfDoc.Add(new Paragraph("Fecha: " + DateTime.Now.ToString("dd/MM/yyyy")));
            pdfDoc.Add(new Paragraph(" ")); // Espacio en blanco

            // Crear una tabla con 2 columnas
            PdfPTable table = new PdfPTable(2);
            table.WidthPercentage = 100;
            table.SetWidths(new float[] { 40f, 60f }); // Configurar ancho de columnas

            // Añadir cabecera de la tabla
            Font headerFont = FontFactory.GetFont("Arial", 12, Font.BOLD, BaseColor.WHITE);
            PdfPCell header1 = new PdfPCell(new Phrase("Campo", headerFont));
            PdfPCell header2 = new PdfPCell(new Phrase("Valor", headerFont));
            header1.BackgroundColor = BaseColor.DARK_GRAY;
            header2.BackgroundColor = BaseColor.DARK_GRAY;
            header1.HorizontalAlignment = Element.ALIGN_CENTER;
            header2.HorizontalAlignment = Element.ALIGN_CENTER;
            table.AddCell(header1);
            table.AddCell(header2);

            // Añadir las filas con los datos del producto
            table.AddCell("Nombre del Producto");
            table.AddCell(txtNombre.Text);

            table.AddCell("Stock del Producto");
            table.AddCell(txtStock.Text);

            table.AddCell("Estado del Producto");
            table.AddCell(rbEstado.SelectedValue);

            table.AddCell("Precio del Producto");
            table.AddCell(txtPrecio.Text);

            table.AddCell("Fecha de Registro");
            table.AddCell(txtFechaRegistro.Text);

            table.AddCell("Dirección del Almacén");
            table.AddCell(txtDireccion.Text);

            table.AddCell("Número de Torre");
            table.AddCell(txtNroTorre.Text);

            table.AddCell("Marca");
            table.AddCell(txtMarca.Text);

            // Añadir la tabla al documento PDF
            pdfDoc.Add(table);

            // Cerrar el documento PDF
            pdfDoc.Close();

            // Enviar el PDF al navegador para su descarga
            byte[] bytes = memoryStream.ToArray();
            memoryStream.Close();

            Response.Clear();
            Response.ContentType = "application/pdf";
            Response.AddHeader("Content-Disposition", "attachment; filename=Reporte_Stock" + DateTime.Now.ToString("dd/MM/yyyy") + ".pdf");
            Response.Buffer = true;
            Response.Cache.SetCacheability(HttpCacheability.NoCache);
            Response.BinaryWrite(bytes);
            Response.End();
        }
    }
}