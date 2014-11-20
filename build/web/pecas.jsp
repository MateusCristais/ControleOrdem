<%@page import="entidade.Peca"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.PecaDao"%>
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
                    window.location.href="pecas.jsp?palavra="+document.getElementById("campo_pesquisa").value;
                }else{
                    window.location.href="pecas.jsp?palavra=";
                }
            }
            
        </script>
        
        <div id="cabecalho_fixo">
            <div id="cabecalho_pecas"></div>
        </div>
        <div id="conteudo_fixo">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 20px;">
                <h1>Consulta de Peças</h1>
                
                Digite parte da descrição ou o codigo para a busca:
                <input type="text" id="campo_pesquisa" name="nomePesquisa" value=""/>
                <img src="imagens/btn_pesquisar.png" alt="Pesquisar" title="Pesquisar" onclick="pesquisar();" id="botao_pesquisar"/>

                </br>
                <a href="pecasNovo.jsp?tipo=1" title="Incluir Novo"><img src="imagens/incluir.png" alt="Incluir Novo" title="Incluir Novo" /></a>

                </br>

                <table id="tabConsulta">
                    <tr>
                        <th style="width: 10%;">Código</th>
                        <th style="width: 55%;">Descrição</th>
                        <th style="width: 25%;">Preço Sugerido</th>
                        <th style="width: 10%;">Ações</th>
                    </tr>
                    <%
                    PecaDao pecaDao = new PecaDao();
                    ArrayList<Peca> listPeca = null;
                    if(!request.getParameter("palavra").equals(null)){
                        String s = request.getParameter("palavra");
                        listPeca = pecaDao.getListPeca(s);
                    }else{
                        listPeca = pecaDao.getListPeca("");
                    }
                    if(listPeca != null){
                        for (Peca p : listPeca){
                        %>
                            <tr>
                                <td><%= p.getIdPeca() %></td>
                                <td><a href="pecasNovo.jsp?tipo=2&codigo=<%= p.getIdPeca() %>&descricao=<%= p.getDescricao() %>&referencia=<%= p.getReferencia() %>&preco=<%= p.getPreco() %>&saldo=<%= p.getSaldo() %>&fichatec=<%= p.getFichaTec() %>"><%= p.getDescricao() %></a></td>
                                <td><%= p.getReferencia() %></td>
                                <td>
                                    <a href="pecasNovo.jsp?tipo=2&codigo=<%= p.getIdPeca() %>&descricao=<%= p.getDescricao() %>&referencia=<%= p.getReferencia() %>&preco=<%= p.getPreco() %>&saldo=<%= p.getSaldo() %>&fichatec=<%= p.getFichaTec() %>">
                                        <img src="imagens/editar.png"  alt="Editar" title="Editar"/></a>
                                    <a href="PecasDeletar?codigo=<%= p.getIdPeca() %>">
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
