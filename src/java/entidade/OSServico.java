package entidade;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="os_servico", schema="controle_os")
public class OSServico {
    
    @Id
    @Basic(optional= false)
    @SequenceGenerator(name="seq_os_servico", 
            sequenceName="controle_os.seq_os_servico", 
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, 
            generator = "seq_os_servico")    
    @Column(name = "id_os_servico")
    private Integer idOsServico;
        
    @ManyToOne
    @JoinColumn(name = "os")
    private OS os;
    
    @ManyToOne
    @JoinColumn(name = "servico")
    private Servico servico;

    /**
     * @return the idOsServico
     */
    public Integer getIdOsServico() {
        return idOsServico;
    }

    /**
     * @param idOsServico the idOsServico to set
     */
    public void setIdOsServico(Integer idOsServico) {
        this.idOsServico = idOsServico;
    }

    /**
     * @return the osServico
     */
    public OS getOs() {
        return os;
    }

    /**
     * @param osServico the osServico to set
     */
    public void setOs(OS os) {
        this.os = os;
    }

    /**
     * @return the servico
     */
    public Servico getServico() {
        return servico;
    }

    /**
     * @param servico the servico to set
     */
    public void setServico(Servico servico) {
        this.servico = servico;
    }

}