package dao;

import entidade.Servico;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Mateus Oliveira
 */
public class ServicoDao {
    
    boolean resultado;
    
    public ServicoDao(){
        resultado = false;
    }
    
    public ArrayList<Servico> getListServico(String palavra) { 
        ArrayList<Servico> listServico = null;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria cNome = s.createCriteria(Servico.class);
        cNome.add(Restrictions.ilike("descricao", "%"+palavra+"%"));
        
        ArrayList<Servico> listServicoDescricao = (ArrayList<Servico>) cNome.list();
        if (!listServicoDescricao.isEmpty()) {
            listServico = listServicoDescricao;
        }else{
            Servico servico = new Servico();
            servico = null;
            try{
                servico = getServico(Integer.valueOf(palavra));
            }catch(NumberFormatException e){
                listServico = null;
            }
            
            if(servico != null)
                listServico.add(servico);
        }

        s.close();
        
        return listServico;
    }

    public Servico getServico(int id) {
        Servico servico;
        
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();
        
        Criteria c = s.createCriteria(Servico.class);
        c.add(Restrictions.eq("idservico", id));
        
        List<Servico> lstServico = (List<Servico>) c.list();

        if (lstServico.isEmpty()) {
            servico = null;
        } else {
            servico = lstServico.get(0);
        }

        s.close();
        return servico;
    }

    public void salvaservico(Servico servico) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.save(servico);

        s.getTransaction().commit();
        s.close();
    }

    public void deletaservico(Servico servico) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.delete(servico);

        s.getTransaction().commit();
        s.close();
    }

    public void atualizaUsuario(Servico servico) {
        Session s = SessionFactoryUtil.openSession(SessionFactoryUtil.openConnection());
        s.beginTransaction();

        s.update(servico);

        s.getTransaction().commit();
        s.close();
    }
}
