<%@ Page Title="" Language="C#" MasterPageFile="~/MV_GesCli.master" AutoEventWireup="true" CodeBehind="Gestion_de_Clientes.aspx.cs" Inherits="PruebaBootstrap.Gestion_de_Clientes" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphVentas_Gestion_Clientes" runat="server">
    <!-- contenido de gestion de clientes -->
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Añadir Cliente
                </h2>
            </div>

            <div class="card-body">
                <div class="row mb-3">
                    <div class="col-md-6 mb-3">
                        <asp:Label ID="lblDOI" runat="server" Text="DOI:" CssClass="col-form-label" />
                        <asp:TextBox ID="txtDOI" CssClass="form-control" runat="server"></asp:TextBox>
                    </div>
                    <div class="col-md-6 mb-3">
                        <asp:Label ID="lblNombre" runat="server" Text="Nombre del contacto:" CssClass="col-form-label" />
                        <asp:TextBox ID="txtNombre" CssClass="form-control" runat="server"></asp:TextBox>
                    </div>
                </div>

                <div class="col-md-12 mb-3">
                    <asp:Label ID="lblRazonSocial" runat="server" Text="Razón Social:" CssClass="col-form-label" />
                    <asp:TextBox ID="txtRazonSocial" CssClass="form-control" runat="server"></asp:TextBox>
                </div>
                <div class="col-md-12 mb-3">
                    <asp:Label ID="lblDireccion" runat="server" Text="Direccion:" CssClass="col-form-label" />
                    <asp:TextBox ID="txtDireccion" CssClass="form-control" runat="server"></asp:TextBox>
                </div>

                <div class="row mb-3">
                    <div class="col-md-6 mb-3">
                        <asp:Label ID="lblCargoContacto" runat="server" Text="Cargo del contacto:" CssClass="col-form-label" />
                        <asp:TextBox ID="txtCargoContacto" CssClass="form-control" runat="server"></asp:TextBox>
                    </div>
                    <div class="col-md-6 mb-3">
                        <asp:Label ID="lblTelefono" runat="server" Text="Telefono de contacto:" CssClass="col-form-label" />
                        <asp:TextBox ID="txtTelefono" CssClass="form-control" runat="server"></asp:TextBox>
                    </div>
                </div>

            </div>


            <div class="card-footer clearfix">
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
                
                <asp:Button ID="btnGuardar" runat="server" Text="Guardar"
                    CssClass="float-end btn btn-primary" OnClick="btnGuardar_Click"/>
                <asp:Button ID="btnLimpiar" runat="server" Text="Limpiar"
                    CssClass="float-end btn btn-primary me-3" OnClick="btnLimpiar_Click"/>
                
            </div>

        </div>
    </div>
</asp:Content>
