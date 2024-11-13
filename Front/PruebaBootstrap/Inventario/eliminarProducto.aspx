<%@ Page Title="" Language="C#" MasterPageFile="MasterInventario.master" AutoEventWireup="true" CodeBehind="eliminarProducto.aspx.cs" Inherits="PruebaBootstrap.eliminarProducto" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphInventarioContenido" runat="server">
<div class="container">
    <h2>Eliminar Producto</h2>
    <script type="text/javascript">
    function validarSeleccionProducto() {
        var ddlProducto = document.getElementById('<%= ddlProducto.ClientID %>');
        if (ddlProducto.value === "0") {
            alert("Por favor, seleccione un producto válido.");
            return false; // Evita que el formulario se envíe
        }
        return true; // Permite el envío del formulario si se selecciona un producto válido
        }
        function confirmarModificacion() {
            return confirm("¿Está seguro de que desea modificar el producto?");
        }
    </script>

    <div class="row">
        <!-- ID de Pedido -->
        <div class="col-md-6">
            <div class="form-group">
                <label for="txtProducto">PRODUCTO:</label>
                <asp:DropDownList ID="ddlProducto" runat="server" AutoPostBack="true" CssClass="form-select"
                    OnSelectedIndexChanged="ddlProducto_SelectedIndexChanged"></asp:DropDownList>
                <!--
                <asp:TextBox ID="txtIdProducto" runat="server" CssClass="form-control" placeholder="Ingrese el ID Producto" />
                -->
            </div>
        </div>
    </div>

    <div class="row mt-4">
        <!-- Botones de Acción -->
        <div class="col-md-12 text-end">
            <asp:Button ID="btnCancelar" runat="server" Text="CANCELAR" CssClass="btn btn-secondary me-2" OnClick="BtnCancelar_Click" />
            <asp:Button ID="btnLimpiar" runat="server" Text="LIMPIAR" CssClass="btn btn-warning me-2" OnClick="BtnLimpiar_Click"/>
            <asp:Button ID="btnGuardar" runat="server" Text="ELIMINAR" CssClass="btn btn-primary"  OnClick="BtnGuardar_Click" OnClientClick="return validarSeleccionProducto() && confirmarModificacion();"/>
        </div>
    </div>
</div>
</asp:Content>
