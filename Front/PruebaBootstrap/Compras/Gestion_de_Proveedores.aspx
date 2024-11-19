<%@ Page Title="Gestión de Proveedores" Language="C#" MasterPageFile="MV_GesPro.Master" AutoEventWireup="true" CodeBehind="Gestion_de_Proveedores.aspx.cs" Inherits="PruebaBootstrap.Gestion_de_Proveedores" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphCompras_Gestion_Proveedores" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Añadir Proveedor</h2>
            </div>
            <div class="card-body">
                <!-- Campo para RUC -->
                <div class="mb-3">
                    <asp:Label ID="lblRUC" runat="server" Text="RUC:" CssClass="col-form-label" />
                    <asp:TextBox ID="txtRUC" CssClass="form-control" runat="server" MaxLength="11" />
                </div>

                <!-- Campo para Razón Social -->
                <div class="mb-3">
                    <asp:Label ID="lblRazonSocial" runat="server" Text="Razón Social:" CssClass="col-form-label" />
                    <asp:TextBox ID="txtRazonSocial" CssClass="form-control" runat="server" />
                </div>

                <!-- Campo para Correo -->
                <div class="mb-3">
                    <asp:Label ID="lblCorreo" runat="server" Text="Correo Electrónico:" CssClass="col-form-label" />
                    <asp:TextBox ID="txtCorreo" CssClass="form-control" runat="server" TextMode="Email" />
                </div>
            </div>

            <div class="card-footer">
                <!-- Botón Guardar -->
                <asp:Button ID="btnGuardar" runat="server" Text="Guardar" CssClass="btn btn-primary float-end" OnClick="btnGuardar_Click"/>

                <!-- Botón Limpiar -->
                <asp:Button ID="btnLimpiar" runat="server" Text="Limpiar" CssClass="btn btn-primary float-end me-3" OnClick="btnLimpiar_Click" />

                <!-- Botón Regresar -->
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="btn btn-secondary float-start" OnClick="btnRegresar_Click" />
            </div>
        </div>
    </div>
</asp:Content>
