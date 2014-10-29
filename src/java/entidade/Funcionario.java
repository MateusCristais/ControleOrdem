package entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="funcionario", schema="controle_os")
@PrimaryKeyJoinColumn(name = "idUsuario")
public class Funcionario implements Serializable{
    
    @Id
    @Basic(optional= false)
    @SequenceGenerator(name="seq_funcionario", 
            sequenceName="controle_os.seq_funcionario", 
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, 
            generator = "seq_funcionario")
    @Column(name = "id_funcionario")
    private Integer idFuncionario;
    
    @Column(name = "salario")
    private Double salario;
    
    @Column(name = "perfil")
    private String perfil;

    /**
     * @return the idFuncionario
     */
    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    /**
     * @param idFuncionario the idFuncionario to set
     */
    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    /**
     * @return the salario
     */
    public Double getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Double salario) {
        this.salario = salario;
    }

    /**
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }


    
}