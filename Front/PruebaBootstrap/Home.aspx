<%@ Page Title="" Language="C#" MasterPageFile="~/MasterPrincipal.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="PruebaBootstrap.WebForm1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitle" runat="server">
    Inicio
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="cphContenidoHome" runat="server">
      <section class="py-5 text-center container">
  <div class="row py-lg-5">
    <div class="col-lg-6 col-md-8 mx-auto">
      <h1 class="fw-light">Bienvenido al sistema</h1>
      <p class="lead text-body-secondary">Presione en ventas para generar un pedido. Presione en Inventario para su gestión</p>
      <p>
        <a href="Ventas/Registrar_Pago.aspx" class="btn btn-primary my-2">Registrar Pago</a>
        <a href="Inventario/añadirProducto.aspx" class="btn btn-secondary my-2">Registrar Producto</a>
      </p>
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
                    <!--
                  <div class="col">
                    <div class="card shadow-sm">
                      <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
                      <div class="card-body">
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <div class="d-flex justify-content-between align-items-center">
                          <div class="btn-group">
                            <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                            <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                          </div>
                          <small class="text-body-secondary">9 mins</small>
                        </div>
                      </div>
                    </div>
                </div>

                  <div class="col">
                      <div class="card shadow-sm">
                        <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>
                        <div class="card-body">
                          <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                          <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                              <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                              <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                            </div>
                            <small class="text-body-secondary">9 mins</small>
                          </div>
                        </div>
                      </div>
                  </div>
                    -->

           </div>
      </div>
  </div>
</asp:Content>

