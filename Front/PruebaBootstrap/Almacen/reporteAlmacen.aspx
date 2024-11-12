<%@ Page Title="" Language="C#" MasterPageFile="~/Almacen/MasterAlmacen.master" AutoEventWireup="true" CodeBehind="reporteAlmacen.aspx.cs" Inherits="PruebaBootstrap.Almacen.reporteAlmacen" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphInventarioContenido" runat="server">
   <div class="container">
       <div class="card">
           <div class="card-header">
                <h2>CREACION DE REPORTES DE ALMACEN</h2>
           </div>

           <div class="card-body">

            <div class="d-flex flex-column flex-md-row p-4 gap-4 py-md-5 "> <!-- Esto hace que este centrado: align-items-center justify-content-center -->
              <div class="list-group" id="almacenesContainer" runat="server">
                  <!-- Botón para seleccionar o deseleccionar todos los almacenes -->
                        <asp:Button ID="btnSelectAll" runat="server" CssClass="btn btn-primary" Text="Seleccionar Todos" OnClick="btnSelectAll_Click" />

                  <!-- CheckBoxList para los almacenes -->
                        <asp:CheckBoxList ID="almacenesCheckBoxList" runat="server" CssClass="list-group" AutoPostBack="true" OnSelectedIndexChanged="almacenesCheckBoxList_SelectedIndexChanged">
                        </asp:CheckBoxList>

              </div>
            </div>

           </div>

           <div class="card-footer">
               <!-- Botón Imprimir -->
               <asp:Button ID="Button1" CssClass="btn btn-success float-start" runat="server" Text="Imprimir" OnClick="Button1_Click" />

           </div>

        </div>
    </div>
</asp:Content>
