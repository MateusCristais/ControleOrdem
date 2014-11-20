package dao;

import entidade.Fornecedor;
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
public class FornecedorDao {
    
    boolean resultado;
    
    public FornecedorDao(){
        resultado = false;
    }
    
    public ArrayList<Fornecedor> getListFornecedor(String palavra) { 
        ArrayList<Fornecedor> listFornecedor;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria cNome = s.createCriteria(Fornecedor.class);
        cNome.add(Restrictions.ilike("razao", "%"+palavra+"%"));
        
        ArrayList<Fornecedor> listFornecedorNome = (ArrayList<Fornecedor>) cNome.list();
        if (listFornecedorNome.isEmpty()) {
            
            listFornecedor = null;
            
            Criteria cDoc = s.createCriteria(Fornecedor.class);
            cDoc.add(Restrictions.ilike("cpfCnpj", "%"+palavra+"%"));

            ArrayList<Fornecedor> listFornecedorDoc = (ArrayList<Fornecedor>) cDoc.list();
            if (listFornecedorDoc.isEmpty()){
                listFornecedor = null;
            } else {
                listFornecedor = listFornecedorDoc;
            }
            
        } else {
            listFornecedor = listFornecedorNome;
        }

        s.close();
        
        return listFornecedor;
    }

    public Fornecedor getFornecedor(int id) {
        Fornecedor fornecedor;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria c = s.createCriteria(Fornecedor.class);
        c.add(Restrictions.eq("idFornecedor", id));
        
        List<Fornecedor> lstFornecedor = (List<Fornecedor>) c.list();

        if (lstFornecedor.isEmpty()) {
            fornecedor = null;
        } else {
            fornecedor = lstFornecedor.get(0);
        }

        s.close();
        return fornecedor;
    }
    
    public Fornecedor getFornecedorDoc(String doc) {
        Fornecedor fornecedor = null;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria c = s.createCriteria(Fornecedor.class);
        c.add(Restrictions.eq("cpfCnpj", doc));
        
        List<Fornecedor> lstFornecedor = (List<Fornecedor>) c.list();

        if (lstFornecedor.isEmpty()) {
            fornecedor = null;
        } else {
            fornecedor = lstFornecedor.get(0);
        }

        s.close();
        return fornecedor;
    }

    public void salvaFornecedor(Fornecedor fornecedor) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.save(fornecedor);

        s.getTransaction().commit();
        s.close();
    }

    public void deletaFornecedor(Fornecedor fornecedor) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.delete(fornecedor);

        s.getTransaction().commit();
        s.close();
    }

    public void atualizaFornecedor(Fornecedor fornecedor) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.update(fornecedor);

        s.getTransaction().commit();
        s.close();
    }
}
