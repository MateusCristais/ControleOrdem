package dao;

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
public class UsuarioDao {
    
    boolean resultado;
    
    public UsuarioDao(){
        resultado = false;
    }
    
    public List<Usuario> getListUsuario(String palavra) { 
        List<Usuario> listUsuario;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria cNome = s.createCriteria(Usuario.class);
        cNome.add(Restrictions.eq("nome", palavra));
        
        List<Usuario> listUsuarioNome = (List<Usuario>) cNome.list();
        if (listUsuarioNome.isEmpty()) {
            
            listUsuario = null;
            
            Criteria cDoc = s.createCriteria(Usuario.class);
            cDoc.add(Restrictions.eq("cpfCnpj", palavra));

            List<Usuario> listUsuarioDoc = (List<Usuario>) cDoc.list();
            if (listUsuarioDoc.isEmpty()){
                listUsuario = null;
            } else {
                listUsuario = listUsuarioDoc;
            }
            
        } else {
            listUsuario = listUsuarioNome;
        }

        s.close();
        
        for(Usuario u : listUsuario){
            out.println(u.getNome());
        }
        
        return listUsuario;
    }

    public Usuario getUsuario(int id) {
        Usuario usuario;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria c = s.createCriteria(Usuario.class);
        c.add(Restrictions.eq("id_usuario", id));
        
        List<Usuario> lstUsuario = (List<Usuario>) c.list();

        if (lstUsuario.isEmpty()) {
            usuario = null;
        } else {
            usuario = lstUsuario.get(0);
        }

        s.close();
        return usuario;
    }

    public void salvaUser(Usuario usuario) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.save(usuario);

        s.getTransaction().commit();
        s.close();
    }

    public void deletaUser(Usuario usuario) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.delete(usuario);

        s.getTransaction().commit();
        s.close();
    }

    public void atualizaUsuario(Usuario usuario) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.update(usuario);

        s.getTransaction().commit();
        s.close();
    }
}
