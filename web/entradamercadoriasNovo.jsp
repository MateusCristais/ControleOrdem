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
            <div id="cabecalho_CadentradaMercadorias"></div>
        </div>
        <div id="conteudo_fixo">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 20px;">
                <h1>Cadastro de Entrada de Mercadoria</h1>
                <table id="cadastros">
                    <form method="POST" action="entradamercadoriasNovoSalvar.jsp">
                        <tr>
                            <td>Nota Fiscal: </td>
                            <td><input type="number" name="notaFiscal" style="width:50%;"/></td>
                        </tr>
                        <tr>
                            <td>Fornecedor: </td>
                            <td><select name="fornecedor" style="width:50%;"> 
                                    <option></option>
                                    <option>Fornecedor 1</option>
                                    <option>Fornecedor 2</option>
                                    <option>Fornecedor 3</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Data: </td>
                            <td><input type="date" name="data" /></td>
                        </tr>
                        <tr>
                            <td>Itens: </td>
                            <td id="centralizados">
                                <select name="tipoItem" style="width:48%;">
                                    <option></option>
                                    <option>Código</option>
                                    <option>Descrição</option>
                                </select>
                                <input type="text" name="pesquisaItem" style="width:51%;" />
                                Quantidade: <input type="number" name="qtde" value="1" style="width:25%;" />
                                Valor Unitário: <input type="number" name="qtde" style="width:25%;" />
                                <a href="#" title="Incluir Item"><img src="imagens/incluir.png" id="incluir" alt="Incluir Item" title="Incluir Item" /></a>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <table id="tabConsulta">
                                    <tr>
                                        <th style="width: 5%;">Item</th>
                                        <th style="width: 10%;">Código</th>
                                        <th style="width: 35%;">Descrição</th>
                                        <th style="width: 10%;">Qtde</th>
                                        <th style="width: 15%;">Vl. Unit.</th>
                                        <th style="width: 15%;">Vl. Total</th>
                                        <th style="width: 10%;">Ações</th>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>123</td>
                                        <td>Arruela</td>
                                        <td>10</td>
                                        <td>0,01</td>
                                        <td>0,10</td>
                                        <td>
                                            <a href="#" title="Editar"><img src="imagens/editar.png" alt="Editar" title="Editar" /></a>
                                            <a href="#" title="Excluir"><img src="imagens/excluir.png" alt="Excluir" title="Excluir" /></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="7"><p align="right"><b>Total: R$ 0,10</b></p></td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td>Observação: </td>
                            <td><textarea name="observacao" rows="5" cols="70" style="width:100%;"></textarea></td>
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
