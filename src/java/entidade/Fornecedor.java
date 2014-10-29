package entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="fornecedor", schema="controle_os")
public class Fornecedor implements Serializable{
    
    @Id
    @Basic(optional= false)
    @SequenceGenerator(name="seq_fornecedor", 
            sequenceName="controle_os.seq_fornecedor", 
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, 
            generator = "seq_fornecedor")
    @Column(name = "id_fornecedor")
    private Integer idFornecedor;
    
    @Column(name = "razao_nome")
    private String razao;
    
    @Column(name = "fantasia")
    private String fantasia;
    
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    
    @Column(name = "rg_ie")
    private String rgIe;
    
    @Column(name = "logradouro")
    private String logradouro;
    
    @Column(name = "numero")
    private Integer numero;
    
    @Column(name = "bairro")
    private String bairro;
    
    @Column(name = "cidade")
    private String cidade;
    
    @Column(name = "uf")
    private String uf;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "obs")
    private String obs;
    
    @OneToMany(mappedBy = "fornecedor")
    private List<Telefone> lstTelefone;
    
    @OneToMany(mappedBy = "fornecedor")
    private List<FornecedorPeca> lstFornecedorPeca;

    /**
     * @return the idFornecedor
     */
    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    /**
     * @param idFornecedor the idFornecedor to set
     */
    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    /**
     * @return the razao
     */
    public String getRazao() {
        return razao;
    }

    /**
     * @param razao the razao to set
     */
    public void setRazao(String razao) {
        this.razao = razao;
    }

    /**
     * @return the fantasia
     */
    public String getFantasia() {
        return fantasia;
    }

    /**
     * @param fantasia the fantasia to set
     */
    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    /**
     * @return the cpfCnpj
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }

    /**
     * @param cpfCnpj the cpfCnpj to set
     */
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    /**
     * @return the rgIe
     */
    public String getRgIe() {
        return rgIe;
    }

    /**
     * @param rgIe the rgIe to set
     */
    public void setRgIe(String rgIe) {
        this.rgIe = rgIe;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return the lstTelefone
     */
    public List<Telefone> getLstTelefone() {
        return lstTelefone;
    }

    /**
     * @param lstTelefone the lstTelefone to set
     */
    public void setLstTelefone(List<Telefone> lstTelefone) {
        this.lstTelefone = lstTelefone;
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

}