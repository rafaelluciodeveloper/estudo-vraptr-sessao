<%-- 
    Document   : login
    Created on : 29/07/2014, 20:33:11
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${pageContext.request.contextPath}/autenticar" method="post">
            <table>
                <tr>
                    <td>
                        Usuário:
                    </td>
                    <td>
                        <input type="text" name="usuario.login"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Senha:
                    </td>
                    <td>
                        <input type="password" name="usuario.senha"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        
                    </td>
                    <td>
                        <input type="submit" value="Enviar"/>
                    </td>
                </tr>
            </table>
        </form>
            <p>
                ${error}
            </p>
    </body>
</html>
