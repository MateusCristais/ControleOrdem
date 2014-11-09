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
            <div id="cabecalho_entradaMercadoria"></div>
        </div>
        <div id="conteudo_fixo">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 20px;">
                <h1>Consulta de Entrada de Mercadorias</h1>
                <select id="combobox">
                    <option></option>
                    <option>Nota Fiscal</option>
                    <option>Data</option>
                    <option>Fornecedor</option>
                    <option>Valor</option>
                </select>
                <input id="campo_pesquisa" />
                <a href="#" title="Pesquisar"><img src="imagens/btn_pesquisar.png" alt="Pesquisar" title="Pesquisar"  id="botao_pesquisar" /></a>
                <a href="entradamercadoriasNovo.jsp" title="Incluir Novo"><img src="imagens/incluir.png" alt="Incluir Novo" title="Incluir Novo" /></a>
                <table id="tabConsulta">
                    <tr>
                        <th style="width: 20%;">Nota Fiscal</th>
                        <th style="width: 20%;">Data</th>
                        <th style="width: 30%;">Fornecedor</th>
                        <th style="width: 20%;">Valor</th>
                        <th style="width: 10%;">Ações</th>
                    </tr>
                    <tr>
                        <td>1123</td>
                        <td>10/10/2014</td>
                        <td>João da Silva ME - EPP - LTDA - S/A</td>
                        <td>12.000,00</td>
                        <td>
                            <a href="#" title="Editar"><img src="imagens/editar.png" alt="Editar" title="Editar" /></a>
                            <a href="#" title="Excluir"><img src="imagens/excluir.png" alt="Excluir" title="Excluir" /></a>
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
