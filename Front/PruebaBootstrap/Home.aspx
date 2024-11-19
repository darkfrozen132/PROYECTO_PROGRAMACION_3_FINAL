<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPrincipal.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="PruebaBootstrap.WebForm1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitle" runat="server">
    Inicio
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphContenidoHome" runat="server">
      <section class="py-5 text-center container">
  <div class="row py-lg-5">
    <div class="col-lg-6 col-md-8 mx-auto">
      <h1 class="fw-light">Bienvenido a TemuFans</h1>
    </div>
  </div>
</section>
 <!-- contenido del menu principal-->
<div class="album py-5 bg-body-tertiary">
      <div class="container">
            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
               
                <!-- elementos -->
                
                  <div class="col">
                    <div class="card shadow-sm">
                      <img src="/super_secret_settings/AlertasDeStock.jpg" class="card-img-top" alt="Descripción de la imagen" width="100%" height="225">
                      <div class="card-body">
                        <p class="card-text">Productos en alerta de stock</p>
                        <div class="d-flex justify-content-between align-items-center">
                          <div class="btn-group">
                            <button type="button" class="btn btn-sm btn-outline-secondary" onclick="window.location.href='/Inventario/AlertasDeStock.aspx'" >VER</button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                    
                  <div class="col">
                    <div class="card shadow-sm">
                      <img src="/super_secret_settings/ModificarPago.png" class="card-img-top" alt="Descripción de la imagen" width="100%" height="225">
                      <div class="card-body">
                        <p class="card-text">Pedidos pendientes de pago</p>
                        <div class="d-flex justify-content-between align-items-center">
                          <div class="btn-group">
                            <button type="button" class="btn btn-sm btn-outline-secondary" onclick="window.location.href='/Ventas/Registrar_Pago.aspx'" >VER</button>
                          </div>
                        </div>
                      </div>
                    </div>
                </div>
                        
                  <div class="col">
                      <div class="card shadow-sm">
                        <img src="/super_secret_settings/consultarStock.png" class="card-img-top" alt="Descripción de la imagen" width="100%" height="225">
                        <div class="card-body">
                          <p class="card-text">Consulta de stock</p>
                          <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                              <button type="button" class="btn btn-sm btn-outline-secondary" onclick="window.location.href='/Inventario/consultarStockProducto.aspx'" >VER</button>
                            </div>
                          </div>
                        </div>
                      </div>
                  </div>
                    

           </div>
      </div>
  </div>
</asp:Content>

