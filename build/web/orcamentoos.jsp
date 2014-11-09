<%
    try {
        if (session.getAttribute("logado").equals(false)) {
            response.sendRedirect("index.jsp");
        }
    } catch (Exception e) {
        response.sendRedirect("index.jsp");
    }
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
        <div id="cabecalho_fixo">
            <div id="cabecalho_orcamentos"></div>
        </div>
        <div id="conteudo_fixo">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 20px;">
                <h1>Consulta de Orçamentos</h1>
                <select id="combobox">
                    <option></option>
                    <option>NÚMERO</option>
                    <option>DATA</option>
                    <option>CLIENTE</option>
                    <option>VALOR</option>
                </select>
                <input id="campo_pesquisa" />
                <a href="#" title="Pesquisar"><img src="imagens/btn_pesquisar.png" alt="Pesquisar" title="Pesquisar"  id="botao_pesquisar" /></a>
                <a href="orcamentoosNovo.jsp" title="Incluir Novo"><img src="imagens/incluir.png" alt="Incluir Novo" title="Incluir Novo" /></a>
                <table id="tabConsulta">
                    <tr>
                        <th style="width: 15%;">Número</th>
                        <th style="width: 15%;">Data</th>
                        <th style="width: 45%;">Cliente</th>
                        <th style="width: 15%;">Valor</th>
                        <th style="width: 10%;">Ações</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>10/10/2014</td>
                        <td>João da Silva Muniz</td>
                        <td>10,00</td>
                        <td>
                            <a href="#" title="Editar"><img src="imagens/editar.png" alt="Editar" title="Editar" /></a>
                            <a href="#" title="Excluir"><img src="imagens/excluir.png" alt="Excluir" title="Excluir" /></a>
                            <a href="#" title="Converte em OS"><img src="imagens/transfere.png" alt="Converte em OS" title="Converte em OS" /></a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div id="rodape_fixo">
            <jsp:include page="rodape.jsp" />    
        </div>
    </body>
</html>
