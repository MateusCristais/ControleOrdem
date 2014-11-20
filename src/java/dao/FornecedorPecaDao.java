package dao;

import entidade.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mateus Oliveira
 */
public class FornecedorPecaDao {
    
    boolean resultado;
    
    public FornecedorPecaDao(){
        resultado = false;
    }
    
    public Usuario getUsuario(int id) {
        Usuario usuario;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria c = s.createCriteria(Usuario.class);
        c.add(Restrictions.eq("idUsuario", id));
        
        List<Usuario> lstUsuario = (List<Usuario>) c.list();

        if (lstUsuario.isEmpty()) {
            usuario = null;
        } else {
            usuario = lstUsuario.get(0);
        }

        s.close();
        return usuario;
    }
    
    public Usuario getUsuarioDoc(String doc) {
        Usuario usuario = null;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria c = s.createCriteria(Usuario.class);
        c.add(Restrictions.eq("cpfCnpj", doc));
        
        List<Usuario> lstUsuario = (List<Usuario>) c.list();

        if (lstUsuario.isEmpty()) {
            usuario = null;
        } else {
            usuario = lstUsuario.get(0);
        }

        s.close();
        return usuario;
    }
        
    public Usuario getUsuarioLogin(String nomeUsuario) {
        Usuario usuario = null;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria c = s.createCriteria(Usuario.class);
        c.add(Restrictions.eq("nomeUsuario", nomeUsuario));
        
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
