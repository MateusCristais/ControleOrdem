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
public class OSDao {
    
    boolean resultado;
    
    public OSDao(){
        resultado = false;
    }
    
    public ArrayList<Usuario> getListUsuario(String palavra) { 
        ArrayList<Usuario> listUsuario;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria cNome = s.createCriteria(Usuario.class);
        cNome.add(Restrictions.ilike("nome", "%"+palavra+"%"));
        
        ArrayList<Usuario> listUsuarioNome = (ArrayList<Usuario>) cNome.list();
        if (listUsuarioNome.isEmpty()) {
            
            listUsuario = null;
            
            Criteria cDoc = s.createCriteria(Usuario.class);
            cDoc.add(Restrictions.ilike("cpfCnpj", "%"+palavra+"%"));

            ArrayList<Usuario> listUsuarioDoc = (ArrayList<Usuario>) cDoc.list();
            if (listUsuarioDoc.isEmpty()){
                listUsuario = null;
            } else {
                listUsuario = listUsuarioDoc;
            }
            
        } else {
            listUsuario = listUsuarioNome;
        }

        s.close();
        
        return listUsuario;
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
