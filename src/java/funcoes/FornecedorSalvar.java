package funcoes;

import dao.FornecedorDao;
import entidade.Fornecedor;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mateus
 */
@WebServlet(urlPatterns = {"/FornecedorSalvar"})
public class FornecedorSalvar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        //PREENCHO O USUÁRIO
        Fornecedor fornecedor = new Fornecedor();
        if(request.getParameter("codigo") != null){
            if(!request.getParameter("codigo").equalsIgnoreCase(""))
            {
                fornecedor.setIdFornecedor(Integer.parseInt(request.getParameter("codigo")));
            }else{
                fornecedor.setIdFornecedor(null);
            }
        }
        fornecedor.setBairro(request.getParameter("bairro"));
        fornecedor.setCidade(request.getParameter("cidade"));
        fornecedor.setCpfCnpj(request.getParameter("cpf"));
        fornecedor.setRgIe(request.getParameter("rg"));
        fornecedor.setEmail(request.getParameter("email"));
        fornecedor.setLogradouro(request.getParameter("endereco"));
        fornecedor.setRazao(request.getParameter("nomeCompleto"));
        fornecedor.setFantasia(request.getParameter("fatesia"));
        fornecedor.setRgIe(request.getParameter("rg"));
        fornecedor.setNumero(Integer.parseInt(request.getParameter("numero")));
        fornecedor.setUf(request.getParameter("uf"));
        fornecedor.setTelefone(request.getParameter("telefone"));
        fornecedor.setCelular(request.getParameter("celular"));
        fornecedor.setCep(request.getParameter("cep"));
        fornecedor.setObs(request.getParameter("obs"));

        Fornecedor fornecedorBusca = new Fornecedor();
        FornecedorDao fornecedorDao = new FornecedorDao();

        //VERIFICA TIPO: 
        //2 - ATUALIZAÇÃO 
        int tipo = 0;
        if(request.getParameter("tipo") != null){
            tipo = Integer.parseInt(request.getParameter("tipo"));
        }
        if(tipo == 2){
            fornecedorDao = new FornecedorDao();
            fornecedorDao.atualizaFornecedor(fornecedor);
            response.sendRedirect("clientes.jsp?palavra=");

        //1 - INCLUSÃO    
        }else{
            //VERIFICA USUÁRIO DOCUMENTO
            fornecedorDao = new FornecedorDao();
            fornecedorBusca = fornecedorDao.getFornecedorDoc(fornecedor.getCpfCnpj());
            if(fornecedorBusca != null){
                request.setAttribute("mensagem", " Número de documento já existente!");
                RequestDispatcher rd = request.getRequestDispatcher("fornecedoresNovo.jsp");
                rd.forward(request, response);
            }else{
                //SALVA USUÁRIO
                fornecedorDao.salvaFornecedor(fornecedor);
                RequestDispatcher rd = request.getRequestDispatcher("fornecedores.jsp?palavra=");
                rd.forward(request, response);
            }
        }
    }
}
