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
            <div id="cabecalho_Cadclientes"></div>
        </div>
        <div id="conteudo_fixo">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 20px;">
                <h1>Cadastro de Cliente</h1>
                <table id="cadastros">
                    <form method="POST" action="clientesNovoSalvar.jsp">
                        <tr>
                            <td>C�digo: </td>
                            <td><input type="number" name="codigo" disabled="true" /></td>
                        </tr>
                        <tr>
                            <td>Nome / Raz�o Social: </td>
                            <td><input type="text" name="nomeCompleto" style="width: 100%" /></td>
                        </tr>
                        <tr>
                            <td>CPF / CNPJ: </td>
                            <td><input type="text" name="cpf" /></td>
                        </tr>
                        <tr>
                            <td>RG / Inscr.Est.: </td>
                            <td><input type="text" name="rg" /></td>
                        </tr>
                        <tr>
                            <td>Endere�o: </td>
                            <td><input type="text" name="endereco" style="width: 100%" /></td>
                        </tr>
                        <tr>
                            <td>N�mero: </td>
                            <td><input type="text" name="numero" /></td>
                        </tr>
                        <tr>
                            <td>Bairro: </td>
                            <td><input type="text" name="bairro" /></td>
                        </tr>
                        <tr>
                            <td>CEP: </td>
                            <td><input type="text" name="cep" /></td>
                        </tr>
                        <tr>
                            <td>UF: </td>
                            <td><select name="uf" style="width: 173px" >
                                    <option></option>
                                    <option value="AC">AC</option>
                                    <option value="AL">AL</option>
                                    <option value="AP">AP</option>
                                    <option value="AM">AM</option>
                                    <option value="BA">BA</option>
                                    <option value="CE">CE</option>
                                    <option value="DF">DF</option>
                                    <option value="ES">ES</option>
                                    <option value="GO">GO</option>
                                    <option value="MA">MA</option>
                                    <option value="MT">MT</option>
                                    <option value="MS">MS</option>
                                    <option value="MG">MG</option>
                                    <option value="PA">PA</option>
                                    <option value="PB">PB</option>
                                    <option value="PR">PR</option>
                                    <option value="PE">PE</option>
                                    <option value="PI">PI</option>
                                    <option value="RH">RJ</option>
                                    <option value="RN">RN</option>
                                    <option value="RS">RS</option>
                                    <option value="RO">RO</option>
                                    <option value="RR">RR</option>
                                    <option value="SC">SC</option>
                                    <option value="SP">SP</option>
                                    <option value="SE">SE</option>
                                    <option value="TO">TO</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Cidade: </td>
                            <td><input type="text" name="cidade" /></td>
                        </tr>
                        <tr>
                            <td>E-mail: </td>
                            <td><input type="text" name="email" style="width: 100%" /></td>
                        </tr>
                        <tr>
                            <td>Telefone 1: </td>
                            <td><input type="text" name="telefone1ddd" size="5" maxlength="3" /> <input type="text" name="telefone1" maxlength="10" /></td>
                        </tr>
                        <tr>
                            <td>Telefone 2: </td>
                            <td><input type="text" name="telefone2ddd" size="5" maxlength="3" /> <input type="text" name="telefone2" maxlength="10" /></td>
                        </tr>
                        <tr>
                            <td>Telefone 3: </td>
                            <td><input type="text" name="telefone3ddd" size="5" maxlength="3" /> <input type="text" name="telefone3" maxlength="10" /></td>
                        </tr>
                        <tr>
                            <td>Observa��o: </td>
                            <td><textarea name="observacao" rows="3" cols="50"></textarea></td>
                        </tr>
                        <tr>
                            <td>Senha: </td>
                            <td><input type="text" name="senha"/></td>
                            <td>Repita a Senha: </td>
                            <td><input type="text" name="senha2"/></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <input type="submit"><img src="imagens/salvar.png" alt="Salvar" title="Salvar" /><input/> 
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
