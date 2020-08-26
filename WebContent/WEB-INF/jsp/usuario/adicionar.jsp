<%-- 
    Document   : adicionar
    Created on : 22/07/2014, 17:02:32
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
        <h1>Adicionar Usuário</h1>
        
        <form action="${pageContext.request.contextPath}/usuarios/salvar" method="post">
            <table>
                <tr>
                    <td>
                        Nome:
                    </td>
                    <td>
                        <input type="text" name="usuario.nome"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Login:
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
            <a href="${pageContext.request.contextPath}/usuarios">Voltar</a>
        </p>
    </body>
</html>
