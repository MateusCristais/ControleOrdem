<script src="jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
    var timeout = 500;
    var closetimer = 0;
    var ddmenuitem = 0;

    function jsddm_open()
    {
        jsddm_canceltimer();
        jsddm_close();
        ddmenuitem = $(this).find('ul').eq(0).css('visibility', 'visible');
    }
    function jsddm_close()
    {
        if (ddmenuitem)
            ddmenuitem.css('visibility', 'hidden');
    }

    function jsddm_timer()
    {
        closetimer = window.setTimeout(jsddm_close, timeout);
    }

    function jsddm_canceltimer()
    {
        if (closetimer)
        {
            window.clearTimeout(closetimer);
            closetimer = null;
        }
    }

    $(document).ready(function ()
    {
        $('#jsddm > li').bind('mouseover', jsddm_open);
        $('#jsddm > li').bind('mouseout', jsddm_timer);
    });

    document.onclick = jsddm_close;
</script>

<ul id="jsddm">
    <li><a title="Auxiliar">Auxiliar</a>
        <ul>
            <li><a href="menuprincipal.jsp" title="Menu Principal" target="_parent">Menu Principal</a></li>
            <li><a href="consultaOSCliente.jsp" title="Consulta Cliente" target="_parent">Consulta Cliente</a></li>
            <li><a href="sobre.jsp" title="Sobre" target="_parent">Sobre</a></li>
            <li><a href="sair.jsp" title="Sair" target="_parent">Sair</a></li>
        </ul>
    </li>
    <li><a title="Cadastros">Cadastros</a>
        <ul>
            <li><a href="clientes.jsp?palavra=" title="Clientes" target="_parent">Clientes</a></li>
            <li><a href="fornecedores.jsp?palavra=" title="Fornecedores" target="_parent">Fornecedores</a></li>
            <li><a href="funcionarios.jsp?palavra=" title="Funcionários" target="_parent">Funcionários</a></li>
            <li><a href="pecas.jsp?palavra=" title="Peças" target="_parent">Peças</a></li>
            <li><a href="servicos.jsp?palavra=" title="Serviços" target="_parent">Serviços</a></li>
        </ul>
    </li>
    <li><a title="Estoque">Estoque</a>
        <ul>
            <li><a href="entradamercadorias.jsp" title="Entrada de Mercadorias" target="_parent">Entrada de Mercadorias</a></li>
        </ul>
    </li>
    <li><a title="Ordem de Serviço">Ordem de Serviço</a>
        <ul>
            <li><a href="orcamentoos.jsp?palavra=" title="Orçamentos de Ordem de Serviço" target="_parent">Orçamentos</a></li>
            <li><a href="os.jsp?palavra=" title="Serviços" target="_parent">Ordens de Serviços</a></li>
        </ul>
    </li>
</ul>
<div class="clear"> </div>