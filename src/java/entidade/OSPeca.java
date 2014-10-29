package entidade;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="os_peca", schema="controle_os")
public class OSPeca {
    
    @Id
    @Basic(optional= false)
    @SequenceGenerator(name="seq_os_peca", 
            sequenceName="controle_os.seq_os_peca", 
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, 
            generator = "seq_os_peca")    
    @Column(name = "id_os_peca")
    private Integer idOsPeca;
        
    @ManyToOne
    @JoinColumn(name = "os")
    private OS os;
    
    @ManyToOne
    @JoinColumn(name = "peca")
    private Peca peca;

    /**
     * @return the idOsPeca
     */
    public Integer getIdOsPeca() {
        return idOsPeca;
    }

    /**
     * @param idOsPeca the idOsPeca to set
     */
    public void setIdOsPeca(Integer idOsPeca) {
        this.idOsPeca = idOsPeca;
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

}