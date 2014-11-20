package entidade;

import dao.SessionFactoryUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class Funcoes {

    private String usuario;
    private String senha;

    public Funcoes() {
    }

    public boolean resultado = false;

    public boolean verificaLogin(String usuario, String senha) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        Criteria c = s.createCriteria(Usuario.class);
        c.add(Restrictions.eq("nomeUsuario", usuario));
        //  c.add(Restrictions.eq("senha", sencrip));
        c.add(Restrictions.eq("senha", senha));
        List<Usuario> lstUsuario = (List<Usuario>) c.list();

        if (lstUsuario.isEmpty()) {
            resultado = false;
        } else {
            resultado = true;
            dadosLogin(usuario, senha);
        }

        s.close();
        return resultado;
    }

    public String dadosLogin(String usuario, String senha) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        String nome = "";

        Criteria c = s.createCriteria(Usuario.class);
        c.add(Restrictions.eq("nomeUsuario", usuario));
        c.add(Restrictions.eq("senha", senha));
        List<Usuario> lstUsuario = (List<Usuario>) c.list();

        if (lstUsuario.isEmpty()) {
            nome = null;
        } else {
            nome = lstUsuario.get(0).getNome();
        }

        s.close();
        return nome;
    }

    public void gravaUser(Usuario usuario) {
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

    public void salvaUser(Usuario usuario) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.update(usuario);

        s.getTransaction().commit();
        s.close();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
