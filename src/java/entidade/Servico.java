package entidade;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="servico", schema="controle_os")
public class Servico {
    @Id
    @Basic(optional= false)
    @SequenceGenerator(name="seq_servico", 
            sequenceName="controle_os.seq_servico", 
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, 
            generator = "seq_servico")
    @Column(name = "id_servico")
    private Integer idServico;
    
    @Column(name = "descricao")
    private String descricao;
        
    @Column(name = "preco_suj")
    private Double precoSujerido;
    
    @Column(name = "ficha_tec")
    private String fichaTec;
        
    @OneToMany(mappedBy = "servico")
    private List<OSServico> lstOsServico;

    /**
     * @return the idServico
     */
    public Integer getIdServico() {
        return idServico;
    }

    /**
     * @param idServico the idServico to set
     */
    public void setIdServico(Integer idServico) {
        this.idServico = idServico;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the precoSujerido
     */
    public Double getPrecoSujerido() {
        return precoSujerido;
    }

    /**
     * @param precoSujerido the precoSujerido to set
     */
    public void setPrecoSujerido(Double precoSujerido) {
        this.precoSujerido = precoSujerido;
    }

    /**
     * @return the fichaTec
     */
    public String getFichaTec() {
        return fichaTec;
    }

    /**
     * @param fichaTec the fichaTec to set
     */
    public void setFichaTec(String fichaTec) {
        this.fichaTec = fichaTec;
    }

    /**
     * @return the lstOsServico
     */
    public List<OSServico> getLstOsServico() {
        return lstOsServico;
    }

    /**
     * @param lstOsServico the lstOsServico to set
     */
    public void setLstOsServico(List<OSServico> lstOsServico) {
        this.lstOsServico = lstOsServico;
    }

}
