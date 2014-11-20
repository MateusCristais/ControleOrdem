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
            
            function verificar(){
                var senha1 = document.getElementById("senha").value;
                var senha2 = document.getElementById("senha2").value;
                
                if(senha1 != senha2){
                    alert("Senhas diferentes, verifique!");
                }
            }
        </script>
        
    </head>
    <body id="corpo_fixo">
        <div id="cabecalho_fixo">
            <div id="cabecalho_Cadfuncionarios"></div>
        </div>
        <div id="conteudo_fixo">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 20px;">
                <h1>Cadastro de Funcionário</h1>
                <table id="cadastros">
                    <form method="POST" action="FuncionarioSalvar?tipo=${param.tipo}&codigo=${param.codigo}">
                        <tr><td style="color:red">${mensagem}</td></tr>
                        <input type="hidden" id="tipo" name="tipo" value="${param.tipo}" disabled="true" />
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">Código: </td>
                            <td><input type="number" id="codigo" name="codigo" value="${param.codigo}" disabled="true" /></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" width="500"  id="textoIdentificador">Nome / Razão Social: </td>
                            <td><input type="text" required="required" name="nomeCompleto" id="nomeCompleto" value="${param.nomeCompleto}" style="width: 100%" /></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">CPF / CNPJ: </td>
                            <td><input type="text" required="required" maxlength="14" onkeypress="formatar('###.###.###-##', this)" name="cpf" value="${param.cpf}" /></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador" width="300" >Nome de usuário: </td>
                            <td><input type="text" required="required" maxlength="120" name="nomeUsuario" value="${param.nomeUsuario}" style="width: 100%" /></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">Senha: </td>
                            <td><input type="password" required="required" name="senha" id="senha"/></td>
                            <td  style="text-align: right" id="textoIdentificador" width="350">Repita a Senha: </td>
                            <td><input type="password" required="required" name="senha2" id="senha2" onchange="verificar()"/></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">RG / Inscr.Est.: </td>
                            <td><input type="text" name="rg" value="${param.rg}"/></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">Endereço: </td>
                            <td><input type="text" name="endereco" value="${param.endereco}" required="required" style="width: 100%" /></td>
                            <td style="text-align: right" id="textoIdentificador">Número: </td>
                            <td><input type="text" required="required" maxlength="5" pattern="[0-9]+$" name="numero" value="${param.numero}" width="25"/></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">Bairro: </td>
                            <td><input type="text" name="bairro" value="${param.bairro}" required="required"/></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">CEP: </td>
                            <td><input type="text" required="required" value="${param.cep}" maxlength="10" onkeypress="formatar('##.###-###', this)" pattern="[0-9]{2}\.[0-9]{3}\-[0-9]{3}$" name="cep" /></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">UF: </td>
                            <td><select name="uf" required="required" style="width: 173px" >
                                    <option selected="selected" value="${param.uf}">${param.uf}</option>
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
                            <td style="text-align: right" id="textoIdentificador">Cidade: </td>
                            <td><input type="text" required="required" name="cidade" value="${param.cidade}"/></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">E-mail: </td>
                            <td><input type="text" required="required" name="email" style="width: 100%" value="${param.email}"/></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">Telefone: </td>
                            <td><input type="numeric" name="telefone" value="${param.telefone}" maxlength="12" onkeypress="formatar('## ####-####', this)"/></td>
                            <td style="text-align: right" id="textoIdentificador">Celular: </td>
                            <td><input type="numeric" name="celular" value="${param.celular}" maxlength="14" onkeypress="formatar('## # ####-####', this)"/></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">Perfil: </td>
                            <td> <select name="perfil" style="width:50%;">
                                    <option></option>
                                    <option value="Administrador">Administrador</option>
                                    <option value="Estoque">Estoque</option>
                                    <option value="Mecânico">Mecânico</option>
                                    <option value="Vendedor">Vendedor</option>
                                </select></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">Salário: </td>
                            <td><input type="text" required="required" name="salario" value="${param.salario}"/></td>
                        </tr>
                        <tr>
                            <td style="text-align: right" id="textoIdentificador">Observação: </td>
                            <td><textarea name="obs" value="${param.obs}" rows="5" cols="27">${param.obs}</textarea></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <div>
                                    <a href="funcionarios.jsp?palavra=" title="Voltar"><img src="imagens/voltar.png" alt="Voltar" title="Voltar" /></a>
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
