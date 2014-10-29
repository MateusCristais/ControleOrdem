package entidade;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="os", schema="controle_os")
public class OS {
    @Id
    @Basic(optional= false)
    @SequenceGenerator(name="seq_os", 
            sequenceName="controle_os.seq_os", 
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, 
            generator = "seq_os")
    @Column(name = "id_os")
    private Integer idOS;
    
    @Column(name = "defeito")
    private String defeito;
    
    @Column(name = "dias_entrega")
    private Integer diasEntrega;
    
    @Column(name = "desconto")
    private Double desconto;
    
    @Column(name = "valor_total")
    private Double valorTotal;
        
    @ManyToOne
    @JoinColumn(name = "funcionario")
    private Funcionario funcionario;
    
    @OneToMany(mappedBy = "os")
    private List<OSServico> lstOsServico;
    
    @OneToMany(mappedBy = "os")
    private List<OSPeca> lstOsPeca;

    /**
     * @return the idOS
     */
    public Integer getIdOS() {
        return idOS;
    }

    /**
     * @param idOS the idOS to set
     */
    public void setIdOS(Integer idOS) {
        this.idOS = idOS;
    }

    /**
     * @return the defeito
     */
    public String getDefeito() {
        return defeito;
    }

    /**
     * @param defeito the defeito to set
     */
    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    /**
     * @return the diasEntrega
     */
    public Integer getDiasEntrega() {
        return diasEntrega;
    }

    /**
     * @param diasEntrega the diasEntrega to set
     */
    public void setDiasEntrega(Integer diasEntrega) {
        this.diasEntrega = diasEntrega;
    }

    /**
     * @return the desconto
     */
    public Double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the valorTotal
     */
    public Double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
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

    /**
     * @return the lstOsPeca
     */
    public List<OSPeca> getLstOsPeca() {
        return lstOsPeca;
    }

    /**
     * @param lstOsPeca the lstOsPeca to set
     */
    public void setLstOsPeca(List<OSPeca> lstOsPeca) {
        this.lstOsPeca = lstOsPeca;
    }

}
