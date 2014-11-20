<%@page import="entidade.Servico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ServicoDao"%>
<%@page import="dao.ServicoDao"%>
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
                    window.location.href="servicos.jsp?palavra="+document.getElementById("campo_pesquisa").value;
                }else{
                    window.location.href="servicos.jsp?palavra=";
                }
            }
            
        </script>
        
        <div id="cabecalho_fixo">
            <div id="cabecalho_servicos"></div>
        </div>
        <div id="conteudo_fixo">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 20px;">
                <h1>Consulta de Serviços</h1>
                
                Digite parte da descrição ou o codigo para a busca:
                <input type="text" id="campo_pesquisa" name="nomePesquisa" value=""/>
                <img src="imagens/btn_pesquisar.png" alt="Pesquisar" title="Pesquisar" onclick="pesquisar();" id="botao_pesquisar"/>

                </br>
                <a href="servicosNovo.jsp?tipo=1" title="Incluir Novo"><img src="imagens/incluir.png" alt="Incluir Novo" title="Incluir Novo" /></a>

                </br>

                <table id="tabConsulta">
                    <tr>
                        <th style="width: 10%;">Código</th>
                        <th style="width: 55%;">Descrição</th>
                        <th style="width: 25%;">Preço Sugerido</th>
                        <th style="width: 10%;">Ações</th>
                    </tr>
                    <%
                    ServicoDao servicoDao = new ServicoDao();
                    ArrayList<Servico> listServico = null;
                    if(!request.getParameter("palavra").equals(null)){
                        String s = request.getParameter("palavra");
                        listServico = servicoDao.getListServico(s);
                    }else{
                        listServico = servicoDao.getListServico("");
                    }
                    if(listServico != null){
                        for (Servico s : listServico){
                        %>
                            <tr>
                                <td><%= s.getIdServico() %></td>
                                <td><a href="servicosNovo.jsp?tipo=2&codigo=<%= s.getIdServico() %>&descricao=<%= s.getDescricao() %>&precoSujerido=<%= s.getPrecoSujerido() %>&fichatec=<%= s.getFichaTec() %>"><%= s.getDescricao() %></a></td>
                                <td><%= s.getPrecoSujerido() %></td>
                                <td>
                                    <a href="servicosNovo.jsp?tipo=2&codigo=<%= s.getIdServico() %>&descricao=<%= s.getDescricao() %>&precoSujerido=<%= s.getPrecoSujerido() %>&fichatec=<%= s.getFichaTec() %>">
                                        <img src="imagens/editar.png"  alt="Editar" title="Editar"/></a>
                                    <a href="servicosDeletar?codigo=<%= s.getIdServico() %>">
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
