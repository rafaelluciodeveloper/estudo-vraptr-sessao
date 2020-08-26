<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Clientes</h1>
        
        <p>
            <a href="${pageContext.request.contextPath}/usuarios/adicionar">Adicionar</a>
        </p>
        
        <table border="1">
            <tr>
                <td>
                    Código
                </td>
                <td>
                    Nome
                </td>
                <td>
                    Login
                </td>
                <td>
                    Ações
                </td>
            </tr>        
            <c:forEach items="${usuarioList}" var="usuario">
                <tr>
                    <td>
                        ${usuario.id}
                    </td>
                    <td>
                        ${usuario.nome}
                    </td>
                    <td>
                        ${usuario.login}
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/usuarios/editar/${usuario.id}">Editar</a>
                        <a href="${pageContext.request.contextPath}/usuarios/excluir/${usuario.id}">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
