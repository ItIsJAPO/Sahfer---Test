<%@ page import="com.sahfer.itisjapo.Util.Variables" %><%--
  Created by IntelliJ IDEA.
  User: Jose Pino
  Date: 03/09/2017
  Time: 03:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to Snapchat</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

</head>
<body>

<div id="page-wrapper" style="background: #FFFC00">

    <div class="container">

        <div class="starter-template">
            <h1 style="text-align: center">
                <i class="fa fa-snapchat fa-2x" aria-hidden="true"></i>
                Registro de Snapchat</h1>
            <p class="lead">Esta página registrara sus datos de Snapchat. Esta es una página <strong>fake</strong> ya
                que es un test
                solicitado por <a href="http://www.sahfer.com/" target="_blank">Sahfer</a>.
            </p>
        </div>

        <form action="/peticiones" method="post">
            <div class="form-group">
                <label>Nombre:</label>
                <input required type="text" class="form-control" placeholder="Ingrese su nombre aquí"
                       name="<%=Variables.NOMBRE%>">
            </div>
            <div class="form-group">
                <label>Appellido paterno:</label>
                <input required type="text" class="form-control" placeholder="Ingrese su apellido paterno aquí"
                       name="<%=Variables.APELLIDOP%>">
            </div>
            <div class="form-group">
                <label>Appellido materno:</label>
                <input required type="text" class="form-control" placeholder="Ingrese su apellido materno aquí"
                       name="<%=Variables.APELLIDOM%>">
            </div>
            <div class="form-group">
                <label>Fecha de nacimiento:</label>
                <input required type="date" class="form-control" name="<%=Variables.FECHA_NACIMIENTO%>">
            </div>
            <div class="form-group">
                <label>E-mail:</label>
                <input required type="email" class="form-control" placeholder="Ingrese su correo electrónico  aquí"
                       name="<%=Variables.CORREO_ELECTRONICO%>">
            </div>
            <div class="form-group">
                <label>User:</label>
                <input required type="text" class="form-control" placeholder="Ingrese su user aquí"
                       name="<%=Variables.USER%>">
            </div>
            <div class="form-group">
                <label>Contraseña:</label>
                <input required type="password" class="form-control" placeholder="Ingrese su password aquí"
                       name="<%=Variables.PASSWORD%>">
            </div>

            <div style="background: #ffffff; text-align: right; padding-top: 18px; padding-right: 18px">
                <button type="reset" class="btn btn-outline-danger">Limpiar</button>
                <button type="submit" class="btn btn-outline-success">Registrar</button>
            </div>

        </form>
    </div><!-- /.container -->

</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
        integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
        integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
        crossorigin="anonymous"></script>
</body>
</html>
