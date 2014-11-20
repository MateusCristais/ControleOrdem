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
        
        <script>
            function formatar(mascara, documento){
                var i = documento.value.length;
                var saida = mascara.substring(0,1);
                var texto = mascara.substring(i);
                
                if(texto.substring(0,1) != saida){
                    documento.value += texto.substring(0,1);
                }
            }
        </script>
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
                    <form method="POST" action="ServicoSalvar.jsp?tipo=${param.tipo}&codigo=${param.codigo}">
                        <tr><td style="color:red">${mensagem}</td></tr>
                        <input type="hidden" id="tipo" name="tipo" value="${param.tipo}" disabled="true" />
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">Código: </td>
                            <td><input type="number" name="codigo" disabled="true" style="width:50%;"/></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">Descrição: </td>
                            <td><input type="text" name="descricao" style="width: 100%" /></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">Preço Sugerido: </td>
                            <td><input type="number" name="preco" style="width:25%;"/></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">Ficha Técnica: </td>
                            <td><textarea name="fichaTecnica" rows="5" cols="50" style="width:100%;"></textarea></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div>
                                    <a href="servicos.jsp?palavra=" title="Voltar"><img src="imagens/voltar.png" alt="Voltar" title="Voltar" /></a>
                                    <input type="submit" value="" id="botao_salvar" />
                                </div>
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
