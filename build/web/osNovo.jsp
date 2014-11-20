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
        <div id="conteudo_fixo2">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 20px;">
                <h1>Cadastro de Ordem de Serviço</h1>
                <form method="POST" action="orcamentosNovoSalvar.jsp">
                    <table id="cadastros">                    
                        <tr>
                            <td>Número: </td>
                            <td><input type="number" name="numero" disabled="true" style="width:50%;" /></td>
                        </tr>
                        <tr>
                            <td>Cliente: </td>
                            <td>
                                <select id="comboboxCliente" name="consultaCliente" style="width:25%;">
                                    <option></option>
                                    <option>NOME</option>
                                    <option>CNPJ/CPF</option>
                                    <option>RG/IE</option>
                                </select>
                                <input type="text" name="cliente" style="width:55%;" />
                                <a href="#" title="Pesquisar"><img src="imagens/btn_pesquisar.png" alt="Pesquisar" title="Pesquisar"  id="botao_pesquisar" /></a>
                                <a href="#" title="Incluir Cliente"><img src="imagens/incluir.png" alt="Incluir Cliente" title="Incluir Cliente" id="botao_pesquisar" /></a>
                            </td>
                        </tr>
                        <tr>
                            <td>Defeito Apontado: </td>
                            <td><textarea name="defeitoApontado" rows="5" cols="75" style="width:100%;"></textarea></td>
                        </tr>
                        <tr>
                            <td>Serviço: </td>
                            <td>
                                <select id="comboboxServico" name="consultaServico" style="width:25%;">
                                    <option></option>
                                    <option>CÓDIGO</option>
                                    <option>DESCRIÇÃO</option>
                                    <option>VALOR</option>
                                </select>
                                <input type="text" name="servico" style="width:60%;" />
                                <a href="#" title="Incluir Serviço"><img src="imagens/incluir.png" alt="Incluir Serviço" title="Incluir Serviço" id="botao_pesquisar" /></a>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <table id="tabConsulta">
                                    <tr>
                                        <th style="width: 10%;">Código</th>
                                        <th style="width: 50%;">Serviço</th>
                                        <th style="width: 10%;">Hora</th>
                                        <th style="width: 15%;">Valor</th>
                                        <th style="width: 10%;">Ações</th>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Reparo na bomba de combustível </td>
                                        <td>01:00</td>
                                        <td>90,00</td>
                                        <td>
                                            <a href="#" title="Editar"><img src="imagens/editar.png" alt="Editar" title="Editar" /></a>
                                            <a href="#" title="Excluir"><img src="imagens/excluir.png" alt="Excluir" title="Excluir" /></a>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td>Peças: </td>
                            <td>
                                <select id="comboboxPeca" name="consultaServico" style="width:25%;">
                                    <option></option>
                                    <option>CÓDIGO</option>
                                    <option>DESCRIÇÃO</option>
                                    <option>VALOR</option>
                                </select>
                                <input type="text" name="peça" style="width:60%;" />
                                <a href="#" title="Incluir Peça"><img src="imagens/incluir.png" alt="Incluir Peça" title="Incluir Peça" id="botao_pesquisar" /></a>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <table id="tabConsulta">
                                    <tr>
                                        <th style="width: 10%;">Código</th>
                                        <th style="width: 50%;">Peça</th>
                                        <th style="width: 10%;">Qtde</th>
                                        <th style="width: 15%;">Valor</th>
                                        <th style="width: 10%;">Ações</th>
                                    </tr>
                                    <tr>
                                        <td>1</td>
                                        <td>Arruela</td>
                                        <td>10</td>
                                        <td>0,01</td>
                                        <td>
                                            <a href="#" title="Editar"><img src="imagens/editar.png" alt="Editar" title="Editar" /></a>
                                            <a href="#" title="Excluir"><img src="imagens/excluir.png" alt="Excluir" title="Excluir" /></a>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr style="text-align: right;"> 
                            <td>
                                <p align="right">
                                    % Conclusão: <input type="text" name="conclusao" size="10" style="background-color: #e4e4e4" style="width:25%;" /><br>
                                    Data Início: <input type="text" name="dtInicio" size="10" style="background-color: #e4e4e4" style="width:25%;" /><br>
                                </p>
                            </td>
                            <td>
                                Dias previstos para execução: <input type="text" title="Dias" name="diasExecucao" style="width:25%;" /> <br />
                                Desconto (%): <input type="text" title="Desconto %" name="desconto" style="width:25%;" /> <br />
                                Valor Total: <input type="text" title="Valor Total" name="vlTotal" style="width:25%;" /> <br />
                            </td>
                        </tr>
                    </table>
                    <table style="width:890px;">
                        <tr>
                            <td style="width: 500px;">
                                Histórico de eventos: <br />
                                <textarea name="historicoEventos" rows="5" cols="74" style="width:100%;" ></textarea>
                            </td>
                            <td style="width: 100px; text-align: center;">
                                % Conclusão: <input type="text" name="conclusao" size="10" style="background-color: #e4e4e4" />
                                <a href="#" title="Incluir"><img src="imagens/incluir.png" alt="Incluir" title="Incluir" /></a>
                                <a href="#" title="Limpar"><img src="imagens/limpar4.png" alt="Limpar" title="Limpar" /></a>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <table id="tabConsulta">
                                    <tr>
                                        <th style="width: 15%;">Usuário</th>
                                        <th style="width: 20%;">Data/Hora</th>
                                        <th style="width: 40%;">Observação</th>
                                        <th style="width: 15%;">% Concluído</th>
                                        <th style="width: 10%;">Ações</th>
                                    </tr>
                                    <tr>
                                        <td>Mecanico 1</td>
                                        <td>11/10/2014 08:50</td>
                                        <td>Feito o reparo na valvula da bomba de combustivel</td>
                                        <td>10%</td>
                                        <td>
                                            <a href="#" title="Editar"><img src="imagens/editar.png" alt="Editar" title="Editar" /></a>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <a href="#" title="Salvar"><img src="imagens/salvar.png" alt="Salvar" title="Salvar" /></a> 
                                <a href="#" title="Voltar"><img src="imagens/voltar.png" alt="Voltar" title="Voltar" /></a> 
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div id="rodape_fixo2">
            <jsp:include page="rodape.jsp" />    
        </div>
    </body>
</html>
