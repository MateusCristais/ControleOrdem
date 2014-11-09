<%-- 
    Document   : clientesNovoSalvar
    Created on : 07/11/2014, 09:00:05
    Author     : Mateus
--%>

<%@page import="dao.UsuarioDao"%>
<%@page import="dao.ClienteDao"%>
<%@page import="entidade.Cliente"%>
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
            Cliente cliente = new Cliente();
            Usuario usuario = new Usuario();
            usuario.setBairro(request.getParameter("bairro"));
            usuario.setCidade(request.getParameter("cidade"));
            usuario.setCpfCnpj(request.getParameter("cpf"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setLogradouro(request.getParameter("endereco"));
            usuario.setNome(request.getParameter("nomeCompleto"));
            usuario.setRgIe(request.getParameter("rg"));
            usuario.setNumero(Integer.parseInt(request.getParameter("numero")));
            usuario.setSenha(request.getParameter("nomeCompleto"));
            usuario.setUf(request.getParameter("uf"));
            cliente.setObs(request.getParameter("observacao"));
            cliente.setUsuario(usuario);
            
            ClienteDao clienteDao = new ClienteDao();
            clienteDao.salvaUser(cliente);
            
            response.sendRedirect("clientes.jsp");
        %>
    </body>
</html>
