<%@ Page Title="" Language="C#" MasterPageFile="~/Almacen/MasterAlmacen.master" AutoEventWireup="true" CodeBehind="reporteAlmacen.aspx.cs" Inherits="PruebaBootstrap.Almacen.reporteAlmacen" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphInventarioContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>CREACIÓN DE REPORTES DE ALMACÉN</h2>
            </div>

            <div class="card-body">
                <div class="d-flex flex-column flex-md-row p-4 gap-4 py-md-5">
                    <!-- Contenedor de almacenes -->
                    <div class="list-group" id="almacenesContainer" runat="server">
                        <asp:Button ID="btnSelectAll" runat="server" CssClass="btn btn-primary" Text="Seleccionar Todos" OnClick="btnSelectAll_Click" />
                        <asp:CheckBoxList ID="almacenesCheckBoxList" runat="server" CssClass="list-group" AutoPostBack="true" OnSelectedIndexChanged="almacenesCheckBoxList_SelectedIndexChanged">
                        </asp:CheckBoxList>
                    </div>
                </div>

                <!-- Mensaje de alerta para errores -->
                <asp:Label ID="lblMensaje" runat="server" CssClass="alert alert-danger" Visible="false"></asp:Label>
            </div>

            <div class="card-footer">
                <!-- Botón Imprimir -->
                <asp:Button ID="Button1" CssClass="btn btn-success float-start" runat="server" Text="Generar Reporte" OnClick="Button1_Click" />
            </div>
        </div>
    </div>
</asp:Content>
