package dao;

import entidade.Usuario;
import entidade.Telefone;
import entidade.Cliente;
import entidade.OS;
import entidade.OSServico;
import entidade.Servico;
import entidade.OSPeca;
import entidade.Funcionario;
import entidade.Peca;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Mateus Oliveira
 */
public class Main {

    public static void main(String[] args) {
        /*
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());

        s.beginTransaction();

        FornecedorTelefone franca = new FornecedorTelefone();
        franca.setNome("Franca");
        s.save(franca);

        FornecedorTelefone ibiraci = new FornecedorTelefone();
        ibiraci.setNome("Ibiraci");
        s.save(ibiraci);

        FornecedorTelefone guara = new FornecedorTelefone();
        guara.setNome("Guara");
        s.save(guara);
        s.flush();
        
        
        //////////////////////////////////////////////////////////////////////

        Usuario itauFranca = new Usuario();
        itauFranca.setNome("Itau Franca");
        itauFranca.setCidade(franca);
        s.save(itauFranca);

        Usuario bradescoIbiraci = new Usuario();
        bradescoIbiraci.setNome("Bradesco Ibiraci");
        bradescoIbiraci.setCidade(ibiraci);
        s.save(bradescoIbiraci);

        Usuario bbguara = new Usuario();
        bbguara.setNome("Banco do Brasil Guara");
        bbguara.setCidade(guara);
        s.save(bbguara);
        s.flush();
        //////////////////////////////////////////////////////////////////////

        Cliente clienteZe = new Cliente();
        clienteZe.setNome("Zé da Silva");
        clienteZe.setCpf("123.123.123-12");
        clienteZe.setCidade(franca);
        s.save(clienteZe);

        Cliente clienteJoao = new Cliente();
        clienteJoao.setNome("João Paulo");
        clienteJoao.setCpf("111.111.111-11");
        clienteJoao.setCidade(ibiraci);
        s.save(clienteJoao);

        Cliente clienteEstevan = new Cliente();
        clienteEstevan.setNome("Estevan");
        clienteEstevan.setCpf("111.111.111-11");
        clienteEstevan.setCidade(guara);
        s.save(clienteEstevan);
        s.flush();

        //////////////////////////////////////////////////////////////////////
        OS conta1 = new OS();
        conta1.setSaldo(3500);
        s.save(conta1);

        OS conta2 = new OS();
        conta2.setSaldo(2500);
        s.save(conta2);

        OS conta3 = new OS();
        conta3.setSaldo(1500);
        s.save(conta3);
        s.flush();
        //////////////////////////////////////////////////////////////////////
        Servico paulinho = new Servico();
        paulinho.setNome("Paulinho");
        s.save(paulinho);

        Servico joazinho = new Servico();
        joazinho.setNome("Joazinho");
        s.save(joazinho);

        Servico zezinho = new Servico();
        zezinho.setNome("Zezinho");
        s.save(zezinho);
        s.flush();
        
        ////////////////////////////////////////////////////
        Funcionario func1 = new Funcionario();
        func1.setNome("João");
        func1.setTelefone("111-2222");
        func1.setDtAdmissao(new Date());

        s.save(func1);

        Funcionario func2 = new Funcionario();
        func2.setNome("José");
        func2.setTelefone("111-2222");
        func2.setDtAdmissao(new Date());
        func2.setSuperisor(func2);
        s.save(func2);

        Funcionario func3 = new Funcionario();
        func3.setNome("Maria");
        func3.setTelefone("111-2222");
        func3.setDtAdmissao(new Date());
        s.save(func3);
        s.flush();
        //////////////////////////////////////////////////////////////////////

        Peca pag1 = new Peca();
        pag1.setData(null);
        pag1.setValor(1500);
        s.save(pag1);

        Peca pag2 = new Peca();
        pag2.setData(null);
        pag2.setValor(2500);
        s.save(pag2);

        Peca pag3 = new Peca();
        pag3.setData(null);
        pag3.setValor(3500);
        s.save(pag3);

        s.flush();
        //////////////////////////////////////////////////////////////////////

        Telefone joaoItauFranca = new Telefone();
        joaoItauFranca.setAgencia(itauFranca);
        joaoItauFranca.setFuncionario(func1);
        joaoItauFranca.setDtEntrada(new Date());
        joaoItauFranca.setDtSaida(new Date());
        s.save(joaoItauFranca);

        Telefone joseBradescoIbiraci = new Telefone();
        joseBradescoIbiraci.setAgencia(bradescoIbiraci);
        joseBradescoIbiraci.setFuncionario(func2);
        joseBradescoIbiraci.setDtEntrada(new Date());
        joaoItauFranca.setDtSaida(new Date());
        s.save(joseBradescoIbiraci);
//
        Telefone MariaBbGuara = new Telefone();
        MariaBbGuara.setAgencia(bbguara);
        MariaBbGuara.setFuncionario(func3);
        MariaBbGuara.setDtEntrada(new Date());
        MariaBbGuara.setDtSaida(new Date());
        s.save(MariaBbGuara);

        s.flush();
        //////////////////////////////////////////////////////////////////////

        OSServico cc1 = new OSServico();
        cc1.setClientes(clienteZe);
        cc1.setConta(conta1);
        cc1.setData(new Date());
        s.save(cc1);

        OSServico cc2 = new OSServico();
        cc2.setClientes(clienteJoao);
        cc2.setConta(conta2);
        cc2.setData(new Date());
        s.save(cc2);

        OSServico cc3 = new OSServico();
        cc3.setClientes(clienteEstevan);
        cc3.setConta(conta3);
        cc3.setData(new Date());
        s.save(cc3);
        s.flush();
//        
        
        
        ///////////////////////////////////////////////////       
        
        
         
       OSPeca emprest1 = new OSPeca();
        emprest1.setAgencia(bbguara);
        List<Cliente> lista_cliente1 = new ArrayList();
        lista_cliente1.add(clienteZe);
        emprest1.setClientes(lista_cliente1);
        s.save(emprest1);

        OSPeca emprest2 = new OSPeca();
        emprest2.setAgencia(bradescoIbiraci);
        List<Cliente> lista_cliente2 = new ArrayList();
        lista_cliente2.add(clienteZe);
        lista_cliente2.add(clienteEstevan);
        emprest2.setClientes(lista_cliente2);
        s.save(emprest2);

        OSPeca emprest3 = new OSPeca();
        emprest3.setAgencia(itauFranca);
        List<Cliente> lista_cliente3 = new ArrayList();
        lista_cliente3.add(clienteEstevan);
        lista_cliente3.add(clienteZe);
        emprest3.setClientes(lista_cliente3);
        s.save(emprest3);

        s.flush();
        //////////////////////////////////////////////////////////////////////   

//

//        fecha a sessao e grava
        s.getTransaction().commit();
        s.close();
*/
        
    }
}
