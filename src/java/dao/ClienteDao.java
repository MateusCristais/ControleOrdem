package dao;

import entidade.Cliente;
import entidade.Usuario;
import static java.lang.System.out;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mateus Oliveira
 */
public class ClienteDao {
       
    
    boolean resultado;
    
    public ClienteDao(){
        resultado = false;
    }
    
    public List<Cliente> getListCliente(String palavra) { 
        List<Cliente> listCliente = null;
        List<Usuario> listUsuario;
        
        UsuarioDao usuarioDao = new UsuarioDao();
        listUsuario = usuarioDao.getListUsuario(palavra);
        
        Cliente cliente = new Cliente();
        
        for(Usuario u : listUsuario){
            cliente = u.getLstCliente().get(0);
        }
        
        for(Cliente c : listCliente){
            out.println(c.getUsuario().getNome());
        }
        
        return listCliente;
    }

    public Cliente getCliente(int id) {
        Cliente cliente;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria c = s.createCriteria(Cliente.class);
        c.add(Restrictions.eq("id_cliente", id));
        
        List<Cliente> lstCliente = (List<Cliente>) c.list();

        if (lstCliente.isEmpty()) {
            cliente = null;
        } else {
            cliente = lstCliente.get(0);
        }

        s.close();
        return cliente;
    }

    public void salvaUser(Cliente cliente) {
        
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.salvaUser(cliente.getUsuario());
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.save(cliente);

        s.getTransaction().commit();
        s.close();
    }

    public void deletaUser(Cliente cliente) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.delete(cliente);

        s.getTransaction().commit();
        s.close();
    }

    public void atualizaCliente(Cliente cliente) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.update(cliente);

        s.getTransaction().commit();
        s.close();
    }
}
