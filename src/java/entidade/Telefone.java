package entidade;

import javax.persistence.*;

@Entity
@Table(name="telefone", schema="controle_os")
public class Telefone {
    
    @Id
    @Basic(optional= false)
    @SequenceGenerator(name="seq_telefone", 
            sequenceName="controle_os.seq_telefone", 
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, 
            generator = "seq_telefone")
    @Column(name = "id_telefone")
    private Integer idTelefone;
    
    @Column(name = "telefone")
    private String telefone;
    
    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "fornecedor")
    private Fornecedor fornecedor;

    /**
     * @return the id
     */
    public Integer getIdTelefone() {
        return idTelefone;
    }

    /**
     * @param id the id to set
     */
    public void setIdTelefone(Integer id) {
        this.idTelefone = id;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
