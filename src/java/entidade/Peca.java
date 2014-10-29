package entidade;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "peca", schema = "controle_os")
public class Peca {

    @Id
    @Basic(optional = false)
    @SequenceGenerator(name = "seq_peca",
            sequenceName = "controle_os.seq_peca",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "seq_peca")
    @Column(name = "id_peca")
    private Integer idPeca;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "referencia")
    private String referencia;

    @Column(name = "preco")
    private Double preco;

    @Column(name = "saldo")
    private Integer saldo;

    @Column(name = "ficha_tec")
    private String fichaTec;

    @OneToMany(mappedBy = "peca")
    private List<OSPeca> lstOsPeca;

    @OneToMany(mappedBy = "peca")
    private List<FornecedorPeca> lstFornecedorPeca;

    /**
     * @return the idPeca
     */
    public Integer getIdPeca() {
        return idPeca;
    }

    /**
     * @param idPeca the idPeca to set
     */
    public void setIdPeca(Integer idPeca) {
        this.idPeca = idPeca;
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
     * @return the referencia
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * @param referencia the referencia to set
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * @return the saldo
     */
    public Integer getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
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
     * @return the lstFornecedorPeca
     */
    public List<FornecedorPeca> getLstFornecedorPeca() {
        return lstFornecedorPeca;
    }

    /**
     * @param lstFornecedorPeca the lstFornecedorPeca to set
     */
    public void setLstFornecedorPeca(List<FornecedorPeca> lstFornecedorPeca) {
        this.lstFornecedorPeca = lstFornecedorPeca;
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
