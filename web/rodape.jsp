<%@page import="java.text.Format"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<div id="rodape_versao">Versão 1</div>
<div id="rodape_usuario">Usuário: <% out.print(session.getAttribute("nome_user")); %></div>
<div id="rodape_horario">
    <%
        long hora = session.getCreationTime();
        Date agora = new Date(hora);
        Format formato = new SimpleDateFormat(
                "EEEE, dd 'de' MMMM 'de' yyyy ' - ' hh:mm:ss");
        String data_hora = formato.format(agora);
    %>
    <%=data_hora%>
</div>