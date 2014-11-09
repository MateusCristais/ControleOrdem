<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Funcoes" scope="session" class="entidade.Funcoes" />
<%@page import="entidade.Funcoes"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trabalho Heitor</title>
    </head>
    <body>
        <h1>Logando...</h1>

        <%
            Funcoes funcoes = new Funcoes();
            String usuario = request.getParameter("usuario");
            String senha = request.getParameter("senha");

            if (funcoes.verificaLogin(usuario, senha) == true) {
                out.println("Logado!");

                session.setAttribute("logado", true);
                session.setAttribute("nome_user", funcoes.dadosLogin(usuario, senha));

                response.sendRedirect("menuprincipal.jsp");
            } else {
                out.println("Usuário e/ou Senha inválidos");
            }
        %>
        <br />
        <a href="index.jsp">Voltar</a>
    </body>
</html>
