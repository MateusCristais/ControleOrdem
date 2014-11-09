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
            <div id="cabecalho_Cadservicos"></div>
        </div>
        <div id="conteudo_fixo">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 20px;">
                <h1>Cadastro de Serviço</h1>
                <table id="cadastros">
                    <form method="POST" action="servicosNovoSalvar.jsp">
                        <tr>
                            <td>Código: </td>
                            <td><input type="number" name="codigo" disabled="true" /></td>
                        </tr>
                        <tr>
                            <td>Descrição: </td>
                            <td><input type="text" name="nomeCompleto" style="width: 100%" /></td>
                        </tr>
                        <tr>
                            <td>Preço Sugerido: </td>
                            <td><input type="number" name="valor" /></td>
                        </tr>
                        <tr>
                            <td>Ficha Técnica </td>
                            <td><textarea name="fichaTecnica" rows="3" cols="50"></textarea></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <a href="#" title="Salvar"><img src="imagens/salvar.png" alt="Salvar" title="Salvar" /></a> 
                                <a href="#" title="Voltar"><img src="imagens/voltar.png" alt="Voltar" title="Voltar" /></a> 
                            </td>
                        </tr>
                    </form>
                </table>
            </div>
        </div>
        <div id="rodape_fixo">
            <jsp:include page="rodape.jsp" />    
        </div>
    </body>
</html>
