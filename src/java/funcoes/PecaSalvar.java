package funcoes;

import dao.UsuarioDao;
import entidade.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Mateus
 */
@WebServlet(urlPatterns = {"/PecaSalvar"})
public class PecaSalvar extends HttpServlet {

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
        
        //VERIFICA SENHAS
        if(!request.getParameter("senha").equals(request.getParameter("senha2"))){
            request.setAttribute("mensagem", "Senhas são diferentes, verifique!");
            RequestDispatcher rd = request.getRequestDispatcher("clientesNovo.jsp");
            rd.forward(request, response);
        }else{
            //PREENCHO O USUÁRIO
            Usuario usuario = new Usuario();
            if(request.getParameter("codigo") != null){
                if(!request.getParameter("codigo").equalsIgnoreCase("")){
                    usuario.setIdUsuario(Integer.parseInt(request.getParameter("codigo")));
                }else{
                    usuario.setIdUsuario(null);
                }
            }
            usuario.setBairro(request.getParameter("bairro"));
            usuario.setCidade(request.getParameter("cidade"));
            usuario.setCpfCnpj(request.getParameter("cpf"));
            usuario.setRgIe(request.getParameter("rg"));
            usuario.setEmail(request.getParameter("email"));
            usuario.setLogradouro(request.getParameter("endereco"));
            usuario.setNome(request.getParameter("nomeCompleto"));
            usuario.setNomeUsuario(request.getParameter("nomeUsuario"));
            usuario.setRgIe(request.getParameter("rg"));
            usuario.setNumero(Integer.parseInt(request.getParameter("numero")));
            usuario.setSenha(request.getParameter("senha"));
            usuario.setUf(request.getParameter("uf"));
            usuario.setTelefone(request.getParameter("telefone"));
            usuario.setCelular(request.getParameter("celular"));
            usuario.setCep(request.getParameter("cep"));
            usuario.setObs(request.getParameter("obs"));
            
            Usuario usuarioBusca = new Usuario();
            UsuarioDao usuarioDao = new UsuarioDao();
            
            //VERIFICA TIPO: 
            //2 - ATUALIZAÇÃO 
            int tipo = 0;
            if(request.getParameter("tipo") != null){
                tipo = Integer.parseInt(request.getParameter("tipo"));
            }
            if(tipo == 2){
                usuarioDao = new UsuarioDao();
                usuarioDao.atualizaUsuario(usuario);
                response.sendRedirect("clientes.jsp?palavra=");
                
            //1 - INCLUSÃO    
            }else{
                //VERIFICA USUÁRIO LOGIN
                usuarioBusca = usuarioDao.getUsuarioLogin(usuario.getNomeUsuario());
                if(usuarioBusca != null){
                    request.setAttribute("mensagem", "Nome de usuário já existente!");
                    RequestDispatcher rd = request.getRequestDispatcher("clientesNovo.jsp");
                    rd.forward(request, response);
                }else{
                    //VERIFICA USUÁRIO DOCUMENTO
                    usuarioDao = new UsuarioDao();
                    usuarioBusca = usuarioDao.getUsuarioDoc(usuario.getCpfCnpj());
                    if(usuarioBusca != null){
                        request.setAttribute("mensagem", " Número de documento já existente!");
                        RequestDispatcher rd = request.getRequestDispatcher("clientesNovo.jsp");
                        rd.forward(request, response);
                    }else{
                        //SALVA USUÁRIO
                        usuarioDao.salvaUser(usuario);
                        RequestDispatcher rd = request.getRequestDispatcher("clientes.jsp?palavra=");
                        rd.forward(request, response);
                    }
                }
            }
        }
    }
}
