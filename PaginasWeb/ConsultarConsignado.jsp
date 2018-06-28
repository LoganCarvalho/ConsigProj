<%@page import="model.Bean.Consignado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Consignado Individual</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="js/bootstrap.min.js"></script>
        <link href="assets/css/custom.css" rel="stylesheet" />
        <style>
            /* Remove the navbar's default margin-bottom and rounded borders */ 
            .navbar {
                margin-bottom: 0;
                border-radius: 0;

            }
        </style>

        <title>Empregado</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse" style="min-height: 135px">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><img  src="Imagens/logoresized.png" alt=""> </a>
                </div>
                <div class="container" id="divMenuConsultarConsignado" style="padding-top: 1cm">
                    <ul class="nav navbar-nav">
                        <li> <a href="Inicio.jsp" style="color:#FFFFFF; font-size: x-large">Sobre</a></li>
                    </ul>
                </div>
                <ul class="nav navbar-nav navbar-right" style="padding-top: 0.5cm">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color:#FFFFFF; font-size: x-large">Colaborador</a>
                    <ul class="dropdown-menu">
                        <li><a href="Inicio.jsp"><span class="glyphicon glyphicon-log-out"></span>Sair</a></li>
                    </ul>   
                </ul>
            </div>
        </nav>
        <div class="jumbotron">
            <div class="container text-center">
                <p>Consultar Saldo</p>
            </div>
            <div class="container">
                <form action="ConsultarSaldoConsignado" method="post"> 
                    <% Consignado consigResp = (Consignado) request.getAttribute("consigResp");%>
                    <div class="form-group row">
                        <label for="txtCPF" class="col-sm-2 form-control-label">CPF do Funcionário</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" name="txtCPF">
                        </div>
                    </div>                                        
                    <div class="form-group row">
                        <label for="txtSaldoConsignado" class="col-sm-2 form-control-label">Valor Consignado</label>
                        <div class="col-sm-3">
                        <%if (consigResp != null) {%>   
                            <input type="text" class="form-control" readonly="true" value="<%=consigResp.getMargem()%>" name="txtSaldoConsignado">
                        <% } %>
                        </div>                         
                    </div>                    
                    <button type="submit" class="btn btn-warning">Consultar</button>
                </form>
            </div>
        </div>
        <footer class="container-fluid text-center">
            <p>SCE- Sistema Consulta Margem Consignado, Copyright © 2018 </p>
        </footer>
    </body>
</html>
