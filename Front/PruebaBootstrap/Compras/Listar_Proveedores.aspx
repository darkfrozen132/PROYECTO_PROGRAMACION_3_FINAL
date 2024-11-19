<%@ Page Title="Lista de Proveedores" Language="C#" MasterPageFile="MV_GesPro.Master" AutoEventWireup="true" CodeBehind="Listar_Proveedores.aspx.cs" Inherits="PruebaBootstrap.Listar_Proveedores" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphCompras_Gestion_Proveedores" runat="server">
<div class="container">
    <div class="card">
        <div class="card-header">
            <h2>Listar Proveedores</h2>
        </div>

        <div class="card-body">
            <!-- Filtros -->
            <div class="row mb-3">
                <div class="col-md-3">
                    <label for="txtRazonSocial">Razón Social</label>
                    <asp:TextBox ID="txtRazonSocial" runat="server" TextMode="Search" CssClass="form-control"></asp:TextBox>
                </div>

                <div class="col-md-3">
                    <label for="txtRUC">RUC</label>
                    <asp:TextBox ID="txtRUC" runat="server" TextMode="Search" CssClass="form-control"></asp:TextBox>
                </div>

                <div class="col-md-2">
                    <asp:Button ID="btnFiltrar" runat="server" CssClass="btn btn-primary mt-4" Text="Filtrar" OnClick="btnFiltrar_Click"/>
                </div>
            </div>

            <!-- GridView -->
            <asp:GridView ID="gvProveedores" runat="server" AutoGenerateColumns="False" CssClass="table table-striped" AllowPaging="true" PageSize="5" OnPageIndexChanging="gvProveedores_PageIndexChanging">
                <Columns>
                    <asp:BoundField DataField="RUC" HeaderText="RUC" />
                    <asp:BoundField DataField="RazonSocial" HeaderText="Razón Social" />
                    <asp:BoundField DataField="FechaRegistro" HeaderText="Fecha de Registro" DataFormatString="{0:dd/MM/yyyy}" />
                </Columns>
            </asp:GridView>
        </div>

        <div class="card-footer">
            <!-- Botón Imprimir -->
            <asp:Button ID="btnImprimir" CssClass="btn btn-success float-start" runat="server" Text="Imprimir" OnClientClick="window.print(); return false;" />
        </div>
    </div>
</div>
</asp:Content>

