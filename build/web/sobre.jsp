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
        <div id="cabecalho_fixo"></div>
        <div id="conteudo_fixo">
            <jsp:include page="menu_fixo.jsp" />
            <div style="float:left; margin-left: 22px;">
                <br />
                <b>Desenvolvido por:</b><br />
                Felipe Henrique Ziliotti<br />
                Marcos Rodrigo Belato<br />
                Mateus Ferreira Oliveira<br />
                Rafael Oliveira Fidelis<br /><br />
                <b>Disciplina:</b><br />
                Tópicos Especiais II - Prof. Me. Heitor Cunha<br /><br />
                <b>Curso:</b><br />
                Ciência da Computação - 2014 - 8º P<br />
            </div>
        </div>
        <div id="rodape_fixo">
            <jsp:include page="rodape.jsp" />    
        </div>
    </body>
</html>
