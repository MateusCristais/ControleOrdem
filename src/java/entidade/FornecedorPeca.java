package entidade;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="fornecedor_peca", schema="controle_os")
public class FornecedorPeca {
    
    @Id
    @Basic(optional= false)
    @SequenceGenerator(name="seq_fornecedor_peca", 
            sequenceName="controle_os.seq_fornecedor_peca", 
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, 
            generator = "seq_fornecedor_peca")    
    @Column(name = "id_fornecedor_peca")
    private Integer idFornecedorPeca;
    
    @ManyToOne
    @JoinColumn(name = "peca")
    private Peca peca;
    
    @ManyToOne
    @JoinColumn(name = "fornecedor")
    private Fornecedor fornecedor;

    /**
     * @return the idFornecedorPeca
     */
    public Integer getIdFornecedorPeca() {
        return idFornecedorPeca;
    }

    /**
     * @param idFornecedorPeca the idFornecedorPeca to set
     */
    public void setIdFornecedorPeca(Integer idFornecedorPeca) {
        this.idFornecedorPeca = idFornecedorPeca;
    }

    /**
     * @return the peca
     */
    public Peca getPeca() {
        return peca;
    }

    /**
     * @param peca the peca to set
     */
    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    /**
     * @return the fornecedor
     */
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }


}