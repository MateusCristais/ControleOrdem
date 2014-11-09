<%@page import="javax.swing.JOptionPane"%>
<%@page import="entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="dao.UsuarioDao"%>
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
    <%
        List<Usuario> listUsuario;
        try{
            request.getParameter("nome_pesquisa");
            if(!request.getParameter("nome_pesquisa").equals(null)){
                JOptionPane.showMessageDialog(null, request.getParameter("nome_pesquisa"));
            }else{
                JOptionPane.showMessageDialog(null, "coco");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não Atualizou");
        }
        
    %>
    <script>
        
        function exemplo() {
            
                                  

            
        }
    </script>
<!--var table = document.getElementById("tabConsulta");
            var nome = document.getElementById("campo_pesquisa").value;
            var row = table.insertRow(0);
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            var cell3 = row.insertCell(2);
            cell1.innerHTML = nome;
            cell2.innerHTML = nome;
            cell3.innerHTML = nome; --> 
    
    <head>
        <title>Ordem de Servicos | 4Comp</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="estilo.css">
    </head>

    <body id="corpo_fixo">
        <div id="cabecalho_fixo">
            <div id="cabecalho_clientes"></div>
        </div>
        <div id="conteudo_fixo">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 20px;">
                
                    <h1>Consulta de Clientes</h1>
                    <select id="combobox" name="consultaCliente">
                        <option></option>
                        <option>NOME</option>
                        <option>CNPJ/CPF</option>
                        <option>RG/IE</option>
                    </select>
                    
                    <form method="POST" action="clientesPesquisa.jsp">
                        <input type="text" id="campo_pesquisa" name="nome_pesquisa"/>
                        <img src="imagens/btn_pesquisar.png" alt="Pesquisar" title="Pesquisar"  id="botao_pesquisar" onClick="exemplo();"/>
                        <input type="submit" value="" id="botao_pesquisar" />
                    </form>
                    
                    <a href="clientesNovo.jsp" title="Incluir Novo">
                        <img src="imagens/incluir.png" alt="Incluir Novo" title="Incluir Novo" /></a>
                    <table id="tabConsulta">
                        <tr>
                            <th style="width: 10%;">Código</th>
                            <th style="width: 55%;">Nome / Razão Social</th>
                            <th style="width: 25%;">CPF / CNPJ</th>
                            <th style="width: 10%;">Ações</th>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
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
