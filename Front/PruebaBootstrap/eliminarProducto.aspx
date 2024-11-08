<%@ Page Title="" Language="C#" MasterPageFile="~/MasterInventario.master" AutoEventWireup="true" CodeBehind="eliminarProducto.aspx.cs" Inherits="PruebaBootstrap.eliminarProducto" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphInventarioContenido" runat="server">
<div class="container">
    <h2>Eliminar Producto</h2>
    <div class="row">
        <!-- ID de Pedido -->
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
            <asp:Button ID="btnGuardar" runat="server" Text="ELIMINAR" CssClass="btn btn-primary"  OnClick="BtnGuardar_Click" />
        </div>
    </div>
</div>
</asp:Content>
