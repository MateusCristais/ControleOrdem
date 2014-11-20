<%@page import="entidade.Fornecedor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.FornecedorDao"%>
<%
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
                    window.location.href="fornecedores.jsp?palavra="+document.getElementById("campo_pesquisa").value;
                }else{
                    window.location.href="fornecedores.jsp?palavra=";
                }
            }
            
        </script>
        
        <div id="cabecalho_fixo">
            <div id="cabecalho_fornecedores"></div>
        </div>
        <div id="conteudo_fixo">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 20px;">
                <h1>Consulta de Fornecedores</h1>
                
                Digite parte do nome ou documento para a busca:
                <input type="text" id="campo_pesquisa" name="nomePesquisa" value=""/>
                <img src="imagens/btn_pesquisar.png" alt="Pesquisar" title="Pesquisar" onclick="pesquisar();" id="botao_pesquisar"/>

                </br>
                <a href="fornecedoresNovo.jsp?tipo=1" title="Incluir Novo"><img src="imagens/incluir.png" alt="Incluir Novo" title="Incluir Novo" /></a>

                </br>

                <table id="tabConsulta">
                    <tr>
                        <th style="width: 10%;">Código</th>
                        <th style="width: 55%;">Nome / Razão Social</th>
                        <th style="width: 25%;">CPF / CNPJ</th>
                        <th style="width: 10%;">Ações</th>
                    </tr>
                    <%
                    FornecedorDao usuarioDao = new FornecedorDao();
                    ArrayList<Fornecedor> listFornecedor = null;
                    if(!request.getParameter("palavra").equals(null)){
                        String s = request.getParameter("palavra");
                        listFornecedor = usuarioDao.getListFornecedor(s);
                    }else{
                        listFornecedor = usuarioDao.getListFornecedor("");
                    }
                    if(listFornecedor != null){
                        for (Fornecedor f : listFornecedor){
                        %>
                            <tr>
                                <td><%= f.getIdFornecedor()%></td>
                                <td><a href="fornecedoresNovo.jsp?tipo=2&codigo=<%= f.getIdFornecedor() %>&nomeCompleto=<%= f.getRazao() %>&fantasia=<%= f.getFantasia() %>&cpf=<%= f.getCpfCnpj()%>&ie=<%= f.getRgIe() %>&endereco=<%= f.getLogradouro() %>&numero=<%= f.getNumero() %>&bairro=<%= f.getBairro() %>&cep=<%= f.getCep() %>&cidade=<%= f.getCidade() %>&email=<%= f.getEmail() %>&obs=<%= f.getObs() %>&uf=<%= f.getUf() %>&telefone=<%= f.getTelefone() %>&celular=<%= f.getCelular() %>"><%= f.getRazao() %></a></td>
                                <td><%= f.getCpfCnpj()%></td>
                                <td>
                                    <a href="fornecedoresNovo.jsp?tipo=2&codigo=<%= f.getIdFornecedor() %>&nomeCompleto=<%= f.getRazao() %>&fantasia=<%= f.getFantasia() %>&cpf=<%= f.getCpfCnpj()%>&ie=<%= f.getRgIe() %>&endereco=<%= f.getLogradouro() %>&numero=<%= f.getNumero() %>&bairro=<%= f.getBairro() %>&cep=<%= f.getCep() %>&cidade=<%= f.getCidade() %>&email=<%= f.getEmail() %>&obs=<%= f.getObs() %>&uf=<%= f.getUf() %>&telefone=<%= f.getTelefone() %>&celular=<%= f.getCelular() %>">
                                        <img src="imagens/editar.png"  alt="Editar" title="Editar"/></a>
                                    <a href="FornecedorDeletar?codigo=<%= f.getIdFornecedor() %>">
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
