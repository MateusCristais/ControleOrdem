package entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="usuario", schema="controle_os")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable{
    
    @Id
    @Basic(optional= false)
    @SequenceGenerator(name="seq_usuario", 
            sequenceName="controle_os.seq_usuario", 
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, 
            generator = "seq_usuario")    
    @Column(name = "id_usuario")
    private Integer idUsuario;
    
    @Column(name = "nome")
    private String nome;
    
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
        
    @OneToMany(mappedBy = "usuario")
    private List<Telefone> lstTelefone;

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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
    
    
}
