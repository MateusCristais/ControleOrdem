package dao;

import entidade.Peca;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mateus Oliveira
 */
public class PecaDao {
    
    boolean resultado;
    
    public PecaDao(){
        resultado = false;
    }
    
    public ArrayList<Peca> getListPeca(String palavra) { 
        ArrayList<Peca> listPeca = null;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria cNome = s.createCriteria(Peca.class);
        cNome.add(Restrictions.ilike("descricao", "%"+palavra+"%"));
        
        ArrayList<Peca> listPecaDescricao = (ArrayList<Peca>) cNome.list();
        if (!listPecaDescricao.isEmpty()) {
            listPeca = listPecaDescricao;
        }else{
            Peca peca = new Peca();
            peca = null;
            try{
                peca = getPeca(Integer.valueOf(palavra));
            }catch(NumberFormatException e){
                listPeca = null;
            }
            if(peca != null)
                listPeca.add(peca);
        }

        s.close();
        
        return listPeca;
    }

    public Peca getPeca(int id) {
        Peca peca;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria c = s.createCriteria(Peca.class);
        c.add(Restrictions.eq("idPeca", id));
        
        List<Peca> lstPeca = (List<Peca>) c.list();

        if (lstPeca.isEmpty()) {
            peca = null;
        } else {
            peca = lstPeca.get(0);
        }

        s.close();
        return peca;
    }

    public void salvaPeca(Peca peca) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.save(peca);

        s.getTransaction().commit();
        s.close();
    }

    public void deletaPeca(Peca peca) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.delete(peca);

        s.getTransaction().commit();
        s.close();
    }

    public void atualizaUsuario(Peca peca) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.update(peca);

        s.getTransaction().commit();
        s.close();
    }
}
