<%@ Page Title="" Language="C#" MasterPageFile="~/MasterInventario.master" AutoEventWireup="true" CodeBehind="modificarProducto.aspx.cs" Inherits="PruebaBootstrap.modificarProducto" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphInventarioContenido" runat="server">
        <h2>Modificar Producto</h2>
    <div class="row">
        <!-- ID de Pedido -->
        <div class="col-md-6">
            <div class="form-group">
                <label for="txtNombreProducto">Nombre del Producto:</label>
                <asp:TextBox ID="txtNombreProducto" runat="server" CssClass="form-control" placeholder="Modifique el nombre del Producto" />
            </div>
        </div>
    </div>

    <div class="row mt-4">
        <!-- Selección de Estado con RadioButtons alineados -->
        <div class="col-md-6">
            <label>Modifique el Estado del Producto:</label>
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
                <label for="txtPrecio">Precio del Producto:</label>
                <asp:TextBox ID="txtPrecio" runat="server" CssClass="form-control" placeholder="Modifique el Precio del Producto" />
            </div>
        </div>
    </div>

    <div class="row">
        <!-- Marca -->
        <div class="col-md-6">
            <div class="form-group">
                <label for="txtIdProducto">ID Producto:</label>
                <asp:TextBox ID="txtIdProducto" runat="server" CssClass="form-control" placeholder="Ingrese el ID Producto" />
            </div>
        </div>
    </div>

    <div class="row mt-4">
        <!-- Botones de Acción -->
        <div class="col-md-12 text-end">
            <asp:Button ID="btnCancelar" runat="server" Text="Cancelar" CssClass="btn btn-secondary me-2" OnClick="BtnCancelar_Click" />
            <asp:Button ID="btnLimpiar" runat="server" Text="Limpiar" CssClass="btn btn-warning me-2" OnClick="BtnLimpiar_Click"/>
            <asp:Button ID="btnGuardar" runat="server" Text="Modificar" CssClass="btn btn-primary"  OnClick="BtnGuardar_Click" />
        </div>
    </div>
</div>
</asp:Content>
