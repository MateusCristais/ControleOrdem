package dao;

import entidade.Funcionario;
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
public class FuncionarioDao {
    
    boolean resultado;
    
    public FuncionarioDao(){
        resultado = false;
    }

    public ArrayList<Usuario> getListFuncionario(String palavra) { 
        ArrayList<Usuario> listUsuario;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria cNome = s.createCriteria(Usuario.class);
        cNome.add(Restrictions.ilike("nome", "%"+palavra+"%"));
        cNome.add(Restrictions.isNotNull("funcionario"));
        
        ArrayList<Usuario> listUsuarioNome = (ArrayList<Usuario>) cNome.list();
        if (listUsuarioNome.isEmpty()) {
            
            listUsuario = null;
            
            Criteria cDoc = s.createCriteria(Usuario.class);
            cDoc.add(Restrictions.ilike("cpfCnpj", "%"+palavra+"%"));
            cDoc.add(Restrictions.isNotNull("funcionario"));

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
    
    public Funcionario getFuncionario(int id) {
        Funcionario funcionario;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria c = s.createCriteria(Funcionario.class);
        c.add(Restrictions.eq("idFuncionario", id));
        
        List<Funcionario> lstFuncionario = (List<Funcionario>) c.list();

        if (lstFuncionario.isEmpty()) {
            funcionario = null;
        } else {
            funcionario = lstFuncionario.get(0);
        }

        s.close();
        return funcionario;
    }

    public void salvaFuncionario(Funcionario funcionario) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.save(funcionario);

        s.getTransaction().commit();
        s.close();
    }

    public void deletaFuncionario(Funcionario funcionario) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.delete(funcionario);

        s.getTransaction().commit();
        s.close();
    }

    public void atualizaFuncionario(Funcionario funcionario) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.update(funcionario);

        s.getTransaction().commit();
        s.close();
    }
    
}
