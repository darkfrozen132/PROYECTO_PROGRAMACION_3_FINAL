<%@ Page Title="" Language="C#" MasterPageFile="MasterInventario.master" AutoEventWireup="true" CodeBehind="añadirProducto.aspx.cs" Inherits="PruebaBootstrap.añadirProducto" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphInventarioContenido" runat="server">
<div class="container">
    <h2>Registrar Producto</h2>
    <script type="text/javascript">
function validarSeleccionMarca() {
    var ddlMarca = document.getElementById('<%= ddlMarca.ClientID %>');
    if (ddlMarca.value === "0") {
        alert("Por favor, seleccione una marca válida.");
        return false; // Evita que el formulario se envíe
    }
    return true; // Permite el envío del formulario si se selecciona ua marca válida
}
    </script>

    <div class="row">
        <!-- ID de Pedido -->
        <div class="col-md-6">
            <div class="form-group">
                <label for="txtNombreProducto">NOMBRE DEL PRODUCTO:</label>
                <asp:TextBox ID="txtNombreProducto" runat="server" CssClass="form-control" placeholder="Ingrese el nombre del Producto" />
            </div>
        </div>
    </div>

    <div class="row mt-4">
        <!-- Selección de Estado con RadioButtons alineados -->
        <div class="col-md-6">
            <label>ESTADO DEL PRODUCTO:</label>
            <asp:RadioButtonList ID="rbEstado" runat="server" RepeatDirection="Horizontal" CellPadding="5" CssClass="form-control RadioButtonList">
                <asp:ListItem Value="ACTIVO" Text="ACTIVO" />
                <asp:ListItem Value="INACTIVO" Text="INACTIVO" />
               </asp:RadioButtonList>
        </div>
    </div>

    <div class="row">
        <!-- Precio -->
        <div class="col-md-6">
            <div class="form-group">
                <label for="txtPrecio">PRECIO DEL PRODUCTO:</label>
                <asp:TextBox ID="txtPrecio" runat="server" CssClass="form-control" placeholder="Ingrese el Precio del Producto" />
            </div>
        </div>
    </div>

    <div class="row">
        <!-- Marca -->
        <div class="col-md-6">
            <div class="form-group">
                <label for="txtMarca">MARCA:</label>
                <asp:DropDownList ID="ddlMarca" runat="server" AutoPostBack="true" CssClass="form-select"
                    OnSelectedIndexChanged="ddlMarca_SelectedIndexChanged"></asp:DropDownList>
                <!--
                <asp:TextBox ID="txtIdMarca" runat="server" CssClass="form-control" placeholder="Ingrese el ID Marca" />
                    -->
            </div>
        </div>
    </div>

    <div class="row mt-4">
        <!-- Botones de Acción -->
        <div class="col-md-12 text-end">
            <asp:Button ID="btnCancelar" runat="server" Text="CANCELAR" CssClass="btn btn-secondary me-2" OnClick="BtnCancelar_Click" />
            <asp:Button ID="btnLimpiar" runat="server" Text="LIMPIAR" CssClass="btn btn-warning me-2" OnClick="BtnLimpiar_Click"/>
            <asp:Button ID="btnGuardar" runat="server" Text="REGISTRAR" CssClass="btn btn-primary"  OnClick="BtnGuardar_Click" OnClientClick="return validarSeleccionMarca();"/>
        </div>
    </div>
</div>

</asp:Content>
