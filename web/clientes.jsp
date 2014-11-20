
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="dao.UsuarioDao"%>

<% //VERIFICA A SESSÃO
    try {
        if (session.getAttribute("logado").equals(false)) {
            response.sendRedirect("index.jsp");
        }
    } catch (Exception e) {
        response.sendRedirect("index.jsp");
    }
    
    //STRING VERIFICA PESQUISA
    String palavra = "";
%>



<!DOCTYPE html>
<html>
    <head>
        <title>Ordem de Servicos | 4Comp</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="estilo.css">
    </head>

    <body id="corpo_fixo">
        
        <script>
        
            function pesquisar(){
                
                if(document.getElementById("campo_pesquisa").value !== null){
                    window.location.href="clientes.jsp?palavra="+document.getElementById("campo_pesquisa").value;
                }else{
                    window.location.href="clientes.jsp?palavra=";
                }
            }
            
        </script>
    
        <div id="cabecalho_fixo">
            <div id="cabecalho_clientes"></div>
        </div>
        <div id="conteudo_fixo">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 20px;">
                
                    <h1>Consulta de Clientes</h1>
                    
                    Digite parte do nome ou documento para a busca:
                    <input type="text" id="campo_pesquisa" name="nomePesquisa" value=""/>
                    <img src="imagens/btn_pesquisar.png" alt="Pesquisar" title="Pesquisar" onclick="pesquisar();" id="botao_pesquisar"/>
                    
                    </br>
                    <a href="clientesNovo.jsp?tipo=1" title="Incluir Novo"><img src="imagens/incluir.png" alt="Incluir Novo" title="Incluir Novo" /></a>
                    
                    </br>
                    
                    <table id="tabConsulta">
                        <tr>
                            <th style="width: 10%;">Código</th>
                            <th style="width: 55%;">Nome / Razão Social</th>
                            <th style="width: 25%;">CPF / CNPJ</th>
                            <th style="width: 10%;">Ações</th>
                        </tr>
                        <%
                        UsuarioDao usuarioDao = new UsuarioDao();
                        ArrayList<Usuario> listUsuario = null;
                        if(!request.getParameter("palavra").equals(null)){
                            String s = request.getParameter("palavra");
                            listUsuario = usuarioDao.getListUsuario(s);
                        }else{
                            listUsuario = usuarioDao.getListUsuario("");
                        }
                        if(listUsuario != null){
                            for (Usuario u : listUsuario){
                            %>
                                <tr>
                                    <td><%= u.getIdUsuario()%></td>
                                    <td><a href="clientesNovo.jsp?tipo=2&codigo=<%= u.getIdUsuario() %>&nomeCompleto=<%= u.getNome() %>&cpf=<%= u.getCpfCnpj()%>&nomeUsuario=<%= u.getNomeUsuario() %>&rg=<%= u.getRgIe() %>&endereco=<%= u.getLogradouro() %>&numero=<%= u.getNumero() %>&bairro=<%= u.getBairro() %>&cep=<%= u.getCep() %>&cidade=<%= u.getCidade() %>&email=<%= u.getEmail() %>&obs=<%= u.getObs() %>&uf=<%= u.getUf() %>&telefone=<%= u.getTelefone() %>&celular=<%= u.getCelular() %>"><%= u.getNome()%></a></td>
                                    <td><%= u.getCpfCnpj()%></td>
                                    <td>
                                        <a href="clientesNovo.jsp?tipo=2&codigo=<%= u.getIdUsuario() %>&nomeCompleto=<%= u.getNome() %>&cpf=<%= u.getCpfCnpj()%>&nomeUsuario=<%= u.getNomeUsuario() %>&rg=<%= u.getRgIe() %>&endereco=<%= u.getLogradouro() %>&numero=<%= u.getNumero() %>&bairro=<%= u.getBairro() %>&cep=<%= u.getCep() %>&cidade=<%= u.getCidade() %>&email=<%= u.getEmail() %>&obs=<%= u.getObs() %>&uf=<%= u.getUf() %>&telefone=<%= u.getTelefone() %>&celular=<%= u.getCelular() %>">
                                            <img src="imagens/editar.png"  alt="Editar" title="Editar"/></a>
                                        <a href="UsuarioDeletar?codigo=<%= u.getIdUsuario() %>">
                                            <img src="imagens/excluir.png" alt="Excluir" title="Excluir"/></a>
                                    </td>
                                </tr>
                            <%
                            }
                        }
                        %>
                    </table>
            </div>
        </div>
        <div id="rodape_fixo">
            <jsp:include page="rodape.jsp" />    
        </div>
        
    </body>
</html>
