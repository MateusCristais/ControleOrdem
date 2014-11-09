package entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cliente", schema="controle_os")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Cliente implements Serializable{
    
    @Id
    @Basic(optional= false)
    @SequenceGenerator(name="seq_cliente", 
            sequenceName="controle_os.seq_cliente", 
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, 
            generator = "seq_cliente")
    @Column(name = "id_Cliente")
    private Integer idCliente;
    
    @Column(name = "obs")
    private String obs;
    
    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    /**
     * @return the idCliente
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the nome
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param nome the nome to set
     */
    public void setObs(String obs) {
        this.obs = obs;
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
    
}