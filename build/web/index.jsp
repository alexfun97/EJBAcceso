<%-- 
    Document   : index
    Created on : 22-nov-2017, 9:46:38
    Author     : skaynx
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <h1>Obtiene todos los Cantantes con EJB </h1>
        <form action="EJBServlet" method="POST">
            ID: <input type="number" name="ID"><br>
            Nombre: <input type="text" name="nombre"><br>
            Fecha nacimiento (xxxx-xx-xx): <input type="text" name="fechaNac"><br>
            Nacionalidad: <input type="text" name="nacionalidad"><br>
            Genero: <select name="genero">
                        <option value="1">Rap</option>
                        <option value="2">Trap</option>
                        <option value="3">Reggae</option>
                        <option value="4">Pop</option>
                    </select><br>
            <input type="submit" name="crud" value="Crear"/>
            <input type="submit" name="crud" value="Leer"/>
            <input type="submit" name="crud" value="Actualizar"/>
            <input type="submit" name="crud" value="Borrar"/>
        </form>
    </body>
</html>