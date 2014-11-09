<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.Format"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Consulta de Ordem de Servicos | 4Comp</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="estilo.css">
    </head>

    <body id="corpo_fixo">
        <div id="cabecalho_fixo"></div>
        <div id="conteudo_fixo">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 20px;">
                <%
                    long hora = session.getCreationTime();
                    Date agora = new Date(hora);
                    Format formato = new SimpleDateFormat(
                            "EEEE, dd 'de' MMMM 'de' yyyy ' - ' hh:mm:ss");
                    String data_hora = formato.format(agora);
                %>
                <br /><b>Data da consulta: </b><%=data_hora%>
                <div style="width: 400px; text-align: right;">
                    <form method="POST" action="consultaOSClienteBD.jsp">
                        <table>
                            <tr>
                                <td>
                                    CPF/CNPJ: <input type="number" name="cpf_cnpj" /> <br />
                                    N�mero OS: <input type="number" name="nroOs" /> <br />
                                </td>
                                <td>
                                    <input type="submit" value="Consultar" style="width:100px; height: 70px;">
                                </td>
                            </tr>
                        </table>
                        <p align="center">
                            Descri��o do Servi�o: <br />
                        </p>
                        <table id="tabConsulta">
                            <tr>
                                <th style="width: 70%;">Servi�o</th>
                                <th style="width: 30%;">Funcion�rio</th>
                            </tr>
                            <tr>
                                <td>Troca do paralama</td>
                                <td>Jo�o da Graxa</td>
                            </tr>
                        </table>
                        <p align="center">
                            Itens do Servi�o: <br />
                        </p>
                        <table id="tabConsulta">
                            <tr>
                                <th style="width: 20%;">Item</th>
                                <th style="width: 60%;">Descri��o</th>
                                <th style="width: 20%;">Qtde</th>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>Arruela 30/1</td>
                                <td>10</td>
                            </tr>
                        </table>
                        <p align="right">
                            Percentual de Conclus�o: <input type="text" name="conclusao" size="10" disabled="true" />
                        </p>
                        <p align="center">
                            <button type="button" onClick="parent.location = 'http://www.nfe.fazenda.gov.br/portal/consulta.aspx?tipoConsulta=completa&tipoConteudo=XbSeqxE8pl8='">Visualizar Nota Fiscal</button>
                            <button type="button" onclick="window.print();">Imprimir</button>
                            <button type="button" onclick="window.close();">Fechar</button>
                        </p>
                    </form>


                </div>
            </div>
        </div>
    </body>
</html>
