<!DOCTYPE html>
<html>
    <head>
        <title>Ordem de Servicos | 4Comp</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="estilo.css">
    </head>
    <body id="corpo_login">
        <div id="cabecalho_login"></div>
        <div id="conteudo_login">
            <div id="campos_login">
                <form action="logar.jsp" method="POST">
                    <input type="text" name="usuario" id="usuario" maxlength="100" style="border: 1px solid #000; width: 250px; height: 25px; margin-bottom: 17px;" />
                    <br/>
                    <input type="password" name="senha" id="senha" maxlength="100" style="border: 1px solid #000; width: 250px; height: 25px; margin-bottom: 17px;" />
                    <div id="botao_login">
                        <input type="reset" value="" id="botao_limpar" />
                        <input type="submit" value="" id="botao_enviar" />
                    </div>
                </form>
            </div>
        </div>
        <div id="rodape_login"></div>
    </body>
</html>
