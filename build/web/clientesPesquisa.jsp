<%-- 
    Document   : clientePesquisa
    Created on : 05/11/2014, 20:49:05
    Author     : Mateus
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="dao.UsuarioDao"%>
<%@page import="java.util.List"%>
<%@page import="entidade.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            UsuarioDao uDao = new UsuarioDao();
            String nome = request.getParameter("nome_pesquisa");
            JOptionPane.showMessageDialog(null, nome);
            List<Usuario> listUsuario = uDao.getListUsuario(nome);
            
            request.setAttribute("list_cliente", listUsuario);
            response.sendRedirect("clientes.jsp");
        %>
    </body>
</html>
