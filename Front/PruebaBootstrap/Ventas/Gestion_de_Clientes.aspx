
<%@ Page Title="" Language="C#" MasterPageFile="MV_GesCli.master" AutoEventWireup="true" CodeBehind="Gestion_de_Clientes.aspx.cs" Inherits="PruebaBootstrap.Gestion_de_Clientes" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphVentas_Gestion_Clientes" runat="server">
    <!-- contenido de gestion de clientes -->
    <!--<script src="<%= ResolveUrl("~/Scripts/gestion_clientes.js") %>"></script>-->
    <!--<script src="/Scripts/gestion_clientes.js"></script> -->
    <link href="/css/notificacion_exito.css" rel="stylesheet" type="text/css" />

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
                        <asp:TextBox ID="txtDOI" CssClass="form-control" runat="server"
                            onkeypress="return seIngresoNumero(event)" MaxLength="20"></asp:TextBox>
                    </div>
                    <div class="col-md-6 mb-3">
                        <asp:Label ID="lblTipoDOI" runat="server" Text="Tipo de DOI:" CssClass="col-form-label" />
                        <asp:RadioButtonList ID="rbTipoDOI" runat="server" RepeatDirection="Horizontal"
                            CellPadding="5" CssClass="form-control RadioButtonList"
                            OnChange="actualizarMaxLength()">
                            <asp:ListItem Value="PASAPORTE" Text="PASAPORTE" />
                            <asp:ListItem Value="DNI" Text="DNI" />
                            <asp:ListItem Value="RUC" Text="RUC" />
                        </asp:RadioButtonList>
                    </div>
                </div>

                <div class="col-md-12 mb-3">
                    <asp:Label ID="lblNombre" runat="server" Text="Nombre del contacto:" CssClass="col-form-label" />
                    <asp:TextBox ID="txtNombre" CssClass="form-control" runat="server"></asp:TextBox>
                </div>
                <div class="col-md-12 mb-3">
                    <asp:Label ID="lblCorreo" runat="server" Text="Correo Electronico:" CssClass="col-form-label" />
                    <asp:TextBox ID="txtCorreo" CssClass="form-control" runat="server"></asp:TextBox>
                </div>
                <div class="col-md-12 mb-3">
                    <asp:Label ID="lblTipoUsuario" runat="server" Text="Tipo de Usuario:" CssClass="col-form-label" />
                    <asp:RadioButtonList ID="rbTipoUsuario" runat="server" RepeatDirection="Horizontal" CellPadding="5" CssClass="form-control RadioButtonList">
                        <asp:ListItem Value="CLIENTE" Text="CLIENTE" />
                        <asp:ListItem Value="EMPRESA" Text="EMPRESA" />
                    </asp:RadioButtonList>
                </div>
                <div class="row mb-3">
                    <div class="col-md-6 mb-3">
                        <asp:Label ID="lblFechaRegistro" runat="server" Text="Fecha de Registro:" CssClass="col-form-label" />
                        <asp:TextBox ID="dtpFechaRegistro" runat="server" type="date" CssClass="form-control"></asp:TextBox>
                    </div>
                    <div class="col-md-6 mb-3">
                        <asp:Label ID="lblTelefono" runat="server" Text="Telefono de contacto:" CssClass="col-form-label" />
                        <asp:TextBox ID="txtTelefono" CssClass="form-control" 
                            runat="server" onkeypress="return seIngresoNumero(event)" MaxLength="9"></asp:TextBox>
                    </div>
                </div>

            </div>


            <div class="card-footer clearfix">
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar" 
                    CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
                
                <asp:Button ID="btnGuardar" runat="server" Text="Guardar"
                    CssClass="float-end btn btn-primary" OnClick="btnGuardar_Click"/>
                <asp:Button ID="btnLimpiar" runat="server" Text="Limpiar"
                    CssClass="float-end btn btn-primary me-3" OnClick="btnLimpiar_Click"/>
                
            </div>

            <div id="modalConfirmacion" class="modal">
                <div class="modal-content">
                    <p>Cliente registrado con éxito</p>
                    <div class="modal-buttons">
                        <asp:Button ID="btnRegresarInicio" runat="server" Text="Volver al inicio"
                            CssClass="modal-buttons mb-3" OnClick="btnRegresar_Click" />
                        <asp:Button ID="btnRegistrarOtroCliente" runat="server" Text="Registrar otro cliente"
                            CssClass="modal-buttons mb-3" OnClick="btnLimpiar_Click" />
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</asp:Content>
